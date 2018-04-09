package com.MahentaRestApp.Mahenta;


import com.MahentaRestApp.Mahenta.XMLParser.ShowXmlParser;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;


public class ShowXmlParserTests {

    @Test
    public void GetShowNodeListFromDocument() throws ParserConfigurationException, IOException, SAXException {
        InputStream resource = ShowXmlParserTests.class.getResourceAsStream("/tests.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(resource);
        ShowXmlParser parser = new ShowXmlParser();
        NodeList nodeList = parser.getShowNodeListFromDocument(document);
        Element testElement =(Element) nodeList.item(0);
        String expectedTitle = "Seltsimees laps";
        String resultTitle = testElement.getElementsByTagName("Title").item(0).getTextContent();

        assertEquals(3, nodeList.getLength());
        assertEquals(expectedTitle, resultTitle);

    }
}
