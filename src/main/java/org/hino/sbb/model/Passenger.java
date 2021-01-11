package org.hino.sbb.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "passengers")
@NamedQueries({
        @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
})
public class Passenger extends AbstractEntity {
    public static final String FIND_ALL = "Passenger.findAll";

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "passenger",fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<Ticket> tickets;

    public Passenger() {
    }

    public Passenger(long id, String name, String secondName, LocalDate birthDate) {
        super.setId(id);
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return name + " " + secondName + " " + birthDate;
    }
}
