/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class ChildDetails extends HttpServlet {

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
     String FName="";
          String MName="";
          String SName="";
          String regno="";
          String dob="";
          String age="";
          String MothersFName="";
          String MothersMName="";
          String MothersSName="";
          String mothersphoneno="";
          String mothersoccupation="";
         
          String FathersFName="";
          String FathersMName="";
          String FathersSName="";
          String Fathersphoneno="";
          String Fathersoccupation="";
          String Fathersworkplace="";
          String Insurance="";
          String PatientID="";
          HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        dbConnect conn = new dbConnect();
           session = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
         
          if(!request.getParameter("FName").equals("") && request.getParameter("FName")!=null){
          FName=request.getParameter("FName");
          }
          if(!request.getParameter("MName").equals("") && request.getParameter("MName")!=null){
          MName=request.getParameter("MName");
          }
          if(!request.getParameter("SName").equals("") && request.getParameter("SName")!=null){
          SName=request.getParameter("SName");
          }
          if(!request.getParameter("regno").equals("") && request.getParameter("regno")!=null){
          regno=request.getParameter("regno");
          }
          if(!request.getParameter("dob").equals("") && request.getParameter("dob")!=null){
          dob=request.getParameter("dob");
          }
          
          if(!request.getParameter("age").equals("") && request.getParameter("age")!=null){
          age=request.getParameter("age");
          }
          
          if(!request.getParameter("dob").equals("") && request.getParameter("dob")!=null){
          dob=request.getParameter("dob");
          }
          
          if(!request.getParameter("MothersFName").equals("") && request.getParameter("MothersFName")!=null){
          MothersFName=request.getParameter("MothersFName");
          }
          
          if(!request.getParameter("MothersMName").equals("") && request.getParameter("MothersMName")!=null){
          MothersMName=request.getParameter("MothersMName");
          }
          
          if(!request.getParameter("MothersSName").equals("") && request.getParameter("MothersSName")!=null){
          MothersSName=request.getParameter("MothersSName");
          }
          if(!request.getParameter("mothersphoneno").equals("") && request.getParameter("mothersphoneno")!=null){
          mothersphoneno=request.getParameter("mothersphoneno");
          }
          if(!request.getParameter("mothersoccupation").equals("") && request.getParameter("mothersoccupation")!=null){
          mothersoccupation=request.getParameter("mothersoccupation");
          }
          if(!request.getParameter("FathersFName").equals("") && request.getParameter("FathersFName")!=null){
          FathersFName=request.getParameter("FathersFName");
          }
          
          if(!request.getParameter("FathersMName").equals("") && request.getParameter("FathersMName")!=null){
          FathersMName=request.getParameter("FathersMName");
          }
            
          if(!request.getParameter("FathersSName").equals("") && request.getParameter("FathersSName")!=null){
          FathersSName=request.getParameter("FathersSName");
          }
          
          if(!request.getParameter("Fathersphoneno").equals("") && request.getParameter("Fathersphoneno")!=null){
          Fathersphoneno=request.getParameter("Fathersphoneno");
          }
             if(!request.getParameter("Fathersoccupation").equals("") && request.getParameter("Fathersoccupation")!=null){
          Fathersoccupation=request.getParameter("Fathersoccupation");
          }
          if(!request.getParameter("Fathersworkplace").equals("") && request.getParameter("Fathersworkplace")!=null){
          Fathersworkplace=request.getParameter("Fathersworkplace");
          }
         
          if(!request.getParameter("Insurance").equals("") && request.getParameter("Insurance")!=null){
          Insurance=request.getParameter("Insurance");
          }
          String userid="";
          if(session.getAttribute("username")!=null){
          userid = (String) session.getAttribute("username");
          }
           PatientID = uniqueid(regno);
           session.setAttribute("PatientID", PatientID);
         if(regno!=null && !regno.equals("")) {
         String insert ="insert into basicdetails set PatientID=?, FName=?,SName=?, LName=?,RegNo=?,DOB=?,Age=?, userid=?";
         
         
         
         conn.ps1=conn.connect.prepareStatement(insert);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 conn.ps1.setString(1, PatientID);   
 conn.ps1.setString(2, FName); 
 conn.ps1.setString(3, MName); 
 conn.ps1.setString(4, SName); 
 conn.ps1.setString(5 ,regno); 
 conn.ps1.setString(6,dob); 
 conn.ps1.setString(7,age); 
 conn.ps1.setString(8,userid); 
 
 conn.ps1.executeUpdate();

         
         
       //  conn.state.executeUpdate(insert);
         String mothersdetails="insert into parentdetails set PatientID=?, FName=?,MName=?, LName=?,PhoneNo=?,Occupation=?,Parenttype=?, userid=?";
        
           conn.ps2=conn.connect.prepareStatement(mothersdetails);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 conn.ps2.setString(1, PatientID);   
 conn.ps2.setString(2, MothersFName); 
 conn.ps2.setString(3, MothersMName); 
 conn.ps2.setString(4, MothersSName); 
 conn.ps2.setString(5 ,mothersphoneno); 
 conn.ps2.setString(6,mothersoccupation); 
 conn.ps2.setString(7,"Mother"); 
 conn.ps2.setString(8,userid); 
 
 conn.ps2.executeUpdate();
         
         
         
         
         // conn.state1.executeUpdate(mothersdetails);
         String fathersdetails="insert into parentdetails set PatientID=?, FName=?,MName=?, LName=?,PhoneNo=?,Occupation=?,Parenttype=?,Company=? ,insurance=?,userid=?";
//         conn.state2.executeUpdate(fathersdetails);
         
         conn.ps=conn.connect.prepareStatement(fathersdetails);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 conn.ps.setString(1, PatientID);   
 conn.ps.setString(2, FathersFName); 
 conn.ps.setString(3, FathersMName); 
 conn.ps.setString(4, FathersSName); 
 conn.ps.setString(5 ,Fathersphoneno); 
 conn.ps.setString(6,Fathersoccupation); 
 conn.ps.setString(7,"Father"); 
 conn.ps.setString(8,Fathersworkplace); 
 conn.ps.setString(9,Insurance); 
 conn.ps.setString(10,userid); 
 
 conn.ps.executeUpdate();
         System.out.println(insert);
         System.out.println(mothersdetails);
         System.out.println(fathersdetails);
         
          }
         
          response.sendRedirect("financialtransaction.jsp");
        } catch(SQLException ex) {            
//            out.println("Registration No "+regno +" already exists");
//            response.sendRedirect("financialtransaction.jsp");
            System.out.println(ex.toString());
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
            Logger.getLogger(ChildDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ChildDetails.class.getName()).log(Level.SEVERE, null, ex);
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


   public String uniqueid(String regno){

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
    

        return regno+ "/" + month + "/"  + generateRandomNumber(800, 9000);
                             }

    public int generateRandomNumber(int start, int end) {
        Random random = new Random();
        long fraction = (long) ((end - start + 1) * random.nextDouble());
        return ((int) (fraction + start));
    }


}
