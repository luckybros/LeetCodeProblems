package Peter.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findTwoBooks(int[] booksPrizes, int peterBudget) {
        Arrays.sort(booksPrizes);

        List<List<Integer>> result = new ArrayList<>(); 
    }

    public void binarySearch(List<List<Integer>> result, int[] booksPrizes, int peterBudget, int right, int left) {
        if(right == left) return;

        int sum = booksPrizes[right] + booksPrizes[left];

        if(sum == peterBudget) {
            List<Integer> solution = new ArrayList<>();
            solution.add(booksPrizes[right]);
            solution.add(booksPrizes[left]);
            result.add(solution);

            return;
        }

        
    }
}
