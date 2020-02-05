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
        music.getClip().stop();
        music.setVolume(10);
        Mapa map = new Mapa("mapa.json");

        Menu_Inicial menu_Inicial = new Menu_Inicial(map);
        if (menu_Inicial.isVisible()) {
            music.getClip().setMicrosecondPosition(0);
            music.getClip().start();
        }
    }
}
