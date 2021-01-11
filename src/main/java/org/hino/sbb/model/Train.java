package org.hino.sbb.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trains")
@NamedQueries({
        @NamedQuery(name = "Train.findAll", query = "SELECT t FROM Train t")
})

public class Train extends AbstractEntity{
    public static final String FIND_ALL = "Train.findAll";

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "seats_number")
    private long seatsNumber;

    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ScheduleNode> trainSchedule;

    @OneToMany(mappedBy = "ticketTrain", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Ticket> tickets;

    public Train() {
    }

    public Train(long id, String name, String number) {
        super.setId(id);
        this.name = name;
        this.number = number;
    }

    public Set<ScheduleNode> getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(Set<ScheduleNode> trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(long seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
