# Lab 7 — Pair Finding

Given an array and a target sum, finds whether a pair exists that sums to
it — implemented two ways to compare algorithmic complexity in practice:

- `lab7.java` — sorts the array, then a two-pointer scan: O(n log n).
- `lab7_copy.java` — the brute-force nested-loop baseline: O(n²).

Both are run against `HasPair_*`/`NoPair_*` fixtures at 10, 100,000, and
1,000,000 elements to compare how each actually scales. `lab7-handout.pdf`
is the lab spec.

## Running

```bash
javac lab7.java lab7_copy.java
java lab7 HasPair_100000.txt
```
