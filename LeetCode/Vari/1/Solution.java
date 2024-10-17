import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] arg) {
        int[] nums = {2,7,11,15};
        int target = 9;
        
        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                int[] result = { i, map.get(complement) };
                return result;
            }
        }
        int[] result = { 0, 0 };
        return result;
    }

    
}