# Minimum Size Subarray Sum

## Problem

Given an array of positive integers ```nums``` and a positive integer ```target```, return the **minimal length** of a subarray whose sum is greater than or equal to ```target```. If there is no such subarray, return ```0``` instead.

## Example

```java
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```

## Solution

We can use the Two Pointers approach to solve this question. The two pointers, start and end, will be used to keep track of the start index and the end index of the current subarray, respectively. And we can move the start index of the current subarray as soon as we know that no better could be done with this index as the start index. This will be optimal in keeping the sum of the current subarray greater than or equal to the target while maintaining the lowest size possible.

## Algorithm

- Initialize **left** pointer to 0 and **sum** to 0
- Iterate over the **nums**:
  - Add **nums[i]** to **sum**
  - While **sum** is greater than or equal to **target**:
    - Update **ans=min⁡(ans,i+1−left)**, where **i+1−left** is the size of current subarray
    - It means that the first index can safely be incremented, since, the minimum subarray starting with this index with **sum ≥ s** has been achieved
    - Subtract **nums[left]** from **sum** and increment **left**

```java
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];

            while (sum >= target) {
                length = Math.min(length, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        if (length == Integer.MAX_VALUE) {
            return 0;
        } else {
            return length;
        }
    }
```

## Time Complexity

Time: O(N) </br>
Space: O(1)
