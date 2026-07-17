# Recursion - Array/String Recursion

## Problems

1. ReverseAnArray.java
2. CheckPalindromeString.java

## What I learned

- Both problems use the same two-pointer pattern: one pointer from the start,
  one from the end, moving inward each recursive call.
- Base case for both: start >= end (pointers met or crossed).

- CheckPalindromeString: compares characters, returns boolean. Has an early exit -
  if characters don't match, return false immediately without going deeper.
  Doesn't wait for full recursion to unwind like Factorial/Sum did.

- ReverseAnArray: swaps elements in place, returns void. The "result" here isn't
  a returned value, it's a side effect - the array itself gets modified.
  Different from CheckPalindromeString which just checks a condition and returns
  true/false without changing anything.

- Same skeleton (two pointers + move inward), but two different jobs:
  one modifies data, one just checks a condition. Good to notice which of my
  functions return a value vs which just do work directly on the data.

## Mistakes I made / things to remember

- Almost forgot ReverseAnArray doesn't need a return value since it mutates
  the array directly - void is correct here, not int/boolean.