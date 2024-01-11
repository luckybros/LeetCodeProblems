import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotalTopDown(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        int numCols = 0;
        for (List<Integer> row : triangle) {
            numCols = Math.max(numCols, row.size());
        }
        int[][] cache = new int[numRows+1][numCols+1];
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);
        return DP(triangle, cache, 0, 0);
    }

    public int DP(List<List<Integer>> triangle, int[][] cache, int i, int j) {
        if(i == triangle.size() - 1) return triangle.get(i).get(j);
        if(cache[i][j] != -1) return cache[i][j];
        cache[i][j] = triangle.get(i).get(j) + Math.min(DP(triangle, cache, i+1, j), DP(triangle, cache, i+1, j+1));
        return cache[i][j];
    }

    public int minimumTotalTopDownBottomUp(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        int numCols = 0;
        for (List<Integer> row : triangle) {
            numCols = Math.max(numCols, row.size());
        }
        int[][] cache = new int[numRows][numCols];
        for(int i = 0; i < numCols; i++)
            cache[numRows-1][i] = triangle.get(numRows-1).get(i);

        for(int i = numRows-2; i >= 0; i--) {
            int k = triangle.get(i).size();
            for(int j = 0; j < k; j++) {
                cache[i][j] = triangle.get(i).get(j) + Math.min(cache[i+1][j], cache[i+1][j+1]);
            }
        }

        return cache[0][0];
        
    }
}