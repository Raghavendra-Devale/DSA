package Strings.basics;

public class CountOccurrence {
    public static void countOccurrence(String str, char target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        String str = "Raghav020522";
        char target = 'R';
        countOccurrence(str, target);
    }
}
/*
This program counts the occurrence of a specific character in a given string.
The countOccurrence method receives a string and a target character as input.
It uses a loop to iterate through each character of the string one by one.
Whenever the current character matches the target character, a counter is incremented.
 */