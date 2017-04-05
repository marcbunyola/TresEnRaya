package tresenraya;

import java.util.Scanner;

/**
 *
 * @author marcbunyola
 */
public class UI {

//atributs
    protected int[][] caselles = new int[3][3];

//constructor
    public UI() {
    }

//mètodes
    //serveix per imprimir el marcador actualitzat
    public void actualitzarMarcador(int victories, int derrotes, int empats) {
        System.out.println("---------------------------------------------------");
        System.out.println("Victories: " + victories);
        System.out.println("Derrotes: " + derrotes);
        System.out.println("Empats: " + empats);
        System.out.println("---------------------------------------------------");
    }

    //ens va informant segons si la partida està en curs o finalitzada
    public void estatPartida(int partidaFinalitzada) {
        if (partidaFinalitzada == -1) {
            System.out.println("Partida en curs");
        } else {
            System.out.println("Partida finalitzada");
        }
    }

    //permet que el taulell de la UI es modifiqui fora de la classe
    public void iniciar(int caselles[][]) {
        
    }

    public void reiniciar(){
        String s;
        int fil, col;
        for (fil = 0; fil < caselles.length; fil++) {
            System.out.println("");
            for (col = 0; col < caselles.length; col++) {
                switch (caselles[fil][col]) {
                    case 1:
                        s = "X ";
                        break;
                    case 2:
                        s = "O ";
                        break;
                    default:
                        s = "- ";
                        break;
                }
                System.out.print(s);
            }
        }
        System.out.println("");
    }
    
    //per triar la dificultat de la partida
    public int nivellDificultat(String nom) {
        Scanner sc = new Scanner(System.in);
        int nivellIA;
        System.out.println("---------------------------------------------------");
        System.out.println(nom + ", introdueix el nivell de dificultat o surt del programa:");
        System.out.println("0= NIVELL FACIL");
        System.out.println("1= NIVELL MIG");
        System.out.println("2= NIVELL DIFÍCIL");
        System.out.println("3= NIVELL MOLT DIFÍCIL");
        System.out.println("4= NIVELL PROFESSIONAL");
        System.out.println("5= SORTIR");
        System.out.println("---------------------------------------------------");
        nivellIA = sc.nextInt();
        return nivellIA;
    }

    //demana el nom de l'usuari
    public String nomJugador() {
        String nom;
        System.out.println("Benvingut. Per favor, introdueix el teu nom");
        Scanner reader = new Scanner(System.in);
        nom = reader.next();
        return nom;
    }

    //posa la fitxa a la posicio que toca i mostra el taulell
    void posarFicha(Posicion p, int jugador) {
        caselles[p.getFil()][p.getCol()] = jugador;
        String s;
        int fil, col;
        for (fil = 0; fil < caselles.length; fil++) {
            System.out.println("");
            for (col = 0; col < caselles.length; col++) {
                switch (caselles[fil][col]) {
                    case 1:
                        s = "X ";
                        break;
                    case 2:
                        s = "O ";
                        break;
                    default:
                        s = "- ";
                        break;
                }
                System.out.print(s);
            }
        }
        System.out.println("");

    }

    //per demanar i proporcionar la posicio a la qual decideix moure el jugador
    public Posicion moviment(String nom) {
        int f;
        int c;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println(nom + ", te toca! Has d'introduir la posició...");
        System.out.print("Introdueix el nº de fila: ");
        f = sc.nextInt();
        System.out.print("Introdueix el nº de columna: ");
        c = sc.nextInt();
        Posicion p = new Posicion(f, c);
        System.out.println("---------------------------------------------------");
        return p;
    }

    //ens avisa si l'usuari ha introduit un valor erroni
    public void warning(String nom) {
        System.out.println(nom + ", t'has equivocat. Per favor, introdueix el/s valors dins de l'intèrval que s'et demana...");
    }

    public void setCaselles(int[][] caselles) {
        this.caselles = caselles;
    }

    public int[][] getCaselles() {
        return caselles;
    }
    
}
