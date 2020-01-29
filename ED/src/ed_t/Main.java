package ed_t;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private final String DEFAULT_MAP = "mapa.json";

    private String mapa;

    /**
     *
     */
    public void menu() {
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

    public void manual_gameplay(Mapa m) {
        Aposentos player = isEntry(m);
        System.out.println("Pontos: " + m.getPontos());
        System.out.println("Divisão: " + player.getNome());
        String resposta;
        Scanner myObj;
        boolean exterior_reached = false;

        do {
            myObj = new Scanner(System.in);
            System.out.println("Escreva o nome da próxima divisão:");

            ArrayUnorderedList list = m.getNetwork().getNeightbors(player);
            Iterator<Aposentos> itr = list.iterator();
            Aposentos lig = null;
            while (itr.hasNext()) {
                lig = itr.next();
                System.out.println(lig.getNome());
            }

            resposta = myObj.nextLine();

            Iterator<Aposentos> itr2 = list.iterator();

            while (itr2.hasNext()) {
                lig = itr2.next();
                if (resposta.equals(lig.getNome())) {
                    m.setPontos(m.getPontos() - (long) m.getNetwork().getAdjMatrixWeights()[m.getNetwork().getIndex(player)][m.getNetwork().getIndex(lig)]);

                    System.out.println("Pontos: " + m.getPontos());
                    System.out.println("Divisão: " + resposta);
                    player = (Aposentos) m.getNetwork().getVertices()[m.getNetwork().getIndex(lig)];
                    if (resposta.equals("exterior")) {
                        exterior_reached = true;
                    }
                }
            }
        } while (m.getPontos() > 0 && !exterior_reached);

        if (m.getPontos() <= 0) {
            System.out.println("Tente outra vez!");
        } else {
            System.out.println("Parabéns você concluiu este mapa com " + m.getPontos() + "!!!");
        }
    }

    public int procurar_indice_aposentos(Mapa m, String nome) {
        for (int i = 0; i < m.getNetwork().getNumVertices(); i++) {
            if (m.getNetwork().getVertices()[i].equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    public Aposentos isEntry(Mapa m) {
        Aposentos ap = null;
        for (int i = 0; i < m.getNetwork().getNumVertices(); i++) {
            ap = (Aposentos) m.getNetwork().getVertices()[i];
            if (ap.getNome().equals("entrada")) {
                return ap;
            }
        }
        return ap;
    }

    /**
     * Metodo que cria um Menu para selecionar o grau de dificuldade
     *
     * @param index inteiro usado para selicionar uma opcção
     */
    public void dificuldade(int index, Mapa m) {
        switch (index) {
            case 1:
                m.getNetwork().multiplicar_adjmatrizweight(index);
                break;
            case 2:
                m.getNetwork().multiplicar_adjmatrizweight(index);
                break;
            case 3:
                m.getNetwork().multiplicar_adjmatrizweight(index);
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

        //Mapa map = new Mapa("mapa.json");
        //map.getNetwork().imprimirMatrizWeight();
        Main Menu = new Main();
        Menu.menu();
    }

}
