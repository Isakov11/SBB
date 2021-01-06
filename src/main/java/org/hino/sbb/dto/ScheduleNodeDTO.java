package org.hino.sbb.dto;

import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;

import java.time.LocalDateTime;

public class ScheduleNodeDTO extends AbstractDTO {

    private Train train;

    private long stationOrder;

    private Station station;

    private LocalDateTime arrivalTime;

    private LocalDateTime departureTime;

    public ScheduleNodeDTO() {
    }

}
