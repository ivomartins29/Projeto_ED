package ed_t;

import Graph.AdjMatrixDiGraph;
import Graph.WeightedAdjMatrixGraph;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class Mapa {

    private AdjMatrixDiGraph matriz;
    private WeightedAdjMatrixGraph matrizPeso;
    private int TAM_MAPA;
    private String nome;
    private long pontos;
    private JSONArray mapa;
    private Aposentos[] aposento;

    public Mapa(String Ficheiro_Json) {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    Ficheiro_Json));

            //falta por condição para verificar se o ficheiro está vazio
            mapa = new JSONArray();
            int i = 0;

            nome = (String) jsonObject.get("nome");
            pontos = (long) jsonObject.get("pontos");

            mapa = (JSONArray) jsonObject.get("mapa");
            TAM_MAPA = mapa.size();

            aposento = new Aposentos[TAM_MAPA+1];

            JSONObject mapa_obj;

            for (; i < mapa.size(); i++) {
                mapa_obj = (JSONObject) mapa.get(i);
                aposento[i] = new Aposentos();
                aposento[i].setNome((String) mapa_obj.get("aposento"));
                aposento[i].setFantasma((long) mapa_obj.get("fantasma"));
                aposento[i].setLigacoes((JSONArray) mapa_obj.get("ligacoes"));
            }
            
            JSONArray array = new JSONArray(); 
            aposento[TAM_MAPA] = new Aposentos();
            aposento[TAM_MAPA].setNome("exterior");
            aposento[TAM_MAPA].setFantasma(0);
            aposento[TAM_MAPA].setLigacoes(array);

            matriz = new AdjMatrixDiGraph(aposento);
            for (int j = 0; j < aposento.length; j++) {
                int m = aposento[j].getLigacoes().size();
                for (int x = 0; x < m; x++) {
                    for (int k = 0; k < aposento.length; k++) {
                        if (aposento[k].getNome().equals(aposento[j].getLigacoes().get(x))) {
                            matriz.addEdge(aposento[k], aposento[j]);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        // TODO Auto-generated catch block

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

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
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

    public AdjMatrixDiGraph getMatriz() {
        return matriz;
    }

    public void setMatriz(AdjMatrixDiGraph matriz) {
        this.matriz = matriz;
    }

    public boolean hasExit(int indice) {

        for (Object ligacoes : aposento[indice].getLigacoes()) {
            if (aposento[indice].getLigacoes().contains("exterior")) {
                return true;
            }
        }
        return false;
    }

    public int EntryIndex() {
        for (int i = 0; i < aposento.length; i++) {
            if (aposento[i].getLigacoes().contains("entrada")) {
                return i;
            }
        }
        return -1;
    }

    public boolean hasEntry(Aposentos ap) {
        if (ap.getLigacoes().contains("entrada")) {
            return true;
        }
        return false;
    }
}
