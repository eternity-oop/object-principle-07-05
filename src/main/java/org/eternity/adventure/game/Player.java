package org.eternity.adventure.game;

public class Player {
    private WorldMap worldMap;
    private Position position;

    public Player(WorldMap worldMap, Position position) {
        this.worldMap = worldMap;
        this.position = position;
    }

    public boolean canMove(Direction direction) {
        return !worldMap.isBlocked(position.shift(direction));
    }

    public void move(Direction direction) {
        if (!canMove(direction)) {
            throw new IllegalArgumentException();
        }

        this.position = this.position.shift(direction);
    }

    Position position() {
        return position;
    }

    public Room currentRoom() {
        return worldMap.roomAt(position);
    }
}
