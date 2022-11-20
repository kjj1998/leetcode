# Sudoku Solver

## Problem

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy **all of the following rules**:

Each of the digits ```1-9``` must occur exactly once in each row. </br>
Each of the digits ```1-9``` must occur exactly once in each column. </br>
Each of the digits ```1-9``` must occur exactly once in each of the 9 ```3x3``` sub-boxes of the grid. </br>
The ```'.'``` character indicates empty cells.

## Example

![Image](./sudoku.png)

```java
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
```

![Image](./sudoku_solved.png)

## Solution

We can use a backtracking recursive approach to solve this problem.

A sudoku puzzle consists of 9 rows and 9 columns. We start from the very first cell and look for empty cells where a number can be placed. Once we have identified an empty cell, we iterate through each of the possible numbers that can be placed in this cell i.e. 1 to 9.

We look for a number that has not appeared in the current row, current column and the subboxes which it belongs to. Once we find a number that matches these conditions, we set the current cell to this number and recursively call ```solve``` function with the next position as input for e.g. if a number was found for current cell ```(3, 4)```, we start searching from ```(3, 5)``` in the next recursive call. If the recursive call returns true, we return true in the current call, else we set the current cell back to being an empty cell.

If we cannot find a valid number for the current empty cell, we return false

```java
public void solveSudoku(char[][] board) {
    solve(board, 0, 0);
}

public boolean solve(char[][] board, int row, int col) {
    for (int i = row; i < 9; i++, col=0) {
        for (int j = col; j < 9; j++) {
            if (board[i][j] != '.') {
                continue;
            }

            for (char num = '1'; num <= '9'; num++) {
                if (isValid(board, i, j, num)) {
                    
                    board[i][j] = num;
                    if (solve(board, i, j+1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
            }

            return false;
        }
    }

    return true;
}

private boolean isValid(char[][] board, int row, int col, char num) {
    int blkRow = (row / 3) * 3;
    int blkCol = (col / 3) * 3;

    for (int i = 0; i < 9; i++) {
        if (board[i][col] == num  || board[row][i] == num || board[blkRow + i / 3][blkCol + i % 3] == num) {
            return false;
        }
    }

    return true;
}
```

## Complexity

Time: O(9\*m\*n) </br>
Space: O(1)
