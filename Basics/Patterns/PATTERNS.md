# Phase 0.4 — Pattern Problems (Parallel Track)


## Nature
Skill reinforcement, not core logic building

Pattern problems are useful **only if treated correctly**.  
They should support learning, not distract from real problem-solving.

---

## What Pattern Problems Are Actually Training

Pattern problems mainly build:
- Loop control confidence
- Nested loop understanding
- Row–column thinking
- Execution order awareness

Pattern problems do **not** train:
- Problem decomposition
- Edge-case thinking
- Data structure logic

This makes Phase 0.4 a **support phase**, not a foundation phase.

---

## How to Solve TakeUForward Pattern Problems Correctly

### Rule 1: Think in Rows, Not Stars
Never think:
> “How do I print stars?”

Always think:
- How many rows are there?
- What changes per row?
- What stays constant across rows?

---

### Rule 2: Fix One Row First
Before writing loops, answer:
- For row `i`, what exactly gets printed?
- How many characters are printed?
- In what order are they printed?

If you can describe one row clearly in English, writing the code becomes straightforward.

---

### Rule 3: Nested Loop Mental Model
Use this mental mapping:
```

Outer loop  → rows
Inner loop  → columns / elements inside a row

```

If this mapping is unclear, pattern problems will feel random and confusing.

---

## Mandatory Dry Run for Patterns

Dry runs are required even for pattern problems.

Example pattern:
```

*

**
***
---

````

Dry run:
- Row 1 → print 1 star
- Row 2 → print 2 stars
- Row 3 → print 3 stars

Only after this should you map the logic to loops.

This reinforces Phase 0.3 execution thinking.

---

## What to Write in Notes (Minimal)

Do not write long explanations.

For each pattern, write only:
```md
Pattern Insight
- Rows = n
- Columns depend on row index
- Inner loop runs `i` times
````
---

## Common Mistakes to Avoid

* Blindly memorizing TakeUForward solutions
* Copying nested loops without understanding
* Over-optimizing print logic
* Spending excessive time on patterns

Patterns should feel **mechanical**, not clever.

---

## Time Bound (Important)

Set a strict limit:

* 5–7 days maximum
* Solve patterns alongside other learning
* Stop once patterns start feeling boring

If they feel boring, they have served their purpose.

---

## Success Check for Phase 0.4

You are done when:

* You can derive patterns without references
* Nested loops feel predictable
* Off-by-one mistakes stop occurring

At this point, move on immediately.

---