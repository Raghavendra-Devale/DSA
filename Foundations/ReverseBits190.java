package Foundations;

/**
 * =======================================================
 * LeetCode 190 - Reverse Bits
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Bit Manipulation
 * Pattern    : Bit-by-Bit Processing
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Reverse the bits of a given 32-bit integer.
 *
 * Example:
 *
 * Input:
 *
 * 00000010100101000001111010011100
 *
 * Reversed:
 *
 * 00111001011110000010100101000000
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Extract a bit using &
 * ✓ Set a bit using |
 * ✓ Left Shift <<
 * ✓ Unsigned Right Shift >>>
 * ✓ Understand fixed 32-bit processing
 *
 */

public class ReverseBits190 {

    /**
     * =======================================================
     * Approach : Bit-by-Bit Reversal
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * We process all 32 bits of n one at a time.
     *
     * For every bit:
     *
     * 1. Shift result left by one position.
     *
     * 2. Extract the last bit of n using:
     *
     *      n & 1
     *
     * 3. Add that bit to result using:
     *
     *      result | (n & 1)
     *
     * 4. Shift n right so the next bit becomes
     *    the last bit.
     *
     * -------------------------------------------------------
     * Small Example
     * -------------------------------------------------------
     *
     * Ignore the 32-bit size temporarily and imagine:
     *
     * n = 1101
     *
     * We want:
     *
     * 1011
     *
     * -------------------------------------------------------
     * Iteration 1
     * -------------------------------------------------------
     *
     * n      = 1101
     * result = 0000
     *
     * result << 1
     *
     * result = 0000
     *
     * n & 1
     *
     * 1101
     * 0001
     * ----
     * 0001
     *
     * result |= 1
     *
     * result = 0001
     *
     * Shift n:
     *
     * n = 0110
     *
     * -------------------------------------------------------
     * Iteration 2
     * -------------------------------------------------------
     *
     * result << 1
     *
     * 0001
     * ↓
     * 0010
     *
     * Last bit of n:
     *
     * 0110 & 0001 = 0
     *
     * result = 0010
     *
     * n = 0011
     *
     * -------------------------------------------------------
     * Iteration 3
     * -------------------------------------------------------
     *
     * result:
     *
     * 0010 << 1
     *
     * =
     *
     * 0100
     *
     * Last bit:
     *
     * 0011 & 1 = 1
     *
     * result:
     *
     * 0101
     *
     * -------------------------------------------------------
     * Iteration 4
     * -------------------------------------------------------
     *
     * result << 1
     *
     * 1010
     *
     * Last bit:
     *
     * 1
     *
     * result:
     *
     * 1011
     *
     * Original:
     *
     * 1101
     *
     * Reversed:
     *
     * 1011
     *
     * -------------------------------------------------------
     * Why result <<= 1 ?
     * -------------------------------------------------------
     *
     * We are building the reversed number from
     * left to right.
     *
     * Before inserting the next bit, we create
     * one empty position at the right side.
     *
     * Example:
     *
     * result = 0101
     *
     * result << 1
     *
     * result = 1010
     *
     * Now the last position is available for
     * the next bit.
     *
     * -------------------------------------------------------
     * Why n & 1 ?
     * -------------------------------------------------------
     *
     * It extracts the Least Significant Bit (LSB).
     *
     * Example:
     *
     * n = 1011
     *
     *     1011
     *   & 0001
     *   ------
     *     0001
     *
     * Last bit = 1
     *
     * Another example:
     *
     *     1010
     *   & 0001
     *   ------
     *     0000
     *
     * Last bit = 0
     *
     * -------------------------------------------------------
     * Why result |= (n & 1) ?
     * -------------------------------------------------------
     *
     * After shifting result left, the last bit
     * is 0.
     *
     * OR allows us to insert the extracted bit.
     *
     * Example:
     *
     * result:
     *
     * 1010
     *
     * extracted bit:
     *
     * 0001
     *
     * OR:
     *
     * 1010
     * 0001
     * ----
     * 1011
     *
     * -------------------------------------------------------
     * Why >>> Instead of >> ?
     * -------------------------------------------------------
     *
     * Java has two right-shift operators.
     *
     * >>  Signed Right Shift
     *
     * >>> Unsigned Right Shift
     *
     * >> preserves the sign bit.
     *
     * Example:
     *
     * A negative int starts with:
     *
     * 1...
     *
     * >> keeps inserting 1 from the left.
     *
     * >>> always inserts 0 from the left.
     *
     * Since this problem treats n as a sequence
     * of 32 bits, >>> expresses the intention
     * more clearly.
     *
     * NOTE:
     *
     * Your original solution used:
     *
     * n >>= 1;
     *
     * Because the loop executes exactly 32 times
     * and we only inspect the least significant
     * bit each time, it still works.
     *
     * However, >>> is the clearer choice here.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * The loop is:
     *
     * for (int i = 0; i < 32; i++)
     *
     * It ALWAYS executes exactly 32 times.
     *
     * Each iteration performs constant-time
     * bit operations:
     *
     * <<
     * &
     * |
     * >>>
     *
     * Therefore:
     *
     * O(32)
     *
     * Since 32 is a constant:
     *
     * Time Complexity = O(1)
     *
     * -------------------------------------------------------
     * Space Complexity Derivation
     * -------------------------------------------------------
     *
     * Extra variables:
     *
     * result
     * i
     *
     * No array, String, collection or recursion
     * is used.
     *
     * Therefore:
     *
     * Space Complexity = O(1)
     */

    public static int reverseBits(int n) {

        int result = 0;

        // Java int always contains 32 bits.
        for (int i = 0; i < 32; i++) {

            /**
             * Make space for the next bit.
             */
            result <<= 1;

            /**
             * Extract the last bit from n:
             *
             * n & 1
             *
             * Then insert that bit into result.
             */
            result |= (n & 1);

            /**
             * Move the next bit of n
             * into the least significant position.
             *
             * Unsigned shift is preferred because
             * the problem works with all 32 bits.
             */
            n >>>= 1;
        }

        return result;
    }

    public static void main(String[] args) {

        int num = 43261596;

        int result = reverseBits(num);

        System.out.println("Original Number : " + num);

        System.out.println(
                "Original Binary : "
                        + String.format(
                        "%32s",
                        Integer.toBinaryString(num)
                ).replace(' ', '0')
        );

        System.out.println(
                "Reversed Binary : "
                        + String.format(
                        "%32s",
                        Integer.toBinaryString(result)
                ).replace(' ', '0')
        );

        System.out.println("Reversed Number : " + result);
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Used Signed Right Shift

Original:

n >>= 1;

Better for this problem:

n >>>= 1;

Reason:

>> preserves the sign bit.

>>> inserts 0 from the left.

Since the problem asks us to process a fixed
32-bit representation, >>> communicates the
intention more clearly.

IMPORTANT:

The original >> solution still works here because:

• We execute exactly 32 iterations.
• We inspect only n & 1 before each shift.
• Every original bit eventually reaches the LSB.

---------------------------------------------------------

2. Don't Stop With:

while (n != 0)

For this particular problem, all 32 positions
matter.

Leading zeros in the original number become
trailing zeros after reversal.

Using:

for (int i = 0; i < 32; i++)

makes the fixed-width nature explicit.

=========================================================
Key Learnings
=========================================================

✓ n & 1 extracts the last bit.

---------------------------------------------------------

✓ result << 1 creates space for the next bit.

---------------------------------------------------------

✓ result | bit inserts a bit into the result.

---------------------------------------------------------

✓ >>> performs unsigned right shift.

---------------------------------------------------------

✓ Java int contains exactly 32 bits.

---------------------------------------------------------

✓ A fixed 32-iteration loop has:

O(32)

which simplifies to:

O(1)

=========================================================
Pattern Recognition
=========================================================

Whenever a problem asks:

• Reverse bits

• Extract individual bits

• Inspect binary representation

• Manipulate specific bits

Think:

BIT MANIPULATION

Important operations:

n & 1

→ Extract last bit

n >>> 1

→ Move to next bit

result << 1

→ Make room for another bit

result | bit

→ Insert bit

=========================================================
Connection With LeetCode 191
=========================================================

LeetCode 191 - Number of 1 Bits:

We learned:

n & 1

to inspect the last bit.

LeetCode 190 - Reverse Bits:

We reuse:

n & 1

but now we take that extracted bit and
build another integer in reverse order.

So both problems use the same fundamental
operation:

Extract the Least Significant Bit.

=========================================================
Interview Notes
=========================================================

Q1. What does n & 1 do?

It extracts the Least Significant Bit.

---------------------------------------------------------

Q2. What does result <<= 1 do?

It shifts the current result left and creates
space for the next extracted bit.

---------------------------------------------------------

Q3. Why exactly 32 iterations?

Java int is a 32-bit signed integer.

The problem requires reversing all 32 bits.

---------------------------------------------------------

Q4. Time Complexity?

Exactly 32 iterations:

O(32)

Since 32 is constant:

O(1)

---------------------------------------------------------

Q5. Space Complexity?

Only a few integer variables:

O(1)

=========================================================
*/