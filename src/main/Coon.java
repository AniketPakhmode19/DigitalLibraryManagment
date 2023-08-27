package main;
import java.sql.*;  

public class Coon{
    Connection c;
    Statement s;
    public Coon(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false","root","root");    
            s =c.createStatement();  
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
