// Analisi di complessità: si è utilizzato un approccio divide et impera
// piuttosto che uno brute force, la cui complessità sarebbe stata O(n^2).
// La ricorrenza relativa alla funzione ricorsiva è T(n) = 2T(n/2) + theta(n),
// poichè il peso della funzione relativa alla divisione è costante essendo
// solo il calcolo della posizione media, mentre la C(n) relativa alla ricombinazione
// è lineare. Di conseguenza, sia dal caso due del teorema dell'esperto
// e sia utilizzando il metodo iterativo, la cui sommatoria risultante è 
// sum i from 0 to logn-1(n) + theta(1), la complessità risulta O(nlgn).

package Esame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Es2 {
    private static Scanner scanner = new Scanner(System.in);

    /*public List<Integer> findMostEventsQuadratic(int[] events, int period) {
        List<Integer> result = new ArrayList<>();

        int[] cache = new int[events.length];
    }*/

    public List<Integer> findMostEvents(int[] events, int period) {
        return divide(events, period, 0, events.length - 1);
    }

    public List<Integer> divide(int[] events, int period, int left, int right) {
        if (right == left) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            result.add(events[left]);
            result.add(events[left]);
            return result;
        }

        int middle = (left + right) / 2;

        List<Integer> leftResult = divide(events, period, left, middle);
        List<Integer> rightResult = divide(events, period, middle + 1, right);
        List<Integer> combined = conquer(events, period, left, middle, right);

        int leftMax = leftResult.get(0);
        int rightMax = rightResult.get(0);
        int combinedMax = combined.get(0);

        if (leftMax >= rightMax && leftMax >= combinedMax) return leftResult;
        else if (rightMax >= leftMax && rightMax >= combinedMax) return rightResult;
        else return combined;
    }

    private List<Integer> conquer(int[] events, int period, int left, int mid, int right) {
        int numEvents = 0;
        int startYear = 0;
        int endYear = 0;
        for(int i = mid; i >= left; i--) {
            if(events[mid+1] - events[i] >= period)
                break;
            numEvents++;
            startYear = events[i];
        }

        for(int i = mid+1; i <= right; i++) {
            if(events[i] - events[mid] >= period)
                break;
            numEvents++;
            endYear = events[i];
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(numEvents);
        result.add(startYear);
        result.add(endYear);

        return result;
    }

    public static void main(String[] arg) {
        Es2 soluzione = new Es2();
        System.out.println("Inserisci in numero di casi di test: ");
        int numTest = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numTest; i++) {
            System.out.println("Inserisci Y: ");
            int Y = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci numero eventi: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] events = new int[n];
            for(int j  = 0; j < n; j++) {
                events[j] = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.println("TEST OUTPUT: ");
            for(int k : soluzione.findMostEvents(events, Y))
                System.out.print(k + " ");
            System.out.println();
        }
    }
}
