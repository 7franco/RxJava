package stackGenerico;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(200);

        Stack<String> names = new Stack<>();
        names.push("Margaret");
        names.push("Paola");
        names.push("Franco");
        names.push("Jonathan");

        integerStack.print();

        System.out.println("Elemento en la cima "+ integerStack.peek());

        System.out.println("Eliminar un elemento "+ integerStack.pop());

        integerStack.print();
    }
}
