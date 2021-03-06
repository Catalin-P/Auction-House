public class PersJur extends Client{
    private double capitalSocial;
    private Companie companie;
    // constructori, getteri, setteri
    public PersJur(double capitalSocial, Companie companie, int id, String nume, String adresa){
        super(id, nume, adresa);
        this.capitalSocial = capitalSocial;
        this.companie = companie;
    }

    public double getCapitalSocial() {
        return capitalSocial;
    }

    public Companie getCompanie() {
        return companie;
    }
}
enum Companie{
    SRL, SA
}