package Foundations;

/*
Problem:
Write a function that reverses a character array in-place.

Do not allocate extra space for another array.
You must modify the input array with O(1) extra memory.

Examples:

Input:
['h','e','l','l','o']

Output:
['o','l','l','e','h']

Input:
['H','a','n','n','a','h']

Output:
['h','a','n','n','a','H']

Concepts:
- Two Pointers
- Array
- Swapping

Difficulty:
Easy
*/

public class ReverseString344 {

    /*
    Approach (Two Pointers)

    Idea:
    - One pointer starts from the beginning.
    - Another pointer starts from the end.
    - Swap both characters.
    - Move the left pointer forward.
    - Move the right pointer backward.
    - Continue until both pointers meet.

    Steps:
    1. Initialize left = 0.
    2. Initialize right = last index.
    3. While left < right:
          Swap s[left] and s[right].
          Increment left.
          Decrement right.
    4. The array is now reversed.

    Why it Works:
    Every swap places two characters into their correct reversed positions.

    Example:

    ['h','e','l','l','o']

    Swap h and o

    ['o','e','l','l','h']

    Swap e and l

    ['o','l','l','e','h']

    Done.
    */

    /*
    Dry Run

    Input:

    ['1','2','3']

    Initial

    left = 0
    right = 2

    Iteration 1

    Swap

    1 ↔ 3

    Array

    ['3','2','1']

    left = 1
    right = 1

    Loop Ends

    Output

    ['3','2','1']
    */

    // TC -> O(n)
    // SC -> O(1)

    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        System.out.println(s);
    }


    /*
Approach (Recursion)

Idea:
Instead of using a loop,
recursively swap the first and last characters.

After each swap:
- Move the left pointer one step forward.
- Move the right pointer one step backward.
- Continue until both pointers meet or cross.

Base Cases:

1. left >= right
   return

Otherwise:

- Swap s[left] and s[right]
- Call reverse(left + 1, right - 1)
*/

/*
Dry Run

Input:

['1','2','3','4']

reverse(0, 3)

↓

Swap

1 ↔ 4

Array

['4','2','3','1']

↓

reverse(1, 2)

↓

Swap

2 ↔ 3

Array

['4','3','2','1']

↓

reverse(2, 1)

Base Case

left >= right

Return

Final Output

['4','3','2','1']
*/

// TC -> O(n)
// SC -> O(n) (Recursive Call Stack)

    public static void reverseStringRec(char[] s) {

        reverse(s, 0, s.length - 1);

        System.out.println(s);
    }

    private static void reverseRec(char[] s, int left, int right) {

        if (left >= right) {
            return;
        }

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverseRec(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        reverseString(new char[]{'1', '2', '3'});

    }
}