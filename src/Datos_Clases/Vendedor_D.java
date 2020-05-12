/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos_Clases;


public class Vendedor_D {
    
    private int idven;
    private String ci;
    private String Nom;
    private String Tel;
    private String estado;
    private String user;

    public Vendedor_D() {
    }
    
    

    public Vendedor_D(int idven, String ci, String Nom, String Tel, String estado, String user) {
        this.idven = idven;
        this.ci = ci;
        this.Nom = Nom;
        this.Tel = Tel;
        this.estado = estado;
        this.user = user;
    }

    public int getIdven() {
        return idven;
    }

    public void setIdven(int idven) {
        this.idven = idven;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
