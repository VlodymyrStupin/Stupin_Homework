package ua.stupin.ua.stupin.hw7;

import java.util.Arrays;

public class Task2 {
    static class Vectors {
        double x;
        double y;
        double z;


        Vectors(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        private double calculateVectorLength() {
            return Math.sqrt(Math.pow(x, 2) +
                    Math.pow(y, 2) + Math.pow(z, 2));
        }

        private Vectors calculateProductOfTwoVectors(Vectors vectors) {
            return new Vectors(y * vectors.z - z * vectors.y,
                    z * vectors.x - x * vectors.z,
                    x * vectors.y - y * vectors.x);
        }

        private double calculateCosineOfTheAngleBetweenTheVectors(Vectors vectors) {
            double scalarProduct = x * vectors.x + y * vectors.y + z * vectors.z;
            return scalarProduct / (calculateVectorLength() * scalarProduct);
        }

        private Vectors addingOfVectors(Vectors vectors) {
            return new Vectors(x + vectors.x, y + vectors.y, z + vectors.z);
        }

        private Vectors subtractOfVectors(Vectors vectors) {
            return new Vectors(x - vectors.x, y - vectors.y, z - vectors.z);
        }

        public static Vectors[] returnRandomVectorsFromNumberN(int n) {
            Vectors[] randomVectors = new Vectors[n];
            for (int i = 0; i < n; i++) {
                randomVectors[i] = new Vectors((Math.random() * 5) - 5, (Math.random() * 5) - 5, (Math.random() * 5) - 5);
            }
            return randomVectors;
        }

        public String toString() {
            return "Vector{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    public static void main(String[] args) {
        Vectors[] randomVectors = Vectors.returnRandomVectorsFromNumberN(3);
        System.out.println(randomVectors[1]);
        System.out.println("Result calculation vector length: " + randomVectors[0].calculateVectorLength());
        System.out.println("Result calculation product of two vectors: " +
                randomVectors[0].calculateProductOfTwoVectors(randomVectors[1]));
        System.out.println("Result calculation cosine of the angle between the vectors: " +
                randomVectors[0].calculateCosineOfTheAngleBetweenTheVectors(randomVectors[1]));
        System.out.println("Result calculation adding of vectors: " + randomVectors[0].addingOfVectors(randomVectors[1]));
        System.out.println("Result calculation odds of vectors: " + randomVectors[0].subtractOfVectors(randomVectors[1]));
    }
}
