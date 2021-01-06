package org.hino.sbb.dto;

import java.time.LocalDate;
import java.util.Objects;


public class PassengerDTO {

    private Long id;

    private Boolean deleted;

    private Integer version;

    private String name;

    private String secondName;

    private LocalDate birthDate;

    public PassengerDTO() {
    }

    public PassengerDTO(Long id, Boolean deleted, Integer version, String name, String secondName, LocalDate birthDate) {
        this.id = id;
        this.deleted = deleted;
        this.version = version;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerDTO passenger = (PassengerDTO) o;
        return Objects.equals(getId(), passenger.getId()) && Objects.equals(getVersion(), passenger.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion());
    }

    @Override
    public String toString() {
        return name + " " + secondName + " " + birthDate;
    }
}
