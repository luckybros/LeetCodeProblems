// Analisi di complessità: poiché ad ogni passo stiamo richiamando una funzione
// ricorsiva che effettua due scelte, la complessità temporale del backtracking
// sarà O(2^n), dove n è l'input di bit 

package Esame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Es1 {
    private static Scanner scanner = new Scanner(System.in);

    public List<Integer> nBits(int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> subresult = new ArrayList<>();
        backtracking(result, subresult, 0, 0, n);
        return result;
    }

    public void backtracking(List<Integer> result, List<Integer> subresult, int step, int direction, int n) {
        if(step == n) {
            int calculated = 0;
            int j = 0;
            for(int i = subresult.size()-1; i >= 0; i--) 
                calculated += subresult.get(i)*Math.pow(2, j++);
            result.add(calculated);
            return;
        }

        if(direction == 0) {
            subresult.add(0);
            backtracking(result, subresult, step+1, 0, n);
            subresult.remove(subresult.size()-1);
            subresult.add(1);
            backtracking(result, subresult, step+1, 1, n);
            subresult.remove(subresult.size()-1);
        }

        else if(direction == 1) {
            subresult.add(1);
            backtracking(result, subresult, step+1, 0, n);
            subresult.remove(subresult.size()-1);
            subresult.add(0);
            backtracking(result, subresult, step+1, 1, n);
            subresult.remove(subresult.size()-1);
        }

    }
    public static void main(String[] arg) {
        Es1 soluzione = new Es1();
        //System.out.println("Inserisci in numero di casi di test: ");
        int numTest = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numTest; i++) {
            //System.out.println("Inserisci n: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            System.out.println("TEST OUTPUT:");
            for(int j : soluzione.nBits(n))
                System.out.println(j);
        }
    }
}
