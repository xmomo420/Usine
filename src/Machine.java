public class Machine extends Station {

    //Attributs d'instance
    private int numeroStation;
    private Boite boite;
    private String nomMachine;

    //Constructeur
    /**
     *
     * @param numeroStation
     * @param nbBoite
     * @param nomMacine
     */
    public Machine(int numeroStation, int nbBoite, String nomMacine) {
        this.numeroStation = numeroStation;
        boite = new Boite(nbBoite);
        this.nomMachine = nomMacine;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nomMachine + "(0) " + boite.toString();
    }
}
