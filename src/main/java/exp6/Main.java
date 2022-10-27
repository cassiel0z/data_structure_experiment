package exp6;

import exp5.QuadraticProbingHashTable;
import exp5.SeparateChainingHashTable;
import exp4.AVLTree;
import exp4.BinarySearchTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] randomArray =new int[n];

        ArrayList<Integer> lst = new ArrayList<>();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AVLTree<Integer> avlt = new AVLTree<>();
        SeparateChainingHashTable<Integer> scht = new SeparateChainingHashTable<>();
        QuadraticProbingHashTable<Integer> qpht = new QuadraticProbingHashTable<>();

        for (int i = 0; i < n; i++) {
            int random = (int) Math.floor(Math.random() * n);//随机生成一个[0,n)的数
            randomArray[i]=random;//记录random值

            lst.add(random);
            bst.insert(random);
            avlt.insert(random);
            scht.insert(random);
            qpht.insert(random);
        }



        System.out.println("Sequential search");
        double time=0;
        for (int i=0;i<100;i++){//循环100次后取平均值
            int search = (int) Math.floor(Math.random() * n);//随机生成一个要查找的下标
            double currTime = System.nanoTime();
            for (int j=0;j<n;j++){//在列表中查找randomArray中下标为search的数
                if(lst.get(j)==randomArray[search])
                    break;
            }
            time+=System.nanoTime() - currTime;
        }
        time/=100;
        System.out.println("Average time is "+time+"ns");
        System.out.println();



        System.out.println("Binary search");
        time=0;
        for (int i=0;i<100;i++){//循环100次后取平均值
            int search = (int) Math.floor(Math.random() * n);//随机生成一个要查找的下标
            double currTime = System.nanoTime();
            bst.contains(randomArray[search]);//在列表中查找randomArray中下标为search的数
            time+=System.nanoTime() - currTime;
        }
        time/=100;
        System.out.println("Average time is "+time+"ns");
        System.out.println();



        System.out.println("AVL Tree search");
        time=0;
        for (int i=0;i<100;i++){//循环100次后取平均值
            int search = (int) Math.floor(Math.random() * n);//随机生成一个要查找的下标
            double currTime = System.nanoTime();
            avlt.contains(randomArray[search]);//在列表中查找randomArray中下标为search的数
            time+=System.nanoTime() - currTime;
        }
        time/=100;
        System.out.println("Average time is "+time+"ns");
        System.out.println();



        System.out.println("Separate chaining hash tables search");
        time=0;
        for (int i=0;i<100;i++){//循环100次后取平均值
            int search = (int) Math.floor(Math.random() * n);//随机生成一个要查找的下标
            double currTime = System.nanoTime();
            scht.contains(randomArray[search]);//在列表中查找randomArray中下标为search的数
            time+=System.nanoTime() - currTime;
        }
        time/=100;
        System.out.println("Average time is "+time+"ns");
        System.out.println();



        System.out.println("Open addressing hash tables search");
        time=0;
        for (int i=0;i<100;i++){//循环100次后取平均值
            int search = (int) Math.floor(Math.random() * n);//随机生成一个要查找的下标
            double currTime = System.nanoTime();
            qpht.contains(randomArray[search]);//在列表中查找randomArray中下标为search的数
            time+=System.nanoTime() - currTime;
        }
        time/=100;
        System.out.println("Average time is "+time+"ns");
        System.out.println();
    }
}
