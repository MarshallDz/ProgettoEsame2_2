package progetto;

public class Pianeta {
    private String nomePianeta;
     private int nCitta;
     private int nRegali;
     private int costoRegali = 0;

    public Pianeta(String n, int c) {
        this.nomePianeta = n;
        this.nCitta = c;
    }
    public String getNomePianeta() {
        return nomePianeta;
    }

    public int getnCitta() { return nCitta; }

    public int getnRegali() { return nRegali; }

    public int getCostoRegali() { return costoRegali; }

    public void setCostoRegali(int costoRegali) {
        this.costoRegali = costoRegali;
    }
    public void incrementaCosto(int p){ costoRegali+=p; }
    public void incrementaNregali(int p){ nRegali+=p; }
}
