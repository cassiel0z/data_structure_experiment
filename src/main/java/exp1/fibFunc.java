package exp1;

public class fibFunc {
    public static int fib_iterator(int n){
        int[] fib=new int[n+1];
        fib[1]=1;
        fib[2]=1;
        for(int i=3;i<=n;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    public static int fib_recursion(int n){
        if(n==1 || n==2){
            return 1;
        }
        else{
            return fib_recursion(n-1)+fib_recursion(n-2);
        }
    }
}
