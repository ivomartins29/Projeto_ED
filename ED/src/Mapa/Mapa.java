package Mapa;

import Collection.ArrayUnorderedList;
import Collection.Network;
import Exceptions.ElementNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class Mapa<T> {

    private String nome_ficheiro;
    private Network<Aposentos> network;
    private int TAM_MAPA;
    private String nome;
    private long pontos;
    private JSONArray mapa;
    private ArrayUnorderedList<Aposentos> aposentos;
    private Aposentos aposento;
    private Aposentos aposento2;

    /**
     *
     * @param Ficheiro_Json
     */
    public Mapa(String Ficheiro_Json) throws ElementNotFoundException {
        nome_ficheiro = Ficheiro_Json;
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
                    aposento.getLigacoes().remove("entrada");
                }
                aposentos.addToFront(aposento);
                network.addVertex(aposento);
            }
            
            JSONArray array2 = new JSONArray();
            array2.add(aposento2.getNome());
            aposento = new Aposentos();
            aposento.setNome("entrada");
            aposento.setFantasma(0);
            aposento.setLigacoes(array2);
            aposentos.addToFront(aposento);
            network.addVertex(aposento);
            
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return nome do ficheiro
     */
    public String getNome_ficheiro() {
        return nome_ficheiro;
    }

    /**
     *
     * @param nome_ficheiro recebe o nome do ficheiro
     */
    public void setNome_ficheiro(String nome_ficheiro) {
        this.nome_ficheiro = nome_ficheiro;
    }

    /**
     *
     * @return tamanho do mapa
     */
    public int getTAM_MAPA() {
        return TAM_MAPA;
    }

    /**
     *
     * @param TAM_MAPA recebe o tamanho do mapa
     */
    public void setTAM_MAPA(int TAM_MAPA) {
        this.TAM_MAPA = TAM_MAPA;
    }

    /**
     *
     * @return o nome do mapa
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome recebe o nome do mapa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return os pontos
     */
    public long getPontos() {
        return pontos;
    }

    /**
     *
     * @param pontos recebe os pontos
     */
    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    /**
     *
     * @return um JSONArray de mapa
     */
    public JSONArray getMapa() {
        return mapa;
    }

    /**
     *
     * @param mapa recebe um JSONArray de mapa
     */
    public void setMapa(JSONArray mapa) {
        this.mapa = mapa;
    }

    /**
     *
     * @return Network de aposentos
     */
    public Network<Aposentos> getNetwork() {
        return network;
    }

    /**
     *
     * @param network recebe um Network de aposentos
     */
    public void setNetwork(Network<Aposentos> network) {
        this.network = network;
    }

    /**
     *
     * @return um ArrayUnorderedList de aposentos
     */
    public ArrayUnorderedList getAposentos() {
        return aposentos;
    }

    /**
     *
     * @param aposentos recebe um ArrayUnorderedList de aposentos
     */
    public void setAposentos(ArrayUnorderedList aposentos) {
        this.aposentos = aposentos;
    }

    /**
     *
     * @return aposento 2
     */
    public Aposentos getAposento() {
        return aposento;
    }

    /**
     *
     * @param aposento recebe um aposento
     */
    public void setAposento(Aposentos aposento) {
        this.aposento = aposento;
    }

    /**
     *
     * @return  aposento2
     */
    public Aposentos getAposento2() {
        return aposento2;
    }

    /**
     *
     * @param aposento2 recebe um aposento
     */
    public void setAposento2(Aposentos aposento2) {
        this.aposento2 = aposento2;
    }
}
