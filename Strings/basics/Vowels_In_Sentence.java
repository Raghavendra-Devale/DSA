package Strings.basics;

public class Vowels_In_Sentence {
    public static void vowelCount(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(vowels.contains(ch+"")){
                count++;
            }
        }
        System.out.println(count);

    }
    public static void main(String[] args) {
        String string = "Ramanamurthy";
        vowelCount("Ramanamurthy");
    }
}
/*
This program counts the number of vowels in a given string.
A string containing all vowels (uppercase and lowercase) is used for comparison.
The program iterates through each character of the input string.
Each character is checked using contains() to see if it is a vowel.
If it is a vowel, the count is incremented.
Finally, the total vowel count is printed.
 */