/*
Problem:
Print a number-based triangle pattern where each row contains
the same number repeated.

Pattern Output (for n = 5):
1
22
333
4444
55555

Approach:
- Use two nested loops.
- The outer loop controls the row number (from 1 to n).
- The inner loop prints the current row number i, i times.
- After completing one row, move to the next line.

Time Complexity:
O(n²) — nested loops for pattern printing.

Auxiliary Space:
O(1) — no extra space used.
*/

public class Pattern4 {

    static void pattern4(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern4(5);
    }
}

/*
Dry Run (n = 5):

i = 1:
j runs from 1 to 1 → print 1
Output: 1

i = 2:
j runs from 1 to 2 → print 22
Output: 22

i = 3:
j runs from 1 to 3 → print 333
Output: 333

i = 4:
j runs from 1 to 4 → print 4444
Output: 4444

i = 5:
j runs from 1 to 5 → print 55555
Output: 55555
*/
