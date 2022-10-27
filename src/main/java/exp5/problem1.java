package exp5;

import java.util.LinkedList;
import exp4.AVLTree;
import java.util.List;

public class problem1 {
    public static void main(String[] args) {
        int[] array=new int[]{4371,1223,6173,4199,4344,9679,1989};
        SeparateChainingHashTable<Integer> scht=new SeparateChainingHashTable<>();
        LinearProbingHashTable<Integer> lpht=new LinearProbingHashTable<>();
        QuadraticProbingHashTable<Integer> qpht=new QuadraticProbingHashTable<>();
        DoubleHashTable<Integer> dht=new DoubleHashTable<>();
        AVLTree<Integer> avlTree=new AVLTree<>();
        List<Integer> list=new LinkedList<>();

        for(int x:array){
            scht.insert(x);
            lpht.insert(x);
            qpht.insert(x);
            dht.insert(x);
            avlTree.insert(x);
            list.add(x);

            System.out.println(scht.contains(x));
            System.out.println(lpht.contains(x));
            System.out.println(qpht.contains(x));
            System.out.println(dht.contains(x));
            System.out.println(avlTree.contains(x));
            System.out.println(list.contains(x));
        }


    }
}
