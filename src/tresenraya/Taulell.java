package tresenraya;

/**
 *
 * @author marcbunyola
 */
public class Taulell {

//atributs
    private static int[][] caselles = new int[3][3];
    private int jugador1;
    private int jugador2;
    private UI interficie;

//constructor
    public Taulell(UI interficie) {
        this.interficie = interficie;
        this.interficie.iniciar(this.caselles);
        int fil, col;
        for (fil = 0; fil < 3; fil++) {
            for (col = 0; col < 3; col++) {
                caselles[fil][col] = 0;
            }
        }
    }



    //mira totes les combinacions a les quals hi ha una victòria
    public int guanyador() {
        //combinacions en les que el jugador guanya
        if ((caselles[0][0] == 1 && caselles[1][0] == 1
                && caselles[2][0] == 1)
                || (caselles[0][1] == 1 && caselles[1][1] == 1
                && caselles[2][1] == 1)
                || (caselles[0][2] == 1 && caselles[1][2] == 1
                && caselles[2][2] == 1)
                || (caselles[0][0] == 1 && caselles[0][1] == 1
                && caselles[0][2] == 1)
                || (caselles[1][0] == 1 && caselles[1][1] == 1
                && caselles[1][2] == 1)
                || (caselles[2][0] == 1 && caselles[2][1] == 1
                && caselles[2][2] == 1)
                || (caselles[0][0] == 1 && caselles[1][1] == 1
                && caselles[2][2] == 1)
                || (caselles[2][0] == 1 && caselles[1][1] == 1
                && caselles[0][2] == 1)) {
            return 1;   // guanyador = jugador1
        }
        //combinacions en les que la IA guanya
        if ((caselles[0][0] == 2 && caselles[1][0] == 2
                && caselles[2][0] == 2)
                || (caselles[0][1] == 2 && caselles[1][1] == 2
                && caselles[2][1] == 2)
                || (caselles[0][2] == 2 && caselles[1][2] == 2
                && caselles[2][2] == 2)
                || (caselles[0][0] == 2 && caselles[0][1] == 2
                && caselles[0][2] == 2)
                || (caselles[1][0] == 2 && caselles[1][1] == 2
                && caselles[1][2] == 2)
                || (caselles[2][0] == 2 && caselles[2][1] == 2
                && caselles[2][2] == 2)
                || (caselles[0][0] == 2 && caselles[1][1] == 2
                && caselles[2][2] == 2)
                || (caselles[2][0] == 2 && caselles[1][1] == 2
                && caselles[0][2] == 2)) {
            return 2;   // guanyador = jugador2
        }
        return 0;   //empat
    }

    //mira si el taulell està complet
    public boolean complet() {
        int cont, fil, col;
        cont = 0;
        for (fil = 0; fil < 3; fil++) {
            for (col = 0; col < 3; col++) {
                if (caselles[fil][col] == 0) {
                    cont++;
                }
            }
        }
        return (cont == 0);
    }

    //indica si hi ha algun jugador a la posició
    public boolean consultar(int fil, int col) {
        boolean r = false;
        if (fil > 2 || col > 2) {
            return false;
        }
        if (caselles[fil][col] == 0) {
            r = true;
        }
        return r;
    }

    //comprova si la casella a la que es mou està lliure
    public boolean validarMoviment(Posicion p) {
        return caselles[p.getFil()][p.getCol()] == 0;   //(si caselles val 0 vol dir que la casella està lliure)
    }

    //ens indica si a la posició hi ha el jugador1
    public boolean consultarJugador(int fil, int col) {
        return caselles[fil][col] == jugador1;
    }

    //ens indica si a la posició hi ha el jugador2
    public boolean consultarIA(int fil, int col) {
        return caselles[fil][col] == jugador2;
    }

    //per indicar quin jugador té la fitxa 1 o 2
    public void setJugador1(int jugador1) {
        this.jugador1 = jugador1;
    }

    //per indicar quin jugador té la fitxa 1 o 2
    public void setJugador2(int jugador2) {
        this.jugador2 = jugador2;
    }

    public int[][] getCaselles() {
        return caselles;
    }

    public void setCaselles(int[][] caselles) {
        this.caselles = caselles;
    }

    
    
}
