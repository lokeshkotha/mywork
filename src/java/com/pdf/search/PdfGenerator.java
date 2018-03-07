/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdf.search;

import com.itextpdf.text.Document;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Map;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Lokesh Kotha
 */
public class PdfGenerator {

    public PdfGenerator() {
    }

    private UploadedFile file;
    private String fileURL;
    private String filePath;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void uploadFile() {
        try {
            String actualfilename = file.getFileName();
            Document document = new Document();
            Calendar calendar = Calendar.getInstance();
            String unique = String.valueOf(calendar.getTimeInMillis());
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/itdev8/Desktop/" + unique + ".pdf"));
            document.addTitle("Hello World stamped");
            document.addSubject("Hello World with changed metadata");
            document.addKeywords("iText in Action, PdfStamper");
            document.addCreator("Silly standalone example");
            document.addAuthor("Also Bruno Lowagie");
            document.add(new Header("Test", "test"));
            document.add(new Header("author2", "waaris"));
            document.add(new Header("Title17", "Hello World stamped"));
            document.add(new Header("Subject785", "Hello World with changed metadata"));
            document.add(new Header("Keywords78", "iText in Action, PdfStamper"));
            document.add(new Header("Creator785", "Silly standalone example"));
            document.add(new Header("Author7858", "Also Bruno Lowagie"));
            document.add(new Header("author3", "uyavsc"));
            writer.createXmpMetadata();
            document.open();
            Image img;
            img = Image.getInstance(file.getContents());
            Paragraph p = new Paragraph("Hello World");
            document.add(p);
            document.add(img);
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readInfo() {
        try {
            Calendar calendar = Calendar.getInstance();
            String unique = String.valueOf(calendar.getTimeInMillis());
            PdfReader reader = new PdfReader(file.getContents());
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("/home/itdev8/Desktop/" + unique + ".pdf"));
            Map<String, String> info = reader.getInfo();
            info.put("Title17", "Hello World stamped");
            info.put("Subject785", "Hello World with changed metadata");
            info.put("Keywords78", "iText in Action, PdfStamper");
            info.put("Creator785", "Silly standalone example");
            info.put("Author7858", "Also Bruno Lowagie");
            stamper.setMoreInfo(info);
            stamper.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
