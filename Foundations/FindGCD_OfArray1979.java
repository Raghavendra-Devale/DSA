package Foundations;

/*
Problem:
Given an integer array nums,

return the greatest common divisor (GCD)
of the smallest number
and the largest number in the array.

The GCD of two numbers
is the largest positive integer
that divides both numbers.

Examples:

Input:
nums = [2,5,6,9,10]

Output:
2

Explanation:

Minimum = 2

Maximum = 10

GCD(2,10) = 2

--------------------

Input:
nums = [7,5,6,8,3]

Output:
1

Concepts:
- Mathematics
- Euclidean Algorithm
- Arrays

Difficulty:
Easy
*/

public class FindGCD_OfArray1979 {

    /*
    =====================================================
    Approach 1 : Euclidean Algorithm (Iterative)
    =====================================================

    Idea:

    The GCD of the entire problem
    depends only on

    the smallest number

    and

    the largest number.

    First,

    find the minimum
    and maximum.

    Then,

    use the Euclidean Algorithm.

    Euclidean Algorithm:

    GCD(a,b)

    =

    GCD(b, a % b)

    Continue until

    b becomes 0.

    The remaining value of a
    is the GCD.

    Steps:

    1. Find minimum element.

    2. Find maximum element.

    3. Compute GCD
       using iteration.

    4. Return the answer.

    Why it Works:

    Every remainder
    preserves the common divisor.

    Eventually,

    remainder becomes 0,

    leaving the greatest
    common divisor.
    */

    /*
    Dry Run

    nums

    [2,5,6,9,10]

    Minimum

    2

    Maximum

    10

    GCD(2,10)

    10 % 2 = 0

    Answer

    2
    */

    // TC -> O(n + log(min,max))
    // SC -> O(1)

    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {

            if (num < min)
                min = num;

            if (num > max)
                max = num;
        }

        return gcd(min, max);
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int rem = a % b;

            a = b;
            b = rem;
        }

        return a;
    }

    /*
    =====================================================
    Approach 2 : Euclidean Algorithm (Recursion)
    =====================================================

    Idea:

    Instead of using a loop,

    recursively compute

    GCD(b, a % b)

    until

    b becomes 0.

    Base Case:

    If b == 0

    return a.

    Otherwise,

    return

    gcd(b, a % b)
    */

    /*
    Dry Run

    GCD(18,12)

    ↓

    GCD(12,6)

    ↓

    GCD(6,0)

    ↓

    6
    */

    // TC -> O(n + log(min,max))
    // SC -> O(log(min,max))

    public int findGCDRec(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {

            if (num < min)
                min = num;

            if (num > max)
                max = num;
        }

        return gcdRec(min, max);
    }

    private int gcdRec(int a, int b) {

        if (b == 0)
            return a;

        return gcdRec(b, a % b);
    }

    public static void main(String[] args) {

        FindGCD_OfArray1979 obj = new FindGCD_OfArray1979();

        int[] nums = {2, 5, 6, 9, 10};

        System.out.println(obj.findGCD(nums));

        System.out.println(obj.findGCDRec(nums));
    }
}
