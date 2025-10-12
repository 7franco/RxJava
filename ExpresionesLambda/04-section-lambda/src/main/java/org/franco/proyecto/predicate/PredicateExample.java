package org.franco.proyecto.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    static void main() {
        Predicate<Integer> isEven = x -> x % 2 ==0;
        boolean result = isEven.test(6);
        System.out.println("Es pas?: "+ result);

        BiPredicate<String, Integer> chechLength = (str, len) -> str.length()==len;

        result = chechLength.test("hola", 4);

        System.out.println("Es igual?: "+ result);
    }
}
