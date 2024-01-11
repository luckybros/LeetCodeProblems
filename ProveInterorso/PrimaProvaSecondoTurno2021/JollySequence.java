package ProveInterorso.PrimaProvaSecondoTurno2021;

import java.util.Arrays;
import java.util.Scanner;

public class JollySequence {
    private static Scanner scanner = new Scanner(System.in);

    public boolean isJolly(int[] nums) {
        boolean[] solution = new boolean[nums.length];
        Arrays.fill(solution, false);
        Divide(nums, solution, 0, nums.length-1);
        for(int i = 1; i <= nums.length-1; i++)
            if(solution[i] == false) return false;
        return true;
    }

    public void Divide(int[] nums, boolean[] solution,  int low, int high) {
        if(high == low + 1) {
            int diff = Math.abs(nums[high] - nums[low]);
            if (diff >= 1 && diff <= nums.length - 1) 
                solution[diff] = true;
            return;
        }
        if(high == low) {
            //if (high >= 1 && high <= nums.length - 1) 
                solution[nums[high]] = true;
            return;
        }
        int mid = (high + low)/2;
        Divide(nums, solution, low, mid);
        Divide(nums, solution, mid+1, high);
        int diff = Math.abs(nums[mid+1] - nums[mid]);
        if (diff >= 1 && diff <= nums.length - 1) solution[diff] = true;
        return;
    }

    public static void main(String[] arg) {
        /*JollySequence soluzione = new JollySequence();
        System.out.println("Inserisci numero di test cases: ");
        int nTest = scanner.nextInt();

        for(int i = 0; i < nTest; i++) {
            System.out.println("Inserisci la lunghezza dell'array: ");
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for(int j = 0; j < length; j++) {
                System.out.println("Inserisci l' " + (j+1) + "-esimo elemento dell'array: ");
                int num = scanner.nextInt();
                nums[j] = num;
            }
            if(soluzione.isJolly(nums)) System.out.println("Jolly");
            else System.out.println("Not jolly");

        }*/
        int[] nums = {4,1,4,2,3};
        JollySequence soluzione = new JollySequence();
        if(soluzione.isJolly(nums)) System.out.println("Jolly");
            else System.out.println("Not jolly");
    }
}
