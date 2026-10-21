package ru.zemerov.birds;

public class parrot extends bird {
    public String text;
    public parrot(String text) {
        super("Попугай");
        this.text = text;
    }
    public void sing() {
        int n = (int)(Math.random() * text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}