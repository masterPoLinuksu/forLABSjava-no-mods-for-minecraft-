package ru.zemerov.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.util.Scanner;
import ru.zemerov.geometry.Point;
import ru.zemerov.geometry.point3D;
import ru.zemerov.graph.City;
import ru.zemerov.graph.twocity;
import ru.zemerov.graph.Route;
import ru.zemerov.birds.bird;
import ru.zemerov.birds.sparrow;
import ru.zemerov.birds.Cuckoo;
import ru.zemerov.birds.parrot;

public class lab3main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length >= 2) {
            System.out.println("=== Возведение в степень ===");
            System.out.println(power(args[0], args[1]));
        } else {
            System.out.println("=== Возведение в степень ===");
            String x = readLine("Введите X: ");
            String y = readLine("Введите Y: ");
            System.out.println(power(x, y));
        }
        System.out.println("=== Трехмерная точка ===");
        int x = readInt("X: ");
        int y = readInt("Y: ");
        int z = readInt("Z: ");
        point3D p = new point3D(x, y, z);
        System.out.println("Точка: " + p);

        System.out.println("\n=== Дороги (рисунок 2) ===");
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        a.addRoad(b, 5); a.addRoad(f, 1); a.addRoad(d, 6);
        b.addRoad(a, 5); b.addRoad(c, 3);
        c.addRoad(b, 3); c.addRoad(d, 4);
        d.addRoad(e, 2); d.addRoad(a, 6); d.addRoad(c, 4);
        e.addRoad(f, 2);
        f.addRoad(b, 1); f.addRoad(e, 2);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        System.out.println("\n=== Маршрут F->D ===");
        Route r = new Route(f, d);
        System.out.println("Маршрут: " + r);

        System.out.println("\n=== Двусторонняя дорога ===");
        twocity xCity = new twocity("X");
        twocity yCity = new twocity("Y");
        xCity.addRoad(yCity, 10);
        System.out.println("X: " + xCity);
        System.out.println("Y: " + yCity);

        System.out.println("\n=== Птицы ===");
        bird[] birds = { new sparrow(), new Cuckoo(), new parrot("Привет, я попугай!") };
        for (int i = 0; i < birds.length; i++) {
            System.out.print(birds[i].name + ": ");
            birds[i].sing();
        }

        System.out.println("\n=== Сравнение городов ===");
        City c1 = new City("C1");
        City c2 = new City("C2");
        City t = new City("T");
        c1.addRoad(t, 1);
        c2.addRoad(t, 2);
        System.out.println("c1.equals(c2): " + c1.equals(c2));

        System.out.println("\n=== Клонирование точки ===");
        Point p1 = new Point(1, 2);
        Point p2 = p1.clone();
        System.out.println("Оригинал: " + p1 + ", Клон: " + p2);
        p2.x = 100;
        System.out.println("После изменения клона: " + p1 + ", " + p2);
    }
    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }
}