package org.hino.sbb.dto;

import org.hino.sbb.model.ScheduleNode;

import java.util.Set;

public class StationDTO extends AbstractDTO {

    private long roadId;

    private String name;

    private Set<ScheduleNodeDTO> stationSchedule;

    public StationDTO() {
    }

    public StationDTO(long id, long roadId, String name) {
        super.setId(id);
        this.roadId = roadId;
        this.name = name;
    }

    public StationDTO(long id, long roadId, String name, Set<ScheduleNodeDTO> stationSchedule) {
        super.setId(id);
        this.roadId = roadId;
        this.name = name;
        this.stationSchedule = stationSchedule;
    }

    public Long getRoadId() {
        return roadId;
    }

    public void setRoadId(long roadId) {
        this.roadId = roadId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<ScheduleNodeDTO> getStationSchedule() {
        return stationSchedule;
    }

    public void setStationSchedule(Set<ScheduleNodeDTO> stationSchedule) {
        this.stationSchedule = stationSchedule;
    }

    @Override
    public String toString() {
        return roadId + name;
    }
}
