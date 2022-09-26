package exp2;


public class MyArrayList<T> {
    private int size=0,
            capacity=10;
    private T[] data;

    public MyArrayList(int capacity){
        if(capacity<=0)
            capacity=this.capacity;
        data=(T[])new Object[capacity];
    }

    public MyArrayList(){
        this(10);
    }

    /*
        返回ArrayList的大小
        @return size list大小
     */
    public int size(){
        return size;
    }

    /*
        往数组最后添加数据
        @param e 要添加的数据
     */
    public void add(T e){
        if(size+1>=capacity){
            resize(2*capacity);
        }
        data[size]=e;
        size++;
    }

    /*
        往数组指定位置添加数据
        @param index 位置索引 e 要添加的数据
     */
    public void add(int index,T e){
        if(checkRange(index)){
            if(size+1>=capacity){
                resize(2*capacity);
            }
            for(int i=size;i>index;i--){
                data[i]=data[i-1];
            }
            data[index]=e;
            size++;
        }
        else throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);

    }

    /*
    获取指定index位置的数据
    @param index 索引位置
    @return data 该位置的数据
 */
    public T get(int index){
        if(checkRange(index)){
            return data[index];
        }
        throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);
    }

    /*
        删除指定index的数据
        @param index 要删除的位置
     */
    public void remove(int index){
        if(checkRange(index)){
            for(int i=index;i<size-1;i++){
                data[i]=data[i+1];
            }
            size--;
            if (size<capacity/2&&capacity>10){
                dlResize(capacity/2);
            }
        }
        else throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);
    }


    /*
        数组扩容
        @param capacity 要设置的大小
     */
    public void resize(int capacity){
        T[] newData=(T[])new Object[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data=newData;
        this.capacity=capacity;
    }

    /*
        数组缩容
        @param capacity 要设置的大小
     */
    public void dlResize(int capacity){
        T[] newData=(T[])new Object[capacity];
        System.arraycopy(data, 0, newData, 0, newData.length);
        data=newData;
        this.capacity=capacity;
    }

    /*
        检查index是否超出范围
        @param index 要检查的索引
        @return boolean 是否超出
    */
    public boolean checkRange(int index){
        return index<=size-1&&index>=0;
    }

}
