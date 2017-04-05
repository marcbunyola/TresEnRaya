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
public class JugadorIA2 extends JugadorIA1 {

//constructor
    public JugadorIA2(UI interficie) {
        super(interficie);
        this.interficie = interficie;
    }

//metodes
    //mira si pot guanyar, i sinó, mira quina es la posició més estratègica
    @Override
    public Posicion triaPosicio() {
        if (intentarGuanyar() == null) {
            return posEstrategica();
        }
        return intentarGuanyar();
    }

    //mira si pot guanyar
    public Posicion intentarGuanyar() {
        Posicion p;
        int i, j;
        if (this.taulell.complet()) {    //mira si hi ha alguna posicio lliure
            return null;
        } else {
            if (this.taulell.consultarIA(1, 1)) {   //si hi ha la ia enmig
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(1, i)) {
                        if (taulell.consultar(1, j)) {
                            p = new Posicion(1, j);
                            return p;
                        }
                    }
                }
                for (i = 0, j = 2; i < 3; i++, j--) { //quan i=0 j=2 quan i=1 j=1 quan i=2 j=0                   
                    if (taulell.consultarIA(0, i)) {
                        if (taulell.consultar(2, j)) {
                            p = new Posicion(2, j);
                            return p;
                        }
                    }
                    if (taulell.consultarIA(2, i)) {
                        if (taulell.consultar(0, j)) {
                            p = new Posicion(0, j);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(1, 1) && !taulell.consultarIA(1, 1)) {   //si no hi ha la ia enmig ni el jugador
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(1, i) && taulell.consultarIA(1, j)) {
                        if (taulell.consultar(1, 1)) {
                            p = new Posicion(1, 1);
                            return p;
                        }
                    }
                }
                for (i = 0, j = 2; i < 3; i++, j--) { //quan i=0 j=2 quan i=1 j=1 quan i=2 j=0                   
                    if (taulell.consultarIA(0, i) && taulell.consultarIA(2, j)) {
                        if (taulell.consultar(1, 1)) {
                            p = new Posicion(1, 1);
                            return p;
                        }
                    }
                    if (taulell.consultarIA(0, j) && taulell.consultarIA(2, i)) {
                        if (taulell.consultar(1, 1)) {
                            p = new Posicion(1, 1);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarIA(1, 0)) {  //si la ia està enmig a la dreta
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(i, 0)) {
                        if (taulell.consultar(j, 0)) {
                            p = new Posicion(j, 0);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(1, 0) && !taulell.consultarIA(1, 0)) {  //si la ia i el jugador no estan enmig a la dreta
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(i, 0) && taulell.consultarIA(j, 0)) {
                        if (taulell.consultar(1, 0)) {
                            p = new Posicion(1, 0);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarIA(1, 2)) {  //si la ia està enmig a la esquerra
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(i, 2)) {
                        if (taulell.consultar(j, 2)) {
                            p = new Posicion(j, 2);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(1, 2) && !taulell.consultarIA(1, 2)) {  //si la ia i el jugador no estan enmig a la esquerra
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(i, 2) && taulell.consultarIA(j, 2)) {
                        if (taulell.consultar(1, 2)) {
                            p = new Posicion(1, 2);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarIA(0, 1)) {  //si la ia està enmig adalt
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(0, i)) {
                        if (taulell.consultar(0, j)) {
                            p = new Posicion(0, j);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(0, 1) && !taulell.consultarIA(0, 1)) {  //si la ia i el jugador no estan enmig adalt
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(0, i) && taulell.consultarIA(0, j)) {
                        if (taulell.consultar(0, 1)) {
                            p = new Posicion(0, 1);
                            return p;
                        }
                    }
                }
            }
            if (taulell.consultarIA(2, 1)) {  //si la ia està enmig abaix
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(2, i)) {
                        if (taulell.consultar(2, j)) {
                            p = new Posicion(2, j);
                            return p;
                        }
                    }
                }
            }
            if (!taulell.consultarJugador(2, 1) && !taulell.consultarIA(2, 1)) {  //si la ia i el jugador no estan enmig abaix
                for (i = 0, j = 2; i < 3; i += 2, j -= 2) {     //quan i=0 j=2 i al reves
                    if (taulell.consultarIA(2, i) && taulell.consultarIA(2, j)) {
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
