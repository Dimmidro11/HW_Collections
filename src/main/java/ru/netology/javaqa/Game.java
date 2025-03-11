package ru.netology.javaqa;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register (Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        if (searchByName(playerName1).getStrength() < searchByName(playerName2).getStrength()) {
            return 2;
        } else if (searchByName(playerName1).getStrength() > searchByName(playerName2).getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

    public Player searchByName(String name) {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return player;
            }
        }
        throw new NotRegisteredException("Player with name " + name + " not found");
    }
}
