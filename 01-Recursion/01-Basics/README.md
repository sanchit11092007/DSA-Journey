# Recursion - Basics

## Problems

1. PrintNTimes.java
2. PrintNumbers1ToN.java
3. PrintNumbersNTo1.java
4. SumOfFirstNNumbers.java

## What I learned

- Base case = when to stop. Recursive case = how it moves toward the base case.
- If work is written AFTER the recursive call → prints in increasing order (1 to N).
- If work is written BEFORE the recursive call → prints in decreasing order (N to 1).
- SumOfFirstNNumbers is different from the first 3 — it returns a value instead of just printing.
  Each call waits for the smaller call below it to return before it can compute its own answer.

sum(5) = 5 + sum(4) = 5 + 4 + sum(3) = ... = 15

## Mistakes I made / things to remember

- Forgetting base case → StackOverflowError
- Java class names are case-sensitive when running, even though Windows filenames aren't.
  javac PrintNumbersNTo1.java → java PrintNumbersNTo1 (must match exact capitalization of "public class")