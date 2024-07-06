package dbm;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import static log.LogController.*;

public class DatabaseConnection {

    private static Connection connection;
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection(){
        try {
            Properties properties = getProperties();
            connection = DriverManager.getConnection(
                    properties.getProperty(URL),
                    properties.getProperty(USERNAME),
                    properties.getProperty(PASSWORD));
            return connection;
        }
        catch (SQLException e){
            log(Level.CONFIG,"Database not found attempting to create rpg_database");
            Connection createConnection = createDatabase(getProperties());
            DatabaseInstantiation initialSetup = new DatabaseInstantiation(createConnection);
            return createConnection;
        }
    }

    private static Properties getProperties(){
        Properties properties = new Properties();
        try{
            properties.load(new FileReader("src/main/resources/db.properties"));
            log(Level.FINE,"db.properties loaded");
            return properties;
        }
        catch (IOException e){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/db.properties"));
                writer.write("url = jdbc:mysql://localhost:3306/rpg_database\nusername = root\npassword = ");
                writer.close();
                properties.load(new FileReader("src/main/resources/db.properties"));
                log(Level.CONFIG,"db.properties created with initial settings");
                return properties;
                }
            catch (IOException ioException){
                log(Level.WARNING, "db.properties unable to be created!");
                return null;
            }
        }
    }

    private static Connection createDatabase(Properties properties){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/",properties.getProperty(USERNAME), properties.getProperty(PASSWORD));
            Statement createDbStatement = connection.createStatement();
            createDbStatement.execute(Queryable.CREATE_DATABASE);
            return DriverManager.getConnection(
                    properties.getProperty(URL),
                    properties.getProperty(USERNAME),
                    properties.getProperty(PASSWORD));
        }
        catch (SQLException e){
            log(Level.WARNING, "Unable to create database rpg_game");
            return null;
        }
    }
    public static void closeConnection(){
        try {
            connection.close();
        }
        catch (SQLException e){
            log(Level.WARNING,"No connection to close found");
        }
    }
}
