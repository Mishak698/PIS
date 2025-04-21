
public class Project {
    public String nazev, stav, datumStart, datumKonec;

    public Project(String nazev, String stav, String datumStart, String datumKonec) {
        this.nazev = nazev;
        this.stav = stav;
        this.datumStart = datumStart;
        this.datumKonec = datumKonec;
    }

    public String toCSV() {
        return String.join(",", nazev, stav, datumStart, datumKonec);
    }
}