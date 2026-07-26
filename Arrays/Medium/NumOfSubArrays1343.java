package Arrays.Medium;

/**
 * =======================================================
 * LeetCode 1343 - Number of Sub-arrays of Size K
 *                  and Average >= Threshold
 * =======================================================
 *
 * Difficulty : Medium
 * Topic      : Arrays
 * Pattern    : Fixed-Size Sliding Window
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an integer array arr and two integers k and
 * threshold, return the number of contiguous subarrays
 * of size k whose average is greater than or equal to
 * threshold.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * arr = [2,2,2,2,5,5,5,8]
 * k = 3
 * threshold = 4
 *
 * Windows:
 *
 * [2,2,2] -> sum = 6  -> average = 2
 * [2,2,2] -> sum = 6  -> average = 2
 * [2,2,5] -> sum = 9  -> average = 3
 * [2,5,5] -> sum = 12 -> average = 4  ✓
 * [5,5,5] -> sum = 15 -> average = 5  ✓
 * [5,5,8] -> sum = 18 -> average = 6  ✓
 *
 * Answer = 3
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 *
 * ✓ Fixed-Size Sliding Window
 * ✓ Reuse previous window sum
 * ✓ Count windows satisfying a condition
 * ✓ Avoid unnecessary division
 * ✓ Recognize similarity with LeetCode 643
 *
 */

public class NumOfSubArrays1343 {

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
     * For each window:
     *
     * 1. Calculate its sum.
     * 2. Calculate its average.
     * 3. Check whether average >= threshold.
     * 4. Increase count if condition is satisfied.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Number of windows:
     *
     * n - k + 1
     *
     * For every window we process:
     *
     * k elements
     *
     * Therefore:
     *
     * O((n - k + 1) * k)
     *
     * Simplified:
     *
     * O(n * k)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Only variables are used.
     *
     * O(1)
     */

    public static int numOfSubarraysBrute(
            int[] arr,
            int k,
            int threshold) {

        int count = 0;

        // Generate every possible window of size k.
        for (int i = 0; i <= arr.length - k; i++) {

            int sum = 0;

            // Calculate current window sum.
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            // Calculate current window average.
            double average = (double) sum / k;

            // Count windows satisfying the condition.
            if (average >= threshold) {
                count++;
            }
        }

        return count;
    }

    /**
     * =======================================================
     * Approach 2 : Fixed-Size Sliding Window
     * =======================================================
     *
     * This is the SAME core pattern as LeetCode 643.
     *
     * -------------------------------------------------------
     * Main Observation
     * -------------------------------------------------------
     *
     * Adjacent windows share k - 1 elements.
     *
     * Example:
     *
     * [2,2,5]
     *
     * becomes
     *
     *   [2,5,5]
     *
     * Instead of recalculating:
     *
     * 2 + 5 + 5
     *
     * we reuse the previous window sum.
     *
     * -------------------------------------------------------
     * Sliding Formula
     * -------------------------------------------------------
     *
     * Remove outgoing:
     *
     * arr[i - k]
     *
     * Add incoming:
     *
     * arr[i]
     *
     * Therefore:
     *
     * windowSum =
     *      windowSum
     *      - arr[i - k]
     *      + arr[i]
     *
     * -------------------------------------------------------
     * Important Learning
     * -------------------------------------------------------
     *
     * Each sliding window produces a result.
     *
     * Therefore the condition:
     *
     * average >= threshold
     *
     * must be checked INSIDE the sliding loop
     * for every newly created window.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Build first window:
     *
     * O(k)
     *
     * Process remaining elements:
     *
     * O(n - k)
     *
     * Total:
     *
     * O(k + n - k)
     *
     * =
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * O(1)
     */

    public static int numOfSubarraysOpti(
            int[] arr,
            int k,
            int threshold) {

        int count = 0;
        int windowSum = 0;

        // Build the first window.
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Process the first window.
        if ((double) windowSum / k >= threshold) {
            count++;
        }

        // Slide through the remaining windows.
        for (int i = k; i < arr.length; i++) {

            // Remove outgoing element.
            windowSum -= arr[i - k];

            // Add incoming element.
            windowSum += arr[i];

            // Every new window must be checked.
            double average = (double) windowSum / k;

            if (average >= threshold) {
                count++;
            }
        }

        return count;
    }

    /**
     * =======================================================
     * Approach 3 : Sliding Window Without Division
     * =======================================================
     *
     * We can improve the condition itself.
     *
     * Current condition:
     *
     * windowSum / k >= threshold
     *
     * Multiply both sides by k:
     *
     * windowSum >= threshold * k
     *
     * Therefore we don't need:
     *
     * • double
     * • division
     * • average variable
     *
     * -------------------------------------------------------
     * Example
     * -------------------------------------------------------
     *
     * k = 3
     * threshold = 4
     *
     * Required average:
     *
     * >= 4
     *
     * Equivalent required sum:
     *
     * >= 4 * 3
     *
     * >= 12
     *
     * So:
     *
     * [2,5,5]
     *
     * sum = 12
     *
     * 12 >= 12
     *
     * ✓ Valid
     *
     * -------------------------------------------------------
     * Time Complexity
     * -------------------------------------------------------
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * O(1)
     */

    public static int numOfSubarraysOptimal(
            int[] arr,
            int k,
            int threshold) {

        int windowSum = 0;
        int count = 0;

        // Minimum sum required for a valid window.
        int requiredSum = threshold * k;

        // Build first window.
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Check first window.
        if (windowSum >= requiredSum) {
            count++;
        }

        // Slide the window.
        for (int i = k; i < arr.length; i++) {

            // Remove outgoing element.
            windowSum -= arr[i - k];

            // Add incoming element.
            windowSum += arr[i];

            // Check current window.
            if (windowSum >= requiredSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 2, 5, 5, 5, 8};

        int k = 3;
        int threshold = 4;

        System.out.println(
                "Brute Force : "
                        + numOfSubarraysBrute(nums, k, threshold)
        );

        System.out.println(
                "Sliding Window : "
                        + numOfSubarraysOpti(nums, k, threshold)
        );

        System.out.println(
                "Optimal without division : "
                        + numOfSubarraysOptimal(nums, k, threshold)
        );
    }
}

/*
=========================================================
Mistakes I Made
=========================================================

1. Processing the Window Result Outside the Loop
---------------------------------------------------------

Each time the window slides, a NEW window is created.

Therefore each new window must immediately
be checked.

Wrong thinking:

Slide all windows first.

Then check the condition.

Correct thinking:

SLIDE
↓
PROCESS CURRENT WINDOW
↓
SLIDE
↓
PROCESS CURRENT WINDOW

So this belongs inside the loop:

if (average >= threshold) {
    count++;
}

=========================================================
Improvement
=========================================================

Average calculation is unnecessary.

Instead of:

double average = (double) windowSum / k;

if (average >= threshold)

We can use:

if (windowSum >= threshold * k)

Why?

windowSum / k >= threshold

Multiply both sides by k:

windowSum >= threshold * k

This removes floating-point calculations.

=========================================================
Connection With LeetCode 643
=========================================================

YES — THIS IS THE SAME CORE PROBLEM PATTERN.

---------------------------------------------------------

LeetCode 643
Maximum Average Subarray I

Goal:

Find ONE maximum window.

Maintain:

windowSum

For every window:

maxSum = Math.max(maxSum, windowSum);

---------------------------------------------------------

LeetCode 1343
Number of Sub-arrays With Average >= Threshold

Goal:

COUNT qualifying windows.

Maintain:

windowSum

For every window:

if (windowSum >= requiredSum) {
    count++;
}

---------------------------------------------------------

Everything else is almost identical.

643:

BUILD FIRST WINDOW
↓
SLIDE
↓
REMOVE LEFT
↓
ADD RIGHT
↓
UPDATE MAXIMUM

1343:

BUILD FIRST WINDOW
↓
CHECK CONDITION
↓
SLIDE
↓
REMOVE LEFT
↓
ADD RIGHT
↓
CHECK CONDITION
↓
INCREASE COUNT

=========================================================
Fixed Sliding Window Template
=========================================================

int windowValue = 0;

// 1. Build first window
for (int i = 0; i < k; i++) {

    windowValue += arr[i];
}

// 2. Process first window

process(windowValue);

// 3. Slide remaining windows
for (int i = k; i < arr.length; i++) {

    // Remove outgoing
    windowValue -= arr[i - k];

    // Add incoming
    windowValue += arr[i];

    // Process CURRENT window
    process(windowValue);
}

=========================================================
Key Learnings
=========================================================

✓ Contiguous subarray of exactly size k

Strong signal:

FIXED-SIZE SLIDING WINDOW

---------------------------------------------------------

✓ arr[i]

Incoming element.

---------------------------------------------------------

✓ arr[i - k]

Outgoing element.

---------------------------------------------------------

✓ Each new window should be processed
immediately after updating it.

---------------------------------------------------------

✓ What we DO with the window depends on
the problem.

643:

Find maximum.

1343:

Count valid windows.

1456:

Count vowels and find maximum.

The sliding mechanism itself stays the same.

=========================================================
Pattern Recognition
=========================================================

You have now seen the same pattern in:

LeetCode 643
Maximum Average Subarray I

Maintain:

SUM

Goal:

MAXIMUM

---------------------------------------------------------

LeetCode 1456
Maximum Vowels in Substring

Maintain:

VOWEL COUNT

Goal:

MAXIMUM

---------------------------------------------------------

LeetCode 1343
Subarrays With Average >= Threshold

Maintain:

SUM

Goal:

COUNT VALID WINDOWS

---------------------------------------------------------

Same window mechanics.

Different information / result.

=========================================================
Time Complexity Summary
=========================================================

BRUTE FORCE

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

SLIDING WINDOW

First window:

O(k)

Remaining:

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

Q1. How do you recognize this as Sliding Window?

The problem asks about:

CONTIGUOUS SUBARRAYS

with:

EXACTLY k ELEMENTS

That strongly indicates fixed-size
Sliding Window.

---------------------------------------------------------

Q2. What's different from LeetCode 643?

The window movement is the same.

643 asks:

"What is the maximum?"

1343 asks:

"How many satisfy this condition?"

---------------------------------------------------------

Q3. Why can we avoid calculating average?

Because:

sum / k >= threshold

is equivalent to:

sum >= threshold * k

---------------------------------------------------------

Q4. Optimal Complexity?

Time:

O(n)

Space:

O(1)

=========================================================
*/