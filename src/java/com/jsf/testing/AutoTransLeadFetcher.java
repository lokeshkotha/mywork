/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

/**
 *
 * @author Lokesh Kotha
 */
public class AutoTransLeadFetcher {

    private static String rawEmailBody = "<div dir=\"ltr\"><div class=\"gmail_quote\"><div dir=\"ltr\"><div class=\"gmail_quote\"><span class=\"\"><br>\n"
            + "</span><div link=\"#0563C1\" vlink=\"#954F72\" lang=\"EN-US\">\n"
            + "<div class=\"m_537404009200797677m_7836504656389214657WordSection1\">\n"
            + "<div align=\"center\">\n"
            + "<table class=\"m_537404009200797677m_7836504656389214657MsoNormalTable\" style=\"width:6.25in\" border=\"0\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\">\n"
            + "<tbody>\n"
            + "<tr>\n"
            + "<td style=\"padding:0in 0in 0in 0in\">\n"
            + "<div align=\"center\">\n"
            + "<table class=\"m_537404009200797677m_7836504656389214657MsoNormalTable\" style=\"width:6.25in;border:outset #666666 1.0pt\" border=\"1\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\">\n"
            + "<tbody>\n"
            + "<tr>\n"
            + "<td style=\"border:inset #666666 1.0pt;padding:0in 0in 0in 0in\">\n"
            + "<p class=\"MsoNormal\"><span class=\"\">------------------------------<wbr>------------------------------<wbr>----<br>\n"
            + "There is a Auto Shipping Lead from <a href=\"http://movers.com\" target=\"_blank\">movers.com</a>.<span><br>\n"
            + "<br>\n"
            + "Please do respond within a day so that it still remains hot!!<br>\n"
            + "<br></span>\n"
            + "------------------------------<wbr>------------------------------<wbr>----<br></span>\n"
            + "NAME= byambadalai badam<br>\n"
            + "EMAIL= <a href=\"mailto:badam.byamba@gmail.com\" target=\"_blank\">badam.byamba@gmail.com</a><br>\n"
            + "CONTACT NO.(HOME)= 773 837 4715 Ext-<span class=\"\"><br>\n"
            + "CONTACT PREFERENCE= home<br>\n"
            + "PREFERENCE TIME= anytime<br>\n"
            + "<br></span>\n"
            + "From_CITY=College Station<br>\n"
            + "From_STATE=TX<br>\n"
            + "From_ZIP=77845<br>\n"
            + "From_COUNTRY = USA<br>\n"
            + "To_CITY=La Porte <br>\n"
            + "To_STATE=TX <br>\n"
            + "To_ZIP=77571 <br>\n"
            + "To_COUNTRY=USA<br>\n"
            + "<br>\n"
            + "MOVE DATE=1/5/2018 12:00:00 AM<span class=\"\"><br>\n"
            + "<br>\n"
            + "Vehicle Info:=<br>\n"
            + "<br>\n"
            + "VehicleType1= SUV<br></span>\n"
            + "Make1= Lexus<br>\n"
            + "Model1= RX 330<br>\n"
            + "Year1= 2015<br>\n"
            + "<br>\n"
            + "Running Condition1= No <br>\n"
            + "<br>\n"
            + "<br>\n"
            + "COMMENTS=need to transport salvage cars from copart location to houston sea port<span class=\"\"><br>\n"
            + "<br>\n"
            + "------------------------------<wbr>------------------------------<wbr>----<span><br>\n"
            + "* This Lead is not resale-able.<br>\n"
            + "<br></span>\n"
            + "* Check the leads and reports online 24/7 in Vendors Cornor.<br>\n"
            + "------------------------------<wbr>------------------------------<wbr>----<u></u><u></u></span></p>\n"
            + "</td>\n"
            + "</tr>\n"
            + "</tbody>\n"
            + "</table>\n"
            + "</div>\n"
            + "</td>\n"
            + "</tr>\n"
            + "</tbody>\n"
            + "</table>\n"
            + "</div><span class=\"\"><span>\n"
            + "<p class=\"MsoNormal\"><u></u> <u></u></p>\n"
            + "<p class=\"MsoNormal\"><u></u> <u></u></p>\n"
            + "<p class=\"MsoNormal\"><i>Best Regards,<u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><i> <u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><b><i>Ricky Smith<u></u><u></u></i></b></p>\n"
            + "<p class=\"MsoNormal\"><i>Movers.com<u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><i>Ph.No.: (D) 732-719-4444; (Board) 732-940-4200<u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><i>Fax No.: 732-940-4300<u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><i>Email: <a href=\"mailto:ricky@movers.com\" target=\"_blank\"><span style=\"color:blue\">ricky@movers.com</span></a><u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><i>Websites: <a href=\"http://www.movers.com/\" target=\"_blank\"><span style=\"color:blue\">www.movers.com/</span></a>,\n"
            + "<a href=\"http://www.topmoving.ca/\" target=\"_blank\"><span style=\"color:blue\">http://www.topmoving.ca/</span></a>, \n"
            + "<a href=\"http://www.ukremovalquotes.co.uk/\" target=\"_blank\"><span style=\"color:blue\">http://www.ukremovalquotes.co.<wbr>uk/</span></a>, \n"
            + "<a href=\"http://www.auremovals.com/\" target=\"_blank\"><span style=\"color:blue\">http://www.auremovals.com/</span></a>,\n"
            + "<a href=\"http://www.removalcompanies.co.nz/\" target=\"_blank\"><span style=\"color:blue\">http://www.removalcompanies.co<wbr>.nz/</span></a>,\n"
            + "<a href=\"http://www.packingmaterials.com/\" title=\"http://www.packingmaterials.com\" target=\"_blank\">\n"
            + "<span style=\"color:blue\">www.packingmaterials.com</span></a><u></u><u></u></i></p>\n"
            + "<p class=\"MsoNormal\"><u></u> </p></span></span></div></div></div></div></div><div class=\"gmail_signature\" data-smartmail=\"gmail_signature\"><div dir=\"ltr\"><div><div dir=\"ltr\"><div><div dir=\"ltr\"><br></div></div></div></div></div></div>\n"
            + "</div>";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.parse(rawEmailBody);
            List<String> contentList = new ArrayList<>();
            Element table = doc.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");
            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Elements cols = row.select("td");
                for (Element x : cols) {
                    String[] splittedContent = x.html().split("<br>");
                    for (String content : splittedContent) {
                        String text = Jsoup.clean(content, Whitelist.none());
                        if (!"".equals(text)) {
                            contentList.add(text.toLowerCase());
                        }
                    }
                }
            }
            Boolean validLead = Boolean.FALSE;
            for (String s : contentList) {
                if (s.contains("Auto Shipping Lead".toLowerCase())) {
                    validLead = Boolean.TRUE;
                    break;
                }
            }
            Leads leadObj = new Leads();
            if (validLead) {
                for (String s : contentList) {
                    if (s.contains("NAME".toLowerCase())) {
                        String name = s.substring(s.indexOf("=") + 1, s.length()).trim();
                        int i = name.indexOf(" ");
                        if (leadObj.getFirstName() == null || "".equals(leadObj.getFirstName())) {
                            if (i > 0) {
                                leadObj.setFirstName(name.substring(0, i));
                                leadObj.setLastName(name.substring(i, name.length()).trim());
                            } else {
                                leadObj.setFirstName(name);
                                leadObj.setLastName(" ");
                            }
                        }
                        System.out.println(leadObj.getFirstName());
                        System.out.println(leadObj.getLastName());
                    } else if (s.contains("EMAIL".toLowerCase())) {
                        leadObj.setEmail(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getEmail());
                    } else if (s.contains("CONTACT NO".toLowerCase())) {
                        leadObj.setMobile(s.substring(s.indexOf("=") + 1, s.length()).replaceAll("[^0-9]", "").trim());
                        System.out.println(leadObj.getMobile());
                    } else if (s.contains("From_ZIP".toLowerCase())) {
                        leadObj.setFromZipcode(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getFromZipcode());
                    } else if (s.contains("To_ZIP".toLowerCase())) {
                        leadObj.setToZipcode(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getToZipcode());
                    } else if (s.contains("MOVE DATE".toLowerCase())) {
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        Date movingDate = df.parse(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        leadObj.setMovingDate(movingDate);
                        System.out.println(leadObj.getMovingDate());
                    } else if (s.contains("VehicleType".toLowerCase())) {
                        leadObj.setVehicleBodyTypes(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getVehicleBodyTypes());
                    } else if (s.contains("Make".toLowerCase())) {
                        leadObj.setVehicleMakes(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getVehicleMakes());
                    } else if (s.contains("Model")) {
                        leadObj.setVehicleModels(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getVehicleModels());
                    } else if (s.contains("Year".toLowerCase())) {
                        leadObj.setYear(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getYear());
                    } else if (s.contains("To_CITY".toLowerCase())) {
                        leadObj.setToCity(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getToCity());
                    } else if (s.contains("From_CITY".toLowerCase())) {
                        leadObj.setFromAreaName(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getFromAreaName());
                    } else if (s.contains("To_COUNTRY".toLowerCase())) {
                        leadObj.setToCountry(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getToCountry());
                    } else if (s.contains("From_COUNTRY".toLowerCase())) {
                        leadObj.setFromCountry(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getFromCountry());
                    } else if (s.contains("COMMENTS".toLowerCase())) {
                        leadObj.setAddlComments(s.substring(s.indexOf("=") + 1, s.length()).trim());
                        System.out.println(leadObj.getAddlComments());
                    }
                }
            }
//            for (String s : contentList) {
//                System.out.println(s);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
