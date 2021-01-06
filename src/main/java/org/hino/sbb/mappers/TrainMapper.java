package org.hino.sbb.mappers;

import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.Train;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class TrainMapper implements InterfaceMapper<TrainDTO, Train> {

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
        return new TrainDTO(
                entity.getId(),
                entity.getName(),
                entity.getNumber()
        );
    }

    @Override
    public List<TrainDTO> toDto(Collection<Train> collection) {
        List resultCollection  = new LinkedList();
        for (Train entity: collection) {
            TrainDTO resultDTO = new TrainDTO(
                    entity.getId(),
                    entity.getName(),
                    entity.getNumber()
            );
            resultCollection.add(resultDTO);
        }
        return resultCollection;
    }
}
