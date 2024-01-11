class Solution {
    public int minDistanceBottomUp(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] cache = new int[length1 + 1][length2 + 1];

        for (int i = 0, k = length1; i <= length1; i++, k--) 
            cache[i][length2] = k;
        
        for (int j = 0, k = length2; j <= length2; j++, k--) 
            cache[length1][j] = k;

        for (int i = length1 - 1; i >= 0; i--) 
            for (int j = length2 - 1; j >= 0; j--) 
                if (word1.charAt(i) == word2.charAt(j)) 
                    cache[i][j] = cache[i + 1][j + 1];
                else 
                    cache[i][j] = 1 + Math.min(cache[i + 1][j + 1], Math.min(cache[i + 1][j], cache[i][j + 1]));
            
        return cache[0][0];
    }

    public int minDistanceTopDown(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] cache = new int[length1 + 1][length2 + 1];

        for (int i = 0, k = length1; i <= length1; i++, k--) 
            cache[i][length2] = k;
        
        for (int j = 0, k = length2; j <= length2; j++, k--) 
            cache[length1][j] = k;

        for(int i = 0; i < length1; i++)
            for(int j = 0; j < length2; j++)
                cache[i][j] = -1;

        return DP(word1, word2, 0, 0, cache);
    }

    public int DP(String word1, String word2, int i, int j, int[][] cache) {
        if(i == word1.length() || j == word2.length()) return cache[i][j];
        else if(cache[i][j] != -1) return cache[i][j];
        
        if (word1.charAt(i) == word2.charAt(j)) {
            cache[i][j] = DP(word1, word2, i+1, j+1, cache);
            return cache[i][j];
        }
        else {
            cache[i][j] = 1 + Math.min(DP(word1, word2, i+1, j+1, cache), Math.min(DP(word1, word2, i, j+1, cache), DP(word1, word2, i+1, j, cache)));
            return cache[i][j];
        }
    }
}
