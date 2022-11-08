class Solution {
    public void rotate(int[][] matrix) {
        
        int length = matrix.length;
        int breadth = matrix[0].length;

        // transpose
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < breadth; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][breadth - 1 - j];
                matrix[i][breadth - 1 - j] = temp;
            }
        }

    }
}