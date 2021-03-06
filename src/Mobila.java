public class Mobila extends Produs{
    private String tip, material;
    // constructori, getteri, setteri
    public Mobila(String tip, String material, int id, int an, String nume, double pretMinim){
        super(id, an, nume, 0.0, pretMinim);
        this.tip = tip;
        this.material = material;
    }

    public String getTip() {
        return tip;
    }

    public String getMaterial() {
        return material;
    }
}
