# Hashing - 01-Basics

## Problems
1. NumberHashing.java
2. CharacterHashing.java

## What I learned
- Hashing is basically: do one pass to remember something, then answer questions
  about the data instantly (O(1)) instead of rescanning every time.
- Array hashing only works when the key space is small and known upfront. For numbers,
  that means knowing the max value ahead of time (e.g. 0 to 1000). For characters,
  the key space is always fixed by the language — 26 letters — so it always works there.
- Same core pattern in both problems: map each key to an index, increment count at
  that index, then read the count later for O(1) queries.
- For character hashing with both cases, splitting into two separate 26-size arrays
  (one for lowercase, one for uppercase) is cleaner than trying to fit both into one
  52-size array with offset math.

## Mistakes I made / things to remember
- Array size for number hashing has to be maxVal + 1, not just maxVal — otherwise the
  last valid value throws an index out of bounds error.
- Array hashing breaks completely if numbers are negative or too large to allocate
  an array for (like 10^9) — that's the signal to switch to a HashMap instead of
  forcing the array approach.
- For character hashing, non-letter characters (spaces, digits, symbols) need to be
  skipped explicitly with the if/else check — otherwise the index math goes wrong
  and either crashes or corrupts unrelated counts.