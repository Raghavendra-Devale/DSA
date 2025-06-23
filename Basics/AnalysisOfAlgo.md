## Analysis of Algorithms (Background)
**What is meant by Algorithm Analysis?** 

Algorithm analysis is an important part of computational complexity theory, which provides theoretical estimation for the required resources of 
an algorithm to solve a specific computational problem. 
Analysis of algorithms is the determination of the amount of time and space resources required to execute it.

## Why Analysis of Algorithms is important?
To predict the behavior of an algorithm without implementing it on a specific computer.

It is much more convenient to have simple measures for the efficiency of an algorithm than to implement the algorithm and test the efficiency every time a certain parameter in the underlying computer system changes.

It is impossible to predict the exact behaviour of an algorithm. There are too many influencing factors. The analysis is thus only an approximation; it is not perfect.

More importantly, by analyzing different algorithms, we can compare them to determine the best one for our purpose.

Types of Algorithm Analysis:
**Best case**, **Worst case**, **Average case**



## Asymptotic Analysis 
When analyzing algorithms, **Asymptotic Analysis is a key concept.** It helps us understand the order of growth of an algorithm's time or space requirements as the input size increases. 

## What is Asymptotic Analysis?
Asymptotic analysis is a way to evaluate the performance of an algorithm by focusing on its growth rate as the input size (n) becomes very large. 

It ignores:
Machine-dependent constants (e.g., hardware speed).
Programming language differences.
Smaller terms become insignificant for large inputs.
Instead, it focuses on the big picture: how the algorithm scales with input size.

## Why Use Asymptotic Analysis?
Machine-Independent: It doesn’t depend on the hardware or programming language.
No Implementation Needed: You can analyze an algorithm without writing code.
Focus on Growth Rate: It helps compare algorithms based on how they perform as the input size grows.

Example: Sum of Natural Numbers
Let’s analyze three different ways to calculate the sum of the first n natural numbers using asymptotic analysis.

Function 1: Mathematical Formula

function fun1(n) {
    return (n * (n + 1)) / 2;
}

Explanation: This uses a mathematical formula to calculate the sum in constant time.
Time Taken: c1 (where c1 is a constant).
Time Complexity: O(1) – Constant time. The runtime doesn’t depend on the input size.
Function 2: Single Loop

function fun2(n) {
    let sum = 0;
    for (let i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}
Explanation: This uses a single loop to iterate through numbers from 1 to n and adds them to the sum.
Time Taken: c2 * n + c3 (where c2 and c3 are constants).
Time Complexity: O(n) – Linear time. The runtime grows linearly with the input size.
Function 3: Nested Loops

function fun3(n) {
    let sum = 0;
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= i; j++) {
            sum++;
        }
    }
    return sum;
}
Explanation: This uses nested loops to calculate the sum. The inner loop runs multiple times for each iteration of the outer loop.
Time Taken: c4 * n² + c5 * n + c6 (where c4, c5, and c6 are constants).
Time Complexity: O(n²) – Quadratic time. The runtime grows quadratically with the input size.
How to Perform Asymptotic Analysis?
Identify the Dominant Term:
For large inputs, the term with the highest growth rate dominates.
Ignore constants and lower-order terms.
Example: In c4 * n² + c5 * n + c6, the dominant term is n².
Use Big-O Notation:
Big-O notation describes the upper bound of an algorithm's growth rate.
Example: If an algorithm takes 3n² + 2n + 1 time, its time complexity is O(n²).
Key Points to Remember
Focus on Growth Rate: Asymptotic analysis focuses on how the algorithm performs as the input size grows.
Ignore Constants: Constants (like c1, c2, etc.) are ignored because they don’t affect the growth rate.
Compare Algorithms: Use asymptotic analysis to compare algorithms and choose the most efficient one.
Conclusion
Asymptotic analysis helps us understand how an algorithm's performance scales with input size, ignoring constants and focusing on growth rates. It allows us to compare algorithms and choose the most efficient one. By mastering this, you can write optimized and scalable code.


Worst, Average and Best Case Time Complexities
It is important to analyze an algorithm after writing it to find it's efficiency in terms of time and space in order to improve it if possible. 

When it comes to analyzing algorithms, the asymptotic analysis seems to be the best way possible to do so. This is because asymptotic analysis analyzes algorithms in terms of the input size. It checks how are the time and space growing in terms of the input size.

In this article, we will take an example of Linear Search and analyze it using Asymptotic analysis.

We can have three cases to analyze an algorithm:

Worst Case
Average Case
Best Case
Below is the algorithm for performing linear search:




// Linearly search x in arr[]. 
// If x is present then return the index,
// otherwise return -1
int search(int arr[], int n, int x)
{
    int i;
    for (i=0;i<n;i++){
        if(arr[i]==x){
            return i;
        }
    }
    return -1;
 }
 
 //Driver program to test above functions
 int main(){
    int arr[]={2,8,12,9};
    int x=12;
    int n=sizeof(arr)/sizeof(arr[0]);
    printf("%d is present in %d index",x,search(arr,n,x));
    getchar();
    return 0;
 }


Worst Case Analysis (Usually Done): In the worst case analysis, we calculate upper bound on running time of an algorithm. We must know the case that causes the maximum number of operations to be executed. For Linear Search, the worst case happens when the element to be searched (x in the above code) is not present in the array. When x is not present, the search() functions compares it with all the elements of arr[] one by one. Therefore, the worst case time complexity of linear search would be  O(N), where N is the number of elements in the array.

Average Case Analysis (Sometimes done):  In average case analysis, we take all possible inputs and calculate computing time for all of the inputs. Sum all the calculated values and divide the sum by total number of inputs. We must know (or predict) distribution of cases. For the linear search problem, let us assume that all cases are uniformly distributed (including the case of x not being present in array). So we sum all the cases and divide the sum by (N+1). Following is the value of average case time complexity.


 

Best Case Analysis (Bogus): In the best case analysis, we calculate lower bound on running time of an algorithm. We must know the case that causes minimum number of operations to be executed. In the linear search problem, the best case occurs when x is present at the first location. The number of operations in the best case is constant (not dependent on N). So time complexity in the best case would be 𝛀(1).

Example-




#include <bits/stdc++.h>
using namespace std;
​
// Linearly search x in arr[].
// If x is present then return the index,
// otherwise return -1
int search(int arr[], int n, int x)
{
    int i;
    for (i = 0; i < n; i++) {
        if (arr[i] == x)
            return i;
    }
    return -1;
}
​
// Driver's Code
int main()
{
    int arr[] = { 1, 10, 30, 15 };
    int x = 30;
    int n = sizeof(arr) / sizeof(arr[0]);
    // Function call
    cout << x << " is present at index "
         << search(arr, n, x);
​
    return 0;
}


Time Complexity Analysis: (In Big-O notation)

Best Case: Ω(1), This will take place if the element to be searched is on the first index of the given list. So, the number of comparisons, in this case, is 1.
Average Case: O(n), This will take place if the element to be searched is on the middle index of the given list.
Worst Case: O(n), This will take place if:
The element to be searched is on the last index
The element to be searched is not present on the list
Important Points:

Most of the times, we do the worst case analysis to analyze algorithms. In the worst analysis, we guarantee an upper bound on the running time of an algorithm which is a good piece of information.
The average case analysis is not easy to do in most of the practical cases and it is rarely done. In the average case analysis, we must know (or predict) the mathematical distribution of all possible inputs.
The Best Case analysis is bogus. Guaranteeing a lower bound on an algorithm doesn't provide any information as in the worst case, an algorithm may take years to run.



Analysis of Recursion
Recursive algorithms are functions that call themselves to solve smaller instances of the same problem. Analyzing their time complexity involves understanding recurrence relations, which describe how the problem size reduces with each recursive call. Let’s break it down with examples.

What is a Recursive Function?
A recursive function is a function that calls itself during its execution. For example:


function fun(n) {
    if (n <= 0) return; 
    console.log("GFG"); 
    fun(n / 2); // Recursive call
    fun(n / 2); // Recursive call
}
Recurrence Relation
To analyze recursive algorithms, we use recurrence relations, which express the time complexity in terms of smaller inputs.

Example 1: Simple Recursion

function fun(n) {
    if (n <= 0) return; 
    console.log("GFG"); 
    fun(n / 2); // Recursive call
    fun(n / 2); // Recursive call
}


Recurrence Relation: 
T(n)=2T(n/2)+Θ(1)
2T(n/2): Two recursive calls with half the input size.
Θ(1): Constant work done in each call.
Base Case: T(0)=Θ(1).
Time Complexity: Θ(n).
Example 2: Recursion with a Loop

function fun(n) {
    if (n == 0) return; // Base case
    for (let i = 0; i < n; i++) { // Θ(n)
        console.log("GFG");
    }
    fun(n / 2); // T(n/2)
    fun(n / 3); // T(n/3)
}
Recurrence Relation: 
T(n)=T(n/2)+T(n/3)+Θ(n)
Base Case: T(0)=Θ(1)
Time Complexity: Θ(n) 
Example 3: Linear Recursion

function fun(n) {
    if (n == 1) return; // Base case
    console.log("GFG"); // Θ(1)
    fun(n - 1); // T(n-1)
}
Recurrence Relation: T(n)=T(n−1)+Θ(1)
Base Case: T(1)=Θ(1)
Time Complexity: Θ(n).
Conclusion
In this article, we studied how to analyze recursive algorithms using recurrence relations. We explored examples like simple recursion, recursion with loops, and linear recursion, and learned how to express their time complexity. By understanding recurrence relations and base cases, you can determine the efficiency of recursive functions and improve their performance.




