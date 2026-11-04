package ru.zemerov.birds;
import java.util.Random;

public class Parrot extends Bird {
    private final String text;
    private final Random random = new Random();

    public Parrot(String text) {
        super("Попугай");

        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст попугая не должен быть пустым");
        }

        this.text = text;
    }

    @Override
    public void sing() {
        int count = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, count));
    }

    @Override
    public String toString() {
        return super.toString() + ", текст: " + text;
    }
}