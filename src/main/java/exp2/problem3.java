package exp2;

import java.sql.Array;
import java.util.*;

public class problem3 {
    public static void main(String[] args) {
        System.out.println("LinkedList Implements");
        LinkedList<Integer> l1= new LinkedList<>();
        LinkedList<Integer> l2= new LinkedList<>();
        LinkedList<Integer> l3,l4;
        for(int i=0;i<10;i++) {
            l1.add(i + 4);
            l2.add(i);
        }

        double time=System.nanoTime();
        l3=MyRemoveAll1(l1,l2);
        MyAddAll1(l3,l2);
        System.out.println(System.nanoTime()-time);

        time=System.nanoTime();
        l1.removeAll(l2);
        l1.addAll(l2);
        System.out.println(System.nanoTime()-time);


        ArrayList<Integer> a1= new ArrayList<>();
        ArrayList<Integer> a2= new ArrayList<>();
        ArrayList<Integer> a3;
        for(int i=0;i<10;i++){
            a1.add(i+4);
            a2.add(i);
        }

        time=System.nanoTime();
        a3=MyRemoveAll2(a1,a2);
        MyAddAll2(a3,a2);
        System.out.println(System.nanoTime()-time);

        time=System.nanoTime();
        a1.removeAll(a2);
        a1.addAll(a2);
        System.out.println(System.nanoTime()-time);



    }

    public static LinkedList<Integer> MyRemoveAll1(LinkedList<Integer> a, LinkedList<Integer> b){
        Iterator<Integer> it1=a.iterator();
        Iterator<Integer> it2=b.iterator();
        int x1;
        int x2;
        x1=it1.next();
        x2=it2.next();
        while(it1.hasNext()&& it2.hasNext()){
            if(x1==x2){
                x1=it1.next();
                x2=it2.next();
                it1.remove();
            }
            else if (x1<x2)
                x1=it1.next();
            else
                x2=it2.next();
        }
        return a;
    }
    public static LinkedList<Integer> MyAddAll1(LinkedList<Integer> a,LinkedList<Integer> b){
        Iterator<Integer> it1=a.iterator();
        Iterator<Integer> it2=b.iterator();
        LinkedList<Integer> l1= new LinkedList<>();
        int x1;
        int x2;
        x1=it1.next();
        x2=it2.next();
        while(it1.hasNext() && it2.hasNext()){
            if(x1==x2){
                x1=it1.next();
                x2=it2.next();

                l1.add(x1);
                l1.add(x2);
            }
            else if (x1<x2){

                l1.add(x1);
                x1=it1.next();

            }
            else{

                l1.add(x2);
                x2=it2.next();

            }

        }
        int flag2=0,flag3=0;
        while (it1.hasNext()){
            x1=it1.next();
            l1.add(x1);
        }
        while (it2.hasNext()){
            x2=it2.next();
            l1.add(x2);
        }
        return l1;
    }
    public static ArrayList<Integer> MyRemoveAll2(ArrayList<Integer> a, ArrayList<Integer> b){
        Iterator<Integer> it1=a.iterator();
        Iterator<Integer> it2=b.iterator();
        int x1;
        int x2;
        x1=it1.next();
        x2=it2.next();
        while(it1.hasNext()&& it2.hasNext()){
            if(x1==x2){
                x1=it1.next();
                x2=it2.next();

                it1.remove();
            }
            else if (x1<x2)
                x1=it1.next();
            else
                x2=it2.next();
        }
        return a;
    }

    public static ArrayList<Integer> MyAddAll2(ArrayList<Integer> a,ArrayList<Integer> b){
        Iterator<Integer> it1=a.iterator();
        Iterator<Integer> it2=b.iterator();
        ArrayList<Integer> l1= new ArrayList<>();
        int x1;
        int x2;
        x1=it1.next();
        x2=it2.next();
        while(it1.hasNext() && it2.hasNext()){
            if(x1==x2){
                x1=it1.next();
                x2=it2.next();
                l1.add(x1);
                l1.add(x2);
            }
            else if (x1<x2){
                l1.add(x1);
                x1=it1.next();
            }
            else{
                l1.add(x2);
                x2=it2.next();
            }

        }
        while (it1.hasNext()){
            x1=it1.next();
            l1.add(x1);
        }
        while (it2.hasNext()){
            x2=it2.next();
            l1.add(x2);
        }
        return l1;
    }
}