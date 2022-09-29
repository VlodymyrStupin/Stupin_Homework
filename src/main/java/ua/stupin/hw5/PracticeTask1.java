package ua.stupin.hw5;
//        Известны данные о стоимости каждого из 12 товаров. Найти общую стоимость тех
//        товаров, которые стоят дороже 1000 uah (количество таких товаров неизвестно).

import java.util.Arrays;

public class PracticeTask1 {
    public static void main(String[] args) {
        int[] productPrice = {995, 996, 997, 998, 999, 1000, 1001, 1002, 1003, 1004, 1005, 1006};
        System.out.println(sumProductPriceMoreThanThousand(productPrice));
        System.out.println(Arrays.toString(productPrice));
    }
    public static int sumProductPriceMoreThanThousand (int[] productPrice){
        int sum = 0;
        for(int i = 0; i<productPrice.length; i++){
            if(productPrice[i] > 1000){
                sum += productPrice[i];
            }
        }
        return sum;
    }
}




