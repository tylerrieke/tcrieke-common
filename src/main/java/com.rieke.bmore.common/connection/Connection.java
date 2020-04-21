package com.rieke.bmore.common.connection;

import java.io.Serializable;

public class Connection implements Serializable{
    private final String ip;
    private final long creationTime;
    private long lastUpdateTime;
    private boolean blackListed;

    public Connection(String ip) {
        this.ip = ip;
        blackListed = false;
        lastUpdateTime = creationTime = System.currentTimeMillis();
    }

    public Connection(String ip, long creationTime, long lastUpdateTime, boolean blackListed) {
        this.ip = ip;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
        this.blackListed = blackListed;
    }

    public String getIp() {
        return ip;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean isBlackListed() {
        return blackListed;
    }

    public void setBlackListed(boolean blackListed) {
        this.blackListed = blackListed;
    }
}
