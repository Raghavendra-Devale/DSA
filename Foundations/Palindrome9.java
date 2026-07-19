package Foundations;

/**
 * =======================================================
 * LeetCode 9 - Palindrome Number
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Math
 * Pattern    : Number Reversal
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an integer x, return true if x is a palindrome,
 * and false otherwise.
 *
 * A palindrome number reads the same from left to right
 * and right to left.
 *
 * Examples:
 *
 * Input : 121
 * Output: true
 *
 * Input : -121
 * Output: false
 *
 * Input : 10
 * Output: false
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Number Manipulation
 * ✓ Digit Extraction
 * ✓ Reverse a Number
 * ✓ Overflow Awareness
 * ✓ Half Reversal Optimization
 *
 */

public class Palindrome9 {

    /**
     * =======================================================
     * Approach 1 : Reverse the Entire Number
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     * Reverse the complete number.
     *
     * If the reversed number is equal to the original number,
     * then it is a palindrome.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * num = 121
     *
     * reverse = 0
     *
     * digit = 1
     * reverse = 1
     *
     * digit = 2
     * reverse = 12
     *
     * digit = 1
     * reverse = 121
     *
     * Compare
     *
     * 121 == 121
     *
     * Return true
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * The while loop removes one digit
     * during every iteration.
     *
     * Example:
     *
     * 12345
     * ↓
     * 1234
     * ↓
     * 123
     * ↓
     * 12
     * ↓
     * 1
     * ↓
     * 0
     *
     * If a number contains d digits,
     * the loop executes d times.
     *
     * Number of digits
     *
     * = log10(n)
     *
     * Therefore
     *
     * Time Complexity
     *
     * O(log n)
     *
     * -------------------------------------------------------
     * Space Complexity Derivation
     * -------------------------------------------------------
     *
     * Extra variables used:
     *
     * temp
     * digit
     * reverse
     *
     * No extra data structure is created.
     *
     * Space Complexity
     *
     * O(1)
     */

    public static boolean isPalindrome(int num) {

        // Zero is a palindrome.
        if (num == 0)
            return true;

        // Negative numbers cannot be palindromes
        // because of the '-' sign.
        if (num < 0)
            return false;

        int temp = num;
        int reverse = 0;

        while (temp != 0) {

            // Extract last digit.
            int digit = temp % 10;

            // Build reversed number.
            reverse = reverse * 10 + digit;

            // Remove last digit.
            temp /= 10;
        }

        // Compare original with reversed number.
        return num == reverse;
    }

    /**
     * =======================================================
     * Approach 2 : Reverse Only Half (Optimal)
     * =======================================================
     *
     * Observation
     * -------------------------------------------------------
     * We do not need to reverse the entire number.
     *
     * We only need to reverse half of the digits.
     *
     * Example:
     *
     * 1221
     *
     * Left Half : 12
     * Right Half: 21
     *
     * Reverse only the right half.
     *
     * 21 → 12
     *
     * Compare
     *
     * 12 == 12
     *
     * Palindrome.
     *
     * -------------------------------------------------------
     * Why reject numbers ending with 0?
     * -------------------------------------------------------
     *
     * Example:
     *
     * 10
     *
     * Reverse becomes
     *
     * 01
     *
     * Leading zeros are ignored.
     *
     * Therefore
     *
     * 10
     *
     * can never equal
     *
     * 1
     *
     * Exception:
     *
     * 0 itself is a palindrome.
     *
     * -------------------------------------------------------
     * Why stop when temp <= reverse?
     * -------------------------------------------------------
     *
     * Initially
     *
     * temp contains the left half.
     *
     * reverse contains the right half.
     *
     * Once reverse becomes greater than or equal to temp,
     * we have processed half of the digits.
     *
     * No need to continue.
     *
     * -------------------------------------------------------
     * Even Digits Example
     * -------------------------------------------------------
     *
     * 1221
     *
     * temp = 12
     *
     * reverse = 12
     *
     * Compare:
     *
     * temp == reverse
     *
     * -------------------------------------------------------
     * Odd Digits Example
     * -------------------------------------------------------
     *
     * 12321
     *
     * temp = 12
     *
     * reverse = 123
     *
     * Middle digit (3) doesn't matter.
     *
     * Remove it:
     *
     * reverse / 10
     *
     * = 12
     *
     * Compare:
     *
     * temp == reverse / 10
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Only half the digits are processed.
     *
     * If number has d digits,
     *
     * loop executes d/2 times.
     *
     * Ignoring constants,
     *
     * O(log n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Only integer variables are used.
     *
     * O(1)
     */

    public static boolean isPalindromeOptimal(int num) {

        // Negative numbers are never palindromes.
        //
        // Any positive number ending with 0
        // cannot be a palindrome.
        if (num < 0 || (num != 0 && num % 10 == 0))
            return false;

        int temp = num;
        int reverse = 0;

        while (temp > reverse) {

            // Extract last digit.
            int digit = temp % 10;

            // Reverse only half the number.
            reverse = reverse * 10 + digit;

            // Remove last digit.
            temp /= 10;
        }

        /**
         * Even digits:
         *
         * temp == reverse
         *
         * Example:
         *
         * 1221
         *
         * Odd digits:
         *
         * temp == reverse / 10
         *
         * Example:
         *
         * 12321
         *
         * Ignore the middle digit.
         */

        return temp == reverse || temp == reverse / 10;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(12121));
        System.out.println(isPalindromeOptimal(12121));

        System.out.println(isPalindrome(-121));
        System.out.println(isPalindromeOptimal(-121));

        System.out.println(isPalindrome(10));
        System.out.println(isPalindromeOptimal(10));
    }
}

/*
=========================================================
Mistakes I Found
=========================================================

1. Incorrect Comparison in Optimal Solution

You wrote:

return num == reverse || num == reverse / 10;

This is incorrect.

After the loop finishes,

'temp' contains the first half of the number,
not 'num'.

Correct:

return temp == reverse || temp == reverse / 10;

---------------------------------------------------------

Example

Input:

121

Loop Ends:

temp    = 1

reverse = 12

Correct Check:

1 == 12 / 10

1 == 1

true

Using num would compare:

121 == 12

false

=========================================================
Key Learnings
=========================================================

✓ A palindrome reads the same forwards
  and backwards.

✓ Digits can be extracted using:

    digit = n % 10;

✓ Digits are removed using:

    n /= 10;

✓ Reversing the entire number is simple
  and intuitive.

✓ Reversing only half the number avoids
  unnecessary work and also avoids integer
  overflow for very large numbers.

✓ Odd-length palindromes contain a middle
  digit that can be ignored.

=========================================================
Pattern Recognition
=========================================================

Whenever a problem asks:

• Reverse an integer

• Check palindrome without converting
  to String

• Compare first and last digits

Think about:

✓ Number Reversal

✓ Digit Extraction

✓ Half Reversal Optimization

=========================================================
Interview Notes
=========================================================

Q1. Why not convert the integer to a String?

Because the interview expects a mathematical
solution without using extra conversion.

---------------------------------------------------------

Q2. Why reverse only half?

• Less work.

• Avoids integer overflow.

• Cleaner comparison.

---------------------------------------------------------

Q3. What are the edge cases?

✓ 0

✓ Negative numbers

✓ Numbers ending with 0

✓ Single digit numbers

=========================================================
*/