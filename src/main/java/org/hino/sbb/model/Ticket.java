package org.hino.sbb.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tickets")
public class Ticket extends AbstractEntity {

    @Column(name = "purchase_time")
    private LocalDateTime purchaseTime;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_id")
    private Train ticketTrain;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Train getTicketTrain() {
        return ticketTrain;
    }

    public void setTicketTrain(Train ticketTrain) {
        this.ticketTrain = ticketTrain;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
