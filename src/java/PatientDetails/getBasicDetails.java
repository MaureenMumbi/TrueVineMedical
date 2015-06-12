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
import org.apache.poi.xslf.usermodel.tutorial.Step1;
import org.apache.poi.xslf.usermodel.tutorial.Step2;
import org.json.JSONObject;

/**
 *
 * @author Maureen
 */
public class getBasicDetails extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
          dbConnect conn = new dbConnect();
           String regno = request.getParameter("regno");
           String patientid = request.getParameter("PatientID");
         String Step1="";
         String Step2="";
         String Step3="";
//         String patientid="";
          JSONObject jsonobj = new JSONObject();
            String query = "select * from basicdetails where Regno='"+regno+"' and PatientID='"+patientid+"'"; 
            System.out.println(query);
            conn.rs = conn.state.executeQuery(query);
            while(conn.rs.next()){
            Step1+="       <h2> Update child's basic details</h2>\n" +
"                        <table>" +
"                         <tr>  <td>First Name</td> <td><input type=\"text\" value=\""+conn.rs.getString("FName") +"\" name=\"FName\" style=\"height:30px;\"  placeholder=\"Childs First Name...\" ></td></tr>"+
"                           <tr> <td>Middle Name</td><td><input type=\"text\" value=\""+conn.rs.getString("SName") +"\" class=\"form-control\"  style=\"height:30px;\" name=\"MName\" placeholder=\"Childs Middle Name...\" ></td></tr>" +
"                            <tr> <td>Surname Name</td><td><input type=\"text\" value=\""+conn.rs.getString("LName") +"\"  class=\"form-control\" style=\"height:30px;\" name=\"SName\" placeholder=\"Childs Surname...\" ></td></tr>" +
"                             <tr>  <td>Reg No</td> <td> <input type=\"text\"  value=\""+conn.rs.getString("Regno") +"\"class=\"form-control\" style=\"height:30px;\"  disabled name=\"regno\" Placeholder=\"e.g 1/2014\"></td></tr>" +
"                             <tr>  <td>Date of Birth</td> <td><input type=\"text\"  value=\""+conn.rs.getString("DOB") +"\" name=\"dob\" style=\"height:30px;\" id=\"DOB\" class=\"datepickerDOB\" onchange=\"ageCount();\" Placeholder=\"dd/mm/yyyy\"></td></tr>" +
"                              <tr> <td>Age</td>  <td> <input type=\"text\" value=\""+conn.rs.getString("age") +"\" class=\"form-control\" name=\"age\" style=\"height:30px;\" id=\"age\" readonly></td></tr>" +

"                    </table>";
                  
            
            patientid= conn.rs.getString("PatientID");
         ; }
    String getParentDetails="select * from parentdetails where parenttype= 'Mother' and PatientID='"+patientid+"'" ;
    conn.rs2 = conn.state1.executeQuery(getParentDetails);
    while(conn.rs2.next()){
Step2+="            <h2>Update Mothers Details</h2>\n" +
"          <table>\n" +
"                        <tr>\n" +
"                            <td>First Name</td><td><input type=\"text\"  value=\""+conn.rs2.getString("Fname") +"\" class=\"form-control\" name=\"MothersFName\"  style=\"height:30px;\" placeholder=\"Mothers First Name...\" ></td>\n" +
"                              </tr>\n" +
"                            <tr> <td>Middle Name</td><td><input type=\"text\"  value=\""+conn.rs2.getString("Mname")+"\" class=\"form-control\" name=\"MothersMName\" style=\"height:30px;\"  margin-left: 25px; width: 350px;\" placeholder=\"Mothers Middle Name...\" ></td>\n" +
"                              </tr>\n" +
"                           <tr>  <td>Surname Name</td><td><input type=\"text\" value=\""+conn.rs2.getString("Lname")+"\" class=\"form-control\" name=\"MothersSName\"  style=\"height:30px;\" placeholder=\"Fathers Surname...\" ></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Phone No</td><td> <input type=\"text\" name=\"mothersphoneno\" value=\""+conn.rs2.getString("PhoneNo")+"\" class=\"form-control\" style=\"height:30px;\" Placeholder=\"e.g 0720000000\"></td>\n" +
"                            \n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Occupation</td><td> <select name=\"mothersoccupation\"   class=\"form-control\"  style=\"height:30px;\">\n" ;
 if (conn.rs2.getString("Occupation").equals("housewife")){

                               Step2+="<option selected value=\"housewife\">Housewife</option>\n" +
                                       "<option value=\"working\">Working</option>\n" ;
 } else{
 
 
 
                               Step2+="<option value=\"housewife\">Housewife</option>\n" +
                                       " <option selected value=\"working\">Working</option>\n" ;
 
 }
                               Step2+=" </select></td>\n" +
                                       "</tr>\n" +
                                       "</table>\n" ;



    }
    String getDadDetails="select * from parentdetails where parenttype='Father' and PatientID='"+patientid+"' ";
    conn.rs3 = conn.state3.executeQuery(getDadDetails);
            while(conn.rs3.next()){
Step3+=" <h2>Update Fathers Detals</h2>\n" +
"           <table>" +
"               <tr>\n" +
"                            <td>First Name</td><td><input type=\"text\" value=\""+conn.rs3.getString("Fname")+"\"  class=\"form-control\"  name=\"FathersFName\"   style=\"height:30px;\" placeholder=\"Father's First Name...\" ></td>\n" +
"                              </tr>\n" +
"                            <tr> <td>Middle Name</td><td><input type=\"text\"  value=\""+conn.rs3.getString("Mname")+"\" class=\"form-control\" name=\"FathersMName\"  style=\"height:30px;\" placeholder=\"Father's Middle Name...\" ></td>\n" +
"                              </tr>\n" +
"                           <tr>  <td>Surname Name</td><td><input type=\"text\"  value=\""+conn.rs3.getString("Lname")+"\" class=\"form-control\" name=\"FathersSName\"  style=\"height:30px;\" placeholder=\"Father's Surname...\" ></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Phone No</td><td> <input type=\"text\"  class=\"form-control\"  value=\""+conn.rs3.getString("PhoneNo")+"\" name=\"Fathersphoneno\"  style=\"height:30px;\"  Placeholder=\"e.g 0720000000\"></td>\n" +
"                            \n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Occupation</td><td> <input type=\"text\" class=\"form-control\"  value=\""+conn.rs3.getString("Occupation")+"\"  name=\"Fathersoccupation\"  style=\"height:30px;\" Placeholder=\"job\"><td>\n" +
"                            \n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Place of work</td><td> <input type=\"text\"  class=\"form-control\"  value=\""+conn.rs3.getString("Company")+"\"  name=\"Fathersworkplace\"   style=\"height:30px;\" id=\"workplace\"  ></td>\n" +
"                            \n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Provided for Insurance</td><td>\n" +
"                             <select name=\"Insurance\"  class=\"form-control\"  style=\"height:30px;\">\n" ;

                                    if(conn.rs3.getString("Insurance").equals("Yes")){  
                           
                            Step3+="<option selected value=\"Yes\">Yes</option>" +
                                      " <option value=\"No\">No</option>" ;}
                                  else{
                                    
                                              Step3+="<option  value=\"Yes\">Yes</option>" +
                                                     " <option selected value=\"No\">No</option>" ;
                         
                                          
                                           }
                                   
            Step3+=   " </select>\n" +
"                            <td>\n" +
"                        </tr></table>";
            }
              
           
            
            try {
                
                jsonobj.put("step1", Step1);
                jsonobj.put("step2", Step2);
                jsonobj.put("step3", Step3);
               
                //System.out.println(jsonobj);
                
                out.println(jsonobj);
                
            } finally {                
                out.close();
            }
            
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
            Logger.getLogger(getBasicDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getBasicDetails.class.getName()).log(Level.SEVERE, null, ex);
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
