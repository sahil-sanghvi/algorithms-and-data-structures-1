[![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Topic](https://img.shields.io/badge/topic-algorithmic%20complexity-informational)]()

# Algorithm Performance Lab

Two algorithms exercises focused on comparing approaches by measurable performance rather than just correctness — matching solutions against provided test fixtures at increasing input scale.

| Project | What it does |
|---|---|
| [`array-matching/`](array-matching/) | Reads two integer arrays from a file and solves a matching problem between them; `ArrayMatch.java` and `ArrayMatch2.java` are two independent solution attempts, verified against 6 input fixtures. |
| [`pair-finding/`](pair-finding/) | Given an array and a target sum, finds whether a pair exists that sums to it. `lab7.java` sorts then two-pointer-scans (O(n log n)); `lab7_copy.java` is the brute-force O(n²) baseline. Both are run against `HasPair_*`/`NoPair_*` fixtures at 10, 100,000, and 1,000,000 elements to compare how each scales. |

[`written-assignments/`](written-assignments/) holds the three proof/analysis assignments from the same course (asymptotic analysis, recurrences, correctness proofs) that didn't involve code.

## Running

```bash
cd array-matching/
javac ArrayMatch.java && java ArrayMatch input00.txt

cd pair-finding/
javac lab7.java lab7_copy.java
java lab7 HasPair_100000.txt
```

## 🎓 Project Context

Built as part of **CSC 225: Algorithms and Data Structures I** at the University of
Victoria.

## ⚠️ Academic Integrity Notice

This repository is maintained for portfolio and educational purposes only. If you are
currently enrolled in CSC 225 at the University of Victoria or a similar algorithms
course, please note that using this code in your own assignments may constitute a
violation of Academic Integrity policies.
