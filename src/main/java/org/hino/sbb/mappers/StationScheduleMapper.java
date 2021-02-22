package org.hino.sbb.mappers;

import org.hino.sbb.dto.StationScheduleDTO;
import org.hino.sbb.model.ScheduleNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.Collection;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface StationScheduleMapper {

    @Mapping(source = "entity.train.number", target = "trainNumber")
    StationScheduleDTO toDto    (ScheduleNode entity);
    Set<StationScheduleDTO> toDto (Collection<ScheduleNode> entity);
}