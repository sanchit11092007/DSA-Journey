# Recursion - Advanced Problems

## Problems

1. PrintAllPermutations.java

## What I learned

- First problem using backtracking: choose -> recurse -> un-choose (swap back).
  The "un-choose" step is what makes it backtracking, not just recursion.

- Approach: fix one position at a time (start index). For that position, try
  every remaining element by swapping it in, recurse to fix the next position,
  then swap back before trying the next candidate.

- If you skip the swap-back, the array stays permanently modified and later
  permutations come out wrong/duplicated. Tested this myself by commenting
  out the swap-back line - confirmed it breaks.

- First time recursion is inside a loop, not just a single recursive call.
  This "loop + recurse" shape is what backtracking problems look like going
  forward (subsets, N-Queens, Sudoku will follow this same pattern).

## Mistakes I made / things to remember

- Forgot to swap back on first attempt - permutations came out duplicated/wrong.
- This is O(N! * N) not O(N!) - the extra N is from copying each permutation
  into the result list.