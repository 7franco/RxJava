package QueueGenerico;

import java.util.LinkedList;
import java.util.NoSuchElementException;


public class Queue<T> {

    private final LinkedList<T>  elements = new LinkedList<>();

    public void enqueue(T element){
        elements.addLast(element);
        System.out.println("Elemento agregado "+ element);
    }

    public T peek(){
        if(isEnpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        return elements.getFirst();
    }

    public T dequeue(){
        if(isEnpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        return elements.removeFirst();
    }

    public boolean isEnpty(){
        return elements.isEmpty();
    }

    public void print(){
        for (Object elem : elements) {
            System.out.println(elem);
        }
    }
}
