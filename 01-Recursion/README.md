# Recursion 

## What is Recursion? 
Recursion is a technique where a function calls itself to solve a smaller version of the same problem, until it reaches a case simple enough to answer directly (the base case). 

Every recursive function has two essential parts: 
1. **Base Case** - the condition that stops the recursion. Without this, the function calls itself forever and crashes with a `StackOverFlowError`. 

2. **Recursive Case** - where the function calls itself again, but with an input that is smaller or simpler than before, moving it closer to the base case. 

```java 
void recurse(int n) {
    if (n == 0) return ;  //base case 
    System.out.println(n); 
    recurse(n-1);   // recursive case
}
```

---

## How Recursion Works Internally 
Every function call is pushed onto the **call stack**. Each call waits (paused) for the one below it to finish before it can continue and return. 

For `recurse(3)`: 
recurse(3) → recurse(2) → recurse(1) → recurse(0) [base case hit, starts returning] 
← returns 
← returns 
← returns 

This is why deep recursion has a **space cost of O(N)** - each pending call takes up memory on the stack until it resolves. 

--- 

## Order of Execution Matters 

Where you place the recursive call relative to your other statements changes the output order. 

## Types of Recursion 

- **Head Recursion** - the recursive call happens first, work happens after the call returns (e.g. printing 1 to N). 

- **Tail Recursion** - the recursive call is the last statement, work happens before the call (e.g. printing N to 1)

- **Multiple Recursion** - the function calls itself more than once per call (e.g. Fibonacci, permutations).

## Recursion vs Iteration 

| Recursion | Iteration | 
|---------- | --------- |
| Uses call stack (extra space) | Uses a loop (constant space) | 
|Easier to express divide-and-conquer problems | Easier for simple repeated tasks | 
| Risk of stack overflow on deep calls | No stack overflow risk | 
| Often cleaner/ shorter code | Sometimes more verbose | 

--- 

## Common Pitfalls 

- Forgeting the base case, or writing one that's never actually reached 
- Not reducing the problem size on each call (infinite recursion)
- Using recursion where a simple loop would be clearer and more efficient
- Underestimating time complexity -recursive solutions like naive Fibonacci can hit **0(2^N)** if subproblems overlap and aren't reused

--- 

## Why Recursion Matters Going Forward
Recursion is the foundation for several major topics later on: 

- **Backtracking** (subsets, permutations, N-Quenns, Sudoku) - recursion plus the ability to "undo" a choice and try another
- **Dynamic Programming** - recognizing overlapping subproblems in a recursion tree (like in Fibonacci) is what motivates memoization
- **Divide and Conquer** (merge sort, quick sort) - breaking a problem into smaller independent subproblems.