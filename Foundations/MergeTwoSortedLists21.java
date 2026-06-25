package Foundations;


import java.util.Arrays;

// * Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class MergeTwoSortedLists21 {
    /*
Approach (Two Pointers):

Idea:
- Since both linked lists are already sorted,
  compare the current nodes of each list.
- Attach the smaller node to the merged list.
- Move the pointer of the list from which the node was taken.
- Continue until one list becomes null.
- Finally, attach the remaining nodes of the non-empty list.

Steps:
1) Create a dummy node to act as the starting point
   of the merged list.
2) Maintain a pointer 'current' to build the result.
3) While both lists are not null:
   - If list1.val <= list2.val:
       - Attach list1 node
       - Move list1 forward
   - Else:
       - Attach list2 node
       - Move list2 forward
   - Move current forward
4) One list may still contain nodes.
   Attach the remaining nodes directly.
5) Return dummy.next (actual head of merged list).

Time Complexity:
O(n + m)

Auxiliary Space:
O(1)

where:
n = number of nodes in list1
m = number of nodes in list2
*/
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

//    Brute force

    /*
Brute Force Approach:

Idea:
- Traverse both linked lists and store all node values in an array.
- Sort the array so that all elements become ordered.
- Create a new linked list using the sorted values.
- Return the head of the newly created list.

Steps:
1) Count the total number of nodes in both lists.
2) Create an array of size (n + m).
3) Traverse list1 and store all values in the array.
4) Traverse list2 and store all values in the array.
5) Sort the array using Arrays.sort().
6) Create a dummy node for the result list.
7) Traverse the sorted array:
   - Create a new node for each value.
   - Attach it to the result list.
8) Return dummy.next as the head of the merged list.

Why it Works:
- After collecting all values from both lists,
  sorting guarantees that the elements are arranged
  in ascending order.
- Building a linked list from the sorted array produces
  the required merged sorted list.

Time Complexity:
- Traversing both lists: O(n + m)
- Sorting the array: O((n + m) log(n + m))
- Creating the new list: O(n + m)

Overall:
O((n + m) log(n + m))

Auxiliary Space:
O(n + m)

where:
n = number of nodes in list1
m = number of nodes in list2
*/


    public static ListNode mergeTwoListsBrute(ListNode list1, ListNode list2) {

        int count = 0;

        ListNode temp = list1;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        temp = list2;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        int arr[] = new int[count];

        temp = list1;
        int index = 0;

        while(temp != null){
            arr[index++] = temp.val;
            temp = temp.next;
        }

        temp = list2;
        while(temp != null){
            arr[index++] = temp.val;
            temp = temp.next;
        }

        Arrays.sort(arr);

        ListNode head = new ListNode(-1);
        ListNode current = head;
        for(int num : arr){
            current.next = new ListNode(num);
            current = current.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(list1, list2);
        System.out.println(result);

    }
}

/*
Dry Run
Input:
list1 = 1 -> 3 -> 5
list2 = 2 -> 4 -> 6

Initial:
dummy -> null
current -> dummy

list1 -> 1 -> 3 -> 5
list2 -> 2 -> 4 -> 6

Iteration 1:
        1 <= 2
Attach 1
dummy -> 1
list1 -> 3 -> 5
list2 -> 2 -> 4 -> 6
Iteration 2:
        3 > 2
Attach 2
dummy -> 1 -> 2
list1 -> 3 -> 5
list2 -> 4 -> 6

Iteration 3:
        3 <= 4
Attach 3
dummy -> 1 -> 2 -> 3
list1 -> 5
list2 -> 4 -> 6

Iteration 4:
        5 > 4
Attach 4
dummy -> 1 -> 2 -> 3 -> 4
list1 -> 5
list2 -> 6

Iteration 5:
        5 <= 6
Attach 5
dummy -> 1 -> 2 -> 3 -> 4 -> 5
list1 -> null
list2 -> 6

Loop Ends:
list1 is null
Attach remaining list2 nodes
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

Return:
dummy.next

Output:
        1 -> 2 -> 3 -> 4 -> 5 -> 6
Key Observation
current.next = (list1 != null) ? list1 : list2;
When one list finishes, the remaining nodes in the other list are already sorted,
so we can attach them directly without further comparisons.
This avoids unnecessary work and keeps the solution O(n + m).
 */