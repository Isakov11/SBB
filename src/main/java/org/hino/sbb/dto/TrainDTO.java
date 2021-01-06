package org.hino.sbb.dto;


public class TrainDTO extends AbstractDTO {

    private String name;

    private String number;


    public TrainDTO() {
    }

    public TrainDTO(long id, String name, String number) {
        super.setId(id);
        this.name = name;
        this.number = number;
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



    @Override
    public String toString() {
        return "TrainDTO{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
