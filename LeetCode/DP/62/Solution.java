class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m-1][n-1] = 1;

        for(int i = m -1; i >= 0; i--)
            for(int j = n - 1; j >= 0; j--) {
                int r, d;
                if(j+1 == n)    
                    r = 0;
                else
                    r = grid[i][j+1];
                if(i+1 == m)    
                    d = 0;
                else
                    d = grid[i+1][j];
                if(i == m - 1 && j == n - 1)
                    grid[i][j] = 1;
                else
                    grid[i][j] = r + d;
            }
        return grid[0][0];
    }

    public int uniquePathsWithRecursion(int m, int n) {
        int grid[][] = new int[m][n];
        return DP(grid, 0, 0, m - 1, n - 1);
    }

    public int DP(int grid[][], int i, int j, int m, int n) {
        if (i == m && j == n) return 1;
        if (i > m || j > n) return 0;
        grid[i][j] = DP(grid, i + 1, j, m, n) + DP(grid, i, j + 1, m, n);
        return grid[i][j];
    }

    public static void main(String arg[]) {
        Solution soluzione = new Solution();
        System.out.println(soluzione.uniquePathsWithRecursion(3, 7));
    }
}