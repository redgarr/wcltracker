package com.brynhagen.entity;

import com.brynhagen.api.Player;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Entity
@Table(name = "player")
public class PlayerImpl
    implements Player
{
    @Id
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="playerClass")
    private PlayerClass playerClass;

    public UUID getId() {
        return id;
    }

    public PlayerImpl setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerImpl setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public PlayerImpl setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
        return this;
    }

    public PlayerImpl() {
    }
}
