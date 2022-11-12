# Merge Intervals

## Problem

Given an array of ```intervals``` where
<code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return *an array of the non-overlapping intervals that cover all the intervals in the input*.

## Example

```java
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
```

## Solution

As we want to merge all overlapping intervals, we first need to sort the intervals by their start value.

Once the intervals are sorted by their start values, we can compare the end value of the previous interval with the start value of the current interval. We store the previous interval in a holding array.

If the end value of the previous interval is greater than or equal to the start value of the current interval, we set the end value of the previous interval to be the max value between the **end value of the previous interval** and the **end value of the current interval**.

If not, we add the previous interval into a result array and change the **start value of the previous interval** to the **start value of the current interval** and also change the **end value of the previous interval** to **the end value of the current interval**.

```java
public int[][] merge(int[][] intervals) {
    
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by starting values

    List<List<Integer>> merged = new ArrayList<>();
    List<Integer> temp = Arrays.asList(
        new Integer[] { intervals[0][0], intervals[0][1] });

    for (int i = 1; i < intervals.length; i++) {
        if (temp.get(1) >= intervals[i][0]) { // update the end value for overlapping intervals
            temp.set(1, Math.max(intervals[i][1], temp.get(1)));
        } else {
            List<Integer> res = new ArrayList<>(temp);  // change to the next non-overlapping interval
            merged.add(res);
            temp.set(0, intervals[i][0]);
            temp.set(1, intervals[i][1]);
        }
    }

    merged.add(temp);

    int[][] finalRes = new int[merged.size()][2];

    for (int i = 0; i < finalRes.length; i++) {
        finalRes[i][0] = merged.get(i).get(0);
        finalRes[i][1] = merged.get(i).get(1);
    }

    return finalRes;
}
```

## Complexity

Time: O(n lg n) for sorting, O(n) for merging </br>
Space: O(n)
