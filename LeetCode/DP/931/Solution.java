class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] cache = new int[rows][columns+2];

        for(int i = 0; i < rows; i++) {
            cache[i][0] = Integer.MAX_VALUE;
            cache[i][columns+1] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < columns + 1; i++)
            cache[rows-1][i] = matrix[rows-1][i-1];

        for(int i = rows - 2; i >= 0; i--)
            for(int j = 1; j < columns + 1; j++)
                cache[i][j] = matrix[i][j-1] + Math.min(cache[i+1][j-1], Math.min(cache[i+1][j], cache[i+1][j+1]));

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < columns + 1; i++) {
            if(cache[0][i] < min)
                min = cache[0][i];
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        
        int result = solution.minFallingPathSum(matrix);
        
        System.out.println(result);
    }
}