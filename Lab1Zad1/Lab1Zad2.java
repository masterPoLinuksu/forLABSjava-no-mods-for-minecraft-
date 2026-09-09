public class Lab1Zad2 {
    public static void main(String[] args) {
        Zad2 zad2 = new Zad2();

        System.out.println("Задача 2.1: " + zad2.zadach2_1(-3));
        System.out.println("Задача 2.4: " + zad2.zadach2_4(5, 7));
        System.out.println("Задача 2.5: " + zad2.zadach2_5(5, 7, 7));
        System.out.println("Задача 2.8: " + zad2.zadach2_8(44));
        System.out.println("Задача 2.9: " + zad2.zadach2_9(5));
    }
}

class Zad2 {
    public int zadach2_1(int x) {
        if (x < 0) {
            return -x;
        }

        return x;
    }

    public String zadach2_4(int x, int y) {
        if (x < y) {
            return x + "<" + y;
        }

        if (x > y) {
            return x + ">" + y;
        }

        return x + "==" + y;
    }

    public int zadach2_5(int x, int y, int z) {
        int max = x;

        if (y > max) {
            max = y;
        }

        if (z > max) {
            max = z;
        }

        return max;
    }

    public String zadach2_8(int x) {
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

    public String zadach2_9(int x) {
        switch (x) {
            case 1:
                return "пн";
            case 2:
                return "вт";
            case 3:
                return "ср";
            case 4:
                return "чт";
            case 5:
                return "пт";
            case 6:
                return "сб";
            case 7:
                return "вс";
            default:
                return "what is that bro pls write Den` Nedeli";
        }
    }
}