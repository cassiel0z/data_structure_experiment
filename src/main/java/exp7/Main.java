package exp7;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r=new Random();
        Student[] s1=new Student[100];
        for(int i=0;i<100;i++){
            s1[i]=new Student(r.nextInt(100),String.valueOf(i));
        }
        for(int i=0;i<100;i++){
            System.out.print(s1[i].averageScore+" ");
        }

        System.out.println();

        Student[] s2=Student.BucketSort(s1);
        for(int i=0;i<100;i++){
            System.out.print(s2[i].averageScore+" ");
        }
    }

}

