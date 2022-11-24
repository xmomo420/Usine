import java.util.ArrayList;

public class Boite {

    // Attribut d'instance
    private ArrayList<ArrayList<Produit>> boites;

    //Constructeur
    /**
     *
     * @param nbBoite
     */
    public Boite(int nbBoite) {
        boites = new ArrayList<>(nbBoite);
        if (nbBoite > 0)
            boites.add(new ArrayList<>());
        boites.add(new ArrayList<>());
    }

    public String produitsToString(ArrayList<ArrayList<Produit>> boite,
                                   int indice) {
        String toString = "";
        if (indice == 0)
            if (boite.get(0) == null || boite.get(0).isEmpty())
                toString = " vide";
            else
                for (Produit produits : boite.get(0))
                    toString += produits + " ";
        else if (boite.get(1) == null || boite.get(1).isEmpty())
                toString = " vide";
            else
                for (Produit produits : boite.get(1))
                    toString += produits + " ";
        return toString;
    }

    @Override
    public String toString() {
        String toString;
        if (boites.size() == 1)
            toString = "B0:" + produitsToString(boites, 0);
        else toString =
                "B0:" + produitsToString(boites, 0) + " B1:" + produitsToString(boites, 1);
        return toString;
    }
}
