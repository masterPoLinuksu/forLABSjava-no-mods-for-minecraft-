public class Lab1Zad4 {
    public static void main(String[] args) {
        Zad4 zad4 = new Zad4();

        System.out.println("Задача 4.3: "
                + zad4.zadach4_3(
                new int[]{1, -2, -7, 4, 2, 2, 5}
        ));

        System.out.println("Задача 4.4:");
        zad4.printArray(
                zad4.zadach4_4(
                        new int[]{1, 2, 3, 4, 5},
                        9,
                        3
                )
        );

        System.out.println("Задача 4.5:");
        zad4.printArray(
                zad4.zadach4_5(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{7, 8, 9},
                        3
                )
        );

        int[] array = {1, 2, 3, 4, 5};

        zad4.zadach4_6(array);

        System.out.println("Задача 4.6:");
        zad4.printArray(array);

        System.out.println("Задача 4.9:");
        zad4.printArray(
                zad4.zadach4_9(
                        new int[]{1, 2, 3, 8, 2, 2, 9},
                        2
                )
        );
    }
}

class Zad4 {
    public int zadach4_3(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }

        return max;
    }

    public int[] zadach4_4(int[] arr, int x, int pos) {
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

    public int[] zadach4_5(int[] arr, int[] ins, int pos) {
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

    public void zadach4_6(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];

            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public int[] zadach4_9(int[] arr, int x) {
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