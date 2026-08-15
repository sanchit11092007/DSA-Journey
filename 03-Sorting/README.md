# Sorting

## Problems

1. SelectionSort.java
2. BubbleSort.java
3. InsertionSort.java
4. MergeSort.java
5. QuickSort.java

## What I learned

- Selection, Bubble, and Insertion Sort are all O(n^2) comparison-based
  sorts, but they build the sorted part in different ways:
  - Selection Sort: find the min in the unsorted part, swap it into place
    (one swap per pass, max)
  - Bubble Sort: repeatedly swap adjacent out-of-order elements, largest
    "bubbles" to the end each pass (can do many swaps per pass)
  - Insertion Sort: pick each element as a "key", shift bigger elements
    right, then insert key into the gap (no swaps, just shifts)
- Bubble Sort and Insertion Sort can hit O(n) best case if the array is
  already sorted (Bubble via the swapped flag, Insertion via minimal
  shifting). Selection Sort can NEVER do better than O(n^2), no matter
  the input, because it always scans the full unsorted range to find
  the min.
- Shifting (Insertion Sort) does fewer writes than swapping (Bubble/
  Selection) since a swap = 3 assignments, a shift = 1.
- Merge Sort and Quick Sort are both divide and conquer, but split the
  "hard work" in opposite places:
  - Merge Sort: trivial split (always exact half), hard work happens
    AFTER recursion, in the merge step
  - Quick Sort: hard work happens BEFORE recursion, in the partition
    step. After partitioning, no merge needed - pivot is already in its
    final position.
- Merge Sort is always O(n log n) regardless of input, since it always
  splits exactly in half. Quick Sort is O(n log n) average but can
  degrade to O(n^2) worst case with bad pivot choice (e.g. first-element
  pivot on an already-sorted array).
- Merge Sort needs O(n) extra space (temp array for merging). Quick Sort
  sorts in-place, only needs O(log n) extra space for the recursion
  stack.
- The two-pointer merge technique in Merge Sort will reappear later in
  problems like merging two sorted arrays/linked lists.
- The partition-around-pivot logic in Quick Sort is the basis for
  Quickselect (Kth largest/smallest element problems later).

## Mistakes I made / things to remember

- In Insertion Sort's while loop, condition MUST be
  `j >= 0 && arr[j] > key` in that order - reversed order causes
  ArrayIndexOutOfBoundsException when j = -1.
- In Selection Sort, the `minIndex != i` check avoids a pointless
  self-swap (not required, but cleaner).
- Intermediate duplicate values during Insertion Sort's shifting (e.g.
  [64, 64, 12, 22, 11] mid-pass) are normal, not a bug.
- Use `mid = low + (high - low) / 2` instead of `(low + high) / 2` to
  avoid integer overflow on large arrays - good habit regardless of
  input size.
- Base case for both Merge Sort and Quick Sort is `low >= high`, NOT
  `low == high` - needed to correctly handle empty ranges.
- In Quick Sort's partition function, watch the boundary condition
  `i < high` in the while loop to avoid going out of array bounds.
- Real-world Quick Sort implementations avoid the O(n^2) worst case
  using randomized or median-of-three pivot selection - not just a
  theoretical edge case.
