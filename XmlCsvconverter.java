import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlToCsvConverter {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Get the root element
            Element root = doc.getDocumentElement();
            NodeList rows = root.getElementsByTagName("*");

            // Get the list of headers
            List<String> headers = new ArrayList<String>();
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                NodeList cells = row.getChildNodes();
                for (int j = 0; j < cells.getLength(); j++) {
                    Element cell = (Element) cells.item(j);
                    String header = cell.getTagName();
                    if (!headers.contains(header)) {
                        headers.add(header);
                    }
                }
            }

            // Write the CSV file
            FileWriter csvWriter = new FileWriter(new File("output.csv"));
            // Write the header row to the CSV file
            for (int i = 0; i < headers.size(); i++) {
                csvWriter.append(headers.get(i));
                if (i != headers.size() - 1) {
                    csvWriter.append(",");
                }
            }
            csvWriter.append("\n");

            // Write the data rows to the CSV file
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                NodeList cells = row.getChildNodes();
                for (int j = 0; j < headers.size(); j++) {
                    String header = headers.get(j);
                    boolean hasValue = false;
                    for (int k = 0; k < cells.getLength(); k++) {
                        Element cell = (Element) cells.item(k);
                        if (cell.getTagName().equals(header)) {
                            csvWriter.append(cell.getTextContent());
                            hasValue = true;
                            break;
                        }
                    }
                    if (!hasValue) {
                        csvWriter.append("");
                    }
                    if (j != headers.size() - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");
            }

            // Close the CSV file
            csvWriter.close();

            System.out.println("Conversion complete.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
