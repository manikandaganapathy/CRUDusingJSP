package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public Statement stmt;
    public ResultSet rs;
    public Connection conn;

    public DBConnection() {
    }
    public Connection setConnection(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","admin");
        }catch(ClassNotFoundException | SQLException e){
           
        }
        return conn;
    }
    public ResultSet getResult(String query,Connection conn){
        this.conn=conn;
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            
        }catch(SQLException e){
            
        }
        return rs;
    }
    
}
