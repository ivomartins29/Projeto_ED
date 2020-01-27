/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_t;

import org.json.simple.JSONArray;

/**
 *
 * @author Ivo Martins
 * @param <T>
 */
public class Aposentos<T> {

    private String nome;
    private long fantasma;
    private JSONArray ligacoes;

    public Aposentos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getFantasma() {
        return fantasma;
    }

    public void setFantasma(long fantasma) {
        this.fantasma = fantasma;
    }

    public JSONArray getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(JSONArray ligacoes) {
        this.ligacoes = ligacoes;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}
