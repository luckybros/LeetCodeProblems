class Solution {
    public boolean isPalindrome(int x) {
        String stringInteger = Integer.toString(x);

        for(int i = 0; i < stringInteger.length()/2; i++)
            if(stringInteger.charAt(i) != stringInteger.charAt(stringInteger.length()-1-i))
                return false;

        return true;
    }
}