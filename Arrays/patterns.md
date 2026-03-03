
---

# 🧠 Two Pointer Mastery Document

---

# 1️⃣ Core Philosophy

Two Pointer Technique is about:

> Controlling iteration boundaries to eliminate redundant comparisons and reduce time complexity.

It is NOT about “using two variables”.

It is about:

* Maintaining invariants
* Managing a dynamic range
* Moving pointers with intent

---

# 2️⃣ Master Pattern Classification

---

## A) Slow–Fast (Same Direction)

Use When:

* In-place compaction
* Removing elements
* Removing duplicates
* Maintaining valid prefix

Invariant Template:

```
arr[0..slow-1] → always valid
fast → scans new elements
```

Time: O(n)
Space: O(1)

---

## B) Converging (Opposite Direction)

Use When:

* Sorted arrays
* Pair sum problems
* Reversing
* Palindrome checks

Invariant Template:

```
left < right
Move pointer based on condition.
```

---

## C) Sliding Window (Dynamic Window)

Use When:

* Index distance constraints
* Subarray problems
* Longest/shortest window
* Duplicate constraints

Invariant Template:

```
Window = arr[left..right]
Maintain window validity.
Shrink when invalid.
```

---

## D) Swap With Boundary (Order Not Required)

Use When:

* Removing elements
* Partition problems
* Order irrelevant

Invariant:

```
Elements after n are discarded.
Current index must be rechecked after swap.
```

---

# 3️⃣ Problems Solved

---

## 1️⃣ Contains Duplicate

Pattern:
Membership Tracking (HashSet)

Time: O(n)
Space: O(n)

Core Idea:
Check if element already seen.

Learning Trigger:
If question says:
“Return true if any value appears twice”
→ Think membership structure immediately.

Mistake:
Initially considered nested loops.

---

## 2️⃣ Contains Duplicate II

Pattern:
Sliding Window + HashSet

Time: O(n)
Space: O(k)

Core Idea:
Maintain a window of last k elements.

Invariant:
Set contains only elements within index range k.

Learning Trigger:
If condition involves:
|i - j| <= k
→ Think sliding window.

---

## 3️⃣ Move Zeroes

Pattern:
Slow–Fast Compaction

Time: O(n)
Space: O(1)

Core Idea:
Move non-zero elements forward.
Fill remaining positions with zero.

Invariant:
arr[0..j-1] always non-zero.

Optimization Insight:
Overwrite method is better than swap (fewer operations).

---

## 4️⃣ Remove Duplicates from Sorted Array

Pattern:
Slow–Fast Pointer

Time: O(n)
Space: O(1)

Core Idea:
Sorted → duplicates adjacent.

Invariant:
arr[0..i] always unique.

Learning Trigger:
If array is sorted and duplicates involved
→ Think adjacent comparison with slow-fast.

---

## 5️⃣ Remove Element

Patterns Used:

* Shifting (O(n²))
* Overwrite
* Swap with last (order not required)

Core Insight:
When order doesn't matter → swap with boundary.

Important Detail:
Do NOT increment pointer immediately after swap.

---

# 4️⃣ Pattern Evolution Roadmap

Level 1 (You are here)

* Basic compaction
* Basic sliding window
* Membership detection

Level 2

* Longest Substring Without Repeating Characters
* Two Sum II
* Container With Most Water
* Sort Colors (Dutch National Flag)

Level 3

* 3Sum
* Minimum Size Subarray Sum
* Subarray with K distinct integers
* Advanced sliding window optimizations

---

# 5️⃣ Common Failure Points

* Not defining invariant clearly
* Moving wrong pointer
* Off-by-one errors
* Removing wrong element from window
* Forgetting to recheck swapped value
* Jumping to optimization without brute clarity

---
<!-- 
# 6️⃣ Template for Adding New Problems

Copy this each time:

---

## Problem Name:

Pattern:

Time Complexity:
Space Complexity:

Core Idea:

Invariant:

Why Two Pointers Worked Here:

Mistake I Made:

What Trigger Should I Remember Next Time:

Difficulty Level:
(Easy / Medium / Hard)

---
 -->
