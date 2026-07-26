package Strings.medium;

/**
 * =======================================================
 * LeetCode 1456 - Maximum Number of Vowels in a
 *                  Substring of Given Length
 * =======================================================
 *
 * Difficulty : Medium
 * Topic      : Strings
 * Pattern    : Fixed-Size Sliding Window
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given a string s and an integer k, return the maximum
 * number of vowel letters in any substring of s with
 * length k.
 *
 * Vowels are:
 *
 * a, e, i, o, u
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * s = "abciiidef"
 * k = 3
 *
 * Substrings of size 3:
 *
 * "abc"  -> 1 vowel
 * "bci"  -> 1 vowel
 * "cii"  -> 2 vowels
 * "iii"  -> 3 vowels
 * "iid"  -> 2 vowels
 * "ide"  -> 2 vowels
 * "def"  -> 1 vowel
 *
 * Maximum = 3
 *
 * Output:
 *
 * 3
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 *
 * ✓ Recognize a fixed-size sliding window problem.
 * ✓ Understand repeated work in brute force.
 * ✓ Build the first window separately.
 * ✓ Remove the outgoing character.
 * ✓ Add the incoming character.
 * ✓ Understand the i - k formula.
 * ✓ Derive TC and SC correctly.
 *
 */

public class MaxVowelsInASubString1456 {

    /**
     * =======================================================
     * Approach 1 : Brute Force
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * Generate every possible substring of length k.
     *
     * For each substring:
     *
     * 1. Traverse all k characters.
     * 2. Count how many are vowels.
     * 3. Update the maximum.
     *
     * -------------------------------------------------------
     * Number of Windows
     * -------------------------------------------------------
     *
     * For a string of length n and window size k:
     *
     * Number of windows:
     *
     * n - k + 1
     *
     * Example:
     *
     * n = 5
     * k = 3
     *
     * abcde
     *
     * Windows:
     *
     * abc
     * bcd
     * cde
     *
     * Total:
     *
     * 5 - 3 + 1
     *
     * = 3
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Outer loop:
     *
     * n - k + 1 windows
     *
     * Inner loop:
     *
     * k characters for every window
     *
     * Total:
     *
     * (n - k + 1) * k
     *
     * Therefore:
     *
     * O(n * k)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Only variables are used.
     *
     * No additional array, StringBuilder,
     * HashMap, HashSet, etc.
     *
     * Therefore:
     *
     * O(1)
     */

    public static int maxVowelsBrute(String s, int k) {

        int maxVowels = 0;

        /**
         * IMPORTANT:
         *
         * The <= is required.
         *
         * Last valid starting index:
         *
         * s.length() - k
         *
         * Example:
         *
         * n = 5
         * k = 3
         *
         * Valid starting indexes:
         *
         * 0
         * 1
         * 2
         *
         * n - k = 2
         *
         * Therefore index 2 must also be processed.
         */
        for (int i = 0; i <= s.length() - k; i++) {

            int vowels = 0;

            // Check all k characters of current window.
            for (int j = i; j < i + k; j++) {

                if (isVowel(s.charAt(j))) {
                    vowels++;
                }
            }

            maxVowels = Math.max(maxVowels, vowels);
        }

        return maxVowels;
    }

    /**
     * =======================================================
     * Approach 2 : Fixed-Size Sliding Window (Optimal)
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * FIXED-SIZE SLIDING WINDOW
     *
     * -------------------------------------------------------
     * Main Observation
     * -------------------------------------------------------
     *
     * Consecutive substrings of size k share
     * k - 1 characters.
     *
     * Example:
     *
     * s = "abcdef"
     * k = 3
     *
     * Window 1:
     *
     * [a b c]
     *
     * Window 2:
     *
     *   [b c d]
     *
     * Characters:
     *
     * b and c
     *
     * exist in both windows.
     *
     * Brute force checks them again.
     *
     * Sliding Window avoids this repeated work.
     *
     * -------------------------------------------------------
     * Sliding Window Rule
     * -------------------------------------------------------
     *
     * When moving the window one position:
     *
     * REMOVE:
     *
     * Character leaving from the left.
     *
     * ADD:
     *
     * Character entering from the right.
     *
     * -------------------------------------------------------
     * Pointer / Index Meaning
     * -------------------------------------------------------
     *
     * i
     *
     * represents the NEW character entering
     * the window.
     *
     * i - k
     *
     * represents the OLD character leaving
     * the window.
     *
     * -------------------------------------------------------
     * Why i - k?
     * -------------------------------------------------------
     *
     * Suppose:
     *
     * k = 3
     *
     * Initial window:
     *
     * indexes
     *
     * 0 1 2
     *
     * When:
     *
     * i = 3
     *
     * index 3 enters.
     *
     * Which index leaves?
     *
     * i - k
     *
     * = 3 - 3
     *
     * = 0
     *
     * Therefore:
     *
     * Incoming:
     *
     * s.charAt(i)
     *
     * Outgoing:
     *
     * s.charAt(i - k)
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * s = "abciiidef"
     *
     * k = 3
     *
     * --------------------------------
     * Build First Window
     * --------------------------------
     *
     * "abc"
     *
     * a -> vowel
     * b -> not vowel
     * c -> not vowel
     *
     * windowVowels = 1
     *
     * maxVowels = 1
     *
     * --------------------------------
     * Slide Window
     * --------------------------------
     *
     * New window:
     *
     * "bci"
     *
     * Outgoing:
     *
     * a
     *
     * a is vowel:
     *
     * windowVowels--
     *
     * 1 -> 0
     *
     * Incoming:
     *
     * i
     *
     * i is vowel:
     *
     * windowVowels++
     *
     * 0 -> 1
     *
     * maxVowels = 1
     *
     * --------------------------------
     *
     * New window:
     *
     * "cii"
     *
     * Outgoing:
     *
     * b
     *
     * No change.
     *
     * Incoming:
     *
     * i
     *
     * windowVowels:
     *
     * 1 -> 2
     *
     * maxVowels = 2
     *
     * --------------------------------
     *
     * New window:
     *
     * "iii"
     *
     * Outgoing:
     *
     * c
     *
     * No change.
     *
     * Incoming:
     *
     * i
     *
     * windowVowels:
     *
     * 2 -> 3
     *
     * maxVowels = 3
     *
     * --------------------------------
     *
     * Maximum possible answer is k.
     *
     * Since:
     *
     * maxVowels == k
     *
     * we can immediately return k.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * First loop:
     *
     * Builds first window.
     *
     * Runs k times.
     *
     * O(k)
     *
     * Second loop:
     *
     * Processes remaining:
     *
     * n - k
     *
     * characters.
     *
     * O(n - k)
     *
     * Total:
     *
     * O(k + (n - k))
     *
     * =
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Variables:
     *
     * windowVowels
     * maxVowels
     * i
     *
     * No growing data structure.
     *
     * Therefore:
     *
     * O(1)
     */

    public static int maxVowelsOpti(String s, int k) {

        int windowVowels = 0;

        /**
         * Step 1:
         *
         * Build the first window:
         *
         * indexes 0 to k - 1.
         */
        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))) {
                windowVowels++;
            }
        }

        int maxVowels = windowVowels;

        /**
         * Maximum possible vowels in a window
         * of size k is k itself.
         *
         * If first window already contains k vowels,
         * we cannot improve the answer.
         */
        if (maxVowels == k) {
            return k;
        }

        /**
         * Step 2:
         *
         * Slide the window.
         *
         * i:
         * incoming character
         *
         * i - k:
         * outgoing character
         */
        for (int i = k; i < s.length(); i++) {

            /**
             * Remove the character that is leaving
             * the left side of the window.
             */
            if (isVowel(s.charAt(i - k))) {
                windowVowels--;
            }

            /**
             * Add the new character entering
             * from the right.
             */
            if (isVowel(s.charAt(i))) {
                windowVowels++;
            }

            maxVowels = Math.max(maxVowels, windowVowels);

            /**
             * Early Exit Optimization
             *
             * A window of size k cannot contain
             * more than k vowels.
             *
             * Therefore if we reach k,
             * this is already the best possible answer.
             */
            if (maxVowels == k) {
                return k;
            }
        }

        return maxVowels;
    }

    /**
     * =======================================================
     * Helper Method
     * =======================================================
     *
     * Returns true when the character is a vowel.
     *
     * The problem guarantees lowercase English letters,
     * so checking lowercase vowels is sufficient.
     *
     * Time Complexity:
     *
     * O(1)
     *
     * Space Complexity:
     *
     * O(1)
     */

    public static boolean isVowel(char ch) {

        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }

    public static void main(String[] args) {

        String s = "weallloveyou";

        int k = 3;

        System.out.println(
                "Brute Force : "
                        + maxVowelsBrute(s, k)
        );

        System.out.println(
                "Optimal     : "
                        + maxVowelsOpti(s, k)
        );
    }
}

/*
=========================================================
Mistakes I Made
=========================================================

1. Missed '=' in Brute Force Loop
---------------------------------------------------------

Initially:

i < s.length() - k

Correct:

i <= s.length() - k

Why?

The final valid window starts exactly at:

s.length() - k

Without '=', the last window is skipped.

---------------------------------------------------------

Example:

s = "abcde"

k = 3

Valid windows:

abc
bcd
cde

Starting indexes:

0
1
2

s.length() - k:

5 - 3 = 2

Therefore index 2 must be included.

=========================================================

2. Removed the Wrong Character
---------------------------------------------------------

Initially, while sliding, I checked:

s.charAt(i)

for removing a vowel.

But:

i

represents the NEW character entering the window.

The outgoing character is:

i - k

Correct:

if (isVowel(s.charAt(i - k))) {
    windowVowels--;
}

=========================================================

3. Mistook i + k for Incoming Character
---------------------------------------------------------

The second loop already starts at:

i = k

Therefore:

s.charAt(i)

is the new character entering the window.

Using:

i + k

would jump ahead and can eventually cause:

StringIndexOutOfBoundsException

Correct:

s.charAt(i)

=========================================================
Key Learnings
=========================================================

✓ When a problem says:

"substring of length k"

or

"subarray of size k"

think:

FIXED-SIZE SLIDING WINDOW

---------------------------------------------------------

✓ Build the first window separately.

---------------------------------------------------------

✓ When sliding:

REMOVE outgoing element.

ADD incoming element.

---------------------------------------------------------

✓ If i is the incoming index:

Outgoing index:

i - k

Incoming index:

i

---------------------------------------------------------

✓ Sliding Window avoids recalculating the
entire window.

=========================================================
Connection With Maximum Average Subarray I
=========================================================

Maximum Average Subarray:

Maintain:

windowSum

When sliding:

windowSum -= nums[i - k];

windowSum += nums[i];

---------------------------------------------------------

Maximum Vowels:

Maintain:

windowVowels

When sliding:

if (isVowel(s.charAt(i - k)))
    windowVowels--;

if (isVowel(s.charAt(i)))
    windowVowels++;

---------------------------------------------------------

THE PATTERN IS THE SAME.

Only the information maintained inside
the window has changed.

Maximum Average:

Maintain SUM.

Maximum Vowels:

Maintain COUNT.

This is the important Sliding Window insight.

=========================================================
Pattern Recognition
=========================================================

Look for words such as:

• Subarray

• Substring

• Contiguous

• Exactly k

• Size k

• Length k

• Maximum / Minimum within k elements

Strong signal:

FIXED-SIZE SLIDING WINDOW

---------------------------------------------------------

Template:

// Build first window

for (int i = 0; i < k; i++) {

    // Add nums[i]
}

// Slide

for (int i = k; i < n; i++) {

    // Remove i - k

    // Add i

    // Update answer
}

=========================================================
Time Complexity Summary
=========================================================

BRUTE FORCE

Number of windows:

n - k + 1

Characters checked per window:

k

TC:

O((n - k + 1) * k)

Simplified:

O(n * k)

SC:

O(1)

---------------------------------------------------------

SLIDING WINDOW

Build first window:

O(k)

Slide remaining:

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

Q1. Why is brute force slow?

Because consecutive windows share most of
their characters.

Brute force recounts them every time.

---------------------------------------------------------

Q2. What does Sliding Window reuse?

The count from the previous window.

Only two things change:

One character leaves.

One character enters.

---------------------------------------------------------

Q3. Why i - k?

Because when index i enters a window of
size k, the character k positions behind
it must leave.

---------------------------------------------------------

Q4. Can we optimize further?

Yes.

The maximum possible answer is:

k

If:

maxVowels == k

we can immediately return because no
future window can produce a better answer.

---------------------------------------------------------

Q5. Optimal Complexity?

Time:

O(n)

Space:

O(1)

=========================================================
*/