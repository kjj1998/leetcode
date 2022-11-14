import java.util.*;

class Solution {
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

        int skip = dfs(nums, index+1, prevIndex, memo);
        int include = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            include = dfs(nums, index + 1, index, memo) + 1;
        }
        
        memo[prevIndex + 1] = Math.max(skip, include);

        return memo[prevIndex + 1];

    }
}