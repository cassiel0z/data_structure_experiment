package exp2;


public class problem6 {
    public static void main(String[] args) {
        MyLinkedList<Integer> l= new MyLinkedList<>();
        for(int i=0;i<10;i++){
            l.add(i);
        }

        double time=System.nanoTime();
        l.reverse();
        System.out.println(System.nanoTime()-time);
    }


}



