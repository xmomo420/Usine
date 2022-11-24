
public class Fournisseur extends Station {
    enum ProduitFournisseur {
        ACANTHITE("acanthite", 2),
        CASSITERITE("cassiterite", 7),
        CHALCOCITE("chalcocite", 3),
        CHARBON("charbon", 1),
        ;

        public final String nom;
        public final int nombreTours;

        ProduitFournisseur(String nom, int nombreTours) {
            this.nom = nom;
            this.nombreTours = nombreTours;
        }
    }

    //Attributs d'instance
    private final int numeroStation;
    private ProduitFournisseur produit;
    private int boite;

    //Constructeur
    /**
     *
     * @param numeroStation
     * @param produit
     */
    public Fournisseur(int numeroStation, int boite, String produit) {
        this.numeroStation = numeroStation;
        this.boite = boite;
        associerProduit(produit);
    }

    /**
     *
     * @param nomProduit
     */
    public void associerProduit(String nomProduit) {
        if (nomProduit.equals(ProduitFournisseur.ACANTHITE.nom))
            this.produit = ProduitFournisseur.ACANTHITE;
        else if (nomProduit.equals(ProduitFournisseur.CASSITERITE.nom))
            this.produit = ProduitFournisseur.CASSITERITE;
        else if (nomProduit.equals(ProduitFournisseur.CHALCOCITE.nom))
            this.produit = ProduitFournisseur.CHALCOCITE;
        else if (nomProduit.equals(ProduitFournisseur.CHARBON.nom))
            this.produit = ProduitFournisseur.CHARBON;
    }

    /**
     *
     * @return
     */
    public String toString () {
        String prefix = "fou F: 1 " +  produit.nom + " " +
                produit.nombreTours + " (" + numeroStation + ",";
        String sufix;
        if (boite == 1)
            sufix = "1)";
        else
            sufix = "0)";
        return prefix + sufix;
    }
}
