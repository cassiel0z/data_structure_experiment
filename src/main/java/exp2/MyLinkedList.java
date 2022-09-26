package exp2;

public class MyLinkedList<T>{
    public Node<T> first;
    public Node<T> last;
    private int size=0;

    public MyLinkedList(){
    }


    /*
        返回LinkedList的大小
        @return size list大小
     */
    public int size(){
        return size;
    }

    /*
        往链表最后添加新的数据
        @param data 要添加的数据
     */
    public void add(T data){
        Node<T> newLast= new Node<>(data, null, last);
        if(last==null){
            first=newLast;
        }
        else{
            last.next=newLast;
        }
        last=newLast;
        size++;
    }

    /*
        在指定index位置插入数据
        @param index 插入位置索引 data 要插入的数据
     */
    public void add(int index,T data){
        Node<T> newNode=new Node<>(data,null,null);
        Node<T> node=first;
        if(checkRange(index)){
            if(index==0&&size==0){
                add(data);
            }
            else{
                for(int i=0;i<index;i++){
                    node=node.next;
                }
                newNode.next=node;
                newNode.prev=node.prev;
                node.prev.next=newNode;
                node.prev=newNode;
                size++;
            }
        }
        else throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);

    }

    /*
        删除指定index的数据
        @param index 要删除的位置
     */
    public void remove(int index){
        Node<T> node=first;
        if(checkRange(index)){
            for(int i=0;i<index;i++){
                node=node.next;
            }
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        else throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);

    }

    /*
    获取指定index位置的数据
    @param index 索引位置
    @return data 该位置的数据
     */
    public T get(int index){
        Node<T> node=first;
        if(checkRange(index)){
            for(int i=0;i<index;i++){
                node=node.next;
            }
            return node.data;
        }
        throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);
    }

    /*
        用来反转链表
     */

    public void reverse() {
        Node<T> previous = null;
        Node<T> next = null;
        Node<T> current=first;
        while (current != null) {
            //存储下一节点
            next = current.next;
            current.next = previous;		//反转

            //更新遍历节点
            previous = current;
            current = next;
        }
        first=previous;
    }


    /*
        检查index是否超出范围
        @param index 要检查的索引
        @return boolean 是否超出
     */
    public boolean checkRange(int index){
        return index<=size-1&&index>=0;
    }




    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
