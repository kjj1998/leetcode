# Compare Version Numbers

## Problem

Given two version numbers, ```version1``` and ```version2```, compare them.

Version numbers consist of **one or more revisions** joined by a dot ``'.'``. Each revision consists of **digits** and may contain leading **zeros**. Every revision contains **at least one character**. Revisions are **0-indexed from left to right**, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example ```2.5.33``` and ```0.1``` are valid version numbers.

To compare version numbers, compare their revisions in **left-to-right** order. Revisions are compared using their **integer value ignoring any leading zeros**. This means that revisions ```1``` and ```001``` are considered **equal**. If a version number does not specify a revision at an index, then **treat the revision as** ```0```. For example, version ```1.0``` is less than version ```1.1``` because their revision 0s are the same, but their revision 1s are ```0``` and ```1``` respectively, and ```0 < 1```.

*Return the following*:

- If ```version1 < version2```, return ```-1```.
- If ```version1 > version2```, return ```1```.
- Otherwise, return ```0```.

## Example

```java
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
```

## Solution

We can use a Two-Pointers approach to solve this question.

We have one pointer for ```version1``` and one pointer for ```version2```. We will sum up the values of all the digits in each version before they reach ```'.'```. Upon reaching ```'.'```, we compare the two summed up values and only proceed to sum the numbers after ```'.'``` if they are equal. 

When we are summing the numbers after ```'.'```, we first reset the sums for both versions to be ```0```. For the last group of digits where there isn't a ```'.'```, the summing will stop when the pointers reaches the last digit

Algorithm:

- While ```ver1Pointer < ver1Length``` or ```ver2Pointer < ver2Length```
  - Set ```ver1Sum``` and ```ver2Sum``` to be 0
  - While ```ver1Pointer < ver1Length``` and ```ver1Character != '.'```
    - ```ver1Sum = ver1Sum * 10 + ver1Character```
  - While ```ver2Pointer < ver2Length``` and ```ver2Character != '.'```
    - ```ver2Sum = ver2Sum * 10 + ver2Character```
  - if ```ver1Sum > ver2Sum```, return 1
  - else if ```ver1Sum < ver2Sum```, return -1
  - else ```ver1Pointer++``` and ```ver2Pointer++```
- Return 0

## Complexity

Time: O(n), where n is the length of the longer version string </br>
Space: O(1)
