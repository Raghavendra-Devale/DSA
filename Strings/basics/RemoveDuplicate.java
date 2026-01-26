package Strings.basics;

public class RemoveDuplicate {
    public static void removeDuplicates(String str) {
        String sb = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!sb.contains(ch+"")){
                sb += ch;
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String str = "RajaRama";
        removeDuplicates(str);
    }
}
/*
This program removes duplicate characters from a string.
It iterates through the string character by character.
Each character is checked against the result string using contains().
If the character is not already present, it is added to the result.
This preserves the original order of characters.
Finally, the string without duplicates is printed.
 */