package org.hino.sbb.mappers;

import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.dto.TrainScheduleDTO;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Train;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
            trainScheduleDTO.setArrivalTime(scheduleNode.getArrivalTime());
            trainScheduleDTO.setDepartureTime(scheduleNode.getDepartureTime());
            result.add(trainScheduleDTO);
        }
        return result;
    }
}
