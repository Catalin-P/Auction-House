// clasa abstracta care modeleaza caract unui produs
// sta la baza claselor Bijuterie, Mobila, Tablou
public abstract class Produs {
    private int id, an;
    private String nume;
    private  double pretVanzare, pretMinim;
    // getteri, setteri, constructori
    public Produs(int id, int an, String nume, double pretVanzare, double pretMinim) {
        this.id = id;
        this.an = an;
        this.nume = nume;
        this.pretVanzare = pretVanzare;
        this.pretMinim = pretMinim;
    }

    public Produs(int id, int an, String nume, double pretMinim) {
        this(id, an, nume, 0.0, pretMinim);
    }

    public int getId() {
        return id;
    }

    public int getAn() {
        return an;
    }

    public String getNume() {
        return nume;
    }

    public double getPretVanzare() {
        return pretVanzare;
    }

    public double getPretMinim() {
        return pretMinim;
    }


}
