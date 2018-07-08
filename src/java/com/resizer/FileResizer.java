/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.resizer;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Lokesh Kotha
 */
public class FileResizer {

    /**
     * Creates a new instance of FileResizer
     */
    public FileResizer() {
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
            Image img = null;
            BufferedImage tempJPG1 = null;
            BufferedImage tempJPG2 = null;
            BufferedImage tempJPG3 = null;
            BufferedImage tempJPG4 = null;
            BufferedImage tempJPG5 = null;
            BufferedImage tempJPG6 = null;
            File newFileJPG1 = null;
            File newFileJPG2 = null;
            File newFileJPG3 = null;
            File newFileJPG4 = null;
            File newFileJPG5 = null;
            File newFileJPG6 = null;
            img = ImageIO.read(file.getInputstream());
            tempJPG1 = resizeImage(img, 80, 80);
            tempJPG2 = resizeImage(img, 250, 250);
            tempJPG3 = resizeImage(img, 458, 458);
            tempJPG4 = resizeImage(img, 125, 125);
            tempJPG5 = resizeImage(img, 98, 98);
            tempJPG6 = resizeImage(img, 800, 800);
            newFileJPG1 = new File("/home/itdev-8/Desktop/test/1/" + file.getFileName().substring(0, file.getFileName().lastIndexOf(".")) + "-cart_default.jpg");
            newFileJPG2 = new File("/home/itdev-8/Desktop/test/1/" + file.getFileName().substring(0, file.getFileName().lastIndexOf(".")) + "-home_default.jpg");
            newFileJPG3 = new File("/home/itdev-8/Desktop/test/1/" + file.getFileName().substring(0, file.getFileName().lastIndexOf(".")) + "-large_default.jpg");
            newFileJPG4 = new File("/home/itdev-8/Desktop/test/1/" + file.getFileName().substring(0, file.getFileName().lastIndexOf(".")) + "-medium_default.jpg");
            newFileJPG5 = new File("/home/itdev-8/Desktop/test/1/" + file.getFileName().substring(0, file.getFileName().lastIndexOf(".")) + "-small_default.jpg");
            newFileJPG6 = new File("/home/itdev-8/Desktop/test/1/" + file.getFileName().substring(0, file.getFileName().lastIndexOf(".")) + "-thickbox_default.jpg");
            ImageIO.write(tempJPG1, "jpg", newFileJPG1);
            ImageIO.write(tempJPG2, "jpg", newFileJPG2);
            ImageIO.write(tempJPG3, "jpg", newFileJPG3);
            ImageIO.write(tempJPG4, "jpg", newFileJPG4);
            ImageIO.write(tempJPG5, "jpg", newFileJPG5);
            ImageIO.write(tempJPG6, "jpg", newFileJPG6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function resize the image file and returns the BufferedImage object
     * that can be saved to file system.
     */
    public static BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
}
