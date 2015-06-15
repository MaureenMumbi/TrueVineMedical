/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author Maureen
 */
public class monthlyattendance extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        try {
            String Year=request.getParameter("year");
          
            dbConnect conn = new dbConnect();
             HSSFWorkbook wb=new HSSFWorkbook();
          HSSFSheet shet1=wb.createSheet("By Sex");
          HSSFSheet shet2=wb.createSheet("By Age");
        
          String startdate="";
          String enddate="";
          String period="";
          
      
          
        //Styles for the created work Book
          //Code showing the font of the styles
          HSSFFont font_header=wb.createFont();
    font_header.setFontHeightInPoints((short)10);
    font_header.setFontName("Arial Black");
//    font.setItalic(true);
    font_header.setBoldweight((short)15);
    font_header.setColor(HSSFColor.BLACK.index);
          //Style for the row showing the start date of the report
    //Cell Style known as "style_header"
          CellStyle style_header=wb.createCellStyle();
    style_header.setFont(font_header);
    style_header.setWrapText(true);
    style_header.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
 
            style_header.setBorderBottom(CellStyle.BORDER_THIN);
            style_header.setBorderLeft(CellStyle.BORDER_THIN);
            style_header.setBorderRight(CellStyle.BORDER_THIN);
            style_header.setBorderTop(CellStyle.BORDER_THIN);
            style_header.setAlignment(CellStyle.ALIGN_CENTER);
            
            //Creating yellow for the years
            CellStyle year_style_header=wb.createCellStyle();
    year_style_header.setFont(font_header);
    year_style_header.setWrapText(true);
    year_style_header.setFillForegroundColor(HSSFColor.YELLOW.index);
year_style_header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
 
            year_style_header.setBorderBottom(CellStyle.BORDER_THIN);
            year_style_header.setBorderLeft(CellStyle.BORDER_THIN);
            year_style_header.setBorderRight(CellStyle.BORDER_THIN);
            year_style_header.setBorderTop(CellStyle.BORDER_THIN);
            year_style_header.setAlignment(CellStyle.ALIGN_CENTER);
            
            
            //Cell Style header known as "indicator_style"
             CellStyle indicator_style = wb.createCellStyle();
              indicator_style.setFillForegroundColor(HSSFColor.PLUM.index);
               indicator_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                HSSFFont fonts = wb.createFont();
                fonts.setColor(HSSFColor.BLACK.index);
                fonts.setFontHeightInPoints((short) 17);
            indicator_style.setFont(fonts);
            indicator_style.setBorderBottom(CellStyle.BORDER_THIN);
            indicator_style.setBorderLeft(CellStyle.BORDER_THIN);
            indicator_style.setBorderRight(CellStyle.BORDER_THIN);
            indicator_style.setBorderTop(CellStyle.BORDER_THIN);
            indicator_style.setAlignment(CellStyle.ALIGN_CENTER);
          
            //Style known as "cell_style"
            CellStyle cell_style = wb.createCellStyle();
          
          
                HSSFFont fonts1 = wb.createFont();
                fonts1.setColor(HSSFColor.BLACK.index);
                fonts1.setFontHeightInPoints((short) 11);
            cell_style.setFont(fonts1);
            cell_style.setBorderBottom(CellStyle.BORDER_THIN);
            cell_style.setBorderLeft(CellStyle.BORDER_THIN);
            cell_style.setBorderRight(CellStyle.BORDER_THIN);
            cell_style.setBorderTop(CellStyle.BORDER_THIN);
            
            //Setting Column width of the DIC NAMES
           
            
     shet1.setColumnWidth(0, 4000);
    shet1.setColumnWidth(1, 6000); 
    shet1.setColumnWidth(2, 4000);
    shet1.setColumnWidth(3, 4000);
    shet1.setColumnWidth(4, 4000);
    shet1.setColumnWidth(5, 4000);
   
    shet2.setColumnWidth(0, 4000);
    shet2.setColumnWidth(1, 4000); 
    shet2.setColumnWidth(2, 4000);
    shet2.setColumnWidth(3, 4000);
    shet2.setColumnWidth(4, 4000);
  
   
            
       HSSFCell cell1,cell101,cell102,cell103,cell2,cell3,cell31,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16,cell17,cell18,cell19,cell20;      
          HSSFFont font=wb.createFont();    
          font.setFontHeightInPoints((short)12);
    font.setFontName("Cambria");

    font.setBoldweight((short)02);
    font.setColor(HSSFColor.BLACK.index);
    CellStyle style=wb.createCellStyle();
    style.setFont(font);
    style.setWrapText(true);
    style.setFillForegroundColor(HSSFColor.GOLD.index);
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    style.setBottomBorderColor(HSSFColor.BRIGHT_GREEN.index);     
   
    HSSFCellStyle stylex = wb.createCellStyle();
stylex.setFillForegroundColor(HSSFColor.WHITE.index);
stylex.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

HSSFFont fontx = wb.createFont();
//fontx.setColor(HSSFColor.DARK_BLUE.index);
      stylex.setFont(fontx);
      stylex.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderTop(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderRight(HSSFCellStyle.BORDER_THIN);
      stylex.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    
     HSSFFont font_header1=wb.createFont();
    font_header1.setFontHeightInPoints((short)10);
    font_header1.setFontName("Arial Black");
//    font.setItalic(true);
    font_header1.setBoldweight((short)05);
    font_header1.setColor(HSSFColor.BLACK.index);
    CellStyle style_header1=wb.createCellStyle();
    style_header1.setFont(font_header);
    style_header1.setWrapText(true);
    style_header1.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
style_header1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
style_header1.getBorderBottom();
style_header1.setBottomBorderColor(HSSFColor.LEMON_CHIFFON.index);
     shet1.addMergedRegion(new CellRangeAddress(0,0,1,7));
    
    
      HSSFRow rw1 =shet1.createRow(1);
              cell10=rw1.createCell(2);
              cell15=rw1.createCell(3);
              cell16=rw1.createCell(4);
              cell10.setCellValue("Monthly Attendance by Sex");   
              cell10.setCellStyle(style_header);
              cell15.setCellStyle(style_header);
              cell16.setCellStyle(style_header);
              
              shet1.addMergedRegion(new CellRangeAddress(1,1,2,4)); 
       HSSFRow rw2 =shet2.createRow(1);
             cell11=rw2.createCell(2);
             cell13=rw2.createCell(3);
             cell14=rw2.createCell(4);
             cell11.setCellValue("Monthly Attendance by Sex");
                 cell11.setCellStyle(style_header);
                 cell13.setCellStyle(style_header);
                 cell14.setCellStyle(style_header);
                 
                 shet2.addMergedRegion(new CellRangeAddress(1,1,2,4)); 
   
      
       rw1 =shet1.createRow(2);
              cell101=rw1.createCell(2);
              cell101.setCellValue("Month ");   
              cell101.setCellStyle(style_header);  
              cell10=rw1.createCell(3);
              cell10.setCellValue("Gender");   
              cell10.setCellStyle(style_header);  
              cell10=rw1.createCell(4);
              cell10.setCellValue("Total");   
              cell10.setCellStyle(style_header);  
             
        rw2 =shet2.createRow(2);
             cell102=rw2.createCell(2);
             cell102.setCellValue("Month");
                 cell102.setCellStyle(style_header);  
             cell11=rw2.createCell(3);
             cell11.setCellValue("Age");
                 cell11.setCellStyle(style_header);  
             cell11=rw2.createCell(4);
             cell11.setCellValue("Total");
                 cell11.setCellStyle(style_header);  
          
           String month="";
           String total="";
           String month1="";
           String total1="";
           String age="";
           String sex="";
           int counter=2;
           int counter1=2;
          int monthcopy=2;
          int monthcopy1=2;
          String monthval1="";
   String getattendance="select monthname(dateRegistered) as months,count(PatientID),Sex from basicdetails where  YEAR(dateRegistered)='"+Year+"' group by months,sex order by month(dateRegistered)";
        System.out.println(getattendance);
        conn.rs= conn.state.executeQuery(getattendance);
        while(conn.rs.next()){
            counter++;
              rw1=shet1.createRow(counter);
            month=conn.rs.getString(1);
            total=conn.rs.getString(2);
            sex=conn.rs.getString(3);
                cell1=rw1.createCell(2);
                cell2=rw1.createCell(3);
                cell3=rw1.createCell(4);
               
              if(monthval1.equals("")){
              monthval1= month;
              System.out.println("88"+monthval1 +"___"+month);
             
                cell1.setCellValue(month);
                shet1.addMergedRegion(new CellRangeAddress(monthcopy,counter-1,2,2));
                monthcopy1=counter;
            
            }
          if(!monthval1.equals("") && !monthval1.equals(month)){
                 monthval1= month;
                System.out.println("!!!"+monthval1 +"___"+month);

                monthcopy1=counter;
               
            }
              shet1.addMergedRegion(new CellRangeAddress(monthcopy1,counter,2,2));  
                
                
             cell1.setCellValue(month);
             cell2.setCellValue(sex);
             cell3.setCellValue(total);
           
             System.out.println(month+"b"+sex+"b"+total);
             
            cell1.setCellStyle(stylex);  
            cell2.setCellStyle(stylex);  
            cell3.setCellStyle(stylex);  
          
        }
        String monthval="";
   String getattendance1="select monthname(dateRegistered) as months,count(PatientID),Age from basicdetails where  YEAR(dateRegistered)='"+Year+"' group by months,age order by month(dateRegistered)";
        
        conn.rs1= conn.state1.executeQuery(getattendance1);
        while(conn.rs1.next()){
            counter1++;
              rw1=shet2.createRow(counter1);
            month1=conn.rs1.getString(1);
            total1=conn.rs1.getString(2);
            age=conn.rs1.getString(3);
                cell1=rw1.createCell(2);
                cell2=rw1.createCell(3);
                cell3=rw1.createCell(4);
               
                 if(monthval.equals("")){
              monthval= month1;
              System.out.println("88"+monthval +"___"+month1);
             
                cell1.setCellValue(month1);
                shet2.addMergedRegion(new CellRangeAddress(monthcopy,counter1-1,2,2));
                monthcopy=counter1;
            
            }
          if(!monthval.equals("") && !monthval.equals(month1)){
                 monthval= month1;
                System.out.println("!!!"+monthval +"___"+month1);

                monthcopy=counter1;
               
            }
              shet2.addMergedRegion(new CellRangeAddress(monthcopy,counter1,2,2));
             System.out.println(month1+"ccc"+sex+"ccc"+total1);     
                
             cell1.setCellValue(month1);
             cell2.setCellValue(age);
             cell3.setCellValue(total1);
           
             
             
            cell1.setCellStyle(stylex);  
            cell2.setCellStyle(stylex);  
            cell3.setCellStyle(stylex);  
          
        }
        
        
          ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
wb.write(outByteStream);
byte [] outArray = outByteStream.toByteArray();
response.setContentType("application/ms-excel");
response.setContentLength(outArray.length);
response.setHeader("Expires:", "0"); // eliminates browser caching
response.setHeader("Content-Disposition", "attachment; filename=MonthlyAttendace_"+Year+".xls");
OutputStream outStream = response.getOutputStream();
outStream.write(outArray);
outStream.flush();
        } finally {            
//            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(monthlyattendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(monthlyattendance.class.getName()).log(Level.SEVERE, null, ex);
        }
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
