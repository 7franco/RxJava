package alturaGenericos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class MundoGenerico {

    private List<Pais> paises;

    private MundoGenerico(List<Pais> paises){
        this.paises = paises;
    }

    public static  MundoGenerico createFromFile(String file) throws FileNotFoundException{
        List<Pais> paisesFichero = new LinkedList<>();
        Pais paisTmp;
        String linea;
        String[] datosPais;
        System.out.println(file);
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            try{
                datosPais =linea.split(",");
                paisTmp = new Pais(datosPais[0].toString(), datosPais[1].toString(), Double.parseDouble(datosPais[2]));
                paisesFichero.add(paisTmp);
            }catch(Exception e){
                System.out.println("Linea incorrecta: "+linea);
                System.err.println(e);
            }
        }
        return new MundoGenerico(paisesFichero);
    }

    /**
     * Recibe una correspondencia y la muestra por pantalla 
     * con el formato clave , valor
     * @param <K> clase de la clave
     * @param <V> clase del valor
     * @param map correspondencia
     */
    public static <K, V> void presentarEnConsola(Map<K,V> map){
        Iterator<K> it = map.keySet().iterator();
        K elem;
        while (it.hasNext()) {
            elem = it.next();
            // System.out.println(elem);
            System.out.println(elem+" \t"+ map.get(elem));
        }
    }

    public SortedMap<String, Integer> numeroDePaisesPorContinente(){
        SortedMap<String, Integer> paisesPorContinente = new TreeMap<>();
        Iterator<Pais> it = paises.iterator();
        Pais pais;
        Integer valor;
        while (it.hasNext()) {
            pais = it.next();
            //valor tendra el numero de paises para saber el continente 
            //o valdra null si el continente no esta
            valor=paisesPorContinente.get(pais.getContinente());
            if(valor == null){
                paisesPorContinente.put(pais.getContinente(), 1);
            }else{
                valor++;
                paisesPorContinente.put(pais.getContinente(), valor);
            }
        }
        return paisesPorContinente;
    } 

    public SortedMap <String, List<Pais>> paisesPorContinente(){
        SortedMap<String, List<Pais>> paisesPorContinente = new TreeMap<>();
        Iterator<Pais> it = paises.iterator();
        Pais pais;
        List<Pais> listaPaises;
        String continente;

        while (it.hasNext()) {
            pais = it.next();
            continente = pais.getContinente();
            listaPaises = paisesPorContinente.get(continente);
            if (listaPaises == null) {
                System.err.println("Cuantas veces ingresa: "+ continente);
                listaPaises = new LinkedList<Pais>();
                paisesPorContinente.put(continente, listaPaises);
            }
            listaPaises.add(pais);

        }

        return paisesPorContinente;
    }

    @Override
    public String toString() {
        return "Mundo [paises=" + paises + "]";
    }

    

}
