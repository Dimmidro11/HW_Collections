package ru.netology.javaqa;

import java.util.Objects;

public class Player {
    private Integer id;
    private String name;
    private Integer strength;

    public Player (Integer id, String name, Integer strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

}
