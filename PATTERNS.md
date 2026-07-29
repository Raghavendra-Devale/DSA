# 🧩 DSA Pattern Notes — Quick Reference

> One place for **every pattern template** used in this project.  
> Study the skeleton first → then look at solved problems for context.

---

## 📋 Pattern Index

| Pattern | When to Use |
|---------|------------|
| [Two Pointers — Opposite Ends](#two-pointers--opposite-ends) | Sorted array, palindrome, sum targets |
| [Two Pointers — Same Direction](#two-pointers--same-direction-fastslow) | Remove/filter in-place, partition |
| [Sliding Window — Fixed Size](#sliding-window--fixed-size) | Max/min/avg over window of size k |
| [Sliding Window — Variable Size](#sliding-window--variable-size) | Smallest/longest subarray meeting condition |
| [Binary Search — Classic](#binary-search--classic) | Sorted array lookup |
| [Binary Search — Rotated Array](#binary-search--rotated-array) | Search in rotated sorted array |
| [Hashing / HashSet](#hashing--hashset) | Duplicate detection, index tracking |
| [Bit Manipulation](#bit-manipulation) | Counting bits, powers of 2, XOR tricks |
| [Math / Number Theory](#math--number-theory) | GCD, primes, digit operations |
| [Recursion / Backtracking](#recursion--backtracking) | Combinations, permutations, subsets |
| [Linked List — Two Pointers](#linked-list--two-pointers) | Merge sorted lists, detect cycle |
| [Traversal / Linear Scan](#traversal--linear-scan) | Simple max/min, frequency counts |

---

## Two Pointers — Opposite Ends

**When:** Array is sorted (or order does not matter). Find a pair/trio meeting a condition.

```java
int left = 0, right = n - 1;

while (left < right) {
    if (conditionMet()) {
        // record answer
        left++;
        right--;
    } else if (needBigger()) {
        left++;
    } else {
        right--;
    }
}
```

**Key insight:** Move the pointer that makes progress toward the condition.

| Problem | File |
|---------|------|
| Two Sum II | [TwoSum_II.java](Arrays/Medium/TwoSum_II.java) |
| Container With Most Water | [ContainerWithMostWater11.java](Arrays/Medium/ContainerWithMostWater11.java) |
| Squares of Sorted Array | [SquaresOfSortedArray977.java](Arrays/Easy/SquaresOfSortedArray977.java) |
| Valid Palindrome | [ValidPalindrome125.java](Strings/easy/ValidPalindrome125.java) |
| Palindrome String Check | [PalindromeString.java](Strings/basics/PalindromeString.java) |
| Merge Sorted Arrays | [MergeSortedArrays88.java](Arrays/Basics/MergeSortedArrays88.java) |

---

## Two Pointers — Same Direction (Fast/Slow)

**When:** Remove elements in-place, move matching elements to front, compress array.

```java
int slow = 0;                           // write pointer — next valid slot

for (int fast = 0; fast < n; fast++) { // read pointer — scouts ahead
    if (isValid(nums[fast])) {
        nums[slow] = nums[fast];
        slow++;
    }
}
// slow == new length of valid portion
return slow;
```

**Key insight:** `slow` marks the "clean" boundary. `fast` scouts ahead. Never let `slow` overtake `fast`.

| Problem | File |
|---------|------|
| Remove Element | [RemoveElement27.java](Arrays/Easy/RemoveElement27.java) |
| Remove Duplicates from Sorted Array | [RemoveDuplicates26.java](Arrays/Easy/RemoveDuplicates26.java) |
| Move Zeroes | [MoveZeroes283.java](Arrays/Easy/MoveZeroes283.java) |
| Move Zeros (Foundations) | [MoveZeros283.java](Foundations/MoveZeros283.java) |
| Reverse String | [ReverseString344.java](Foundations/ReverseString344.java) |

---

## Sliding Window — Fixed Size

**When:** Problem gives exact window size `k`. Find max/min/sum/count within that window.

```java
// Step 1: Build first window
int windowSum = 0;
for (int i = 0; i < k; i++) {
    windowSum += nums[i];
}

int result = windowSum;

// Step 2: Slide — add right element, drop left element
for (int right = k; right < n; right++) {
    windowSum += nums[right];        // new element entering window
    windowSum -= nums[right - k];   // element leaving window
    result = Math.max(result, windowSum);
}
```

**Key insight:** Window size is always exactly `k`. No shrinking needed — just slide and update.

| Problem | File |
|---------|------|
| Maximum Average Subarray I | [MaximumAverageSubArrayI643.java](Arrays/Easy/MaximumAverageSubArrayI643.java) |
| Num of Sub-arrays Size K Avg >= Threshold | [NumOfSubArrays1343.java](Arrays/Medium/NumOfSubArrays1343.java) |
| Max Vowels in Substring | [MaxVowelsInASubString1456.java](Strings/medium/MaxVowelsInASubString1456.java) |

---

## Sliding Window — Variable Size

**When:** Find the **smallest** or **longest** subarray/substring satisfying a condition. Window grows and shrinks dynamically.

```java
int left = 0;
int windowState = 0;              // e.g. running sum, distinct char count
int result = Integer.MAX_VALUE;   // use 0 for longest-window problems

for (int right = 0; right < n; right++) {
    // Expand: add current element into window
    windowState += nums[right];

    // Shrink: pull left in while window satisfies / over-satisfies condition
    while (windowIsValid()) {
        result = Math.min(result, right - left + 1); // record INSIDE for min-length
        windowState -= nums[left];
        left++;
    }

    // For max-length problems: record result OUTSIDE the while loop
}
```

**Key insight:**
- **Minimum length** → shrink while condition is met, record **inside** `while`.
- **Maximum length** → shrink while condition is violated, record **outside** `while`.

| Problem | File |
|---------|------|
| Minimum Size Subarray Sum | [MinimumSizeSubarraySum209.java](Arrays/Medium/MinimumSizeSubarraySum209.java) |

---

## Binary Search — Classic

**When:** Array is sorted. Looking for a target or a "true/false" boundary.

```java
int left = 0, right = nums.length - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;  // avoids integer overflow

    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        left = mid + 1;                   // target in right half
    } else {
        right = mid - 1;                  // target in left half
    }
}

return -1; // not found
```

**Key insight:** Always `mid = left + (right - left) / 2`. Loop condition is `left <= right`.

---

## Binary Search — Rotated Array

**When:** Array was sorted then rotated at some pivot. One half is always sorted.

```java
int left = 0, right = nums.length - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] == target) return mid;

    // Left half is sorted
    if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
            right = mid - 1;    // target in sorted left half
        } else {
            left = mid + 1;     // target must be in right half
        }
    }
    // Right half is sorted
    else {
        if (nums[mid] < target && target <= nums[right]) {
            left = mid + 1;     // target in sorted right half
        } else {
            right = mid - 1;    // target must be in left half
        }
    }
}

return -1;
```

**Key insight:** Identify which half is sorted → check if target falls within it → eliminate the other half.

| Problem | File |
|---------|------|
| Search in Rotated Sorted Array | [SearchInRotatedArray.java](Arrays/Medium/SearchInRotatedArray.java) |

---

## Hashing / HashSet

**When:** Check existence, detect duplicates, or track last-seen index — all in O(1).

### Duplicate Detection — HashSet
```java
Set<Integer> seen = new HashSet<>();

for (int num : nums) {
    if (seen.contains(num)) return true;  // duplicate found
    seen.add(num);
}
return false;
```

### Index Tracking — HashMap
```java
Map<Integer, Integer> map = new HashMap<>();  // value -> last seen index

for (int i = 0; i < nums.length; i++) {
    if (map.containsKey(nums[i])) {
        // map.get(nums[i]) gives the previous index
    }
    map.put(nums[i], i);
}
```

**Key insight:** HashMap gives O(1) lookup at the cost of O(n) space. Ask: *"What do I need to remember about each element?"*

| Problem | File |
|---------|------|
| Contains Duplicate | [ContainsDuplicate217.java](Arrays/Easy/ContainsDuplicate217.java) |
| Contains Duplicate II | [ContainsDuplicateII.java](Arrays/Easy/ContainsDuplicateII.java) |
| Happy Number | [HappyNumber202.java](Foundations/HappyNumber202.java) |
| Remove Duplicate Characters | [RemoveDuplicate.java](Strings/basics/RemoveDuplicate.java) |
| Roman to Integer | [RomanToInteger18.java](Strings/easy/RomanToInteger18.java) |

---

## Bit Manipulation

**When:** Binary representation, counting set bits, powers of 2, XOR tricks.

### Count Set Bits — Brian Kernighan's Algorithm
```java
int count = 0;
while (n != 0) {
    n = n & (n - 1);   // clears the lowest set bit
    count++;
}
```

### Check Power of Two
```java
// A power of 2 has exactly one set bit
return n > 0 && (n & (n - 1)) == 0;
```

### XOR Trick — Find Missing Number
```java
int xor = 0;
for (int i = 0; i <= n; i++) xor ^= i;     // XOR all expected values
for (int num : nums)          xor ^= num;   // XOR out all present values
// xor == missing number
```

### Reverse Bits
```java
int result = 0;
for (int i = 0; i < 32; i++) {
    result = (result << 1) | (n & 1);  // grab LSB of n, append to result
    n >>>= 1;                           // unsigned right shift
}
```

**Key insight:** `n & 1` = last bit. `n >> 1` = shift right. `n & (n-1)` = clears lowest set bit.

| Problem | File |
|---------|------|
| Number of 1 Bits | [NumberOf1Bits191.java](Foundations/NumberOf1Bits191.java) |
| Power of Two | [PowerOfTwo231.java](Foundations/PowerOfTwo231.java) |
| Reverse Bits | [ReverseBits190.java](Foundations/ReverseBits190.java) |
| Missing Number (XOR) | [MissingNumber268.java](Foundations/MissingNumber268.java) |

---

## Math / Number Theory

**When:** Digit operations, GCD/LCM, prime detection, divisibility checks.

### GCD — Euclidean Algorithm
```java
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;  // when b == 0, a is the GCD
}
```

### Sieve of Eratosthenes — Count Primes up to n
```java
boolean[] isComposite = new boolean[n];
for (int i = 2; (long) i * i < n; i++) {
    if (!isComposite[i]) {
        for (int j = i * i; j < n; j += i) {
            isComposite[j] = true;   // mark all multiples as composite
        }
    }
}
// count = number of 'false' entries from index 2 onward
```

### Digit Square Sum — Used in Happy Number
```java
int digitSquareSum(int n) {
    int sum = 0;
    while (n > 0) {
        int d = n % 10;    // extract last digit
        sum += d * d;
        n /= 10;           // remove last digit
    }
    return sum;
}
```

### Number Reversal — Used in Palindrome Number
```java
int reversed = 0;
while (n > 0) {
    reversed = reversed * 10 + n % 10;  // append last digit
    n /= 10;
}
```

| Problem | File |
|---------|------|
| Count Primes | [CountPrimes204.java](Foundations/CountPrimes204.java) |
| Find GCD of Array | [FindGCD_OfArray1979.java](Foundations/FindGCD_OfArray1979.java) |
| Happy Number | [HappyNumber202.java](Foundations/HappyNumber202.java) |
| Palindrome Number | [Palindrome9.java](Foundations/Palindrome9.java) |
| Power of Three | [PowerOfThree326.java](Foundations/PowerOfThree326.java) |
| Ugly Number | [UglyNumber263.java](Foundations/UglyNumber263.java) |

---

## Recursion / Backtracking

**When:** Explore all possible combinations, permutations, or subsets. Make a choice → recurse → undo.

```java
void backtrack(int start, List<Integer> current, List<List<Integer>> result) {
    // Base case — goal reached, record answer
    if (goalReached()) {
        result.add(new ArrayList<>(current));
        return;
    }

    for (int i = start; i < candidates.length; i++) {
        // Pruning — skip invalid or duplicate branches early
        if (shouldSkip(i)) continue;

        current.add(candidates[i]);          // Choose
        backtrack(i + 1, current, result);   // Explore
        current.remove(current.size() - 1);  // Unchoose (backtrack)
    }
}
```

**Key insight:** Always **undo exactly what you did** before the recursive call. Prune early with `continue`.

| Problem | File |
|---------|------|
| Combination Sum II | [CombinationSumII40.java](Arrays/Medium/CombinationSumII40.java) |
| Fibonacci Number | [FibonacciNumber509.java](Foundations/FibonacciNumber509.java) |
| Factorial | [Factorial.java](Mathematics/Factorial.java) |

---

## Linked List — Two Pointers

**When:** Merge sorted lists, detect cycles, find midpoint.

### Merge Two Sorted Lists
```java
ListNode dummy = new ListNode(0);
ListNode curr = dummy;

while (l1 != null && l2 != null) {
    if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
    } else {
        curr.next = l2;
        l2 = l2.next;
    }
    curr = curr.next;
}

curr.next = (l1 != null) ? l1 : l2;  // attach remainder
return dummy.next;
```

**Key insight:** Use a `dummy` node to avoid special-casing the head. Always advance `curr`.

| Problem | File |
|---------|------|
| Merge Two Sorted Lists | [MergeTwoSortedLists21.java](Foundations/MergeTwoSortedLists21.java) |

---

## Traversal / Linear Scan

**When:** Simple max/min, frequency count, character classification — no advanced pattern needed.

```java
int max = Integer.MIN_VALUE;
int secondMax = Integer.MIN_VALUE;

for (int num : nums) {
    if (num > max) {
        secondMax = max;    // old max becomes second
        max = num;
    } else if (num > secondMax && num != max) {
        secondMax = num;
    }
}
```

**Key insight:** One variable per thing you track. Update in the correct order — do not overwrite before you read.

| Problem | File |
|---------|------|
| Max Index | [MaxIndex.java](Arrays/Easy/MaxIndex.java) |
| Max and Second Max | [MaxAndSecondMax.java](Arrays/Medium/MaxAndSecondMax.java) |
| Character Count | [CharacterCount.java](Strings/basics/CharacterCount.java) |
| Vowels in Sentence | [Vowels_In_Sentence.java](Strings/basics/Vowels_In_Sentence.java) |
| Count Occurrence | [CountOccurrence.java](Strings/basics/CountOccurrence.java) |

---

## 🧠 Pattern Decision Tree

```
Problem involves array or string?
│
├── Is it sorted?
│   ├── Looking for a pair/triple   →  Two Pointers (Opposite Ends)
│   ├── Looking for one element     →  Binary Search (Classic)
│   └── Array was rotated?          →  Binary Search (Rotated)
│
├── Fixed window size k given?
│   └── Sliding Window — Fixed Size
│
├── Smallest / longest subarray meeting a condition?
│   └── Sliding Window — Variable Size
│
├── Remove / filter elements in-place?
│   └── Two Pointers — Same Direction
│
├── Duplicates / "seen before"?
│   └── HashSet or HashMap
│
├── Binary / bits / power of 2?
│   └── Bit Manipulation
│
└── All combinations / subsets?
    └── Backtracking
```

---

## ⚡ Complexity Cheat Sheet

| Pattern | Time | Space |
|---------|------|-------|
| Traversal / Linear Scan | O(n) | O(1) |
| Two Pointers | O(n) | O(1) |
| Sliding Window (Fixed) | O(n) | O(1) |
| Sliding Window (Variable) | O(n) amortized | O(1) |
| Binary Search | O(log n) | O(1) |
| HashSet / HashMap | O(n) | O(n) |
| Bit Manipulation | O(1) – O(log n) | O(1) |
| Sieve of Eratosthenes | O(n log log n) | O(n) |
| Backtracking | O(2^n) worst | O(n) stack |
| Merge Sorted Lists | O(n + m) | O(1) |

---

> 📌 **Rule of thumb:** If you cannot identify a pattern within 2 minutes, ask:  
> *"Is it sorted? Does it involve a range/subarray? Do I need all combinations?"*
