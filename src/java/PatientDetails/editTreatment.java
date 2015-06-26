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
public class editTreatment extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            dbConnect conn= new dbConnect();
            
            String date="";
            String patientid="";
            String pname="";
            String table="";
            String age="";
            
            if(request.getParameter("date")!=null){
            date=request.getParameter("date");
            }
              if(request.getParameter("name")!=null){
           pname=request.getParameter("name");
            }
            if(request.getParameter("regNo")!=null){
            patientid=request.getParameter("regNo");
            }
            if(request.getParameter("age")!=null){
            age=request.getParameter("age");
            }
            
            
            
            String referalopts[]={"Not reffered","Surgical","Orthopedic","Ophthalmology","ENT","Neurology"};
            
            String refs="";
            String getdata="select * from treatment where PatientID='"+patientid+"' and treatmentdate='"+date+"'";
            conn.rs=conn.state.executeQuery(getdata);
            System.out.println(""+getdata);
            while(conn.rs.next()){
            
                
                for(int a=0;a<referalopts.length;a++){
                if(conn.rs.getString("referral").contains(referalopts[a])){
                  refs+="<option selected value=\""+referalopts[a]+"\">"+referalopts[a]+"</option>";
                }
                else {
                    refs+="<option value=\""+referalopts[a]+"\">"+referalopts[a]+"</option>";
                
                }
                }
            //treatment
                //prescription
                //refferal
                
                table+="<tr><td style=\"text-align: left;\">Patients Name:</td><td> <input type=\"hidden\" name=\"reg\" value=\""+patientid+"\"><b>"+pname+"</b></td></tr>  ";
                table+="  <tr><td  style=\"text-align: left;\">Age:</td><td><input type=\"hidden\" name=\"name\" value=\""+pname+"\"><input type=\"hidden\" name=\"age\" value=\""+age+"\">"+age+"</td></tr>";
                table+="  <tr><td style=\"text-align: left;\">Date of Treatment:</td><td><input type=\"text\" required readonly name=\"date1\" class=\"date1\" value=\""+conn.rs.getString("treatmentdate")+"\" style=\"height:30px;width:240px;\" id=\"date1\" required/></td></tr>" +
"  <tr><td style=\"text-align: left;\">Treatment:</td><td>  <textarea  required name=\"treatment\" id=\"treatment\" required cols=\"40\" rows=\"4\"> "+conn.rs.getString("treatment")+"</textarea></td></tr>\n" +
"  <tr><td style=\"text-align: left;\">Prescription :</td><td><textarea name=\"prescription\" id=\"prescription\" required cols=\"40\" rows=\"2\"> "+conn.rs.getString("prescription")+"</textarea></td></tr>";
                table+=" <tr><td style=\"text-align: left;\">Next Visit Date:</td><td><input  type=\"text\"  class=\"nextvisit\" name=\"nextvisitdate\" value=\""+conn.rs.getString("nextvisitdate")+"\" style=\"height:30px;width:240px;\" id=\"nextvisit\" /><button title='clear date field to blank' onclick=\"cleardate1();\" class=\"btn btn-default\" type=\"button\">\n" +
"<i class=\"fa fa-refresh\" ></i></button></td></tr>";
                table+="<tr><th colspan=\"2\" style=\"text-align: center;\">Refferal Section</th></tr>";
                table+="<tr><td style=\"text-align: left;\">Select An Option</td><td> <select name=\"refferal\" title=\"To select various options, hold the control button and select all the options that apply. To unselect an option, Hold the control button and press the selected option\" id=\"refferal\" required style=\"height:120px;width:240px;\" multiple='multiple'>"+refs+"</select></td></tr>";
                table+="<tr> <td><input type='hidden' name='isprint1' id='isprint1' value='yes'><input type=\"checkbox\" onclick='printst();' checked name=\"isprint\" id=\"isprint\" value=\"yes\">Print</td> <td colspan=\"2\" style=\"margin-left: 20px;\"><input type=\"submit\" id=\"submit\"  style=\"height: 35px; width:120px; background: orange;\"value=\"SAVE AND PRINT\" /></td>  </tr>";
            
                
                
            
            
            
            }
            
            System.out.println("_______"+table);
            
            PrintWriter out = response.getWriter();
            try {
                
                out.println(table);
            } finally {
                
                conn.rs.close();
                conn.state.close();
                out.close();
            }
        }   catch (SQLException ex) {
            Logger.getLogger(editTreatment.class.getName()).log(Level.SEVERE, null, ex);
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
