package org.hino.sbb.mappers;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.model.Passenger;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class PassengerMapper {

        public Passenger toEntity(PassengerDTO dto) {
            return new Passenger(
                    dto.getId(),
                    dto.getDeleted(),
                    dto.getVersion(),
                    dto.getName(),
                    dto.getSecondName(),
                    dto.getBirthDate()
                    );
        }

        public PassengerDTO toDto(Passenger entity) {
            return new PassengerDTO(
                    entity.getId(),
                    entity.getDeleted(),
                    entity.getVersion(),
                    entity.getName(),
                    entity.getSecondName(),
                    entity.getBirthDate()
            );
        }
        public List<PassengerDTO> toDto(Collection<Passenger> collection) {
            List resultCollection  = new LinkedList();
            for (Passenger entity: collection) {
                PassengerDTO resultDTO = new PassengerDTO(
                        entity.getId(),
                        entity.getDeleted(),
                        entity.getVersion(),
                        entity.getName(),
                        entity.getSecondName(),
                        entity.getBirthDate()
                );
                resultCollection.add(resultDTO);
            }
            return resultCollection;
        }
}
