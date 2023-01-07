package progetto;

public class Pianeta {
    private String nomePianeta;
     private int nCitta;

    public Pianeta(String n, int c) {
        this.nomePianeta = n;
        this.nCitta = c;
    }

    public void setNomePianeta(String n){
        this.nomePianeta = n;
    }

    public void setnCitta(int nCitta) {
        this.nCitta = nCitta;
    }

    public String getNomePianeta() {
        return nomePianeta;
    }

    public int getnCitta() {
        return nCitta;
    }

}
