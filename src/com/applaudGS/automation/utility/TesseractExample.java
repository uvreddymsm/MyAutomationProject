package com.applaudGS.automation.utility;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample {

    public static void main(String[] args) throws TesseractException {
    	
       /* File imageFile = new File("D:\\RQUEST_WorkSpace\\Tess4jProject\\Images\\multipagetiff.tiff");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
   //    ITesseract instance = new Tesseract1(); // JNA Direct Mapping

            String result = instance.doOCR(imageFile);
            String result = instance.doOCR(imageFile);
            System.out.println("Hey Buddy This Is The Test Reading From TIFF Format Image");
            System.out.println("----------------------------------------------------------");
            System.out.println(result);*/
    }
    
    
    @Test
    public void sample() throws TesseractException{
    	File imageFile = new File("D:\\RQUEST_WorkSpace\\Tess4jProject\\Images\\multipagetiff.tiff");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
   //    ITesseract instance = new Tesseract1(); // JNA Direct Mapping

          /*  String result = instance.doOCR(imageFile);*/
            String result = instance.doOCR(imageFile);
            System.out.println("Hey Buddy This Is The Test Reading From TIFF Format Image");
            System.out.println("----------------------------------------------------------");
            System.out.println(result);
    }
}
