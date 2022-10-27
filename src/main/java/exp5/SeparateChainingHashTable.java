package exp5;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<AnyType> {

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++)//生成一个lists数组，每个元素为一个链表
            theLists[i] = new LinkedList<>();
    }

    public void insert(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);//若冲突则在列表中添加数据
            currentSize++;
            if(++currentSize>theLists.length)//当负载因子达到0.5时进行再散列
                rehash();
        }
    }

    public void remove(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(AnyType x) {
        LinkedList<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    public void makeEmpty() {
        for (LinkedList<AnyType> theList : theLists) theList.clear();
        currentSize = 0;
    }


    private static final int DEFAULT_TABLE_SIZE = 11;//默认表长度
    private LinkedList<AnyType>[] theLists;
    private int currentSize;

    private int myhash(AnyType x) {
         /*
            散列函数：插入下标为输入值的哈希值mod列表长度
            @param x 插入的数据
         */
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;
        return hashVal;
    }

    private void rehash(){
        /*
          再散列列表
        */
        LinkedList<AnyType> [] oldLists=theLists;

        theLists=new LinkedList[nextPrime(2*theLists.length)];//新列表长度为2倍原长度之后的第一个质数
        for(int j=0;j< theLists.length;j++)
            theLists[j] =new LinkedList<>();

        currentSize=0;
        for (List<AnyType> oldList : oldLists)
            for (AnyType item : oldList)
                insert(item);
    }

    private static int nextPrime(int n) {
        /*
            寻找大于n的第一个质数
            @param n 起始点
            @return i 大于n的第一个质数
         */
        for (int i = n + 1; ; i++)
            if (isPrime(i)) return i;
    }

    private static boolean isPrime(int n) {
        /*
            判断是否是质数
            @param n 输入一个数
            @return 返回是否是质数的布尔值
         */
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i < n / 2; i += 2)
            if (n % i == 0) return false;
        return true;
    }



}