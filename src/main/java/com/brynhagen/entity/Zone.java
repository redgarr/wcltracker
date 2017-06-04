package com.brynhagen.entity;

import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.Cascade;

import com.brynhagen.entity.converter.JSONEncounterDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by Jonathan on 2017-05-24.
 */
@Entity
@Table(name = "zone")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Zone
    implements Comparable<Zone>
{

    @Id
    private int id;

    @Column(nullable=false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zone")
    private List<Encounter> encounters;

    public Zone()
    {
        id = -1;
        name = null;
        encounters = null;
    }

    public Zone(int id, String name, List<Encounter> encounters) {
        this.id = id;
        this.name = name;
        this.encounters = encounters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        Zone zone = (Zone)o;

        return id == zone.id;
    }

    @Override
    public int compareTo(Zone o)
    {
        return name.compareTo(o.getName());
    }
}
