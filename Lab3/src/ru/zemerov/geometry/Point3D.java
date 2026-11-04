package ru.zemerov.geometry;

public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    // Для 8.4
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public Point3D clone() {
        return new Point3D(getX(), getY(), z);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Point3D other = (Point3D) obj;

        return z == other.z;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}