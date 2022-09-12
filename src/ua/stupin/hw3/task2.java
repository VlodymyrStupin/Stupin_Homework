package ua.stupin.ua.stupin.hw3;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        String palindrome = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Input a sentence: ");
        String sentence = s.nextLine();
        String sentenceWithoutWhitespace = sentence.replaceAll("\\s", "");
        char[] letters = sentenceWithoutWhitespace.toCharArray();
        palindrome = countLetters(letters, palindrome);
        palindromeOrNot(palindrome, sentenceWithoutWhitespace);
        s.close();
    }
    private static String countLetters(char[] letters, String palindrome) {
        for (int i = 0, j = letters.length - 1; i < letters.length / 2; i++, j--) {
            if (letters[i] == letters[j]) {
                palindrome = "True";
            } else {
                palindrome = "False";
            }
        }
        return palindrome;
    }
    private static void palindromeOrNot(String palindrome, String sentenceWithoutWhitespace) {
        if (palindrome.equals("True")) {
            System.out.print("The sentence '" + sentenceWithoutWhitespace + "' is a palindrome");
        } else {
            System.out.print("The sentence '" + sentenceWithoutWhitespace + "' is not a palindrome");
        }
    }
}
