package Foundations;

import java.util.Arrays;

/**
 * LeetCode 204 - Count Primes
 *
 * Difficulty : Easy
 * Pattern    : Sieve of Eratosthenes
 * Topic      : Number Theory
 *
 * -------------------------------------------------------
 * Problem
 * -------------------------------------------------------
 * Given an integer n, return the number of prime numbers
 * strictly less than n.
 *
 * Example:
 *
 * Input : 10
 *
 * Prime Numbers:
 * 2 3 5 7
 *
 * Output : 4
 *
 * -------------------------------------------------------
 * Learning Objective
 * -------------------------------------------------------
 * 1. Understand how to check whether a single number is prime.
 * 2. Understand why brute force repeats work.
 * 3. Learn Sieve of Eratosthenes.
 * 4. Learn why we start from i * i.
 * 5. Learn why j += i.
 */

public class CountPrimes204 {

    /**
     * -------------------------------------------------------
     * Approach 1 : Brute Force
     * -------------------------------------------------------
     *
     * Idea:
     *
     * Check every number from 2 to n-1.
     * If the number is prime, increment the count.
     *
     * Time Complexity:
     * O(n√n)
     *
     * Space Complexity:
     * O(1)
     */
    public static int countPrimesBrute(int n) {

        int count = 0;

        // Check every number individually.
        for (int i = 2; i < n; i++) {

            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Checks whether a single number is prime.
     *
     * Instead of checking till n,
     * checking till √n is sufficient because
     * factors always occur in pairs.
     *
     * Example:
     *
     * 36
     *
     * 2 × 18
     * 3 × 12
     * 4 × 9
     * 6 × 6
     *
     * After √36 = 6,
     * factors begin repeating.
     *
     * Time:
     * O(√n)
     */
    public static boolean isPrime(int n) {

        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0)
                return false;
        }

        return true;
    }

    /**
     * -------------------------------------------------------
     * Approach 2 : Sieve of Eratosthenes
     * -------------------------------------------------------
     *
     * Observation:
     *
     * Instead of asking:
     *
     * Is 4 prime?
     * Is 6 prime?
     * Is 8 prime?
     *
     * We ask:
     *
     * Since 2 is prime,
     * every multiple of 2 is NOT prime.
     *
     * Since 3 is prime,
     * every multiple of 3 is NOT prime.
     *
     * We eliminate composite numbers instead
     * of checking every number individually.
     *
     * Time Complexity:
     * O(n log log n)
     *
     * Space Complexity:
     * O(n)
     */
    public static int countPrimeSievesAlgo(int n) {

        // There are no prime numbers less than 2.
        if (n <= 2)
            return 0;

        // Assume every number is prime.
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        /**
         * Why i * i < n ?
         *
         * Suppose n = 100
         *
         * After processing
         * 2
         * 3
         * 5
         * 7
         *
         * every composite number has already
         * been marked.
         *
         * Also avoids integer overflow caused
         * by using i < n and computing i * i.
         */
        for (int i = 2; i * i < n; i++) {

            // If already marked false,
            // it is not a prime.
            if (primes[i]) {

                /**
                 * Why start from i * i ?
                 *
                 * Example:
                 *
                 * i = 5
                 *
                 * Multiples:
                 *
                 * 10
                 * 15
                 * 20
                 * 25
                 * 30
                 *
                 * 10 already marked by 2.
                 * 15 already marked by 3.
                 * 20 already marked by 2.
                 *
                 * Therefore first new composite is 25.
                 */

                /**
                 * Why j += i ?
                 *
                 * We only want multiples.
                 *
                 * Example:
                 *
                 * 25
                 * 30
                 * 35
                 * 40
                 *
                 * NOT
                 *
                 * 25
                 * 26
                 * 27
                 * 28
                 */
                for (int j = i * i; j < n; j += i) {

                    primes[j] = false;
                }
            }
        }

        // Count all remaining prime numbers.
        int count = 0;

        for (int i = 2; i < n; i++) {

            if (primes[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(countPrimesBrute(15));
        System.out.println(countPrimeSievesAlgo(15));
    }
}

/*
=========================================================
Mistakes I Made
=========================================================

1. Initially used

for(int j = i * i; j < n; j++)

This checks every number.

Correct:

j += i

because we only want multiples.


---------------------------------------------------------

2. Initially used

for(int i = 2; i < n; i++)

For very large values of i,

i * i

can overflow integer range
and become negative.

Correct:

i * i < n


---------------------------------------------------------

3. Initially thought the complexity was

O(n√n)

Actual complexity is

O(n log log n)

Reason:

Instead of checking every number,
we eliminate multiples of each prime only once.

=========================================================
Key Learnings
=========================================================

✓ Checking one number is different from generating all primes.

✓ Brute Force repeats work.

✓ Sieve removes groups of composite numbers.

✓ Start marking from i * i.

✓ Use j += i to visit only multiples.

✓ Watch for integer overflow while using i * i.

=========================================================
Pattern Recognition
=========================================================

Think Sieve of Eratosthenes whenever you see:

• Count primes
• Generate primes
• Prime preprocessing
• Multiple prime queries
• Prime lookup

=========================================================
*/