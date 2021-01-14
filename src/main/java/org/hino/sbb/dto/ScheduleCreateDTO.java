package org.hino.sbb.dto;


import java.time.LocalDateTime;

public class ScheduleCreateDTO extends AbstractDTO {

    private long trainId;

    private long stationOrder;

    private long stationId;

    private String arrivalTime;

    private String departureTime;

    public ScheduleCreateDTO() {
    }

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public long getStationOrder() {
        return stationOrder;
    }

    public void setStationOrder(long stationOrder) {
        this.stationOrder = stationOrder;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
