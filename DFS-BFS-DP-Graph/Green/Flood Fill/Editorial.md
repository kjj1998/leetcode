# Flood Fill

## Problem

An image is represented by an ```m x n``` integer grid ```image``` where ```image[i][j]``` represents the pixel value of the image.

You are also given three integers ```sr```, ```sc```, and ```color```. You should perform a **flood fill** on the image starting from the pixel ```image[sr][sc]```.

To perform a **flood fill**, consider the starting pixel, plus any pixels connected **4-directionally** to the starting pixel of the same color as the starting pixel, plus any pixels connected **4-directionally** to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with **color**.

Return *the modified image after performing the flood fill*.

## Example

![Image](./flood1-grid.jpg)

```java
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
```

## Solution

We can solve this question by adopting a Breadth-First-Search approach.

From the starting cell given, we consider the cells that are 4-directionally connected to the starting cell. If the cells are within boundaries, are not ```color``` and are of the same value as the current cell, we enqueue them into the queue.

Thus as we dequeue cells from the queue, we set them to ```color``` and check if the neighboring cells are eligible to be turned into ```color```

Algorithm:

- Enqueue starting cell into a queue
- While queue is not empty:
  - Dequeue a cell

  - If the neighboring cells are within boundaries, have the same value as the current cell and their values are not ```color```, enqueue them into the queue

  - Set the current cell value to ```color```
- Return ```image```

```java
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
```

## Complexity

Time: O(m\*n), in the worst case, we would cover every cell in the grid </br>
Space: O(m\*n) for the queue to store all the cells
