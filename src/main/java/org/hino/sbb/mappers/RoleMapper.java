package org.hino.sbb.mappers;

import org.hino.sbb.dto.RoleDTO;
import org.hino.sbb.model.Role;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity (RoleDTO dto);

    RoleDTO toDto (Role entity);

    List<RoleDTO> toDto (Collection<Role> entity);

}
