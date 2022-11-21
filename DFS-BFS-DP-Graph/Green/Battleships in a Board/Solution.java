class Solution {
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
}