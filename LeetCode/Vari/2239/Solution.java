class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;

        for(int num : nums) {
            if(Math.abs(num) < distance) { 
                min = num;
                distance = Math.abs(num);
            }
            else if(Math.abs(num) == distance) 
                min = Math.max(num, min);
        }
                
        return min;
    }
}