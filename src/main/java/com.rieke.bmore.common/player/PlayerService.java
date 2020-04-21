package com.rieke.bmore.common.player;

import com.rieke.bmore.common.connection.ConnectionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerService <P extends Player> {
    private PlayerFactory<P> playerFactory;
    private ConnectionFactory connectionFactory;

    public PlayerService(PlayerFactory<P> playerFactory, ConnectionFactory connectionFactory) {
        this.playerFactory = playerFactory;
        this.connectionFactory = connectionFactory;
    }

    public P getPlayer(String ip) {
        return playerFactory.getPlayer(ip);
    }

    public P getPlayerIfExists(String ip) {
        return playerFactory.getPlayerIfExists(ip);
    }

    public void update(String ip, String name, String display) {
        P player = playerFactory.getPlayer(ip);
        player.setName(name);
        player.setDisplay(display);
    }

    public Collection<P> getAllPlayers() {
        return playerFactory.getAllPlayers();
    }

    public List<P> getPlayersByOrder(List<String> including) {
        List<P> players = new ArrayList<>();
        for(String inc:including) {
            players.add(getPlayer(inc));
        }
        for(P player:getAllPlayers()) {
            if(!player.getConnection().isBlackListed() && !players.contains(player)) {
                players.add(player);
            }
        }
        return players;
    }
}
