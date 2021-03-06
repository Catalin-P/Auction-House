public class PersFiz extends Client{
    private  String dataNastere;
    // constructori, getteri, setteri
    public PersFiz(String dataNastere, int id, String nume, String adresa){
        super(id, nume, adresa);
        this.dataNastere = dataNastere;
    }

    public String getDataNastere() {
        return dataNastere;
    }
}
