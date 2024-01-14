package ProveInterorso.PrimaProva.MinDifference;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public int minDifference(int[][] nums) {
        for(int i = 0; i < nums.length; i++)
            Arrays.sort(nums[i]);

        int[] minNums = divide(nums, 0, nums[0].length-1);
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < minNums.length; i++)
            min = Math.min(min, minNums[i] - minNums[i-1]);

        return min;
    }

    public int[] divide(int[][] nums, int right, int left) {
        if(right == left) {
            int[] vector = new int[nums.length];
            for(int i = 0; i < nums.length; i++)
                vector[i] = nums[i][right];

            return vector;
        }

        int middle = (left + right) / 2;

        int[] leftVector = divide(nums, right, middle);
        int[] rightVector = divide(nums, middle+1, left);    

        return impera(nums, leftVector, rightVector, right, middle, left);
    }

    public int[] impera(int[][] nums, int[] leftVector, int[] rightVector, int right, int middle, int left) {
        int leftMin = Integer.MAX_VALUE;
        for(int i = 1; i < leftVector.length; i++)
            leftMin = Math.min(leftMin, Math.abs(leftVector[i] - leftVector[i-1]));

        int rightMin = Integer.MAX_VALUE;
        for(int i = 1; i < rightVector.length; i++)
            rightMin = Math.min(rightMin, Math.abs(rightVector[i] - rightVector[i-1]));

        int[] middleVector = new int[leftVector.length];
        int middleMin = Integer.MAX_VALUE;

        for(int i = 1; i < middleVector.length; i++) {
            int firstCrossDifference = Math.abs(leftVector[i] - rightVector[i-1]);
            int secondCrossDifference = Math.abs(rightVector[i] - leftVector[i-1]);

            if(firstCrossDifference <= secondCrossDifference) {
                middleVector[i] = leftVector[i];
                middleVector[i-1] = rightVector[i-1];
                middleMin = firstCrossDifference;
            }

            else {
                middleVector[i] = leftVector[i];
                middleVector[i-1] = rightVector[i-1];
                middleMin = secondCrossDifference;
            }
        }

        if(Math.min(leftMin, Math.min(rightMin, middleMin)) == leftMin) return leftVector;
        else if(Math.min(leftMin, Math.min(rightMin, middleMin)) == middleMin) return middleVector;
        else  return rightVector;
    }

    public static void main(String[] arg) {
        Solution soluzione = new Solution();
        System.out.println("Inserisci in numero di casi di test: ");
        int numTest = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < numTest; i++) {
            System.out.println("Inserisci il numero di righe e di colonne: ");
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            scanner.nextLine();

            int[][] matrix = new int[rows][columns];
            for(int j = 0; j < rows; j++) 
                for(int k = 0; k < columns; k++) {
                    System.out.println("Inserisci l'elemento in posizione (" + j + ", " + k + "):");
                    int x = scanner.nextInt();
                    scanner.nextLine();
                    matrix[j][k] = x;
                }
            System.out.println("La differenza minima è " + soluzione.minDifference(matrix));
                    
        } 
    }
}
