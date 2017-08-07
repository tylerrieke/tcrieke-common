package com.rieke.bmore.common.player;

import com.rieke.bmore.common.connection.Connection;
import com.rieke.bmore.common.connection.ConnectionFactory;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class PlayerFactory <P extends Player>{
    private final ConnectionFactory connectionFactory;
    private final Map<Connection, P> connectionPlayerMap;
    private int playerCount=0;

    public PlayerFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        connectionPlayerMap = new ConcurrentHashMap<>();
    }

    public synchronized P getPlayer(String ip) {
        Connection connection = connectionFactory.getConnection(ip);
        P player = connectionPlayerMap.get(connection);
        if(player==null) {
            player = initPlayer(connection, "NewPlayer"+(++playerCount),"P"+playerCount);
            connectionPlayerMap.put(connection,player);
        }
        return player;
    }

    public Collection<P> getAllPlayers() {
        return connectionPlayerMap.values();
    }

    protected abstract P initPlayer(Connection connection, String name, String display);
}
