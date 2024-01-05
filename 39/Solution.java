import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> vector = new ArrayList<Integer>();
        int sum = 0;
        Backtracking(candidates, target, result, vector, sum, 0);
        return result;
    }

    public void Backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> vector, int sum, int step) {
        if(sum == target) {
            List<Integer> vectorCopy = new ArrayList<Integer>(vector);
            result.add(vectorCopy);
            return;
        }

        if(sum > target)
            return;

        for(int i = step; i < candidates.length; i++) {
            vector.add(candidates[i]);
            Backtracking(candidates, target, result, vector, sum + candidates[i], i);
            vector.remove(vector.size() - 1);
        }
    }
}

    public static void main(String[] arg) {
        int arr[] = new int[] {2, 3, 5};
        Solution soluzione = new Solution();

        for(List<Integer> element : soluzione.combinationSum(arr, 8))
            System.out.println(element);
    }
}