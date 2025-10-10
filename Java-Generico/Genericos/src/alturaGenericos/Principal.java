package alturaGenericos;

import java.util.ArrayList;
import java.util.List;

public class Principal {


    public static void main(String[] args) throws Exception {
        

        Pais pais = new Pais("Ecuador", "America", 1.7);
        System.out.println(pais);

        try {
            // Mundo mundo = Mundo.createFromFile("src/alturas.txt");
            MundoGenerico mundo = MundoGenerico.createFromFile("C:\\Users\\Usuario\\Desktop\\CURSOS\\RxJava\\Genericos\\src\\alturas.txt");
            System.out.println(mundo);
            MundoGenerico.presentarEnConsola(mundo.numeroDePaisesPorContinente());
            MundoGenerico.presentarEnConsola(mundo.paisesPorContinente());

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
