package org.eternity.adventure.game;

public class Size {
    private int width, height;

    public static Size with(int width, int height) {
        return new Size(width, height);
    }

    private Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int indexOf(Position position) {
        return position.x() + position.y() % height * width;
    }

    public boolean contains(Position position) {
        return position.x() >= 0 && position.x() < width &&
                position.y() >= 0 && position.y() < height;
    }

    public int area() {
        return width * height;
    }
}
