class Solution {
    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();

        int[][] cache = new int[text1Length+1][text2Length+1];

        for(int i = 0; i < text1Length + 1; i++)
            for(int j = 0; j < text2Length + 1; j++)
                cache[i][j] = 0;

        for(int i = text1Length-1; i >= 0; i--)
            for(int j = text2Length-1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j))
                    cache[i][j] = 1 + cache[i+1][j+1];
                else
                    cache[i][j] += Math.max(cache[i+1][j], cache[i][j+1]);
            }
        return cache[0][0];
    }

    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();
        int[][] cache = new int[text1Length+1][text2Length+1];
        for (int i = 0; i < text1Length + 1; i++)
            for (int j = 0; j < text2Length + 1; j++)
                cache[i][j] = -1; 

        return DP(text1, text2, 0, 0, cache);
    }

    public int DP(String text1, String text2, int i, int j, int[][] cache) {
        if(cache[i][j] != -1) return cache[i][j];
        if(i == text1.length() || j == text2.length()) return 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            cache[i][j] = 1 + DP(text1, text2, i+1, j+1, cache);
            return cache[i][j];
        }
        else {
            cache[i][j] = Math.max(DP(text1, text2, i+1, j, cache), DP(text1, text2, i, j+1, cache));
            return cache[i][j];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";

        int result = solution.longestCommonSubsequenceTopDown(text1, text2);

        System.out.println("Lunghezza della sottosequenza comune più lunga: " + result);
    }
}