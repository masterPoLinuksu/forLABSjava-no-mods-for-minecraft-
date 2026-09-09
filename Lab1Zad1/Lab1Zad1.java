public class Lab1Zad1 {
    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();

        System.out.println("Задача 1.1: " + zad1.zadach1_1(5.25));
        System.out.println("Задача 1.2: " + zad1.zadach1_2(4568));
        System.out.println("Задача 1.6: " + zad1.zadach1_6('D'));
        System.out.println("Задача 1.7: " + zad1.zadach1_7(5, 1, 3));
        System.out.println("Задача 1.10: " + zad1.zadach1_10(5, 11));
    }
}

class Zad1 {
    public double zadach1_1(double x) {
        int whole = (int) x;
        return x - whole;
    }

    public int zadach1_2(int x) {
        int last = x % 10;
        int other = x / 10;
        int secondLast = other % 10;

        return last + secondLast;
    }

    public boolean zadach1_6(char x) {
        if (x >= 'A' && x <= 'Z') {
            return true;
        }

        return false;
    }

    public boolean zadach1_7(int a, int b, int num) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (num >= a && num <= b) {
            return true;
        }

        return false;
    }

    public int zadach1_10(int a, int b) {
        int first = a % 10;
        int second = b % 10;

        return first + second;
    }
}