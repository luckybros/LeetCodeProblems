import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TargetSum {
    public List<Integer> findTargetSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        binarySearch(nums, 0, nums.length-1, target, result);

        List<Integer> subVector = result.get(0);
        for(List<Integer> list : result) {
            if(Math.abs(list.get(1) - list.get(0)) < Math.abs(subVector.get(1) - subVector.get(0)))
                subVector = list;
        }
        return subVector;
    }

    public void binarySearch(int[] nums, int right, int left, int target, List<List<Integer>> result) {
        if(left == right) return;
        int sum = nums[left] + nums[right];

        if(sum == target) {
            List<Integer> subCopy = new ArrayList<>();
            subCopy.add(nums[left]);
            subCopy.add(nums[right]);
            result.add(subCopy);
            binarySearch(nums, right+1, left, target, result);
        }
        else if(sum > target) binarySearch(nums, right, left-1, target, result);
        else if(sum < target) binarySearch(nums, right+1, left, target, result);
    }
    
    public static void main(String[] arg) {
        int nums[] = {10, 2, 6, 8, 4};
        TargetSum solution = new TargetSum();
        for (Integer i : solution.findTargetSum(nums, 10)) 
            System.out.println(i);
    }
}
