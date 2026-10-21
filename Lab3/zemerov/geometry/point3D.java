package ru.zemerov.geometry;

public class point3D extends Point {
    public int z;

    public point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}