package ua.stupin.ua.stupin.hw6;

public class Task2 {

    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
    Помилка на стрічці №21
    Знайшов так - спочатку показувало помилку ArrayIndexOutOfBoundsException. Знайшов через які стрічки отримував помилку.
    Виявились ними стрічка №22 і №24. Зрбив з стрічок які викликали помилку коментарі.
    Далі запустив дебагер і в блоці for який знахожиться на стрічці №21 побачив, що змінна "j"
    рахувала в нескінченність. Помилкою було те, що в циклі була замінена змінна "j" на зміну "і"
     */
}
