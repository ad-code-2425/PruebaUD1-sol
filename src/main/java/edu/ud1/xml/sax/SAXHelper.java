package edu.ud1.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import edu.ud1.model.Partido;

public class SAXHelper {
    
    public static ArrayList<Partido> leerSAX(String filePath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //saxParserFactory.setNamespaceAware(true);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        File file = new File(filePath);
        PartidosHandler handler = new PartidosHandler();
        saxParser.parse(file, handler);

        return handler.getPartidos();

    }
}
