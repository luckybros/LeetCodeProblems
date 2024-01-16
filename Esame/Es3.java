// Analisi di complessità: attraverso il Dynamic Programming si può ridurre
// la complessità da esponenziale a quadratica, essendo che nell'approccio Bottom
// Up quello che l'algoritmo itera semplicemente su una matrice nxn.
// La complessità è quindi O(n^2)

package Esame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Es3 {
    private static Scanner scanner = new Scanner(System.in);

    /*public List<Integer> longestSubsequenceTopDown(List<Integer> reference, List<List<Integer>> inputSequences) {
        List<Integer> result = new ArrayList<>();
        int[][] cache = new int[reference.size()+1][reference.size()+1];
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);
        for(int i = 0; i < inputSequences.size(); i++)
            result.add(DP())
    }

    public int DP(List<Integer> reference, List<Integer> sequence, int i, int j, int[][] cache) {

    }*/

    public List<Integer> longestSubsequenceBottomUp(List<Integer> reference, List<List<Integer>> inputSequences) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < inputSequences.size(); i++)
            result.add(longestSubsequenceBottomUpHelper(reference, inputSequences.get(i)));
        return result;
    }

    public int longestSubsequenceBottomUpHelper(List<Integer> reference, List<Integer> sequence) {
        int[][] cache = new int[reference.size()+1][reference.size()+1];
        for(int i = 0; i < cache.length; i++)
            cache[i][reference.size()] = 0;
        for(int i = 0; i < cache.length; i++)
            cache[reference.size()][i] = 0;

        for(int i = reference.size()-1; i >= 0; i--)
            for(int j = reference.size()-1; j >= 0; j--) {
                if(reference.get(i) == sequence.get(j)) cache[i][j] = 1 + cache[i+1][j+1];
                else cache[i][j] = Math.max(cache[i+1][j], cache[i][j+1]);
            }
        return cache[0][0];
    }
    

    public static void main(String[] arg) {
        Es3 soluzione = new Es3();
        System.out.println("Inserisci il numero di casi di test: ");
        int numTest = scanner.nextInt();
        scanner.nextLine();
    
        for(int i = 0; i < numTest; i++) {
            System.out.println("Inserisci lunghezza sequenza di riferimento: ");
            int n = scanner.nextInt();
            scanner.nextLine();
        
            List<Integer> reference = new ArrayList<>();
            List<List<Integer>> inputSequences = new ArrayList<>();
        
            System.out.println("Inserisci gli elementi della sequenza di riferimento: ");
            for(int j = 0; j < n; j++) {
                reference.add(scanner.nextInt());
            }
            scanner.nextLine();
        
            int terminator = 1;
            while (terminator != 0) {
                List<Integer> inputSequence = new ArrayList<>();
                System.out.println("Inserisci gli elementi della sequenza di input (termina con 0): ");
                for(int k = 0; k < n; k++){
                    if(terminator == 0)
                        break;
                    terminator = scanner.nextInt();
                    inputSequence.add(terminator);
                }
                scanner.nextLine();
                if (terminator != 0) 
                    inputSequences.add(inputSequence);
            }
        
            System.out.println("TEST OUTPUT:");
            List<Integer> result = soluzione.longestSubsequenceBottomUp(reference, inputSequences);
            for(int l : result)
                System.out.println(l);
        }
    }
}
