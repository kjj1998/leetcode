# Max Area Of Island

## Problem

You are given an ```m x n``` binary matrix grid. An island is a group of ```1's``` (representing land) **connected 4-directionally (horizontal or vertical.)** You may assume **all four edges of the grid are surrounded by water.**

The area of an island is the number of cells with a value ```1``` in the island.

Return the maximum area of an island in grid. If there is no island, return ```0```.

## Example

![Image](./maxarea1-grid.jpg)

```java
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
```

## Solution

```java
public int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;

    int m = grid.length;
    int n = grid[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {  // only conduct dfs if cell is 1 which indicates an island
                int area = dfs(grid, i, j, m ,n);
                maxArea = Math.max(maxArea, area);
            }
        }
    }

    return maxArea;
}

public int dfs(int[][] grid, int curRow, int curCol, int m, int n) {
    if (curRow < 0 || curRow == m || curCol < 0 || curCol == n) {   // out of bounds check
        return 0;
    }

    if (grid[curRow][curCol] == 0) {    // non-island check
        return 0;
    }

    grid[curRow][curCol] = 0;   // change current cell to an island

    // conduct dfs in 4 directions
    int top = dfs(grid, curRow-1, curCol, m, n);
    int bot = dfs(grid, curRow+1, curCol, m, n);
    int left = dfs(grid, curRow, curCol-1, m, n);
    int right = dfs(grid, curRow, curCol+1, m, n);

    return top+bot+left+right+1;    // return the combined areas from the 4 directions
}
```

## Time Complexity

Time: O(R*C), where R is the number of rows and C is the number of columns </br>
Space: O(1), constant space