/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

/**
 *
 * @author 8150121 e 8150133
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
}
