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
import org.json.JSONObject;

/**
 *
 * @author MANUEL
 */
public class loadinvestigations extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            
            dbConnect conn= new dbConnect();
            String date="";
            
            String patientid="";
            date="";
            String name="";
            if(request.getParameter("patientid")!=null){
            
            patientid=request.getParameter("patientid");
            }
            
             if(request.getParameter("name")!=null){
            
            name=request.getParameter("name");
            }
            
             if(request.getParameter("date")!=null){
            
            date=request.getParameter("date");
            }
            String getdata="select * from investigations where date='"+date+"' and patientID='"+patientid+"'";
            
            conn.rs=conn.state.executeQuery(getdata);
            String createdtable="";
            String step1="";
            String step2="";
            String step3="";
            
            while(conn.rs.next()){
            
                //now get the data
                step1="<h2 class=\"StepTitle\">Step 1</h2>\n" +
"\n" +
"                        <fieldset>\n" +
"                            <h5 style='text-align:center;'> Fill all the fields shown</h5>\n" +
"                            <div id=\"message\"></div>\n" +
"                            <div class=\"formRow\" >\n" +
"                                <div class=\"panel-body\">\n" +

"" +
"                                            <table style=\"margin-left: 150px; width:1000px;\" id=\"invtable1\" class=\"viewpdt\">\n" +
"                                                <td colspan=\"1\">Name:</td>\n" +
"                                                <td><b>"+name+"</b><input type=\"hidden\" required  value=\"Search..\"  readonly style=\" cursor:pointer;margin-left: 40px; text-transform:uppercase ; height: 18px; width:100px;text-align:center ; color:white ;background:coral; border-style:ridge ;\" onclick=\"getAtoFDetails();\"/> </td>\n" +
"                                                <input type=\"hidden\" name=\"patientid\" value=\""+conn.rs.getString("patientID")+"\"/>" +
"                                                <tr>\n" +
"                                                    <td style=\"text-align:left ;\">Date: </td><td><input type='text' value=\""+conn.rs.getString("date")+"\" readonly name='invdate' class='form-control date' style=' width: 160px;height:35px;'  ><td></td>\n" +
"                                                </tr>\n" +
"                                                <tr>\n" +
"                                                    <td style=\"text-align:left ;\">Urinalysis and Microscopy </td><td><input type='text' value=\""+conn.rs.getString("urinalysis")+"\" name='urinalysis' class='form-control' style=' width: 160px;height:35px;' placeholder='in LB' ><td><i>LB</i></td>\n" +
"                                                </tr>\n" +
"                                                <tr> <td style=\"text-align:left ;\">Stool Microscopy</th>  <td><input type='text' class='form-control'  style=' width: 160px;height:35px;' value=\""+conn.rs.getString("stoolmicroscopy")+"\" name='stoolmic' placeholder='Stool Microscopy' ></td>   \n" +
"                                                </tr>\n" +
"                                                <tr><td style=\"text-align:left ;\">Stool Pylori</td> <td><select   class='form-control' style=' width: 160px;height:35px;' name='stoolpylori' placeholder='Stool Pylori' ><option value=''>select option</option>" ;
String stoolmicopt="";
                if(conn.rs.getString("stoolHpylori").equalsIgnoreCase("positive")){  stoolmicopt+="<option selected value='positive'>Positive</option><option  value='negative'>Negative</option>"; } else if(conn.rs.getString("stoolHpylori").equalsIgnoreCase("negative")){  stoolmicopt+="<option  value='positive'>Positive</option><option selected value='negative'>Negative</option>"; } 
step1+=stoolmicopt+"</select></td>  </tr><tr><td style=\"text-align:left ;\">Blood Slide for Maliria Parasite</td><td><select   class='form-control' style=' width: 160px;height:35px;' name='malariaparasite' placeholder='Blood Slide for Malaria' ><option value=''>select option</option>" ;
String malaria="";
                if(conn.rs.getString("malaria").equalsIgnoreCase("positive")){  malaria+="<option selected value='positive'>Positive</option><option  value='negative'>Negative</option>"; } else if(conn.rs.getString("malaria").equalsIgnoreCase("negative")){  malaria+="<option  value='positive'>Positive</option><option selected value='negative'>Negative</option>"; } 
step1+=malaria+"</select></td></tr>" +
"                                                <tr><td style=\"text-align:left ;\">Random Blood Sugar </td> <td> <input type='text' value=\""+conn.rs.getString("RBS")+"\" class='form-control' style=' width: 160px;height:35px;' name='rbs' id=\"rbs\" Placeholder='use mmol/L'></td>\n" +
"                                                </tr>" +
"                                            </table>" +
"                                       </div>" +
"                            </div>" +
"                        </fieldset>" +
"";
                
      step2="   <h2 class=\"StepTitle\">Step 2</h2>\n" +
"\n" +
"                        <table style=\"margin-left: 150px; width:1000px;\" id=\"invtable2\" class=\"viewpdt\">\n" +
"                            <tr><td style=\"text-align:left ;\">(a)Total WBC Count </td><td> <input type='text' value=\""+conn.rs.getString("HTotalWBCCount")+"\"  name='wbccount' style=' width: 130px;height:35px;' id='wbccount'   /></td></tr>\n" +
"                            <tr><td style=\"text-align:left ;\">(b)Differential </td><td> <input type='text' value=\""+conn.rs.getString("HDifferential")+"\" name='differential' style=' width: 130px;height:35px;' id='differential'   ></td></tr>\n" +
"                            <tr><td style=\"text-align:left ;\">(c) HB</td><td> <input type='text'name='hb' value=\""+conn.rs.getString("HHb")+"\" style=' width: 130px;height:35px;' id='hb' /> </td><td><i>g/dL</i></td></tr>\n" +
"                            <tr><td style=\"text-align:left ;\">(d)Peripheral Film </td><td> <input type='text' value=\""+conn.rs.getString("HPeripheral")+"\" name='peripheralfilm' style='width: 130px;height:35px;' id='periPheralFilm'   /></td></tr>\n" +
"                            <tr><td style=\"text-align:left ;\">(e)Inclusions</td><td><select  onchange=\"decideincdesc();\"  style='width: 130px;height:35px;' name='inclusions' id=\"inclusions\"  >\n" +
"                                        <option value=''>select option</option>";
String inclusion="";
                if(conn.rs.getString("Hinclusions").equalsIgnoreCase("positive")){  inclusion+="<option selected value='positive'>Positive</option><option  value='negative'>Negative</option>"; } else if(conn.rs.getString("HInclusions").equalsIgnoreCase("negative")){  inclusion+="<option  value='positive'>Positive</option><option selected value='negative'>Negative</option>"; } 
step2+=inclusion+"</select></td></tr>\n" +
"                            <tr><td style=\"text-align:left ;\"><span id=\"incdesclabel\"></span></td><td><textarea name=\"incdesc\" id=\"incdesc\" style=\"margin-left:322px ;\" cols=\"40\" rows=\"4\" >"+conn.rs.getString("inclusiondesc")+"</textarea></td></tr>" +
"<tr>\n" +
"</tr>\n" +
"</table>";          
           

step3="<h2 class=\"StepTitle\">Step 3 </h2>\n" +
"                        <table style=\"margin-left: 10px; width:1000px;\" id=\"invtable2\" class=\"viewpdt\">\n" +
"                            <tr>\n" +
"                            </tr>\n" +
"                            <tr><td style=\"text-align:left ;\">LFTs  </td> <td><input  value=\""+conn.rs.getString("LFTs")+"\" type='text'  name='lft' style=' width: 130px;height:35px;' id='lft'   /></td> </tr>\n" +
"                            <tr> <td style=\"text-align:left ;\">Urea and Electrolytes </td> <td> <input type='text' value=\""+conn.rs.getString("UreaNelectrolytes")+"\" name='urea' style=' width: 130px;height:35px;' id='urea'   /></td></tr>\n" +
"                            <tr> <td style=\"text-align:left ;\">Thyroid Profile </td><td> <input type='text' value=\""+conn.rs.getString("ThyroidProfile")+"\" name='thyroid' style=' width: 130px;height:35px;' id='thyroid'   /></td></tr>\n" +
"                            <tr> <td style=\"text-align:left ;\">CTR </td> <td> <input type='text' value=\""+conn.rs.getString("CXR")+"\" name='ctr' style=' width: 130px;height:35px;' id='ctr'   /></td></tr>\n" +
"                            <tr><td style=\"text-align:left ;\">Other X ray </td> <td> <input type='text' value=\""+conn.rs.getString("OtherXray")+"\"  name='xray' style=' width: 130px;height:35px;' id='xray'   /></td></tr>\n" +
"                            <tr> <td style=\"text-align:left ;\">Abdominal Ultra Sound </td>   <td> <input type='text'value=\""+conn.rs.getString("ultrasound")+"\"  name='ultrasound' style=' width: 130px;height:35px;' id='ultrasound'   /></td> </tr>\n" +
"                            <tr><td style=\"text-align:left ;\">CT scan brain </td> <td> <input type='text' value=\""+conn.rs.getString("ctscanbrain")+"\"  name='ctscanbrain' style=' width: 130px;height:35px;' id='ctscanbrain'   ></td></tr>\n" +
"                            <tr> <td style=\"text-align:left ;\">CT scan other </td> <td> <input type='text' value=\""+conn.rs.getString("ctscanother")+"\"  name='ctscanother' style=' width: 130px;height:35px;' id='ctscanother'   ></td>  </tr>\n" +
"                            <tr> <td style=\"text-align:left ;\">MRI </td><td> <input type='text'  value=\""+conn.rs.getString("MRI")+"\" name='mri' style=' width: 130px;height:35px;' id='mri'   ></td>   </tr>\n" +
"                            <tr>\n" +
"                            </tr>\n" +
"                            </table>";
            }//end of while
            
            JSONObject obj= new JSONObject();
            
            obj.put("step1", step1);
            obj.put("step2", step2);
            obj.put("step3", step3);
            
           // System.out.println("__"+step1);
            
            
            try {
                
                out.println(obj);
            } finally {
                out.close();
            }
        }   catch (SQLException ex) {
            Logger.getLogger(loadinvestigations.class.getName()).log(Level.SEVERE, null, ex);
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
