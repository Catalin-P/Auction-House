import java.util.HashMap;
import java.util.List;

public class Licitatie implements Runnable{
    private int id, nrParticipanti, idProdus, nrPasiMaxim;
    // hashMap pentru a mapa un Broker fiecarui Client
    private HashMap<Client, Broker> clientBrokerHashMap = new HashMap<Client, Broker>();
    // getteri, setteri, constructori
    public int getId() {
        return id;
    }

    public int getNrParticipanti() {
        return nrParticipanti;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public int getNrPasiMaxim() {
        return nrPasiMaxim;
    }

    public Licitatie(int id, int nrParticipanti, int idProdus, int nrPasiMaxim) {
        this.id = id;
        this.nrParticipanti = nrParticipanti;
        this.idProdus = idProdus;
        this.nrPasiMaxim = nrPasiMaxim;
    }

    public Licitatie(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNrParticipanti(int nrParticipanti) {
        this.nrParticipanti = nrParticipanti;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public void setNrPasiMaxim(int nrPasiMaxim) {
        this.nrPasiMaxim = nrPasiMaxim;
    }
    // licitatia propriu-zisa
    public void run(){
        // initializari
        int i = 0;
        // pas crent
        int pas = 0;
        // indicele din ArrayList al celui ce liciteaza cel mai mult
        int indiceCastigator = 0;
        // vector ce va retine sumele maxime oferite de fiecare bidder(nu participa la licitatie => sumeMaximeClienti[i] == 0
        double[] sumeMaximeClienti = new double[CasaLicitatii.Instanta().getListaClienti().size()];
        // preluam brokerii din casa de licitatie
        List<Broker> listaBrokeri = CasaLicitatii.Instanta().getListaBrokeri();
        double sumaMinProdus = 0;
        // cautam suma minima cu care se poate vinde produsul din licitatia curenta
        // in vectorul de produse din casa
        for(int j = 0; j < CasaLicitatii.Instanta().getListaProdus().size(); ++j){
            if (idProdus == CasaLicitatii.Instanta().getListaProdus().get(j).getId()){
                sumaMinProdus = (int) CasaLicitatii.Instanta().getListaProdus().get(j).getPretMinim();
            }
        }
        // asteptam sa se ocupe toate sloturile licitatiei
        while(i < nrParticipanti){
            // cautam lista de produse pt care a licitat a fiecarui client produsl cu acelasi ID ca al licitatiei
            for(int j = 0; j < CasaLicitatii.Instanta().getListaClienti().size(); ++j){
                for(int k = 0; k < CasaLicitatii.Instanta().getListaClienti().get(j).getProduseLicitate().size(); ++k){
                    List<Produs> licitatiiClientCurent = CasaLicitatii.Instanta().getListaClienti().get(j).getProduseLicitate();
                    // daca clientul curent liciteaza pt produsul licitatiei curente
                    if(licitatiiClientCurent.get(k).getId() == idProdus){
                        // ocupam inca un slot
                        i++;
                        // generam ce broker ii asignam clientului( caz 2 brokeri, de aceea am folosit %2)
                        int numarRandom = (int)(Math.random() * 10);
                        int indiceBrokerAsignat = numarRandom % 2;
                        Broker brokerClient = listaBrokeri.get(indiceBrokerAsignat);
                        // clientii pot sa liciteze maxim intre 200-500 lei
                        double sumaRandomClient = (int) (Math.random() * 300 + 200);
                        sumaRandomClient -= brokerClient.calculComision(CasaLicitatii.Instanta().getListaClienti().get(j), sumaRandomClient);
                        clientBrokerHashMap.put(CasaLicitatii.Instanta().getListaClienti().get(j), brokerClient);
                        // updatam suma maxima ce poate fi platita de clientul de pe pozitia j
                        sumeMaximeClienti[j] = sumaRandomClient;
                        // listam participantii la licitatie
                        System.out.println("Participa la Licitatii.Licitatie " + CasaLicitatii.Instanta().getListaClienti().get(j).getNume() );
                    }
                }
            }
        }
        // licitatia incepe de la jumatatea sumei minime acceptate pentru produs
        int pretStart = (int) (sumaMinProdus /2);
        int v[]  = new int[CasaLicitatii.Instanta().getListaClienti().size()];
        for(int j = 0; j < v.length; ++j){
            v[j] = pretStart;
        }
        // updatam vectorii sumelor de la fiecare pas calculate de brokeri cu pretul de start
        for(Broker broker : clientBrokerHashMap.values()){
            broker.setSumePasCurent(v);
        }
        // simulam licitatia
        while(pas < nrPasiMaxim){
            pas++;
            // printam pasul curent
            System.out.println("Pas " + pas);
            for(Client x: clientBrokerHashMap.keySet()){
                Broker brokerClient = clientBrokerHashMap.get(x);
                int sumeBroker[] = brokerClient.getSumePasCurent();
                // asignam fiecarui client o incrementare in suma pt licitatie(cuprinsa intre 10-20 lei)
                int increment = (int) (Math.random() * 10 + 10);
                for(int j = 0; j < CasaLicitatii.Instanta().getListaClienti().size(); ++j){
                    if(x.getId() == CasaLicitatii.Instanta().getListaClienti().get(j).getId()){
                        // daca suma clientului curent este mai mica decat plafonul sau maxim
                        // updatam valoarea in vectorul sumePasCurent al brokerului sau
                        if(sumeBroker[j] + increment < sumeMaximeClienti[j]){
                            sumeBroker[j] += increment;
                            clientBrokerHashMap.get(x).getSumePasCurent()[j] = sumeBroker[j];
                            // spunem cat licitateaza
                            System.out.println("Clientul " + x.getNume() + " liciteaza " + sumeBroker[j]);
                        }
                    }
                }
            }
            // calculam castigatorul de la pasul curent prin intermediul broker si apoi al casei de licitatie
            indiceCastigator = CasaLicitatii.Instanta().aflaCastigatorLaPasCurent(listaBrokeri);
        }
        // afiseaza castigatorul in cazul in care suma minima necesara pentru un produs a fost depasita
        // sau transmite mesajul ca sume este prea mica in caz contrar
        if(CasaLicitatii.Instanta().getListaBrokeri().get(0).getSumePasCurent()[0] >= 2 * pretStart){
            System.out.println("Castigator: " + CasaLicitatii.Instanta().getListaClienti().get(indiceCastigator).getNume());
        }
        else{
            System.out.println("Suma licitata a fost prea mica!");
        }
        System.out.println();
        for(int j = 0; j < v.length; ++j){
            v[j] = 0;
        }
        // restabilim vectorul sumePasCurent dupa fiecare licitatie
        for(Broker broker : clientBrokerHashMap.values()){
            broker.setSumePasCurent(v);
        }
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
