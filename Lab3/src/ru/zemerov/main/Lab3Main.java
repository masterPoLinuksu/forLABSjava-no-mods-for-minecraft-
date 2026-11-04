package ru.zemerov.main;

import java.util.Scanner;
import ru.zemerov.graph.*;
import ru.zemerov.geometry.*;
import ru.zemerov.birds.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Lab3Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Лабораторная №3. Вариант №5");

        System.out.println("\n1.10. Дороги");

        int abCost = 5;
        City[] map = createMap();
        City a = map[0], b = map[1], c = map[2];
        City d = map[3], f = map[5];

        System.out.println("До изменения: " + a);
        int newCost = readInt("Новая стоимость A -> B: ");
        a.addRoad(b, newCost);
        System.out.println("Повторное добавление: " + a);

        a.removeRoad(b);
        System.out.println("После удаления: " + a);
        a.addRoad(b, abCost);

        for (City city : map) {
            System.out.println(city);
        }

        System.out.println("\n2.5. Маршрут");

        Route route = new Route(f, d);
        System.out.println("F -> D: " + route);

        System.out.print("Массив пути: ");
        for (City city : route.getPath()) {
            System.out.print(city.getName() + " ");
        }
        System.out.println();

        route.setStart(readCity(map, "Новое начало"));
        route.setEnd(readCity(map, "Новый конец"));
        System.out.println("Начало: " + route.getStart().getName()
                + ", конец: " + route.getEnd().getName());
        System.out.println("Новый маршрут: " + route);

        System.out.println("\n3.3. Двусторонняя дорога");

        City x = new City(readText("Название обычного города: "));
        TwoWayCity y = new TwoWayCity(
                readText("Название двустороннего города: ")
        );
        int cost = readInt("Стоимость дороги между ними: ");

        y.addRoad(x, cost);
        System.out.println(x);
        System.out.println(y);

        String zName = readText("Название ещё одного двустороннего города: ");
        int zCost = readInt("Стоимость его дороги в предыдущий город: ");
        TwoWayCity z = new TwoWayCity(
                zName, new City[]{y}, new int[]{zCost}
        );
        System.out.println(z);
        System.out.println(y);

        System.out.println("\n3.5. Трёхмерная точка");

        int px = readInt("X: ");
        int py = readInt("Y: ");
        int pz = readInt("Z: ");

        Point point = new Point(px, py);
        Point3D point3D = new Point3D(px, py, pz);
        System.out.println("Двумерная точка: " + point);
        System.out.println("Трёхмерная точка: " + point3D);

        System.out.println("\n4.3. Птицы");

        String text = readText("Текст попугая: ");
        for (Bird bird : new Bird[]{
                new Sparrow(), new Cuckoo(), new Parrot(text)
        }) {
            System.out.println(bird + ":");
            bird.sing();
        }

        System.out.println("\n5.9. Городим");

        City ga = new TwoWayCity(map[0].getName());
        City gb = new City(map[1].getName());
        City gc = new City(map[2].getName());
        City gd = new TwoWayCity(map[3].getName());
        City ge = new City(map[4].getName());

        ga.addRoad(gb, 1);
        ga.addRoad(gc, 1);
        gb.addRoad(gc, 1);
        gd.addRoad(gb, 1);
        gd.addRoad(ge, 1);
        ge.addRoad(gc, 1);

        for (City city : new City[]{ga, gb, gc, gd, ge}) {
            System.out.print(city.getName() + " -> ");
            for (int i = 0; i < city.getRoadCount(); i++) {
                System.out.print(city.getRoadCity(i).getName() + " ");
            }
            System.out.println();
        }

        System.out.println("\n6.5. Сравнение городов");

        String firstName = readText("Название первого сравниваемого города: ");
        String secondName = readText("Название второго сравниваемого города: ");
        int firstCost = readInt("Стоимость дороги в A: ");
        int secondCost = readInt("Стоимость дороги в B: ");

        City first = new City(
                firstName, new City[]{a, b}, new int[]{firstCost, secondCost}
        );
        City second = new TwoWayCity(
                secondName, new City[]{b, a}, new int[]{secondCost, firstCost}
        );

        System.out.println(first);
        System.out.println(second);
        System.out.println("City равен TwoWayCity: " + first.equals(second));
        System.out.println("В обратную сторону: " + second.equals(first));
        System.out.println("Хеш-коды совпадают: "
                + (first.hashCode() == second.hashCode()));

        int changedCost;
        do {
            changedCost = readInt(
                    "Новая стоимость дороги в A, отличная от " + firstCost + ": "
            );
        } while (changedCost == firstCost);

        first.addRoad(a, changedCost);
        System.out.println("После изменения стоимости: " + first.equals(second));

        System.out.println("\n7.3. Возведение в степень");

        if (args.length == 2) {
            try {
                System.out.println(args[0] + " ^ " + args[1]
                        + " = " + power(args[0], args[1]));
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка: аргументы должны быть целыми числами.");
            }
        } else {
            System.out.println("Укажите два аргумента запуска, например: 2 3");
        }

        System.out.println("\n8.4. Клонирование точки");

        Point copy = point.clone();
        System.out.println("Оригинал: " + point + ", копия: " + copy);
        System.out.println("Один объект: " + (point == copy));
        System.out.println("Равные координаты: " + point.equals(copy));

        copy.setX(readInt("Новый X копии: "));
        copy.setY(readInt("Новый Y копии: "));
        System.out.println("Оригинал: " + point + ", изменённая копия: " + copy);

        Point3D copy3D = point3D.clone();
        System.out.println("Трёхмерная копия: " + copy3D);
        copy3D.setZ(readInt("Новый Z трёхмерной копии: "));
        System.out.println("Оригинал 3D: " + point3D + ", копия 3D: " + copy3D);
    }

    private static City[] createMap() {
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City(
                "F", new City[]{b, e}, new int[]{1, 2}
        );

        a.addRoad(b, 5);
        a.addRoad(f, 1);
        a.addRoad(d, 6);

        b.addRoad(a, 5);
        b.addRoad(c, 3);

        c.addRoad(b, 3);
        c.addRoad(d, 4);

        d.addRoad(a, 6);
        d.addRoad(c, 4);
        d.addRoad(e, 2);

        e.addRoad(f, 2);

        return new City[]{a, b, c, d, e, f};
    }

    private static City readCity(City[] cities, String prompt) {
        while (true) {
            String name = readText(prompt + " — название города A-F: ");
            for (City city : cities) {
                if (city.getName().equals(name)) {
                    return city;
                }
            }
            System.out.println("Такого города на карте нет.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                return parseInt(readText(prompt));
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка: введите целое число типа int.");
            }
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("Ошибка: введите непустой текст.");
        }
    }

    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
}