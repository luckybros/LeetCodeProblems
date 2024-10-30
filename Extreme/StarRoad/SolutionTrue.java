import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// Please name your class Main
public class SolutionTrue {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
        
        // Lettura del numero di hotel
        int numHotels = in.nextInt();
        
        // Lettura delle stelle di ogni hotel
        List<Integer> stars = new ArrayList<>();
        for (int i = 0; i < numHotels; i++) {
            stars.add(in.nextInt());
        }
        
        // Lettura delle connessioni tra gli hotel
        int[][] links = new int[numHotels+1][numHotels+1];
        while (in.hasNextInt()) {
            int from = in.nextInt(); 
            int to = in.nextInt();
            links[from][to] = 1;
            links[to][from] = 1; 
        }
        
        // Creazione dell'istanza della classe Main per invocare il metodo starRoad
        SolutionTrue main = new SolutionTrue();
        int result = main.starRoad(numHotels, stars, links);
        
        // Stampa del risultato
        System.out.println(result);
	}
	
	public int starRoad(int numHotels, List<Integer> stars, int[][] links) {
        int[][] cache = new int[numHotels+1][numHotels+1];

        // Inizializzando la mappa
        for(int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], -1);

        Integer max = Integer.MIN_VALUE;

        for(int i = 0; i < numHotels; i++) {
            max = Math.max(max, Math.max(DP(numHotels, 0, stars.get(i), stars, links, cache, i), 1 + DP(numHotels, 1, stars.get(i), stars, links, cache, i)));
        }

        return max;
    }

    public int DP(int numHotels, int step, int constraint, List<Integer> stars, int[][] links, int[][] cache, int i) {
        Integer max = Integer.MIN_VALUE;
        Boolean hasChild = false;
        for(int j = 0; j < numHotels; j++) {
            if(links[i][j] == 1) {
                if(cache[i][j] != -1) return cache[i][j];
                hasChild = true;
                max = Math.max(max, DP(numHotels, step, constraint, stars, links, cache, j));
                if(stars.get(i) > constraint) {
                    max = Math.max(max, 1 + DP(numHotels, step + 1, stars.get(i), stars, links, cache, j));
                }
                cache[i][j] = max;
            }
        }

        if(!hasChild) return stars.get(i) >constraint ? 1 : 0;
            
        return max;
    }
}