# Product of Array Except Self

## Problem

Given an integer array ```nums```, return an array ```answer``` such that ```answer[i]``` is equal to the **product** of all the elements of ```nums``` except ```nums[i]```.

The product of any prefix or suffix of ```nums``` is **guaranteed** to fit in a **32-bit** integer.

You must write an algorithm that runs in ```O(n)``` time and without using the division operation.

## Example

```java
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

## Solution

We can make use of the concept of prefix sum to solve this question. The solution is divided into two phases.

The first phase is a forward pass that inserts into each position of the result array the prefix multiplicative result of the numbers prior to the current position. 

The second phase is a backward pass that inserts into each position of the result array the prefix multiplicative result of the numbers to the right of the current position multiplied with the value in the current position.

For the backward pass, an additonal variable is required to keep track of the prefix multiplicative result.

```java
public int[] productExceptSelf(int[] nums) {
    
    int[] res = new int[nums.length];
    Arrays.fill(res,  1);

    // Forward pass
    for (int i = 1; i < nums.length; i++) {
        res[i] = res[i-1] * nums[i-1];
    }

    int product = nums[nums.length-1];

    // Backward pass
    for (int i = nums.length-2; i >= 0; i--) {
        res[i] = res[i] * product;
        product *= nums[i];
    }

    return res;
}
```

## Complexity

Time: O(n) </br>
Space: O(n)
