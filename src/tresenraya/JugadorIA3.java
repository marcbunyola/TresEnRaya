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
public class JugadorIA3 extends JugadorIA2 {

//constructor
    public JugadorIA3(UI interficie) {
        super(interficie);
        this.interficie = interficie;
    }

//mètodes
    //mira si pot guanyar, sino mira si pot evitar que guanyis, sino posa a la posició més estratègica
    @Override
    public Posicion triaPosicio() {
        if (this.intentarGuanyar() == null) {
            if (noPerdre() == null) {
                return posEstrategica();
            }
            return noPerdre();
        }
        return this.intentarGuanyar();
    }

    //mira si pot evitar que guanyis
    public Posicion noPerdre() {
        Posicion p;
        int i, j;
        if (taulell.complet()) {    //mira si hi ha alguna posicio lliure
            return null;
        } else {
            if (taulell.consultarJugador(1, 1)) {   //si hi ha el jugador enmig
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(1, i)) {
                        if (taulell.consultar(1, j)) {
                            p = new Posicion(1, j);
                            return p;
                        }
                    }
                }
                for (i = 0, j = 2; i < 3; i++, j--) { //quan i=0 j=2 quan i=1 j=1 quan i=2 j=0                   
                    if (taulell.consultarJugador(0, i)) {
                        if (taulell.consultar(2, j)) {
                            p = new Posicion(2, j);
                            return p;
                        }
                    }
                    if (taulell.consultarJugador(2, i)) {
                        if (taulell.consultar(0, j)) {
                            p = new Posicion(0, j);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(1, 1) && !taulell.consultarIA(1, 1)) {   //si no hi ha la ia enmig ni el jugador
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(1, i) && taulell.consultarJugador(1, j)) {
                        if (taulell.consultar(1, 1)) {
                            p = new Posicion(1, 1);
                            return p;
                        }
                    }
                }
                for (i = 0, j = 2; i < 3; i++, j--) { //quan i=0 j=2 quan i=1 j=1 quan i=2 j=0                   
                    if (taulell.consultarJugador(0, i) && taulell.consultarJugador(2, j)) {
                        if (taulell.consultar(1, 1)) {
                            p = new Posicion(1, 1);
                            return p;
                        }
                    }
                    if (taulell.consultarJugador(0, j) && taulell.consultarJugador(2, i)) {
                        if (taulell.consultar(1, 1)) {
                            p = new Posicion(1, 1);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarJugador(1, 0)) {  //si el jugador està enmig a la dreta
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(i, 0)) {
                        if (taulell.consultar(j, 0)) {
                            p = new Posicion(j, 0);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(1, 0) && !taulell.consultarIA(1, 0)) {  //si la ia i el jugador no estan enmig a la dreta
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(i, 0) && taulell.consultarJugador(j, 0)) {
                        if (taulell.consultar(1, 0)) {
                            p = new Posicion(1, 0);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarJugador(1, 2)) {  //si el jugador està enmig a la esquerra
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(i, 2)) {
                        if (taulell.consultar(j, 2)) {
                            p = new Posicion(j, 2);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(1, 2) && !taulell.consultarIA(1, 2)) {  //si la ia i el jugador no estan enmig a la esquerra
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(i, 2) && taulell.consultarJugador(j, 2)) {
                        if (taulell.consultar(1, 2)) {
                            p = new Posicion(1, 2);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarJugador(0, 1)) {  //si el jugador està enmig adalt
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(0, i)) {
                        if (taulell.consultar(0, j)) {
                            p = new Posicion(0, j);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(0, 1) && !taulell.consultarIA(0, 1)) {  //si la ia i el jugador no estan enmig adalt
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(0, i) && taulell.consultarJugador(0, j)) {
                        if (taulell.consultar(0, 1)) {
                            p = new Posicion(0, 1);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarJugador(2, 1)) {  //si el jugador està enmig abaix
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(2, i)) {
                        if (taulell.consultar(2, j)) {
                            p = new Posicion(2, j);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(2, 1) && !taulell.consultarIA(2, 1)) {  //si la ia i el jugador no estan enmig abaix
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarJugador(2, i) && taulell.consultarJugador(2, j)) {
                        if (taulell.consultar(2, 1)) {
                            p = new Posicion(2, 1);
                            return p;
                        }
                    }
                }
            }
        }

        return null;
    }
}
