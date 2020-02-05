/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

/**
 *
<<<<<<< HEAD
 * @author 8150121 e 8150133
=======
 * @author jogui
>>>>>>> 026de2582b704c9fc3ac69cc75b8d5b641e0a441
 */
public class Jogador {

    private String nome;
    private long pontos;
    private String mapa;
    private double timeDuration;

    public Jogador() {
        this.nome = null;
        this.pontos = 0;
        this.mapa = null;
        this.timeDuration = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public double getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(double timeDuration) {
        this.timeDuration = timeDuration;
    }
<<<<<<< HEAD
=======
    

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
    
    
    
>>>>>>> 026de2582b704c9fc3ac69cc75b8d5b641e0a441
}
