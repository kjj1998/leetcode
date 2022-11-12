import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int mins = 0;
        Queue<int[]> rotten = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{ i, j });      // add rotten oranges into the queue
                } else if (grid[i][j] == 1) {
                    freshOranges++;     // number of fresh oranges at the beginning
                }
            }
        }

        int[][] dirs = new int[][] { {0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        if (freshOranges == 0) {
            return mins;
        }

        while (!rotten.isEmpty() && freshOranges > 0) {

            int numOfRottenOranges = rotten.size();

            for (int j = 0; j < numOfRottenOranges; j++) {
                int[] position = rotten.poll();

                int curRow = position[0];
                int curCol = position[1];

                for (int i = 0; i < 4; i++) {
                    int adjRow = curRow + dirs[i][0];
                    int adjCol = curCol + dirs[i][1];

                    if (adjRow >= 0 && adjRow < grid.length && adjCol >= 0 && adjCol < grid[0].length) {
                        if (grid[adjRow][adjCol] == 1) {
                            grid[adjRow][adjCol] = 2;
                            rotten.add(new int[]{ adjRow, adjCol });
                            freshOranges--;
                        }
                    }
                }
            }
            
            mins++;
        }

        return freshOranges == 0 ? mins : -1;
    }
}
