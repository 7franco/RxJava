package org.franco.proyecto;

public class Calculator {

    public void operateAndPrint(int a, int b, Operation op){
        int result = op.operate(a,b);
        System.out.println("Resultado: "+ result);
    }

    static void main() {
        Calculator calculator = new Calculator();
        calculator.operateAndPrint(5,5, (a,b)-> a+b);
        calculator.operateAndPrint(10,5, (a,b)-> a-b);
        calculator.operateAndPrint(5,5, (a,b)-> a*b);
        calculator.operateAndPrint(10,5, (a,b)-> a/b);
    }
}


@FunctionalInterface
interface Operation{
    int operate(int a, int b);
}