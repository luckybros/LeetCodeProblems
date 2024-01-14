package OnlineJudge.Pope.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> findLargestNumberOfPopes(int[] popeYears, int period) {
        return divide(popeYears, period, 0, popeYears.length - 1);
    }

    private static List<Integer> divide(int[] popeYears, int period, int left, int right) {
        if (popeYears[right] - popeYears[left] + 1 <= period) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            result.add(0);
            result.add(0);
            return result;
        }

        int mid = (left + right) / 2;

        List<Integer> leftResult = divide(popeYears, period, left, mid);
        List<Integer> rightResult = divide(popeYears, period, mid + 1, right);

        List<Integer> combined = conquer(popeYears, period, left, mid, right);

        int leftMax = leftResult.get(0);
        int rightMax = rightResult.get(0);
        int combinedMax = combined.get(0);

        if (leftMax >= rightMax && leftMax >= combinedMax) {
            return leftResult;
        } else if (rightMax >= leftMax && rightMax >= combinedMax) {
            return rightResult;
        } else {
            return combined;
        }
    }

    private static List<Integer> conquer(int[] popeYears, int period, int left, int mid, int right) {
        int i = mid;
        int j = mid + 1;

        while (i >= left && popeYears[mid + 1] - popeYears[i] < period) {
            i--;
        }

        while (j <= right && popeYears[j] - popeYears[mid] < period) {
            j++;
        }

        List<Integer> result = new ArrayList<>();
        result.add(j - i - 1);
        result.add(popeYears[i + 1]);
        result.add(popeYears[j - 1]);
        return result;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        int Y = 6;
        int P = 20;
        int[] popeYears = {850, 860, 865, 870, 875};

        List<Integer> result = findLargestNumberOfPopes(popeYears, Y);

        System.out.println(result.get(0) + " " + result.get(1) + " " + result.get(2));
    }
}
