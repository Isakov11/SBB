package org.hino.sbb.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@NamedQueries({
        @NamedQuery(name = "ScheduleNode.findAll", query = "SELECT s FROM ScheduleNode s")
})

public class ScheduleNode extends AbstractEntity{
    public static final String FIND_ALL = "ScheduleNode.findAll";

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "station_order")
    private long stationOrder;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    public ScheduleNode() {
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public long getStationOrder() {
        return stationOrder;
    }

    public void setStationOrder(long stationOrder) {
        this.stationOrder = stationOrder;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
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
}
