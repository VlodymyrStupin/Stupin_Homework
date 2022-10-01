package ua.stupin.ua.stupin.hw4;

public class Task2and3 {
    public static void main(String[] args) {
        int[] arrayThousand = new int[1000];
        int primeNumber = 0;
        int compositeNumber = 0;
        int notCompositeAndNotPrimeNumber = 0;
        int[] compositeAndPrimeNumber = compositeAndPrimeNumber(arrayThousand, primeNumber,
                compositeNumber, notCompositeAndNotPrimeNumber);
        System.out.println("Prime number in array: " + compositeAndPrimeNumber[0]);
        System.out.println("Composite number in array: " + compositeAndPrimeNumber[1]);
        System.out.println("Not a composite and not a prime number in array: " + compositeAndPrimeNumber[2]);
    }

    private static int[] compositeAndPrimeNumber(int[] arrayThousand, int primeNumber,
                                                 int compositeNumber, int notCompositeAndNotPrimeNumber) {
        for (int i = 0; i < arrayThousand.length; i++) {
            arrayThousand[i] = ((int) (Math.random() * 100));
            if (arrayThousand[i] == 0 || arrayThousand[i] == 1) {
                notCompositeAndNotPrimeNumber += 1;
            } else if (arrayThousand[i] == 2 || arrayThousand[i] == 3 ||
                    arrayThousand[i] == 5 || arrayThousand[i] == 7) {
                primeNumber += 1;
            } else if (arrayThousand[i] % 2 == 0 || arrayThousand[i] % 3 == 0 ||
                    arrayThousand[i] % 5 == 0 || arrayThousand[i] % 7 == 0) {
                compositeNumber += 1;
            } else {
                primeNumber += 1;
            }
            System.out.println(arrayThousand[i]);
        }
        return new int[]{primeNumber, compositeNumber, notCompositeAndNotPrimeNumber};
    }
}
