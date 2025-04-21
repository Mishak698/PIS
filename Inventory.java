

public class Inventory {
    public String nazev, kod, umisteni;
    public int mnozstvi;
    public double cena;

    public Inventory(String nazev, String kod, int mnozstvi, String umisteni, double cena) {
        this.nazev = nazev;
        this.kod = kod;
        this.mnozstvi = mnozstvi;
        this.umisteni = umisteni;
        this.cena = cena;
    }

    public String toCSV() {
        return String.join(",", nazev, kod, String.valueOf(mnozstvi), umisteni, String.valueOf(cena));
    }
}