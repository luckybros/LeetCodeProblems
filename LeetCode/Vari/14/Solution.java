public class Solution {
    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefixHelper(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefixHelper(String[] strs, int l, int r) {
        if(l == r) return strs[l];

        int q = (l + r) / 2;
        String leftString = longestCommonPrefixHelper(strs, l, q);
        String rightString = longestCommonPrefixHelper(strs, q+1, r);

        int minLength = Math.min(leftString.length(), rightString.length());
        String commonPrefix = "";

        for(int i = 0; i < minLength; i++)  
            if(leftString.charAt(i) == rightString.charAt(i))
                commonPrefix += leftString.charAt(i);
            else
                return commonPrefix;

        return commonPrefix;
    }
        
}