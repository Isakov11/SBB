package org.hino.sbb.mappers;

import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ScheduleNodeMapper implements InterfaceMapper<ScheduleNodeDTO, ScheduleNode> {

    public ScheduleNode toEntity(ScheduleNodeDTO dto)  {
        TrainDTO trainDTO =  dto.getTrain();
        Train train = new Train(
                trainDTO.getId(),
                trainDTO.getName(),
                trainDTO.getNumber()
        );

        StationDTO stationDTO =  dto.getStation();
        Station station = new Station(
                stationDTO.getId(),
                stationDTO.getRoadId(),
                stationDTO.getName()
        );

        return new ScheduleNode(
                dto.getId(),
                train,
                dto.getStationOrder(),
                station,
                dto.getArrivalTime(),
                dto.getDepartureTime()
        );
    }

    public ScheduleNodeDTO toDto(ScheduleNode entity) {

        Train train = entity.getTrain();
        TrainDTO trainDTO =  new TrainDTO(
                train.getId(),
                train.getName(),
                train.getNumber()
        );

        Station station = entity.getStation();
        StationDTO StationDTO = new StationDTO(
                station.getId(),
                station.getRoadId(),
                station.getName()
        );

        return new ScheduleNodeDTO(
                entity.getId(),
                trainDTO,
                entity.getStationOrder(),
                StationDTO,
                entity.getArrivalTime(),
                entity.getDepartureTime()
            );
        }

    public Set<ScheduleNodeDTO> toDto(Collection<ScheduleNode> collection) {
        Set resultCollection = new HashSet();
        for (ScheduleNode entity: collection) {
            Train train = entity.getTrain();
            TrainDTO trainDTO =  new TrainDTO(
                    train.getId(),
                    train.getName(),
                    train.getNumber()
            );

            Station station = entity.getStation();
            StationDTO StationDTO = new StationDTO(
                    station.getId(),
                    station.getRoadId(),
                    station.getName()
            );

            ScheduleNodeDTO resultDTO = new ScheduleNodeDTO(
                    entity.getId(),
                    trainDTO,
                    entity.getStationOrder(),
                    StationDTO,
                    entity.getArrivalTime(),
                    entity.getDepartureTime()
            );
            resultCollection.add(resultDTO);
        }
        return resultCollection;
    }
}
