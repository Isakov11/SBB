package org.hino.sbb.mappers;

import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.dto.StationScheduleDTO;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface StationMapper {

    @Mapping(source = "id", target = "id")
    Station toEntity (StationDTO dto);
    @Mapping(source = "stationSchedule", target = "stationScheduleTable")
    StationDTO toDto (Station entity);
    List<StationDTO> toDto (Collection<Station> entity);

    default LinkedList<StationScheduleDTO> nodeEntitiesToStationScheduleTable(List<ScheduleNode> stationSchedule){
        LinkedList<StationScheduleDTO> nodes = new LinkedList<>();
        for(ScheduleNode nodeEntity: stationSchedule){
            StationScheduleDTO stationScheduleDTO = new StationScheduleDTO();
            stationScheduleDTO.setTrainNumber(nodeEntity.getTrain().getNumber());
            LocalDateTime min = LocalDateTime.of(1753,02,01,0,0);
            LocalDateTime max = LocalDateTime.of(9998,12,31,0,0);
            LocalDateTime arrival =nodeEntity.getArrivalTime();
            LocalDateTime departure =nodeEntity.getDepartureTime();
            if (arrival.isBefore(min)){
                stationScheduleDTO.setArrivalTime(" --:-- ");
            }else{
                stationScheduleDTO.setArrivalTime(arrival.toLocalTime().toString());
            }
            if (departure.isAfter(max)){
                stationScheduleDTO.setDepartureTime(" --:-- ");
            }else{
                stationScheduleDTO.setDepartureTime(departure.toLocalTime().toString());
            }
            nodes.add(stationScheduleDTO);
        }
        return nodes;
    }

}
