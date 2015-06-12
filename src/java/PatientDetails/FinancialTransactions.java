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
public class FinancialTransactions extends HttpServlet {

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
          dbConnect conn = new dbConnect();
            String consultationfee="";
             String injectionfee="";
             String drugs="";
             String procedurefee="";
             String Userid="";
               String PatientID="";
        try {
           if(request.getParameter("PatientID")!=null && !request.getParameter("PatientID").equals("")){
                      PatientID=request.getParameter("PatientID") ;
                        session.setAttribute("PatientID",PatientID);
           }
                if(session.getAttribute("username")!=null){
           Userid= (String) session.getAttribute("username");}
           
           if(PatientID!=null && !PatientID.equals("")){
            consultationfee=request.getParameter("consultationfee");
            injectionfee=request.getParameter("injectionfee");
            drugs=request.getParameter("drugs");
            procedurefee=request.getParameter("procedurefee");}
           
       
             
             String insertfinancial=" insert into financialtransaction set PatientID=?, ConsultationFee=?, InjectionFee=?,Drugs=?, ProcedureFee=?, userid=?";
          
             
             System.out.println(insertfinancial);
            // conn.state.executeUpdate(insertfinancial);
        conn.ps2=conn.connect.prepareStatement(insertfinancial);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 conn.ps2.setString(1, PatientID);   
 conn.ps2.setString(2, consultationfee); 
 conn.ps2.setString(3, injectionfee); 
 conn.ps2.setString(4, drugs); 
 conn.ps2.setString(5 ,procedurefee); 
 conn.ps2.setString(6,Userid); 

 conn.ps2.executeUpdate();
        response.sendRedirect("generalexamination.jsp");
        
        } catch(SQLException ex) {            
            out.println(ex.toString());
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
            Logger.getLogger(FinancialTransactions.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FinancialTransactions.class.getName()).log(Level.SEVERE, null, ex);
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
