package exp1;

public class Main {
    public static void main(String[] args) {

        System.out.println("第一题");

        double currTime = System.nanoTime();
        System.out.println(sumFunc.sum_iterator(1000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(sumFunc.sum_iterator(10000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(sumFunc.sum_iterator(100000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(sumFunc.sum_recursion(1000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(sumFunc.sum_recursion(10000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

//        System.out.println(sumFunc.sum_recursion(100000));
//        System.out.println(sumFunc.sum_recursion(1000000));


        System.out.println("第二题");

        currTime = System.nanoTime();
        System.out.println(factorialFunc.fact_iterator(5));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(factorialFunc.fact_iterator(10));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(factorialFunc.fact_iterator(15));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(factorialFunc.fact_recursion(5));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();


        currTime = System.nanoTime();
        System.out.println(factorialFunc.fact_recursion(10));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();


        currTime = System.nanoTime();
        System.out.println(factorialFunc.fact_recursion(16));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();



        System.out.println("第三题");

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_iterator(1000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_iterator(10000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_iterator(100000));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_recursion(5));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_recursion(10));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_recursion(15));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();

        currTime = System.nanoTime();
        System.out.println(fibFunc.fib_recursion(40));
        System.out.println((System.nanoTime() - currTime)+"ns");

        System.out.println();



        System.out.println("第四题 a)");

        currTime = System.nanoTime();
        int[] arr1= randomArray.summonArray_a(10);
        System.out.println((System.nanoTime() - currTime)+"ns");
        for (int j : arr1) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("第四题 b)");

        currTime = System.nanoTime();
        int[] arr2= randomArray.summonArray_b(10);
        System.out.println((System.nanoTime() - currTime)+"ns");
        for (int j : arr2) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("第四题 c)");

        currTime = System.nanoTime();
        int[] arr3= randomArray.summonArray_c(15);
        System.out.println((System.nanoTime() - currTime)+"ns");
        for (int j : arr3) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("第四题 d)");

        System.out.println("average_a");

        int average=0;
        System.out.print("N==1000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_a(1000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ns ");

        System.out.println();

        average=0;
        System.out.print("N==5000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_a(5000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ns ");

        System.out.println();

        average=0;
        System.out.print("N==10000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_a(10000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ns ");

        System.out.println();

        System.out.println("average_b");


        average=0;
        System.out.print("N==1000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_b(1000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ns ");

        System.out.println();

        average=0;
        System.out.print("N==5000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_b(5000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ns ");

        System.out.println();

        average=0;
        System.out.print("N==10000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_b(10000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ns ");

        System.out.println();


        System.out.println("average_c");

        average=0;
        System.out.print("N==1000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_b(1000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ms ");

        System.out.println();

        average=0;
        System.out.print("N==5000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_b(5000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ms ");

        System.out.println();

        average=0;
        System.out.print("N==10000:");
        for (int i=0;i<10;i++){
            currTime = System.nanoTime();
            randomArray.summonArray_b(10000);
            average+=System.nanoTime() - currTime;
        }
        average/=10;
        System.out.print(average+"ms ");

        System.out.println();



    }



}
