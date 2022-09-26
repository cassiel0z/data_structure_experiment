package exp1;

public class sumFunc {
    public static int sum_iterator(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static int sum_recursion(int n){

        if(n==1){
            return 1;
        }
        else {
            return n + sum_recursion(n - 1);
        }
    }

}
