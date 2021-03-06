public class Tablou extends Produs{
    private String numePictor;
    private Culori  culori;
    // constructori, getteri, setteri
    public Tablou(String numePictor, Culori culori, int id, int an, String nume, double pretMinim){
        super(id, an, nume, 0.0, pretMinim);
        this.numePictor = numePictor;
        this.culori = culori;
    }

    public String getNumePictor() {
        return numePictor;
    }

    public Culori getCulori() {
        return culori;
    }
}
enum Culori{
    ULEI, TEMPERA, ACRILIC
}