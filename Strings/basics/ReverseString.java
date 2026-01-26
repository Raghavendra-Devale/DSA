package Strings.basics;

public class ReverseString {
    public static void reverseStringWithoutInbuilt(String str){
        char[] arr = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            char temp = str.charAt(i);
            arr[i] = str.charAt(j);
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(arr);
    }

    public static void revrseString(String str){
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) {
        String str = "RAMAR";
        revrseString(str);
    }
}
/*
This program reverses a string in two different ways.
The first method converts the string into a character array and swaps characters using two pointers.
Swapping continues until the pointers meet in the middle.
The reversed character array is then printed.
The second method uses StringBuilder’s reverse() method.
Both approaches produce the reversed string.
 */