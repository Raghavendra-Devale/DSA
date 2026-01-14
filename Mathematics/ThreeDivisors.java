/*
Problem:
Given a positive integer n, find how many numbers less than or equal to n
have exactly 3 positive divisors.

Key Observation:
A number has exactly 3 positive divisors if and only if it is the square of a prime number.

Reason:
- Let the number be p², where p is prime.
- Divisors of p² are: 1, p, p² → exactly 3 divisors.
- Any non-prime square or non-square number will have more or fewer divisors.

Approach:
1) Iterate over numbers i such that i² ≤ n.
2) For each i, check if i is a prime number.
3) If i is prime, then i² has exactly 3 divisors.
4) Count such prime numbers i.

Time Complexity:
O(√n × √√n) ≈ O(√n)
- Loop runs till √n
- Prime check runs till √i

Auxiliary Space:
O(1)
*/

public class ThreeDivisors {

    public static boolean isPrime(int n){
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            System.out.println("Checking if " + n + " is divisible by " + i);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int exactly3Divisors(int n){
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = exactly3Divisors(6);
        System.out.println("count " + ans);
    }
}

/*
Dry Run:

Input:
n = 10

Step 1:
Loop i from 2 while i*i ≤ 10

i = 2:
2 is prime → 2² = 4 ≤ 10 → count = 1

i = 3:
3 is prime → 3² = 9 ≤ 10 → count = 2

i = 4:
4² = 16 > 10 → loop ends

Numbers with exactly 3 divisors:
4 → (1, 2, 4)
9 → (1, 3, 9)

Output:
2
*/

/*
LeetCode Insight:
Instead of counting, LeetCode checks directly:
1) If n is a perfect square.
2) If √n is prime.
If both are true → exactly 3 divisors.
*/
