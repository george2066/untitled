package org.example.service;

import org.example.model.Address;
import org.example.model.City;
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


public class AddressService implements Service{

    private static List<Address> addresses = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        AddressXMLHandler handler = new AddressXMLHandler();
        parser.parse(new File("/home/loudviper8815726/programmirovanie/untitled/src/main/java/org/example/test/AS_ADM_HIERARCHY.XML"), handler);
    }


    @Override
    public List<Address> getList() {
        return addresses;
    }

    private static class AddressXMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("ITEM")) {
                long id = Long.parseLong(attributes.getValue("ID"));
                long objectId = Long.parseLong(attributes.getValue("OBJECTID"));
                long parentObjId = Long.parseLong(attributes.getValue("PARENTOBJID"));
                long changeId = Long.parseLong(attributes.getValue("CHANGEID"));
                long nextId = Long.parseLong(attributes.getValue("PREVID"));
                String updateDate = attributes.getValue("UPDATEDATE");
                String startDate = attributes.getValue("STARTDATE");
                String endDate = attributes.getValue("ENDDATE");
                int isActive = Integer.parseInt(attributes.getValue("ISACTIVE"));
                addresses.add(new Address(id, objectId, parentObjId, changeId, nextId, updateDate, startDate, endDate, isActive));
            }
        }
    }

}
