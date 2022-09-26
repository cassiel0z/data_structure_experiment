package exp1;
import java.util.*;

public class randomArray {
    public static int[] summonArray_a(int n){
        Random ran = new Random();
        int[] a=new int[n];
        int k=0;
        do {
            a[k]=ran.nextInt(n);
            for (int m=0;m<k;m++){
                if(a[k]==a[m]){
                    k--;
                    break;
                }
            }
            k++;
        }while (k<n);
        return a;
    }

    public static int[] summonArray_b(int n){
        Random ran = new Random();
        int[] a=new int[n];
        boolean[] used=new boolean[n];
        int k=0;
        for(boolean x:used)
            x=false;
        do {
            a[k]=ran.nextInt(n);
            if(!used[a[k]]){
                used[a[k]]=true;
                k++;
            }
        }while(k<n);

        return a;
    }

    public static int[] summonArray_c(int n){
        Random ran = new Random();
        int[] a=new int[n];
        int k=0;
        for(int index=0;index<a.length;index++){
            a[index]=index+1;
        }
        for(int index=1;index<n;index++){
            int rand=ran.nextInt(index);
            int temp=a[index];
            a[index]=a[rand];
            a[rand]=temp;
        }
        return a;
    }

    private static int randInt(int i, int j){
        return (int)(Math.floor(Math.random()*(j-i)+i));
    }
}
