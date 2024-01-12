package ProveInterorso.SecondaIntercorsoDicembre;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prodotti {
    private static Scanner scanner = new Scanner(System.in);
    public int solution(List<List<Integer>> products, int budget) {
        int cache[][] = new int[products.size()+1][budget+1];
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);
        return DP(products, cache, 0, budget, 0);
    }

    public int DP(List<List<Integer>> products, int[][] cache, int expense, int budget, int index) {
        if(index == products.size()) {
            if(expense > budget) return Integer.MIN_VALUE;
            else {
                cache[index][expense] = expense;
                return cache[index][expense];
            }
        }
        if(cache[index][expense] != -1) return cache[index][expense];
        int max = Integer.MIN_VALUE;
        List<Integer> actualPrizes = products.get(index);
        for(int prize : actualPrizes) {
            max = Math.max(max, DP(products, cache, expense + prize, budget, index+1));
            cache[index][expense + prize] = max;
        }
        return max;
    }

    public static void main(String[] args) {
        Prodotti soluzione = new Prodotti();

        System.out.println("Inserisci il numero di casi di test (N): ");
        int numTestCases = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline dopo il numero di casi di test

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            System.out.println("Inserisci il budget e il numero di classi di prodotti (B C): ");
            int budget = scanner.nextInt();
            int numClasses = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline dopo il numero di classi di prodotti

            List<List<Integer>> products = new ArrayList<>();
            for (int i = 0; i < numClasses; i++) {
                System.out.println("Inserisci il numero di prodotti e i prezzi per la classe " + (i + 1) + " (M P1 P2 ...): ");
                int numProducts = scanner.nextInt();
                List<Integer> prices = new ArrayList<>();
                for (int j = 0; j < numProducts; j++) {
                    prices.add(scanner.nextInt());
                }
                scanner.nextLine(); // Consuma il newline dopo i prezzi dei prodotti
                products.add(prices);
                System.out.println(soluzione.solution(products, budget));
            }

            // Ora puoi utilizzare 'budget' e 'products' per il tuo algoritmo
            System.out.println("Eseguire l'algoritmo con budget: " + budget + " e prodotti: " + products);
        }

        scanner.close();
        // Example usage
        /*List<List<Integer>> products = Arrays.asList(
                Arrays.asList(8, 6, 4),
                Arrays.asList(5, 10),
                Arrays.asList(1, 3, 3, 7),
                Arrays.asList(50, 14, 23, 8)
        );

        int budget = 100;
        int result = soluzione.solution(products, budget);
        System.out.println(result);*/
    }
}
