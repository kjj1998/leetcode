# Rotting Oranges

## Problem

You are given an ```m x n``` ```grid``` where each cell can have one of three values:

- ```0``` representing an empty cell,
- ```1``` representing a fresh orange, or
- ```2``` representing a rotten orange.

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return *the minimum number of minutes that must elapse until no cell has a fresh orange*. If this is impossible, return ```-1```.

## Example

![Image](./oranges.png)

```java
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

## Solution

For this problem, as the rotten oranges will affect all surrounding fresh oranges, we can model it as a Breadth First Search where every fresh orange that can be reached from a rotten orange will be turned rotten.

We will first add all existing rotten oranges into a queue and then dequeue all of them to find out if there are any fresh oranges surrounding them that can be turned rotten. These fresh oranges will be turned rotten and added into the queue. Everytime we finish dequeuing all of the rotten oranges, we increase the number of minutes taken by one.

We also decrement the count of fresh oranges everytime we turn a fresh orange rotten. This is so that we can know at the end, whether all fresh oranges can be turned rotten

```java
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

                // Check for out of bounds
                if (adjRow >= 0 && adjRow < grid.length && adjCol >= 0 && adjCol < grid[0].length) {
                    if (grid[adjRow][adjCol] == 1) {        // check for fresh oranges
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
```

## Complexity

Time: O(m\*n) </br>
Space: O(m\*n)
