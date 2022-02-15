package com.teachmeskills.lesson_17.task_2.parser_dom;

import com.teachmeskills.lesson_17.task_2.model.Sonnet;
import com.teachmeskills.lesson_17.task_2.iparser.IParser;
import com.teachmeskills.lesson_17.task_2.writexml.WriteXML;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements IParser {

    private List<Sonnet> sonnetList = new ArrayList<>();
    private Sonnet sonnetObj = new Sonnet();

    @Override
    public void process(String file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document document = factory.newDocumentBuilder().parse(new File(file));
            document.getDocumentElement().normalize();

            NodeList nList1 = document.getElementsByTagName("author");
            getAuthorField(nList1);

            NodeList nList2 = document.getDocumentElement().getElementsByTagName("title");
            getTitleField(nList2);

            NodeList nList3 = document.getDocumentElement().getElementsByTagName("line");
            getLinesField(nList3);

            sonnetList.add(sonnetObj);
            WriteXML.addLinesSonnetInDoc(sonnetList);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.err.println(e.getMessage());
        }
    }

    private void getAuthorField(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                Node nodeFirst = eElement.getElementsByTagName("firstName").item(0);
                if (nodeFirst != null) {
                    String firstName = nodeFirst.getTextContent();
                    sonnetObj.setAuthorFirstName(firstName);
                } else {
                    System.out.println("'firstName' не существует.");
                }

                Node nodeLast = eElement.getElementsByTagName("lastName").item(0);
                if (nodeLast != null) {
                    String lastName = nodeLast.getTextContent();
                    sonnetObj.setAuthorLastName(lastName);
                } else {
                    System.out.println("'lastName' не существует.");
                }
            }
        }
    }

    private void getTitleField(NodeList nList) {
        String title = "";

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            title = node.getTextContent();
        }
        sonnetObj.setTitle(title);
    }

    private void getLinesField(NodeList nList) {
        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            lineList.add(node.getTextContent() + "   ");
            sonnetObj.setLine(lineList);
        }
    }

}
