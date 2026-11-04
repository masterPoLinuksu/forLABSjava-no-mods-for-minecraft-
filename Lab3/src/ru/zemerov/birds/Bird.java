package ru.zemerov.birds;

public abstract class Bird {
    private final String name;

    protected Bird(String name) {
        this.name = name;
    }

    public abstract void sing();

    @Override
    public String toString() {
        return name;
    }
}