package AllocatedBooks.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public int findPages(List<Integer> array, int numBooks,int numStudents) {
        int low = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            int current = array.get(i);
            if (current < low) low = current;
        }
        
        int high = 0;
        for(int number: array)
            high += number;
        
        return binarySearch(array, numBooks, numStudents, low, high);
    }
    
    public int binarySearch(List<Integer> array, int numBooks, int numStudents, int low, int high) {
        if(high > low) {
            int mid = (high + low) / 2;
            if(isPossible(array, numBooks, numStudents, mid)) return binarySearch(array, numBooks, numStudents, low, mid);
            else return binarySearch(array, numBooks, numStudents, mid+1, high);
        }
        else return low;
    }

    public boolean isPossible(List<Integer> array, int numBooks, int numStudents, int numPages) {
        int students = 1;
        int curSum = 0;

        for(int i = 0; i < numBooks; i++) {
            if(array.get(i) > numPages) return false;

            if(curSum + array.get(i) > numPages) {
                students++; 
                curSum = array.get(i);
                if(students > numStudents) return false;
            }

            else curSum += array.get(i);
            
        }

        return true;
    }

    public void printSolution(List<Integer> array, int solution, int numStudents) {
        int curSum = 0;
        int assignedStudents = 0;
        for (int i = 0; i < array.size(); i++) {
            curSum += array.get(i);

            if (curSum >= solution || array.size() - assignedStudents == numStudents - 1) {
                System.out.print("/ ");
                curSum = 0;
                assignedStudents++;
            }

            System.out.print(array.get(i) + " ");
        }
    }

    public static void main(String[] arg) {
        System.out.print("Inserisci la dimensione della lista di libri: ");
        int numBooks = scanner.nextInt();

        System.out.print("Inserisci il numero di studenti: ");
        int numStudents = scanner.nextInt();

        List<Integer> bookList = new ArrayList<>();
        System.out.println("Inserisci i valori della lista di libri:");

        for (int i = 0; i < numBooks; i++) {
            int bookPages = scanner.nextInt();
            bookList.add(bookPages);
        }

        Solution solution = new Solution();
        int result = solution.findPages(bookList, numBooks, numStudents);
        System.out.println(result);
        solution.printSolution(bookList, result, numStudents);

        scanner.close();
        
    }
};
