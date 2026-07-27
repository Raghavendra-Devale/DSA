package Arrays.Medium;

/**
 * =======================================================
 * LeetCode 209 - Minimum Size Subarray Sum
 * =======================================================
 *
 * Difficulty : Medium
 * Topic      : Arrays
 * Pattern    : Variable-Size Sliding Window
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an array of positive integers nums and a positive
 * integer target, return the minimal length of a
 * contiguous subarray whose sum is greater than or equal
 * to target.
 *
 * If there is no such subarray, return 0.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * target = 7
 * nums = [2,3,1,2,4,3]
 *
 * Valid subarrays include:
 *
 * [2,3,1,2] -> sum = 8 -> length = 4
 * [3,1,2,4] -> sum = 10 -> length = 4
 * [1,2,4]   -> sum = 7 -> length = 3
 * [4,3]     -> sum = 7 -> length = 2
 *
 * Minimum length:
 *
 * 2
 *
 * Output:
 *
 * 2
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 *
 * ✓ Variable-Size Sliding Window
 * ✓ Expand window using right
 * ✓ Shrink window using left
 * ✓ Understand why while is needed
 * ✓ Calculate current window size
 * ✓ Understand the role of positive numbers
 *
 */

public class MinimumSizeSubarraySum209 {

    /**
     * =======================================================
     * Approach : Variable-Size Sliding Window
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * VARIABLE-SIZE SLIDING WINDOW
     *
     * -------------------------------------------------------
     * Main Idea
     * -------------------------------------------------------
     *
     * Unlike fixed-size Sliding Window problems,
     * we are NOT given the required window size.
     *
     * Instead, we must FIND the smallest window whose:
     *
     * sum >= target
     *
     * Therefore the window must be able to:
     *
     * EXPAND
     *
     * and
     *
     * SHRINK
     *
     * -------------------------------------------------------
     * Pointer Meaning
     * -------------------------------------------------------
     *
     * left
     *
     * → Beginning of current window.
     *
     * right
     *
     * → End of current window.
     *
     * windowSum
     *
     * → Sum of all elements between:
     *
     * left ... right
     *
     * -------------------------------------------------------
     * Core Strategy
     * -------------------------------------------------------
     *
     * EXPAND:
     *
     * Move right forward and add:
     *
     * nums[right]
     *
     * until:
     *
     * windowSum >= target
     *
     * Then:
     *
     * SHRINK:
     *
     * Move left forward while the window
     * is still valid.
     *
     * This helps us find the smallest possible
     * valid window.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * target = 7
     *
     * nums:
     *
     * [2,3,1,2,4,3]
     *
     * left = 0
     * windowSum = 0
     *
     * -------------------------------------------------------
     * right = 0
     * -------------------------------------------------------
     *
     * Add:
     *
     * 2
     *
     * window:
     *
     * [2]
     *
     * sum = 2
     *
     * 2 < 7
     *
     * Keep expanding.
     *
     * -------------------------------------------------------
     * right = 1
     * -------------------------------------------------------
     *
     * Add:
     *
     * 3
     *
     * window:
     *
     * [2,3]
     *
     * sum = 5
     *
     * Keep expanding.
     *
     * -------------------------------------------------------
     * right = 2
     * -------------------------------------------------------
     *
     * Add:
     *
     * 1
     *
     * window:
     *
     * [2,3,1]
     *
     * sum = 6
     *
     * Keep expanding.
     *
     * -------------------------------------------------------
     * right = 3
     * -------------------------------------------------------
     *
     * Add:
     *
     * 2
     *
     * window:
     *
     * [2,3,1,2]
     *
     * sum = 8
     *
     * Now:
     *
     * 8 >= 7
     *
     * VALID WINDOW.
     *
     * Size:
     *
     * right - left + 1
     *
     * 3 - 0 + 1
     *
     * = 4
     *
     * minSub = 4
     *
     * Now shrink.
     *
     * Remove nums[left]:
     *
     * Remove 2
     *
     * sum:
     *
     * 8 - 2 = 6
     *
     * left = 1
     *
     * Now:
     *
     * 6 < 7
     *
     * Stop shrinking.
     *
     * -------------------------------------------------------
     * right = 4
     * -------------------------------------------------------
     *
     * Add:
     *
     * 4
     *
     * Current window:
     *
     * [3,1,2,4]
     *
     * sum:
     *
     * 6 + 4 = 10
     *
     * Valid.
     *
     * size = 4
     *
     * minSub = 4
     *
     * SHRINK
     *
     * Remove 3.
     *
     * sum = 7
     *
     * left = 2
     *
     * Still valid!
     *
     * Current window:
     *
     * [1,2,4]
     *
     * size = 3
     *
     * minSub = 3
     *
     * SHRINK again.
     *
     * Remove 1.
     *
     * sum = 6
     *
     * Stop.
     *
     * -------------------------------------------------------
     * right = 5
     * -------------------------------------------------------
     *
     * Add:
     *
     * 3
     *
     * Current window:
     *
     * [2,4,3]
     *
     * sum:
     *
     * 9
     *
     * Valid.
     *
     * size = 3
     *
     * SHRINK
     *
     * Remove 2.
     *
     * sum = 7
     *
     * Current window:
     *
     * [4,3]
     *
     * size = 2
     *
     * minSub = 2
     *
     * SHRINK again.
     *
     * Remove 4.
     *
     * sum = 3
     *
     * Stop.
     *
     * Final answer:
     *
     * 2
     *
     * -------------------------------------------------------
     * Why WHILE Instead of IF?
     * -------------------------------------------------------
     *
     * This is one of the most important parts
     * of this problem.
     *
     * Suppose:
     *
     * windowSum = 10
     * target = 7
     *
     * Removing one element might produce:
     *
     * windowSum = 8
     *
     * But:
     *
     * 8 >= 7
     *
     * The smaller window is STILL valid.
     *
     * So we should continue shrinking.
     *
     * Using:
     *
     * if
     *
     * would shrink only once.
     *
     * Using:
     *
     * while
     *
     * keeps shrinking until the window
     * becomes invalid.
     *
     * -------------------------------------------------------
     * Why right - left + 1?
     * -------------------------------------------------------
     *
     * Suppose:
     *
     * left = 2
     * right = 4
     *
     * Indexes:
     *
     * 2, 3, 4
     *
     * Number of elements:
     *
     * 3
     *
     * Formula:
     *
     * right - left + 1
     *
     * =
     *
     * 4 - 2 + 1
     *
     * =
     *
     * 3
     *
     * -------------------------------------------------------
     * Why Integer.MAX_VALUE?
     * -------------------------------------------------------
     *
     * Initially we haven't found any valid
     * subarray.
     *
     * Therefore:
     *
     * minSub = Integer.MAX_VALUE
     *
     * guarantees that the first valid window
     * will replace it.
     *
     * At the end:
     *
     * if it is STILL Integer.MAX_VALUE,
     *
     * no valid window was ever found.
     *
     * Return:
     *
     * 0
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * At first glance we have:
     *
     * for (...)
     *
     *     while (...)
     *
     * This might LOOK like:
     *
     * O(n²)
     *
     * But it is NOT.
     *
     * Why?
     *
     * right only moves:
     *
     * 0 → n-1
     *
     * Therefore right moves at most n times.
     *
     * left also only moves:
     *
     * 0 → n-1
     *
     * Therefore left moves at most n times.
     *
     * Neither pointer ever moves backwards.
     *
     * Total pointer movements:
     *
     * n + n
     *
     * =
     *
     * 2n
     *
     * Drop constant:
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Extra variables:
     *
     * minSub
     * windowSum
     * left
     * right
     * windowSize
     *
     * No extra data structure.
     *
     * Therefore:
     *
     * O(1)
     */

    public static int minSubArrayLen(int target, int[] nums) {

        // Stores the minimum valid window size found.
        int minSub = Integer.MAX_VALUE;

        // Sum of the current window.
        int windowSum = 0;

        // Left boundary of the window.
        int left = 0;

        /**
         * right expands the window.
         */
        for (int right = 0; right < nums.length; right++) {

            // Add incoming element.
            windowSum += nums[right];

            /**
             * If the current window is valid,
             * keep shrinking it from the left.
             *
             * We continue while:
             *
             * windowSum >= target
             *
             * because we are searching for the
             * MINIMUM valid window.
             */
            while (windowSum >= target) {

                // Calculate current window size.
                int windowSize = right - left + 1;

                // Update minimum.
                minSub = Math.min(minSub, windowSize);

                // Remove outgoing element.
                windowSum -= nums[left];

                // Shrink window.
                left++;
            }
        }

        /**
         * If minSub was never updated,
         * no valid subarray exists.
         */
        return minSub == Integer.MAX_VALUE
                ? 0
                : minSub;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};

        int target = 7;

        System.out.println(
                "Minimum Subarray Length : "
                        + minSubArrayLen(target, nums)
        );
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Class Name Typo
---------------------------------------------------------

Current:

MinimumSizeSubarratSum209

Correct:

MinimumSizeSubarraySum209

"Subarrat" should be "Subarray".

=========================================================

2. Output Says "Brute force"
---------------------------------------------------------

Original:

System.out.println(
    "Brute force " + obj.minSubArrayLen(7, nums)
);

But this implementation is NOT brute force.

It is the optimal Sliding Window solution.

Better:

System.out.println(
    "Minimum Subarray Length : "
        + minSubArrayLen(target, nums)
);

=========================================================

3. Static vs Instance Method
---------------------------------------------------------

Your method was:

public int minSubArrayLen(...)

Therefore you needed:

MinimumSizeSubarratSum209 obj =
        new MinimumSizeSubarratSum209();

For these DSA utility classes, we can keep the
method static:

public static int minSubArrayLen(...)

Then call:

minSubArrayLen(target, nums);

This isn't an algorithmic issue, just cleaner
for the way we are organizing these files.

=========================================================
Key Learnings
=========================================================

✓ This is NOT fixed-size Sliding Window.

The window size is NOT given.

We need to discover the minimum size.

Therefore:

VARIABLE-SIZE SLIDING WINDOW.

---------------------------------------------------------

✓ right EXPANDS the window.

windowSum += nums[right];

---------------------------------------------------------

✓ left SHRINKS the window.

windowSum -= nums[left];

left++;

---------------------------------------------------------

✓ Expand until the condition becomes valid.

Then:

Shrink while it REMAINS valid.

---------------------------------------------------------

✓ The key condition is:

while (windowSum >= target)

NOT:

if (windowSum >= target)

Because one window may be shrinkable
multiple times.

=========================================================
Connection With Previous Sliding Window Problems
=========================================================

FIXED-SIZE WINDOW
---------------------------------------------------------

LeetCode 643:

Maximum Average Subarray I

Window size:

k

---------------------------------------------------------

LeetCode 1456:

Maximum Vowels in Substring

Window size:

k

---------------------------------------------------------

LeetCode 1343:

Subarrays Average >= Threshold

Window size:

k

---------------------------------------------------------

All three follow:

Build first k elements

↓

Remove i-k

↓

Add i

↓

Process window

=========================================================

VARIABLE-SIZE WINDOW
---------------------------------------------------------

LeetCode 209:

Minimum Size Subarray Sum

There is NO fixed window size.

Instead:

right expands

↓

condition becomes valid

↓

left shrinks

↓

keep shrinking while valid

This is a NEW Sliding Window variation.

=========================================================
Fixed vs Variable Sliding Window
=========================================================

FIXED SIZE:

Given:

"k"

Example:

Find maximum average subarray
of size k.

Movement:

REMOVE one
ADD one

Window always remains size k.

---------------------------------------------------------

VARIABLE SIZE:

No required window size.

Example:

Find smallest subarray with:

sum >= target

Movement:

EXPAND right

until condition is satisfied.

Then:

SHRINK left

while condition remains satisfied.

=========================================================
Variable Sliding Window Template
=========================================================

int left = 0;

for (int right = 0; right < nums.length; right++) {

    // 1. Add incoming element
    add(nums[right]);

    // 2. Shrink while condition allows
    while (condition) {

        // 3. Process current window
        updateAnswer();

        // 4. Remove outgoing element
        remove(nums[left]);

        left++;
    }
}

=========================================================
Pattern Recognition
=========================================================

Look for:

• Contiguous subarray / substring

AND something like:

• Minimum length

• Maximum length

• At least target

• At most target

• Condition-based window

AND:

Window size is NOT fixed.

Think:

VARIABLE-SIZE SLIDING WINDOW

=========================================================
Very Important Complexity Lesson
=========================================================

Code:

for (right = 0; right < n; right++) {

    while (...) {
        left++;
    }
}

DO NOT immediately conclude:

Nested loop = O(n²)

Ask:

How many TOTAL times can left move?

left starts:

0

and only moves forward.

It can move at most:

n times.

right can also move at most:

n times.

Therefore:

right movements + left movements

<=

n + n

=

2n

Therefore:

TC = O(n)

=========================================================
Why Positive Integers Matter
=========================================================

The problem guarantees positive integers.

This is VERY important.

When we add an element:

windowSum can only increase.

When we remove an element:

windowSum can only decrease.

Therefore we know exactly how to move
the window.

If negative numbers were allowed:

Adding could decrease the sum.

Removing could increase the sum.

Then this simple Sliding Window strategy
would not generally work.

=========================================================
Time Complexity
=========================================================

right:

Moves at most n times.

left:

Moves at most n times.

Total:

O(n + n)

=

O(2n)

=

O(n)

=========================================================
Space Complexity
=========================================================

Only constant variables are used.

SC:

O(1)

=========================================================
Interview Notes
=========================================================

Q1. How did you identify Sliding Window?

The problem asks about a contiguous subarray.

We need the minimum length satisfying:

sum >= target

The window size is variable.

Therefore:

Variable-Size Sliding Window.

---------------------------------------------------------

Q2. Why use while instead of if?

Because after removing one element,
the window may still satisfy:

sum >= target

We should continue shrinking to find
the smallest possible valid window.

---------------------------------------------------------

Q3. Why is the nested while not O(n²)?

Because left never resets.

Across the entire algorithm:

right moves at most n times.

left moves at most n times.

Therefore:

O(n).

---------------------------------------------------------

Q4. Why does this work with positive numbers?

Adding a positive number increases the sum.

Removing a positive number decreases the sum.

That monotonic behavior allows us to decide
when to expand and when to shrink.

---------------------------------------------------------

Q5. Optimal Complexity?

Time:

O(n)

Space:

O(1)

=========================================================
*/