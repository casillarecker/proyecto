
package Datos_Clases;

public class Ventas_D {
    
    private int idVenta;
    private int idCli;
    private int idVende;
    private String FecVen;
    private double monto;

    public Ventas_D() {
    }

    public Ventas_D(int idVenta, int idCli, int idVende, String FecVen, double monto) {
        this.idVenta = idVenta;
        this.idCli = idCli;
        this.idVende = idVende;
        this.FecVen = FecVen;
        this.monto = monto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdVende() {
        return idVende;
    }

    public void setIdVende(int idVende) {
        this.idVende = idVende;
    }

    public String getFecVen() {
        return FecVen;
    }

    public void setFecVen(String FecVen) {
        this.FecVen = FecVen;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
     
}
