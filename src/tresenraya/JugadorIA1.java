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
public class JugadorIA1 extends JugadorIA {

//constructor
    public JugadorIA1(UI interficie) {
        super(interficie);
        this.interficie = interficie;
    }

    //tria la posició més estratègica
    @Override
    public Posicion triaPosicio() {
        return posEstrategica();
    }

    //per trobar la posicio més estratègica
    public Posicion posEstrategica() {
        Posicion p;
        int i, j;
        if (this.taulell.consultar(1, 1)) {     //1,1 (enmig)
            p = new Posicion(1, 1);
            return p; // ======================================================>
        }
        for (i = 0; i < 3; i += 2) {    //0,0; 0,2; 2,0; 2,2 (cantons)
            for (j = 0; j < 3; j += 2) {
                if (this.taulell.consultar(i, j)) {
                    p = new Posicion(i, j);
                    return p;
                }
            }
        }
        for (i = 0, j = 1; i < 2; i++, j--) {    //0,1; 1,0
            if (this.taulell.consultar(i, j)) {
                p = new Posicion(i, j);
                return p;
            }
        }
        for (i = 1, j = 2; i < 3; i++, j--) {   //1,2; 2,1
            if (this.taulell.consultar(i, j)) {
                p = new Posicion(i, j);
                return p;
            }
        }
        return null;
    }
}
