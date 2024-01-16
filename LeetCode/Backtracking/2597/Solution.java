import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int result[] = new int[1];
        result[0] = 0;
        List<Integer> subset = new ArrayList<>();
        Backtracking(nums, subset, k, 0, result);
        return result[0];
    }

    public void Backtracking(int[] nums, List<Integer> subset, int k, int step, int[] result) {
        for(int i = step; i < nums.length; i++) {
            subset.add(nums[i]);
            if(isOkay(subset, k)) {
                result[0]++;
                Backtracking(nums, subset, k, i + 1, result);
            }
                subset.remove(subset.size() - 1);
        }
    }

    public boolean isOkay(List<Integer> subset, int k) {
        Set<Integer> seen = new HashSet<>();
    
        for (int num : subset) {
            if (seen.contains(num - k) || seen.contains(num + k)) 
                return false;
            seen.add(num);
        }
    
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 4, 6};
        int k = 2;
        int result = solution.beautifulSubsets(nums, k);
        System.out.println("Result: " + result);
    }
}