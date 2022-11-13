# Coin Change

## Problem

You are given an integer array ```coins``` representing coins of different denominations and an integer ```amount``` representing a total amount of money.

Return the *fewest number of coins* that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return ```-1```.

You may assume that you have an infinite number of each kind of coin.

## Example

```java
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

## Solution

A very standard top down DFS approach with memomization can be applied here.

There are two base conditions:

- When the amount remaining is ```0```, we return ```0```
- When the amount remaining is less than ```0```, we return ```-1```

For the general condition, we will iterate through each type of coin that we can have and then we will recursively call the dfs function after subtracting that type of coin from the amount. On return, we check if the ```return value``` is ```more than or equal to 0``` and if it is ```more than the current minimum value```, for which the minimum value will be updated with the ```return value + 1```.

To memomize, we will utilise an array of size ```amount + 1``` which will be used to store the minimum number of coins needed at each value from 1 to amount to prevent repeated computations

```java
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
```

## Complexity

Time: O(S*n) where ```S``` is the amount and ```n``` is the coin denomination count </br>
Space: O(S)
