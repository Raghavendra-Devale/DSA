
package Foundations;

/*
Problem:
An ugly number is a positive integer
whose prime factors are limited to

2, 3 and 5.

Given an integer n,
return true if it is an ugly number.
Otherwise, return false.

Examples:

Input: 6
Output: true
Explanation:
6 = 2 × 3

Input: 8
Output: true
Explanation:
8 = 2 × 2 × 2

Input: 14
Output: false
Explanation:
14 = 2 × 7
7 is not an allowed prime factor.

Concepts:
- Mathematics
- Prime Factors
- Recursion
- Repeated Division

Difficulty:
Easy
*/

public class UglyNumber263 {

    /*
    =====================================================
    Approach 1 : Repeated Division
    =====================================================

    Idea:

    Ugly numbers contain only
    the prime factors

    2

    3

    and

    5.

    Keep removing these factors
    as long as possible.

    If after removing all possible
    factors,

    the remaining number becomes 1,

    then it is an ugly number.

    Otherwise,

    some other prime factor exists.

    Steps:

    1. If n <= 0
       return false.

    2. While divisible by 2
       divide by 2.

    3. While divisible by 3
       divide by 3.

    4. While divisible by 5
       divide by 5.

    5. Return

       n == 1

    Why it Works:

    Every ugly number
    is formed only using

    2

    3

    and

    5.

    Removing all these factors
    should finally leave

    1.
    */

    /*
    Dry Run

    Input

    60

    Divide by 2

    60 → 30 → 15

    Divide by 3

    15 → 5

    Divide by 5

    5 → 1

    Return true

    ----------------------

    Input

    14

    Divide by 2

    14 → 7

    Divide by 3

    No

    Divide by 5

    No

    Remaining value

    7

    Return false
    */

    // TC -> O(log n)
    // SC -> O(1)

    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }

    /*
    =====================================================
    Approach 2 : Recursion
    =====================================================

    Idea:

    Instead of using loops,

    recursively divide the number

    whenever it is divisible by

    2

    3

    or

    5.

    Stop when

    n becomes 1

    or

    none of the factors can divide it.

    Base Cases:

    1.

    n == 1

    return true.

    2.

    n <= 0

    return false.

    3.

    If divisible by 2

    recurse with

    n / 2.

    4.

    If divisible by 3

    recurse with

    n / 3.

    5.

    If divisible by 5

    recurse with

    n / 5.

    Otherwise,

    return false.
    */

    /*
    Dry Run

    Input

    30

    isUglyRec(30)

    ↓

    isUglyRec(15)

    ↓

    isUglyRec(5)

    ↓

    isUglyRec(1)

    ↓

    true

    ----------------------

    Input

    14

    isUglyRec(14)

    ↓

    isUglyRec(7)

    ↓

    Not divisible by

    2

    3

    or

    5

    ↓

    false
    */

    // TC -> O(log n)
    // SC -> O(log n)

    public boolean isUglyRec(int n) {

        if (n == 1)
            return true;

        if (n <= 0)
            return false;

        if (n % 2 == 0)
            return isUglyRec(n / 2);

        if (n % 3 == 0)
            return isUglyRec(n / 3);

        if (n % 5 == 0)
            return isUglyRec(n / 5);

        return false;
    }

    public static void main(String[] args) {

        UglyNumber263 obj = new UglyNumber263();

        System.out.println(obj.isUgly(6));
        System.out.println(obj.isUgly(14));

        System.out.println(obj.isUglyRec(6));
        System.out.println(obj.isUglyRec(14));
    }
}

