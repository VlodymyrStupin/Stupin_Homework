package ua.stupin.hw2;

public class task2 {
    public static void main(String[] args){
        double xA = -2;     double yA = 2;
        double xB = 3;      double yB = 3;
        double xC = 5;      double yC = -2;
        triangleSquare(xA, yA, xB, yB, xC, yC);
    }
    private static void triangleSquare(double xA, double yA, double xB, double yB, double xC, double yC) {
        double triangleSquare = Math.abs((xA - xC)*(yB - yC)-(xB - xC)*(yA - yC))/2;
        System.out.println(triangleSquare);
    }
}



