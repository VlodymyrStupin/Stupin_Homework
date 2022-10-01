package ua.stupin.ua.stupin.hw3;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String palindrome = "";
        System.out.println("Input a sentence: ");
        Scanner s = new Scanner(System.in);
        String sentence = s.nextLine();
        palindrome = isPalindrome(sentenceWithoutWhitespace(sentence), palindrome);
        palindromeOrNot(palindrome, palindrome);
        s.close();
    }
    private static char[] sentenceWithoutWhitespace (String sentence){
        String sentenceWithoutWhitespace = sentence.replaceAll("\\s", "");
        return sentenceWithoutWhitespace.toCharArray();
    }
    private static String isPalindrome(char[] letters, String palindrome) {
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
