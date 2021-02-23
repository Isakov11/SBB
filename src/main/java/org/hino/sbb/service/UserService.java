package org.hino.sbb.service;

import org.hino.sbb.dao.RoleDAO;
import org.hino.sbb.dao.UserDAO;
import org.hino.sbb.dto.UserDTO;
import org.hino.sbb.mappers.UserMapper;
import org.hino.sbb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserService{

    private UserDAO dao;

    private RoleDAO roleDao;

    private UserMapper mapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService() {}

    @Autowired
    public UserService(UserDAO dao, RoleDAO roleDao, UserMapper mapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dao = dao;
        this.roleDao = roleDao;
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional (readOnly = true)
    public List<User> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public List<UserDTO> findAllDTO() {
        List<UserDTO> dtoList = mapper.toDto(dao.findAll());
        return dtoList;
    }

    @Transactional (readOnly = true)
    public User findById(long id) {
        return dao.findById(id);
    }

    @Transactional (readOnly = true)
    public User findByUsername(String username) {
        return dao.findByName(username);
    }

    @Transactional (readOnly = true)
    public UserDTO findDTOById(long id) {
        return mapper.toDto(findById(id));
    }

    public User create(User entity) {
        entity.setRoles(Collections.singleton(roleDao.findByName("ADMIN") ));
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

        return dao.create(entity);
    }

    public UserDTO create(UserDTO dto) {
        User entity = mapper.toEntity(dto);
        return mapper.toDto(create(entity));
    }

    public User update(User entity) {
        return dao.update(entity);
    }

    public UserDTO update(UserDTO dto) {
        User entity = mapper.toEntity(dto);
        return mapper.toDto(update(entity));
    }

    public User delete(long id) {
        User entity = dao.findById(id);
        entity.setRoles(null);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}
