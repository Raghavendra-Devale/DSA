package Foundations;

import java.util.HashSet;

public class HappyNumber202 {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();

        while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = getNext(n);
        }
        return n == 1;
    }

    public static boolean isHappyTwoPointer(int n) {
        int slow = getNext(n);
        int fast = getNext(getNext(n));
        while (slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }


    static int getNext(int n){

        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum += digit * digit;
            n = n/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappyTwoPointer(19));
    }
}
