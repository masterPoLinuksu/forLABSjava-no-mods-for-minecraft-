public class Lab1Zad3 {
    public static void main(String[] args) {
        Zad3 zad3 = new Zad3();

        System.out.println("Задача 3.2: " + zad3.zadach3_2(5));
        System.out.println("Задача 3.3: " + zad3.zadach3_3(9));

        System.out.println("Задача 3.7:");
        zad3.zadach3_7(4);

        System.out.println("Задача 3.8:");
        zad3.zadach3_8(4);

        System.out.println("Задача 3.10:");
        zad3.guessGame();
    }
}

class Zad3 {
    public String zadach3_2(int x) {
        String result = "";

        for (int i = x; i >= 0; i--) {
            result = result + i + " ";
        }

        return result;
    }

    public String zadach3_3(int x) {
        String result = "";

        for (int i = 0; i <= x; i = i + 2) {
            result = result + i + " ";
        }

        return result;
    }

    public void zadach3_7(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void zadach3_8(int x) {
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
        int guess = 0;

        while (guess != secret) {
            System.out.print("Введите число от 0 до 9: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess != secret) {
                System.out.println("Мимо");
            }
        }

        System.out.println("Вы угадали число за " + attempts + " попытки");
    }
}