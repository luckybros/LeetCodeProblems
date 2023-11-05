import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, 0, 0, n, "");
        return result;
    }

    public void backtracking(List<String> result, int open, int closed, int n, String current) {
        if (open == n && closed == n) {
            result.add(current);
            return;
        }

        if (open < n) {
            backtracking(result, open + 1, closed, n, current + "(");
        }

        if (closed < open) {
            backtracking(result, open, closed + 1, n, current + ")");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> combinations = solution.generateParenthesis(n);

        System.out.println("All combinations of well-formed parentheses for n = " + n + " are:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
