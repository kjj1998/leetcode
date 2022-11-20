import java.util.*;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ sr, sc });

        int[][] dirs = new int[][]{ {0, -1}, {0, 1}, {1, 0}, {-1, 0} };

        while (!queue.isEmpty()) {
            
            int[] cell = queue.poll();
            int curRow = cell[0];
            int curCol = cell[1];
            int prevColor = image[curRow][curCol];
            image[curRow][curCol] = color;

            for (int i = 0; i < dirs.length; i++) {
                int adjRow = curRow + dirs[i][0];
                int adjCol = curCol + dirs[i][1];

                if (adjRow >= 0 && adjRow < image.length && adjCol >= 0 && adjCol < image[0].length 
                && image[adjRow][adjCol] == prevColor && image[adjRow][adjCol] != color) {
                    queue.offer(new int[] { adjRow, adjCol });
                }
            }

            
        }

        return image;
    }
}
