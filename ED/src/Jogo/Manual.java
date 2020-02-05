package Jogo;

import Mapa.ArrayOrderedUti;
import Collection.ArrayUnorderedList;
import Exceptions.ElementNotFoundException;
import Mapa.Aposentos;
import Mapa.Jogador;
import Mapa.Mapa;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe da interface gráfica do modo de jogo manual.
 *
 * @author 8150121 e 8150133
 */
public class Manual extends JFrame {

    private Mapa mapa;
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private Jogador util;
    private Aposentos divisao;
    private JButton jButton1;

    private String resposta;
    private String divisoes;
    private ArrayUnorderedList list;
    private Iterator<Aposentos> itr;
    private ArrayOrderedUti<Jogador> jogadores;
    private Aposentos lig;
    double tempoInicial;
    double tempoFinal;

    /**
     * Método construtor da classe Manual.
     *
     * @param m mapa fornecido
     * @param util novo jogador
     */
    public Manual(Mapa m, Jogador util) throws FileNotFoundException {

        mapa = m;
        this.util = util;
        String temp = null;
        do {
            temp = JOptionPane.showInputDialog("Escolha a dificuldade\n"
                    + "1: Básico\n2: Normal\n3: Dificíl");
        } while (!temp.equals("1") && !temp.equals("2") && !temp.equals("3"));
        m.getNetwork().multiplicar_adjmatrizweight(Integer.parseInt(temp));
        initComponents();
        setVisible(true);
    }

    /**
     * Método que cria a interface gráfica da classe Manual.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        divisao = isEntry(mapa);
        util.setPontos(mapa.getPontos());

        setTitle(mapa.getNome());

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 200, 200));
        setSize(new java.awt.Dimension(450, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setSize(new java.awt.Dimension(this.getWidth() - 50, this.getHeight() - 50));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome: " + util.getNome());

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pontos: " + util.getPontos());

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Divisão Atual: " + divisao.getNome());

        jTextField1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Digite o nome da próxima divisão:");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(92, 92, 92))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jTextField1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 75, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{jButton1, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jTextField1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        divisoes = null;
        list = mapa.getNetwork().getNeighbors(divisao);
        itr = list.iterator();
        lig = null;
        lig = itr.next();
        divisoes = lig.getNome();

        jLabel4.setText(divisoes);
        util.setMapa(mapa.getNome());

        tempoInicial = System.currentTimeMillis();

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Método que atualiza os dados do jogo no JFrame caso as condições sejam
     * válidas.
     *
     * @param evt evento realizado quando clicado no botão
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jogadores = new ArrayOrderedUti<>();
        try {
            lerFicheiro();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manual.class.getName()).log(Level.SEVERE, null, ex);
        }
        resposta = jTextField1.getText();
        Iterator<Aposentos> itr2 = list.iterator();
        while (itr2.hasNext()) {
            lig = itr2.next();
            if (resposta.equals(lig.getNome())) {
                util.setPontos(util.getPontos() - (long) mapa.getNetwork().getAdjMatrixConnectionCost()[mapa.getNetwork().getVertexIndex(divisao)][mapa.getNetwork().getVertexIndex(lig)]);

                jLabel1.setText("Nome: " + util.getNome());
                jLabel2.setText("Pontos: " + util.getPontos());
                jLabel3.setText("Divisão: " + resposta);

                divisao = (Aposentos) mapa.getNetwork().getVertices()[mapa.getNetwork().getVertexIndex(lig)];

                divisoes = "";
                list = mapa.getNetwork().getNeighbors(divisao);
                itr = list.iterator();
                lig = null;
                while (itr.hasNext()) {
                    lig = itr.next();
                        divisoes = divisoes + " - " + lig.getNome();
                }
                jTextField1.setText("");
                jLabel4.setText(divisoes);

                if (resposta.equals("exterior")) {
                    exterior_reached();
                }
            }
        }

        if (util.getPontos() <= 0) {
            double tempoFinal = System.currentTimeMillis();
            double i = 1000.0;
            util.setTimeDuration(((tempoFinal - tempoInicial) / i));

            JOptionPane.showMessageDialog(null, "MORREU!");

            jogadores.add(util);
            try {
                guardarClassificacaoJogador();
            } catch (IOException ex) {
                Logger.getLogger(Manual.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Menu_Inicial mI = new Menu_Inicial(new Mapa(mapa.getNome_ficheiro()));
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(Manual.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }

    /**
     * Método que termina a interface gráfica Manual e abre Menu_Inicial,
     * guardando os dados do jogador.
     */
    public void exterior_reached() {
        double tempoFinal = System.currentTimeMillis();
        double i = 1000.0;
        util.setTimeDuration(((tempoFinal - tempoInicial) / i));

        JOptionPane.showMessageDialog(null, "Parabéns " + util.getNome() + ", concluiste o mapa '" + util.getMapa() + "' com " + util.getPontos() + " Pontos !!!\n"
                + "Acabou o mapa em: " + util.getTimeDuration() + " segundos");
        jogadores.add(util);
        try {
            guardarClassificacaoJogador();
        } catch (IOException ex) {
            Logger.getLogger(Manual.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Menu_Inicial mI = new Menu_Inicial(new Mapa(mapa.getNome_ficheiro()));
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Manual.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    /**
     * Método que pesquisa no mapa fornecido o aposento em que será iniciado o
     * jogo.
     *
     * @param m mapa que irá ser pesquisado
     * @return o aposento que tem como nome "entrada"
     */
    public Aposentos isEntry(Mapa m) {
        Aposentos ap = null;
        for (int i = 0; i < m.getNetwork().getCount(); i++) {
            ap = (Aposentos) m.getNetwork().getVertices()[i];
            if (ap.getNome().equals("entrada")) {
                return ap;
            }
        }
        return ap;
    }

    /**
     * Método que guarda num ficheiro CSV o dados do jogador.
     *
     */
    public void guardarClassificacaoJogador() throws IOException {
        FileWriter x = new FileWriter("Classificacoes.csv");
        x.write("Nome, Mapa, Pontos, Duracao \n");

        Iterator<Jogador> itr = jogadores.iterator();

        while (itr.hasNext()) {
            util = itr.next();
            try {
                x.write("" + util.getNome() + "," + util.getMapa() + "," + util.getPontos() + "," + util.getTimeDuration() + "\n");
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }
        x.close();
    }

    /**
     * Método que lé os daods do ficheiro "Classificacoes.csv", e conforme vai
     * lendo adiciona ao ArrayOrderedUti.
     *
     */
    public void lerFicheiro() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("Classificacoes.csv"));
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] variavel = scanner.nextLine().split(",");
            Jogador uti2 = new Jogador();
            uti2.setNome(variavel[0]);
            uti2.setMapa(variavel[1]);
            uti2.setPontos((Integer.parseInt(variavel[2])));
            uti2.setTimeDuration((Integer.parseInt(variavel[2])));
            jogadores.add(uti2);
        }
    }
}
