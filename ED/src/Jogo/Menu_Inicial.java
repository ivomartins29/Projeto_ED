package Jogo;

import Exceptions.ElementNotFoundException;
import Mapa.Jogador;
import Mapa.Mapa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe da interface gráfica do menu inicial.
 *
 * @author 8150121 e 8150133
 */
public class Menu_Inicial extends javax.swing.JFrame {

    private final String DEFAULT_MAP = "mapa.json";
    private Mapa leitura;
    private Jogador util;

    /**
     * Método construtor da classe Menu_Inicial.
     *
     * @param m mapa fornecido
     */
    public Menu_Inicial(Mapa m) {
        leitura = m;
        initComponents();
        setVisible(true);
    }

    /**
     * Método que cria a interface gráfica da classe Menu_Inicial.
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
        jButton1.setText("Jogar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Novo  Mapa ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(70, 70, 70));
        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME!!");

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
        this.setLocationRelativeTo(null);
    }

    /**
     * Método que fecha a interface gráfica.
     *
     * @param evt evento realizado quando o botão é pressionado
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Hope you enjoyed!!!");
        dispose();
    }

    /**
     * Método que pede o nome do ficheiro que contém mapa ao utilizador.
     *
     * @param evt evento realizado quando o botão é pressionado
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String s = JOptionPane.showInputDialog("Digite o nome do ficherio que contém o mapa:\n(EXAMPLE: mapa.json)");
        try {
            leitura = new Mapa(s);
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Menu_Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que abre uma nova interface gráfica ("Menu_Jogo") e 
     * pede o nome de utilizador ao jogador
     *
     * @param evt evento realizado quando o botão é pressionado
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        util = new Jogador();
        String nome = JOptionPane.showInputDialog("Digite o seu nome de usuário:");
        if (nome == null) {
            util.setNome(" ");
        } else {
            util.setNome(nome);
        }

        if (leitura == null) {
            try {
                leitura = new Mapa(DEFAULT_MAP);
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(Menu_Inicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Menu_Jogo mJ = new Menu_Jogo(leitura, util);
        mJ.setVisible(true);
        dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;

    /**
     * Get do Mapa leitura.
     * 
     * @return leitura
     */
    public Mapa getLeitura() {
        return leitura;
    }

    /**
     * Set do Mapa Leitura
     * 
     * @param leitura novo mapa
     */
    public void setLeitura(Mapa leitura) {
        this.leitura = leitura;
    }

}
