
```md
## Intuition Behind the Two Pointer Approach

The main challenge of this problem is understanding **which pointer to move** after calculating the area.

The container area depends on two factors:

- **Width** → `right - left`
- **Height** → `min(height[left], height[right])`

Even though the width is important, the **smaller height always limits the water capacity**.

### Key Observation

If we have two walls:

```

height[left] = 3
height[right] = 8

```

The water level cannot exceed **3**, because water would spill over the shorter wall.

So the container area is:

```

area = min(3,8) × width
= 3 × width

```

### What Happens If We Move the Taller Wall?

If we move the `right` pointer inward:

- The **width decreases**
- The **limiting height remains 3**

So the area will either **stay the same or decrease**.

Therefore, moving the taller wall **cannot produce a better result**.

### The Greedy Decision

The only chance to increase the area is to **find a taller wall than the current shorter one**.

So we move the pointer that points to the **shorter wall**.

```

if height[left] < height[right]
left++
else
right--

```

This greedy choice ensures that we explore only the possibilities that might increase the container height.

### Why This Works Efficiently

Instead of checking all possible pairs (`O(n²)`), the two-pointer approach eliminates impossible combinations by shrinking the search space intelligently.

Each pointer moves at most **n times**, giving a total time complexity of:

```

O(n)

```

### Core Insight

Always move the **shorter wall**, because the shorter wall determines the maximum possible water level.

Replacing the shorter wall is the only way to potentially increase the container height.
```

