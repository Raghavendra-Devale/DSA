/*
Problem:
Print a number-based right-angled triangle pattern.

Pattern Output (for n = 4):
1
12
123
1234

Approach:
- Use two nested loops.
- The outer loop controls the number of rows (from 1 to n).
- The inner loop prints numbers starting from 1 up to the current row number.
- After printing numbers for each row, move to the next line.

Time Complexity:
O(n²) — nested loops for pattern printing.

Auxiliary Space:
O(1) — no extra space used.
*/

public class Pattern3 {

    static void pattern3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern3(4);
    }
}

/*
Dry Run (n = 4):

i = 1:
j = 1 → print 1
Output: 1

i = 2:
j = 1 → print 1
j = 2 → print 2
Output: 12

i = 3:
j = 1 → print 1
j = 2 → print 2
j = 3 → print 3
Output: 123

i = 4:
j = 1 → print 1
j = 2 → print 2
j = 3 → print 3
j = 4 → print 4
Output: 1234
*/
