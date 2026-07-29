package Strings.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * =======================================================
 * LeetCode 3 - Longest Substring Without Repeating Characters
 * =======================================================
 *
 * Difficulty : Medium
 * Topic      : Strings
 * Pattern    : Variable-Size Sliding Window
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 * A substring is a contiguous sequence of characters.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * "abcabcbb"
 *
 * Possible substrings:
 *
 * "abc"      -> length = 3
 * "bca"      -> length = 3
 * "cab"      -> length = 3
 * "abc"      -> length = 3
 * "bc"       -> length = 2
 * "cb"       -> length = 2
 * "bb"       -> invalid (duplicate)
 *
 * Output:
 *
 * 3
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 *
 * ✓ Variable-Size Sliding Window
 * ✓ HashSet
 * ✓ Expand and Shrink Window
 * ✓ Remove Duplicates
 * ✓ Longest Valid Window
 *
 */

public class LongestSubstringWithoutRepeatedChars3 {

    /**
     * =======================================================
     * Approach 1 : Brute Force
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * Start every possible substring.
     *
     * Keep extending it until
     * a duplicate character appears.
     *
     * A HashSet stores characters already
     * present in the current substring.
     *
     * If a duplicate appears,
     * stop exploring that substring.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * s = "abcabcbb"
     *
     * Start at index 0:
     *
     * "a"
     * "ab"
     * "abc"
     *
     * Next character:
     *
     * a
     *
     * Already present.
     *
     * Stop.
     *
     * Maximum = 3
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Outer loop:
     *
     * Starts from every character.
     *
     * O(n)
     *
     * Inner loop:
     *
     * Can visit remaining characters.
     *
     * Worst case:
     *
     * O(n)
     *
     * Total:
     *
     * O(n × n)
     *
     * =
     *
     * O(n²)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * HashSet stores current substring.
     *
     * Worst case:
     *
     * O(n)
     */

    public static int lengthOfLongestSubstringBrute(String s) {

        int maxLength = 0;

        // Try every starting index.
        for (int i = 0; i < s.length(); i++) {

            Set<Character> seen = new HashSet<>();

            // Extend the substring.
            for (int j = i; j < s.length(); j++) {

                // Duplicate found.
                if (seen.contains(s.charAt(j))) {
                    break;
                }

                // Add current character.
                seen.add(s.charAt(j));

                // Update maximum length.
                maxLength = Math.max(maxLength,
                        j - i + 1);
            }
        }

        return maxLength;
    }

    /**
     * =======================================================
     * Approach 2 : Variable-Size Sliding Window (Optimal)
     * =======================================================
     *
     * Pattern
     * -------------------------------------------------------
     *
     * Variable-Size Sliding Window
     *
     * -------------------------------------------------------
     * Main Observation
     * -------------------------------------------------------
     *
     * We need the LONGEST substring
     * that satisfies:
     *
     * "No duplicate characters."
     *
     * Therefore:
     *
     * Expand the window while it remains valid.
     *
     * If a duplicate appears,
     * shrink the window until it becomes
     * valid again.
     *
     * -------------------------------------------------------
     * Pointer Meaning
     * -------------------------------------------------------
     *
     * left
     *
     * Beginning of current window.
     *
     * right
     *
     * Character entering the window.
     *
     * seen
     *
     * Stores all characters currently
     * inside the window.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * s = "abcabcbb"
     *
     * --------------------------------
     * right = 0
     * --------------------------------
     *
     * Window:
     *
     * "a"
     *
     * seen:
     *
     * {a}
     *
     * max = 1
     *
     * --------------------------------
     * right = 1
     * --------------------------------
     *
     * Window:
     *
     * "ab"
     *
     * seen:
     *
     * {a,b}
     *
     * max = 2
     *
     * --------------------------------
     * right = 2
     * --------------------------------
     *
     * Window:
     *
     * "abc"
     *
     * seen:
     *
     * {a,b,c}
     *
     * max = 3
     *
     * --------------------------------
     * right = 3
     * --------------------------------
     *
     * Character:
     *
     * a
     *
     * Duplicate!
     *
     * Shrink:
     *
     * Remove left:
     *
     * a
     *
     * left++
     *
     * Duplicate removed.
     *
     * Add current a.
     *
     * Window:
     *
     * "bca"
     *
     * max remains 3.
     *
     * Continue.
     *
     * -------------------------------------------------------
     * Why WHILE instead of IF?
     * -------------------------------------------------------
     *
     * Suppose:
     *
     * Window:
     *
     * "abca"
     *
     * right points to:
     *
     * second 'a'
     *
     * Removing one character
     * may NOT remove the duplicate.
     *
     * Therefore:
     *
     * Continue shrinking until:
     *
     * duplicate no longer exists.
     *
     * Hence:
     *
     * while
     *
     * instead of:
     *
     * if
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * At first glance:
     *
     * for + while
     *
     * may look like:
     *
     * O(n²)
     *
     * But:
     *
     * right moves only forward.
     *
     * Maximum:
     *
     * n moves.
     *
     * left also moves only forward.
     *
     * Maximum:
     *
     * n moves.
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
     * HashSet stores characters
     * currently inside the window.
     *
     * Worst case:
     *
     * O(n)
     */

    public static int lengthOfLongestSubstringSlidingWindow(String s) {

        // Longest valid substring.
        int maxLength = 0;

        // Left boundary.
        int left = 0;

        // Characters currently in window.
        Set<Character> seen = new HashSet<>();

        // Expand window.
        for (int right = 0; right < s.length(); right++) {

            /**
             * Duplicate found.
             *
             * Keep shrinking until
             * duplicate disappears.
             */
            while (seen.contains(s.charAt(right))) {

                seen.remove(s.charAt(left));

                left++;
            }

            // Add current character.
            seen.add(s.charAt(right));

            // Update answer.
            maxLength = Math.max(
                    maxLength,
                    right - left + 1
            );
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(
                "Brute Force : "
                        + lengthOfLongestSubstringBrute(s)
        );

        System.out.println(
                "Sliding Window : "
                        + lengthOfLongestSubstringSlidingWindow(s)
        );
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Time Complexity Misconception
---------------------------------------------------------

The optimal solution contains:

for

and

while

But it is NOT O(n²).

Reason:

left never moves backwards.

right never moves backwards.

Each pointer moves at most n times.

Therefore:

O(n)

=========================================================

2. Why WHILE Instead of IF?
---------------------------------------------------------

Suppose:

Window:

"abca"

right points to:

'a'

Duplicate exists.

Removing only one character
(using if)

may not eliminate the duplicate.

while continues shrinking until
the window becomes valid again.

=========================================================
Key Learnings
=========================================================

✓ This is a Variable-Size Sliding Window.

---------------------------------------------------------

✓ Expand using:

right++

---------------------------------------------------------

✓ Shrink using:

left++

---------------------------------------------------------

✓ Maintain a HashSet containing
characters currently inside the window.

---------------------------------------------------------

✓ Window is valid only when:

No duplicate characters exist.

=========================================================
Connection With LeetCode 209
=========================================================

LeetCode 209

Condition:

windowSum >= target

Shrink while condition is TRUE.

---------------------------------------------------------

LeetCode 3

Condition:

Duplicate character exists.

Shrink while condition is TRUE.

---------------------------------------------------------

The pattern is IDENTICAL.

Only the condition changes.

209:

Maintain SUM.

3:

Maintain CHARACTER SET.

=========================================================
Pattern Recognition
=========================================================

Fixed Sliding Window

Problems:

643

1456

1343

Window size:

Fixed

---------------------------------------------------------

Variable Sliding Window

Problems:

209

3

Window grows.

Window shrinks.

Window size changes dynamically.

=========================================================
Variable Sliding Window Template
=========================================================

left = 0

for(right = 0; right < n; right++){

    // Expand

    while(window invalid){

        // Shrink

        left++;
    }

    // Process current window
}

=========================================================
Time Complexity Summary
=========================================================

Brute Force

Outer:

O(n)

Inner:

O(n)

Total:

O(n²)

SC:

O(n)

---------------------------------------------------------

Sliding Window

left:

Moves at most n times.

right:

Moves at most n times.

TC:

O(n)

SC:

O(n)

=========================================================
Interview Notes
=========================================================

Q1. Why use HashSet?

HashSet provides:

contains()

add()

remove()

Average:

O(1)

making duplicate detection efficient.

---------------------------------------------------------

Q2. Why is this Variable Sliding Window?

The window size is not fixed.

It expands and shrinks based on whether
duplicates exist.

---------------------------------------------------------

Q3. Why is the optimal solution O(n)?

Both pointers move only forward.

Each pointer visits each character
at most once.

Total work:

O(n)

---------------------------------------------------------

Q4. Can Space be O(1)?

For general Unicode strings, no.

The HashSet may grow with the number of
distinct characters.

For lowercase English letters only,
space would effectively be constant.

=========================================================
*/