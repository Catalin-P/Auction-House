public class ProdusFactory {
    public static Produs createProdus(String comanda){
        String[] params = comanda.split(" ");
        switch (params[0]){
            case "tablou":
                return new Tablou(params[4], Culori.valueOf(params[5]), Integer.valueOf(params[1]), Integer.valueOf(params[3]),
                        params[0], Double.valueOf(params[2]));
            case "bijuterie":
                return new Bijuterie(params[4], Boolean.parseBoolean(params[5]),Integer.valueOf(params[1]), Integer.valueOf(params[3]),
                        params[0], Double.valueOf(params[2]));
            case "mobila":
                return new Mobila(params[4],params[5],Integer.valueOf(params[1]), Integer.valueOf(params[3]),
                        params[0], Double.valueOf(params[2]));
            default:
                return null;
        }
    }
}
