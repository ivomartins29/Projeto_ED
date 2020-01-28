package ed_t;

import Graph.Graph;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private final String DEFAULT_MAP = "mapa.json";

    private String mapa;

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
                        System.out.println("DIFICULDADE\n1:Básico\n2:Normal\n3:Dificíl\n");
                        index = myObj.nextInt();
                        dificuldade(index, leitura);

                        manual_gameplay(leitura);
                        break;
                    //modo simulação    
                    case 2:
                        if (leitura == null) {
                            mapa = DEFAULT_MAP;
                            leitura = new Mapa(mapa);
                        }
                        //Menu escolher grau de dificuldade
                        System.out.println("DIFICULDADE\n1:Básico\n2:Normal\n3:Dificíl\n");
                        index = myObj.nextInt();
                        dificuldade(index, leitura);
                        break;
                    //voltar atras    
                    case 3:
                        menu();
                        break;
                }
                break;
            //Carregar outro mapa    
            case 2:
                myObj = new Scanner(System.in);
                System.out.println("Digite o nome do ficheiro do mapa:");
                System.out.println("EXAMPLE: mapa.json");
                mapa = myObj.nextLine();

                leitura = new Mapa(mapa);

                menu();
                break;
            //sair do jogo;    
            case 3:
                System.out.println("Hope you enjoyed!!!");
                break;
        }
    }

   /* public void manual_gameplay(Mapa m) {
        int pos_player = m.EntryIndex();
        System.out.println("Pontos: " + m.getPontos());
        System.out.println("Divisão: " + m.getAposento()[pos_player].getNome());
        String resposta;
        Scanner myObj;
        boolean exterior_reached = false;

        do {
            myObj = new Scanner(System.in);
            System.out.println("Escreva o nome da próxima divisão:");

            for (Aposentos neighbor : m.getMatriz().getNeighbors(m.getAposento()[pos_player])) {
                System.out.println(neighbor.getNome());
            }
            resposta = myObj.nextLine();
            for (Aposentos neighbor : m.getMatriz().getNeighbors(m.getAposento()[pos_player])) {
                if (neighbor != null) {
                    if (resposta.equals(neighbor.getNome())) {
                        m.setPontos(m.getPontos() - neighbor.getFantasma());
                        System.out.println("Pontos: " + m.getPontos());
                        System.out.println("Divisão: " + neighbor.getNome());
                        pos_player = procurar_indice_aposentos(m, neighbor.getNome());
                        if (neighbor.getNome().equals("exterior")) {
                            exterior_reached = true;
                        }
                    }
                }

            }
        } while (m.getPontos() > 0 && !exterior_reached);

        if (m.getPontos() <= 0) {
            System.out.println("Tente outra vez!s");
        } else {
            System.out.println("Parabéns você concluiu este mapa!!");
        }
    }

    public int procurar_indice_aposentos(Mapa m, String nome) {
        for (int i = 0; i < m.getAposento().length; i++) {
            if (m.getAposento()[i].getNome().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metodo que cria um Menu para selecionar o grau de dificuldade
     *
     * @param index inteiro usado para selicionar uma opcção
     */
   /* public void dificuldade(int index, Mapa mapa) {
        int i = 0;
        switch (index) {
            case 1:
                for (; i < mapa.getAposento().length; i++) {
                    mapa.getAposento()[i].setFantasma(mapa.getAposento()[i].getFantasma() * 1);
                }
                break;
            case 2:
                for (; i < mapa.getAposento().length; i++) {
                    mapa.getAposento()[i].setFantasma(mapa.getAposento()[i].getFantasma() * 2);
                }
                break;
            case 3:
                for (; i < mapa.getAposento().length; i++) {
                    mapa.getAposento()[i].setFantasma(mapa.getAposento()[i].getFantasma() * 3);
                }
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Main Menu = new Main();
        //Menu.menu();
         Mapa mapa = new Mapa("mapa.json");
         //
         mapa.getNetwork().imprimir();
    }

}
