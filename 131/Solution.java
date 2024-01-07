import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> substring = new ArrayList<>();
        Backtracking(s, result, substring, 0);
        return result;
    }

    public void Backtracking(String s, List<List<String>> result, List<String> substring, int step) {
        if(step == s.length()) {
            List<String> substringCopy = new ArrayList<>(substring);
            result.add(substringCopy);
            return;
        }

        for(int i = step; i < s.length(); i++)  {
            String currentSubstring = s.substring(step, i+1);
            if(isPalindrome(currentSubstring)) {
                substring.add(currentSubstring);
                Backtracking(s, result, substring, i + 1);
                substring.remove(substring.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String substring) {
        int left = 0;
        int right = substring.length() - 1;

        while(right > left)
            if(substring.charAt(right--) != substring.charAt(left++))
                return false;

        return true;
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        String s = new String("aab");

        for (List<String> listString : solution.partition(s)) {
            for (String resultString : listString) 
                System.out.println(resultString);
            System.out.println("\n");
        }

    }
}