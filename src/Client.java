import java.util.ArrayList;
import java.util.List;

public abstract class Client {
    private int id, nrParticipari, nrLicitatiiCastigate;
    private String nume, adresa;
    private List<Produs> produseLicitate = new ArrayList<Produs>();

    public int getId() {
        return id;
    }

    public int getNrParticipari() {
        return nrParticipari;
    }

    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public List<Produs> getProduseLicitate(){
        return produseLicitate;
    }

    public Client(int id, int nrParticipari, int nrLicitatiiCastigate, String nume, String adresa) {
        this.id = id;
        this.nrParticipari = nrParticipari;
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
        this.nume = nume;
        this.adresa = adresa;
    }

    public Client(){
    }

    public Client(int id, String nume, String adresa){
        this(id, 0, 0,nume, adresa);
    }

    public void liciteazaPtProdus(Produs produs){
        produseLicitate.add(produs);
    }
}
