package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/Librarian";
        String user="root";
        String password="123456";
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        System.out.println(DB.getConnection());
    }
}
