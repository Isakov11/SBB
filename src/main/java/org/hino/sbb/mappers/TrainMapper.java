package org.hino.sbb.mappers;

import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.dto.TrainScheduleDTO;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Train;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.*;


@Mapper(componentModel = "spring")
public interface TrainMapper {

    @Mapping(source = "trainRoute", target = "trainSchedule")
    Train toEntity (TrainDTO dto);

    @Mapping(source = "trainSchedule", target = "trainRoute")
    TrainDTO toDto (Train entity);

    List<TrainDTO> toDto (Collection<Train> entity);

    default LinkedList<TrainScheduleDTO> scheduleEntityToTrainSchedule(List<ScheduleNode> trainSchedule){
        LinkedList<TrainScheduleDTO> result = new LinkedList<>();
        for(ScheduleNode scheduleNode: trainSchedule){
            TrainScheduleDTO trainScheduleDTO = new TrainScheduleDTO();
            trainScheduleDTO.setStationName(scheduleNode.getStation().getName());
            LocalDateTime min = LocalDateTime.of(1753,02,01,0,0);
            LocalDateTime max = LocalDateTime.of(9998,12,31,0,0);
            LocalDateTime arrival = scheduleNode.getArrivalTime();
            LocalDateTime departure = scheduleNode.getDepartureTime();
            if (arrival.isBefore(min)){
                trainScheduleDTO.setArrivalTime(" --:-- ");
            }else{
                trainScheduleDTO.setArrivalTime(arrival.toLocalTime().toString());
            }
            if (departure.isAfter(max)){
                trainScheduleDTO.setDepartureTime(" --:-- ");
            }else{
                trainScheduleDTO.setDepartureTime(departure.toLocalTime().toString());
            }
            result.add(trainScheduleDTO);
        }
        return result;
    }
}
