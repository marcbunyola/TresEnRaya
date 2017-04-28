package tresenraya;

/**
 *
 * @author marcbunyola
 */
public class Partida {

//atributs
    private Taulell taulell;
    private Marcador marcador;
    private Jugador jugador1;
    private Jugador jugador2;
    private UI interficie;

//constructor
    public Partida(Jugador jugador1, Jugador jugador2, Marcador marcador, UI interficie) {
        taulell = new Taulell(interficie);
        this.jugador1 = jugador1;
        this.jugador1.setTipusFitxa(1);
        taulell.setJugador1(1);
        this.jugador2 = jugador2;
        this.jugador2.setTipusFitxa(2);
        taulell.setJugador2(2);
        this.marcador = marcador;
        this.interficie = interficie;
    }

//mètodes  
    //get que ens serveix perque les IAs hi tenguin acces
    public Taulell getTaulell() {
        return taulell;
    }

    //gestiona els torns dels dos jugadors
    public int jugar() {
        Posicion p;
        int turnoActivo = 0;
        int partidaFinalitzada = -1;
        this.interficie.reiniciar();
        while (partidaFinalitzada == -1) {   //la partida no acaba fins que el mètode comprova no "digui" el contrari
            interficie.estatPartida(partidaFinalitzada);
            if (turnoActivo == 0) {
                p = jugador1.triaPosicio();
                if (!taulell.consultar(p.getFil(), p.getCol())) {
                    this.marcador.derrota();
                    partidaFinalitzada = 1;
                    interficie.warning(jugador1.getNom());
                    break;
                }
                
                this.interficie.setCaselles(this.taulell.getCaselles());
                this.interficie.posarFicha(p, 1);  //valor n indica el tipus de fitxa segons el sorteig de qui comença
                turnoActivo++;
            } else {
                p = jugador2.triaPosicio();
                if (!taulell.consultar(p.getFil(), p.getCol())) {
                    this.marcador.derrota();
                    partidaFinalitzada = 1;
                    interficie.warning(jugador2.getNom());
                    break;
                }
                this.interficie.setCaselles(this.taulell.getCaselles());
                this.interficie.posarFicha(p, 2);  //valor l indica el tipus de fitxa segons el sorteig de qui comença
                turnoActivo--;
            }
            partidaFinalitzada = comprova(); //crida el mètode comprova --> 
        }
        interficie.estatPartida(partidaFinalitzada);
        
        return partidaFinalitzada;
    }

    //comprova si hi ha algun guanyador o algun empat
    public int comprova() {
        switch (taulell.guanyador()) {  //crida al mètode guanyador, que comprovarà si hi ha guanyador o empat
            case 1:
                if (jugador1 instanceof JugadorIA) {
                    this.marcador.derrota();

                } else {
                    this.marcador.victoria();
                }
                return 1;
            case 2:
                if (jugador2 instanceof JugadorIA) {
                    this.marcador.derrota();
                } else {
                    this.marcador.victoria();
                }
                return 2;
            default:
                if (taulell.complet() && taulell.guanyador() == 0) {
                    this.marcador.empats();
                    return 0;
                }
                break;
        }
        return -1;  //la partida no ha acabat perque el mètode guanyador no ha trobat ni guanyador ni empat
    }

}
