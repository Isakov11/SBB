package org.hino.sbb.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stations")
@NamedQueries({
        @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s")
})
public class Station extends AbstractEntity{
    public static final String FIND_ALL = "Station.findAll";

    @Column(name = "road_id")
    private long roadId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "station")
    private Set<ScheduleNode> stationSchedule;

    public Station() {
    }

    public Station(long id, long roadId, String name) {
        super.setId(id);
        this.roadId = roadId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return roadId + name;
    }

    public long getRoadId() {
        return roadId;
    }

    public void setRoadId(long roadId) {
        this.roadId = roadId;
    }

    public Set<ScheduleNode> getStationSchedule() {
        return stationSchedule;
    }

    public void setStationSchedule(Set<ScheduleNode> stationSchedule) {
        this.stationSchedule = stationSchedule;
    }
}
