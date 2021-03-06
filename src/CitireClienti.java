import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// clasa helper pentru citirea fisierului clienti.txt
public class CitireClienti {
    public static void citesteClienti(String numeFisier) throws FileNotFoundException {
        File fisier = new File(numeFisier);
        Scanner scanner = new Scanner(fisier);
        Client clientCurent = null;
        CasaLicitatii casa = CasaLicitatii.Instanta();
        // parcurgem fiecare linie a fisierului
        while (scanner.hasNextLine()){
            // extragem parametri din string folosind metoda split
            String[] dateClient = scanner.nextLine().split(" ");
            // decidem tipul de persoana in functie de nr de parametri si cream obiectul
            if(dateClient.length == 4){
                clientCurent = new PersFiz(dateClient[3], Integer.valueOf(dateClient[0]), dateClient[1],
                        dateClient[2]);
            }else{
                clientCurent = new PersJur(Double.valueOf(dateClient[4]), Companie.valueOf(dateClient[3]),
                        Integer.valueOf(dateClient[0]), dateClient[1], dateClient[2]);
            }
            // adaugam clientul in lista de clienti a casei de licitatii
            casa.getListaClienti().add(clientCurent);
        }
    }
}
