package edu.ud1.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonHelper {
    

       /**
     * Crea un fichero en formato JSON en la ubicación outputFile
     * @param object objeto a transformar en JSON
     * @param outputFile ubicacion del fichero resultado de transformación
     * @throws IOException en caso de que se genere
     */
    public static void crearJSONFile(Object object, String outputFile) throws IOException {
        var mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        String jsonString = mapper.writeValueAsString(object);

        Files.writeString(Paths.get(outputFile), jsonString);

    }

}
