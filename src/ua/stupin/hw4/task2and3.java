package ua.stupin.ua.stupin.hw4;

public class task2and3 {
    public static void main(String[] args) {
        int[] arrayThousand = new int[10];
        int primeNumber = 0;
        int compositeNumber = 0;
        int[] compositeAndPrimeNumber = compositeAndPrimeNumber(arrayThousand, primeNumber, compositeNumber);
        System.out.println("Prime number in array: " + compositeAndPrimeNumber[0]);
        System.out.println("Composite number in array: " + compositeAndPrimeNumber[1]);
    }
    private static int[] compositeAndPrimeNumber (int[] arrayThousand, int primeNumber,int compositeNumber){
        for (int i = 0; i < arrayThousand.length; i++) {
            arrayThousand[i] = (2 + (int) (Math.random() * 100));
            if(arrayThousand[i] == 2 || arrayThousand[i] == 3 ||
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
        return new int[] {primeNumber, compositeNumber};
    }
}
