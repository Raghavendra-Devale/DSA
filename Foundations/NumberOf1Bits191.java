package Foundations;

/**
 * =======================================================
 * LeetCode 191 - Number of 1 Bits
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Bit Manipulation
 * Pattern    : Bitwise Operations
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given a positive integer, return the number of '1'
 * bits present in its binary representation.
 *
 * This count is also known as the Hamming Weight.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input : 11
 *
 * Binary Representation:
 *
 * 1011
 *
 * Number of 1's = 3
 *
 * Output : 3
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Binary Representation
 * ✓ Bit Manipulation
 * ✓ Unsigned Right Shift
 * ✓ AND (&) Operator
 * ✓ Hamming Weight
 *
 */

public class NumberOf1Bits191 {

    /**
     * =======================================================
     * Approach 1 : Convert to Integer Binary Representation
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     * Convert the decimal number into its binary form.
     *
     * Example:
     *
     * 11
     *
     * Binary:
     *
     * 1011
     *
     * Treat this binary representation as a decimal number
     * and count how many digits are equal to 1.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * 1011
     *
     * digit = 1
     * count = 1
     *
     * digit = 1
     * count = 2
     *
     * digit = 0
     *
     * digit = 1
     * count = 3
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Integer.toBinaryString()
     *
     * visits every bit once.
     *
     * O(32)
     *
     * Parsing and counting also
     * traverse every binary digit.
     *
     * Total:
     *
     * O(32)
     *
     * Since an integer has only 32 bits,
     * this is effectively O(1).
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Binary String
     *
     * O(32)
     *
     * Effective:
     *
     * O(1)
     *
     * -------------------------------------------------------
     * Note
     * -------------------------------------------------------
     *
     * This approach is NOT recommended.
     *
     * For large binary strings,
     * Integer.parseInt() may overflow.
     *
     * It is used only for understanding.
     */

    public static int hammingWeightB(int num) {

        int count = 0;

        int binary = Integer.parseInt(Integer.toBinaryString(num));

        System.out.println(binary);

        while (binary != 0) {

            int currentDigit = binary % 10;

            if (currentDigit == 1)
                count++;

            binary /= 10;
        }

        return count;
    }

    /**
     * =======================================================
     * Approach 2 : Binary String Traversal
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * Convert the number into a binary String.
     *
     * Traverse every character.
     *
     * Count every occurrence of '1'.
     *
     * -------------------------------------------------------
     * Example
     * -------------------------------------------------------
     *
     * 11
     *
     * Binary
     *
     * "1011"
     *
     * Count:
     *
     * 1
     * 0
     * 1
     * 1
     *
     * Answer:
     *
     * 3
     *
     * -------------------------------------------------------
     * Time Complexity
     * -------------------------------------------------------
     *
     * Conversion:
     *
     * O(32)
     *
     * Traversal:
     *
     * O(32)
     *
     * Overall:
     *
     * O(32)
     *
     * Effective:
     *
     * O(1)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Binary String
     *
     * O(32)
     *
     * Effective:
     *
     * O(1)
     */

    public static int hammingWeightO(int num) {

        int count = 0;

        String binary = Integer.toBinaryString(num);

        System.out.println(binary);

        char[] binaryArray = binary.toCharArray();

        for (char bit : binaryArray) {

            if (bit == '1')
                count++;
        }

        return count;
    }

    /**
     * =======================================================
     * Approach 3 : Bit Manipulation (Optimal)
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * Bit Manipulation
     *
     * -------------------------------------------------------
     * Observation
     * -------------------------------------------------------
     *
     * We don't need to convert the number
     * into binary.
     *
     * We can directly inspect every bit.
     *
     * -------------------------------------------------------
     * AND (&) Operator
     * -------------------------------------------------------
     *
     * Example:
     *
     * num = 11
     *
     * Binary:
     *
     * 1011
     *
     * num & 1
     *
     * 1011
     * 0001
     * ----
     * 0001
     *
     * Result:
     *
     * 1
     *
     * Therefore,
     * last bit is 1.
     *
     * -------------------------------------------------------
     * Unsigned Right Shift (>>>)
     * -------------------------------------------------------
     *
     * Move every bit one position
     * towards the right.
     *
     * Example:
     *
     * 1011
     *
     * ↓
     *
     * 0101
     *
     * Repeat until every bit has been checked.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * num = 11
     *
     * Binary
     *
     * 1011
     *
     * Iteration 1
     *
     * 1011 & 1 = 1
     *
     * count = 1
     *
     * Shift
     *
     * 0101
     *
     * ----------------
     *
     * Iteration 2
     *
     * 0101 & 1 = 1
     *
     * count = 2
     *
     * Shift
     *
     * 0010
     *
     * ----------------
     *
     * Iteration 3
     *
     * 0010 & 1 = 0
     *
     * count = 2
     *
     * Shift
     *
     * 0001
     *
     * ----------------
     *
     * Iteration 4
     *
     * 0001 & 1 = 1
     *
     * count = 3
     *
     * Shift
     *
     * 0000
     *
     * Loop Ends.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Integer contains 32 bits.
     *
     * Every iteration processes
     * one bit.
     *
     * Maximum iterations:
     *
     * 32
     *
     * Therefore:
     *
     * O(32)
     *
     * Effective:
     *
     * O(1)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Only integer variables.
     *
     * O(1)
     */

    public static int hammingWeight(int num) {

        int count = 0;

        while (num != 0) {

            /**
             * Extract the Least Significant Bit.
             *
             * If last bit is 1,
             * increase the count.
             */

            count += (num & 1);

            /**
             * Unsigned Right Shift.
             *
             * Moves every bit
             * one position to the right.
             */

            num >>>= 1;
        }

        return count;
    }

    public static int hammingWeightUnsetRight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }return count;
    }

    public static void main(String[] args) {

        System.out.println(hammingWeightB(11));

        System.out.println(hammingWeightO(11));

        System.out.println(hammingWeightUnsetRight(11));

        System.out.println(hammingWeight(11));
    }
}

/*
=========================================================
Mistakes I Made
=========================================================

1. Converted binary String into Integer.

int binary =
Integer.parseInt(Integer.toBinaryString(num));

This works for small inputs.

However,

for numbers having 32 bits,

the binary representation can exceed
the maximum decimal value of Integer,
causing NumberFormatException.

Therefore,

this approach is only useful for learning.

---------------------------------------------------------

2. Initially relied on String conversion.

Although correct,

it uses unnecessary conversion.

Bit Manipulation directly works on bits
and is the preferred interview solution.

=========================================================
Key Learnings
=========================================================

✓ Integer.toBinaryString()
returns the binary representation.

✓ '& 1' extracts the Least Significant Bit.

✓ '>>>' performs an unsigned right shift.

✓ Every right shift removes one bit.

✓ Bit Manipulation avoids String conversion
and is more efficient.

✓ Integer contains 32 bits.

Therefore,

processing every bit is effectively O(1).

=========================================================
Pattern Recognition
=========================================================

Whenever a problem asks:

• Count set bits

• Binary representation

• Even/Odd checking

• Power of Two

• Bit Masks

Think about:

✓ Bit Manipulation

Useful Operators:

&   AND

|   OR

^   XOR

~   NOT

<<  Left Shift

>>  Signed Right Shift

>>> Unsigned Right Shift

=========================================================
Interview Notes
=========================================================

Q1. Why use '& 1'?

It checks whether the Least Significant Bit
is 0 or 1.

---------------------------------------------------------

Q2. Why use '>>>' instead of '>>'?

>> preserves the sign bit.

>>> always inserts 0 from the left,
making it safe for unsigned bit traversal.

---------------------------------------------------------

Q3. Can this be optimized further?

Yes.

Brian Kernighan's Algorithm:

while(n != 0){

    n = n & (n - 1);

    count++;
}

Each operation removes one set bit.

Time Complexity:

O(number of set bits)

This is the optimal interview solution.

=========================================================
*/