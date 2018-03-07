package com.jsf.testing;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itdev8
 */
public class EmailTest3IMAP {

    public static void check(String host, String protocol, String user, String password, String port) {
        try {
            //create properties field
            Properties properties = new Properties();

            properties.put(String.format("mail.%s.host", protocol), host);
            properties.put(String.format("mail.%s.port", protocol), port);

            // SSL setting
            properties.setProperty(String.format("mail.%s.socketFactory.class", protocol), "javax.net.ssl.SSLSocketFactory");
            properties.setProperty(String.format("mail.%s.socketFactory.fallback", protocol), "false");
            properties.setProperty(String.format("mail.%s.socketFactory.port", protocol), port);

            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore(protocol);

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
//            Message[] messages = emailFolder.getMessages();//to get all messages
            Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));//to get only unread messages
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
//                message.setFlag(Flags.Flag.SEEN, true);
//                message.saveChanges();
                InternetAddress addresses = (InternetAddress) message.getFrom()[0];
                if (addresses.getAddress().equals("nagalokesh.kotha@gmail.com")) {
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("Text: " + message.getContent().toString());
                    validateMessage(message);
                    message.setFlag(Flags.Flag.SEEN, false);
                }
            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //for pop3
//        String host = "pop.gmail.com";// change accordingly
//        String mailStoreType = "pop3";
        // for IMAP
        String mailStoreType = "imap";
        String host = "imap.gmail.com";
        String port = "993";

        String username = "emailsfromcontact@gmail.com";// change accordingly
        String password = "imantechsolutions";// change accordingly

        check(host, mailStoreType, username, password, port);
    }

    public static String validateMessage(Message message) throws MessagingException, IOException {
        Enumeration headerEnumeration;
        Object content = message.getContent();
        if (content instanceof Multipart) {
            Multipart mp = (Multipart) content;
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bp = mp.getBodyPart(i);
                if (Pattern.compile(Pattern.quote("text/html"), Pattern.CASE_INSENSITIVE).matcher(bp.getContentType()).find()) {
                    // found html part
                    String text = (String) bp.getContent();
                    Elements element = Jsoup.parse(text).getElementsByTag("p");
                    List<String> dataList = new ArrayList<String>();
                    for (Element x : element) {
                        dataList.add(x.text().replaceAll("\\u00A0", "").trim().toLowerCase());
                    }
//                    dataList.removeAll(Arrays.asList("", null));
                    Leads lead = new Leads();
                    int fromIndex = dataList.indexOf("Moving From".toLowerCase());
                    int toIndex = dataList.indexOf("Moving To".toLowerCase());
                    int addInfoIndex = dataList.indexOf("Addl. Information".toLowerCase());
                    int contactInfoIndex = dataList.indexOf("Contact Information".toLowerCase());
                    for (int j = 0; j < fromIndex; j++) {
//                        List<Distance> distanceList = leadsDAO.getAllDistances();
//                        Distance removalDistance = leadsDAO.getDistanceByName("Local <50");
                        int removalKey = 0;
//                        for (int i = 0; i < distanceList.size(); i++) {
//                            if (distanceList.get(i).getId().equals(removalDistance.getId())) {
//                                removalKey = i;
//                                break;
//                            }
//                        }
//                        distanceList.remove(removalKey);
//                        for (Distance distanceObj : distanceList) {
//                            if (dataList.get(j).contains(distanceObj.getDistancename().toLowerCase().replaceAll("\\P{L}", " ").trim())) {
//                                lead.setDistanceObj(distanceObj);
//                                break;
//                            }
//                        }
                    }
                    //moving from data
                    for (int j = fromIndex; j < toIndex; j++) {
                        if (dataList.get(j).contains("City".toLowerCase())) {
                            int temp = j + 1;
                            if (lead.getFromAreaName() == null) {
                                lead.setFromAreaName(dataList.get(temp));
                            }
                            continue;
                        }
                        if (dataList.get(j).contains("ZipCode".toLowerCase())) {
                            int temp = j + 1;
                            if (lead.getFromZipcode() == null) {
                                lead.setFromZipcode(dataList.get(temp));
                            }
                            continue;
                        }
                        if (dataList.get(j).contains("Country".toLowerCase())) {
                            int temp = j + 1;
//                            Country countryObj = leadsDAO.getCountryByName(dataList.get(temp).toLowerCase());
//                            if (countryObj != null) {
//                                lead.setFromCountry(countryObj);
//                            } else {
//                                Country country = new Country();
//                                country.setCountryname(dataList.get(temp));
//                                lead.setFromCountry(country);
//                            }
                        }
                    }
                    //moving to data
                    for (int j = toIndex; j < addInfoIndex; j++) {
                        if (dataList.get(j).contains("City".toLowerCase())) {
                            int temp = j + 1;
                            if (lead.getToAreaName() == null) {
                                lead.setToAreaName(dataList.get(temp));
                            }
                            continue;
                        }
                        if (dataList.get(j).contains("ZipCode".toLowerCase())) {
                            int temp = j + 1;
                            if (lead.getToZipcode() == null) {
                                lead.setToZipcode(dataList.get(temp));
                            }
                            continue;
                        }
                        if (dataList.get(j).contains("Country".toLowerCase())) {
                            int temp = j + 1;
//                            Country countryObj = leadsDAO.getCountryByName(dataList.get(temp).toLowerCase());
//                            if (countryObj != null) {
//                                lead.setToCountry(countryObj);
//                            } else {
//                                Country country = new Country();
//                                country.setCountryname(dataList.get(temp));
//                                lead.setToCountry(country);
//                            }
                        }
                    }
                    //Addl. Information data
                    for (int j = addInfoIndex; j < contactInfoIndex; j++) {
                        if (dataList.get(j).contains("Type".toLowerCase())) {
                            int temp = j + 1;
//                            List<MovingSizes> movingSizesList = leadsDAO.getAllMovingSizes();
//                            for (MovingSizes movingSizesObj : movingSizesList) {
//                                if (movingSizesObj.getMovingsizename().toLowerCase().equals(dataList.get(temp).toLowerCase())) {
//                                    lead.setMovingSizes(movingSizesObj);
//                                    Services servicesObj = leadsDAO.getServiceById(movingSizesObj.getServices().getId());
//                                    lead.setServicesObj(servicesObj);
//                                    break;
//                                }
//                            }
                            continue;
                        }
                        if (dataList.get(j).contains("Move Date".toLowerCase())) {
                            int temp = j + 1;
                            try {
                                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                Date movingDate = df.parse(dataList.get(temp));
                                lead.setMovingDate(movingDate);
                            } catch (ParseException exception) {
                                exception.printStackTrace();
                                lead.setMovingDate(null);
                            }
                            continue;
                        }
                        if (dataList.get(j).contains("Comments".toLowerCase())) {
                            int temp = j + 1;
                            lead.setAddlComments(dataList.get(temp));
                        }
                    }
                    //Contact Information data
                    for (int j = contactInfoIndex; j < dataList.size(); j++) {
                        if (dataList.get(j).contains("Name".toLowerCase())) {
                            int temp = j + 1;
                            String leadName = dataList.get(temp);
//                            int i = leadName.indexOf(" ");
//                            if (lead.getFirstName() == null || "".equals(lead.getFirstName())) {
//                                if (i > 0) {
//                                    lead.setFirstName(leadName.substring(0, i));
//                                    lead.setLastName(leadName.substring(i, leadName.length()));
//                                } else {
//                                    lead.setFirstName(leadName);
//                                    lead.setLastName(" ");
//                                }
//                            }
                            continue;
                        }
                        if (dataList.get(j).replaceAll("\\P{L}", "").trim().contains("email")) {
                            int temp = j + 1;
                            if (lead.getEmail() == null) {
                                lead.setEmail(dataList.get(temp).trim());
                            }
                            continue;
                        }
                        if (dataList.get(j).contains("Contact".toLowerCase())) {
                            int temp = j + 1;
                            String ctdetails = dataList.get(temp);
                            String numberOnly = ctdetails.replaceAll("[^0-9]", "");
                            if (numberOnly.length() >= 8) {
                                lead.setMobile(numberOnly);
                            }
                        }
                    }
                } else {
                    // some other bodypart...
                }
            }
        }
        return "";
    }
}
