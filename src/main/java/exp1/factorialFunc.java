package exp1;

public class factorialFunc {
    public static long fact_iterator(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res*=i;
        }
        return res;
    }

    public static long fact_recursion(int n){
        if (n==1){
            return 1;
        }
        else{
            return n*fact_recursion(n-1);
        }
    }
}
