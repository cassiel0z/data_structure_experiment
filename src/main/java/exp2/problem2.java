package exp2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {

        LinkedList<Integer> l1= new LinkedList<>();
        LinkedList<Integer> l2= new LinkedList<>();

        ArrayList<Integer> a1 =new ArrayList<>();
        ArrayList<Integer> a2 =new ArrayList<>();

        for (int i=0;i<10;i++){
            l1.add(i+2);
            l2.add(i+3);
            a1.add(i+2);
            a2.add(i+3);
        }

        System.out.println("LinkedList Implements");
        double time=System.nanoTime();
        MyRetainAll1(l1,l2);
        System.out.println(System.nanoTime()-time);

        time=System.nanoTime();
        l1.retainAll(l2);
        System.out.println(System.nanoTime()-time);

        System.out.println("ArrayList Implements");

        time=System.nanoTime();
        MyRetainAll2(a1,a2);
        System.out.println(System.nanoTime()-time);

        time=System.nanoTime();
        a1.retainAll(a2);
        System.out.println(System.nanoTime()-time);

    }

    public static void MyRetainAll1(LinkedList<Integer> l1,LinkedList<Integer> l2){
        LinkedList<Integer> l3= new LinkedList<>();




        for (int i=0;i<l1.size();i++){
            for (int j=0;j<l2.size();j++){
                if(Objects.equals(l1.get(i), l2.get(j))){
                    l3.add(l1.get(i));
                    break;
                }
            }
        }
    }
    public static void MyRetainAll2(ArrayList<Integer> a1,ArrayList<Integer> a2){
        ArrayList<Integer> a3 =new ArrayList<>();


        for (int i=0;i<a1.size();i++){
            for (int j=0;j<a2.size();j++){
                if(Objects.equals(a1.get(i), a2.get(j))){
                    a3.add(a1.get(i));
                    break;
                }
            }
        }
    }

}
