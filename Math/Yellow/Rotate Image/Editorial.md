# Rotate Image

## Problem

You are given an ```n x n``` 2D matrix representing an image, rotate the image by **90** degrees (clockwise).

You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

## Example

```java
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```

## Solution

We can get the 90 degrees rotated clockwise matrix by first doing a **transpose** of the elements and then followed by a row by row **reversal** of the elements

```java
5   1   9   11   transposed     5   2   13  15      reversal    15  13  2   5
2   4   8   10       =>         1   4   3   14         =>       14  3   4   1
13  3   6   7                   9   8   6   12                  12  6   8   9
15  14  12  16                  11  10  7   16                  16  7   10  11
```

To get the 90 degrees rotated **anti-clockwise** matrix do a row by row **reversal** of the elements followed by a **transpose** of the elements
