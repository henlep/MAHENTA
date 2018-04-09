package com.MahentaRestApp.Mahenta.XMLParser;

import com.MahentaRestApp.Mahenta.Show.Show;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShowXmlParser {

    public List<Show> GetShowsFromUrls(List<String> UrlList) throws ParserConfigurationException, IOException, SAXException {

        List<Show> showList = new ArrayList<>();

        for (String url:UrlList){
            Document document = getDocumentFromUrl(url);

            NodeList nList = getShowNodeListFromDocument(document);
            for (int i = 0; i<nList.getLength(); i++) {
                Show show = createShowFromNode(nList.item(i));
                showList.add(show);
            }
        }
        return showList;
    }

    public Document getDocumentFromUrl(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        return parser.parse(new URL(url).openStream());
    }

    public NodeList getShowNodeListFromDocument(Document document) throws IOException, SAXException, ParserConfigurationException {
        document.getDocumentElement().normalize();
        return document.getElementsByTagName("Show");
    }

    private Show createShowFromNode(Node node){
        Show show = new Show();
        Element element = (Element) node;
        Element images = (Element) element.getElementsByTagName("Images").item(0);
        show.id = Long.parseLong(element.getElementsByTagName("ID").item(0).getTextContent());
        show.Title = element.getElementsByTagName("Title").item(0).getTextContent();
        show.Cinema = element.getElementsByTagName("Theatre").item(0).getTextContent();
        show.Hall = element.getElementsByTagName("TheatreAuditorium").item(0).getTextContent();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        show.showDate = LocalDateTime.parse(element.getElementsByTagName("dttmShowStart").item(0).getTextContent(), formatter).toLocalDate();
        show.showTime = LocalDateTime.parse(element.getElementsByTagName("dttmShowStart").item(0).getTextContent(), formatter).toLocalTime();
        DateTimeFormatter showTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        show.showTimeString = show.showTime.format(showTimeFormatter);
        show.ShowUrl = element.getElementsByTagName("ShowURL").item(0).getTextContent();
        show.ImgUrl = images.getElementsByTagName("EventSmallImagePortrait").item(0).getTextContent();
        return show;
    }
}
