package HammingDistance.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public List<List<Integer>> hammingResolutor(int data, int hammingDistance) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < data; i++) 
            temp.add(0);
        backtracking(result, temp, 0, data, hammingDistance);
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> temp, int step, 
        int data, int hammingDistance) {
            if(step == hammingDistance) {
                if(!result.contains(temp)) {
                    List<Integer> tempCopy = new ArrayList<>(temp);
                    result.add(tempCopy);
                }
                return;
            }

            for(int i = step; i < data; i++) 
                if(temp.get(i) == 0) {
                    temp.set(i, 1);
                    backtracking(result, temp, step+1, data, hammingDistance);
                    temp.set(i, 0);
                }
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        System.out.print("Inserisci numero di test cases: ");
        int nTest = scanner.nextInt();

        for(int i = 0; i < nTest; i++) {
            System.out.println("Inserisci numero bit per il " + (i+1) + " test: ");
            int nBit = scanner.nextInt();
            System.out.println("Inserisci distanza di Hamming per il " + (i+1) + " test: ");
            int hDistance = scanner.nextInt();
            for(List<Integer> list : soluzione.hammingResolutor(nBit, hDistance)) 
                System.out.println(list);
        }

    }
}
