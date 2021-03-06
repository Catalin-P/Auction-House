public class ComandaAdmin extends Comanda{
    // implementam comanda care este solicitata de admin
    public void executa(Produs produs){
        Admin admin = Admin.Instanta();
        admin.adaugaProdus(produs);
    }
}
