package org.hino.sbb.mappers;

import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TrainMapper implements InterfaceMapper<TrainDTO, Train> {
    //TODO TrainMapper
    @Autowired
    ScheduleNodeMapper scheduleNodeMapper;

    @Override
    public Train toEntity(TrainDTO dto) {
        return new Train(
                dto.getId(),
                dto.getName(),
                dto.getNumber()
        );
    }

    @Override
    public TrainDTO toDto(Train entity) {
        //TODO Убрать
        Set<ScheduleNodeDTO> schedule = new HashSet<>();
        if (entity.getTrainSchedule() != null){
            schedule = scheduleNodeMapper.toDto(entity.getTrainSchedule());
        }else{
            schedule= new HashSet<>();
        }

        return new TrainDTO(
                entity.getId(),
                entity.getName(),
                entity.getNumber(),
                schedule
        );
    }

    @Override
    public List<TrainDTO> toDto(Collection<Train> collection) {
        List resultCollection  = new LinkedList();
        for (Train entity: collection) {
            //TODO Убрать
            Set<ScheduleNodeDTO> schedule = new HashSet<>();
            if (entity.getTrainSchedule() != null){
                schedule = scheduleNodeMapper.toDto(entity.getTrainSchedule());
            }
            TrainDTO resultDTO = new TrainDTO(
                    entity.getId(),
                    entity.getName(),
                    entity.getNumber(),
                    schedule
            );
            resultCollection.add(resultDTO);
        }
        return resultCollection;
    }
}
