package org.franco.proyecto.postgress;

import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.time.LocalDate;

@RequiredArgsConstructor
public class PersonDAO {

    private final Connection connection;

    public void save(Person person){
        String sql = "INSERT INTO person (name, birth_date)"+
                "VALUES (?, ?)";
        try (

                PreparedStatement statement = connection.prepareStatement(sql)
        ){

            statement.setString(1, person.getName());
            statement.setDate(2, Date.valueOf(person.getBirthDate()));

            int rows = statement.executeUpdate();
            showMessage(rows, "La persona fue ingresada correctamente...", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Person findById(int id) throws SQLException {
        String sql ="SELECT * FROM person WHERE id = ?";
        try(PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                String name = rs.getString("name");
                LocalDate birthDate = rs.getDate("birth_date").toLocalDate();

                return new Person(id, name, birthDate);
            }else{
                System.out.println("No se encontro persona con ID: "+ id);
                return null;
            }
        }
    }

    private void showMessage(int rows, String messageOk, String messageError){
        if(rows > 0) {
            System.out.println(messageOk);
        }else if (messageError.isBlank()){
            System.out.println(messageError);
        }
    }
}
