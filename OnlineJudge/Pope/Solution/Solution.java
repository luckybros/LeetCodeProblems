package OnlineJudge.Pope.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> Pope(int nums[], int period) {
        return divide(nums, period, 0, nums.length-1);
    }

    public List<Integer> divide(int nums[], int period, int left, int right) {
        if (right - left + 1 < period) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(0);
            result.add(0);
            return result;
        }

        int mid = (left + right) / 2;

        List<Integer> leftResult = divide(nums, period, left, mid);
        List<Integer> rightResult = divide(nums, period, mid+1, right);

        List<Integer> combined = impera(nums, period, left, mid, right);

        int leftMax = leftResult.get(0);
        int rightMax = rightResult.get(0);
        int combinedMax = combined.get(0);

        if (leftMax >= rightMax && leftMax >= combinedMax) return leftResult;
        else if (rightMax >= leftMax && rightMax >= combinedMax) return rightResult;
        else return combined;
    }

    public List<Integer> impera(int nums[], int period, int left, int mid, int right) {
        int i = mid;
        int j = mid + 1;

        while (i >= left && nums[mid+1] - nums[i] < period)
            i--;

        while (j <= right && nums[j] - nums[mid] < period)
            j++;

        List<Integer> result = new ArrayList<>();
        result.add(j - i - 1);
        result.add(nums[i+1]);
        result.add(nums[j-1]);
        return result;
    }

    public static void main(String[] args) {
        Solution soluzione = new Solution();
        // Input con valori forniti
        int Y = 5;
        int P = 20;
        int[] popeYears = {1, 2, 3, 6, 8, 12, 13, 13, 15, 16, 17, 18, 19, 20, 20, 21, 25, 26, 30, 31};

        // Chiamata alla funzione principale
        List<Integer> result = soluzione.Pope(popeYears, Y);

        // Stampa del risultato
        System.out.println(result.get(0) + " " + result.get(1) + " " + result.get(2));
    }
}
