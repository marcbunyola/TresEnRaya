/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

/**
 *
 * @author marcbunyola
 */
public class JugadorIA4 extends JugadorIA3 {

//constructor
    public JugadorIA4(UI interficie) {
        super(interficie);
        this.interficie = interficie;
    }

//mètodes
    //mira si pot guanyar, sino mira si pot evitar que guanyis, sino posa la fitxa allà on hi ha més prioritat
    @Override
    public Posicion triaPosicio() {
        if (intentarGuanyar() == null) {
            if (noPerdre() == null) {
                return prioritat();
            }
            return noPerdre();
        }
        return intentarGuanyar();
    }

    //mètode que tria la posició en referència a la prioritat
    public Posicion prioritat() {
        Posicion p;
        int i, j, k;
        if (taulell.complet()) {    //mira si hi ha alguna posicio lliure
            return null;
        } else {
            for (k = 4; k > -1; k--) {
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        if (this.posprioritat()[i][j] == k) {
                            if (taulell.consultar(i, j)) {
                                p = new Posicion(i, j);
                                return p;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //retorna un array de prioritats segons les fitxes que ha posat el jugador
    public int[][] posprioritat() {
        int[][] prioritat = {{3, 2, 3}, {2, 4, 2}, {3, 2, 3}};
        int i, j;
        if (taulell.consultarJugador(1, 1)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[1][1] = -1;
        }
        if (taulell.consultarJugador(0, 0)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[0][0] = -1;
            prioritat[1][2] += 1;
            prioritat[2][1] += 1;
        }
        if (taulell.consultarJugador(0, 2)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[0][2] = -1;
            prioritat[1][0] += 1;
            prioritat[2][1] += 1;
        }
        if (taulell.consultarJugador(2, 0)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[2][0] = -1;
            prioritat[0][1] += 1;
            prioritat[1][2] += 1;
        }
        if (taulell.consultarJugador(2, 2)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[2][2] = -1;
            prioritat[0][1] += 1;
            prioritat[1][0] += 1;
        }
        if (taulell.consultarJugador(0, 1)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[0][1] = -1;
            prioritat[1][0] += 1;
            prioritat[2][0] += 1;
            prioritat[1][2] += 1;
            prioritat[2][2] += 1;
        }
        if (taulell.consultarJugador(2, 1)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[2][1] = -1;
            prioritat[1][0] += 1;
            prioritat[0][0] += 1;
            prioritat[1][2] += 1;
            prioritat[0][2] += 1;
        }
        if (taulell.consultarJugador(1, 0)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[1][0] = -1;
            prioritat[0][1] += 1;
            prioritat[0][2] += 1;
            prioritat[2][1] += 1;
            prioritat[2][2] += 1;
        }
        if (taulell.consultarJugador(1, 2)) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    prioritat[i][j] -= 1;
                }
            }
            prioritat[1][2] = -1;
            prioritat[0][0] += 1;
            prioritat[0][1] += 1;
            prioritat[2][0] += 1;
            prioritat[2][1] += 1;
        }
        return prioritat;
    }
}
