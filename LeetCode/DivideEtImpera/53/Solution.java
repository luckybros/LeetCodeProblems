class Solution {
    public static int maxSubArrayQuadratic(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static int maxSubArrayLinear(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(sum < 0)
                sum = 0;

            sum += nums[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }

    public static int maxSubArrayDivideEtImpera(int[] nums) {
        return maxSum(nums, 0, nums.length-1);
    }

    public static int maxSum(int[] nums, int l, int r) {
        if(l < r) {
            int q = (l+r)/2;
            int maxLeftSum = maxSum(nums, l, q);
            int maxRightSum = maxSum(nums, q+1, r);
            int maxSum = maxSumMerge(nums, l, q, r);
            return Math.max(Math.max(maxLeftSum, maxRightSum), maxSum);
        }
        else 
            return nums[l];
    }

    public static int maxSumMerge(int[] nums, int l, int q, int r) {
        int leftMax = nums[q];
        int rightMax = nums[q+1];
        int leftSum = nums[q];
        int rightSum = nums[q+1];

        int i;
        for(i = q+2; i <= r; i++) {
            rightSum += nums[i];
            if(rightSum > rightMax)
                rightMax = rightSum;
        }

        for(i = q-1; i >= l; i--) {
            leftSum += nums[i];
            if(leftSum > leftMax)
                leftMax = leftSum;
        }

        return leftMax+rightMax;
    }
    
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        int result = maxSubArrayDivideEtImpera(nums);
        System.out.println("Result: " + result);
    }
}

