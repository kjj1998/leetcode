import java.util.*;

class Solution {
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
}