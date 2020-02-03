package ed_t;

import java.awt.Color;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Mapa map = new Mapa("mapa.json");
        Utilizadores util = new Utilizadores();
        String nome = (String) JOptionPane.showInputDialog("Digite o seu nome de usuário:");
        util.setNome(nome);
        Menu_Inicial menu_Inicial = new Menu_Inicial(map, util);
    }
}
