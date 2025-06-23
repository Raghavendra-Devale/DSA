/*
 * You are given an interger I, find the absolute value of the integer I.
 * Example 1:
 * Input:I = -32
 * Output: 32
 * Explanation: 
 * The absolute value of -32 is 32.
 * 
 * Example 2:
 * Input: I = 45
 * Output: 45
 * Explanation: 
 * The absolute value of 45 is 45 itself.
 * Your Task: Your task is to complete the function absolute() which takes an integer I 
 * as input parameter and return the absolute value of I.
 * Expected Time Complexity: O(1)
 * Expected Auxiliary Space : O(1)
 * Constraints:-106 <= I <= 106
 * link: 
 */

 

import java.util.Scanner;

public class AbsoluteValue {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int num = sc.nextInt();

        //Absolute value using Math function
        int abs = Math.abs(num);

        //Absolute value Manually
        if(num < 0 ){ num = -(num); }
        
        System.out.println("Absolute values using inbulit funtion "+abs+" manual "+num);
    }
 }