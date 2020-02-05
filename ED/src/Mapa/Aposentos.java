package Mapa;

import org.json.simple.JSONArray;

/**
 * Classe que contém os dados relacionados a um aposento
 * 
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class Aposentos<T> {

    private String nome;
    private long fantasma;
    private JSONArray ligacoes;

    /**
     * Método construtor de Aposentos
     */
    public Aposentos() {
    }

    /**
     * Get da variável nome
     * 
     * @return a string nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set da variável nome
     * 
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Get da variável fantasma
     * 
     * @return o valor do fantasma
     */
    public long getFantasma() {
        return fantasma;
    }

    /**
     * Set da variável fantasma
     * 
     * @param fantasma novo valor de fantasma
     */
    public void setFantasma(long fantasma) {
        this.fantasma = fantasma;
    }

    /**
     * Get da variável ligacoes
     * 
     * @return o JSONArray das ligacoes
     */
    public JSONArray getLigacoes() {
        return ligacoes;
    }

    /**
     * Set da variável ligacoes
     * 
     * @param ligacoes novo JSONArray de ligacoes
     */
    public void setLigacoes(JSONArray ligacoes) {
        this.ligacoes = ligacoes;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
