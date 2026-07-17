# Hashing 

## What is hashing

Hashing means storing information about data so you can look it up instantly later, instead of searching for it every time. 

Example: if you want to know "how many times does 5 appear in this array?", you could loop through the array every time someone asks (slow). Or you could go through the array once, count everything, and store it in a map/array - then answer any questions instantly. 
That's hashing: do the work once, remember it, reuse it. 

## What's inside 

- `01_Basics/` - counting frequency of numbers and characters 
- `02_Collision_Handling/` - theory on how HashMaps handle two different keys landing in the same spot (chaining, open addressing) - no coding problems, just concepts 

## Mistakes / things to remember 

- Don't use Hashmap for character counting - a 26-size array is simpler and faster. 
- `map.get(key) + 1` throws an error if the key isn't in the map yet - always use `getOrDefault` instead. 
- HashMap lookups are 0(1) on average, not guranteed worst case. 