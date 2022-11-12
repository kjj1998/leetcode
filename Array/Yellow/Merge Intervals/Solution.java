import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> merged = new ArrayList<>();
        List<Integer> temp = Arrays.asList(new Integer[] { intervals[0][0], intervals[0][1] });

        for (int i = 1; i < intervals.length; i++) {
            if (temp.get(1) >= intervals[i][0]) {
                temp.set(1, Math.max(intervals[i][1], temp.get(1)));
            } else {
                List<Integer> res = new ArrayList<>(temp);
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
}
