import java.util.Arrays;

class Solution {

    public int fib(int n) {
        if(n == 0) return 0;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return DP(n, memo);
    }

    public int DP(int n, int[] memo) {
        if(n == 1 || n == 2) return 1;
        if(memo[n] >= 0) return memo[n];

        int f = DP(n-1, memo) + DP(n-2, memo);
        memo[n] = f;
        return f;
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        System.out.println(soluzione.fib(4));
    }
}