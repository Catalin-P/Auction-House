import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // creeaza entitati care participa la licitatie
        CasaLicitatii casa = CasaLicitatii.Instanta();
        Admin admin = new Admin("admim_casa_licitatii");

        // citeste clientii si produsele
        CitireClienti.citesteClienti("clienti.txt");
        CitireProduse.citesteProduse("produse.txt");

        // adauga 2 brokeri pt test
        casa.getListaBrokeri().add(new Broker("DriveWealth"));
        casa.getListaBrokeri().add(new Broker("InteractiveBrokers"));

        // creeaza 4 licitatii pt test
        Licitatie[] licitatii = new Licitatie[4];
        licitatii[0] = new Licitatie(1, 2, 100, 10);
        licitatii[1] = new Licitatie(2, 2, 101, 15);
        licitatii[2] = new Licitatie(3, 4, 102, 13);
        licitatii[3] = new Licitatie(4, 4, 103, 10);

        // hardcodare solicitari clienti pentru diverse licitatii
        casa.getListaClienti().get(0).liciteazaPtProdus(casa.getListaProdus().get(0));
        casa.getListaClienti().get(0).liciteazaPtProdus(casa.getListaProdus().get(1));
        casa.getListaClienti().get(0).liciteazaPtProdus(casa.getListaProdus().get(2));
        casa.getListaClienti().get(0).liciteazaPtProdus(casa.getListaProdus().get(3));
        casa.getListaClienti().get(1).liciteazaPtProdus(casa.getListaProdus().get(0));
        casa.getListaClienti().get(2).liciteazaPtProdus(casa.getListaProdus().get(1));
        casa.getListaClienti().get(2).liciteazaPtProdus(casa.getListaProdus().get(3));
        casa.getListaClienti().get(3).liciteazaPtProdus(casa.getListaProdus().get(3));
        casa.getListaClienti().get(4).liciteazaPtProdus(casa.getListaProdus().get(3));
        casa.getListaClienti().get(5).liciteazaPtProdus(casa.getListaProdus().get(2));
        casa.getListaClienti().get(3).liciteazaPtProdus(casa.getListaProdus().get(2));
        casa.getListaClienti().get(1).liciteazaPtProdus(casa.getListaProdus().get(2));
        // creeaza si ruleaza licitatiile ca si threaduri
        Thread thread1 = new Thread(licitatii[0]);
        Thread thread2 = new Thread(licitatii[1]);
        Thread thread3 = new Thread(licitatii[2]);
        Thread thread4 = new Thread(licitatii[3]);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
    }
}
