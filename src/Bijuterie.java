public class Bijuterie extends Produs{
    private String material;
    private boolean piatraPretioasa;
    // constructori, getteri, setteri
    public String getMaterial() {
        return material;
    }

    public boolean isPiatraPretioasa() {
        return piatraPretioasa;
    }

    public  Bijuterie(String material, boolean piatraPretioasa, int id, int an, String nume, double pretMinim){
        super(id, an, nume, 0.0, pretMinim);
        this.material = material;
        this.piatraPretioasa = piatraPretioasa;
    }
}
