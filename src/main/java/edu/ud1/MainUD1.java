package edu.ud1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import edu.ud1.json.JsonHelper;
import edu.ud1.model.Partido;
import edu.ud1.xml.dom.DomHelper;
import edu.ud1.xml.sax.SAXHelper;

/**
 *
 * @author maria
 */
public class MainUD1 {

    private static final String ELECCIONES_INTPUT_FILE_XML = Paths.get("src", "main", "resources", "elecciones.xml")
            .toString();

    private static final String ELECCIONES_OUTPUT_FILE_JSON = Paths
            .get("src", "main", "resources", "elecciones_output.json")
            .toString();

            private static final String ELECCIONES_OUTPUT_FILE_XML_DOM = Paths
            .get("src", "main", "resources", "elecciones_output.xml")
            .toString();

/**
 * Punto principal de ejecución.
 * Lee con SAX el archivo XML origen indicado por la constante ELECCIONES_INTPUT_FILE_XML y crea un ArrayList<Partido>
 * Crea un archivo JSON a partir de los objetos Partido obtenidos del fichero XML origen en la ruta especificada por la constante ELECCIONES_OUTPUT_FILE_JSON
 * Crea un archivo XML a partir de los objetos Partido obtenidos del fichero XML origen en la ruta especificada por la constante ELECCIONES_OUTPUT_FILE_XML_DOM
 * @param args No son necesarios
 */
    public static void main(String[] args) {

        ArrayList<Partido> partidos;
       
        try {
            // Leemos con SAX:
            partidos = SAXHelper.leerSAX(ELECCIONES_INTPUT_FILE_XML);

            // Creamos un fichero Json
            JsonHelper.crearJSONFile(partidos, ELECCIONES_OUTPUT_FILE_JSON);

            //Creamos un xml con DOM
            Document doc = DomHelper.generarDOM(partidos);
            DomHelper.escribirDOM(doc, ELECCIONES_OUTPUT_FILE_XML_DOM);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {

            e.printStackTrace();
        }

    }

}
