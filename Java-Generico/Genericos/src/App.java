
import java.util.ArrayList;
import java.util.List;



public class App {
    public static void main(String[] args) throws Exception {
        // Object number = Integer.valueOf(10);
        // number = "Hola";

        // var name = "Franco";
        // System.out.println(name);


        // ArrayList<String> list = new ArrayList<>();
        // list.add("Franco");
        // list.add("Jonathan");
        // for(String o : list){
        //     System.out.println(o.toUpperCase());
        // }

        // Box<String> stringBox = new Box<String>("Franco");
        // System.out.println(stringBox);
        
        Utility.printItem("Jonathan", 2);
        Utility.printItem(10);

        Double response = MathUtils.sum(2, 5);
        System.out.println(response);

        List<String> names = new ArrayList<>();
        names.add("Franco");
        names.add("Jonatha");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        printList(names);
        printList(numbers);

        sumNumber(numbers);
        
        addNumber(numbers);
    }

    public static void printList(List<?> list){
        for(Object o: list){
            System.out.println(o);
        }

    }

    public static void sumNumber(List<? extends  Number> numbers){
        double sum =0;
        for (Number num: numbers){
            sum += num.doubleValue();
        }
        System.out.println(sum);
    }

    public static void addNumber(List<? super Integer> numbers){
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Object num = numbers.get(0);
    
        System.out.println(num);
    }
}
