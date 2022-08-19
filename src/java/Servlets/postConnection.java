/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Servlets.Producto;

/**
 *
 * @author lazar
 */
public class postConnection {
    public int registerProduct(Producto producto) throws ClassNotFoundException {
        String url = "INSERT INTO supermarket.alimentoperecedero" +
                      "(tipo, nombre, precioCosto, precioVenta, stock) VALUES (?,?,?,?,?)";
        
        int result = 0;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","password");
                PreparedStatement stmt = conn.prepareStatement(url)){
            stmt.setString(1, producto.getTipo());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getPrecioCosto());
            stmt.setInt(4, producto.getPrecioVenta());
            stmt.setInt(5, producto.getStock());
            
            System.out.println(stmt);
            
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
