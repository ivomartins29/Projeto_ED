package Jogo;

import Mapa.Mapa;

/**
 *
 * @author 8150121 e 8150133
 */
public class Main {

    /**
     * Método que inicia o programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Music music = new Music();
        music.readMusic("Megalovania.wav");
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
