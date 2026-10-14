package lab2;

import java.util.ArrayList;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

class Name {
    public String surname;
    public String firstName;
    public String patronymic;

    public Name(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String toString() {
        String result = "";
        if (surname != null) {
            result = result + surname + " ";
        }
        if (firstName != null) {
            result = result + firstName + " ";
        }
        if (patronymic != null) {
            result = result + patronymic + " ";
        }
        return result.trim();
    }
}

class Line {
    public Point start;
    public Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "Линия от" + start + " до" + end;
    }
}

class City {
    public String name;
    public ArrayList<City> cities = new ArrayList<City>();
    public ArrayList<Integer> costs = new ArrayList<Integer>();

    public City(String name) {
        this.name = name;
    }

    public City(String name, City[] otherCities, int[] otherCosts) {
        this.name = name;
        for (int i = 0; i < otherCities.length; i++) {
            cities.add(otherCities[i]);
            costs.add(otherCosts[i]);
        }
    }

    public void addRoad(City city, int cost) {
        cities.add(city);
        costs.add(cost);
    }

    public String toString() {
        String result = name + " -> ";
        for (int i = 0; i < cities.size(); i++) {
            result = result + cities.get(i).name + ":" + costs.get(i) + " ";
        }
        return result;
    }
}

class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction f) {
        int n = numerator * f.denominator + f.numerator * denominator;
        int d = denominator * f.denominator;
        return new Fraction(n, d);
    }

    public Fraction sum(int x) {
        return sum(new Fraction(x, 1));
    }

    public Fraction minus(Fraction f) {
        int n = numerator * f.denominator - f.numerator * denominator;
        int d = denominator * f.denominator;
        return new Fraction(n, d);
    }

    public Fraction minus(int x) {
        return minus(new Fraction(x, 1));
    }

    public Fraction mult(Fraction f) {
        return new Fraction(numerator * f.numerator, denominator * f.denominator);
    }

    public Fraction mult(int x) {
        return mult(new Fraction(x, 1));
    }

    public Fraction div(Fraction f) {
        return new Fraction(numerator * f.denominator, denominator * f.numerator);
    }

    public Fraction div(int x) {
        return div(new Fraction(x, 1));
    }
}

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
        System.out.println("Задание 3-4");
        City moscow = new City("Москва");
        City kazan = new City("Казань");
        City samara = new City("Самара", new City[]{moscow}, new int[]{700});
        City piter = new City("Санкт-Петербург", new City[]{moscow}, new int[]{500});
        moscow.addRoad(kazan, 600);
        moscow.addRoad(piter, 500);
        kazan.addRoad(samara, 400);
        System.out.println(moscow);
        System.out.println(kazan);
        System.out.println(samara);
        System.out.println(piter);

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