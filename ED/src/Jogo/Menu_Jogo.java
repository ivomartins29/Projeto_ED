package Jogo;

import Exception.ElementNotFoundException;
import Mapa.Jogador;
import Mapa.Mapa;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe da interface gráfica do menu de modo de jogo.
 *
 * @author 8150121 e 8150133
 */
public class Menu_Jogo extends javax.swing.JFrame {

    private Mapa mapa;
    private Jogador util;

    /**
     * Método construtor da classe Menu_Jogo.
     *
     * @param m mapa fornecido
     * @param util novo jogador
     */
    public Menu_Jogo(Mapa m, Jogador util) {
        this.mapa = m;
        this.util = util;
        initComponents();
        setVisible(true);
    }

    /**
     * Método que cria a interface gráfica da classe Menu_Jogo.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 200, 200));
        setSize(new java.awt.Dimension(450, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(getWidth() - 50, getHeight() - 50));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Manual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Menu_Jogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Simulação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(70, 70, 70));
        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modo de Jogo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addGap(7, 7, 7)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addGap(7, 7, 7)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addGap(45, 45, 45))
        );

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
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Método que fecha a interface gráfica e abre a interface gráfica
     * Menu_Inicial
     *
     * @param evt evento realizado quando o botão é pressionado
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Menu_Inicial mI = new Menu_Inicial(new Mapa(mapa.getNome_ficheiro()));
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Menu_Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    /**
     * Método que fecha a interface gráfica e abre a interface gráfica
     * Simulação
     *
     * @param evt evento realizado quando o botão é pressionado
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Simulacao simulacao = new Simulacao(new Mapa(mapa.getNome_ficheiro()), util);
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Menu_Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    /**
     * Método que fecha a interface gráfica e abre a interface gráfica
     * Manuals
     *
     * @param evt evento realizado quando o botão é pressionado
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
        try {
            Manual manual = new Manual(new Mapa(mapa.getNome_ficheiro()), util);
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Menu_Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}
