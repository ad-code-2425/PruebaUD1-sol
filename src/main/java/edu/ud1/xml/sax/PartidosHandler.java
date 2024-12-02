package edu.ud1.xml.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.ud1.model.Partido;

/**
 *
 * @author maria
 */
public class PartidosHandler extends DefaultHandler {

    public static final String PARTIDO_TAG = "partido";
    public static final String PARTIDOS_TAG = "partidos";
    public static final String PARTIDO_VOTOS_NUM_TAG = "votos_numero";
    public static final String PARTIDO_VOTOS_PORC_TAG = "votos_porciento";
    public static final String PARTIDO_NOMBRE_TAG = "nombre";
    public static final String PARTIDO_ATT_ID = "id";

    private ArrayList<Partido> partidos = new ArrayList();
    private Partido partido;
    private StringBuilder buffer = new StringBuilder();

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case PARTIDO_NOMBRE_TAG:
                partido.setNombre(buffer.toString());
                break;
            case PARTIDO_VOTOS_NUM_TAG:
                partido.setVotos(Integer.parseInt(buffer.toString()));
                break;
            case PARTIDO_VOTOS_PORC_TAG:
                break;

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {

            case PARTIDO_TAG:
                partido = new Partido();
                partidos.add(partido);

            case PARTIDO_NOMBRE_TAG:
            case PARTIDO_VOTOS_NUM_TAG:
            case PARTIDO_VOTOS_PORC_TAG:
                buffer.delete(0, buffer.length());
                break;

        }
    }
}
