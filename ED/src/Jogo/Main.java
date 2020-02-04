package Jogo;

/**
 *
 * @author 8180546 && 8180159
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
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
