class Solution {
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
}
