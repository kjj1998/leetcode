public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        
        Integer[] memo = new Integer[amount+1];

        int min = dfs(coins, amount, memo);

        return min;
    }

    public int dfs(int[] coins, int amountLeft, Integer[] memo) {
        if (amountLeft == 0) {
            return 0;
        }

        if (amountLeft < 0) {
            return -1;
        }

        if (memo[amountLeft] != null) {
            return memo[amountLeft];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int val = dfs(coins, amountLeft - coins[i], memo);

            if (val >= 0 && val < min) {
                min = val + 1;
            }
        }

        memo[amountLeft] = (min == Integer.MAX_VALUE ? -1 : min);

        return memo[amountLeft];
    }
}