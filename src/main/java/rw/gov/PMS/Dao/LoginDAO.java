/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rw.gov.PMS.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import rw.gov.PMS.Model.LoginModel;

/**
 *
 * @author The_Great
 */
public class LoginDAO {
    private String URL = "jdbc:mysql://localhost:3306/";
    private  String Username = "root";
    private  String Password = "";
    
    public int loginUser(LoginModel loginObj){
        try {
            Connection con = DriverManager.getConnection(URL, Username, Password);
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO login";
            
            PreparedStatement ppst = con.prepareStatement(sql);
            ppst.setString(1, loginObj.getUsername());
            ppst.setString(2, loginObj.getPassword());
            ppst.setString(3, loginObj.getRole());
            int rowAffected = ppst.executeUpdate();
            
            con.close();
            return rowAffected;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
