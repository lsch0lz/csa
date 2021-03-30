package uebung3.DTO;

public class Bestellung {
    private long bID;
    private long kID;

    public Bestellung(long bID, long kID) {
        this.bID = bID;
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

}
