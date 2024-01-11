import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int cache[] = new int[nums.length];
        Arrays.fill(cache, -1);
        return DP(nums, 0, cache);
    }

    public int DP(int[] nums, int index, int[] cache) {
        if(index >= nums.length)
            return 0;

        if(cache[index] >= 0)
            return cache[index];

        int result = Math.max((nums[index] + DP(nums, index + 2, cache)), DP(nums, index + 1, cache));
        cache[index] = result;
        return result;
    }

    public static void main(String[] arg) {
        int nums[] = {1, 2, 3, 1};
        Solution soluzione = new Solution();
        System.out.println(soluzione.rob(nums));
    }
}