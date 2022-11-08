# Remove Duplicates from Sorted Array II

## Problem

Given an integer array ```nums``` sorted in **non-decreasing order**, remove some duplicates **in-place** such that each unique element appears **at most twice**. The **relative order** of the elements should be kept the **same**.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array ```nums```. More formally, if there are ```k``` elements after removing the duplicates, then the first ```k``` elements of nums should hold the final result. It does not matter what you leave beyond the first ```k``` elements.

Return ```k``` after placing the final result in the first ```k``` slots of nums.

Do **not** allocate extra space for another array. You must do this by **modifying the input array in-place** with O(1) extra memory.

## Solution

We can see that we would require two pointers ```a``` and ```b```, where ```a``` would keep track of the number of the last index where all the numbers beforehand adhere to the **each unique element appearing at most twice rule**. Whereas, ```b``` would continue to iterate down the original length of the array given.

More specifically, ```a``` would be an integer variable ```i``` that refers to an index in the array ```nums``` that only increases when the **each unique element appearing at most twice rule** is satisfied. ```b``` would be an integer variable ```j``` that increases as it iterates through the array ```nums```.

```i``` only increases when ```i < 2``` since no unique element would appear more than twice in this situation. And it would also increase when ```nums[j] > nums[i-2]``` as it indicates ```nums[i-2]``` and ```nums[i-1]``` are unique elements that have appeared ```at most twice``` and thus ```nums[i]``` should be changed to ```nums[j]```.

```java
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (i < 2 || nums[j] > nums[i-2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
```
