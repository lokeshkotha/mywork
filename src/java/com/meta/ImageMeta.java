/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.meta;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Lokesh Kotha
 */
public class ImageMeta {

    private UploadedFile file;

    public static void main(String[] args) {
        ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("png").next();
        ImageWriteParam writeParam = imageWriter.getDefaultWriteParam();
        ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);

    }
}
