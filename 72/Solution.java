class Solution {
    public int minDistance(String word1, String word2) {
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
}
