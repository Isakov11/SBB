package org.hino.sbb.dto;


import java.time.LocalDateTime;

public class ScheduleNodeDTO extends AbstractDTO {

    private TrainDTO train;

    private long stationOrder;

    private StationDTO station;

    private LocalDateTime arrivalTime;

    private LocalDateTime departureTime;

    public ScheduleNodeDTO() {
    }

    public ScheduleNodeDTO(long id, TrainDTO train, long stationOrder, StationDTO station,
                           LocalDateTime arrivalTime, LocalDateTime departureTime) {
        super.setId(id);
        this.train = train;
        this.stationOrder = stationOrder;
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

    public long getStationOrder() {
        return stationOrder;
    }

    public void setStationOrder(long stationOrder) {
        this.stationOrder = stationOrder;
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
        StringBuilder builder = new StringBuilder();
        builder.append(train.getName()).
                append(", ").
                append(stationOrder).
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
