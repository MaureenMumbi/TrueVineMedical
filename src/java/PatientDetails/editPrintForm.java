/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





/**
 *
 * @author MANUEL
 */
public class editPrintForm extends HttpServlet {

    
    HttpSession session=null;
   String isprint="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
          isprint="";
            
            PrinterClass print=new PrinterClass();
            
            session=request.getSession();
            
            String name="";
            String age="";
            String fdate="";
            String date="";
            String prescription="";
            String refferall="";
            String regno="";
            String treatment="";
            String userid="Not Known";
            name=request.getParameter("name");
            age=request.getParameter("age");
            isprint=request.getParameter("isprint1");
            
            System.out.println("__"+request.getParameter("isprint1"));
            fdate=request.getParameter("date1");
            prescription=request.getParameter("prescription");
            
            String refs[]=request.getParameterValues("refferal");
            treatment=request.getParameter("treatment");
            regno=request.getParameter("reg");
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Calendar cal = Calendar.getInstance();
            date= dateFormat.format(cal.getTime());
            
            for(int a=0;a<refs.length;a++){
            
            refferall+=""+refs[a]+",";    
            
            }
            
            
            
            //save the document first
            
            dbConnect conn=new dbConnect();
            
            
             if(session.getAttribute("userid")!=null){
                userid=session.getAttribute("userid").toString();
            }
            
            
            String checkttreatment="select * from treatment where PatientId='"+regno+"' and treatmentdate='"+fdate+"'";
            
            
            
            conn.rs=conn.state.executeQuery(checkttreatment);
            if(!conn.rs.next()){           
                                
            //now save the new details
                
                
                String savedata=" insert into treatment (PatientID,treatmentdate,Prescription,referral,userid,treatment) values (?,?,?,?,?,?)";
                
              conn.ps1=conn.connect.prepareStatement(savedata);
            
            //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
            conn.ps1.setString(1, regno);
            conn.ps1.setString(2, fdate);
            conn.ps1.setString(3, prescription);
            conn.ps1.setString(4, refferall);
            conn.ps1.setString(5, userid);
            conn.ps1.setString(6, treatment);        
            
            conn.ps1.executeUpdate();
            
            
            }
            
            else {
            
            String update="update treatment set Prescription=? , referral=? , treatment=? where PatientID='"+regno+"' and treatmentdate='"+fdate+"'";
                
            conn.ps1=conn.connect.prepareStatement(update);
            
            //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
            conn.ps1.setString(1, prescription);
            conn.ps1.setString(2, refferall);
            conn.ps1.setString(3, treatment);
                   
            
            conn.ps1.executeUpdate();
            
            
            
            
            }
//creation of document and printing begins here
            
            
            //this part can be skipped
            
            
           // XWPFDocument document = new XWPFDocument();
            if(isprint.equalsIgnoreCase("yes")){
                
                              
                
                
                //------------------------------PDF ENDS HERE-------
       
           String tablevals[]={name,regno,age,date,treatment,prescription,refferall};
         

           String pt = getServletContext().getRealPath("db.jsp");                  
         String mydrive = pt.substring(0, 1);
         
     String formpath=mydrive+":\\TrueVineMedical\\TreatmentForms"; 
       
     new File(formpath).mkdirs();
       String finapath=  formpath+"\\"+name.replace(" ","_") + date.replace("-","_") + ".pdf";                 
        

        
        
     
        
                try {
                    //----------------------------------------------------------
    
                    createPdf(finapath,tablevals);
                    
                } catch (DocumentException ex) {
                    Logger.getLogger(PrintForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                
                
        
        
        
        
        
       
        
        print.printform(finapath);
          //now call the print
        
        
        
//            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
//            document.write(outByteStream);
//            byte[] outArray = outByteStream.toByteArray();
//            response.setContentType("application/ms-excel");
//            response.setContentLength(outArray.length);
//            response.setHeader("Expires:", "0"); // eliminates browser caching
//            response.setHeader("Content-Disposition", "attachment; filename="+name.replace(" ","_") + date + ".docx");
//            OutputStream out1Stream = response.getOutputStream();
//            out1Stream.write(outArray);
//            out1Stream.flush();
//            
            }
            else {
            
                
               
            }
                session.setAttribute("updtreatmentmsg", "<h4> <font color=\"green\"> Treatment details saved successfully </font></h4>");            
             String index="";
      
      String  form[]= new String[]{};
            form=(String[]) session.getAttribute("form");

     int indexes=0;
       
         if(session.getAttribute("index")!=null){
       index=session.getAttribute("index").toString();
       
       indexes=Integer.parseInt(index)+1;
         }
      System.out.println("length"+form.length);
      System.out.println("lengths"+indexes);
         if(Integer.parseInt(index)==form.length-1){   
             response.sendRedirect("manageforms.jsp");}

         else{
              response.sendRedirect(form[indexes]);
         }
         
        session.setAttribute("index",indexes);
         
            
        } catch (SQLException ex) {
            Logger.getLogger(PrintForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    

   
   
   
   
    public void createPdf(String filename,String [] Tablevalue)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(createFirstTable(Tablevalue));
        // step 5
        document.close();
    }
   
   
     public static PdfPTable createFirstTable(String [] tablevalues) {
         
 String tableheaders[]={"Patients Name","Patients Id","Age","Date of Treatment","Treatment","Prescription","Referral"};
           
     
      
        Font fontbold = FontFactory.getFont("Times-Roman", 14, Font.BOLD);
        fontbold.setColor(255,0,0);
    
        Font fontbolds = FontFactory.getFont("Times-Roman", 13, Font.BOLD);
         fontbolds.setColor(255,0,0);
        Font fontboldsl = FontFactory.getFont("Times-Roman", 11, Font.BOLD);
        //document.add(new Paragraph("Times-Roman, Bold", fontbold));
    	// a table with three columns
        PdfPTable table = new PdfPTable(2);
        
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("TRUEVINE CHILD HEALTH CENTRE ",fontbold));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Patient's Treatment Card",fontbolds));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        // we add the four remaining cells with addCell()
        for( int a=0;a<tableheaders.length;a++){
        cell = new PdfPCell(new Phrase(tableheaders[a],fontboldsl));
     
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);
    
        table.addCell(tablevalues[a]);
        }
        return table;
    }
    
    
}
