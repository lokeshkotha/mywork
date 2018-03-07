/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

import com.jsf.testing.XMLMovingDistance;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Lokesh Kotha
 */
public class XMLDataPosting {

    public static void main(String[] args) {
        try {
            XMLDataPosting dataPosting = new XMLDataPosting();
            dataPosting.sendLead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPostData() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("AAA");
            doc.appendChild(rootElement);
            Element lead = doc.createElement("BBB");
            rootElement.appendChild(lead);
            lead.appendChild(getEmployeeElements(doc, lead, "moverref", "leads@granot.com"));
            lead.appendChild(getEmployeeElements(doc, lead, "servtypeid", XMLMovingDistance.Long.getName()));
            lead.appendChild(getEmployeeElements(doc, lead, "firstname", "Thomas Wills"));
            lead.appendChild(getEmployeeElements(doc, lead, "lastname", "Wills"));
            lead.appendChild(getEmployeeElements(doc, lead, "ocity", "Jacksonville"));
            lead.appendChild(getEmployeeElements(doc, lead, "ostate", "FL"));
            lead.appendChild(getEmployeeElements(doc, lead, "ozip", "32216"));
            lead.appendChild(getEmployeeElements(doc, lead, "dcity", "Columbus"));
            lead.appendChild(getEmployeeElements(doc, lead, "dstate", "OH"));
            lead.appendChild(getEmployeeElements(doc, lead, "dzip", "43219"));
            lead.appendChild(getEmployeeElements(doc, lead, "weight", "4500"));
            lead.appendChild(getEmployeeElements(doc, lead, "movesize", "2 Small bedroom"));
            lead.appendChild(getEmployeeElements(doc, lead, "notes", "Should be on time"));
            lead.appendChild(getEmployeeElements(doc, lead, "movedte", "12/15/2017"));
            lead.appendChild(getEmployeeElements(doc, lead, "email", "whalyalexis@gmail.com"));
            lead.appendChild(getEmployeeElements(doc, lead, "phone1", "9045559999"));
            //        Element rootElement= doc.createElementNS("AAA");
            //        lead.appendChild(getEmployeeElements(doc, lead, "custcode", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "leadno", name));
            //        lead.appendChild(getEmployeeElements(doc, lead, "volume", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "dcountry", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "ocountry", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "movedte2", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "phone2", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "cell", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "source", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "mincount", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "maxcount", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "soldcount", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "repnotes", "~"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others1txt", "~"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others1amt", "0"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others2txt", "~"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others2amt", "0"));
//        lead.appendChild(getEmployeeElements(doc, lead, "label", "~"));
            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            //write to console or file
            StreamResult console = new StreamResult(System.out);
            //write data
            transformer.transform(source, console);
            System.out.println("DONE");
        } catch (ParserConfigurationException | TransformerException e) {

        }
    }

    private String sendLead() throws MalformedURLException, ProtocolException, IOException, TransformerConfigurationException, ParserConfigurationException, TransformerException, SAXException {
        String url = "http://lead.hellomoving.com/LEADSGWXML.lidgw?API_ID=CBB90D177F24";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        String USER_AGENT = "Mozilla/5.0";
        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("AAA");
        doc.appendChild(rootElement);
        Element lead = doc.createElement("BBB");
        rootElement.appendChild(lead);
        lead.appendChild(getEmployeeElements(doc, lead, "moverref", "leads@granot.com"));
        lead.appendChild(getEmployeeElements(doc, lead, "servtypeid", XMLMovingDistance.Long.getName()));
        lead.appendChild(getEmployeeElements(doc, lead, "firstname", "Thomas Wills"));
        lead.appendChild(getEmployeeElements(doc, lead, "lastname", "Wills"));
        lead.appendChild(getEmployeeElements(doc, lead, "ocity", "Jacksonville"));
        lead.appendChild(getEmployeeElements(doc, lead, "ostate", "FL"));
        lead.appendChild(getEmployeeElements(doc, lead, "ozip", "32216"));
        lead.appendChild(getEmployeeElements(doc, lead, "dcity", "Columbus"));
        lead.appendChild(getEmployeeElements(doc, lead, "dstate", "OH"));
        lead.appendChild(getEmployeeElements(doc, lead, "dzip", "43219"));
        lead.appendChild(getEmployeeElements(doc, lead, "weight", "4500"));
        lead.appendChild(getEmployeeElements(doc, lead, "movesize", "2 Small bedroom"));
        lead.appendChild(getEmployeeElements(doc, lead, "notes", "Should be on time"));
        lead.appendChild(getEmployeeElements(doc, lead, "movedte", "12/15/2017"));
        lead.appendChild(getEmployeeElements(doc, lead, "email", "whalyalexis@gmail.com"));
        lead.appendChild(getEmployeeElements(doc, lead, "phone1", "9045559999"));
        //for output to file, console
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
//        StreamResult console = new StreamResult(System.out);
//        transformer.transform(source, console);
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
        wr.writeBytes(output);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine.trim());
        }
        in.close();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String xmlcontent = response.toString().replaceAll("\n|\r", "");
        String finalXML = xmlcontent.substring(0, xmlcontent.lastIndexOf("<?xml version=\"1.0\"?>"));
        builder = factory.newDocumentBuilder();
        Document doc2 = builder.parse(new InputSource(new StringReader(finalXML)));
        System.out.println("Root element :" + doc2.getDocumentElement().getNodeName());        //print result
        NodeList nodeList = doc2.getChildNodes();
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);
            System.out.println("Node Name =" + tempNode.getNodeName());
            NodeList nodelist2 = tempNode.getChildNodes();
            for (int count2 = 0; count2 < nodelist2.getLength(); count2++) {
                Node tempNode2 = nodelist2.item(count2);
                System.out.println("Node Name =" + tempNode2.getNodeName());
                NodeList nodelist3 = tempNode2.getChildNodes();
                for (int count3 = 0; count3 < nodelist3.getLength(); count3++) {
                    Node tempNode3 = nodelist3.item(count3);
                    System.out.println(tempNode3.getNodeName()+":"+tempNode3.getFirstChild().getNodeValue());
                }
            }
        }
        return "success";
    }

    private String sendLead2() throws MalformedURLException, ProtocolException, IOException, TransformerConfigurationException, ParserConfigurationException, TransformerException {
        String url = "http://lead.hellomoving.com/LEADSGWXML.lidgw?API_ID=CBB90D177F24";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        String USER_AGENT = "Mozilla/5.0";
        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("AAA");
        doc.appendChild(rootElement);
        Element lead = doc.createElement("BBB");
        rootElement.appendChild(lead);
        lead.appendChild(getEmployeeElements(doc, lead, "moverref", "leads@granot.com"));
        lead.appendChild(getEmployeeElements(doc, lead, "servtypeid", XMLMovingDistance.Long.getName()));
        lead.appendChild(getEmployeeElements(doc, lead, "firstname", "Thomas Wills"));
        lead.appendChild(getEmployeeElements(doc, lead, "lastname", "Wills"));
        lead.appendChild(getEmployeeElements(doc, lead, "ocity", "Jacksonville"));
        lead.appendChild(getEmployeeElements(doc, lead, "ostate", "FL"));
        lead.appendChild(getEmployeeElements(doc, lead, "ozip", "32216"));
        lead.appendChild(getEmployeeElements(doc, lead, "dcity", "Columbus"));
        lead.appendChild(getEmployeeElements(doc, lead, "dstate", "OH"));
        lead.appendChild(getEmployeeElements(doc, lead, "dzip", "43219"));
        lead.appendChild(getEmployeeElements(doc, lead, "weight", "4500"));
        lead.appendChild(getEmployeeElements(doc, lead, "movesize", "2 Small bedroom"));
        lead.appendChild(getEmployeeElements(doc, lead, "notes", "Should be on time"));
        lead.appendChild(getEmployeeElements(doc, lead, "movedte", "12/15/2017"));
        lead.appendChild(getEmployeeElements(doc, lead, "email", "whalyalexis@gmail.com"));
        lead.appendChild(getEmployeeElements(doc, lead, "phone1", "9045559999"));
        //        Element rootElement= doc.createElementNS("AAA");
        //        lead.appendChild(getEmployeeElements(doc, lead, "custcode", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "leadno", name));
        //        lead.appendChild(getEmployeeElements(doc, lead, "volume", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "dcountry", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "ocountry", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "movedte2", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "phone2", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "cell", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "source", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "mincount", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "maxcount", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "soldcount", name));
//        lead.appendChild(getEmployeeElements(doc, lead, "repnotes", "~"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others1txt", "~"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others1amt", "0"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others2txt", "~"));
//        lead.appendChild(getEmployeeElements(doc, lead, "others2amt", "0"));
//        lead.appendChild(getEmployeeElements(doc, lead, "label", "~"));
        //for output to file, console
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //for pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
        wr.writeBytes(doc.toString());
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return "success";
    }

    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
