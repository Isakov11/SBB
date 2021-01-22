package org.hino.sbb.dto;

import java.time.LocalDateTime;

public class StationScheduleDTO {

    private String trainNumber;

    private LocalDateTime arrivalTime;

    private LocalDateTime departureTime;

    public StationScheduleDTO() {
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
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

    @Override
    public String toString() {
        String result = "Train № " + trainNumber + ", "
                + (arrivalTime == null ? "Initial station" : (arrivalTime.toLocalDate() + " " + arrivalTime.toLocalTime()))
                + " — "
                + (departureTime == null ? "Final station" : (departureTime.toLocalDate() + " " + departureTime.toLocalTime()));

        return result;
    }
}
