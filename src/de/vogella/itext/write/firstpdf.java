

package de.vogella.itext.write;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**

 */
public class firstpdf   {

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {

        Document document = new Document();

        Connection con = null;
       String URL = "jdbc:mysql://localhost:3306/pdf";
      String USER = "root";
       String PASS = "";
       System.out.println("1");
        
       
      // con=DriverManager.getConnection("jdbc:odbc:thin:@localhost:1521:xxxx","scott","tiger"); 

      // I think you have missed the database name. Replace the database name with xxxx 
       // Connection conn = DriverManager.getConnection("jdbc:oracle://192.168.184.44:SS4/NewEdge_SS4","tlm_dbo","password");
        
        try {
			PdfWriter.getInstance(document,
			        new FileOutputStream("HelloWorld.pdf"));
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("2");
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("3");
       
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
		    Statement stm = conn.createStatement();
		    ResultSet rs = stm.executeQuery("select CATEGORY_CODE,CURRENCY,PROCESSING_DATE,F10_SUM_AMT,GOLD_SUM_AMT,AMT_DIFF from BROKERAGE_F10_GOLD_SG_NE_UK");
		    System.out.println("4");
		
		    while (rs.next()) {
	        	// write a country to the text file
		    	
		    	  System.out.println("5");
		         String first = rs.getString("CATEGORY_CODE");
		         String f2 = rs.getString("CURRENCY");
		         String f3 = rs.getString("PROCESSING_DATE");
		         String f4 = rs.getString("F10_SUM_AMT");
		         String f5 = rs.getString("GOLD_SUM_AMT");
		         String f6 = rs.getString("AMT_DIFF");
		         System.out.println("6");
		    	document.open();
		    	 try {
		    		  System.out.println("7");
					document.add(new Paragraph(first));
					document.add(new Paragraph(f2));
					document.add(new Paragraph(f3));
					document.add(new Paragraph(f4));
					document.add(new Paragraph(f5));
					document.add(new Paragraph(f6));
					document.add(new Paragraph("=============="));
					  System.out.println("8");
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    	 System.out.println("9");
				 document.close();
				 System.out.println("9.1");
				// rs.close();
				 System.out.println("9.2");
		    
				 System.out.println("9.3");
				 conn.close();
				 System.out.println("9.4");
				 stm.close();


    }
}