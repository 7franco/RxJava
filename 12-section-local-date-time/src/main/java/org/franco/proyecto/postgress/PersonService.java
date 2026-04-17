package org.franco.proyecto.postgress;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonService {

    public void savePerson(Person person) throws SQLException{
        Connection connection=null;
        try{
            connection = ConnetionPool.getConnection();

            connection.setAutoCommit(false);

            PersonDAO personDAO = new PersonDAO((Connection) connection);
            personDAO.save(person);

            connection.commit();



        } catch (SQLException e) {
            if(connection != null){
                connection.rollback();

            }
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if (connection!=null){
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Tuvimos un problema en la coneccion...");
                }
            }
        }
    }

    public Person findPersonById(int id) throws SQLException {
        try(Connection connection = ConnetionPool.getConnection()){
            PersonDAO personDAO = new PersonDAO((Connection) connection);
            return personDAO.findById(id);
        }
    }


}
