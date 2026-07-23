package Foundations;

/**
 * =======================================================
 * LeetCode 283 - Move Zeroes
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Arrays
 * Pattern    : Two Pointers
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an integer array nums, move all 0's to the end
 * of the array while maintaining the relative order of
 * the non-zero elements.
 *
 * The operation must be performed in-place without making
 * a copy of the array.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * [0,1,0,3,12]
 *
 * Output:
 *
 * [1,3,12,0,0]
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Array Traversal
 * ✓ Two Pointer Technique
 * ✓ In-place Modification
 * ✓ Stable Ordering
 *
 */

public class MoveZeros283 {

    /**
     * =======================================================
     * Approach 1 : Overwrite + Fill Remaining with Zero
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * Traverse the array.
     *
     * Whenever a non-zero element is found,
     * place it at the next available position.
     *
     * After all non-zero elements are placed,
     * fill the remaining positions with zero.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums = [0,1,0,3,12]
     *
     * i = Position to place next non-zero element.
     *
     * j = Current element.
     *
     * Initially
     *
     * i = 0
     *
     * --------------------------------
     *
     * j = 0
     *
     * nums[0] = 0
     *
     * Ignore.
     *
     * --------------------------------
     *
     * j = 1
     *
     * nums[1] = 1
     *
     * Place at nums[0]
     *
     * Array:
     *
     * [1,1,0,3,12]
     *
     * i = 1
     *
     * --------------------------------
     *
     * j = 2
     *
     * Zero.
     *
     * Ignore.
     *
     * --------------------------------
     *
     * j = 3
     *
     * nums[3] = 3
     *
     * Place at nums[1]
     *
     * Array:
     *
     * [1,3,0,3,12]
     *
     * i = 2
     *
     * --------------------------------
     *
     * j = 4
     *
     * nums[4] = 12
     *
     * Place at nums[2]
     *
     * Array:
     *
     * [1,3,12,3,12]
     *
     * i = 3
     *
     * --------------------------------
     *
     * Fill remaining positions with 0.
     *
     * Final:
     *
     * [1,3,12,0,0]
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * First Loop
     *
     * Visits every element once.
     *
     * O(n)
     *
     * Second Loop
     *
     * Fills remaining positions with zero.
     *
     * Worst case:
     *
     * Entire array contains zeroes.
     *
     * O(n)
     *
     * Total:
     *
     * O(n + n)
     *
     * Ignore constants.
     *
     * Final:
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Only integer variables.
     *
     * O(1)
     */

    public static void moveZeroesBrute(int[] nums) {

        // Position where next non-zero element
        // should be placed.
        int i = 0;

        // Copy every non-zero element
        // towards the beginning.
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {

                nums[i] = nums[j];

                i++;
            }
        }

        // Fill remaining positions with zero.
        while (i < nums.length) {

            nums[i] = 0;

            i++;
        }

        printArray(nums);
    }

    /**
     * =======================================================
     * Approach 2 : Two Pointer Swap (Optimal)
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * Two Pointers
     *
     * -------------------------------------------------------
     * Observation
     * -------------------------------------------------------
     *
     * Instead of copying elements and then filling zeroes,
     * swap every non-zero element with the first available
     * zero position.
     *
     * This performs the operation in a single traversal.
     *
     * -------------------------------------------------------
     * Pointer Meaning
     * -------------------------------------------------------
     *
     * i
     *
     * → Position where the next non-zero element belongs.
     *
     * j
     *
     * → Current element being inspected.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums = [0,1,0,3,12]
     *
     * i = 0
     *
     * ----------------------------
     *
     * j = 0
     *
     * Zero
     *
     * Ignore.
     *
     * ----------------------------
     *
     * j = 1
     *
     * nums[1] = 1
     *
     * Swap
     *
     * [1,0,0,3,12]
     *
     * i = 1
     *
     * ----------------------------
     *
     * j = 2
     *
     * Zero
     *
     * Ignore.
     *
     * ----------------------------
     *
     * j = 3
     *
     * nums[3] = 3
     *
     * Swap
     *
     * [1,3,0,0,12]
     *
     * i = 2
     *
     * ----------------------------
     *
     * j = 4
     *
     * nums[4] = 12
     *
     * Swap
     *
     * [1,3,12,0,0]
     *
     * Done.
     *
     * -------------------------------------------------------
     * Why check i != j ?
     * -------------------------------------------------------
     *
     * Suppose array is
     *
     * [1,2,3]
     *
     * i == j
     *
     * Swapping with itself does nothing.
     *
     * This condition avoids unnecessary swaps.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Only one traversal.
     *
     * Loop executes n times.
     *
     * Each iteration performs constant work.
     *
     * Therefore
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * temp
     * i
     * j
     *
     * Constant extra memory.
     *
     * O(1)
     */

    public static void moveZeroesOpti(int[] nums) {

        // Position where next non-zero element
        // should be placed.
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            // Process only non-zero elements.
            if (nums[j] != 0) {

                /**
                 * Avoid swapping an element
                 * with itself.
                 */
                if (i != j) {

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

                i++;
            }
        }

        printArray(nums);
    }

    /**
     * Utility method for printing array.
     */
    public static void printArray(int[] nums) {

        for (int num : nums) {

            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 1, 0, 3, 12};

        System.out.println("Brute Force:");
        moveZeroesBrute(nums1);

        System.out.println();

        System.out.println("Optimal:");
        moveZeroesOpti(nums2);
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Method Naming

moveZeroesBrute()

This is actually not a brute force solution.

It is an efficient overwrite approach.

A better name would be:

moveZeroesOverwrite()

---------------------------------------------------------

2. Printing Inside Logic

Current code prints the array inside the method.

For interview questions,

prefer returning after modifying the array.

Printing should usually be done in main().

---------------------------------------------------------

3. Repeated Printing Code

The same printing loop appeared twice.

Extracting it into

printArray()

removes duplication.

=========================================================
Key Learnings
=========================================================

✓ Two Pointer problems usually have:

One pointer for reading.

One pointer for writing.

---------------------------------------------------------

✓ 'i' always points to where the next
non-zero element should be placed.

---------------------------------------------------------

✓ 'j' scans every element exactly once.

---------------------------------------------------------

✓ Relative order of non-zero elements
is preserved.

---------------------------------------------------------

✓ The swap approach avoids an additional
loop for filling zeros.

=========================================================
Pattern Recognition
=========================================================

Whenever a problem asks:

• Move elements in-place

• Maintain relative order

• Rearrange without extra space

• Partition an array

Think:

✓ Two Pointers

Common Examples:

• Move Zeroes

• Remove Element

• Remove Duplicates

• Sort Colors

=========================================================
Interview Notes
=========================================================

Q1. Why is this a Two Pointer problem?

One pointer reads the array.

One pointer writes the correct position.

---------------------------------------------------------

Q2. Is this Stable?

Yes.

The relative order of all non-zero
elements remains unchanged.

---------------------------------------------------------

Q3. Why check i != j?

To avoid unnecessary self-swaps.

---------------------------------------------------------

Q4. Which approach is preferred?

Approach 2.

It performs the rearrangement in a single
traversal while maintaining O(1) space.

=========================================================
*/