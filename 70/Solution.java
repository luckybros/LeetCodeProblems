class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        memo[n] = 1;
        memo[n-1] = 1;

        for(int i = n-2; i >= 0; i--)
            memo[i] = memo[i+1] + memo[i+2];

        return memo[0];
    }

    public int climbStairsWithoutArray(int n) {
        int one = 1;
        int two = 1;

        for(int i = n-2; i >= 0; i--) {
            int sum = one + two;
            two = one;
            one = sum;
        }

        return one;
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        int nStairs = 5;
        System.out.println(soluzione.climbStairsWithoutArray(nStairs));
    }
}