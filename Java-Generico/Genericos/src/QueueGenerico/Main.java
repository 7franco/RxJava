package QueueGenerico;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> numbers = new Queue<>();
        numbers.enqueue(10);
        numbers.enqueue(20);
        numbers.enqueue(30);
        numbers.enqueue(40);
        numbers.print();

        System.out.println("El primero de la fila "+ numbers.peek());

        System.out.println("Elimina el primero de la fila " + numbers.dequeue());

        numbers.print();

        Queue<String> names = new Queue<>();
        names.enqueue("Margaret");
        names.enqueue("Paola");
        names.enqueue("Jonathan");
        names.enqueue("Fran");

        names.print();
    }
}
