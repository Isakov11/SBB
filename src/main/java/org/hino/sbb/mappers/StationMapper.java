package org.hino.sbb.mappers;

import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.dto.StationScheduleDTO;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface StationMapper {

    Station toEntity (StationDTO dto);
    @Mapping(source = "stationSchedule", target = "stationScheduleTable")
    StationDTO toDto (Station entity);
    List<StationDTO> toDto (Collection<Station> entity);

    default LinkedList<StationScheduleDTO> nodeEntitiesToStationScheduleTable(List<ScheduleNode> stationSchedule){
        LinkedList<StationScheduleDTO> nodes = new LinkedList<>();
        for(ScheduleNode nodeEntity: stationSchedule){
            StationScheduleDTO stationScheduleDTO = new StationScheduleDTO();
            stationScheduleDTO.setTrainNumber(nodeEntity.getTrain().getNumber());
            stationScheduleDTO.setArrivalTime(nodeEntity.getArrivalTime());
            stationScheduleDTO.setDepartureTime(nodeEntity.getDepartureTime());
            nodes.add(stationScheduleDTO);
        }
        return nodes;
    }

}
