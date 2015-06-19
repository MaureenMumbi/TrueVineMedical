/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

/**
 *
 * @author MANUEL
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

@SuppressWarnings("unchecked")
public class ConvertPDFPagesToImages {
    public static void main(String[] args) {
        try {
        String sourceDir = "C:/TrueVineMedical/TreatmentForms/a.pdf"; // Pdf files are read from this folder
        String destinationDir = "C:/TrueVineMedical/TreatmentForms/"; // converted images from pdf document are saved here

        File sourceFile = new File(sourceDir);
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
            destinationFile.mkdir();
            System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
        }
        if (sourceFile.exists()) {
            System.out.println("Images copied to Folder: "+ destinationFile.getName());             
            PDDocument document = PDDocument.load(sourceDir);
            List<PDPage> list = document.getDocumentCatalog().getAllPages();
            System.out.println("Total files to be converted -> "+ list.size());

            String fileName = sourceFile.getName().replace(".pdf", "");             
            int pageNumber = 1;
            for (PDPage page : list) {
                BufferedImage image = page.convertToImage();
                File outputfile = new File(destinationDir + fileName +"_"+ pageNumber +".png");
                System.out.println("Image Created -> "+ outputfile.getName());
                ImageIO.write(image, "png", outputfile);
                pageNumber++;
            }
            document.close();
            System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
        } else {
            System.err.println(sourceFile.getName() +" File not exists");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}