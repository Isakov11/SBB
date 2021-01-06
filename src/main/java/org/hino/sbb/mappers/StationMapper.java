package org.hino.sbb.mappers;

import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class StationMapper implements InterfaceMapper<StationDTO, Station> {
    @Autowired
    ScheduleNodeMapper scheduleNodeMapper;

    public Station toEntity(StationDTO dto)  {
        return new Station(
                dto.getId(),
                dto.getRoadId(),
                dto.getName()
        );
    }

    public StationDTO toDto(Station entity) {
        return new StationDTO(
                entity.getId(),
                entity.getRoadId(),
                entity.getName(),
                scheduleNodeMapper.toDto(entity.getStationSchedule())
        );
    }

    public List<StationDTO> toDto(Collection<Station> collection) {
        List resultCollection  = new LinkedList();
        for (Station entity: collection) {
            StationDTO resultDTO = new StationDTO(
                    entity.getId(),
                    entity.getRoadId(),
                    entity.getName(),
                    scheduleNodeMapper.toDto(entity.getStationSchedule())
            );
            resultCollection.add(resultDTO);
        }
        return resultCollection;
    }
}
