# Meeting Rooms II

## Problem

Given an array of meeting time ```intervals``` intervals where ```intervals[i] = [starti, endi]```, return the *minimum number of conference rooms required*.

## Example

```java
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
```

## Solution

```java
public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if (curStart >= pq.peek()) {
                pq.poll();
            }
        
            pq.add(curEnd);
        }

        return pq.size();
    }

```

## Complexity

Time: O(N Log N) </br>
Space: O(N)
