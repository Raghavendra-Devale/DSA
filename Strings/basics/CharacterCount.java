package Strings.basics;

public class CharacterCount {
    public static void charCount(String str) {
        while (str.length() > 0) {
            char ch = str.charAt(0);
            String s1 = str.replace(ch+"", "");
            int count = str.length() -  s1.length();
            System.out.println(ch+ " : "+ count);
            str = s1;
        }
    }

    public static void main(String[] args) {
        String str = "RajaRAma";
        charCount(str);
    }
}
/*
    This program counts the frequency of each character in a string
    In each loop iteration it picks the first character and removes all its occurrences using replace()
    The count is calculated by subtracting the new string length from the original length
    The character and its count are printed
    The string is then updated to exclude the processed character
    The loop continues until the string becomes empty
 */