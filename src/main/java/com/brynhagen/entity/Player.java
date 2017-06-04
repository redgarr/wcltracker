package com.brynhagen.entity;

import com.brynhagen.enums.PlayerClass;

import javax.persistence.*;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Entity
@Table(name = "player",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"name", "server_name"})
)
public class Player {

    @Id
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="player_class")
    private PlayerClass playerClass;

    @Column(name="server_name")
    private String serverName;

    @Column(name="server_region")
    private String serverRegion;

    public Player() {
    }

    public Player(int id, String name, PlayerClass playerClass, String serverName, String serverRegion) {
        this.id = id;
        this.name = name;
        this.playerClass = playerClass;
        this.serverName = serverName;
        this.serverRegion = serverRegion;
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

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerRegion() {
        return serverRegion;
    }

    public void setServerRegion(String serverRegion) {
        this.serverRegion = serverRegion;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerClass=" + playerClass +
                ", serverName='" + serverName + '\'' +
                ", serverRegion='" + serverRegion + '\'' +
                '}';
    }
}
