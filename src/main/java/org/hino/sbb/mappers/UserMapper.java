package org.hino.sbb.mappers;

import org.hino.sbb.dto.UserDTO;
import org.hino.sbb.model.User;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity (UserDTO dto);

    UserDTO toDto (User entity);

    List<UserDTO> toDto (Collection<User> entity);

}
