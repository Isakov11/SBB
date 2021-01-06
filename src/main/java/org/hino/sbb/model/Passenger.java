package org.hino.sbb.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "passengers")
@NamedQueries({
        @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
        @NamedQuery(name = "Passenger.findById", query = "SELECT p FROM Passenger p WHERE p.id = :id")
})
public class Passenger extends AbstractEntity {
    public static final String FIND_ALL = "Passenger.findAll";
    public static final String FIND_By_Id = "Passenger.findById";

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted;

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

    public Passenger(Long id, Boolean deleted, Integer version, String name, String secondName, LocalDate birthDate) {
        super.setId(id);
        this.deleted = deleted;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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
