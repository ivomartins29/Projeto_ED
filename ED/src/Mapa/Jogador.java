package Mapa;

/**
 * Classe que contém os dados do jogador
 *
 * @author 8150121 e 8150133
 */
public class Jogador {

    private String nome;
    private long pontos;
    private String mapa;
    private double timeDuration;

    /**
     * Método construtor da classe Jogador
     */
    public Jogador() {
        this.nome = null;
        this.pontos = 0;
        this.mapa = null;
        this.timeDuration = 0;
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
     * @param nome nova string nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Get da variável pontos
     *
     * @return o valor de pontos
     */
    public long getPontos() {
        return pontos;
    }

    /**
     * Set da variável pontos
     *
     * @param pontos novo valor para pontos
     */
    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    /**
     * Get da variável mapa
     *
     * @return string mapa
     */
    public String getMapa() {
        return mapa;
    }

    /**
     * Set da variável mapa
     *
     * @param mapa novo mapa
     */
    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    /**
     * Get da variável timeDuration
     *
     * @return valor de timeDuration
     */
    public double getTimeDuration() {
        return timeDuration;
    }

    /**
     * Set da variável timeDuration
     *
     * @param timeDuration novo valor para timeDurations
     */
    public void setTimeDuration(double timeDuration) {
        this.timeDuration = timeDuration;
    }
}
