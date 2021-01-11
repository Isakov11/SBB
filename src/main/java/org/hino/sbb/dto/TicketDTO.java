package org.hino.sbb.dto;

import org.hino.sbb.model.Passenger;
import org.hino.sbb.model.Train;

import javax.persistence.*;
import java.time.LocalDateTime;

public class TicketDTO extends AbstractDTO {

    private LocalDateTime purchaseTime;

    private TrainDTO ticketTrain;

    private PassengerDTO passenger;

    public TicketDTO() {
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public TrainDTO getTicketTrain() {
        return ticketTrain;
    }

    public void setTicketTrain(TrainDTO ticketTrain) {
        this.ticketTrain = ticketTrain;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }
}
