package Jogo;

import Exception.ElementNotFoundException;
import Mapa.Aposentos;
import Mapa.Jogador;
import Mapa.Mapa;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 8150121 e 8150133
 */
public class Simulacao extends JFrame {

    private Mapa mapa;
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private Jogador util;
    private Aposentos divisao;
    private Aposentos saida;
    private JButton jButton1;

    private String divisoes;
    private Iterator<Aposentos> itr;
    private Aposentos lig;

    /**
     *
     * @param m
     * @param util
     */
    public Simulacao(Mapa m, Jogador util) {
        mapa = m;
        this.util = util;
        String temp = null;
        do {
            temp = (String) JOptionPane.showInputDialog("Escolha a dificuldade\n"
                    + "1: Básico\n2: Normal\n3: Dificíl");
        } while (!temp.equals("1") && !temp.equals("2") && !temp.equals("3"));
        mapa.getNetwork().multiplicar_adjmatrizweight(Integer.parseInt(temp));
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")                        
    private void initComponents() {
        divisao = isEntry(mapa);
        saida = isExterior(mapa);

        util.setPontos(mapa.getPontos());
        System.out.println(util.getPontos());
        setTitle(mapa.getNome());

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 200, 200));
        setSize(new java.awt.Dimension(450, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(getWidth() - 50, getHeight() - 50));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome: " + util.getNome());

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Divisão Inicial: " + divisao.getNome());

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Caminho com menor custo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(122, 122, 122)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 75, Short.MAX_VALUE))
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
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{jButton1, jLabel1, jLabel2, jLabel3, jLabel4});

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

        divisoes = "";
        divisao = isEntry(mapa);
        saida = isExterior(mapa);

        jLabel2.setText("Pontos Finais: ");
        try {
            itr = mapa.getNetwork().iteratorShortestPathConnectionCost(divisao, saida);
        } catch (Exception ex) {
            Logger.getLogger(Simulacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        lig = null;
        itr.next();
        while (itr.hasNext()) {
            lig = itr.next();
            if (lig.getFantasma() > 0) {
                divisoes = divisoes + " - " + lig.getNome() + " (fantasma)";
            } else {
                divisoes = divisoes + " - " + lig.getNome();
            }
            System.out.println(divisao.getNome());
            util.setPontos(util.getPontos() - (long) mapa.getNetwork().getAdjMatrixConnectionCost()[mapa.getNetwork().getVertexIndex(divisao)][mapa.getNetwork().getVertexIndex(lig)]);
            System.out.println(util.getPontos());
            divisao = (Aposentos) mapa.getNetwork().getVertices()[mapa.getNetwork().getVertexIndex(lig)];
        }
        jLabel2.setText("Pontos Finais: " + util.getPontos());
        jLabel4.setText(divisoes);

        pack();
        setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Menu_Inicial menu_Inicial = new Menu_Inicial(new Mapa(mapa.getNome_ficheiro()));
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Simulacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    /**
     *
     * @param m
     * @return
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
     *
     * @param m
     * @return
     */
    public Aposentos isExterior(Mapa m) {
        Aposentos ap = null;
        for (int i = 0; i < m.getNetwork().getCount(); i++) {
            ap = (Aposentos) m.getNetwork().getVertices()[i];
            if (ap.getNome().equals("exterior")) {
                return ap;
            }
        }
        return ap;
    }
}
