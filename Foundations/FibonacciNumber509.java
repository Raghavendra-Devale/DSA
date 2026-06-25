package Foundations;

/*
Problem:
The Fibonacci numbers are defined as:

F(0) = 0
F(1) = 1

For n > 1,

F(n) = F(n - 1) + F(n - 2)

Given an integer n,
return F(n).

Examples:

Input: 2
Output: 1

Input: 3
Output: 2

Input: 4
Output: 3

Concepts:
- Recursion
- Dynamic Programming
- Memoization
- Tabulation
- Space Optimization

Difficulty:
Easy
*/

public class FibonacciNumber509 {

    /*
    ======================================================
    Approach 1 : Simple Recursion
    ======================================================

    Idea:
    The Fibonacci sequence follows the recurrence relation:

    F(n) = F(n-1) + F(n-2)

    Keep solving smaller subproblems
    until reaching the base cases.

    Base Cases:

    F(0) = 0
    F(1) = 1

    Steps:

    1. If n <= 1
       return n

    2. Otherwise

       return

       fib(n-1) + fib(n-2)

    Why it Works:

    Every Fibonacci number
    is the sum of its previous two numbers.

    Example:

    fib(5)

    =
    fib(4) + fib(3)

    =
    (fib(3)+fib(2))
    +
    (fib(2)+fib(1))

    Continue until reaching
    fib(1) and fib(0).
    */

    /*
    Dry Run

    fib(4)

    ↓

    fib(3) + fib(2)

    ↓

    (fib(2)+fib(1))
    +
    (fib(1)+fib(0))

    ↓

    (1+1)+(1+0)

    ↓

    3
    */

    // TC -> O(2^n)
    // SC -> O(n)

    public static int fib(int n) {

        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    /*
    ======================================================
    Approach 2 : Memoization (Top Down DP)
    ======================================================

    Idea:

    Recursion calculates the same values
    many times.

    Store already computed answers
    inside an array.

    Before solving,

    check whether the answer
    already exists.

    If yes,

    return it directly.

    Steps:

    1. Create dp[]

    2. Base case

    3. If dp[n] already exists
       return it

    4. Otherwise

       calculate

       fib(n-1)+fib(n-2)

       store it

       return it.
    */

    /*
    Dry Run

    fib(5)

    dp[]

    fib(4)
    stored

    fib(3)
    stored

    Next time fib(4)
    is required,

    directly returned

    instead of recalculating.
    */

    // TC -> O(n)
    // SC -> O(n)

    static int[] dp = new int[31];

    public static int fibMemo(int n) {

        if (n <= 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = fibMemo(n - 1) + fibMemo(n - 2);

        return dp[n];
    }

    /*
    ======================================================
    Approach 3 : Tabulation (Bottom Up DP)
    ======================================================

    Idea:

    Instead of recursion,

    build answers from

    smaller values

    to larger values.

    Since

    F(i)

    depends on

    F(i-1)

    and

    F(i-2),

    fill the array
    from left to right.

    Steps:

    1. Create dp[]

    2. dp[0]=0

    3. dp[1]=1

    4. Fill remaining values

       dp[i]

       =

       dp[i-1]+dp[i-2]

    5. Return dp[n]
    */

    /*
    Dry Run

    n = 6

    dp

    0 1 _ _ _ _ _

    i=2

    0 1 1

    i=3

    0 1 1 2

    i=4

    0 1 1 2 3

    i=5

    0 1 1 2 3 5

    i=6

    0 1 1 2 3 5 8
    */

    // TC -> O(n)
    // SC -> O(n)

    public static int fibTab(int n) {

        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[n];
    }

    /*
    ======================================================
    Approach 4 : Space Optimized DP
    ======================================================

    Idea:

    We only need

    previous two values.

    So,

    instead of storing
    the whole array,

    keep only

    prev2

    prev1

    current

    Update them
    every iteration.

    Steps:

    prev2 = 0

    prev1 = 1

    Loop from 2 to n

    current

    =

    prev1 + prev2

    Shift values

    prev2 = prev1

    prev1 = current

    Return prev1
    */

    /*
    Dry Run

    n = 6

    prev2 = 0

    prev1 = 1

    i=2

    current =1

    prev2=1

    prev1=1

    i=3

    current=2

    prev2=1

    prev1=2

    i=4

    current=3

    prev2=2

    prev1=3

    i=5

    current=5

    prev2=3

    prev1=5

    i=6

    current=8

    Answer = 8
    */

    // TC -> O(n)
    // SC -> O(1)

    public static int fibOptimal(int n) {

        if (n <= 1)
            return n;

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        System.out.println(fib(6));

        System.out.println(fibMemo(6));

        System.out.println(fibTab(6));

        System.out.println(fibOptimal(6));
    }
}