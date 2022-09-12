package ua.stupin.ua.stupin.hw4;

public class task4 {
    public static void main(String[] args) {
        int[] arrayTwoThousand = new int[2000];
        changeToNull(arrayTwoThousand);
    }
    private static void changeToNull(int[] arrayTwoThousand) {
        for (int i = 0; i < arrayTwoThousand.length; i++) {
            arrayTwoThousand[i] = (1 + (int) (Math.random() * 2000));
            if (arrayTwoThousand[i] %2 == 0){
                arrayTwoThousand[i] = 0;
            }
            System.out.println(arrayTwoThousand[i]);
        }
    }
}
