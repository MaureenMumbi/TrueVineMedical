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
public class SaveVisits extends HttpServlet {

   HttpSession session=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            session=request.getSession();
            
            String patientid="";
            String revisitdate="";
            String findings="";
            String reccomendations="";
            String userid="";
            String visitno="";
            
            
            String followupid="";
            
            
            if(session.getAttribute("userid")!=null){
                userid=session.getAttribute("userid").toString();
            }
            
            patientid=request.getParameter("reg");
            revisitdate=request.getParameter("date1");
            findings=request.getParameter("finding");
            reccomendations=request.getParameter("recomendation");
            visitno=request.getParameter("Visitno");
            followupid=request.getParameter("followupid");
            
            
            dbConnect conn=new dbConnect();
            //=====find if the same record exists
            
            String checkdata=" Select * from followup where patientID='"+patientid+"' and revisitDate='"+revisitdate+"'";
            
         conn.rs1=conn.state1.executeQuery(checkdata);
         
         
         
         
 //------------------------------------------------------------------------------------------------        
 //------------------------------------------------------------------------------------------------        
 //------------------------------------------------------------------------------------------------        
 //------------------------------------------------------------------------------------------------
         //CHANGE THE ID USED IN WHERE CLAUSE AND USE A FOLLOWUP ID INSTEAD.
 //------------------------------------------------------------------------------------------------        
 //------------------------------------------------------------------------------------------------        
 //------------------------------------------------------------------------------------------------        
 //------------------------------------------------------------------------------------------------        
         if(conn.rs1.next()){
        String invinsert="update followup set patientID=?,revisitDate=?,findings=?,recommendations=?,userid=?,visit_no=? where FollowUpId='"+followupid+"'";
            
            conn.ps1=conn.connect.prepareStatement(invinsert);
            
            //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
            conn.ps1.setString(1, patientid);
            conn.ps1.setString(2, revisitdate);
            conn.ps1.setString(3, findings);
            conn.ps1.setString(4, reccomendations);
            conn.ps1.setString(5, userid);
            conn.ps1.setString(6, visitno);
            
            conn.ps1.executeUpdate();     
             
         
             session.setAttribute("visitsmsg","<h3 style='color:green'>Data Saved Succesfully !!</h3>");
             
         }
         else { 
             
             
String invinsert="insert into followup (patientID,revisitDate,findings,recommendations,userid,visit_no,FollowUpId)"
                    + " values (?,?,?,?,?,?,?)";
            
            
            conn.ps1=conn.connect.prepareStatement(invinsert);
            
            //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
            conn.ps1.setString(1, patientid);
            conn.ps1.setString(2, revisitdate);
            conn.ps1.setString(3, findings);
            conn.ps1.setString(4, reccomendations);
            conn.ps1.setString(5, userid);
            conn.ps1.setString(6, visitno);
            conn.ps1.setString(7, followupid);
            
            conn.ps1.executeUpdate();
            
          session.setAttribute("visitsmsg","<h3 style='color:green'>Visits Data for Patient id "+patientid+" has been saved succesfully !!</h3>");  
         }
            
            
            
            PrintWriter out = response.getWriter();
            try {
                out.println(session.getAttribute("visitsmsg"));
                
            } finally {
                out.close();
            }
            
            //change this redirect to one made by Mo
          //  response.sendRedirect("viewclients.jsp");
            
        }  catch (SQLException ex) {
           Logger.getLogger(SaveVisits.class.getName()).log(Level.SEVERE, null, ex);
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
