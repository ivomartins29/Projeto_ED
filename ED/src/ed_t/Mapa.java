package ed_t;

import Graph.Network;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class Mapa<T> {

    private Network<Aposentos> network;
    private int TAM_MAPA;
    private String nome;
    private long pontos;
    private JSONArray mapa;
    private ArrayUnorderedList aposentos;
    private Aposentos aposento;
    private Aposentos aposento2;

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

            aposentos = new ArrayUnorderedList(mapa.size() + 1);

            JSONObject mapa_obj;

            for (; i < mapa.size(); i++) {
                mapa_obj = (JSONObject) mapa.get(i);
                aposento = new Aposentos();
                aposento.setNome((String) mapa_obj.get("aposento"));
                aposento.setFantasma((long) mapa_obj.get("fantasma"));
                aposento.setLigacoes((JSONArray) mapa_obj.get("ligacoes"));
                aposentos.addToFront(aposento);
            }

            JSONArray array = new JSONArray();
            aposento = new Aposentos();
            aposento.setNome("exterior");
            aposento.setFantasma(0);
            aposento.setLigacoes(array);
            aposentos.addToFront(aposento);

            network = new Network<>();
            Iterator<Aposentos> itr = aposentos.iterator();

            while (itr.hasNext()) {
                aposento = itr.next();
                if (aposento.getLigacoes().size() != 0) {

                    for (int j = 0; j < aposento.getLigacoes().size(); j++) {

                        for (int k = 0; k < aposentos.size(); k++) {
                            while (itr.hasNext()) {
                                aposento2 = itr.next();
                                if (aposento.getNome().equals(aposento2.getLigacoes().get(j))) {
                                    network.addEdge(aposento, aposento2, (double) aposento2.getFantasma());
                                }
                            }
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

    /* public boolean hasExit(int indice) {

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
    }*/
}
