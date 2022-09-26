package exp3;

public class MyStack<T> {
    public Node<T> last;
    public Node<T> first;
    private int size;

    public MyStack(){
        last=null;
        first=null;
        size=0;
    }

    public void push(T data){
        Node<T> node=new Node<>(data);
        if(last==null){
            first=node;
        }
        else {
            node.prev=last;
            last.next=node;
        }
        last=node;
        size++;
    }

    public T pop(){
        T temp=last.data;
        last=last.prev;
        if(last==null)
            first=null;
        else
            last.next=null;
        size--;
        return temp;
    }

    public T peek(){
        return last.data;
    }

    public int getSize(){
        return size;
    }

    public boolean empty(){
        return size==0;
    }

    public int search(T e){
        Node<T> node=first;
        int index=0;
        while(node!=null){
            if(node.data==e) return index;
            node=node.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[");
        Node<T> node=first;
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
