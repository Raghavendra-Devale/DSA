package Strings.basics;

public class PalindromeString {
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) {
            return true;
        }
        return  false;
    }

    public static void isPalindrome2(String str) {
        String reversed = "";
        for (int i = str.length()-1; i >= 0 ; i--) {
            reversed += str.charAt(i);
        }
        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        }else {
            System.out.println("Not palindrome");
        }
    }
    public static void main(String[] args) {
        String str = "racecara";
//        System.out.println(isPalindrome(str));
        isPalindrome2(str);
    }
}
/*
This program checks whether a given string is a palindrome or not.
The first method, `isPalindrome`, uses `StringBuilder` to reverse the string and compares it with the original.
If both strings are equal, it returns `true`, otherwise it returns `false`.
The second method, `isPalindrome2`, manually reverses the string using a loop.
After reversing, it compares the original and reversed strings and prints whether it is a palindrome or not.

 */