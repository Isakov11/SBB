package org.hino.sbb.mappers;

import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.model.ScheduleNode;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ScheduleNodeMapper {

    ScheduleNode    toEntity (ScheduleNodeDTO dto);
    ScheduleNodeDTO toDto (ScheduleNode entity);
    Set<ScheduleNodeDTO> toDto (Collection<ScheduleNode> entity);
}