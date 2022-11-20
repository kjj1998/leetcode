# Best Time To Buy And Sell Stock

## Problem

You are given an array ```prices``` where ```prices[i]``` is the price of a given stock on the <code>i^th^</code> day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return ```0```.

## Example

```java
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

## Solution

To solve this question, we need to keep track of two variables, ```profit``` which stores the max profit value earned and ```min``` which keeps track of the minimum value encountered in the array so far.

We initialize ```profit``` to ```0``` and ```min``` to the first value in the array. As we iterate through the array, we calulcate the profit earned if ```array[i] > min``` and compare it to the current profit we have. If ```min > array[i]```, we set ```min = array[i]```. 

We can get the max profit in this way because, we always keep track of the min value which we can use to get the maximum profit.

## Complexity

Time: O(n), where n is the size of ```prices```, since only one pass is needed </br>
Space: O(1), constant space needed for ```profit``` and ```min``` variable 