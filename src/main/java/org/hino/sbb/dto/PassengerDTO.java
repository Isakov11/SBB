package org.hino.sbb.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class PassengerDTO extends AbstractDTO {

    @NotBlank(message ="Name should not be blank.")
    @Size(min=1, max=45, message="Name length should be from 1 to 45.")
    private String name;

    @NotBlank(message ="Second name should not be blank.")
    private String secondName;

    @NotBlank(message ="Birth date should not be blank.")
    private String birthDate;

    public PassengerDTO() {
    }

    public PassengerDTO(String name, String secondName, String birthDate) {
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerDTO passenger = (PassengerDTO) o;
        return Objects.equals(getId(), passenger.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return name + " " + secondName + " " + birthDate;
    }
}
