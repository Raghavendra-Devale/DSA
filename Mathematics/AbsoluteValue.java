/*
Problem:
You are given an integer I. Find and return the absolute value of the integer.

Approach:
Two approaches are demonstrated in this solution:

1) Using Java's built-in function Math.abs():
   - Math.abs(num) directly returns the absolute value of the given integer.

2) Manual approach using condition:
   - If the number is negative (num < 0), multiply it by -1.
   - If the number is positive or zero, it remains unchanged.

Both approaches run in constant time and use constant space.

Time Complexity:
O(1) — only simple comparisons and assignments.

Auxiliary Space:
O(1) — no extra data structures are used.
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
        sc.close();
    }
}

/*
Dry Run:

Input:
-32

Step 1:
num = -32

Step 2:
abs = Math.abs(-32)
abs becomes 32

Step 3:
Check if num < 0
-32 < 0 → true

Step 4:
num = -(-32)
num becomes 32

Output:
Absolute values using inbulit funtion 32 manual 32
*/
