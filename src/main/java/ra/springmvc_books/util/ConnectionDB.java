package ra.springmvc_books.util;

import jdk.vm.ci.code.site.Call;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/books_store";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Thinh@123";

    public static Connection openConnection(){
        Connection conn = null;
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch (Exception ex){
            ex.printStackTrace();
        } return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement calst){
        if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        if(calst !=null){
            try {
                calst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
