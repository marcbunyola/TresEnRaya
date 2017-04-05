package tresenraya;

/**
 *
 * @author marcbunyola
 */
public class Posicion {

    //atributs
    private int fil, col;

    //constructor
    public Posicion(int f, int c) {
        fil = f;
        col = c;
    }

    //mètodes
    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
