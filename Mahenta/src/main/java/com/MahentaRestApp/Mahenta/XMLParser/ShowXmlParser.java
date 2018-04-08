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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

public class ShowXmlParser {

    public List<Show> GetItems() throws ParserConfigurationException, IOException, SAXException {


        LocalDate today = LocalDate.now();

        DateTimeFormatter todayFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String todayString = today.format(todayFormatter);
        List<String> UrlList = new ArrayList<>();
        UrlList.add("https://www.forumcinemas.ee/xml/Schedule/?area=1008&dt="+todayString);
        UrlList.add("https://www.apollokino.ee/xml/Schedule/?area=1004&dt="+todayString);
        //String url = "https://www.forumcinemas.ee/xml/Schedule/?area=1008&dt="+todayString;
        //03.04.2018


        List<Show> list = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        for (String url:UrlList){
        DocumentBuilder parser = factory.newDocumentBuilder();

        Document document = parser.parse(new URL(url).openStream());
        document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("Show");
        for (int i = 0; i<nList.getLength(); i++) {

            Show show = new Show();
            Node node = nList.item(i);
            Element element = (Element) node;
            Element images = (Element) element.getElementsByTagName("Images").item(0);
            show.id = Long.parseLong(element.getElementsByTagName("ID").item(0).getTextContent());
            show.Title = element.getElementsByTagName("Title").item(0).getTextContent();
            show.Cinema = element.getElementsByTagName("Theatre").item(0).getTextContent();
            show.Hall = element.getElementsByTagName("TheatreAuditorium").item(0).getTextContent();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            show.showDate = LocalDateTime.parse(element.getElementsByTagName("dttmShowStart").item(0).getTextContent(), formatter).toLocalDate();
            show.showTime = LocalDateTime.parse(element.getElementsByTagName("dttmShowStart").item(0).getTextContent(), formatter).toLocalTime();

            show.ImgUrl = images.getElementsByTagName("EventMediumImagePortrait").item(0).getTextContent();



            list.add(show);

        }
        }
        return list;
    }

}
