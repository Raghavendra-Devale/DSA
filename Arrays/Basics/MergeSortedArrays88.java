package Arrays.Basics;

/**
 * =======================================================
 * LeetCode 88 - Merge Sorted Array
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Arrays
 * Pattern    : Two Pointers
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * You are given two sorted integer arrays:
 *
 * nums1 of size m + n
 * nums2 of size n
 *
 * nums1 has enough extra space at the end to hold
 * all elements from nums2.
 *
 * Merge nums2 into nums1 so that nums1 becomes
 * one sorted array.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * nums1 = [1,2,3,0,0,0]
 * m = 3
 *
 * nums2 = [2,5,6]
 * n = 3
 *
 * Output:
 *
 * [1,2,2,3,5,6]
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Two Pointer Technique
 * ✓ Merging Sorted Arrays
 * ✓ In-place Modification
 * ✓ Reverse Traversal
 *
 */

public class MergeSortedArrays88 {

    /**
     * =======================================================
     * Approach 1 : Merge Using Extra Array
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * This is similar to the Merge step of Merge Sort.
     *
     * Create a new array.
     *
     * Compare the current elements of both arrays.
     *
     * Copy the smaller element into the answer array.
     *
     * After one array finishes,
     * copy the remaining elements.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums1 = [1,2,3]
     *
     * nums2 = [2,5,6]
     *
     * answer = []
     *
     * Compare
     *
     * 1 vs 2
     *
     * answer = [1]
     *
     * ------------------
     *
     * 2 vs 2
     *
     * answer = [1,2]
     *
     * ------------------
     *
     * 3 vs 2
     *
     * answer = [1,2,2]
     *
     * ------------------
     *
     * 3 vs 5
     *
     * answer = [1,2,2,3]
     *
     * Remaining:
     *
     * 5
     * 6
     *
     * Final:
     *
     * [1,2,2,3,5,6]
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Every element from both arrays
     * is visited exactly once.
     *
     * nums1 → m elements
     *
     * nums2 → n elements
     *
     * Total work:
     *
     * O(m + n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Extra array of size
     *
     * m + n
     *
     * Therefore:
     *
     * O(m + n)
     */

    public static void mergeWithExtraSpace(int[] nums1, int m,
                                           int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int k = 0;

        int[] answer = new int[m + n];

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {

                answer[k] = nums1[i];

                i++;
                k++;

            } else {

                answer[k] = nums2[j];

                j++;
                k++;
            }
        }

        // Copy remaining elements of nums1.
        while (i < m) {

            answer[k] = nums1[i];

            i++;
            k++;
        }

        // Copy remaining elements of nums2.
        while (j < n) {

            answer[k] = nums2[j];

            j++;
            k++;
        }

        print(answer);
    }

    /**
     * =======================================================
     * Approach 2 : In-place Merge (Optimal)
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * Two Pointers
     *
     * Reverse Traversal
     *
     * -------------------------------------------------------
     * Observation
     * -------------------------------------------------------
     *
     * nums1 already has enough empty space
     * at the end.
     *
     * If we start merging from the front,
     * elements will be overwritten.
     *
     * Instead,
     * start filling from the end.
     *
     * -------------------------------------------------------
     * Pointer Meaning
     * -------------------------------------------------------
     *
     * i
     *
     * Last valid element of nums1.
     *
     * j
     *
     * Last element of nums2.
     *
     * k
     *
     * Last position of nums1.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums1
     *
     * [1,2,3,0,0,0]
     *
     * nums2
     *
     * [2,5,6]
     *
     * i = 2
     *
     * j = 2
     *
     * k = 5
     *
     * ----------------------
     *
     * Compare
     *
     * 3 vs 6
     *
     * Place 6
     *
     * [1,2,3,0,0,6]
     *
     * ----------------------
     *
     * Compare
     *
     * 3 vs 5
     *
     * Place 5
     *
     * [1,2,3,0,5,6]
     *
     * ----------------------
     *
     * Compare
     *
     * 3 vs 2
     *
     * Place 3
     *
     * [1,2,3,3,5,6]
     *
     * ----------------------
     *
     * Compare
     *
     * 2 vs 2
     *
     * Place 2
     *
     * [1,2,2,3,5,6]
     *
     * Done.
     *
     * -------------------------------------------------------
     * Why Merge from the End?
     * -------------------------------------------------------
     *
     * Because the last positions are empty.
     *
     * We never overwrite useful values.
     *
     * -------------------------------------------------------
     * Time Complexity
     * -------------------------------------------------------
     *
     * Every element is processed once.
     *
     * O(m + n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * No extra array.
     *
     * Only pointer variables.
     *
     * O(1)
     */

    public static void mergeInplace(int[] nums1, int m,
                                    int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];

                i--;

            } else {

                nums1[k] = nums2[j];

                j--;
            }

            k--;
        }

        /**
         * IMPORTANT
         *
         * If nums2 still has remaining elements,
         * copy them.
         *
         * Remaining nums1 elements are already
         * in their correct position.
         */

        while (j >= 0) {

            nums1[k] = nums2[j];

            j--;
            k--;
        }

        print(nums1);
    }

    /**
     * Utility Method
     */
    public static void print(int[] arr) {

        for (int num : arr) {

            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        System.out.println("Merge Using Extra Space:");
        mergeWithExtraSpace(nums1, 3, nums2, 3);

        System.out.println();

        int[] nums3 = {1, 2, 3, 0, 0, 0};

        System.out.println("Merge In-place:");
        mergeInplace(nums3, 3, nums2, 3);
    }
}

/*
=========================================================
Mistakes I Made
=========================================================

1. Missing Remaining Elements of nums2

Original Code:

while(i >= 0 && j >= 0){
    ...
}

After the loop ends,

if nums2 still contains elements,
they must be copied.

Missing:

while(j >= 0){

    nums1[k] = nums2[j];

    j--;
    k--;
}

---------------------------------------------------------

Example

nums1 = [0]

m = 0

nums2 = [1]

Without this loop,

Result:

[0]

Correct:

[1]

---------------------------------------------------------

2. Printing Logic

Printing is better kept inside a
separate utility method.

=========================================================
Key Learnings
=========================================================

✓ Merge Sort merge logic can solve
the problem using extra space.

✓ The optimal solution works because
nums1 already has empty space at the end.

✓ Reverse traversal prevents overwriting
valid elements.

✓ Remaining elements of nums2 must always
be copied after the main loop.

✓ Remaining elements of nums1 never need
to be copied because they are already in
their correct positions.

=========================================================
Pattern Recognition
=========================================================

Whenever a problem involves:

• Two sorted arrays

• Merge two sequences

• In-place merging

• Backward traversal

Think:

✓ Two Pointers

✓ Reverse Traversal

Related Problems:

• Merge Intervals

• Merge Sorted Lists

• Merge k Sorted Lists

=========================================================
Interview Notes
=========================================================

Q1. Why merge from the end?

Because the end of nums1 contains empty
space.

This avoids overwriting useful values.

---------------------------------------------------------

Q2. Why only copy remaining nums2 elements?

If nums1 still has elements,

they are already in their correct positions.

Only nums2 elements may still need to be inserted.

---------------------------------------------------------

Q3. Which approach is preferred?

Approach 2.

Time : O(m + n)

Space : O(1)

It satisfies the interview requirement
of performing the merge in-place.

=========================================================
*/