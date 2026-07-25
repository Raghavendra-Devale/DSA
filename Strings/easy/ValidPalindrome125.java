package Strings.easy;

/**
 * =======================================================
 * LeetCode 125 - Valid Palindrome
 * =======================================================
 *
 * Difficulty : Easy
 * Topic      : Strings
 * Pattern    : Two Pointers
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * A phrase is a palindrome if, after converting all
 * uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same
 * forward and backward.
 *
 * Return true if the given string is a palindrome,
 * otherwise return false.
 *
 * -------------------------------------------------------
 * Example
 * -------------------------------------------------------
 *
 * Input:
 *
 * "A man, a plan, a canal: Panama"
 *
 * Processed String:
 *
 * "amanaplanacanalpanama"
 *
 * Output:
 *
 * true
 *
 * -------------------------------------------------------
 * Learning Objectives
 * -------------------------------------------------------
 * ✓ String Traversal
 * ✓ Character Manipulation
 * ✓ StringBuilder
 * ✓ Two Pointer Technique
 * ✓ Character Utility Methods
 *
 */

public class ValidPalindrome125 {

    /**
     * =======================================================
     * Approach 1 : StringBuilder + Reverse
     * =======================================================
     *
     * Idea
     * -------------------------------------------------------
     *
     * Traverse the string.
     *
     * Keep only:
     *
     * • Letters
     * • Digits
     *
     * Convert everything to lowercase.
     *
     * Reverse the processed string.
     *
     * Compare the original processed string
     * with its reverse.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * Input:
     *
     * "A man, a plan, a canal: Panama"
     *
     * Processed:
     *
     * "amanaplanacanalpanama"
     *
     * Reverse:
     *
     * "amanaplanacanalpanama"
     *
     * Compare:
     *
     * Equal
     *
     * Return true.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * Step 1:
     *
     * Traverse original string.
     *
     * O(n)
     *
     * Step 2:
     *
     * Reverse StringBuilder.
     *
     * O(n)
     *
     * Step 3:
     *
     * Compare both strings.
     *
     * O(n)
     *
     * Total:
     *
     * O(n + n + n)
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
     * Processed string
     *
     * Reverse string
     *
     * Overall:
     *
     * O(n)
     */

    public static boolean isPalindromeStringBuilder(String s) {

        StringBuilder palindromeString = new StringBuilder();

        // Keep only letters and digits.
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {

                palindromeString.append(Character.toLowerCase(ch));
            }
        }

        String original = palindromeString.toString();

        String reverse = palindromeString.reverse().toString();

        return original.equals(reverse);
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
     * We don't actually need to build a new string.
     *
     * We can compare characters directly from both ends.
     *
     * Ignore:
     *
     * • Spaces
     * • Symbols
     * • Punctuation
     *
     * Compare only:
     *
     * • Letters
     * • Digits
     *
     * -------------------------------------------------------
     * Pointer Meaning
     * -------------------------------------------------------
     *
     * left
     *
     * Starts from beginning.
     *
     * right
     *
     * Starts from end.
     *
     * -------------------------------------------------------
     * Dry Run
     * -------------------------------------------------------
     *
     * Input:
     *
     * "A man, a plan, a canal: Panama"
     *
     * left = 'A'
     * right = 'a'
     *
     * Compare:
     *
     * a == a
     *
     * Move inward.
     *
     * Skip spaces and punctuation.
     *
     * Continue until pointers cross.
     *
     * Return true.
     *
     * -------------------------------------------------------
     * Why Skip Special Characters?
     * -------------------------------------------------------
     *
     * The problem statement says only
     * letters and digits should be considered.
     *
     * Therefore:
     *
     * ' '
     * ','
     * ':'
     * '.'
     *
     * are ignored.
     *
     * -------------------------------------------------------
     * Time Complexity Derivation
     * -------------------------------------------------------
     *
     * left moves from left to right.
     *
     * right moves from right to left.
     *
     * Every character is visited
     * at most once.
     *
     * Therefore:
     *
     * O(n)
     *
     * -------------------------------------------------------
     * Space Complexity
     * -------------------------------------------------------
     *
     * Only two pointers are used.
     *
     * O(1)
     */

    public static boolean isPalindromeTwoPointers(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from left.
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {

                left++;
            }

            // Skip non-alphanumeric characters from right.
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {

                right--;
            }

            // Compare characters ignoring case.
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Utility Method
     */
    public static void printResult(String input) {

        System.out.println("Input : " + input);

        System.out.println("StringBuilder : "
                + isPalindromeStringBuilder(input));

        System.out.println("Two Pointers  : "
                + isPalindromeTwoPointers(input));

        System.out.println();
    }

    public static void main(String[] args) {

        printResult("A man, a plan, a canal: Panama");

        printResult("race a car");

        printResult(" ");

        printResult("0P");
    }
}

/*
=========================================================
Mistakes / Improvements
=========================================================

1. Typo in Class Name

Current:

ValidPalindrom125

Better:

ValidPalindrome125

---------------------------------------------------------

2. Method Name

Current:

isPalindromeStringBuilder()

Better:

isPalindromeUsingStringBuilder()

Makes the purpose clearer.

---------------------------------------------------------

3. Typo in Output

Current:

"two ponters"

Better:

"two pointers"

=========================================================
Key Learnings
=========================================================

✓ Character.isLetterOrDigit()
checks whether a character should be
considered.

---------------------------------------------------------

✓ Character.toLowerCase()
allows case-insensitive comparison.

---------------------------------------------------------

✓ Two Pointer technique avoids
creating another string.

---------------------------------------------------------

✓ StringBuilder.reverse() provides
a simple solution but uses extra memory.

=========================================================
Pattern Recognition
=========================================================

Whenever a problem involves:

• Palindrome

• Ignoring characters

• Compare from both ends

• Strings

Think:

✓ Two Pointers

✓ Character Utility Methods

Related Problems:

• Palindrome Number

• Valid Palindrome II

• Reverse String

=========================================================
Interview Notes
=========================================================

Q1. Which solution is preferred?

The Two Pointer solution.

Reason:

It avoids creating another string.

---------------------------------------------------------

Q2. Why convert to lowercase?

The comparison must be
case-insensitive.

'A' and 'a' should be treated
as equal.

---------------------------------------------------------

Q3. Why skip punctuation?

Because the problem explicitly states
that only letters and digits are valid.

---------------------------------------------------------

Q4. Complexity Comparison

Approach 1

Time  : O(n)

Space : O(n)

-------------------------

Approach 2

Time  : O(n)

Space : O(1)

Approach 2 is the expected interview solution.

=========================================================
*/