package exp3;

public class MyQueue_CA<T> {
    private int front;

    private int back;

    private int currentSize;

    private T[] theArray;

    private static final int MIN_CAPACITY = 100;

    public MyQueue_CA() {
        currentSize = 0;
        front = 0;
        back = 0;
        theArray = (T[]) new Object[MIN_CAPACITY];
    }

    public void enqueue(T data) {

        if (!isFull()) {
            theArray[back] = data;
            back = (back + 1) % MIN_CAPACITY;
            currentSize++;
        } else throw new IndexOutOfBoundsException("Queue is full");
    }

    public T dequeue() {
        if (!isEmpty()) {
            T temp = theArray[front];
            front = (front + 1) % MIN_CAPACITY;
            currentSize--;
            return temp;
        } else throw new IndexOutOfBoundsException("Queue is empty");
    }

    public int size() {
        return this.currentSize;
    }


    public boolean isFull() {
        return currentSize == theArray.length;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public String toString() {
        StringBuilder toString = new StringBuilder("[");
        int flag = 0;
        for (int i = front; i != back; i = (i + 1) % MIN_CAPACITY) {
            if (flag == 1) toString.append(",");
            toString.append(theArray[i]);
            flag = 1;
        }
        toString.append("]");
        return toString.toString();
    }

}