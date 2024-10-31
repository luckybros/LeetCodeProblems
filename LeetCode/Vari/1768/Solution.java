class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        String result = "";

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < l1 && j < l2) {
            if(k % 2 == 0) {
                result += word1.charAt(i);
                i++;
                k++;
            }
            else {
                result += word2.charAt(j);
                j++;
                k = 0;
            }
        }
         
        if(i < l1) {
            for(int w = i; w < l1; w++)
                result += word1.charAt(w);
        }

        if(j < l2) {
            for(int w = j; w < l2; w++)
                result += word2.charAt(w);
        }
        return result;
    }
}