package org.hino.sbb.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
})
public class Role extends AbstractEntity  implements GrantedAuthority{
    public static final String FIND_ALL = "Role.findAll";

    @Column(name = "name", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
