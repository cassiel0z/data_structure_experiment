package exp3;

public class MyQueue_AL<T> {

    private int front;

    private int back;

    private int currentSize;

    private T[] theArray;

    private static final int MIN_CAPACITY = 100;


    public MyQueue_AL() {
        currentSize = 0;
        front = 0;
        back = 0;
        theArray = (T[]) new Object[MIN_CAPACITY];
    }


    public void enqueue(T data) {

        if (theArray.length == currentSize)

            ensureCapacity(size() * 2 + 1);

        theArray[back] = data;
		back++;

        currentSize++;

    }

    public T dequeue() {

        if (theArray.length == 0) throw new IndexOutOfBoundsException("Queue is empty");

        T lastData = theArray[front];

        front++;

        currentSize--;

        return lastData;

    }

    public int size() {

        return this.currentSize;

    }

    public void ensureCapacity(int newCap) {

        if (newCap < currentSize) return;

        T[] old = theArray;

        theArray = (T[]) new Object[newCap];

		if (currentSize >= 0) System.arraycopy(old, 0, theArray, 0, currentSize);

    }

	@Override
	public String toString(){
		StringBuilder toString = new StringBuilder("[");
		int flag=0;
		for(int i=front;i<back;i++){
			if(flag==1) toString.append(",");
			toString.append(theArray[i]);
			flag=1;
		}
		toString.append("]");
		return toString.toString();
	}


}
