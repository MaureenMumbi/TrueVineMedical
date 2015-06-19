/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import DBCONNECT.dbConnect;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MANUEL
 */
public class CommonDiagnosis extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            dbConnect conn= new dbConnect();
            
            String startdate="2015/05/01";
            String enddate="2015/06/30";
            
            
            if(request.getParameter("startdate")!=null){
            startdate=request.getParameter("startdate");
            
            }
            
            if(request.getParameter("enddate")!=null){
            enddate=request.getParameter("enddate");
            
            }
            
            
            //______________________________________________________________________________________
  //                       NOW CREATE THE WORKSHEETS          
  //______________________________________________________________________________________  
            
              XSSFWorkbook wb=new XSSFWorkbook();
              
              
              
              
    //______________________________________________________________________________________
    //______________________________________________________________________________________
              
            XSSFFont font = wb.createFont();
            font.setFontHeightInPoints((short) 18);
            font.setFontName("Cambria");
            font.setColor((short) 0000);
            CellStyle style = wb.createCellStyle();
            style.setFont(font);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            XSSFFont font2 = wb.createFont();
            font2.setFontName("Cambria");
            font2.setColor((short) 0000);
            CellStyle style2 = wb.createCellStyle();
            style2.setFont(font2);
            style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);

            XSSFCellStyle stborder = wb.createCellStyle();
            stborder.setBorderTop(HSSFCellStyle.BORDER_THIN);
            stborder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            stborder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            stborder.setBorderRight(HSSFCellStyle.BORDER_THIN);
            stborder.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            XSSFCellStyle stylex = wb.createCellStyle();
            stylex.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
            stylex.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            stylex.setVerticalAlignment(VerticalAlignment.CENTER);

            XSSFFont fontx = wb.createFont();
            fontx.setColor(HSSFColor.BLACK.index);
            fontx.setFontName("Cambria");
            //fontx.setBold(true);
             font.setFontHeightInPoints((short) 13);
            stylex.setFont(fontx);
            stylex.setWrapText(true);
            
            
            XSSFSheet shet=wb.createSheet("Common Diagnosis");
            
            XSSFRow rw= shet.createRow(0);
            rw.setHeightInPoints(40);
            XSSFCell header=rw.createCell(0);
            header.setCellValue("TRUE VINE MEDICAL CENTER");
            header.setCellStyle(stylex);
         
            for(int a=1;a<=2;a++){
             XSSFCell head=rw.createCell(a);
            head.setCellValue("");
            head.setCellStyle(stylex);
            }
            
            //second row
            XSSFRow rw1= shet.createRow(1);
                 rw1.setHeightInPoints(35);
            XSSFCell header1=rw1.createCell(0);
            header1.setCellValue("COMMON DIAGNOSIS REPORT BETWEEN "+startdate.replace("/","-")+"  AND "+enddate.replace("/", "-"));
            header1.setCellStyle(stylex);
            for(int a=1;a<=2;a++){
             XSSFCell head=rw1.createCell(a);
            head.setCellValue("");
            head.setCellStyle(stylex);
            }
            
            
            shet.setColumnWidth(0, 6000);  
            shet.setColumnWidth(1, 6000);  
            shet.setColumnWidth(2, 6000);  
            shet.addMergedRegion(new CellRangeAddress(0,0,0,2));
            shet.addMergedRegion(new CellRangeAddress(1,1,0,2));
            String selectsicknesses="select treatment, count(treatment) as diagnosis from treatment where treatmentdate between '"+startdate+"' and  '"+enddate+"' group by treatment order by diagnosis DESC";
            
           
            
            System.out.println(""+selectsicknesses);
            conn.rs=conn.state.executeQuery(selectsicknesses);
            String Header[]={"NO","DIAGNOSIS","INSTANCES"};
             XSSFRow H1=shet.createRow(2);
           for(int a=0;a<Header.length;a++){
             XSSFCell head=H1.createCell(a);
            head.setCellValue(Header[a]);
            head.setCellStyle(style2);
            }
          
            int rowpos=3;
            
            while(conn.rs.next()){
             
             XSSFRow r=shet.createRow(rowpos);
             XSSFCell cl=r.createCell(0);
             cl.setCellValue(rowpos-2);
             cl.setCellStyle(style2);
             
             XSSFCell cl1=r.createCell(1);
             cl1.setCellValue(conn.rs.getString(1));
             cl1.setCellStyle(style2);
             
             XSSFCell cl2=r.createCell(2);
             cl2.setCellValue(conn.rs.getString(2));
             cl2.setCellStyle(style2);
             rowpos++;
                
            }
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=DIAGNOSIS_REPORT_"+startdate.replace("/", "-")+"_AND_"+enddate.replace("/","-")+""+".xlsx");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        }   catch (SQLException ex) {
            Logger.getLogger(CommonDiagnosis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
