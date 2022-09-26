package exp3;

public class MyQueue_LL<T> {
    private Node<T> front;
    private Node<T> back;
    private int currentSize;

    public MyQueue_LL(){
        front=null;
        back=null;
        currentSize=0;
    }

    public void enqueue(T data){
        Node<T> node=new Node<>(data);
        if(back==null){
            front=node;
        }
        else {
            node.prev=back;
            back.next=node;
        }
        back=node;
        currentSize++;
    }

    public T dequeue(){
        T temp=front.data;
        front=front.next;
        if(front==null)
            back=null;
        else
            front.prev=null;
        currentSize--;
        return temp;
    }

    public T peek(){
        return front.data;
    }

    public int size(){
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[");
        Node<T> node=front;
        int flag=0;
        while(node!=null){
            if(flag==1) toString.append(",");
            toString.append(node.data);
            flag=1;
            node=node.next;
        }
        toString.append("]");
        return toString.toString();
    }

    static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;
        public Node(T data){
            this.data=data;
            next=null;
            prev=null;
        }

    }
}
