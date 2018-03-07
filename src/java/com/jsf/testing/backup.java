package com.jsf.testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itdev8
 */
public class backup {
//                CompanyConfig cc = mdao.getCompanyConfig();
//            if (!bannerImage.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = bannerImage.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-bannerimage") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getBannerimagepath();
//                String bannerImageFilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String bannerImageUrl = cc.getBannerimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File bannerImageFile = new File(bannerImageFilePath);
//                bannerImageFile.createNewFile();
//                InputStream i = bannerImage.getInputstream();
//                byte[] buff = new byte[(int) bannerImage.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(bannerImageFile);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setBannerimageurl(bannerImageUrl);
//            } else {
//                addListingRequestObj.setBannerimageurl("");
//            }
//            if (!smallImage.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = smallImage.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-smallimage") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getMemberlistingsmallimagepath();
//                String smallImageFilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String smallImageUrl = cc.getMemberlistingsmallimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File smallImageFile = new File(smallImageFilePath);
//                smallImageFile.createNewFile();
//                InputStream i = smallImage.getInputstream();
//                byte[] buff = new byte[(int) smallImage.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(smallImageFile);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setSmallimageurl(smallImageUrl);
//            } else {
//                addListingRequestObj.setSmallimageurl("");
//            }
//            if (!bigImage.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = bigImage.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-bigimage") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getMemberlistingbigimagepath();
//                String bigImageFilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String bigImageUrl = cc.getMemberlistingbigimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File bigImageFile = new File(bigImageFilePath);
//                bigImageFile.createNewFile();
//                InputStream i = bigImage.getInputstream();
//                byte[] buff = new byte[(int) bigImage.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(bigImageFile);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setBigimageurl(bigImageUrl);
//            } else {
//                addListingRequestObj.setBigimageurl("");
//            }
//            if (!additionalImage1.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = additionalImage1.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-addimage1") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getAdlistingimagepath();
//                String addImage1FilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String addImage1Url = cc.getAdlistingimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File addImage1File = new File(addImage1FilePath);
//                addImage1File.createNewFile();
//                InputStream i = additionalImage1.getInputstream();
//                byte[] buff = new byte[(int) additionalImage1.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(addImage1File);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setImageurl1(addImage1Url);
//            } else {
//                addListingRequestObj.setImageurl1("");
//            }
//            if (!additionalImage2.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = additionalImage2.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-addimage2") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getAdlistingimagepath();
//                String addImage2FilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String addImage2Url = cc.getAdlistingimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File addImage2File = new File(addImage2FilePath);
//                addImage2File.createNewFile();
//                InputStream i = additionalImage1.getInputstream();
//                byte[] buff = new byte[(int) additionalImage1.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(addImage2File);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setImageurl2(addImage2Url);
//            } else {
//                addListingRequestObj.setImageurl2("");
//            }
//            if (!additionalImage3.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = additionalImage3.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-addimage3") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getAdlistingimagepath();
//                String addImage3FilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String addImage3Url = cc.getAdlistingimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File addImage3File = new File(addImage3FilePath);
//                addImage3File.createNewFile();
//                InputStream i = additionalImage3.getInputstream();
//                byte[] buff = new byte[(int) additionalImage3.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(addImage3File);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setImageurl3(addImage3Url);
//            } else {
//                addListingRequestObj.setImageurl3("");
//            }
//            if (!additionalImage4.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = additionalImage4.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-addimage4") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getAdlistingimagepath();
//                String addImage4FilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String addImage4Url = cc.getAdlistingimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File addImage4File = new File(addImage4FilePath);
//                addImage4File.createNewFile();
//                InputStream i = additionalImage4.getInputstream();
//                byte[] buff = new byte[(int) additionalImage4.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(addImage4File);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setImageurl4(addImage4Url);
//            } else {
//                addListingRequestObj.setImageurl4("");
//            }
//            if (!additionalImage5.getFileName().isEmpty()) {
//                int time = (int) (new Date().getTime() / 1000);
//                String filename = additionalImage5.getFileName();
//                String modifiedFileName = mObj.getMembershipid().toString().concat("-addimage5") + String.valueOf(time).replaceAll("\\s", "-");
//                String path = cc.getAdlistingimagepath();
//                String addImage5FilePath = path + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                String addImage5Url = cc.getAdlistingimageurl() + modifiedFileName + filename.substring(filename.lastIndexOf("."), filename.length());
//                File addImage5File = new File(addImage5FilePath);
//                addImage5File.createNewFile();
//                InputStream i = additionalImage5.getInputstream();
//                byte[] buff = new byte[(int) additionalImage5.getSize()];
//                i.read(buff);
//                OutputStream os = new FileOutputStream(addImage5File);
//                os.write(buff);
//                os.close();
//                i.close();
//                addListingRequestObj.setImageurl5(addImage5Url);
//            } else {
//                addListingRequestObj.setImageurl5("");
//            }
}
