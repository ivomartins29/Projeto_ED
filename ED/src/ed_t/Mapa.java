package ed_t;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class Mapa {

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

            aposento = new Aposentos[TAM_MAPA];

            JSONObject mapa_obj;

            for (; i < mapa.size(); i++) {
                mapa_obj = (JSONObject) mapa.get(i);
                aposento[i] = new Aposentos();
                aposento[i].setNome((String) mapa_obj.get("aposento"));
                aposento[i].setFantasma((long) mapa_obj.get("fantasma"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        // TODO Auto-generated catch block

    }
}
