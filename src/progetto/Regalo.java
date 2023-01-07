package progetto;

public class Regalo {
    private String nomeRegalo;
    private int costo;
    private String tipo;
    public Regalo(String n, int c, String t){
        this.nomeRegalo = n;
        this.costo = c;
        this.tipo = t;
    }

    public String getNomeRegalo() { return nomeRegalo; }
    public int getCosto() { return costo; }
    public String getTipo() { return tipo; }
    public void setNomeRegalo(String nomeRegalo) { this.nomeRegalo = nomeRegalo; }
    public void setCosto(int costo) { this.costo = costo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
