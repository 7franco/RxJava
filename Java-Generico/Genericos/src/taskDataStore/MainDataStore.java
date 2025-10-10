package taskDataStore;

import java.util.List;

public class MainDataStore {

    public static void main(String[] args) {
        
        DataStore<User, String> dataStore = new DataStore<>();

        try {
            System.out.println("Add usuarios");
            dataStore.add("123", new User("123","Margaret"));
            dataStore.add("124", new User("124","Paola"));
            dataStore.add("125", new User("125","Franco"));

            System.out.println("Encontrado: "+ dataStore.find("123"));
            System.out.println("Eliminado: "+ dataStore.remove("124"));

        } catch (Exception e) {
            System.err.println(e);
        }

        List<User> users = dataStore.getAll();
        for (Object elem : users) {
            System.out.println(elem);
        }

    }
}
