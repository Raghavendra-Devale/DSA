
````md
# 📦 Arrays — Theory + Problem Index (Java)

---

## 🧠 Core Theory (Read Once, Revise Often)

### What is an Array?
An **array** stores elements of the **same data type** in **contiguous memory locations**.

```java
int[] nums = {1, 2, 3, 4};
````

### Key Characteristics

* Fixed size
* 0-based indexing
* O(1) access using index
* Homogeneous data

---

### Time & Space Complexity

| Operation              | Complexity |
| ---------------------- | ---------- |
| Access by index        | O(1)       |
| Traversal              | O(n)       |
| Search (unsorted)      | O(n)       |
| Search (sorted)        | O(log n)   |
| Insert/Delete (middle) | O(n)       |

---

### Golden Rules 🧠

* **Sorted + Search → Binary Search**
* **Remove / Filter → Two Pointers**
* **Subarray / Range → Sliding Window**
* Always move pointers
* Read the return type carefully

---

## 🔑 Core Array Patterns (Very Important)

### 1. Traversal

```java
for (int i = 0; i < nums.length; i++) {
    // logic
}
```

### 2. Two Pointers

```java
int k = 0;
for (int i = 0; i < nums.length; i++) {
    if (nums[i] != val) {
        nums[k++] = nums[i];
    }
}
```

### 3. Sliding Window

```java
int left = 0;
for (int right = 0; right < nums.length; right++) {
    // expand
    while (condition) {
        left++;
    }
}
```

### 4. Binary Search

```java
int l = 0, r = nums.length - 1;
while (l <= r) {
    int mid = l + (r - l) / 2;
}
```

---

## ❌ Common Mistakes

* Infinite loops (pointers not moving)
* Using linear search where binary search is expected
* Wrong return value (index vs length)
* Index out of bounds
* Ignoring constraints

---

# 📚 Arrays — Solved Problems Index

This section tracks all **array problems implemented in this repository**, organized by difficulty and concept.  
Each entry links directly to the corresponding Java file.

---

## 🧱 Basics

| # | LC # | Problem | Concept | Link |
|---|------|--------|--------|------|
| 1 | — | Insert At End | Basic insertion | [InsertAtEnd](Basics/InsertAtEnd.java) |
| 2 | — | Insert At Index | Shifting elements | [InsertAtIndex](Basics/InsertAtIndex.java) |
| 3 | 88 | Merge Sorted Arrays | Two Pointers / Merge | [MergeSortedArrays88](Basics/MergeSortedArrays88.java) |
| 4 | — | Reverse In Groups | Reversal logic | [ReverseInGroups](Basics/ReverseInGroups.java) |

---

## 🟢 Easy

| # | LC # | Problem | Concept | Link |
|---|------|--------|--------|------|
| 1 | 217 | Contains Duplicate | HashSet | [ContainsDuplicate217](Easy/ContainsDuplicate217.java) |
| 2 | 219 | Contains Duplicate II | Hashing / Index tracking | [ContainsDuplicateII](Easy/ContainsDuplicateII.java) |
| 3 | — | Max Index | Traversal / comparison | [MaxIndex](Easy/MaxIndex.java) |
| 4 | 643 | Maximum Average Subarray I | Fixed Sliding Window | [MaximumAverageSubArrayI643](Easy/MaximumAverageSubArrayI643.java) |
| 5 | — | Mean & Median | Math + sorting | [MeanMedian](Easy/MeanMedian.java) |
| 6 | 283 | Move Zeroes | Two pointers | [MoveZeroes283](Easy/MoveZeroes283.java) |
| 7 | 26 | Remove Duplicates from Sorted Array | Two pointers | [RemoveDuplicates26](Easy/RemoveDuplicates26.java) |
| 8 | 27 | Remove Element | Two pointers / in-place | [RemoveElement27](Easy/RemoveElement27.java) |
| 9 | 977 | Squares of a Sorted Array | Two pointers | [SquaresOfSortedArray977](Easy/SquaresOfSortedArray977.java) |

---

## 🟡 Medium

| # | LC # | Problem | Concept | Link |
|---|------|--------|--------|------|
| 1 | 40 | Combination Sum II | Backtracking | [CombinationSumII40](Medium/CombinationSumII40.java) |
| 2 | 11 | Container With Most Water | Two pointers | [ContainerWithMostWater11](Medium/ContainerWithMostWater11.java) |
| 3 | — | Max and Second Max | Traversal | [MaxAndSecondMax](Medium/MaxAndSecondMax.java) |
| 4 | 209 | Minimum Size Subarray Sum | Variable Sliding Window | [MinimumSizeSubarraySum209](Medium/MinimumSizeSubarraySum209.java) |
| 5 | 1343 | Num of Sub-arrays of Size K and Avg >= Threshold | Fixed Sliding Window | [NumOfSubArrays1343](Medium/NumOfSubArrays1343.java) |
| 6 | 27 | Remove Element | Two pointers / in-place | [RemoveElement27](Medium/RemoveElement27.java) |
| 7 | 33 | Search in Rotated Sorted Array | Binary search | [SearchInRotatedArray](Medium/SearchInRotatedArray.java) |
| 8 | — | Sorted and Rotated Check | Array properties | [SortedAndRotated](Medium/SortedAndRotated.java) |
| 9 | 167 | Two Sum II — Input Array Is Sorted | Two pointers | [TwoSum_II](Medium/TwoSum_II.java) |

---


## 🧠 Notes for Revision

- Every solved problem should be:
    - Dry-run manually
    - Analyzed for time & space complexity
    - Mapped to a known pattern (two pointers, binary search, etc.)

- When revising:
    - Re-solve without looking at code
    - Explain logic out loud
    - Handle edge cases explicitly

---



## 🧠 Revision Checklist

*  Can explain logic without code
*  Can dry run confidently
*  Knows time & space complexity
*  Understands edge cases
*  Can identify pattern quickly

---