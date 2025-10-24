package org.franco.proyecto;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BenchMark {

    static void main(String[] args) {

        Set<Integer> set = IntStream.range(1,70_000_000)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(set.size());

        long start  = System.currentTimeMillis();
        set.stream().map(n -> n*2);
        long end = System.currentTimeMillis();
        System.out.println("Stream: "+ (end -start)+" ms");

        start = System.currentTimeMillis();
        set.parallelStream().map(i -> i*i).count();
        end = System.currentTimeMillis();
        System.out.println("Parallel Stream: " + (end -start) + " ms");

    }
}
