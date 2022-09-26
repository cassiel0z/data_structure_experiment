package exp3;

public class problem1 {
    public static void main(String[] args) {
        MyStack<Integer> s1=new MyStack<>();
        for(int i=0;i<10;i++){
            s1.push(i);
        }
        System.out.println(s1);
        s1.pop();
        System.out.println(s1);
        System.out.println(s1.empty());
        System.out.println(s1.search(8));
        System.out.println(s1.getSize());
    }
}
