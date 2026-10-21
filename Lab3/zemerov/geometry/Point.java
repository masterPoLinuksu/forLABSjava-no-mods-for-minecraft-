package ru.zemerov.geometry;

public class Point implements Cloneable {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point clone() {
        return new Point(x, y);
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}