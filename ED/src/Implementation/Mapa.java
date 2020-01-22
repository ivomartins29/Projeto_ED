/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import org.json.simple.JSONArray;

/**
 *
 * @author jogui
 */
public class Mapa {
    private int TAM_MAPA;
    private String nome;
    private int pontos;
    private JSONArray mapa;
    private Aposentos[] aposento;

    public Mapa() {
    }

    public int getTAM_MAPA() {
        return TAM_MAPA;
    }

    public void setTAM_MAPA(int TAM_MAPA) {
        this.TAM_MAPA = TAM_MAPA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public JSONArray getMapa() {
        return mapa;
    }

    public void setMapa(JSONArray mapa) {
        this.mapa = mapa;
    }

    public Aposentos[] getAposento() {
        return aposento;
    }

    public void setAposento(Aposentos[] aposento) {
        this.aposento = aposento;
    }
  
}
