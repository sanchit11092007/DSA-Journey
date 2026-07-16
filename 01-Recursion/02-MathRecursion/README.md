# Recursion - Math Recursion

## Problems

1. FactorialOfN.java
2. PrimeNumbers.java
3. ArmstrongNumber.java
4. GCDUsingRecursion.java

## What I learned

- Factorial: n * factorial(n-1), base case n == 0 or 1 → return 1.
  Watch out for int overflow on large n (13! already overflows int).

- Prime check: only need to check divisors up to sqrt(n), not all the way to n.
  If divisor*divisor > n and nothing divided evenly, it's prime.
  Two base cases here instead of one: divisor*divisor > n (prime) OR n % divisor == 0 (not prime).

- Armstrong number: sum of (each digit ^ total digit count) == original number.
  Used two separate recursive functions - one to count digits, one to sum the powers.
  Digit peeling pattern: n % 10 (last digit), n / 10 (rest of number) - this comes up a lot.

- GCD (Euclid's algorithm): gcd(a, b) = gcd(b, a % b), base case b == 0 → return a.
  No "n-1" style reduction here - shrinks via remainder instead, which is why it's O(log n)
  instead of checking every number down to 1.

## Mistakes I made / things to remember

- Int overflow on factorial for large n - no error thrown, just wrong answer.
- Cast to (long) before divisor*divisor in prime check to avoid overflow on large n.
- isPrime doesn't handle n < 2 - assumes valid input for now, should add that check later.