public class Lab1Zad1 {
    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();

        System.out.println("Задача 1.1: " + zad1.fraction(5.25));
        System.out.println("Задача 1.2: " + zad1.sumLastNums(4568));
        System.out.println("Задача 1.6: " + zad1.isUpperCase('D'));
        System.out.println("Задача 1.7: " + zad1.isInRange(5, 1, 3));

        int result = zad1.lastNumSum(5, 11);
        result = zad1.lastNumSum(result, 123);
        result = zad1.lastNumSum(result, 14);
        result = zad1.lastNumSum(result, 1);

        System.out.println("Задача 1.10: " + result);
    }
}

class Zad1 {
    public double fraction(double x) {
        int whole = (int) x;
        return x - whole;
    }

    public int sumLastNums(int x) {
        int last = x % 10;
        int other = x / 10;
        int secondLast = other % 10;

        return last + secondLast;
    }

    public boolean isUpperCase(char x) {
        if (x >= 'A' && x <= 'Z') {
            return true;
        }

        return false;
    }

    public boolean isInRange(int a, int b, int num) {
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

    public int lastNumSum(int a, int b) {
        int first = a % 10;
        int second = b % 10;

        return first + second;
    }
}