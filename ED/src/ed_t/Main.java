package ed_t;

import java.util.Scanner;

public class Main {

    private final String DEFAULT_MAP = "mapa.json";
    private String mapa;

    /**
     *
     */
   /* public void menu() {
        int index = 0;
        Mapa leitura = null;

        Scanner myObj = new Scanner(System.in);
        System.out.println("MENU\n1:Jogar\n2:Novo Mapa\n3:Sair\n");
        index = myObj.nextInt();

        //menu inicial
        switch (index) {
            //Jogar
            case 1:
                System.out.println("MODO\n1:Manual\n2:Simulação\n3:Voltar\n");
                index = myObj.nextInt();

                //menu do modo de jogo
                switch (index) {
                    //modo manual
                    case 1:
                        if (leitura == null) {
                            mapa = DEFAULT_MAP;
                            leitura = new Mapa(mapa);
                        }
                        //Menu escolher grau de dificuldade
                        System.out.println("MODO\n1:Manual\n2:Simulação\n3:Voltar\n");
                        index = myObj.nextInt();
                        dificuldade(index);
                        break;
                    //modo simulação    
                    case 2:
                        if (leitura == null) {
                            mapa = DEFAULT_MAP;
                            leitura = new Mapa(mapa);
                        }
                        //Menu escolher grau de dificuldade
                        System.out.println("MODO\n1:Manual\n2:Simulação\n3:Voltar\n");
                        index = myObj.nextInt();
                        dificuldade(index);
                        break;
                    //voltar atras    
                    case 3:
                        menu();
                        break;
                }
                System.out.println("1");
                break;
            //Carregar outro mapa    
            case 2:

                myObj = new Scanner(System.in);
                System.out.println("Digite o nome do mapa:");
                mapa = myObj.nextLine();

                leitura = new Mapa(mapa);

                menu();
                break;
            //sair do jogo;    
            case 3:
                System.out.println("3");
                break;
        }
    }

    /**
     * Metodo que cria um Menu para selecionar o grau de dificuldade
     *
     * @param index inteiro usado para selicionar uma opcção
     */
   /* public void dificuldade(int index) {
        switch (index) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main Menu = new Main();
        Menu.menu();*/
        
        Mapa mapa = new Mapa("mapa.json");
        System.out.println(mapa.getAposento()[0].getLigacoes());
    }

}
