package ua.stupin.hw3;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        int countWords = 0;
        wordsCounter(countWords);
    }
    private static String inputSetence() {
        Scanner s = new Scanner(System.in);
        System.out.println("Input a sentence: ");
        String sentence = s.nextLine();
        return sentence;
    }
    private static void wordsCounter(int countWords) {
        String sentence = inputSetence();
        if(sentence.length() != 0){
            countWords++;
            for (int i = 0; i < sentence.length(); i++) {
                if(sentence.charAt(0)==' ') {
                    System.out.println("You write wrong, sentence cannot start with the spacebar");
                    countWords = countWords - 1;
                    break;
                } else if (sentence.charAt(i) == ' '&& i!=0 && sentence.charAt(i-1)!=' '){
                    countWords++;
                }
            }
        }
        System.out.println("The number of words in your sentence is: " + countWords);
    }
}
