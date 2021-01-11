package org.hino.sbb.dto;

import org.hino.sbb.model.Ticket;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class PassengerDTO extends AbstractDTO {

    private Long id;


    private String name;

    private String secondName;

    private LocalDate birthDate;

    private Set<Ticket> tickets;

    public PassengerDTO() {
    }

    public PassengerDTO(Long id, String name, String secondName, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
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
        return Objects.equals(getId(), passenger.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return name + " " + secondName + " " + birthDate;
    }
}
