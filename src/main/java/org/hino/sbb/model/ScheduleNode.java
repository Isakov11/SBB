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

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    public ScheduleNode() {
    }

    public ScheduleNode(long id, Train train, Station station, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        super.setId(id);
        this.train = train;
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
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
