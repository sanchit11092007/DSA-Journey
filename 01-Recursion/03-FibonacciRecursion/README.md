# Recursion - Fibonacci Recursion

## Problems

1. FibonacciNumber.java
2. FibonacciSequence.java

## What I learned

- Fibonacci: fib(n) = fib(n-1) + fib(n-2). Base cases: fib(0) = 0, fib(1) = 1.
- First problem with TWO recursive calls per call instead of one - called "multiple recursion".
  The recursion tree branches into 2 instead of being a straight line.

- Overlapping subproblems: fib(2) gets computed multiple times across different branches
  of the tree - same calculation repeated wastefully. This is why fib is O(2^N), very slow
  for large n (try n=40, visibly laggy).

- This overlapping subproblem thing is exactly what memoization/DP fixes later - important
  to actually understand WHY it's slow here so DP makes sense when I get to it.

- FibonacciSequence.java: reused fib(n) but wrapped it in a plain for loop to print
  all terms up to N. Not everything has to be recursive just because the topic is recursion -
  used recursion only where it made sense (single term), loop to drive it across a range.

- This makes FibonacciSequence WORSE than FibonacciNumber in complexity - O(N * 2^N) since
  fib(i) is recomputed fresh for every term with no reuse at all.

## Mistakes I made / things to remember

- Almost assumed printSequence needed to be recursive too - it doesn't, only fib() does.
- Note to self: try building the sequence without a for loop later (pure recursion,
  passing a list/array through the calls) - good exercise once comfortable with this version.