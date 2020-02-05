package Mapa;

import org.json.simple.JSONArray;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class Aposentos<T> {

    private String nome;
    private long fantasma;
    private JSONArray ligacoes;

    /**
     *
     */
    public Aposentos() {
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
    public long getFantasma() {
        return fantasma;
    }

    /**
     *
     * @param fantasma
     */
    public void setFantasma(long fantasma) {
        this.fantasma = fantasma;
    }

    /**
     *
     * @return
     */
    public JSONArray getLigacoes() {
        return ligacoes;
    }

    /**
     *
     * @param ligacoes
     */
    public void setLigacoes(JSONArray ligacoes) {
        this.ligacoes = ligacoes;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    /**
     *
     * @return
     */
    public boolean hasExit() {
        if (this.getLigacoes().contains("exterior")) {
            return true;
        }
        return false;
    }
}
