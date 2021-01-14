package org.hino.sbb.dto;

import org.hino.sbb.model.Ticket;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class PassengerDTO extends AbstractDTO {

    private String name;

    private String secondName;

    private String birthDate;

    /*private Set<PassengerTicketDTO> tickets;*/

    public PassengerDTO() {
    }

    public PassengerDTO(long id, String name, String secondName, String birthDate) {
        super.setId(id);
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /*public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }*/

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
