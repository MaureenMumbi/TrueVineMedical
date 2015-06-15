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

/**
 *
 * @author MANUEL
 */
public class loadDisposal extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            
            String regNo=request.getParameter("patientid");
            String name=request.getParameter("name");
            
            dbConnect conn= new dbConnect();
            String table="";
            
            String reason="";
            String dateofdeath="";
            String causeofdeath="";
            String town="";
            String country="";
            
         
            
            String options[]={"Discharged due to overage","Died","Lost to follow up","Moved to other towns"};
            String optionstr="<option value=''>Choose Reason</option>";
            String gettable="select * from finaldisposal where PatientID='"+regNo+"'";
            conn.rs=conn.state.executeQuery(gettable);
            
            while(conn.rs.next()){
            
            reason=conn.rs.getString("Reason");
           
                System.out.println("__"+optionstr);
            
            dateofdeath=conn.rs.getString("dateofdeath");
            if(dateofdeath==null){dateofdeath="";}
            causeofdeath=conn.rs.getString("causeofdeath");
                if(causeofdeath==null){dateofdeath="";}
            town=conn.rs.getString("town");
                if(town==null){town="";}
            country=conn.rs.getString("country");
                if(country==null){country="";}
            
            
            
            }
            
            
             for(int a=0;a<options.length;a++){
                if(reason.equalsIgnoreCase(options[a])){
                  optionstr+="<option selected value=\""+options[a]+"\">"+options[a]+"</option>";
                }
                else {
                    optionstr+="<option value=\""+options[a]+"\">"+options[a]+"</option>";
                
                }
                }
            
          table+="<table style=\"margin-left: 90px; width:1000px;\" id=\"\" class=\"viewpdt\"><tr><th colspan=\"2\" style=\"text-align: center;\">Give the reason for not attending hospital any more</th></tr> ";  
          table+="<tr><th colspan=\"1\" style=\"text-align: center;\">Patient's Name</th><td><b>"+name+"</b><input type='hidden' name='patientid' value='"+regNo+"'><input type='hidden' name='name' value='"+name+"'></td></tr>";  
          table+=" <tr><th style=\"text-align: left;width:200px;\">Reason</th><td><select name=\"disposal\" required title=\"\" id=\"disposal\" onchange=\"chooseaction();\" style=\"height:30px;width:240px;\" >"+optionstr+"</select></td></tr></table>";  
          table+="<div id=\"causediv\"><table style=\"margin-left: 90px; width:1000px;\" id=\"\" class=\"viewpdt\">" +
                 "<tr ><th style=\"width:200px;\"><span id=\"datelabel\">Date</span></th><td><input type=\"text\" class='date' name=\"deathdate\" value='"+dateofdeath+"' id=\"deathdate\" readonly style=\"width:240px; height:30px;\"/><button title='clear date field to blank' onclick=\"cleardate();\" class=\"btn btn-default\" type=\"button\"><i class=\"fa fa-refresh\" ></i></button></td></tr>\n" +
                 "<tr><th><span id=\"causelabel\"> Cause </span></td><th><input type=\"text\" name=\"deathcause\" id=\"deathcause\" value='"+causeofdeath+"' style=\"width:240px; height:75px;\"/></td></tr></table></div>";  
          table+="<div id=\"towndiv\">\n" +
" <table style=\"margin-left: 90px; width:1000px;\" id=\"\" class=\"viewpdt\">                   \n" +
"<tr><th style=\"width:200px;\"><span id=\"townlabel\">Town</span></th><td> <input style='height:33px;width:240px;' value='"+town+"' list=\"townsdl\" name=\"town\" id=\"town\" /> <datalist id=\"townsdl\"><option value=\"nairobi\"> <option value=\"nyahururu\"></datalist></td></tr>   \n" +
"<tr><th><span id=\"countrylabel\">Country</span></th><td> <input list=\"countydl\" style='height:33px;width:240px;'  value='"+country+"' name=\"country\" id=\"country\" /> <datalist id=\"countydl\"><option value=\"Uganda\"/> <option value=\"Tanzania\"/></datalist> </td></tr>   \n" +
"</table></div>\n" +
"<table class=\"viewpdt\" style=\"margin-left: 400px;\">\n" +
"<tr><th colspan=\"2\"><input type=\"submit\"  style=\"height: 30px; width:120px; background: orange;\"value=\"Save\" /></th>  </tr>\n" +
"</table>";  
          table+="";  
            
            PrintWriter out = response.getWriter();
            try {
                
                out.println(table);
            } finally {
                out.close();
            }
        }   catch (SQLException ex) {
            Logger.getLogger(loadDisposal.class.getName()).log(Level.SEVERE, null, ex);
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
