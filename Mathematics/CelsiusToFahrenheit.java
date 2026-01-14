/*
Problem:
Given a temperature in Celsius (C), convert it into Fahrenheit.

Approach:
The problem is solved using the standard temperature conversion formula:
Fahrenheit = (Celsius × 9/5) + 32

- The input temperature is read in Celsius.
- The formula is applied directly to compute the temperature in Fahrenheit.
- Since only a constant number of arithmetic operations are performed,
  the solution runs in constant time and space.

Time Complexity:
O(1) — single arithmetic calculation.

Auxiliary Space:
O(1) — no extra space used.
*/

// Formula to convert Fahrenheit = (C * 9/5) + 32

import java.util.Scanner;

public class CelsiusToFahrenheit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value in C");
        int C = sc.nextInt();

        int F = (C * 9/5) + 32;
        System.out.println("In Fahrenheit "+ F);
        sc.close();
    }
}

/*
Dry Run:

Input:
C = 32

Step 1:
Read input value C = 32

Step 2:
Apply formula:
F = (32 * 9/5) + 32
F = (288 / 5) + 32
F = 57 + 32
F = 89

Output:
In Fahrenheit 89
*/
