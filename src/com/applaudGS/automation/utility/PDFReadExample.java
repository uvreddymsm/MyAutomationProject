package com.applaudGS.automation.utility;
import com.itextpdf.text.pdf.PdfReader; 
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
// See more at: http://tutorialspointexamples.com/itext-read-pdf-file-in-java/#sthash.im36wXBX.dpuf
public class PDFReadExample {
	public static void main(String args[]){
		try {
			//Create PdfReader instance.
			PdfReader pdfReader = new PdfReader("C:\\Users\\yuvaraju.reddy.Applaud\\Desktop\\FFIEC002_201506_f_v.pdf"); 
			//Get the number of pages in pdf.
			int pages = pdfReader.getNumberOfPages();
			System.out.println("Total No Of Pages : "+pages);
			//Iterate the pdf through pages.
			for(int i=1; i<=pages; i++) {
				//Extract the page content using PdfTextExtractor.
				String pageContent =PdfTextExtractor.getTextFromPage(pdfReader, i);
				//Print the page content on console.
				System.out.println("Content on Page "+ i + ": " + pageContent);
			}
			//Close the PdfReader.
			pdfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		 }
	}
	
}
		
	




