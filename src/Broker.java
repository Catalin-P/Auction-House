public class Broker extends Angajat{
    private int[] sumePasCurent = new int[CasaLicitatii.Instanta().getListaClienti().size()];
    // constructori, getteri, setteri
    public Broker(String nume) {
        super(nume);
    }

    public int[] getSumePasCurent() {
        return sumePasCurent;
    }

    public void setSumePasCurent(int[] sumePasCurent) {
        this.sumePasCurent = sumePasCurent;
    }

    public Broker() {
    }
    // sterge un produs din lista de produse a casei de licitatii
    public void stergeProdus(Produs produs){
        // invoca obiectul casa
        CasaLicitatii casa = CasaLicitatii.Instanta();
        // stergerea propriu-zisa
        casa.getListaProdus().remove(produs);
    }
    // calculeaza comision client
    public double calculComision(Client client, double sumaMax){
        // stabilim daca este persoana fizica sau juridica
        if (client instanceof PersFiz){
            // comision in functie de participari la alte licitatii
            if(client.getNrParticipari() <5){
                return 0.2 * sumaMax;
            }
            return 0.15 * sumaMax;
        }else{
            // comision in functie de participari la alte licitatii
            if(client.getNrParticipari() < 25){
                return 0.25 * sumaMax;
            }
            return 0.1 * sumaMax;
        }

    }
}