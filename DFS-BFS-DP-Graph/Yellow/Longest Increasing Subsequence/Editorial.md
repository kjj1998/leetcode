# Longest Increasing Subsequence

## Problem

Given an integer array ```nums```, return the length of the longest **strictly increasing subsequence**

## Example

```java
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

## Solution

The naive approach to this question is to utilise a standard top-down DFS approach.

The base condition would be when the current ```index``` is greater than or equal to the length of the ```nums``` array.

There are two general conditions:

1. Skip the current number and move on to the next index i.e. do not include the current number in the subsequence

2. Include the ```current number``` in the subsequence, but first we have to check that the ```current number``` is **greater than** the ```number at the previous index``` so that we fulfil the condition of having the longest increasing subsequence.

The return value will be the maximum of the return value of the two recursive calls. The first recursive call which ```skips the current number``` and the second recursive call which ```includes the current number + 1```

However, this naive approach will exceed the time limit as it will have exponential runtime. We can improve the runtime by caching repeated computations. 

Take the array ```nums = [10,9,2,5,3,7,101,18]``` for example. The subsequence ```[3, 7, 101]``` will be computed repeatedly at least in ```[10, 3, 7, 101]```, ```[9, 3, 7, 101]```, ```[2, 3, 7, 101]```, ```[5, 3, 7, 101]``` or ```[3, 7, 101]```. Regardlessly, we can see that the maximum length of an increasing subsequence starting from ```[3]``` can only be 3 no matter how many computations we do. Therefore, we can just do a single computation and cache the result in an array for retrieval later when we need it.

```java
public int lengthOfLIS(int[] nums) {

    int[] memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);

    return dfs(nums, 0, -1, memo);
}

public int dfs(int[] nums, int index, int prevIndex, int[] memo) {
    if (index >= nums.length) {
        return 0;
    }

    if (memo[prevIndex+1] != -1) {
        return memo[prevIndex + 1];
    }

    int skip = dfs(nums, index+1, prevIndex, memo); // no change to previous index when skipping
    int include = 0;
    if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
        include = dfs(nums, index + 1, index, memo) + 1;
    }
    
    memo[prevIndex + 1] = Math.max(skip, include);

    return memo[prevIndex + 1];

}
```

## Complexity

Time: O(N^2^) </br>
Space: O(N)