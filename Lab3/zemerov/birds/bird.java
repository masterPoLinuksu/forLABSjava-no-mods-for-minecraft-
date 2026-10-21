package ru.zemerov.birds;

public class bird {
    public String name;
    public bird(String name) { this.name = name; }
    public void sing() { System.out.println(name + " поёт."); }
    public String toString() { return name; }
}