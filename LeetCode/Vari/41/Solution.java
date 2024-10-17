
import java.util.HashMap;

class Solution {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= length; i++) 
            map.put(i, 0);

        for(int i = 0; i < length; i++) 
            if(nums[i]<= length && nums[i] >= 1) 
                map.put(nums[i], 1);
        
        for(int i = 1; i <= length; i++) 
            if(map.get(i).equals(0))
                return i;

        return length+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};

        System.out.println(firstMissingPositive(nums));
    }
}