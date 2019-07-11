/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemkampus_beta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    Connection con;
    Statement st;
    ResultSet rs;
    
    public Connection config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/sistem_kampus","root","");
            st = con.createStatement();
            } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    return con;
    }
   
}