# Phase 0.3 — Loops, Conditions & Dry Runs

## Goal
Build the ability to trace code step-by-step and explain *why* a result happens — without running the program.

This phase fixes:
- “I wrote correct logic but output is wrong”
- “I don’t know where it broke”
- Debugger dependency

Understanding here means thinking like the CPU.

---

## What You Are Actually Learning

This phase is not about loop syntax.

You are learning to:
- Follow execution order
- Evaluate `if / else` conditions correctly
- Track variable changes
- Predict output before running code

---

## Core Skills to Build

### A. Loop Execution Awareness
You must clearly know:
- When a loop starts
- When it stops
- How many times it runs
- What changes in each iteration

Ask yourself:
- What is the loop variable value right now?
- Will this loop terminate?
- Which line executes next?

---

### B. Condition Evaluation
For every `if` statement:
- When does it enter?
- When does it skip?
- Why is the condition true or false?

Never think:
> “I think it will go inside”

Always think:
> “Condition is true because …”

---

### C. Variable Tracking (Most Important)
Track for each variable:
- Name
- Current value
- When it changes
- Why it changes

This is the heart of dry runs.

---

## What Is a Dry Run?
A dry run means:
> Manually executing code line by line using a small input, without running it on a computer.

You simulate exactly what the CPU does.

---

## How to Do a Dry Run (Step-by-Step)

### Step 1: Pick a Small Input
Never dry run large inputs.

Example:
```

nums = [2, 4, 1]

```

---

### Step 2: Create a Tracking Table
Use any clear format.

Example:
```

| Line | i | nums[i] | result | Condition |

```

Clarity matters more than formatting.

---

### Step 3: Walk Line by Line
Repeatedly ask:
- Which line runs now?
- What changes here?
- What is skipped?

Do not jump steps.

---

## Conceptual Example (No Full Solution)

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

Execution:
- i = 0 → nums[0] = 1 → condition false → sum = 0
- i = 1 → nums[1] = 3 → condition true → sum = 3
- i = 2 → nums[2] = 2 → condition false → sum = 3

Final output: `3`

If you can narrate this clearly, you understand it.

---
### Inside Each Problem Note
Add this section:

```

## Dry Run (Manual)

Input used:
Steps:

* Step 1:
* Step 2:
* Step 3:

Final Output:

```

Logic narration only — no code.

---

## What Not to Do in Phase 0.3
- Do not write full solutions
- Do not optimize
- Do not rely on a debugger
- Do not skip dry runs

Understanding equals the ability to dry run.

---