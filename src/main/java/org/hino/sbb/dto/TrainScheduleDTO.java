package org.hino.sbb.dto;

import java.time.LocalDateTime;

public class TrainScheduleDTO {

    private String stationName;

    private LocalDateTime arrivalTime;

    private LocalDateTime departureTime;

    public TrainScheduleDTO() {
    }

    public TrainScheduleDTO(String stationName, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return  "stationName='" + stationName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime;
    }
}
