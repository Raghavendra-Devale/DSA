/*
Problem:
Given the first two terms A and B of a Geometric Progression (GP),
find the Nth term of the series.

Geometric Progression:
A sequence where each term is obtained by multiplying the previous term
by a constant ratio (r).

Approach:
- The common ratio (r) is calculated as B / A.
- The formula for the Nth term of a GP is:
  Nth term = A × r^(n - 1)
- Java's Math.pow() function is used to compute the power efficiently.

Time Complexity:
O(1) — constant number of operations.

Auxiliary Space:
O(1) — no extra space used.
*/

public class GP_Term {

    static double ans;

    static double findGP(int A, int B, int n){
        double ratio = (double) B / A;        // common ratio r
        ans = A * Math.pow(ratio, n - 1);     // nth term = A * r^(n-1)
        return ans;
    }

    public static void main(String[] args) {
        double ans = findGP(2, 3, 1);
        System.out.println(ans);
    }
}

/*
Dry Run:

Input:
A = 2, B = 3, N = 1

Step 1:
Calculate ratio:
r = B / A = 3 / 2 = 1.5

Step 2:
Apply GP formula:
Nth term = A × r^(N - 1)
Nth term = 2 × (1.5)^(0)
Nth term = 2 × 1
Nth term = 2

Output:
2.0
*/
