package org.hino.sbb.dto;

import javax.validation.constraints.Min;

public class ScheduleCreateDTO extends AbstractDTO {

    @Min(0)
    private long trainId;

    @Min(0)
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
