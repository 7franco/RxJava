package factorialExercite;

public class Factorial {


    public static int factorial(int n){
        if(n==0)
            return 1;
        else  
            return n * factorial(n-1);
    }

    public static int fib(int n){
        if(n < 2)
            return n;
        else
            return fib(n-1) + fib(n-2); 
    }



    public static void main(String[] args){

        for (int i=0; i<30; i++) {
            System.out.println("El Fib("+i+") es: "+fib(i));
           
        }
        System.out.println( String.valueOf(factorial(10)));
    }
}
