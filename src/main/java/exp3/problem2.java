package exp3;

import java.util.LinkedList;
import java.util.Queue;

public class problem2 {
    public static void main(String[] args) {
        System.out.println("ArrayList实现");
        MyQueue_AL<Integer> al=new MyQueue_AL<>();
        for (int i=0;i<10;i++){
            al.enqueue(i);
        }
        System.out.println(al);
        System.out.println(al.size());
        System.out.println(al.dequeue());
        System.out.println(al.dequeue());
        System.out.println(al);

        System.out.println("LinkedList实现");
        MyQueue_LL<Integer> ll=new MyQueue_LL<>();
        for (int i=0;i<10;i++){
            ll.enqueue(i);
        }
        System.out.println(ll);
        System.out.println(ll.size());
        System.out.println(ll.dequeue());
        System.out.println(ll.dequeue());
        System.out.println(ll);

        System.out.println("Circular Array实现");
        MyQueue_CA<Integer> ca=new MyQueue_CA<>();
        for (int i=0;i<10;i++){
            ca.enqueue(i);
        }
        System.out.println(ca);
        System.out.println(ca.size());
        System.out.println(ca.dequeue());
        System.out.println(ca.dequeue());
        System.out.println(ca);

        System.out.println("Queue实现");
        Queue<Integer> q1 = new LinkedList<>() ;
        for (int i=0;i<10;i++){
            q1.add(i);
        }
        System.out.println(q1);
        System.out.println(q1.size());
        System.out.println(q1.remove());
        System.out.println(q1.remove());
        System.out.println(q1);

    }
}
