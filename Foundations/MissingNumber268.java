
        package Foundations;

/*
Problem:
Given an array nums containing n distinct numbers
in the range [0, n],

return the only number in the range
that is missing from the array.

Examples:

Input:
nums = [3,0,1]

Output:
2

Input:
nums = [0,1]

Output:
2

Input:
nums = [9,6,4,2,3,5,7,0,1]

Output:
8

Concepts:
- Mathematics
- XOR
- Sorting
- Array

Difficulty:
Easy
*/

import java.util.Arrays;

public class MissingNumber268 {

    /*
    =====================================================
    Approach 1 : Sum Formula (Mathematical)
    =====================================================

    Idea:

    Numbers from

    0 to n

    have a known sum.

    Expected Sum

    =

    n × (n + 1) / 2

    Calculate

    Actual Sum

    of the array.

    Their difference
    is the missing number.

    Steps:

    1. Find expected sum.

    2. Find actual sum.

    3. Return

       expected - actual

    Why it Works:

    Since exactly one number
    is missing,

    subtracting the sums
    reveals that number.
    */

    /*
    Dry Run

    nums = [3,0,1]

    n = 3

    Expected Sum

    3 × 4 / 2

    = 6

    Actual Sum

    3 + 0 + 1

    = 4

    Missing

    6 - 4

    = 2
    */

    // TC -> O(n)
    // SC -> O(1)

    public int missingNumber(int[] nums) {

        int n = nums.length;

        int expected = n * (n + 1) / 2;

        int actual = 0;

        for (int num : nums) {
            actual += num;
        }

        return expected - actual;
    }

    /*
    =====================================================
    Approach 2 : XOR
    =====================================================

    Idea:

    XOR has two important properties.

    x ^ x = 0

    x ^ 0 = x

    XOR all numbers

    from 0 to n

    and

    XOR every element
    of the array.

    Every existing number
    cancels itself.

    Only the missing number
    remains.

    Steps:

    1. Initialize answer = n.

    2. XOR answer
       with every index.

    3. XOR answer
       with every array element.

    4. Return answer.
    */

    /*
    Dry Run

    nums = [3,0,1]

    ans = 3

    i=0

    ans = 3 ^ 0 ^ 3 = 0

    i=1

    ans = 0 ^ 1 ^ 0 = 1

    i=2

    ans = 1 ^ 2 ^ 1 = 2

    Return 2
    */

    // TC -> O(n)
    // SC -> O(1)

    public int missingNumberXOR(int[] nums) {

        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {

            ans ^= i;
            ans ^= nums[i];
        }

        return ans;
    }

    /*
    =====================================================
    Approach 3 : Sorting
    =====================================================

    Idea:

    Sort the array.

    After sorting,

    every index
    should contain
    the same value.

    The first mismatch
    is the missing number.

    If no mismatch exists,

    then n is missing.
    */

    /*
    Dry Run

    nums

    [3,0,1]

    Sort

    [0,1,3]

    index 0 -> 0 ✓

    index 1 -> 1 ✓

    index 2 -> 3 ✗

    Return 2
    */

    // TC -> O(n log n)
    // SC -> O(1) (Ignoring sorting implementation space)

    public int missingNumberSort(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static void main(String[] args) {

        MissingNumber268 obj = new MissingNumber268();

        int[] nums = {3, 0, 1};

        System.out.println(obj.missingNumber(nums));

        System.out.println(obj.missingNumberXOR(nums));

        System.out.println(obj.missingNumberSort(nums));
    }
}

