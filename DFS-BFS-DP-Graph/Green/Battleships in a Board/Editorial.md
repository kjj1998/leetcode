# Battleships in a Board

## Problem

Given an ```m x n``` matrix ```board``` where each cell is a battleship ```'X'``` or empty ```'.'```, return *the number of the **battleships** on ```board```*.

*Battleships* can only be placed horizontally or vertically on ```board```. In other words, they can only be made of the shape ```1 x k``` (```1``` row, ```k``` columns) or ```k x 1``` (```k``` rows, ```1``` column), where ```k``` can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

## Example

![Image](./battelship-grid.jpg)

```java
Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2
```

## Solution

We can find all battleships on the grid using a Depth-First-Search approach.

As we iterate through each cell in the grid, we look for cells marked with ```'X'```. From the cells marked with ```'X'```, we use DFS to search in its 4-directionally connected neighbors for ```'X'```. We continue to recursively call the DFS function to search for ```'X'``` as long as the cells are within the grid boundaries and are ```'X'```.

Algorithm:

- Iterate through each cell in the ```m*n``` grid
- On encountering an ```'X'```, we call the DFS function
  - In the DFS function, we check that the current cell is within the boundaries of the grid
  - We also check that the value of the current cell is not ```'.'```
  - We then change the value of the current cell to ```'.'```
  - Recursively call the DFS function on the cells that are 4-directionally connected to the current cell
- Increment the count of battleships after returning from the original DFS function call

```java
public int countBattleships(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    int count = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'X') {
                dfs(board, i, j, m, n);
                count++;
            }
        }
    }

    return count;
}

public void dfs(char[][] board, int curRow, int curCol, int rowLength, int colLength) {
    if (curRow < 0 || curRow == rowLength || curCol < 0 || curCol == colLength) {
        return;
    }

    if (board[curRow][curCol] == '.') {
        return;
    }

    board[curRow][curCol] = '.';

    dfs(board, curRow+1, curCol, rowLength, colLength);
    dfs(board, curRow-1, curCol, rowLength, colLength);
    dfs(board, curRow, curCol+1, rowLength, colLength);
    dfs(board, curRow, curCol-1, rowLength, colLength);
}
```

## Complexity

Time: O(m*n), in the worst case the entire grid is one giant battleship </br>
Space: O(1)
