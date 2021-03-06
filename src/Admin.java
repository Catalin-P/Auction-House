public class Admin extends Angajat{
    private static Admin admin;
    // constructor, getteri, setteri
    public Admin(String nume) {
        super(nume);
    }
    // folosim DP Singleton (un singur admin)
    public static Admin Instanta(){
        if (admin== null) {
            admin = new Admin("AuctionAdmin");
        }
        return admin;
    }
    // adauga produs in lista de produse a casei de licitatii
    public void adaugaProdus(Produs produs){
        CasaLicitatii casa = CasaLicitatii.Instanta();
        casa.getListaProdus().add(produs);
    }
}
