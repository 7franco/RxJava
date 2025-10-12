package org.franco.proyecto.ternaryOperator;

public class teranryOperatorExample {

    static void main(String[] args) {
        int age = 33;
        String message;
        if(age >= 18){
            message = "Mayor de edad!";
        }else {
            message = "Menor de edad!";
        }
//        System.out.println(message);

        //condicion ? expresion_si_verdadero : expresion_si_falso.
        message = age >= 18 ? "Mayor de edad":"Menor de edad";
        System.out.println(message);

        int score = 91;
        String level;

        level = score >= 90 ? "Excelente" : score>=70 ? "Bueno" : "Regular";
        System.out.println(level);

        //Ejercicio 3
        int accessLevel =3;
        String accessMessage = "Acceso denegago";

        accessMessage = accessLevel>=1 ? (accessLevel>=3 ?"Acceso Total.":"Acceso parcial."):"Acceso denegago";
        System.out.println(accessMessage);

    }
}
