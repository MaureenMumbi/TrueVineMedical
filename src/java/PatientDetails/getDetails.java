/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class getDetails extends HttpServlet {

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
        try {
           dbConnect conn = new dbConnect();
             
session = request.getSession(true);
  
                                
                                        
                                        
                                        ArrayList childdetails = new ArrayList();
                                     
                 String query = "select * from basicdetails";
                                        System.out.println("query " + query);
              
                                                        conn.rs = conn.state.executeQuery(query);
        if(childdetails!=null && childdetails.size()>0 ){childdetails.clear();}

                                        while(conn.rs.next())
                                        {
                                                
                    System.out.println(conn.rs.getString(1) +"  "+ conn.rs.getString(2) +" "+conn.rs.getString(3));                     
                       ClientDetailsBean DB= new ClientDetailsBean();
                       DB.setFNAME(conn.rs.getString("FName"));
                       DB.setSNAME(conn.rs.getString("SName"));
                       DB.setLNAME(conn.rs.getString("LName"));
                       DB.setREGNO(conn.rs.getString("RegNo"));
                       DB.setDOB(conn.rs.getString("Age"));
                      
                    
                      
          
                       childdetails.add(DB);
                       
                      
        }
                       
                                           session.setAttribute("childdetails", childdetails);
         
                                        response.sendRedirect("viewChildDetails.jsp");
                                     
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
            Logger.getLogger(getDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getDetails.class.getName()).log(Level.SEVERE, null, ex);
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
