import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Usine {

    //Constantes globales
    private static final String ERROR = "Erreur, mauvaise commande...\n";
    private static final List<String> COMMANDES =
            Arrays.asList("a", "s", "f");

    // Attribut d'instance
    private ArrayList<Station> stations = new ArrayList<>();
    private Joueur joueur;
    private char commande;

    //Constructeur

    /**
     *
     * @throws IOException
     */
    public Usine() throws IOException {
        Niveau niveau = new Niveau();
        Joueur joueur = new Joueur();
        niveau.ajouterNiveauDebut();
        debutJeu(niveau);
        jouer(true, joueur);
        while (joueur.getArgent() < niveau.getArgentVictoire())
            jouer(false, joueur);


    }
    //Méthode d'instances
    /**
     *
     * @param niveau
     */
    public void debutJeu (Niveau niveau) {
        this.stations = niveau.getStations();
    }




    /**
     *
     */
    public void jouer(boolean debut, Joueur joueur) {
        if (!debut)
            commande = validerCommande();
        System.out.print(this); //Affichage
        System.out.println(joueur.getArgent() + "$");

        // Faire le reste
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (Station ligne : stations)
            toString.append(stations.indexOf(ligne)).append(" : ").append(ligne.toString()).append("\n");
        return toString.toString();
    }


    //Méthodes de classe
    /**
     *
     * @param commande
     * @return
     */
    private static boolean nonValide(String commande) {
        return !(commande.length() == 1 && ( COMMANDES.contains(commande) || Character.isDigit(commande.charAt(0))));
    }



    /**
     *
     * @return
     */
    private static char validerCommande() {
        System.out.print("=>");
        Scanner input = new Scanner(System.in);
        String commande = input.next();
        boolean nonValide = nonValide(commande);
        while (nonValide) {
            System.out.println(ERROR);
            System.out.print("=>");
            commande = input.next();
            nonValide = nonValide(commande);
        }
        return commande.charAt(0);
    }
}
