# Hashing - 02-Collision-Handling

## Problems
- No coding problems in this folder — theory only, since Striver's sheet doesn't
  have a coding question for collision handling itself.

## What I learned
- A collision happens when two different keys hash to the same index/bucket. With a
  fixed number of buckets and a much larger number of possible keys, collisions are
  guaranteed to happen eventually — not a bug, just math (pigeonhole principle).
- Two main ways to handle it:
  1. Chaining — each bucket holds a list of everything that hashed there. On
     collision, just add to that list. This is what Java's HashMap actually uses
     internally.
  2. Open addressing — no lists, everything lives directly in the array. On
     collision, probe for the next open slot (linear probing, quadratic probing,
     or double hashing depending on how you pick the next slot).
- Java's HashMap specifically uses chaining, and since Java 8, if a single bucket
  gets 8+ collisions, that bucket's list gets converted into a balanced tree instead
  (treeification) — keeps worst-case lookup from degrading too badly.
- HashMap has a default load factor of 0.75 — once it's 75% full, it resizes (doubles
  capacity) and rehashes everything. This is why HashMap operations are "amortized"
  O(1), not strictly guaranteed O(1) every single time.

## Mistakes I made / things to remember
- Don't assume "HashMap = zero collisions." Collisions are expected and handled
  internally — the data structure is built to survive them, not avoid them.
- If I ever use a custom object as a HashMap key, I need to override both
  hashCode() and equals() together. Overriding only one means logically equal
  objects get treated as different keys, which is a common and confusing bug.
- "O(1) average case" for HashMap operations has an asterisk — worst case (bad hash
  distribution, too many collisions in one bucket) can degrade to O(log n) in modern
  Java (post-treeification) or O(n) in a naive implementation.