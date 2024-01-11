class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int prev0 = 0;
        int prev1 = 1;
        int prev2 = 1;
        int ris = 0;

        for(int i = 3; i < n+1; i++) {
            ris = prev0 + prev1 + prev2;
            prev0 = prev1;
            prev1 = prev2;
            prev2 = ris;
        }
            
        return ris;
    }

    public int tribonacciWithArray(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] solution = new int[n+1];
        solution[0] = 0;
        solution[1] = 1;
        solution[2] = 1;

        for(int i = 3; i < n+1; i++) 
            solution[i] = solution[i-1] + solution[i-2] + solution[i-3];
        
        return solution[n];
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();

        System.out.println(soluzione.tribonacci(25));
    }
}
