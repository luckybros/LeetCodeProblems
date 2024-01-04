#include <iostream>

class Queue {
private:
    static const int MAX_SIZE = 3;
    int arr[MAX_SIZE];
    int front;
    int rear;

public:
    Queue() {
        front = 0;
        rear = 0;
        for(int i = 0; i < MAX_SIZE; i++)
            arr[i] = -1;
    }

    bool isEmpty() {
        return front == rear;
    }

    bool isFull() {
        return front == ((rear + 1) % MAX_SIZE);
    }

    void enqueue(int x) {
        if (isFull())
            return;

        arr[rear] = x;
        rear = (rear + 1) % MAX_SIZE;
    }

    void dequeue() {
        if (isEmpty())
            return;

        front = (front + 1) % MAX_SIZE;
    }

    void printQueue() {
        if (isEmpty()) {
            std::cout << "La coda è vuota." << std::endl;
            return;
        }

        for (int i = front; i <= rear ; i = (i + 1) % MAX_SIZE) {
            std::cout << arr[i] << " ";
        }
    }
};

int main() {
    Queue myQueue;

    myQueue.enqueue(1);
    myQueue.enqueue(2);
    myQueue.enqueue(3);

    myQueue.dequeue();

    myQueue.printQueue();

    return 0;
}
