package com.rieke.bmore.common.player;

import com.rieke.bmore.common.connection.Connection;

public class Player {
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
