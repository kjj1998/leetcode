import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
        Arrays.fill(res,  1);

        // Forward pass
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int product = nums[nums.length-1];

        // Backward pass
        for (int i = nums.length-2; i >= 0; i--) {
            res[i] = res[i] * product;
            product *= nums[i];
        }

        return res;
    }
}