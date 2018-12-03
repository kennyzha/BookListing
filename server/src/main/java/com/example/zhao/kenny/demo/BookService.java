package com.example.zhao.kenny.demo;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    public static final String URL = "https://www.goodreads.com/search.xml?key=%s&q=%s";

    public List<Book> getBooks(String query){
        List<Book> bookResults = new ArrayList<>();
        try {
            // Would use a SAX parser instead if XML file was larger
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Would cache the the results in a real application
            Document doc = builder.parse(String.format(URL, Config.API_KEY, query));
            doc.normalize();

            NodeList nodeList = doc.getElementsByTagName("best_book");

            for(int i = 0; i < nodeList.getLength(); i++){
                Node curNode = nodeList.item(i);

                if(curNode.getNodeType() == Node.ELEMENT_NODE){
                    Element curElement = (Element) curNode;

                    String title = curElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = curElement.getElementsByTagName("name").item(0).getTextContent();
                    String img_url = curElement.getElementsByTagName("image_url").item(0).getTextContent();

                    bookResults.add(new Book(title, author, img_url));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return bookResults;
    }
}
