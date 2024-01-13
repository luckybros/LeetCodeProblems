package OnlineJudge.PermutationString.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public String findIString(int index, String startString) {
        List<String> stringList = new ArrayList<>();
        backtracking(stringList, startString, String.valueOf(startString.charAt(0)), 1);
        return stringList.get(index-1);
    }

    public void backtracking(List<String> stringList, String startString, String substring, int index) {
        if(startString.length() == substring.length()) {
            String substringCopy = new String(substring);
            stringList.add(substringCopy);
            return;
        }
        
        char charToAdd = startString.charAt(index);
        for(int i = 0; i <= substring.length(); i++) {
            String modifiedString = substring.substring(0, i) + charToAdd + substring.substring(i);
            backtracking(stringList, startString, modifiedString, index+1);
        }
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        System.out.println("Inserire numero di test cases: ");
        int numTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            System.out.println("Inserire stringa e index di permutazione: ");
            String inputString = scanner.next();
            int permutationIndex = scanner.nextInt();
            String permutedString = soluzione.findIString(permutationIndex, inputString);
            System.out.println(permutedString);
        }
        scanner.close();
        
    }
}
