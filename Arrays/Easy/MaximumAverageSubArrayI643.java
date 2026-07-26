package Arrays.Easy;

/**
 * =======================================================
 * LeetCode 643 - Maximum Average Subarray I
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Arrays
 * Pattern    : Fixed-Size Sliding Window
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an integer array nums consisting of n elements,
 * and an integer k,
 *
 * find a contiguous subarray whose length is exactly k
 * that has the maximum average value.
 *
 * Return this maximum average.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * nums = [1,12,-5,-6,50,3]
 * k = 4
 *
 * Possible windows:
 *
 * [1,12,-5,-6]
 * Sum = 2
 * Average = 2 / 4 = 0.5
 *
 * [12,-5,-6,50]
 * Sum = 51
 * Average = 51 / 4 = 12.75
 *
 * [-5,-6,50,3]
 * Sum = 42
 * Average = 42 / 4 = 10.5
 *
 * Maximum Average:
 *
 * 12.75
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ Understand fixed-size windows
 * ✓ Recognize repeated work in brute force
 * ✓ Learn Sliding Window
 * ✓ Remove the outgoing element
 * ✓ Add the incoming element
 * ✓ Derive TC and SC
 *
 */

public class MaximumAverageSubArrayI643 {

    /**
     * =======================================================
     * Approach 1 : Brute Force
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * Generate every possible subarray of size k.
     *
     * For every starting index:
     *
     * 1. Calculate the sum of the next k elements.
     * 2. Calculate the average.
     * 3. Compare it with the maximum average.
     *
     * -------------------------------------------------------
     * Number of Windows
     * -------------------------------------------------------
     *
     * Suppose:
     *
     * n = 6
     * k = 4
     *
     * Array:
     *
     * [1,12,-5,-6,50,3]
     *
     * Windows:
     *
     * Index 0 → 3
     * Index 1 → 4
     * Index 2 → 5
     *
     * Total:
     *
     * n - k + 1
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums = [1,12,-5,-6,50,3]
     *
     * k = 4
     *
     * Window 1:
     *
     * [1,12,-5,-6]
     *
     * sum = 2
     *
     * average = 0.5
     *
     * maxAverage = 0.5
     *
     * --------------------------------
     *
     * Window 2:
     *
     * [12,-5,-6,50]
     *
     * sum = 51
     *
     * average = 12.75
     *
     * maxAverage = 12.75
     *
     * --------------------------------
     *
     * Window 3:
     *
     * [-5,-6,50,3]
     *
     * sum = 42
     *
     * average = 10.5
     *
     * Final:
     *
     * 12.75
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Outer loop:
     *
     * Number of windows:
     *
     * n - k + 1
     *
     * Therefore:
     *
     * O(n - k + 1)
     *
     * Inner loop:
     *
     * For every window,
     * we visit exactly k elements.
     *
     * O(k)
     *
     * Combine:
     *
     * O((n - k + 1) * k)
     *
     * In simplified Big-O form:
     *
     * O(n * k)
     *
     * -------------------------------------------------------
     * Space Complexity Derivation
     * -------------------------------------------------------
     *
     * Extra variables:
     *
     * maxAvg
     * sum
     * average
     * i
     * j
     *
     * No extra array or collection.
     *
     * Therefore:
     *
     * O(1)
     */

    public static double findMaxAverage(int[] nums, int k) {

        // Stores the largest average found so far.
        double maxAvg = Double.NEGATIVE_INFINITY;

        /**
         * A valid window of size k can start only
         * until index:
         *
         * nums.length - k
         *
         * Number of windows:
         *
         * n - k + 1
         */
        for (int i = 0; i <= nums.length - k; i++) {

            int sum = 0;

            /**
             * Calculate the sum of the current
             * window of size k.
             */
            for (int j = i; j < i + k; j++) {

                sum += nums[j];
            }

            // Calculate average of current window.
            double average = (double) sum / k;

            // Keep the largest average.
            maxAvg = Math.max(maxAvg, average);
        }

        return maxAvg;
    }

    /**
     * =======================================================
     * Approach 2 : Fixed-Size Sliding Window (Optimal)
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * Fixed-Size Sliding Window
     *
     * -------------------------------------------------------
     * Main Observation
     * -------------------------------------------------------
     *
     * Look at two consecutive windows.
     *
     * Window 1:
     *
     * [1,12,-5,-6]
     *
     * Window 2:
     *
     * [12,-5,-6,50]
     *
     * Notice:
     *
     * 12
     * -5
     * -6
     *
     * exist in BOTH windows.
     *
     * Brute force calculates their sum again.
     *
     * That is repeated work.
     *
     * Instead:
     *
     * Previous Window:
     *
     * [1,12,-5,-6]
     *
     * Remove:
     *
     * 1
     *
     * Add:
     *
     * 50
     *
     * New Window:
     *
     * [12,-5,-6,50]
     *
     * Therefore:
     *
     * newWindowSum
     *
     * =
     *
     * oldWindowSum
     * - outgoing element
     * + incoming element
     *
     * -------------------------------------------------------
     * Algorithm
     * -------------------------------------------------------
     *
     * Step 1:
     *
     * Calculate the sum of the first k elements.
     *
     * Step 2:
     *
     * Store it as maxSum.
     *
     * Step 3:
     *
     * Start from index k.
     *
     * For every new element:
     *
     * Add:
     *
     * nums[i]
     *
     * Remove:
     *
     * nums[i - k]
     *
     * Step 4:
     *
     * Update maxSum.
     *
     * Step 5:
     *
     * Divide maxSum by k only once at the end.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * nums = [1,12,-5,-6,50,3]
     *
     * k = 4
     *
     * First Window:
     *
     * [1,12,-5,-6]
     *
     * windowSum:
     *
     * 1 + 12 - 5 - 6
     *
     * = 2
     *
     * maxSum = 2
     *
     * --------------------------------
     *
     * i = 4
     *
     * Incoming:
     *
     * nums[4] = 50
     *
     * Outgoing:
     *
     * nums[4 - 4]
     *
     * nums[0] = 1
     *
     * New sum:
     *
     * 2 + 50 - 1
     *
     * = 51
     *
     * maxSum:
     *
     * max(2,51)
     *
     * = 51
     *
     * --------------------------------
     *
     * i = 5
     *
     * Incoming:
     *
     * nums[5] = 3
     *
     * Outgoing:
     *
     * nums[5 - 4]
     *
     * nums[1] = 12
     *
     * New sum:
     *
     * 51 + 3 - 12
     *
     * = 42
     *
     * maxSum:
     *
     * max(51,42)
     *
     * = 51
     *
     * --------------------------------
     *
     * Final:
     *
     * maxSum = 51
     *
     * Average:
     *
     * 51 / 4
     *
     * = 12.75
     *
     * -------------------------------------------------------
     * Why Track maxSum Instead of maxAverage?
     * -------------------------------------------------------
     *
     * Every window has exactly the same size:
     *
     * k
     *
     * Therefore:
     *
     * If
     *
     * sumA > sumB
     *
     * then
     *
     * sumA / k > sumB / k
     *
     * So we don't need to calculate the average
     * for every window.
     *
     * Find the maximum sum first,
     * then divide only once.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * First loop:
     *
     * Processes k elements.
     *
     * O(k)
     *
     * Sliding Window loop:
     *
     * Processes remaining:
     *
     * n - k
     *
     * elements.
     *
     * O(n - k)
     *
     * Total:
     *
     * O(k + (n - k))
     *
     * Expand:
     *
     * O(k + n - k)
     *
     * k cancels:
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity Derivation
     * -------------------------------------------------------
     *
     * Extra variables:
     *
     * windowSum
     * maxSum
     * i
     *
     * No additional array or collection.
     *
     * Therefore:
     *
     * O(1)
     */

    public static double findMaxAverageOptimal(int[] nums, int k) {

        int windowSum = 0;

        /**
         * Build the first window.
         *
         * Window:
         *
         * nums[0 ... k-1]
         */
        for (int i = 0; i < k; i++) {

            windowSum += nums[i];
        }

        // First window is initially the maximum.
        int maxSum = windowSum;

        /**
         * Slide the window.
         *
         * nums[i]
         *      → incoming element
         *
         * nums[i - k]
         *      → outgoing element
         */
        for (int i = k; i < nums.length; i++) {

            // Add incoming element.
            windowSum += nums[i];

            // Remove outgoing element.
            windowSum -= nums[i - k];

            // Update maximum window sum.
            maxSum = Math.max(maxSum, windowSum);
        }

        /**
         * All windows have the same size k.
         *
         * Therefore we only need to calculate
         * the average once.
         */
        return (double) maxSum / k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};

        int k = 4;

        System.out.println(
                "Brute Force Average : "
                        + findMaxAverage(nums, k)
        );

        System.out.println(
                "Sliding Window Average : "
                        + findMaxAverageOptimal(nums, k)
        );
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Recalculating Sum in Every Window
---------------------------------------------------------

Brute force calculates:

Window 1:

[1,12,-5,-6]

Then Window 2:

[12,-5,-6,50]

Notice:

12
-5
-6

are processed again.

This repeated work can be avoided using
Sliding Window.

---------------------------------------------------------

2. Calculating Average for Every Window
---------------------------------------------------------

Brute Force:

average = (double) sum / k;

for every window.

But every window has the same denominator:

k

Therefore:

Largest Sum

also means

Largest Average.

So the optimal approach tracks:

maxSum

and divides only once at the end.

=========================================================
Key Learnings
=========================================================

✓ When a problem asks about a CONTIGUOUS
subarray of FIXED size k,

think:

FIXED-SIZE SLIDING WINDOW

---------------------------------------------------------

✓ Sliding Window avoids recalculating values
that were already calculated.

---------------------------------------------------------

✓ Moving a fixed-size window means:

ADD the incoming element.

REMOVE the outgoing element.

---------------------------------------------------------

Formula:

windowSum =
    windowSum
    + nums[i]
    - nums[i - k];

---------------------------------------------------------

✓ If every window has the same size,
comparing sums is enough.

No need to repeatedly calculate averages.

=========================================================
Pattern Recognition
=========================================================

Important words:

"contiguous"

"subarray"

"exactly k elements"

"window of size k"

"maximum/minimum sum"

"maximum/minimum average"

These should make you think:

FIXED-SIZE SLIDING WINDOW

---------------------------------------------------------

Typical Structure:

1. Build first window.

2. Store its result.

3. Start from index k.

4. Add incoming element.

5. Remove outgoing element.

6. Update answer.

=========================================================
Time Complexity Summary
=========================================================

Approach 1:

Number of windows:

n - k + 1

Work per window:

k

TC:

O((n - k + 1) * k)

Simplified:

O(n * k)

SC:

O(1)

---------------------------------------------------------

Approach 2:

First window:

O(k)

Remaining elements:

O(n - k)

Total:

O(k + n - k)

=

O(n)

SC:

O(1)

=========================================================
Interview Notes
=========================================================

Q1. How did you identify Sliding Window?

The problem asks for a contiguous subarray
of exactly k elements.

That is a strong indication of a fixed-size
Sliding Window problem.

---------------------------------------------------------

Q2. What repeated work exists in brute force?

Adjacent windows share k - 1 elements.

Brute force recalculates those elements.

Sliding Window reuses the previous sum.

---------------------------------------------------------

Q3. Why don't we calculate average every time?

All windows have the same size k.

Therefore comparing their sums produces
the same ordering as comparing averages.

---------------------------------------------------------

Q4. What is the key Sliding Window formula?

windowSum += nums[i];

windowSum -= nums[i - k];

---------------------------------------------------------

Q5. Optimal Complexity?

Time:

O(n)

Space:

O(1)

=========================================================
*/