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
            case Partido.PARTIDO_NOMBRE_TAG:
                partido.setNombre(buffer.toString());
                break;
            case Partido.PARTIDO_VOTOS_NUM_TAG:
                partido.setVotos(Integer.parseInt(buffer.toString()));
                break;
            case Partido.PARTIDO_VOTOS_PORC_TAG:
                partido.setPorcentaje(Float.parseFloat(buffer.toString()));
                break;

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {

            case Partido.PARTIDO_TAG:
                partido = new Partido();
                partidos.add(partido);
                //Obtenemos atributo
                String id = attributes.getValue("id");
                partido.setId(Integer.valueOf(id));
                break;

            case Partido.PARTIDO_NOMBRE_TAG:
            case Partido.PARTIDO_VOTOS_NUM_TAG:
            case Partido.PARTIDO_VOTOS_PORC_TAG:
                buffer.delete(0, buffer.length());
                break;

        }
    }
}
