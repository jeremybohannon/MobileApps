package com.example.android.gettingdataxml;

import android.util.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jeremybohannon on 10/16/17.
 */

public class PersonParser {
    public static class PersonsSAXParser extends DefaultHandler{

        ArrayList<Person> persons;
        Person person;
        Address address;

        StringBuilder innerXML;

        public static ArrayList<Person> parsePersons(InputStream inputStream) throws IOException, SAXException{
            PersonsSAXParser parser = new PersonsSAXParser();
            Xml.parse(inputStream, Xml.Encoding.UTF_8, parser);
            return parser.persons;
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            this.persons = new ArrayList<>();
            this.innerXML = new StringBuilder();


        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);

            if(localName.equals("person")){
                person = new Person();
                person.id = Integer.parseInt(attributes.getValue("id"));

            } else if(localName.equals("address")){
                address = new Address();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);

            String text = "";
            if(innerXML.toString() != null)
                text = innerXML.toString().trim();

            if(localName.equals("name")){
                person.name = text;
            } else if(localName.equals("age")){
                person.age = Integer.parseInt(text);
            } else if(localName.equals("line1")){
                address.line1 = text;
            } else if(localName.equals("address")){
                person.address = address;
            } else if(localName.equals("person")){
                persons.add(person);
            }

            innerXML.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);

            innerXML.append(ch, start, length);
        }
    }
}
