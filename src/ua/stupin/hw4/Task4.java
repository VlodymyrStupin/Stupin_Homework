package ua.stupin.ua.stupin.hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arrayTwoThousand = new int[2000];
        System.out.println("Array change to 0 when value is even:: " +
                Arrays.toString(changeToZeroInArrayWhenValueIsEven(arrayTwoThousand)));
        System.out.println("Initial array: " + Arrays.toString(arrayTwoThousand));
    }

    private static int[] changeToZeroInArrayWhenValueIsEven(int[] arrayTwoThousand) {
        int[] copyArrayTwoThousand = new int[arrayTwoThousand.length];
        System.arraycopy(arrayTwoThousand, 0, copyArrayTwoThousand, 0, copyArrayTwoThousand.length);
        for (int i = 0; i < copyArrayTwoThousand.length; i++) {
            copyArrayTwoThousand[i] = (1 + (int) (Math.random() * 2000));
            if (copyArrayTwoThousand[i] % 2 == 0) {
                copyArrayTwoThousand[i] = 0;
            }
        }
        return copyArrayTwoThousand;
    }
}
