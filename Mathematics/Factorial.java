/*
Problem:
Given a positive integer N, find the factorial of N.

Factorial Definition:
N! = N × (N-1) × (N-2) × ... × 1
0! and 1! are defined as 1.

Approach:
Two different approaches are implemented:

1) Iterative (Loop-based) Approach:
   - Initialize result as 1.
   - Multiply result with numbers from 1 to N using a loop.
   - This avoids recursion and stack usage.

2) Recursive Approach:
   - Uses the mathematical definition of factorial.
   - Base case: if N is 0 or 1, return 1.
   - Recursive case: N * factorial(N-1).

Time Complexity:
Both approaches run in O(N) time.

Auxiliary Space:
- Loop version: O(1)
- Recursive version: O(N) due to recursive call stack.
*/

public class Factorial {

    // Loop version
    public static long factorial(int N){
        long result = 1;

        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive version
    static long factorialRecurse(int n){
        if (n <= 1) return 1;
        return n * factorialRecurse(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Loop version " + factorial(n));
        System.out.println("Recursive version " + factorialRecurse(n));
    }
}

/*
Dry Run (Loop Version):

Input:
N = 5

Step-by-step:
result = 1
i = 1 → result = 1 * 1 = 1
i = 2 → result = 1 * 2 = 2
i = 3 → result = 2 * 3 = 6
i = 4 → result = 6 * 4 = 24
i = 5 → result = 24 * 5 = 120

Output:
120

Dry Run (Recursive Version):

factorialRecurse(5)
→ 5 * factorialRecurse(4)
→ 5 * 4 * factorialRecurse(3)
→ 5 * 4 * 3 * factorialRecurse(2)
→ 5 * 4 * 3 * 2 * factorialRecurse(1)
→ 5 * 4 * 3 * 2 * 1
→ 120
*/
