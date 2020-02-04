/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 8180546 && 8180159
 */
public class Jogador {
    
     private String nome;
    private long pontos;
    private String mapa;
    private double timeDuration;

    /**
     *
     */
    public Jogador() {
        this.nome = null;
        this.pontos = 0;
        this.mapa = null;
        this.timeDuration = 0;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public long getPontos() {
        return pontos;
    }

    /**
     *
     * @param pontos
     */
    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    /**
     *
     * @return
     */
    public String getMapa() {
        return mapa;
    }

    /**
     *
     * @param mapa
     */
    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    /**
     *
     * @return
     */
    public double getTimeDuration() {
        return timeDuration;
    }

    /**
     *
     * @param timeDuration
     */
    public void setTimeDuration(double timeDuration) {
        this.timeDuration = timeDuration;
    }
    
    /**
     *
     * @throws IOException
     */
    public void guardarUtilizadores() throws IOException {
        FileWriter x = new FileWriter("Classificações.txt", true);
        try {
            x.write("Jogador: " + this.nome + "\nMapa jogado: " + this.mapa + "\nPontos: " + this.pontos + "\nAcabou o mapa em: " + this.timeDuration + " segundos" + "\n\n");
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }
        x.close();
    }
    
    
    
}
