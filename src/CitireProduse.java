import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// clasa statica helper pentru a citi continutul fisierului produse.txt
public class CitireProduse {
    public static void citesteProduse(String numeFisier) throws FileNotFoundException {
        File fisier = new File(numeFisier);
        Scanner scanner = new Scanner(fisier);
        ComandaAdmin comanda = new ComandaAdmin();
        // citim linie cu linie fisierul text
        while (scanner.hasNextLine()){
            String dateProdus = scanner.nextLine();
            // cream subtipul de  produs cu DP Factory
            Produs produsCurent = ProdusFactory.createProdus(dateProdus);
            // Utilizam DP command pentru a adauga un produs in lista casei de licitatii
            comanda.executa(produsCurent);
        }
    }
}
