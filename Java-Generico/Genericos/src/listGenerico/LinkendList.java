package listGenerico;

public class LinkendList<T> {

    private Node<T> head;

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }else{
            Node<T> current = head;
            while (current.next != null) { 
                current = current.next;
            }
            current.next=newNode;
        }
    }

    public void printlist(){
        Node<T> current = head;
        while (current != null) {
            System.out.println("Elemento: "+current.data);            
            current =  current.next;
        }
    }


    public void update(T oldData, T newData){
        Node<T> current = head;
        while (current != null) {
            if(current.data.equals(oldData)){
                current.data = newData;
                return;
            }
            current =  current.next;
        }
    }

    public void delete(T data){
        if(head == null){
            return;
        }

        if(head.data.equals(data)){
            head = head.next;
            return;
        }

        Node<T> current = head.next;
        Node<T> previous = head;

        while (current != null && !current.data.equals(data)) { 
            previous = current;
            current = current.next;
        }
        if(current == null){
            return;
        }

        previous.next = current.next;

    }


}
