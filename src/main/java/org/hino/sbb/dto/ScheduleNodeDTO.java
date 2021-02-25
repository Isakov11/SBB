package org.hino.sbb.dto;

import java.time.LocalDateTime;

public class ScheduleNodeDTO extends AbstractDTO {

    private TrainDTO train;

    private StationDTO station;

    private LocalDateTime arrivalTime;

    private LocalDateTime departureTime;

    public ScheduleNodeDTO() {}

    public ScheduleNodeDTO(long id, TrainDTO train, StationDTO station,
                           LocalDateTime arrivalTime, LocalDateTime departureTime) {
        super.setId(id);
        this.train = train;
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public TrainDTO getTrain() {
        return train;
    }

    public void setTrain(TrainDTO train) {
        this.train = train;
    }

    public StationDTO getStation() {
        return station;
    }

    public void setStation(StationDTO station) {
        this.station = station;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalTimeString() {
        String result;
        LocalDateTime min = LocalDateTime.of(1753,02,01,0,0);

        if (arrivalTime.isBefore(min)){
            result = " --:-- ";
        }else{
            result = arrivalTime.toLocalTime().toString();
        }
        return result;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getDepartureTimeString() {
        String result;
        LocalDateTime max = LocalDateTime.of(9998,12,31,0,0);
        if (departureTime.isAfter(max)){
            result= " --:-- ";
        }else{
            result= departureTime.toLocalTime().toString();
        }
        return result;
    }
    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(train.getName()).
                append(", ").
                append(station.getName()).
                append(", ");
        if (arrivalTime != null) {
            builder.append(arrivalTime.toLocalDate()).
                    append(" ").
                    append(arrivalTime.toLocalTime());
        }
        else{
            builder.append("Initial station");
        }
        builder.append(" - ");
        if (departureTime != null) {
            builder.append(departureTime.toLocalDate()).
                    append(" ").
                    append(departureTime.toLocalTime());
        }
        else{
            builder.append("final station");
        }

        return builder.toString();
    }
}
