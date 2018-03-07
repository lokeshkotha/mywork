package com.test;

import com.mongo.location.SpringMongoConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itdev4
 */
public class ExcelUpload {

    @Autowired
    private MongoOperations mongoOperation;
    ApplicationContext ctx;

    public ExcelUpload() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        try {
//            addCities();
        } catch (Exception ex) {
        }
    }

//    public void addCities() throws Exception {
//        FileInputStream file = new FileInputStream(new File("C:\\Users\\itdev4\\Desktop\\cities.xlsx"));
//
////Create Workbook instance holding reference to .xlsx file
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//
////Get first/desired sheet from the workbook
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
////Iterate through each rows one by one
//        Iterator<Row> rowIterator = sheet.iterator();
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
////For each row, iterate through all the columns
//            Iterator<Cell> cellIterator = row.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
////Check the cell type and format accordingly
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "t");
//                        break;
//                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue() + "t");
//                        break;
//                }
//            }
//        }
//    }
//    public void addExcelData() throws FileNotFoundException, IOException {
//        String excelFilePath = "C:\\Users\\itdev4\\Desktop\\cities.xlsx";
//        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
//
//        Workbook workbook = new XSSFWorkbook(inputStream);
//        Sheet firstSheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = firstSheet.iterator();
//
//        while (iterator.hasNext()) {
//            Row nextRow = iterator.next();
//            Iterator<Cell> cellIterator = nextRow.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                }
//                System.out.print(" - ");
//            }
//            System.out.println();
//        }
//
//        workbook.close();
//        inputStream.close();
//    }
    
    public void uploadFeed() throws IOException {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        ExternalContext et = facesContext.getExternalContext();
//        List<Companyconfig> companyConfigs = mdao.getAllCompanyConfig();
//        if (!uploadCsv.getFileName().isEmpty()) {
//            String actualfilename = uploadCsv.getFileName().replaceAll("\\s", "").toLowerCase();
//            /*global*/ csvPath = companyConfigs.get(0).getUploadcsvpath() + actualfilename;
//            /*global*/ csvUrl = companyConfigs.get(0).getUploadcsvurl() + actualfilename;
//            File drivinglicencefile = new File(csvPath);
//            drivinglicencefile.createNewFile();
//            InputStream inputStreamObj = uploadCsv.getInputstream();
//            byte[] sizeinbytes = new byte[(int) uploadCsv.getSize()];
//            inputStreamObj.read(sizeinbytes);
//            OutputStream outputStreamObj = new FileOutputStream(drivinglicencefile);
//            outputStreamObj.write(sizeinbytes);
//            outputStreamObj.close();
//            inputStreamObj.close();
//        }

        List<String> titleandcontent = new ArrayList<String>();

        FileInputStream file = new FileInputStream(new File("C:\\Users\\itdev4\\Desktop\\cities.xlsx"));

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue() + "\t");
//                        break;
//                }
                titleandcontent.add(cell.getStringCellValue());
            }
            System.out.println("");
        }
        file.close();

        List<String> city = new ArrayList<String>();
        List<String> state = new ArrayList<String>();
        for (int i = 0; i < titleandcontent.size(); i++) {
            if (i % 2 == 0) {
                city.add(titleandcontent.get(i));
            } else {
                state.add(titleandcontent.get(i));
            }
        }
        String status = "";
//        for (int i = 0; i < title.size(); i++) {
//            feedObj = new Feedcontent();
//            feedObj.setTitle(title.get(i));
//            feedObj.setContent(content.get(i));
//
//            feedObj.setServiceid(fdao.getServiceByName(servicestring));
//            feedObj.setStatusid(fdao.getStatusByName("Submitted"));
//            feedObj.setCreateddate(new Date());
//            feedObj.setNewsdate(new Date());
//            feedObj.setPublishdate(new Date());
//            feedObj.setCreatedby((Users) facesContext.getExternalContext().getSessionMap().get("loginuser"));
//            status = fdao.addFeedContent(feedObj);
//        }
//        if (status.equals("success")) {
//            facesContext = FacesContext.getCurrentInstance();
//            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Feeds Uploaded Successfully!", "Feeds Uploaded Successfully!"));
//        } else if (status.equals("abc")) {
//            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Feeds already Exists!", "Feeds already Exists!"));
//        }

    }
    
    public void test() throws FileNotFoundException, IOException{
          String excelFilePath = "D:\\cities.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
         
        workbook.close();
        inputStream.close();
    }
}
