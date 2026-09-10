public class MainLab1 {
    public static void main(String[] args) {
        MainLab1 m = new MainLab1();

        System.out.println("Задание 1");
        System.out.println("Задача 1.1: " + m.fraction(5.25));
        System.out.println("Задача 1.2: " + m.sumLastNums(4568));
        System.out.println("Задача 1.6: " + m.isUpperCase('D'));
        System.out.println("Задача 1.7: " + m.isInRange(5, 1, 3));

        int result = m.lastNumSum(5, 11);
        result = m.lastNumSum(result, 123);
        result = m.lastNumSum(result, 14);
        result = m.lastNumSum(result, 1);
        System.out.println("Задача 1.10: " + result);

        System.out.println();
        System.out.println("Задание 2");
        System.out.println("Задача 2.1: " + m.abs(-3));
        System.out.println("Задача 2.4: " + m.makeDecision(5, 7));
        System.out.println("Задача 2.5: " + m.max3(5, 7, 7));
        System.out.println("Задача 2.8: " + m.age(44));
        System.out.println("Задача 2.9: " + m.day(5));

        System.out.println();
        System.out.println("Задание 3");
        System.out.println("Задача 3.2: " + m.reverseListNums(5));
        System.out.println("Задача 3.3: " + m.chet(9));

        System.out.println("Задача 3.7:");
        m.square(4);

        System.out.println("Задача 3.8:");
        m.leftTriangle(4);

        System.out.println("Задача 3.10:");
        m.guessGame();

        System.out.println();
        System.out.println("Задание 4");
        System.out.println("Задача 4.3: " + m.maxAbs(new int[]{1, -2, -7, 4, 2, 2, 5}));

        System.out.println("Задача 4.4:");
        m.printArray(m.add(new int[]{1, 2, 3, 4, 5}, 9, 3));

        System.out.println("Задача 4.5:");
        m.printArray(m.add(new int[]{1, 2, 3, 4, 5}, new int[]{7, 8, 9}, 3));

        int[] array = {1, 2, 3, 4, 5};
        m.reverse(array);
        System.out.println("Задача 4.6:");
        m.printArray(array);

        System.out.println("Задача 4.9:");
        m.printArray(m.findAll(new int[]{1, 2, 3, 8, 2, 2, 9}, 2));
    }

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

        System.out.println("Вы угадали! Вы отгадали число за " + attempts + " попытки");
    }

    public int maxAbs(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    public int[] add(int[] arr, int x, int pos) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        result[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }
        return result;
    }

    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
