/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author MANUEL
 */
public class saveEditedDisposal extends HttpServlet {

  HttpSession session=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String Patientid="";
               String name="";
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            session=request.getSession();
            
            String msg="";
            
            dbConnect conn= new dbConnect();
            
            String Reason="";
            String deathdate="";
            String deathcause="";
            String Town="";
            String Country="";
         
        
            
            if(request.getParameter("disposal")!=null){
                Reason=request.getParameter("disposal");
            }
             if(request.getParameter("name")!=null){
                name=request.getParameter("name");
            }
            
            Patientid=request.getParameter("patientid");
            if(request.getParameter("deathdate")!=null){
                deathdate=request.getParameter("deathdate");
            }
            
            if(request.getParameter("deathcause")!=null){
                deathcause=request.getParameter("deathcause");
            }
            
            if(request.getParameter("town")!=null){
                Town=request.getParameter("town");
            }
            
            if(request.getParameter("country")!=null){
                Country=request.getParameter("country");
            }
            
            
            String userid="unknown";
            
            if(session.getAttribute("userid")!=null){
                userid=session.getAttribute("userid").toString();
            }
            
            //check if disposal has data for the current user
            
            String checkuser="Select * from finaldisposal where PatientID='"+Patientid+"'";
            conn.rs=conn.state.executeQuery(checkuser);
            
            if(!conn.rs.next()){
            msg=name+" 's disposal records saved Successfully";
            String savedata=" insert into finaldisposal (PatientID,Reason,dateofdeath,causeofdeath,town,country,userid) "
                    + "values (?,?,?,?,?,?,?)";
            
            conn.ps1=conn.connect.prepareStatement(savedata);
            
            //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
            conn.ps1.setString(1, Patientid);
            conn.ps1.setString(2, Reason);
            conn.ps1.setString(3,deathdate );
            conn.ps1.setString(4, deathcause);
            conn.ps1.setString(5, Town);
            conn.ps1.setString(6, Country);
            conn.ps1.setString(7, userid);        
            
            conn.ps1.executeUpdate();
            
            }
            
            else {
            
            
            //do an update
                
                   msg=name+"'s disposal records updated Successfully";
                 String savedata="update finaldisposal set Reason = ?,dateofdeath = ?,causeofdeath = ? ,town = ? ,country = ? where PatientID='"+Patientid+"' ";
            
            conn.ps1=conn.connect.prepareStatement(savedata);
            
            //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
         
            conn.ps1.setString(1, Reason);
            conn.ps1.setString(2,deathdate );
            conn.ps1.setString(3, deathcause);
            conn.ps1.setString(4, Town);
            conn.ps1.setString(5, Country);
                
            
            conn.ps1.executeUpdate();
                
                
            
            }
            
            
            conn.ps1.close();
            conn.connect.close();
            
            session.setAttribute("disposalmsg", msg);
           
            
        
            
            
        } catch (SQLException ex) {
          Logger.getLogger(savedisposal.class.getName()).log(Level.SEVERE, null, ex);
      }
          
            response.sendRedirect("editDisposal.jsp?name="+name+"&regNo="+Patientid);  
        
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
