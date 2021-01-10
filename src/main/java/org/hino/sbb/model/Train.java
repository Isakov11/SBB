package org.hino.sbb.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trains")
@NamedQueries({
        @NamedQuery(name = "Train.findAll", query = "SELECT t FROM Train t")
})

public class Train extends AbstractEntity{
    public static final String FIND_ALL = "Train.findAll";

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;
    public Train() {
    }

    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
    private Set<ScheduleNode> trainSchedule;

    public Train(long id, String name, String number) {
        super.setId(id);
        this.name = name;
        this.number = number;
    }

    public Set<ScheduleNode> getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(Set<ScheduleNode> trainSchedule) {
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
}
