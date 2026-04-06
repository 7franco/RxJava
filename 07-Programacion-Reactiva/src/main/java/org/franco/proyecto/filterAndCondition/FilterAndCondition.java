package org.franco.proyecto.filterAndCondition;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {

    static void main(String[] args) {
        Observable<Integer> ager  = Observable.just(7,10,20,30,12,14,18,60,70);
//        FIlter
//        ager.filter(age -> age >=21).subscribe(System.out::println);

        //Distinct
//        ager.distinct().subscribe(System.out::println);

//        TAKE
//        ager.take(2).subscribe(System.out::println);

//        takeWhile
        ager.takeWhile(age -> age < 11).subscribe(System.out::println);

    }
}
