public class Lab1Zad3 {
    public static void main(String[] args) {
        Zad3 zad3 = new Zad3();

        System.out.println("Задача 3.2: " + zad3.reverseListNums(5));
        System.out.println("Задача 3.3: " + zad3.chet(9));

        System.out.println("Задача 3.7:");
        zad3.square(4);

        System.out.println("Задача 3.8:");
        zad3.leftTriangle(4);

        System.out.println("Задача 3.10:");
        zad3.guessGame();
    }
}

class Zad3 {
    public String reverseListNums(int x) {
        String result = "";

        for (int i = x; i >= 0; i--) {
            result = result + i + " ";
        }

        return result;
    }

    public String chet(int x) {
        String result = "";

        for (int i = 0; i <= x; i = i + 2) {
            result = result + i + " ";
        }

        return result;
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void guessGame() {
        java.util.Random random = new java.util.Random();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int secret = random.nextInt(10);
        int attempts = 0;
        int guess = -1;

        while (guess != secret) {
            System.out.print("Введите число от 0 до 9: ");

            guess = scanner.nextInt();
            attempts++;

            if (guess != secret) {
                System.out.println("Вы не угадали");
            }
        }

        System.out.println(
                "Вы угадали! Вы отгадали число за "
                        + attempts
                        + " попытки"
        );
    }
}