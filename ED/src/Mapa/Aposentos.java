package Mapa;

import org.json.simple.JSONArray;

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
    public String toString() {
        return this.nome;
    }


    public boolean hasExit() {
        if (this.getLigacoes().contains("exterior")) {
            return true;
        }
        return false;
    }
}
