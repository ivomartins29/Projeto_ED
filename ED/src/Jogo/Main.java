package Jogo;

import Mapa.Jogador;
import Mapa.Mapa;
import java.awt.Color;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //Mapa map = new Mapa("mapa.json");
        //Jogador util = new Jogador();
        //String nome = (String) JOptionPane.showInputDialog("Digite o seu nome de usuário:");
        //util.setNome(nome);
       // Menu_Inicial menu_Inicial = new Menu_Inicial(map, util);
       MenuConsole menu= new MenuConsole();
       menu.menu();
       //Mapa mapa = new Mapa("mapa.json");
       //mapa.getNetwork().imprimirMatrizWeight();
    }
}
