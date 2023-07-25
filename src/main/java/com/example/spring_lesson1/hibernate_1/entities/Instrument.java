package com.example.spring_lesson1.hibernate_1.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {
    @Id
    @Column(name = "INSTRUMENT_ID")
    private String instrumentld;
    @ManyToMany
    @JoinTable(name = "singer instrument",
    joinColumns = @JoinColumn(name = "NSTRUMENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "SINGER ID"))
    private Set<Singer> singers;

    public String getInstrumentld() {
        return instrumentld;
    }

    public void setInstrumentld(String instrumentld) {
        this.instrumentld = instrumentld;
    }

    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentld='" + instrumentld + '\'' +
                "singers='" + singers + '\'' +
                '}';
    }
}
