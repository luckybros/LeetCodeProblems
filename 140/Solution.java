import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        Map<String, Boolean> stringMap = new HashMap<>();
        for (String word : wordDict) 
            stringMap.put(word, true);

        backtracking(s, "", "", 0, stringMap, result);

        return result;
    }

    public void backtracking(String s, String searchString, String resultString, int step, Map<String, Boolean> stringMap, List<String> result) {
        for(int i = step; i < s.length(); i++) {
            searchString = searchString + s.charAt(i);
            if (stringMap.containsKey(searchString)) {
                String resultStringCopy = resultString.isEmpty() ? searchString : resultString + " " + searchString;
                if(i+1 == s.length()) {
                    result.add(resultStringCopy);
                    return;
                }
                else
                    backtracking(s, "", resultStringCopy, i + 1, stringMap, result);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");

        List<String> result = solution.wordBreak(s, wordDict);

        System.out.println(result);
    }
}