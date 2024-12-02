package edu.ud1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import edu.ud1.json.JsonHelper;
import edu.ud1.model.Partido;
import edu.ud1.xml.sax.SAXHelper;

/**
 *
 * @author maria
 */
public class MainUD1 {

    private static final String ELECCIONES_OUTPUT_FILE_XML = Paths.get("src", "main", "resources", "elecciones.xml")
            .toString();

    private static final String ELECCIONES_OUTPUT_FILE_CSV = Paths
            .get("src", "main", "resources", "elecciones_output.json")
            .toString();

    public static void main(String[] args) {

        ArrayList<Partido> partidos;

        // Leemos con SAX:

        try {
            partidos = SAXHelper.leerSAX(ELECCIONES_OUTPUT_FILE_XML);

            // Creamos un fichero Json
            JsonHelper.crearJSONFile(partidos, ELECCIONES_OUTPUT_FILE_CSV);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
