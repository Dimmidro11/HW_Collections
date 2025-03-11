package ru.netology.javaqa;

import java.util.HashMap;

public class Game {

    HashMap<String, Integer> players = new HashMap<>();

    public void register(Integer strength, String name) {
        players.put(name, strength);
    }

    public int round(String playerName1, String playerName2) {
        if (searchByName(playerName1) < searchByName(playerName2)) {
            return 2;
        } else if (searchByName(playerName1) > searchByName(playerName2)) {
            return 1;
        } else {
            return 0;
        }
    }

    public Integer searchByName(String name) {
        if (players.get(name) == null) {
            throw new NotRegisteredException("Player with name " + name + " not found");
        } else {
            return players.get(name);
        }
    }
}

