            CONSTRAINTS AWARENESS

#  PHASE 0.2 — CONSTRAINTS AWARENESS

🎯 Goal:
When you see constraints, your brain should *automatically* know:

what is possible
what is impossible
what is risky



##  What are Constraints? (Very simply)

Constraints tell you:
* how big the input can be
* how much work your solution can do

They are **limits**, not decorations.

Example:
```
1 ≤ n ≤ 10^5
```

Means:

* input can be small or very large
* your solution must handle the **worst case**

---

##  The Core Mental Map (MEMORIZE THIS)

You **must internalize** this table.

| Input Size (n) | What is usually OK |
| -------------- | ------------------ |
| n ≤ 100        | O(n²) acceptable   |
| n ≤ 10⁴        | O(n log n)         |
| n ≤ 10⁵        | O(n log n) or O(n) |
| n ≤ 10⁶+       | O(n) only          |

You don’t need proofs yet.
Just **recognition**.

---

## How to READ Constraints (Step-by-Step)

When you see constraints, ask **in this order**:

### What grows?

* array length?
* string length?
* number of test cases?

This is your `n`.

---

### Maximum size?

Look for:

```
n ≤ ?
```

This tells you **how careful you must be**.

---

### Value range?

Look for:

```
-10⁹ ≤ nums[i] ≤ 10⁹
```

This tells you:

* overflow risks
* data type awareness (int vs long)

---

### Time limit (implicit)

Most platforms allow:

* ~10⁷–10⁸ operations per second

So:

* O(n²) with n=10⁵ Wrong
* O(n) with n=10⁵ Right

---

## Example: Two Sum (Revisited, but differently)

Constraints (typical):

```
2 ≤ nums.length ≤ 10⁴
```

What this tells you (WITHOUT solving):

* nested loops might be risky
* single-pass solutions are safer

You do NOT write solution yet.
You just **feel the pressure**.

---

## Common Constraint Signals (VERY IMPORTANT)

Learn to recognize these instantly:

### Big n

```
n ≤ 10⁵ or more
```

Signal:

* avoid nested loops

---

### Small n

```
n ≤ 100
```

Signal:

* brute force is fine

---

###  Multiple test cases

```
1 ≤ T ≤ 10⁵
```

Signal:

* total complexity matters

---

###  Range queries

```
many queries
```

Signal:

* precomputation may be needed (later phases)

---