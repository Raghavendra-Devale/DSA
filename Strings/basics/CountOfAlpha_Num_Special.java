package Strings.basics;

public class CountOfAlpha_Num_Special {

    public static void countOfAlpha_Num_Special(String str) {
        int alphabetCount = 0;
        int numbersCount = 0;
        int specialCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp  = str.charAt(i);
            if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z') ) {
                alphabetCount++;
            } else if (temp >= '0' && temp <= '9') {
                numbersCount++;
            }else {
                specialCount++;
            }
        }
        System.out.println("Alphabet Count: " + alphabetCount + " numbers count: " + numbersCount + " special count: " + specialCount);
    }

    public static void main(String[] args) {
        String str = "Raghav@0205";
        countOfAlpha_Num_Special(str);
    }
}

/*
This program counts alphabets, digits, and special characters in a string.
It loops through each character of the string one by one.
Alphabet characters are identified using uppercase and lowercase ASCII ranges.
Digits are checked using the range '0' to '9'.
All remaining characters are treated as special characters.
Finally, the counts are printed.
 */
