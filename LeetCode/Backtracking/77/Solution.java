import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subVector = new ArrayList<>();
        Backtracking(result, subVector, k, n, 1);
        return result;
    }

    void Backtracking(List<List<Integer>> result, List<Integer> subVector, int k, int n, int start) {
        if(subVector.size() == k){ 
            List<Integer> subVectorCopy = new ArrayList<>(subVector);
            result.add(subVectorCopy);
            return;
        }
            
        for(int i = start; i <= n; i++) {
            subVector.add(i);
            Backtracking(result, subVector, k, n, i+1);
            subVector.remove(subVector.size() - 1);
        }
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        int n = 4;
        int k = 2;

        List<List<Integer>> combinations = solution.combine(n, k);

        System.out.println("Combinations for n = " + n + " and k = " + k + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }

    }
}
