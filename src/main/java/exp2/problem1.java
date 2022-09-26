package exp2;

public class problem1 {
    public static void main(String[] args) {
        System.out.println("LinkedList Implements");
        MyLinkedList<Integer> l= new MyLinkedList<>();
        MyLinkedList<Integer> p1= new MyLinkedList<>();
        for (int i=0;i<10;i++){
            l.add(i+2);
            p1.add(i+3);

        }

        double time=System.nanoTime();
        printLots1(l,p1);
        System.out.println(System.nanoTime()-time);

        System.out.println("ArrayList Implements");
        MyArrayList<Integer> a= new MyArrayList<>();
        MyArrayList<Integer> p2= new MyArrayList<>();

        for (int i=0;i<10;i++){
            a.add(i+2);
            p2.add(i+3);
        }

        time=System.nanoTime();
        printLots2(a,p2);
        System.out.println(System.nanoTime()-time);


    }
    public static void printLots1(MyLinkedList<Integer> a,MyLinkedList<Integer> b){
        for(int i=0;i<a.size();i++){
            int c=b.get(i);
        }
    }
    public static void printLots2(MyArrayList<Integer> a,MyArrayList<Integer> b){
        for(int i=0;i<a.size();i++){
            int c=b.get(i);
        }
    }
}