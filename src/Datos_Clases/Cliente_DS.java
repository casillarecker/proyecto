
package Datos_Clases;


public class Cliente_DS {
    private int IdCli;
    private String ciCli;
    private String nom;
    private String dire;

    public Cliente_DS() {
    }

    public Cliente_DS(int IdCli, String ciCli, String nom, String dire) {
        this.IdCli = IdCli;
        this.ciCli = ciCli;
        this.nom = nom;
        this.dire = dire;
    }

    public int getIdCli() {
        return IdCli;
    }

    public void setIdCli(int IdCli) {
        this.IdCli = IdCli;
    }

    public String getCiCli() {
        return ciCli;
    }

    public void setCiCli(String ciCli) {
        this.ciCli = ciCli;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }
    
    
}
