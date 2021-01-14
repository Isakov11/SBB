package org.hino.sbb.dto;


import java.util.LinkedList;
import java.util.Set;

public class TrainDTO extends AbstractDTO {

    private String name;

    private String number;

    private long seatsNumber;

    private LinkedList<TrainScheduleDTO> trainRoute;

    public TrainDTO() {
    }

    public TrainDTO(long id, String name, String number) {
        super.setId(id);
        this.name = name;
        this.number = number;
    }

    public TrainDTO(long id, String name, String number, long seatsNumber) {
        super.setId(id);
        this.name = name;
        this.number = number;
        this.seatsNumber = seatsNumber;
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

    public long getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(long seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public LinkedList<TrainScheduleDTO> getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(LinkedList<TrainScheduleDTO> trainRoute) {
        this.trainRoute = trainRoute;
    }

    @Override
    public String toString() {
        return "TrainDTO{" +
                "id= " + super.getId() +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
