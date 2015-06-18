/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

/**
 *
 * @author MANUEL
 */
public class PrintForm extends HttpServlet {

    
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
            
            XWPFDocument document = new XWPFDocument();
            
            //XWPFTestDataSamples.openSampleDocument("TestDocument.docx");
                String allpath = getServletContext().getRealPath("/card.docx");
                
                System.out.println("__PATH OF CARD::"+allpath);
            FileOutputStream outStream = null;
            
            //create the
           
            String tableheaders[]={"Patients Name","Patients Id","Age","Date of Treatment","Treatment","Prescription","Referral"};
            String tablevals[]={name,regno,age,date,treatment,prescription,refferall};
            
        XWPFTable tbl = document.createTable(1,2);
  
        //XWPFTableRow rw = tbl.createRow();
        //rw.createCell().setText("TRUEVINE CHILD HEALTH CENTRE");
        
        CTTblPr tblPr = tbl.getCTTbl().getTblPr();
        CTString styleStr = tblPr.addNewTblStyle();
        styleStr.setVal("StyledTable");
        
            
            XWPFParagraph paragraphFour = tbl.getRow(0).getCell(0).getParagraphs().get(0);
            paragraphFour.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun paragraphFourRunOne = paragraphFour.createRun();
            paragraphFourRunOne.setBold(true);
           // paragraphFourRunOne.setUnderline(UnderlinePatterns.SINGLE);
            paragraphFourRunOne.setFontSize(15);
            paragraphFourRunOne.setFontFamily("Cambria");
            paragraphFourRunOne.setColor("007000");
            paragraphFourRunOne.setText("TRUEVINE CHILD HEALTH CENTRE");         
            
            //mergeCellsHorrizontally(tbl, 0, 0, 0);
           
             spanCellsAcrossRow(tbl, 0, 0, 2);
                XWPFTable tbl1 = document.createTable(7,2);
            
            
                //create a looped table
                          for (int a = 0; a < tableheaders.length; a++) {

                XWPFParagraph paragraphOne = tbl1.getRow(a).getCell(0).getParagraphs().get(0);
                paragraphOne.setAlignment(ParagraphAlignment.LEFT);
                //Print the names
                XWPFRun paragraphOneRunOne = paragraphOne.createRun();
                paragraphOneRunOne.setFontSize(12);
                paragraphOneRunOne.setFontFamily("Cambria");
                paragraphOneRunOne.setBold(true);
                paragraphOneRunOne.addBreak();
                paragraphOneRunOne.setText(tableheaders[a]);
            //second column

                XWPFParagraph paragraphOne1 = tbl1.getRow(a).getCell(1).getParagraphs().get(0);
                paragraphOne1.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun paragraphOneRunOne1 = paragraphOne1.createRun();
                paragraphOneRunOne1.setFontSize(12);
                paragraphOneRunOne1.setItalic(true);
                paragraphOneRunOne1.setFontFamily("Cambria");
               
                // paragraphOneRunOne1.addBreak();
                paragraphOneRunOne1.setText(tablevals[a]);

            }

           String pt = getServletContext().getRealPath("db.jsp");                  
         String mydrive = pt.substring(0, 1);
         
     String formpath=mydrive+":\\TrueVineMedical\\TreatmentForms"; 
       
     new File(formpath).mkdirs();
       String finapath=  formpath+"\\"+name.replace(" ","_") + date.replace("-","_") + ".docx";                 
        
//             FileWriter outFile = new FileWriter(finapath ,false);
//       PrintWriter out = new PrintWriter(outFile);
//       out.print(document);
//       out.close();   
       
       FileOutputStream outstream = new FileOutputStream(finapath);
        document.write(outstream);
        outstream.close();
        
       
       FileWriter outFile = new FileWriter(finapath ,false);
       PrintWriter out = new PrintWriter(outFile);
       out.print(out); /**/
       out.close(); 
        
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
            session.setAttribute("treatmentmsg", "<h4><font color=\"green\">Treatment details saved successfully</font></h4>");            
             //String nextpage="treatment.jsp?name="+name+"&age="+age+"&regNo="+regno;
              String index="";
             String  form[]= new String[]{};
             if(session.getAttribute("form")!=null){
            form=(String[]) session.getAttribute("form");

         int indexes=0;
         session = request.getSession();
         if(session.getAttribute("index")!=null){
       index=session.getAttribute("index").toString();
       
       indexes=Integer.parseInt(index)+1;
         }
      System.out.println("length"+form.length);
      System.out.println("lengths"+indexes);
         if(Integer.parseInt(index)==form.length-1){   
             response.sendRedirect("viewChildDetails.jsp");}

         else{
              response.sendRedirect(form[indexes]);
         }
         
        session.setAttribute("index",indexes);}
       
         
            
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
    
    
   private void spanCellsAcrossRow(XWPFTable table, int rowNum, int colNum, int span) {
    XWPFTableCell  cell = table.getRow(rowNum).getCell(colNum);
    //cell.getCTTc().getTcPr().addNewGridSpan();
    if (cell.getCTTc().getTcPr() == null) cell.getCTTc().addNewTcPr();
if (cell.getCTTc().getTcPr().getGridSpan() == null) cell.getCTTc().getTcPr().addNewGridSpan();

    cell.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long)span));
}
 
    
    
}
