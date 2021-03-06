public class ComandaClient extends Comanda{
    // implementam comanda solicitata de client
    public void execute(Produs produs){
        System.out.println("Produs: " + produs.getNume() + " Id: " + produs.getId());
    }
}
