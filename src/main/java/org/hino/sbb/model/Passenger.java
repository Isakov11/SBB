package org.hino.sbb.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passengers")
@NamedQueries({
        @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
})
public class Passenger extends AbstractEntity {
    public static final String FIND_ALL = "Passenger.findAll";

    @Column(name = "version")
    private Integer version;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Passenger() {
    }

    public Passenger(long id, Integer version, String name, String secondName, LocalDate birthDate) {
        super.setId(id);
        this.version = version;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return name + " " + secondName + " " + birthDate;
    }
}
