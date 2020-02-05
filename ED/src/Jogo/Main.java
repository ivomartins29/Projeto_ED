package Jogo;

import Mapa.Jogador;
import Mapa.Mapa;
<<<<<<< HEAD
import javax.swing.JOptionPane;

/**
 *
 * @author 8150121 e 8150133
 */
=======
import java.awt.Color;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

>>>>>>> 026de2582b704c9fc3ac69cc75b8d5b641e0a441
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Music music = new Music();
        music.playMusic("Megalovania.wav");
        
        Mapa map = new Mapa("mapa.json");
        Jogador util = new Jogador();
        String nome = (String) JOptionPane.showInputDialog("Digite o seu nome de usuário:");
        if (nome == null) {
            util.setNome("No Name");
        } else {
            util.setNome(nome);
        }
        Menu_Inicial menu_Inicial = new Menu_Inicial(map, util);
    }
}
