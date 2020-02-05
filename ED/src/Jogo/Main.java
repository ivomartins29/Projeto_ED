package Jogo;

import Mapa.Jogador;
import Mapa.Mapa;
import javax.swing.JOptionPane;

/**
 *
 * @author 8150121 e 8150133
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
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
