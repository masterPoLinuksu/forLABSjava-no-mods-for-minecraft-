package lab2;

import java.util.ArrayList;

public class lab2allZad {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-3, 5);
        Point p3 = new Point(0, 7);
        System.out.println("Задача 1.1: " + p1 + " " + p2 + " " + p3);

        System.out.println("Задача 1.3:");
        Name n1 = new Name(null, "Клеопатра", null);
        Name n2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name n3 = new Name("Маяковский", "Владимир", null);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        System.out.println();
        System.out.println("Задание 2");
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
        Line line3 = new Line(line1.start, line2.end);
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        line1.start.x = 4;
        line1.start.y = 6;
        line2.end.x = 30;
        line2.end.y = 12;
        System.out.println("После изменения линий 1 и 2:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        line1.start = new Point(100, 100);
        line1.end = new Point(200, 200);
        System.out.println("После изменения линии 1 без влияния на линию 3:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 3: " + line3);

        System.out.println();
        System.out.println("Задание 3–4");

        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");

        City e = new City("E");
        City f = new City("F",
                new City[]{b, e},
                new int[]{1, 2}
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

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        System.out.println();
        System.out.println("Задание 5");
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);
        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " + " + 2 + " = " + f1.sum(2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " - " + 2 + " = " + f1.minus(2));
        System.out.println(f1 + " * " + f2 + " = " + f1.mult(f2));
        System.out.println(f1 + " * " + 2 + " = " + f1.mult(2));
        System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
        System.out.println(f1 + " / " + 2 + " = " + f1.div(2));
        System.out.println("f1.sum(f2).div(f3).minus(5) = " + f1.sum(f2).div(f3).minus(5));
    }
}