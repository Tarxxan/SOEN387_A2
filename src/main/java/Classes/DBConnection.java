package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "mysql://root:pGbD1yZXthDKdEibWtM1@containers-us-west-123.railway.app:5598/railway";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "pGbD1yZXthDKdEibWtM1";
    static Connection conn = null;

    public DBConnection() {
    }

    public static Connection getConnection() {
        try{
            Class.forName(JDBC_DRIVER); //Register JDBC driver
            //Open a connection
            System.out.println("Connection Attempting");
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Connection Successful");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database",e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException("Error Class Not Found",e);
        }
    }

    public static void closeConnection() throws SQLException{
        //Close connection
        if(conn!=null) conn.close();
    }
}