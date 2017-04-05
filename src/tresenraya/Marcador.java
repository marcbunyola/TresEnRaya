package tresenraya;

/**
 *
 * @author marcbunyola
 */
public class Marcador {

    //atributs    
    private int victories = 0;
    private int derrotes = 0;
    private int empats = 0;
    private UI interficie;

//constructor
    public Marcador(UI interficie) {
        this.interficie = interficie;
    }

//mètodes que modifiquen els contadors del marcador i criden al mètode que imprimirà el marcador
    //suma victòries
    public void victoria() {
        this.victories++;
        this.interficie.actualitzarMarcador(victories, derrotes, empats);
    }

    //suma derrotes
    public void derrota() {
        this.derrotes++;
        this.interficie.actualitzarMarcador(victories, derrotes, empats);
    }

    //suma empats
    public void empats() {
        this.empats++;
        this.interficie.actualitzarMarcador(victories, derrotes, empats);
    }
}
