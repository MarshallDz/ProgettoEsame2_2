package progetto;

import java.util.ArrayList;

public class Citta {
    private String nomeCitta;
    private String pianetaO;
    private ArrayList<Collegamento> archi;
    private ArrayList<Regalo> regali;
    private int nCase;
    private int regaliRichiesti = 0;
    private int arte=0, sport=0, elet=0;

    public Citta(String n, String p, int c) {
        this.nomeCitta = n;
        this.pianetaO = p;
        this.nCase = c;
        this.archi = new ArrayList<>();
        this.regali = new ArrayList<>();
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
    public int getRegaliRichiesti() { return regaliRichiesti; }
    public void incrementaRegaliRichiesti(int p){ regaliRichiesti += p; }
    public void aggiungiArco(Collegamento c){ archi.add(c); }
    public void aggiungiRegalo(Regalo r){ 
        this.regali.add(r);
        switch (r.getTipo()) {
            case "arte" -> arte++;
            case "elettronica" -> elet++;
            case "sport" -> sport++;
        }
    }
    public int regaliSize(){ return regali.size(); }
    public int getNumeroArchi(){ return archi.size(); }
    public ArrayList<Collegamento> getArchi() { return archi; }
    public int getPesoArchi(){
        int TotalPeso = 0;
        for (Collegamento collegamento : archi) TotalPeso += collegamento.getPeso();
        return TotalPeso;
    }
    public int getArte(){return arte; }
    public int getElettronica(){return elet; }
    public int getSport(){return sport;}
}

