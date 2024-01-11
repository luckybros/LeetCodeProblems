class Aritmetic {
    public int findMissingNumber(int[] nums) {
        return Divide(nums, 0, nums.length-1);
    }

    public int Divide(int[] nums, int left, int right) {
        if(left + 1 == right)
            return (nums[left] + nums[right]) / 2;
        
        int middle = (left + right) / 2;
        if(nums.length % 2 == 0) 
            if(nums[middle] - nums[left] > nums[right] - nums[middle + 1])
                return Divide(nums, left, middle);
            else
                return Divide(nums, middle + 1, right);
        else
            if(nums[middle] - nums[left] > nums[right] - nums[middle])
                return Divide(nums, left, middle);
            else
                return Divide(nums, middle, right);
    }


    public static void main(String[] arg) {
        int nums[] = {1, 3, 5, 9};
        Aritmetic soluzione = new Aritmetic();
        System.out.println(soluzione.findMissingNumber(nums));
    }
}
