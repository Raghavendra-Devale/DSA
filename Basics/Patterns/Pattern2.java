/*
Problem:
Print a left-aligned triangle star pattern.

Pattern Output (for n = 5):

(blank line)
*
**
***
****

Approach:
- Use two nested loops.
- The outer loop runs n times and represents rows.
- The inner loop prints stars based on the current row number.
- For row i, the inner loop runs i times, printing i stars.
- Since i starts from 0, the first row prints no stars (blank line).

Time Complexity:
O(n²) — due to nested loops.

Auxiliary Space:
O(1) — no extra space used.
*/

public class Pattern2 {

    static void pattern2(int n){
        for(int i = 0; i < n; i++){
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern2(5);
    }
}

/*
Dry Run (n = 5):

i = 0:
j runs from 0 to -1 → no stars printed
Output: (blank line)

i = 1:
j runs from 0 to 0 → *
Output: *

i = 2:
j runs from 0 to 1 → **
Output: **

i = 3:
j runs from 0 to 2 → ***
Output: ***

i = 4:
j runs from 0 to 3 → ****
Output: ****
*/
