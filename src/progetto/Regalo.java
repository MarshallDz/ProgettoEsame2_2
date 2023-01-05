package progetto;

public class Regalo {
    private String nomeRegalo;
    private int costo;
    private Tipologia tipo;
    protected enum Tipologia {arte, tecnologia, sport }
    public Regalo(String n, int c, Tipologia t){
        this.nomeRegalo = n;
        this.costo = c;
        this.tipo = t;
    }

    public String getNomeRegalo() {
        return nomeRegalo;
    }

    public int getCosto() {
        return costo;
    }

    public Tipologia getTipo() {
        return tipo;
    }

    public void setNomeRegalo(String nomeRegalo) {
        this.nomeRegalo = nomeRegalo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setTipo(Tipologia tipo) {
        this.tipo = tipo;
    }
}
