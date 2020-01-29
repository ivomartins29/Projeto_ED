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
    private ArrayUnorderedList<Aposentos> aposentos;
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

            aposentos = new ArrayUnorderedList(mapa.size() + 2);

            JSONObject mapa_obj;
            network = new Network<>(mapa.size() + 2);

            for (; i < mapa.size(); i++) {
                mapa_obj = (JSONObject) mapa.get(i);
                aposento = new Aposentos();
                aposento.setNome((String) mapa_obj.get("aposento"));
                aposento.setFantasma((long) mapa_obj.get("fantasma"));
                aposento.setLigacoes((JSONArray) mapa_obj.get("ligacoes"));
                if (aposento.getLigacoes().contains("entrada")) {
                    aposento2 = aposento;
                }
                aposentos.addToFront(aposento);
                network.addVertex(aposento);
            }

            JSONArray array = new JSONArray();
            aposento = new Aposentos();
            aposento.setNome("exterior");
            aposento.setFantasma(0);
            aposento.setLigacoes(array);
            aposentos.addToFront(aposento);
            network.addVertex(aposento);

            Iterator<Aposentos> itr = aposentos.iterator();

            while (itr.hasNext()) {
                aposento = itr.next();
                for (int j = 0; j < aposento.getLigacoes().size(); j++) {
                    for (int k = 0; k < aposentos.size(); k++) {
                        for (Aposentos ap : aposentos) {
                            if (ap.getNome().equals(aposento.getLigacoes().get(j))) {
                                network.addEdge(aposento, ap, ap.getFantasma());
                            }
                        }
                    }
                }
            }

            JSONArray array2 = new JSONArray();
            array2.add(aposento2);
            aposento = new Aposentos();
            aposento.setNome("entrada");
            aposento.setFantasma(0);
            aposento.setLigacoes(array2);
            aposentos.addToFront(aposento);
            network.addVertex(aposento);

            Iterator<Aposentos> itr_entrada = aposentos.iterator();
            while (itr.hasNext()) {
                aposento = itr.next();
                for (i = 0; i < aposento.getLigacoes().size(); i++) {
                    for (Aposentos ap : aposentos) {
                        if (ap.getNome().equals("entrada")) {
                            network.addEdge(ap, aposento, ap.getFantasma());
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

    public Network<Aposentos> getNetwork() {
        return network;
    }

    public void setNetwork(Network<Aposentos> network) {
        this.network = network;
    }

    public ArrayUnorderedList getAposentos() {
        return aposentos;
    }

    public void setAposentos(ArrayUnorderedList aposentos) {
        this.aposentos = aposentos;
    }

    public Aposentos getAposento() {
        return aposento;
    }

    public void setAposento(Aposentos aposento) {
        this.aposento = aposento;
    }

    public Aposentos getAposento2() {
        return aposento2;
    }

    public void setAposento2(Aposentos aposento2) {
        this.aposento2 = aposento2;
    }
}
