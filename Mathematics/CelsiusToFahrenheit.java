/*
 * Given a temperature in celsius C. You need to convert the given temperature to Fahrenheit.
Example 1:
Input: C = 32
Output: 89.6
Explanation: Using the conversion formula of celsius to farhenheit , it can be calculated that, 
for 32 degree C, the temperature in Fahrenheit = 89.6

Example 2:
Input: 50
Output: 122
Explanation: Using the conversion formulaof celsius to farhenheit, it can be calculated that, 
for 50 degree C, the temperature in Fahrenheit = 122.
Your Task: Your task is to complete the function CtoF() that takes C as parameter and returns temperature in fahrenheit( in double). The flooring and printing is automatically done by the driver code.

Expected Time Complexity: O(1)
Expected Auxiliary Space : O(1)

Constraints:
1 <= C <= 104
 */


 // Formula to convert F=(C* 9/5)+32;

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