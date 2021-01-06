package org.hino.sbb.dto;


import org.hino.sbb.model.ScheduleNode;

import java.util.Set;

public class TrainDTO extends AbstractDTO {

    private String name;

    private String number;

    private Set<ScheduleNodeDTO> trainSchedule;

    public TrainDTO() {
    }

    public TrainDTO(long id, String name, String number) {
        super.setId(id);
        this.name = name;
        this.number = number;
    }

    public TrainDTO(long id, String name, String number, Set<ScheduleNodeDTO> trainSchedule) {
        super.setId(id);
        this.name = name;
        this.number = number;
        this.trainSchedule = trainSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<ScheduleNodeDTO> getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(Set<ScheduleNodeDTO> trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    @Override
    public String toString() {
        return "TrainDTO{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
