package ru.zemerov.birds;

public class Cuckoo extends bird {
    public Cuckoo() { super("Кукушка"); }
    public void sing() {
        int n = (int)(Math.random() * 10) + 1;
        for (int i = 0; i < n; i++) System.out.print("ку-ку ");
        System.out.println();
    }
}