package progetto;

public class Collegamento {
    private String destinazione;
    private int peso;

    public Collegamento(String destinazione, int peso) {
        this.destinazione = destinazione;
        this.peso = peso;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public int getPeso() {
        return peso;
    }
}
