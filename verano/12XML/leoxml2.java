
// Obtengo todos los títulos


import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class leoxml2 {

    public static void main(String[] args) {

        String fichero = "libros.xml";

        try {
            // Leo el fichero xml
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);

            // Obtiene una lista de todos los elementos con la etiqueta "titulo"
            NodeList listaTitulos = doc.getElementsByTagName("titulo");

            for (int i = 0; i < listaTitulos.getLength(); i++) {
                
                Node nodoTitulo = listaTitulos.item(i);
                String titulo = nodoTitulo.getTextContent();
                System.out.println("Título: " + titulo);
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("El fichero no existe" + e.getMessage());
        }

    }
}
