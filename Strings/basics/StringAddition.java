package Strings.basics;

public class StringAddition {
    public static void addString(String s1, String s2){
        int sum = Integer.parseInt(s1) + Integer.parseInt(s2);
        int sum2 = 0;
        System.out.println(sum);
    }
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "12";
        addString(num1, num2);
    }
}
/*
This program adds two numbers that are provided in the form of strings.
The `addString` method takes two string inputs representing numeric values.
It converts both strings into integers using `Integer.parseInt()`.
After conversion, the integers are added together to get the sum.
Finally, the calculated sum is printed from the method.

 */