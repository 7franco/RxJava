package org.franco.proyecto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Operation2 operation = new Operation2() {
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        };

        System.out.println(operation.operate(5,5));


        Operation multiply = (a,b) -> a*b;
        System.out.println(multiply.operate(4,5));

        Operation subtraction = (a,b) -> a-b;
        System.out.println(multiply.operate(14,5));

    }
}

/**
 * Se llama interfaz funcional
 */
@FunctionalInterface
interface Operation2{
    int operate(int a, int b);

    default String show(){
        return "Soy una operacion";
    }

    default String show2(){
        return "Soy una operacion";
    }

    static Operation subtraction(){
        return (a,b) -> a-b;
    }
}
