# Daily Temperatures

## Problem

Given an array of integers ```temperatures``` represents the daily temperatures, return *an array ```answer``` such that ```answer[i]``` is the number of days you have to wait after the **i^th^** day to get a warmer temperature*. If there is no future day for which this is possible, keep ```answer[i] == 0``` instead.

## Example

```java
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

## Solution

We can solve this problem with a Stack-based approach, in particular using a **Monotonic Stack**.

We can model this question as finding the next greater element from the current element and because of this, we will utilise a monotonic decreasing stack.

As we iterate through the ```temp``` array, we will push the current index into the stack. We would have a monotonic decreasing stack when we try to find the next greater element by comparing the top of the stack with the current index.

While the index at the top of the stack is lesser than the current index, we pop from the top of the stack index and subtract it from the current index to find the number of days to get a warmer temperature. The condition ```while the index at the top of the stack is lesser than the current index``` ensures that we maintain a monotonic decreasing stack which will help us to find the next greater element.

```java
public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> monoIndexes = new Stack<>();
    int tempLen = temperatures.length;
    int[] res = new int[tempLen];

    for (int curIndex = 0; curIndex < tempLen; curIndex++) {

        int curTemp = temperatures[curIndex];

        while ((!monoIndexes.isEmpty()) && (temperatures[monoIndexes.peek()] < curTemp)) {
            int prevIndex = monoIndexes.pop();
            res[prevIndex] = curIndex - prevIndex;
        }

        monoIndexes.push(curIndex);
    }

    return res;
}
```

## Complexity

Time: O(n) </br>
Space: O(n)