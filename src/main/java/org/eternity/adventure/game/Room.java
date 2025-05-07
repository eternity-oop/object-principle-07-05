package org.eternity.adventure.game;

public class Room {
    private Position position;
    private String name;
    private String description;

    public Room(Position position, String name, String description) {
        this.position = position;
        this.name = name;
        this.description = description;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Position position() {
        return position;
    }
}
