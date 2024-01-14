package ProveInterorso.PrimaProva.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findStrings(String inputString) {
        List<String> result = new ArrayList<>();
        backtracking(result, inputString, "", 0, inputString.length());
        return result;
    }

    public void backtracking(List<String> result, String inputString, String current, int step, int finalStep) {
        if (step == finalStep) {
            if (!result.contains(current.trim())) {
                result.add(current);
            }
            return;
        }

        // Aggiungi il carattere senza spazio
        backtracking(result, inputString, current + inputString.charAt(step), step + 1, finalStep);

        // Ripristina lo stato della stringa prima di aggiungere lo spazio
        backtracking(result, inputString, current + inputString.charAt(step) + " ", step + 1, finalStep);
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        for (String s : soluzione.findStrings("XYZ"))
            System.out.println(s);
    }
}
