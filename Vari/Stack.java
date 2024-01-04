package Vari;

public class Stack {
    private int[] arr;
    public int top;
    private int size;

    public Stack(int capacity) {
        size = capacity;
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int x) {
        if (!isFull()) {
            arr[++top] = x;
        } else {
            System.out.println("Overflow: la pila è piena");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int elementoRimosso = arr[top--];
            return elementoRimosso;
        } else {
            System.out.println("Underflow: la pila è vuota");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("La pila è vuota");
            return -1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Elemento in cima alla pila: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("La pila è vuota: " + stack.isEmpty());
    }
}
