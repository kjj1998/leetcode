# Find Minimum in Rotated Sorted Array II

## Problem

Suppose an array of length ```n``` sorted in ascending order is **rotated** between ```1``` and ```n``` times. For example, the array ```nums = [0,1,4,4,5,6,7]``` might become:

- ```[4,5,6,7,0,1,4]``` if it was rotated ```4``` times.
- ```[0,1,4,4,5,6,7]``` if it was rotated ```7``` times.

Notice that **rotating** an array ```[a[0], a[1], a[2], ..., a[n-1]]``` 1 time results in the array ```[a[n-1], a[0], a[1], a[2], ..., a[n-2]]```.

Given the sorted rotated array ```nums``` that may contain **duplicates**, return *the minimum element of this array*.

You must decrease the overall operation steps as much as possible.

## Example

```java
Input: nums = [3,3,1,3]
Output: 1
```

## Solution

Because of the presence of duplicates, the traditional binary search approach would not work. Thus, we would need a way to handle the duplicates if we want to continue using binary search.

As we know in binary search, we have two pointers, one ```low``` and one ```high``` pointer. Using these two pointers, we will find the ```mid``` pointer.

With the ```mid``` pointer:

- If the value at the ```mid``` pointer is larger than the value at the ```high``` pointer, we make ```low = mid + 1``` as we know that the minimum value cannot be in the left hand portion of the array since the left hand portion would have been greater than the value at the ```end``` pointer, given that the array has been rotated.

- If the value at the ```mid``` pointer is smaller than the value at the ```high``` pointer, we make ```high = mid``` as we know that the minimum value must be the value at ```mid``` or lesser as we know that the minimum value cannot be in the right hand portion of the array since the right hand portion would have been greater than the value at the ```mid``` pointer, given that the array has been rotated.

- If the above two conditions are not met, we have encountered a duplicate at ```high``` pointer, and we can remove that duplicate by decrementing ```high```.

```java
public int findMin(int[] nums) {
    int start = 0;
    int end = nums.length-1;
    int mid = 0;

    if (nums[start] < nums[end]) {
        return nums[start];
    }

    while (start <= end) {
        mid = start + (end - start)/2;
        
        if (nums[mid] > nums[end]) {
            start = mid + 1;
        } else if (nums[mid] < nums[end]) {
            end = mid;
        } else {
            end--;
        }
    }

    return nums[mid];
}
```

## Complexity

Time: O(lg n) </br>
Space: O(1)