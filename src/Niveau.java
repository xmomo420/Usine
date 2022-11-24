import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Niveau {

    //Constantes globales
    private final String PROMPT = "Entrez le nom du fichier contenant" +
            " le niveau : ";
    private final String ERROR = "Ce fichier n'existe pas ! \n";

    //Attribut d'instance
    private ArrayList<Station> stations;
    private int argentVictoire;


    //Méthode d'instance
    public void ajouterNiveauDebut() throws IOException {
        String nomFichier = validerNomFichier(ERROR, PROMPT);
        ArrayList<String[]> lignes = remplirListe(nomFichier);
        stations = new ArrayList<>(lignes.size());
        for (String[] ligne : lignes) {
            if (ligne[0].startsWith("fou"))
                stations.add(ajouterFournisseur(ligne[2], ligne[3], ligne[1]));
            else if (ligne[0].startsWith("m"))
                stations.add(ajouterMachine(ligne[1], ligne[2], ligne[0]));
            else if (ligne[0].startsWith("ven"))
                stations.add(new Vendeur());
        }
        argentVictoire = Integer.parseInt(lignes.get(1)[0]);
    }

    public int getArgentVictoire() {
        return argentVictoire;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    //Méthode de classe
    private static Fournisseur ajouterFournisseur(String numeroStation,
                                             String boite, String produit) {
        return new Fournisseur(Integer.parseInt(numeroStation),
                Integer.parseInt(boite), produit);
    }

    private static Machine ajouterMachine(String numeroStation,
                                          String nbBoite, String nomMachine) {
        return new Machine(Integer.parseInt(numeroStation),
                Integer.parseInt(nbBoite), nomMachine);
    }

    public static ArrayList<String[]> remplirListe (String nomFichier) throws IOException {
        Path chemin = Paths.get(nomFichier);
        Stream<String> str = Files.lines(chemin);
        List<String> lignes = str.collect(Collectors.toList());
        ArrayList<String[]> lignesRetour = new ArrayList<>(lignes.size());
        for (String ligne : lignes)
            lignesRetour.add(ligne.split(" "));
        return lignesRetour;
    }

    private static String validerNomFichier (String msgErr, String prompt) {
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        String nomFichier = input.next();
        boolean nonValide = inexistant(nomFichier);
        while (nonValide) {
            System.out.println(msgErr);
            System.out.print(prompt);
            nomFichier = input.next();
            nonValide = inexistant(nomFichier);
        }
        return nomFichier;
    }

    private static boolean inexistant(String nomFichier) {
        boolean estPresent;
        try {
            Path chemin = Paths.get(nomFichier);
            Stream<String> str = Files.lines(chemin);
            estPresent = true;
        } catch (IOException e) {
            estPresent = false;
        }
        return !estPresent;
    }
}
