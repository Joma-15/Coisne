package org.example;

import java.sql.*;

import com.mysql.cj.jdbc.ConnectionImpl;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Random;

public class Database {
    //for database connection
    Dotenv dotenv = Dotenv.load();
    String jdbcUrl = dotenv.get("JDBC_URL");
    String jdbcUserName = dotenv.get("JDBC_USERNAME");
    String jdbcPassword = dotenv.get("JDBC_PASSWORD");
    /*
    * Class to handle prisoner database logic
    *
    */
    public class PrisonerDatabaseHandler{
        //register the user to the database
        public void registerPrisoner(String firstName, String lastName,int age, char sex, int cellId){
            Prisoner prisoner = new Prisoner();
            String query = "INSERT INTO prisoner(?,?,?,?,?,?)";

            try(Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUserName,jdbcPassword);
                PreparedStatement statement = connection.prepareStatement((query))){

                int uniqueId = generateRandomId();
                prisoner.setPrisonerId(uniqueId);

                statement.setInt(1,prisoner.getPrisonerId());
                statement.setString(2,firstName);
                statement.setString(3,lastName);
                statement.setInt(4,age);
                statement.setString(5,Character.toString(sex).toUpperCase());
                statement.setInt(6,cellId);

                statement.executeUpdate();//put all the data to the database
            }catch (SQLException e){
                System.out.println("Database error: " + e.getMessage());
            }
        }

        //method to generate random 4 digits unique numbers for the prisoner id
        public static int generateRandomId(){
            Random random = new Random();
            boolean isUnique = false;
            String findQuery = "SELECT * FROM prisoner WHERE prisoner_id = ? ";
            int uniqueId = 0;

            try(Connection connection = new ConnectionImpl(findQuery);
                PreparedStatement findStatement = connection.prepareStatement(findQuery)){

                while (!isUnique){
                    uniqueId = random.nextInt(9000) + 1000;//generate four random unique number

                    try(ResultSet result = findStatement.executeQuery()){
                        if(!result.next()){
                            isUnique = true;
                        }
                    }catch (SQLException e){
                        System.out.println("Database error: " + e.getMessage());
                    }
                }

            }
            return uniqueId;//return the generated four random numbers
        }
    }
}
