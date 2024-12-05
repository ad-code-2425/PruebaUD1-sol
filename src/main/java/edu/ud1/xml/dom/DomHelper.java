package edu.ud1.xml.dom;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import edu.ud1.model.Partido;

public class DomHelper {
      /**
     * Genera un objeto Document que representa en memoria el documento XML con los datos del parámetro partidos
     * @param partidos Lista de partidos
     * @return objeto Document
     * @throws ParserConfigurationException en caso de error
     */
      public static Document generarDOM(ArrayList<Partido> partidos) throws ParserConfigurationException {
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();

          DOMImplementation implementation = builder.getDOMImplementation();

          // desde el document creamos un nuevo elemento
          Document document = implementation.createDocument(null, Partido.PARTIDOS_TAG, null);
          // Obtenemos el elemento raíz
          Element root = document.getDocumentElement();

          for (Partido partido : partidos) {

              // Creamos el elemento partido
              Element ePartido = document.createElement(Partido.PARTIDO_TAG);
              ePartido.setAttribute(Partido.PARTIDO_ATT_ID, String.valueOf(partido.getId()));

              addElementConTexto(document, ePartido, Partido.PARTIDO_NOMBRE_TAG, partido.getNombre());
              addElementConTexto(document, ePartido, Partido.PARTIDO_VOTOS_NUM_TAG, String.valueOf(partido.getVotos()));

             
              addElementConTexto(document, ePartido, Partido.PARTIDO_VOTOS_PORC_TAG, String.valueOf(partido.getPorcentaje()));

              // añadimos el documento al DOM
              root.appendChild(ePartido);
              
          }

          return document;

      }
    
    private static void addElementConTexto(Document document, Node padre, String tag, String text) {
        // Creamos un nuevo nodo de tipo elemento desde document
        Node node = document.createElement(tag);
        // Creamos un nuevo nodo de tipo texto también desde document
        Node nodeTexto = document.createTextNode(text);
        // añadimos a un nodo padre el nodo elemento
        padre.appendChild(node);
        // Añadimos al nodo elemento su nodo hijo de tipo texto
        node.appendChild(nodeTexto);
    }
    
      /**
     * Crea un fichero en la ubicación indicada pro fileDestino a partir de un objeto Document en memoria
     * @param document objeto que se transcibirá al fichero de fileDestino
     * @param fileDestino ruta al fichero de destino
     * @throws TransformerException en caso de que surja durante la operación
     */
    public static void escribirDOM(Document document, String fileDestino) throws TransformerException {
        // Para generar un documento XML con un objeto Document
        // Generar el tranformador para obtener el documento XML en un fichero
        TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
        // Espacios para indentar cada línea
        fabricaTransformador.setAttribute("indent-number", 4);
        Transformer transformador = fabricaTransformador.newTransformer();
        // Insertar saltos de línea al final de cada línea
        // https://docs.oracle.com/javase/8/docs/api/javax/xml/transform/OutputKeys.html
        transformador.setOutputProperty(OutputKeys.INDENT, "yes");

        // Si se quisiera añadir el <!DOCTYPE>:
        // transformador.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
        // docType.getSystemId());
        // El origen de la transformación es el document
        Source origen = new DOMSource(document);
        // El destino será un stream a un fichero
        Result destino = new StreamResult(fileDestino);
        transformador.transform(origen, destino);
    }
}
