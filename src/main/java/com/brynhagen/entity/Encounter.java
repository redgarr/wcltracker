package com.brynhagen.entity;

import javax.persistence.*;

/**
 * Created by Jonathan on 2017-05-24.
 */
@Entity
@Table(name = "encounter")
public class Encounter {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @Column
    private String name;

    public Encounter()
    {
    }

    public Encounter(int id, Zone zone, String name) {
        this.id = id;
        this.zone = zone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
