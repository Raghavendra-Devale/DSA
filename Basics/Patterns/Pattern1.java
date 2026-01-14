/*
Problem:
Print a right-angled triangle star pattern.

Pattern Output:
*
**
***
****

Approach:
- Use two nested loops.
- The outer loop controls the number of rows.
- The inner loop controls the number of stars printed in each row.
- For each row i, print (i + 1) stars.
- After printing stars for a row, move to the next line.

Time Complexity:
O(n²) — nested loops for pattern printing.

Auxiliary Space:
O(1) — no extra space used.
*/

public class Pattern1 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/*
Dry Run:

Row 0:
i = 0 → j runs from 0 to 0
Print: *

Row 1:
i = 1 → j runs from 0 to 1
Print: **

Row 2:
i = 2 → j runs from 0 to 2
Print: ***

Row 3:
i = 3 → j runs from 0 to 3
Print: ****

Final Output:
*
**
***
****
*/
