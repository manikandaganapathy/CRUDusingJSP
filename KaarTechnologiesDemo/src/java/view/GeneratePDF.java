package view;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneratePDF {
    static String query;
    static Connection conn;
    static Statement stmt;
    static ResultSet res;
    static DBConnection dbconn;
    static List lst=new ArrayList();        
        
        
	private static Font TIME_ROMAN = 
			new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = 
			new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);


	/**
	 * @param args
	 */
	public static Document createPDF(String file) {
		
	Document document = null;

	try {
		document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();

		addMetaData(document);

		addTitlePage(document);
		
		createTable(document);
		
		document.close();

	} catch (FileNotFoundException | DocumentException e) {
		
		e.printStackTrace();
	}
	return document;

	}

	private static void addMetaData(Document document) {
		document.addTitle("Manikandan Ganapathy");
		document.addSubject("Generate PDF report");
		document.addAuthor("Manikandan Ganapathy");
		document.addCreator("Manikandan Ganapathy");
	}

	private static void addTitlePage(Document document)
			throws DocumentException {
		
		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("PDF Report", TIME_ROMAN));

		creteEmptyLine(preface, 1);
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("MM/dd/yyyy");
		preface.add(new Paragraph(
				"Report created on "+ simpleDateFormat
				.format(new Date()),TIME_ROMAN_SMALL));
		document.add(preface);
		
		
	}

	private static void creteEmptyLine(Paragraph paragraph, 
			int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	private static void createTable(Document document) 
			throws DocumentException {		
	try {
            dbconn=new DBConnection();
            conn=dbconn.setConnection();
            stmt=conn.createStatement();
            query="select * from manu";
            res=dbconn.getResult(query, conn);
            while(res.next()){
               lst.add(res.getString("num"));
               lst.add(res.getString("fromdate"));
               lst.add(res.getString("todate"));
               lst.add(res.getString("des"));
               lst.add(res.getString("role"));
                lst.add(res.getString("tech"));
            }
            res.close();
        }catch (Exception e){
            
        }finally{
            Iterator itr;
            Paragraph paragraph = new Paragraph();
	creteEmptyLine(paragraph, 2);
	document.add(paragraph);
	PdfPTable table = new PdfPTable(6);		

	PdfPCell c1 = new PdfPCell(new Phrase("Serial no."));
	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(c1);

	c1 = new PdfPCell(new Phrase("From"));
	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(c1);
        
c1 = new PdfPCell(new Phrase("To"));
	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Description"));
	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(c1);
        
	c1 = new PdfPCell(new Phrase("Role"));
	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Technology"));
	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(c1);
	table.setHeaderRows(1);
	
       for (itr = lst.iterator(); itr.hasNext();) {
                    String s = (String) itr.next();
                    
                
		table.setWidthPercentage(100);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
              
		table.addCell(s);
		table.addCell((String) itr.next());
		
			
        }
	document.add(table);
            
                
            lst.clear();
            
        }
            
        
	}
}