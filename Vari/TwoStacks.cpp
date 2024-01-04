#include <iostream>

class TwoStacks {
private:
    int* arr;      // Array per contenere gli elementi
    int size;      // Dimensione totale dell'array
    int top1;      // Puntatore superiore per la prima pila
    int top2;      // Puntatore superiore per la seconda pila

public:
    // Costruttore per inizializzare la classe con la dimensione dell'array
    TwoStacks(int n) {
        size = n;
        arr = new int[size];
        top1 = -1;  // Inizializza il puntatore superiore per la prima pila
        top2 = size;  // Inizializza il puntatore superiore per la seconda pila
    }

    // Funzione per Push nella prima pila
    void push1(int x) {
        // Controlla se c'è spazio sufficiente tra le pile
        if (top1 < top2 - 1) {
            arr[++top1] = x;  // Incrementa e inserisce nella prima pila
        } else {
            std::cout << "Overflow nella prima pila" << std::endl;
        }
    }

    // Funzione per Push nella seconda pila
    void push2(int x) {
        // Controlla se c'è spazio sufficiente tra le pile
        if (top1 < top2 - 1) {
            arr[--top2] = x;  // Decrementa e inserisce nella seconda pila
        } else {
            std::cout << "Overflow nella seconda pila" << std::endl;
        }
    }

    // Funzione per Pop dalla prima pila
    int pop1() {
        // Controlla se la prima pila non è vuota
        if (top1 >= 0) {
            return arr[top1--];  // Restituisce e decrementa il puntatore
        } else {
            std::cout << "Underflow nella prima pila" << std::endl;
            return -1;  // Valore sentinella per indicare errore
        }
    }

    // Funzione per Pop dalla seconda pila
    int pop2() {
        // Controlla se la seconda pila non è vuota
        if (top2 < size) {
            return arr[top2++];  // Restituisce e incrementa il puntatore
        } else {
            std::cout << "Underflow nella seconda pila" << std::endl;
            return -1;  // Valore sentinella per indicare errore
        }
    }
};

int main() {
    TwoStacks ts(6);  // Crea un'istanza con un array di dimensione 6

    ts.push1(1);
    ts.push2(6);
    ts.push2(11);
    ts.push1(2);
    ts.push1(3);

    std::cout << "Elemento pop dalla prima pila: " << ts.pop1() << std::endl;
    std::cout << "Elemento pop dalla seconda pila: " << ts.pop2() << std::endl;

    return 0;
}
