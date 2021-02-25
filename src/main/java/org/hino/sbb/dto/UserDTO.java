package org.hino.sbb.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO extends AbstractDTO{

    @NotBlank(message="Username should not be blank")
    private String username;

    @NotBlank(message="Password should not be blank")
    private String password;

    private String role;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
