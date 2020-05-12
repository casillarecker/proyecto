
package Datos_Clases;

public class Detalle_Venta_D {
    
    private int idDetalleVen;
    private int idVenta;
    private int idProd;
    private int cant;
    private double precVenta;

    public Detalle_Venta_D(int idDeVen, int idVenta, int idProd, int cant, double precVenta) {
        this.idDetalleVen = idDeVen;
        this.idVenta = idVenta;
        this.idProd = idProd;
        this.cant = cant;
        this.precVenta = precVenta;
    }


    public int getIdDetalleVen() {
        return idDetalleVen;
    }

    public void setIdDetalleVen(int idDetalleVen) {
        this.idDetalleVen = idDetalleVen;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecVenta() {
        return precVenta;
    }

    public void setPrecVenta(double precVenta) {
        this.precVenta = precVenta;
    }
    
    
}
