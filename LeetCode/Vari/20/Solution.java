
import java.util.Stack;



class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Utilizzare char invece di Character

            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else {
                if(stack.isEmpty())
                    return false;

                char r = stack.pop();

                if(c == ')' && r != '(') return false;
                if(c == ']' && r != '[') return false;
                if(c == '}' && r != '{') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] arg) {
        String input = "()[]{}";

        System.out.println(isValid(input));
    }
}
