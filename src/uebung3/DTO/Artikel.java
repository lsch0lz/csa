package uebung3.DTO;

public class Artikel {
    private final long aID;
    private String bezeichnung;
    private double preis;

    public Artikel(long aID, String bezeichnung, double preis) {
        this.aID = aID;
        this.bezeichnung = bezeichnung;
        this.preis = preis;
    }

    public long getaID() {
        return aID;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

}
