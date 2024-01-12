package ProveInterorso.PrimaProvaSecondoTurno2021.Viaggio;

import java.util.Scanner;

public class Viaggio {
    private static Scanner scanner = new Scanner(System.in);

    public float solution(float nums[]) {
        float sum = 0;
        for(float num : nums)
            sum = sum + num;
        float average = sum / nums.length;
        float parteDecimale = average % 1;
        average = average - parteDecimale;
        float result = 0;

        for(float num : nums) {
            float x = average - num;
            if(x > 0) result += x;
        }
        return result;
    }
    public static void main(String[] arg) {
        Viaggio soluzione = new Viaggio();
        System.out.println("Inserisci numero di test cases: ");
        int nTest = scanner.nextInt();

        for(int i = 0; i < nTest; i++) {
            System.out.println("Inserisci il numero di studenti: ");
            int nStudenti = scanner.nextInt();
            float prizes[] = new float[nStudenti];
            for(int j = 0; j < nStudenti; j++) {
                System.out.println("Inserisci la spesa " + (j+1) + "- esima:");
                float n = scanner.nextFloat();
                prizes[j] = n;
            }
            System.out.println(soluzione.solution(prizes));
        }
            
    }
}
