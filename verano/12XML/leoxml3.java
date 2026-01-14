import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class leoxml3 {

    public static void main(String[] args) {

        String fichero = "libros.xml";

        try {
            // Leo el fichero xml
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);

            // Obtiene una lista de todos los elementos con la etiqueta "libro"
            NodeList listaLibros = doc.getElementsByTagName("libro");

            for (int i = 0; i < listaLibros.getLength(); i++) {
                
                Node nodoLibro = listaLibros.item(i);
                
                // Obtenemos los hijos del nodoLibro (título, autor, año)
                NodeList hijos = nodoLibro.getChildNodes();
                
                String titulo = "";
                String autor = "";
                String anio = "";
                
                // Recorremos los hijos para encontrar cada elemento
                for (int j = 0; j < hijos.getLength(); j++) {
                    Node hijo = hijos.item(j);
                    
                    if (hijo.getNodeName().equals("titulo")) {
                        titulo = hijo.getTextContent();
                    } else if (hijo.getNodeName().equals("autor")) {
                        autor = hijo.getTextContent();
                    } else if (hijo.getNodeName().equals("anio")) {
                        anio = hijo.getTextContent();
                    }
                }
                
                // Imprimimos la información del libro
                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
                System.out.println("Año: " + anio);
                System.out.println("--------------------"); // Separador
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}