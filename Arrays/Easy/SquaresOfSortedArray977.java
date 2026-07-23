package Arrays.Easy;

import java.util.Arrays;

/**
 * =======================================================
 * LeetCode 977 - Squares of a Sorted Array
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Arrays
 * Pattern    : Two Pointers
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an integer array nums sorted in non-decreasing
 * order, return an array containing the squares of each
 * number, also sorted in non-decreasing order.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * [-4,-1,0,3,10]
 *
 * Squares:
 *
 * [16,1,0,9,100]
 *
 * Sorted Output:
 *
 * [0,1,9,16,100]
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Two Pointer Technique
 * ✓ Array Traversal
 * ✓ Reverse Filling
 * ✓ Understanding Negative Numbers
 *
 */

public class SquaresOfSortedArray977 {

    /**
     * =======================================================
     * Approach 1 : Square Every Element + Sort
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * 1. Square every element.
     * 2. Store in another array.
     * 3. Sort the array.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums
     *
     * [-4,-1,0,3,10]
     *
     * Square:
     *
     * [16,1,0,9,100]
     *
     * Sort:
     *
     * [0,1,9,16,100]
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * First Loop:
     *
     * Squares every element.
     *
     * O(n)
     *
     * Arrays.sort()
     *
     * Uses Dual Pivot QuickSort
     * for primitive int arrays.
     *
     * Average:
     *
     * O(n log n)
     *
     * Total:
     *
     * O(n + n log n)
     *
     * Dominant Term:
     *
     * O(n log n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Extra answer array.
     *
     * O(n)
     */

    public static int[] sortedSquaresExtraSorting(int[] nums) {

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            answer[i] = nums[i] * nums[i];
        }

        Arrays.sort(answer);

        return answer;
    }

    /**
     * =======================================================
     * Approach 2 : Two Pointers (Optimal)
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
     * The array is already sorted.
     *
     * The largest square will always come
     * from one of the two ends.
     *
     * Why?
     *
     * Negative numbers become positive
     * after squaring.
     *
     * Example:
     *
     * [-7,-5,-2,1,4]
     *
     * Squares:
     *
     * [49,25,4,1,16]
     *
     * Largest square:
     *
     * 49
     *
     * which came from the left end.
     *
     * -------------------------------------------------------
     * Pointer Meaning
     * -------------------------------------------------------
     *
     * left
     *
     * First element.
     *
     * right
     *
     * Last element.
     *
     * i
     *
     * Last position of answer array.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums
     *
     * [-4,-1,0,3,10]
     *
     * answer
     *
     * [_,_,_,_,_]
     *
     * ---------------------------------
     *
     * Compare
     *
     * 16 vs 100
     *
     * Place 100
     *
     * [_,_,_,_,100]
     *
     * ---------------------------------
     *
     * Compare
     *
     * 16 vs 9
     *
     * Place 16
     *
     * [_,_,_,16,100]
     *
     * ---------------------------------
     *
     * Compare
     *
     * 1 vs 9
     *
     * Place 9
     *
     * [_,_,9,16,100]
     *
     * ---------------------------------
     *
     * Compare
     *
     * 1 vs 0
     *
     * Place 1
     *
     * [_,1,9,16,100]
     *
     * ---------------------------------
     *
     * Remaining
     *
     * 0
     *
     * Final:
     *
     * [0,1,9,16,100]
     *
     * -------------------------------------------------------
     * Why Fill from the End?
     * -------------------------------------------------------
     *
     * Every iteration chooses
     * the largest square.
     *
     * Therefore,
     * it belongs at the last available position.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * left moves at most n times.
     *
     * right moves at most n times.
     *
     * Together,
     * every element is processed exactly once.
     *
     * Therefore:
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Extra answer array.
     *
     * O(n)
     */

    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // Position where the next largest square
        // should be placed.
        int i = nums.length - 1;

        int[] answer = new int[nums.length];

        while (left <= right) {

            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // Place the larger square at the end.
            if (leftSquare > rightSquare) {

                answer[i] = leftSquare;

                left++;

            } else {

                answer[i] = rightSquare;

                right--;
            }

            i--;
        }

        return answer;
    }

    /**
     * Utility Method
     */
    public static void printArray(int[] nums) {

        for (int num : nums) {

            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println("Approach 1:");
        printArray(sortedSquaresExtraSorting(nums));

        System.out.println();

        System.out.println("Approach 2:");
        printArray(sortedSquares(nums));
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Variable Naming

Instead of:

l
r
ans

Prefer:

leftSquare
rightSquare
answer

This improves readability.

---------------------------------------------------------

2. Printing Logic

Printing should be kept inside a separate
utility method instead of repeating loops.

=========================================================
Key Learnings
=========================================================

✓ Squaring negative numbers changes
their ordering.

---------------------------------------------------------

✓ The largest square is always found
at one of the two ends.

---------------------------------------------------------

✓ Fill the answer array from the end
because the largest values are chosen first.

---------------------------------------------------------

✓ Two Pointer technique avoids sorting.

=========================================================
Pattern Recognition
=========================================================

Whenever a problem involves:

• Sorted arrays

• Largest values at both ends

• Building a sorted result

Think:

✓ Two Pointers

✓ Reverse Filling

Related Problems:

• Merge Sorted Array

• Move Zeroes

• Container With Most Water

=========================================================
Interview Notes
=========================================================

Q1. Why can't we simply square the numbers?

Because negative numbers become positive,
destroying the sorted order.

---------------------------------------------------------

Q2. Why compare only the first and last elements?

The array is already sorted.

The element with the largest absolute value
must be at one of the two ends.

---------------------------------------------------------

Q3. Why fill from the end?

Because we select the largest square first.

---------------------------------------------------------

Q4. Which approach is preferred?

Approach 2.

Time Complexity:

O(n)

Space Complexity:

O(n)

It avoids the extra sorting step and is the
expected interview solution.

=========================================================
*/