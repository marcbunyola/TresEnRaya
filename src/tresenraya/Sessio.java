package tresenraya;

import java.util.Random;

/**
 *
 * @author marcbunyola
 */
public class Sessio {

//atributs
    private Jugador jugador;
    private JugadorIA jugadorIA;
    private Partida partida;
    private Marcador marcador;
    private UI interficie;

//constructor
    public Sessio() {
        interficie = new GUI();
        jugador = new Jugador(this.interficie);
        jugadorIA = new JugadorIA(this.interficie);
        marcador = new Marcador(this.interficie);

    }

//mètodes
    //per iniciar la partida
    public void iniciar() {
        jugador.setNom(interficie.nomJugador());
        int temp;
        int fin = 5;
        while (fin != this.menu()) {        //entrarà al while fins que l'usuari introdueixi 5 (s'acabarà el programa)
            if (sorteig() == 1) {
                partida = new Partida(jugador, jugadorIA, marcador, interficie);    //crea la partida segons el sorteig per saber qui començarà
            } else {
                partida = new Partida(jugadorIA, jugador, marcador, interficie);
            }
            this.jugadorIA.setTaulell(this.partida.getTaulell());
            temp = partida.jugar();
        }
    }

    //crea la IA segons el nivell introduit al menu, que es troba a la UI
    public int menu() {
        int n = 0;
        switch (interficie.nivellDificultat(jugador.getNom())) {
            case 0:
                this.jugadorIA = new JugadorIA(this.interficie);
                n = 0;
                return n;
            case 1:
                this.jugadorIA = new JugadorIA1(this.interficie);
                n = 1;
                return n;
            case 2:
                this.jugadorIA = new JugadorIA2(this.interficie);
                n = 2;
                return n;
            case 3:
                this.jugadorIA = new JugadorIA3(this.interficie);
                n = 3;
                return n;
            case 4:
                this.jugadorIA = new JugadorIA4(this.interficie);
                n = 4;
                return n;
            case 5:
                System.exit(0);
            default:
                interficie.warning(jugador.getNom());
                interficie.nivellDificultat(jugador.getNom());
        }
        return n;
    }

    //random que retorna 0 o 1
    public int sorteig() {
        int numeroAleatori;
        Random r1 = new Random();
        numeroAleatori = r1.nextInt(2);
        return numeroAleatori;
    }
}
