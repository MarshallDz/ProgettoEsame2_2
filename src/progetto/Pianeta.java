package progetto;

public class Pianeta {
    private String nomePianeta;
     private int nCitta;
     private int nRegali;
     private int costoRegali;

    public Pianeta(String n, int c) {
        this.nomePianeta = n;
        this.nCitta = c;
    }
    public String getNomePianeta() {
        return nomePianeta;
    }
    public void setnRegali(int nRegali) { this.nRegali = nRegali; }

    public int getnRegali() { return nRegali; }

    public int getCostoRegali() { return costoRegali; }

    public void setCostoRegali(int costoRegali) {
        this.costoRegali = costoRegali;
    }
}
