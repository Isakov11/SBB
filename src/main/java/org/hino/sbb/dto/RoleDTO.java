package org.hino.sbb.dto;

import org.hino.sbb.model.AbstractEntity;
import org.hino.sbb.model.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


public class RoleDTO extends AbstractDTO  {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
