
public class Employee {
    public String jmeno, prijmeni, pozice, kontakt;

    public Employee(String jmeno, String prijmeni, String pozice, String kontakt) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.pozice = pozice;
        this.kontakt = kontakt;
    }

    public String toCSV() {
        return String.join(",", jmeno, prijmeni, pozice, kontakt);
    }
}