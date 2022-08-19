/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

/**
 *
 * @author lazar
 */
public class Producto {
    String tipo;
    String nombre;
    int precioCosto;
    int precioVenta;
    int stock;
    
    public Producto(String tipo, String nombre, int precioCosto, int precioVenta, int stock){
        this.tipo = tipo;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPrecioCosto() {
        return precioCosto;
    }
    
    public int getPrecioVenta() {
        return precioVenta;
    }
    
    public int getStock() {
        return stock;
    }
        
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }
    
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
}
