// clasa folosita pt a implementa DP Builder pt un obiect de tip Licitatii.Licitatie
public class BuilderLicitatie {
    // creeaza un obiect de tipul pe care trebuie sa il construim
    private Licitatie licitatie = new Licitatie();
    // metode pt a seta parametri obiectului inlantuit
    public BuilderLicitatie withID(int id){
        licitatie.setId(id);
        return this;
    }

    public BuilderLicitatie withNrParticipanti(int nrParticipanti){
        licitatie.setNrParticipanti(nrParticipanti);
        return this;
    }

    public BuilderLicitatie withNrPasi(int nrPasi){
        licitatie.setNrPasiMaxim(nrPasi);
        return this;
    }

    public BuilderLicitatie withIDProdus(int idProdus){
        licitatie.setIdProdus(idProdus);
        return this;
    }
    // returnam obiectul final
    public Licitatie build(){
        return licitatie;
    }
}
