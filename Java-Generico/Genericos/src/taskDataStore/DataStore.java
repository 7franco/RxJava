package taskDataStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataStore<T, K> {
    
    private final List<T> lists ;
    private final Map<K, T> maps;    
    
    public DataStore() {
        lists= new ArrayList<>();
         maps = new HashMap<>();
    }

    public void add(K key, T item){
        Objects.requireNonNull(key, "La clave no puede ser nula");
        Objects.requireNonNull(key, "El item no puede ser nula");
        if(!maps.containsKey(key)){
            lists.add(item);
            maps.put(key, item);
        }
    }

    public T remove(K key){
        Objects.requireNonNull(key, "La clave no puede ser nula");
        T item = maps.remove(key);  // elimina y devuelve el valor asociado
        if(item != null){
            lists.remove(item);   
        }
        return item;
    }

    public T find(K key){
        Objects.requireNonNull(key, "La clave no puede ser nula");
        return maps.get(key);
    }

    public List<T> getAll(){
        return Collections.unmodifiableList(lists);
    }

    public boolean isEnpty(){
        return lists.isEmpty();
    }

    public void print(){
        lists.forEach(System.out::println);
        maps.forEach((k,T)->{
            System.out.println("Key: "+k+" Value: "+T);
        });
    }
}
