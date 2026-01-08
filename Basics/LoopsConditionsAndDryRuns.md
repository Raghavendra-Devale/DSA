
#  PHASE 0.3 — Loops, Conditions & Dry Runs

**Goal:**
You should be able to **trace code step-by-step in your head or on paper** and say *why* a result happens.

This phase fixes:

* “I wrote correct logic but output is wrong”
* “I don’t know where it broke”
* “Debugger dependency”

---

##  What You Are ACTUALLY Learning Here

Not loops syntax — you already know that.

You are learning to:

* follow execution order
* understand branching (`if / else`)
* track variable changes
* predict output **before running code**

This is **thinking like the CPU**.

---

## Core Skills You Must Build

### A. Loop Execution Awareness

You must clearly know:

* when a loop starts
* when it stops
* how many times it runs
* what changes every iteration

Example mental questions:

* What is `i` at each step?
* Does this loop ever terminate?

---

### B. Condition Evaluation

For every `if`:

* when does it enter?
* when does it skip?
* what happens to variables inside?

You should never say:

> “I think it will go inside”

You should say:

> “Condition is true because …”

---

### C. Variable Tracking (MOST IMPORTANT)

This is the heart of dry runs.

You track:

* variable name
* current value
* when it changes
* why it changes

---

## What Is a Dry Run? (Plain English)

A dry run means:

> Executing the code **line by line** using a sample input, without running it on a computer.

You simulate execution **manually**.

---

##  How to Do a Dry Run (STEP-BY-STEP)

### Step 1: Pick SIMPLE input

Never dry run with large input.

Example:

```
nums = [2, 4, 1]
```

---

### Step 2: Create a Table (WRITE THIS)

In your notes, do this:

```md
| Line | i | current value | result | Condition |
|-----|---|---------------|--------|-----------|
```

You don’t need perfect format — clarity matters.

---

### Step 3: Walk Line by Line

Ask repeatedly:

* Which line runs now?
* What changes here?
* What is skipped?

This builds **execution confidence**.

---

##  Example (Conceptual, NOT Solution)

Pseudo-code:

```
sum = 0
for i from 0 to n-1:
    if nums[i] > 2:
        sum = sum + nums[i]
```

Dry run input:

```
nums = [1, 3, 2]
```

Mental flow:

* i = 0 → nums[0] = 1 → condition false → sum stays 0
* i = 1 → nums[1] = 3 → condition true → sum = 3
* i = 2 → nums[2] = 2 → condition false → sum stays 3

Final output = 3

This is **exactly** what you must be able to do.

---





```md
# Phase 0.3 — Loops, Conditions & Dry Runs

## What this phase trains
- Understanding execution flow
- Evaluating conditions correctly
- Tracking variable changes
- Debugging without a debugger

## Dry Run Rules
- Use small inputs
- Track variables explicitly
- Execute line by line
- Never skip steps

## Common Mistakes
- Forgetting variable updates
- Assuming condition outcome
- Skipping loop boundaries
```

---

### 🧪 Inside EACH problem `.md`, add this section:

```md
## Dry Run (Manual)

Input used:
Steps:
- Step 1:
- Step 2:
- Step 3:

Final Output:
```

No code required — logic narration is enough.

---