package org.hino.sbb.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedList;

public class StationDTO extends AbstractDTO {

    @NotBlank(message ="Station name should not be blank.")
    @Size(min=1, max=55, message="Station name should be 1 to 55.")
    private String name;

    private LinkedList<StationScheduleDTO> stationScheduleTable;

    public StationDTO() {
    }

    public StationDTO(long id, String name) {
        super.setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<StationScheduleDTO> getStationScheduleTable() {
        return stationScheduleTable;
    }

    public void setStationScheduleTable(LinkedList<StationScheduleDTO> stationScheduleTable) {
        this.stationScheduleTable = stationScheduleTable;
    }

    @Override
    public String toString() {
        return "StationDTO{" +
                "name='" + name + '\'' +
                ", stationSchedule=" + stationScheduleTable +
                '}';
    }
}
