package org.hino.sbb.dto;

public class StationScheduleDTO {

    private String trainNumber;

    private String arrivalTime;

    private String departureTime;

    public StationScheduleDTO() {
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
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

    @Override
    public String toString() {
        return  "Train № " + trainNumber +
                " arrival Time " + arrivalTime +
                " departure Time " + departureTime;
    }
}
