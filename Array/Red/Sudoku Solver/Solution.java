class Solution {
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
}