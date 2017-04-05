package tresenraya;

/**
 *
 * @author marcbunyola
 */
public class Jugador {

//atributs
    protected int tipusFitxa;
    private UI interficie;
    private String nom;

//constructor
    public Jugador(UI interficie) {
        this.interficie = interficie;
    }

//mètodes
    //crida el mètode posarFitxa de la UI, el qual ens proporciona la posició introduïda pel jugador
    public Posicion triaPosicio() {
        Posicion p;
        p = interficie.moviment(this.getNom());
        return p;
    }

    //proporciona el nom
    public String getNom() {
        return nom;
    }

    //permet modificar el nom del jugador, el qual s'introdueix a la sessió
    public void setNom(String nom) {
        this.nom = nom;
    }

    //permet modificar el tipus de fitxa del jugador a la partida
    public void setTipusFitxa(int tipusFitxa) {
        this.tipusFitxa = tipusFitxa;
    }
}
