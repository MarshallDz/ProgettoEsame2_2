package progetto;

import java.util.ArrayList;

public class Citta {
    private String nomeCitta;
    private String pianetaO;
    private ArrayList<Collegamento> archi;
    private int nCase;

    public Citta(String n, String p, int c) {
        this.nomeCitta = n;
        this.pianetaO = p;
        this.nCase = c;
        this.archi = new ArrayList<>();
    }

    //getter e setter
    public void setNomeCitta(String n) {
        this.nomeCitta = n;
    }

    public void setPianetaO(String p) {
        this.pianetaO = p;
    }

    public void setnCase(int nCase) {
        this.nCase = nCase;
    }

    public String getNomeCitta() {
        return nomeCitta;
    }

    public String getPianetaO() {
        return pianetaO;
    }

    public int getnCase() {
        return nCase;
    }

    public void aggiungiArco(Collegamento c){
        archi.add(c);
    }
    public void stampaArchi(){
        for (Collegamento c: archi){
            System.out.println(c.getDestinazione() +" " + c.getPeso());
        }
    }
}

