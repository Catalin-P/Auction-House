// clasa abstracta Angajat
// sta la baza subtipurilor Admin si Broker
public abstract class Angajat {
    private String nume;
    // constructori, getteri, setteri
    public Angajat(String nume) {
        this.nume = nume;
    }

    public Angajat(){
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
