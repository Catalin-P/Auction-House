import java.util.ArrayList;
import java.util.List;

public class CasaLicitatii {
    // creeaza liste generice pentru a stoca produsele, licitatiile
    // brokerii si clientii
    private List<Client> listaClienti = new ArrayList<Client>();
    private List<Produs> listaProdus = new ArrayList<Produs>();
    private List<Licitatie> listaLicitatie = new ArrayList<Licitatie>();
    private List<Broker> listaBrokeri = new ArrayList<Broker>();
    private static CasaLicitatii casa;
    // utilizare DP Singleton, metoda folosita pt a crea o instanta unica a clasei
    public static CasaLicitatii Instanta(){
        if (casa == null) {
            casa = new CasaLicitatii();
        }
        return casa;
    }
    // getteri
    public List<Client> getListaClienti() {
        return listaClienti;
    }

    public List<Produs> getListaProdus() {
        return listaProdus;
    }

    public List<Licitatie> getListaLicitatie() {
        return listaLicitatie;
    }

    public List<Broker> getListaBrokeri(){
        return listaBrokeri;
    }
    // returneaza indicele clientului care a licitat cea mai mare suma
    public int aflaCastigatorLaPasCurent(List<Broker> listaBrokeri){
        int indice = -1;
        int maxim = -1;
        // parcurgem lista de brokeri
        for(int i = 0; i < listaBrokeri.size(); ++i){
            int[] listaBroker = listaBrokeri.get(i).getSumePasCurent();
            // pentru fiecare broker, comparam suma de la pasul curent al clientului
            // de pe pozitia j cu maximul curent
            for(int j = 0; j < listaBrokeri.get(i).getSumePasCurent().length; ++j){
                // actualizam maxim si indice
                if(maxim < listaBroker[j]){
                    indice = j;
                    maxim = listaBroker[j];
                }
            }
        }
        // actualizam sumele de la pasul curent cu maximul licitat
        for(int i = 0; i < listaBrokeri.size(); ++i){
            int[] listaBroker = listaBrokeri.get(i).getSumePasCurent();
            for(int j = 0; j < listaBrokeri.get(i).getSumePasCurent().length; ++j){
                listaBroker[j] = maxim;
            }
        }
        return indice;
    }
}
