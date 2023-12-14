package org.example.service;

import org.example.model.City;
import org.example.model.Street;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreetService implements Service{

    private static List<Street> streets = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        StreetXMLHandler handler = new StreetXMLHandler();
        parser.parse(new File("/home/loudviper8815726/programmirovanie/untitled/src/main/java/org/example/test/AS_ADDR_OBJ.XML"), handler);
    }

    @Override
    public List<Street> getList() {
        return streets;
    }

    private static class StreetXMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("OBJECT")) {
                long id = Long.parseLong(attributes.getValue("ID"));
                long objectId = Long.parseLong(attributes.getValue("OBJECTID"));
                String objectGUId = attributes.getValue("OBJECTGUID");
                long changeId = Long.parseLong(attributes.getValue("CHANGEID"));
                String name = attributes.getValue("NAME");
                String typeName = attributes.getValue("TYPENAME");
                int level = Integer.parseInt(attributes.getValue("LEVEL"));
                long operTypeId = Long.parseLong(attributes.getValue("OPERTYPEID"));
                int prevId = Integer.parseInt(attributes.getValue("PREVID"));
                int nextId = Integer.parseInt(attributes.getValue("NEXTID"));
                String updateDate = attributes.getValue("UPDATEDATE");
                String startDate = attributes.getValue("STARTDATE");
                String endDate = attributes.getValue("ENDDATE");
                int isActual = Integer.parseInt(attributes.getValue("ISACTUAL"));
                int isActive = Integer.parseInt(attributes.getValue("ISACTIVE"));
                streets.add(new Street(id, objectId, objectGUId, changeId, name, typeName, level, operTypeId, prevId, nextId, updateDate, startDate, endDate, isActive, isActual));
            }
        }
    }

}
