package org.hino.sbb.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TicketCreateDTO extends AbstractDTO {

    private long PassengerId;

    private long TrainId;

    private LocalDateTime purchaseTime;

    public TicketCreateDTO() {
    }

    public long getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(long passengerId) {
        PassengerId = passengerId;
    }

    public long getTrainId() {
        return TrainId;
    }

    public void setTrainId(long trainId) {
        TrainId = trainId;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
