package com.rieke.bmore.common.player;

import com.rieke.bmore.common.connection.Connection;

import java.io.Serializable;

public class Player implements Serializable{
    private Connection connection;
    private String name;
    private String display;
    private boolean active;

    public Player(Connection connection, String name, String display) {
        this.connection = connection;
        this.name = name;
        this.display = display;
        active = false;
    }

    public Player(Connection connection, String name, String display, boolean active) {
        this.connection = connection;
        this.name = name;
        this.display = display;
        this.active = active;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
