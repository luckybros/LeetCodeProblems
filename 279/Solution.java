import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for(int i = 1; i <= n; i++) 
            for(int j = 1; j <= i; j++) {
                int squared = j*j;
                if(squared > i)
                    break;
                memo[i] = Math.min(memo[i], 1 + memo[i - squared]);
            }

        return memo[n];
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        System.out.println(soluzione.numSquares(12));
    }

    

    
}