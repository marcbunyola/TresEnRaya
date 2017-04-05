package tresenraya;

/**
 *
 * @author marcbunyola
 */
//atributs
public class JugadorIA extends Jugador {

    protected Taulell taulell;
    protected int tipusFitxa;
    protected UI interficie;

//constructor

    public JugadorIA(UI interficie) {
        super(interficie);
        this.interficie = interficie;
    }
   

//mètodes
    public void setTaulell(Taulell taulell) {
        this.taulell = taulell;
    }

    public void setTipusFitxa(int tipusFitxa) {
        this.tipusFitxa = tipusFitxa;
    }

    //tria una posicio no ocupada (sa primera que troba)
    @Override
    public Posicion triaPosicio() {
        Posicion p;
        for (int i = 0; i < 3; i++) {   //combinacions de fileres amb columnes (9)
            for (int j = 0; j < 3; j++) {
                if (this.taulell.complet()) {    //mira si hi ha alguna posicio lliure
                    return null;
                }
                if (this.taulell.consultar(i, j)) {  //si hi ha una posicio lliure guarda una posicio
                    p = new Posicion(i, j);
                    return p;
                }
            }
        }
        return null;
    }
}
