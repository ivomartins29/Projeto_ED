/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import Collection.ArrayUnorderedList;
import Mapa.Aposentos;
import Mapa.Mapa;
import Mapa.Jogador;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Scanner;

public class MenuConsole {

    private final String DEFAULT_MAP = "mapa.json";

    private String mapa;
    private Mapa leitura;

    public MenuConsole() {
        this.mapa = DEFAULT_MAP;
    }

    public final static void limparSaida() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }

    /**
     *
     * @throws java.lang.Exception
     */
    public void menu() throws Exception {

        int index = 0;
        limparSaida();

        Scanner myObj = new Scanner(System.in);
        System.out.println("//////////////////////////////////////////////");
        System.out.println("//                                          //");
        System.out.println("//            Casa Assombrada               //");
        System.out.println("//                                          //");
        System.out.println("//////////////////////////////////////////////");
        System.out.println("\n");
        System.out.println("MENU\n1:Jogar\n2:Novo Mapa\n3:Sair\n");
        index = myObj.nextInt();
        String jogador;
        //menu inicial
        switch (index) {
            //Jogar
            case 1:
                limparSaida();
                System.out.println("MODO\n1:Manual\n2:Simulação\n3:Voltar\n");
                index = myObj.nextInt();

                //menu do modo de jogo
                switch (index) {
                    //modo manual
                    case 1:
                        if (leitura == null) {
                            leitura = new Mapa(mapa);
                        }
                        //Menu escolher grau de dificuldade
                        limparSaida();
                        System.out.println("DIFICULDADE\n1:Básico\n2:Normal\n3:Dificíl\n");
                        index = myObj.nextInt();
                        dificuldade(index, leitura);
                        manual_gameplay(leitura);
                        break;
                    //modo simulação    
                    case 2:
                        if (leitura == null) {
                            leitura = new Mapa(mapa);
                        }
                        //Menu escolher grau de dificuldade
                        limparSaida();
                        System.out.println("DIFICULDADE\n1:Básico\n2:Normal\n3:Dificíl\n");
                        index = myObj.nextInt();
                        dificuldade(index, leitura);
                        simulation_gameplay(leitura);
                        break;
                    //voltar atras    
                    case 3:
                        menu();
                        break;
                }
                break;
            //Carregar outro mapa    
            case 2:
                int enc = 0;
                myObj = new Scanner(System.in);

                do {
                    limparSaida();
                    System.out.println("Digite o nome do ficheiro do mapa:");
                    System.out.println("EXAMPLE: mapa.json");
                    mapa = myObj.nextLine();

                    leitura = new Mapa(mapa);
                    if (leitura.getNome() != null) {
                        enc = 1;
                    }
                } while (enc == 0);

                menu();
                break;
            //sair do jogo;    
            case 3:
                System.out.println("Hope you enjoyed!!!");
                break;
        }
    }

    public void manual_gameplay(Mapa m) throws Exception {

        Aposentos divisao = isEntry(m);
        Jogador uti = new Jogador();
        Scanner player = new Scanner(System.in);
        String jogador;
        limparSaida();
        do {
            System.out.println("Introduza o nome do jogador: ");
            jogador = player.nextLine();
        } while ("".equals(jogador));
        uti.setNome(jogador);
        uti.setPontos(m.getPontos());
        uti.setMapa(m.getNome());
        limparSaida();
        System.out.println("Mapa: " + m.getNome());
        System.out.println("Jogador: " + uti.getNome());
        System.out.println("Pontos: " + uti.getPontos());
        System.out.println("Divisão: " + divisao.getNome());
        String resposta;
        Scanner myObj;
        boolean exterior_reached = false;
        double tempoInicial = System.currentTimeMillis();

        do {
            myObj = new Scanner(System.in);
            System.out.println("Escreva o nome da próxima divisão:");
            ArrayUnorderedList<Aposentos> list = m.getNetwork().getNeightbors(divisao);
            Iterator<Aposentos> itr = list.iterator();
            Aposentos lig = null;
            
            while (itr.hasNext()) {
                lig = itr.next();
                if (lig.getFantasma() > 0) {
                    System.out.print("  '" + lig.getNome() + "'" + "(ATENÇÃO, existe um famtasma nesta divisão)");
                } else {
                    System.out.print("  '" + lig.getNome() + "'");
                }
            }
            System.out.println("\n");

            resposta = myObj.nextLine();

            Iterator<Aposentos> itr2 = list.iterator();

            while (itr2.hasNext()) {
                lig = itr2.next();
                if (resposta.equals(lig.getNome())) {
                    limparSaida();
                    uti.setPontos(uti.getPontos() - (long) m.getNetwork().getAdjMatrixConnectionCost()[m.getNetwork().getVertexIndex(divisao)][m.getNetwork().getVertexIndex(lig)]);
                    System.out.println("Mapa: " + m.getNome());
                    System.out.println("Jogador: " + uti.getNome());
                    System.out.println("Pontos: " + uti.getPontos());
                    System.out.println("Divisão: " + resposta);
                    divisao = (Aposentos) m.getNetwork().getVertices()[m.getNetwork().getVertexIndex(lig)];
                    if (divisao.getFantasma() > 0) {
                        System.out.println("                  ''''''     ");
                        System.out.println("              '''       ''' ");
                        System.out.println("            '''            '''");
                        System.out.println("          '''   ( )    ( )   '''");
                        System.out.println("          '''                 '''");
                        System.out.println("           '''       ( )        ''' ");
                        System.out.println("              '''               '''");
                        System.out.println("                '''             '''");
                        System.out.println("                  '''          '''");
                        System.out.println("                    '''        '''");
                        System.out.println("                      '''       '''");
                        System.out.println("                         '''     '''");
                        System.out.println("                            '''''");
                    }
                    if (resposta.equals("exterior")) {
                        exterior_reached = true;
                    }
                }
            }
        } while (uti.getPontos() > 0 && !exterior_reached);

        double tempoFinal = System.currentTimeMillis();
        double i = 1000.0;
        uti.setTimeDuration(((tempoFinal - tempoInicial) / i));
        uti.guardarUtilizadores();

        if (uti.getPontos() <= 0) {
            limparSaida();
            System.out.println("Tente outra vez!");
            System.out.println("\nPress enter to play again...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            menu();
        } else {
            limparSaida();
            System.out.println("Parabéns " + uti.getNome() + ",concluiu o mapa " + m.getNome() + " com " + uti.getPontos() + " Pontos !!!");
            System.out.printf("Acabou o mapa em: " + uti.getTimeDuration() + " segundos");
            System.out.println("\nPress enter to play again...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            menu();
        }
    }

    public void simulation_gameplay(Mapa m) throws Exception {
        Aposentos divisao = isEntry(m);
        Aposentos saida = isExterior(m);
        Scanner player = new Scanner(System.in);
        Jogador uti = new Jogador();
        String jogador;
        String resposta = null;
        boolean exterior_reached = false;

        limparSaida();
        System.out.println("Introduza o nome do jogador: ");
        jogador = player.nextLine();
        uti.setNome(jogador);
        uti.setPontos(m.getPontos());
        uti.setMapa(m.getNome());
        limparSaida();
        System.out.println("Mapa: " + m.getNome());
        System.out.println("Jogador: " + uti.getNome());
        System.out.println("Pontos: " + uti.getPontos());
        System.out.println("Divisão: " + divisao.getNome());

        double tempoInicial = System.currentTimeMillis();

        do {

            System.out.println("Possiveis divisões:");

            ArrayUnorderedList list = m.getNetwork().getNeightbors(divisao);
            Iterator<Aposentos> itr3 = list.iterator();
            Aposentos lig1 = null;

            Iterator<Aposentos> itr = m.getNetwork().iteratorShortestPathConnectionCost(divisao, saida);
            Aposentos lig = null;
            while(itr.hasNext()){
                System.out.println(itr.next().getNome());
            }
            
           /*while (itr3.hasNext()) {
                lig1 = itr3.next();
                System.out.print("  '" + lig1.getNome() + "'");
                while (itr.hasNext()) {
                    lig = itr.next();
                    // System.out.println(lig.getNome());
                    if (lig == lig1) {
                        //resposta = lig.getNome();
                    }
                }
            }
*/
            System.out.println("\n");

            System.out.println("Divisão escolhida: " + resposta);

            System.out.println("\nPress enter to next division...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            limparSaida();

            Iterator<Aposentos> itr2 = list.iterator();

            while (itr2.hasNext()) {
                lig = itr2.next();
                if (resposta.equals(lig.getNome())) {
                    uti.setPontos(uti.getPontos() - (long) m.getNetwork().getAdjMatrixConnectionCost()[m.getNetwork().getVertexIndex(divisao)][m.getNetwork().getVertexIndex(lig)]);
                    System.out.println("Mapa: " + m.getNome());
                    System.out.println("Jogador: " + uti.getNome());
                    System.out.println("Pontos: " + uti.getPontos());
                    System.out.println("Divisão: " + resposta);
                    divisao = (Aposentos) m.getNetwork().getVertices()[m.getNetwork().getVertexIndex(lig)];
                    if (resposta.equals("exterior")) {
                        exterior_reached = true;
                    }
                }
            }

        } while (uti.getPontos() > 0 && !exterior_reached);

        double tempoFinal = System.currentTimeMillis();
        double i = 1000.0;
        uti.setTimeDuration(((tempoFinal - tempoInicial) / i));
        uti.guardarUtilizadores();

        if (uti.getPontos() <= 0) {
            limparSaida();
            System.out.println("Tente outra vez!");
            System.out.println("\nPress enter to play again...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            menu();
        } else {
            limparSaida();
            System.out.println("Parabéns " + uti.getNome() + ",concluiu o mapa " + m.getNome() + " com " + uti.getPontos() + " Pontos !!!");
            System.out.printf("Acabou o mapa em: " + uti.getTimeDuration() + " segundos");
            System.out.println("\nPress enter to play again...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            menu();
        }
    }

    public int procurar_indice_aposentos(Mapa m, String nome) {
        for (int i = 0; i < m.getNetwork().size(); i++) {
            if (m.getNetwork().getVertices()[i].equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    public Aposentos isEntry(Mapa m) {
        Aposentos ap = null;
        for (int i = 0; i < m.getNetwork().size(); i++) {
            ap = (Aposentos) m.getNetwork().getVertices()[i];
            if (ap.getNome().equals("entrada")) {
                return ap;
            }
        }
        return ap;
    }

    public Aposentos isExterior(Mapa m) {
        Aposentos ap = null;
        for (int i = 0; i < m.getNetwork().size(); i++) {
            ap = (Aposentos) m.getNetwork().getVertices()[i];
            if (ap.getNome().equals("exterior")) {
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

}
