package exp5;

import java.util.Arrays;

public class QuadraticProbingHashTable<AnyType> {
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty() {
        currentSize = 0;
        Arrays.fill(array, null);
    }

    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            return;

        array[currentPos] = new HashEntry<>(x, true);//插入数据后标记当前地址的元素为isActive=True，即存在数据
        currentSize++;
        if (currentSize > array.length / 2)//当负载因子达到0.5时进行再散列
            rehash();
    }

    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)){
            array[currentPos].isActive = false;
            currentSize--;
        }

    }

    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType e) {
            this(e, true);
        }

        public HashEntry(AnyType e, boolean i) {
            element = e;
            isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 11;//默认表长度

    private HashEntry<AnyType>[] array;
    private int currentSize;

    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(AnyType x) {
        /*
            寻找数据插入的最终位置
            @param x 待插入的数据
         */
        int offset = 1;
        int i=0;
        int currentPos = myhash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            i++;
            offset+=2*i-1;//每次冲突向后推的长度为f(i-1)+2*i-1
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private void rehash() {
        /*
         再散列列表
         */
        HashEntry<AnyType>[] oldArray = array;

        allocateArray(nextPrime(2 * oldArray.length));//新列表长度为2倍原长度之后的第一个质数
        currentSize = 0;

        for (HashEntry<AnyType> anyTypeHashEntry : oldArray)
            if (anyTypeHashEntry != null && anyTypeHashEntry.isActive)
                insert(anyTypeHashEntry.element);
    }

    private int myhash(AnyType x) {
         /*
            散列函数：插入下标为输入值的哈希值mod列表长度
            @param x 插入的数据
         */
        int hashVal = x.hashCode();
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
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
