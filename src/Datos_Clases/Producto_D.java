
package Datos_Clases;


public class Producto_D {
    
    private int idPro;
    private String nom;
    private double precio;
    private int stock;

    public Producto_D() {
    }

    public Producto_D(int idPro, String nom, double precio, int stock) {
        this.idPro = idPro;
        this.nom = nom;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
  
    
    
}
