package tresenraya;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author marcbunyola
 */
public class GUI extends UI {

//atributs
    Label texteVictories = new Label();
    Label texteDerrotes = new Label();
    Label texteEmpats = new Label();
    Label texteEstat = new Label();
    Label texteWarning = new Label();
    Label texteWarning2 = new Label();
    Label texteNivellIA = new Label();
    Font fuente = new Font("Arial", Font.BOLD, 30);
    Font fuente2 = new Font("Arial", Font.PLAIN, 17);
    JButton boto = new JButton();
    JButton[][] arrayBotons = new JButton[3][3];
    String[][] valorCaselles = new String[3][3];
    Posicion buzon;
    String buzon2;
    String nom;
    int auxiliar = 0;
    int nivellIA;

//constructor
    public GUI() {
        mostrarFinestra();
    }

//mètodes
    //actualitza el marcador
    @Override
    public void actualitzarMarcador(int victories, int derrotes, int empats) {
        texteVictories.setSize(130, 20);
        texteVictories.setLocation(25, 5);
        texteVictories.setFont(fuente2);
        texteDerrotes.setSize(130, 20);
        texteDerrotes.setLocation(25, 45);
        texteDerrotes.setFont(fuente2);
        texteEmpats.setSize(130, 20);
        texteEmpats.setLocation(25, 85);
        texteEmpats.setFont(fuente2);
        texteVictories.setText("Victories: " + victories);
        texteDerrotes.setText("Derrotes: " + derrotes);
        texteEmpats.setText("Empats: " + empats);
    }

    //informa de l'estat de la partida
    @Override
    public void estatPartida(int partidaFinalitzada) {
        texteEstat.setSize(150, 50);
        texteEstat.setLocation(0, 0);
        texteEstat.setFont(fuente2);
        texteNivellIA.setSize(150, 50);
        texteNivellIA.setLocation(20, 0);
        texteNivellIA.setFont(fuente2);
        if (partidaFinalitzada == -1) {
            texteEstat.setText("Partida en curs.");
            texteNivellIA.setText("Nivell de dificultat: " + nivellIA + ".");
        } else {
            texteEstat.setText("Partida finalitzada.");
            texteNivellIA.setText("Nivell de dificultat: " + nivellIA + ".");
        }
    }

    //reinicia el taulell abans de començar una nova partida
    @Override
    public void reiniciar() {
        boto.setBackground(Color.green);
        boto.setText("INICIAR");
        boto.setFont(fuente);
        buzon2 = null;
        while (buzon2 == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
        int fil, col;
        for (fil = 0; fil < 3; fil++) {
            for (col = 0; col < 3; col++) {
                valorCaselles[fil][col] = "";
                caselles[fil][col] = 0;
                arrayBotons[fil][col].setText(valorCaselles[fil][col]);
                arrayBotons[fil][col].setFont(fuente);
            }
        }
        texteWarning.setText("");
        texteWarning2.setText("");
        auxiliar++;
    }

    //per introduïr el nivell de la IA abans de começar una partida
    @Override
    public int nivellDificultat(String nom) {
        if (auxiliar > 0) {
            boto.setText("REINICIAR");
            boto.setFont(fuente);
            boto.setBackground(Color.red);
            buzon2 = null;
            while (buzon2 == null) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                }
            }
        }
        buzon2 = null;
        Object[] nivells = {0, 1, 2, 3, 4, 5};
        nivellIA = (int) JOptionPane.showInputDialog(null, "Tria el nivell de dificultat: \n"
                + " + 0: Nivell fàcil\n"
                + " + 1: Nivell mig\n"
                + " + 2: Nivell difícil\n"
                + " + 3: Nivell molt difícil\n"
                + " + 4: Nivell professional\n"
                + " + 5: Nivell aleatori\n"
                + "\n"
                + "", "", JOptionPane.QUESTION_MESSAGE, null, nivells, nivells[0]);
        if (nivellIA == 5) {
            Random r1 = new Random();
            nivellIA = r1.nextInt(5);
        }
        return nivellIA;

    }

    //demanarà el nom al jugador i el guardarà
    @Override
    public String nomJugador() {
        nom = JOptionPane.showInputDialog("Benvingut al joc TRES EN RAYA. Com et dius?");
        return nom;
    }

    //posa la fitxa al taulell i actualitza el taulell
    @Override
    void posarFicha(Posicion p, int jugador) {
        caselles[p.getFil()][p.getCol()] = jugador;
        int fil, col;
        for (fil = 0; fil < 3; fil++) {
            for (col = 0; col < 3; col++) {
                switch (caselles[fil][col]) {
                    case 1:
                        valorCaselles[fil][col] = "X";
                        break;
                    case 2:
                        valorCaselles[fil][col] = "O";
                        break;
                    default:
                        valorCaselles[fil][col] = "";
                        break;
                }
                arrayBotons[fil][col].setText(valorCaselles[fil][col]);
                arrayBotons[fil][col].setForeground(Color.white);
            }
        }
    }

    //demana la posició al jugador (fila i columna)
    @Override
    public Posicion moviment(String nom) {
        buzon = null;
        while (buzon == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
        return buzon;
    }

    //missatge d'error que apareix quan el jugador s'ha equivocat
    @Override
    public void warning(String nom) {
        texteWarning.setLocation(5, 15);
        texteWarning.setSize(270, 20);
        texteWarning.setFont(fuente2);
        texteWarning.setText(nom + ", t'has equivocat...");
        texteWarning2.setLocation(5, 40);
        texteWarning2.setSize(270, 20);
        texteWarning2.setFont(fuente2);
        texteWarning2.setText("Per favor, introdueix valors vàlids");
    }

    //taulells:
    //crea el panell marcador
    private JPanel marcador() {
        JPanel marcador = new JPanel();
        marcador.add(texteVictories);
        marcador.add(texteDerrotes);
        marcador.add(texteEmpats);
        marcador.setSize(175, 110);
        marcador.setLocation(300, 95);
        marcador.setBackground(Color.ORANGE);
        marcador.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.darkGray));
        return marcador;
    }

    //crea el panell taulell
    private JPanel taulell() {
        int i, j;
        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(5);
        gl.setVgap(5);
        JPanel taulell = new JPanel(gl);
        taulell.setSize(280, 280);
        taulell.setLocation(10, 10);
        taulell.setBackground(Color.white);
        for (i = 0; i < caselles.length; i++) {
            for (j = 0; j < caselles.length; j++) {
                arrayBotons[i][j] = new JButton();
                arrayBotons[i][j].setBackground(Color.DARK_GRAY);
                taulell.add(arrayBotons[i][j]);

            }
        }
        //no deixa ficar variables (i, j) dins dels events, per això hi ha un event per cada casella
        arrayBotons[0][0].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(0, 0);
        });
        arrayBotons[0][1].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(0, 1);
        });
        arrayBotons[0][2].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(0, 2);
        });
        arrayBotons[1][0].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(1, 0);
        });
        arrayBotons[1][1].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(1, 1);
        });
        arrayBotons[1][2].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(1, 2);
        });
        arrayBotons[2][0].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(2, 0);
        });
        arrayBotons[2][1].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(2, 1);
        });
        arrayBotons[2][2].addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon = new Posicion(2, 2);
        });
        return taulell;
    }

    //crea el panell estat
    private JPanel estat() {
        JPanel estat = new JPanel();
        estat.add(texteEstat);
        estat.add(texteNivellIA);
        estat.setSize(280, 70);
        estat.setLocation(10, 300);
        estat.setBackground(Color.orange);
        estat.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.darkGray));
        return estat;
    }

    //crea el panell warning
    private JPanel warning() {
        JPanel warning = new JPanel();
        warning.add(texteWarning);
        warning.add(texteWarning2);
        warning.setSize(280, 70);
        warning.setLocation(10, 380);
        warning.setBackground(Color.orange);
        warning.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.darkGray));
        return warning;
    }

    //crea el panell iniciar
    private JPanel iniciar() {
        JPanel iniciar = new JPanel();
        boto.setSize(100, 100);
        iniciar.setSize(175, 215);
        iniciar.setLocation(300, 350);
        iniciar.setBackground(Color.blue);
        boto.setBackground(Color.green);
        boto.setText("INICIAR");
        boto.setFont(fuente);
        iniciar.add(boto);
        boto.addActionListener((java.awt.event.ActionEvent evt) -> {
            buzon2 = "ARA";
        });
        boto.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.darkGray));
        return iniciar;
    }

    //crea el panell fons
    private JPanel fons() {
        JPanel fons = new JPanel();
        fons.setBackground(Color.blue);
        return fons;
    }

    //crea la finestra, crea un container de la finestra, i fica els panells al container
    private void mostrarFinestra() {
        javax.swing.JFrame j = new javax.swing.JFrame("TRES EN RAYA");
        j.setResizable(false);
        j.setSize(490, 490);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Container cp = j.getContentPane();
        cp.add(taulell());
        cp.add(marcador());
        cp.add(estat());
        cp.add(warning());
        cp.add(iniciar());
        cp.add(fons());
        j.setVisible(true);
    }
}
