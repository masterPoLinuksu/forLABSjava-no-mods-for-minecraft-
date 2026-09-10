public class Lab1Zad2 {
    public static void main(String[] args) {
        Zad2 zad2 = new Zad2();

        System.out.println("Задача 2.1: " + zad2.abs(-3));
        System.out.println("Задача 2.4: " + zad2.makeDecision(5, 7));
        System.out.println("Задача 2.5: " + zad2.max3(5, 7, 7));
        System.out.println("Задача 2.8: " + zad2.age(44));
        System.out.println("Задача 2.9: " + zad2.day(5));
    }
}

class Zad2 {
    public int abs(int x) {
        if (x < 0) {
            return -x;
        }

        return x;
    }

    public String makeDecision(int x, int y) {
        if (x < y) {
            return x + "<" + y;
        }

        if (x > y) {
            return x + ">" + y;
        }

        return x + "==" + y;
    }

    public int max3(int x, int y, int z) {
        int max = x;

        if (y > max) {
            max = y;
        }

        if (z > max) {
            max = z;
        }

        return max;
    }

    public String age(int x) {
        int lastTwo = x % 100;
        int last = x % 10;

        if (lastTwo >= 11 && lastTwo <= 14) {
            return x + " лет";
        }

        if (last == 1) {
            return x + " год";
        }

        if (last >= 2 && last <= 4) {
            return x + " года";
        }

        return x + " лет";
    }

    public String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }
}