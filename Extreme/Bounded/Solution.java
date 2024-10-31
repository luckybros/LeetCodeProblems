// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int numElements = in.nextInt();   // Leggi il numero di elementi
        int numConstraints = in.nextInt(); // Leggi il numero di vincoli

        // Leggi i vincoli in base al formato fornito
        List<List<Integer>> constraints = new ArrayList<>();
        for (int i = 0; i < numConstraints; i++) {
            List<Integer> constraint = new ArrayList<>();
            constraint.add(in.nextInt());
            constraint.add(in.nextInt());
            constraint.add(in.nextInt());
            int numVariables = constraint.get(2);
            for (int j = 0; j < numVariables; j++) { 
                constraint.add(in.nextInt());
            }
            constraints.add(constraint);
        }

        Main main = new Main();
        Integer result = main.solution(numElements, numConstraints, constraints);
        System.out.println(result);
    }
	
	public int solution(int numElements, int numConstraints, List<List<Integer>> constraints) {
	    
	    HashMap<Integer, List<Integer>> map = new HashMap<>();
	    
	    for(int i = 1; i <= numElements; i++)    
	        map.put(i, new ArrayList<>(Arrays.asList(-1, -1)));
	        
	    getIntervals(map, constraints);
	    
	    int[] result = new int[1];
	    List<Integer> variables = new ArrayList<>();
	    
	    Backtracking(result, 0, numElements, variables, map, constraints);
	    
	    return result[0];
	}
	
	public void getIntervals(HashMap<Integer, List<Integer>> map, List<List<Integer>> constraints) {
	    
	    for(int i = 0; i < constraints.size(); i++) {
	        int lowBound = constraints.get(i).get(0);
	        int highBound = constraints.get(i).get(1);
	        int numVariables = constraints.get(i).get(2);
	        
	        for (int j = 1; j <= numVariables; j++) {
	       
                int variable = constraints.get(i).get(2 + j); 
                if (map.get(variable).get(0) == -1)
                    map.put(variable, new ArrayList<>(Arrays.asList(0, highBound)));
                else {
                    int oldHighBound = map.get(variable).get(1);
                    map.put(variable, new ArrayList<>(Arrays.asList(0, Math.min(highBound, oldHighBound))));
                }
            }
	    }
	}
	
	public void Backtracking(int[] result, int step, int numVariables, List<Integer> variables, HashMap<Integer, List<Integer>> map, List<List<Integer>> constraints) {
	    
	    if(step == numVariables) {
	        for(int i = 0; i < constraints.size(); i++) {
	            int lowBound = constraints.get(i).get(0);
	            int highBound = constraints.get(i).get(1);
	            int numVariableEquations = constraints.get(i).get(2);
	            int sum = 0;
	            for(int j = 1 ; j <= numVariableEquations; j++) {
	                sum += variables.get(constraints.get(i).get(2+j) - 1);
	            }
	            if(sum < lowBound || sum > highBound) return;
	        }
	        result[0]++;
	        return;
	    }
	    
	    int lowerBound = map.get(step + 1).get(0);
        int highBound = map.get(step + 1).get(1);
        for (int j = lowerBound; j <= highBound; j++) {
            variables.add(j);
            Backtracking(result, step + 1, numVariables, variables, map, constraints);
            variables.remove(variables.size() - 1);
        }
	    
	}
	    
}
	
	
	
	
