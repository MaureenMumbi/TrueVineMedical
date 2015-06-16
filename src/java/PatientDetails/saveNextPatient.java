/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class saveNextPatient extends HttpServlet {

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
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        session = request.getSession();
        try {
            dbConnect conn = new dbConnect();
        
              String weight="";
             String temperature="";
             String bp="";
         
             String Userid="";
               String PatientID="";
           if(request.getParameter("PatientID")!=null && !request.getParameter("PatientID").equals("")){
                      PatientID=request.getParameter("PatientID") ;
                        session.setAttribute("PatientID",PatientID);
           }
                if(session.getAttribute("username")!=null){
           Userid= (String) session.getAttribute("username");}
           
           if(PatientID!=null && !PatientID.equals("")){
            weight=request.getParameter("weight");
            temperature=request.getParameter("temperature");
            bp=request.getParameter("bp");
          
           
       
             
             String insertnextpatient=" insert into todayspatient set PatientID=?, Weight=?, temperature=?,bp=?, userid=?";
          
             
             System.out.println(insertnextpatient);
            // conn.state.executeUpdate(insertfinancial);
        conn.ps2=conn.connect.prepareStatement(insertnextpatient);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 conn.ps2.setString(1, PatientID);   
 conn.ps2.setString(2, weight); 
 conn.ps2.setString(3, temperature); 
 conn.ps2.setString(4, bp); 
  conn.ps2.setString(5,Userid); 

 conn.ps2.executeUpdate();
  session.setAttribute("patientadded", "<font color=\"green\">Patient added succesfully</font>");
           }
   
             else {
                session.setAttribute("patientadded", "<b><font color=\"red\">Error, Patient not added successfully</font></b>");
           }
        response.sendRedirect("ViewNextPatient.jsp");
        } finally {            
            out.close();
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
            Logger.getLogger(saveNextPatient.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(saveNextPatient.class.getName()).log(Level.SEVERE, null, ex);
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
