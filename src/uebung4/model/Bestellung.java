package uebung4.model;

public class Bestellung {
    private long bID;
    private long kID;

    public Bestellung(long bID, long kID) {
        this.bID = bID;
        this.kID = kID;
    }

    /**
     * Konstruktor um Entitaet in DB zu speichern, also OHNE ID!
     *
     * @param kID
     */
    public Bestellung(long kID) {
        this.bID = -1;
        this.kID = kID;
    }

    public long getbID() {
        return bID;
    }

    public void setbID(long bID) {
        this.bID = bID;
    }

    public long getkID() {
        return kID;
    }

    public void setkID(long kID) {
        this.kID = kID;
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "bID=" + bID +
                ", kID=" + kID +
                '}';
    }

}
