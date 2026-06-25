package Foundations;

/*
Problem:
Given an integer n, return true if it is a power of three.
Otherwise, return false.

A number is a power of three if there exists an integer x such that:

n = 3^x

Examples:

Input: 27
Output: true

Input: 10
Output: false

Concepts:
- Mathematics
- Recursion
- Division
- Logarithm

Difficulty:
Easy
*/



public class PowerOfThree326 {

    /*
Approach (Repeated Division)

Idea:
- Every power of 3 is divisible by 3 until it becomes 1.
- Keep dividing the number by 3 while it is perfectly divisible.
- If the final value becomes exactly 1,
  then the number is a power of 3.

Steps:
1. If n <= 0, return false.
2. While n is divisible by 3:
      divide n by 3.
3. If n becomes 1,
      return true.
   Otherwise,
      return false.

Why it Works:
Power of three numbers contain only one prime factor: 3.

Example:
27 = 3 × 3 × 3

Repeated division removes one factor at a time.

27 → 9 → 3 → 1

Since we end at 1,
27 is a power of 3.
*/

/*
    Dry Rub

Input:
27

Iteration 1

27 % 3 == 0

n = 9

Iteration 2

9 % 3 == 0

n = 3

Iteration 3

3 % 3 == 0

n = 1

Loop Ends

Return true
     */
// TC -> O(log₃ n)
    // SC -> O(1)

    public static boolean isPowerOfThree(int n) {

        if(n <= 0){
            return false;
        }
        while(n % 3 == 0){
            n /= 3;
        }

        return n == 1;

    }

    /*
Approach (Recursion)

Idea:
Instead of using a loop,
keep dividing recursively until:

- n becomes 1
OR
- n is not divisible by 3.

Base Cases:

1. n == 1
   return true

2. n <= 0 OR n % 3 != 0
   return false

Otherwise:

return isPowerOfThree(n / 3)
*/

    /*
    Dry rub:
    27

isPowerOfThree(27)

↓

isPowerOfThree(9)

↓

isPowerOfThree(3)

↓

isPowerOfThree(1)

↓

true
     */
//TC -> O(log₃ n)
//    SC -> O(log₃ n) (Recursive Call Stack)

    public static boolean isPowerOfThreeRec(int n) {

        if (n == 1)
            return true;

        if (n <= 0 || n % 3 != 0)
            return false;

        return isPowerOfThreeRec(n / 3);
    }



    /*
Approach (Mathematical Trick)

Idea:

The largest power of 3
that fits inside a signed 32-bit integer is

3^19 = 1162261467

Every smaller positive power of 3
must divide this number exactly.

Therefore,

if

1162261467 % n == 0

then n must be a power of 3.

Otherwise,
it is not.
*/

    /*
    Dry run
    Input

27

1162261467 % 27

=

0

Return true

------------------

Input

10

1162261467 % 10

=

7

Return false
     */

//    TC and SC O(1)

    public static boolean isPowerOfThreeMath(int n) {

        return n > 0 && 1162261467 % n == 0;
    }




    public static void main(String[] args) {
        System.out.println(isPowerOfThree(10));
    }
}
