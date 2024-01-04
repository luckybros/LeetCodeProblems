import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>(); 
        }
        HashMap<String, String> charFromDigits = new HashMap<String, String>();
        charFromDigits.put("2", "abc");
        charFromDigits.put("3", "def");
        charFromDigits.put("4", "ghi");
        charFromDigits.put("5", "jkl");
        charFromDigits.put("6", "mno");
        charFromDigits.put("7", "pqrs");
        charFromDigits.put("8", "tuv");
        charFromDigits.put("9", "wxyz");
        List<String> result = new ArrayList<String>();
        String resultString = "";
        Backtracking(charFromDigits, digits, digits.length(), result, resultString, 0);
        return result;
    }

    void Backtracking(HashMap<String, String> charFromDigits, String digits, int length, List<String> result, String resultString, int step){
        if(resultString.length() == length) {
            String resultStringCopy = new String(resultString);
            result.add(resultStringCopy);
            return;
        }

        if(charFromDigits.containsKey(String.valueOf(digits.charAt(step)))) {
            String digitsNumbers = charFromDigits.get(String.valueOf(digits.charAt(step)));

        for(int i = 0; i < digitsNumbers.length(); i++) {
            resultString = resultString + digitsNumbers.charAt(i);
            Backtracking(charFromDigits, digits, length, result, resultString, step + 1);
            resultString = resultString.substring(0, resultString.length() - 1); 
            }
        }
    }

    public static void main(String arg[]) {
        Solution soluzione = new Solution();
        String digits = "34";
        List<String> result = soluzione.letterCombinations(digits);

        for(String s : result) 
            System.out.println(s);
    }

}