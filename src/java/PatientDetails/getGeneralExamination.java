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
import org.json.JSONObject;

/**
 *
 * @author Maureen
 */
public class getGeneralExamination extends HttpServlet {

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
         
           String patientid = request.getParameter("PatientID");
           System.out.println(patientid);
         String Step1="";
         String Step2="";
         String Step3="";
         String Step4="";
             int count=0;
//         String patientid="";
          JSONObject jsonobj = new JSONObject();
          System.out.println("generalexamination  "+patientid);
          String getExamination="select * from childbirthhistory where PatientID='"+patientid+"'";
          conn.rs = conn.state.executeQuery(getExamination);
          while(conn.rs.next()){
              
             Step1+="\n" +
"                    <table style=\"width: 1100px;\" class=\"viewpdt\">\n" +
"                        \n" +
"                        <tr>\n" +
"                            <td>Place of Birth</td><td>\n" +
"                                <select name=\"birthplace\" id=\"birthplace\" onchange=\"showhospital();\" class=\"form-control\"  style=\"height:30px;\" >\n" ;
          if(conn.rs.getString("BirthPlace").equals("Home")){  
                           
                            Step1+="<option selected value=\"Home\">Home</option>" +
                                      " <option value=\"Hospital\">Hospital</option>" ;}
                                  else{
                                    
                                              Step1+="<option  value=\"Home\">Home</option>" +
                                                     " <option selected value=\"Hospital\">Hospital</option>" ;
                         
                                          
                                           }
                     
   Step1+= "                                </select>\n" +
"                            </td>\n" +
"                         \n" +
"                                <td>\n" +
"                                    <input type=\"hidden\" class=\"form-control\" value='"+conn.rs.getString("HospitalName")+"'  style=\"height:30px;\" name=\"hospitalname\" id=\"hospitalname\" placeholder=\"Hospital Name \" >\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                           <tr>  <td>Mode of Delivery</td>\n" +
"                               <td>\n" +
"                                   <select name=\"deliverymode\" class=\"form-control\"  style=\"height:30px;\" >\n" ;
         if(conn.rs.getString("DeliveryMode").equals("CSection")){  
                         Step1+= "<option value=\"\"></option>  \n" +
"                                    <option selected value=\"CSection\">Caesarian Section</option>  \n" +
"                                    <option value=\"Normal\">Normal</option>  \n" ;
         }
         else{
         
                                 Step1+= "<option value=\"\"></option>  \n" +
"                                    <option  value=\"CSection\">Caesarian Section</option>  \n" +
"                                    <option selected  value=\"Normal\">Normal</option>  \n" ;
         
         
         }
Step1+="                                </select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                       \n" +
"                        <tr>\n" +
"                            <td>Birth Weight</td>\n" +
"                            <td> \n" +
"                                 \n" +
"                            \n" +
"                                <input type=\"text\" value='"+conn.rs.getString("BirthWeight")+"' class=\"form-control\"  style=\"height:30px;\" name=\"birthweight\">\n" +
"                               \n" +
"                            </td>\n" +
"                            <td> <span class=\"input-group-addon\" style=\"width: 20px; \">Kgs</span></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Birth Number</td><td> <input type=\"text\" value='"+conn.rs.getString("BirthNo")+"'  name=\"birthno\"  class=\"form-control\" style=\"height:30px;\" id=\"birthno\" ></td>\n" +
"                            \n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td>Has there been any sibling death?</td>\n" +
"                            <td> \n" +
"                                <select name=\"siblingdeath\" id=\"siblingdeath\" class=\"form-control\" onchange=\"showage()\"  style=\"height:30px;\" >\n" ;
 if(conn.rs.getString("SiblingDeath").equals("Yes")){  
                           
                            Step1+="<option value=\"\"></option><option selected value=\"Yes\">Yes</option>" +
                                      " <option value=\"No\">No</option>" ;}
                                  else{
                                    
                                              Step1+="<option  value=\"\"></option>"
                                                      + "<option  value=\"Yes\">Yes</option>" +
                                                     " <option selected value=\"No\">No</option>" ;
                         
                                          
                                           }                                 
                        Step1+="  </select>\n" +
"                            </td>\n" +
"                            \n" +
"                        </tr>\n" +
"                        <tr>\n" ;
                                 if(conn.rs.getString("SiblingDeath").equals("Yes")){  
 Step1+="                            <td>Death Age </td><td> <input type=\"text\" class=\"form-control\"value='"+conn.rs.getString("DeathAge")+"'  placeholder=\"Enters Siblings Age\" name=\"age\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; height: 70px; width: 250px;\" id=\"age\" ></td>\n" +
"                            </tr><tr><td>Death Cause </td><td><input type=\"text\" class=\"form-control\"  value='"+conn.rs.getString("DeathCause")+"' name=\"cause\"   placeholder=\"Enters Death Cause\"style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; height: 70px; width: 250px;\" id=\"cause\" ></td>\n" +
"                          ";}
 else { 
           Step1+="  <td> <input type=\"hidden\" class=\"form-control\"value=\"\"  placeholder=\"Enters Siblings Age\" name=\"age\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; height: 70px; width: 250px;\" id=\"age\" ></td>\n" +
"                            <td> <input type=\"hidden\" class=\"form-control\"  value=\"\" name=\"cause\"   placeholder=\"Enters Death Cause\"style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; height: 70px; width: 250px;\" id=\"cause\" ></td>\n" +
"                          ";
                                 }
   
           Step1+="                         </tr>\n" +
"                    </table>\n" +
"                            " ;
          }
           String getPastMedic="select * from pastmedicalhistory where PatientID='"+patientid+"'";
          conn.rs2 = conn.state2.executeQuery(getPastMedic);
          while(conn.rs2.next()){
          
          Step2+=" <table style=\" width:300px; height: 250px;\">\n" +
"              <tr></tr>\n" +
"                        <tr>\n" +
"                            <td>Has the child has any longstanding medical problems?</td>\n" +
"                          </tr>\n" +
"                                                     <tr><td>\n" +
"                                                             <input  value=\"Epilepsy\" class=\"btnSmall btn submit center\" style=\"background-color: #cccccc; margin-bottom: 10px;\" onclick=\"addtotextarea('Epilepsy')\">\n" +
"				    <input value=\"Asthma\" class=\"btnSmall btn submit center\" style=\"background-color:#cccccc;margin-bottom: 10px;\"  onclick=\"addtotextarea('Asthma')\">\n" +
"				    <input  value=\"Diabetes\" class=\"btnSmall btn submit center\" style=\"background-color:#cccccc;margin-bottom: 10px;\" onclick=\"addtotextarea('Diabetes')\">\n" +
"				    <input value=\"Cerebral Palsy\" class=\"btnSmall btn submit center\" style=\"background-color:#cccccc;margin-bottom: 10px;\" onclick=\"addtotextarea('Cerebral Palsy')\">\n" +
"				    <input  value=\"Sickle Cell Disease\" class=\"btnSmall btn submit center\" style=\"background-color:#cccccc;margin-bottom: 10px;\" onclick=\"addtotextarea('Sickle Cell Disease')\">\n" +
"				    <input value=\"Others\" class=\"btnSmall btn submit center\" style=\"background-color:#cccccc;margin-bottom: 10px;\" onclick=\"addtotextarea('Others')\">\n" +
"				   \n" +
"                                </td></tr>\n" +
"                                                                 <br/>\n" +
"                             <tr><td><textarea style=\"width: 658px; height: 133px;\" id=\"problem\" name=\"problem\">"+conn.rs2.getString("longstandingproblems")+"</textarea></td></tr>\n" +
"          </table>\n" +
"            <br/>\n" +
"            <table>\n" +
"                <tr><td>Has the child ever been hospitalized?</td>\n" +
"                    <td>\n" +
"                        <select name=\"hospitalized\" id=\"hospitalized\" class=\"form-control\" onchange=\"showhospitalized()\"  style=\"height:30px;\" >\n" ;
 if(conn.rs2.getString("hospitalized").equals("Yes")){  
     Step2+="<option value=\"\"></option>  \n" +
"                                    <option selected value=\"Yes\">Yes</option>  \n" +
"                                    <option value=\"No\">No</option>  \n" ;
 }  else  if(conn.rs2.getString("hospitalized").equals("No")){  

     Step2+="<option value=\"\"></option>  \n" +
"                                    <option value=\"Yes\">Yes</option>  \n" +
"                                    <option selected value=\"No\">No</option>  \n" ;  
     
 }
  else{  

     Step2+="<option selected value=\"\"></option>  \n" +
"                                    <option value=\"Yes\">Yes</option>  \n" +
"                                    <option selected value=\"No\">No</option>  \n" ;  
     
 }
             
  Step2+=" </select>\n" +
"                        \n" +
"                        \n" +
"                    </td></tr>\n" +
"                </table>\n" +
"                <table id=\"hospitalizeddetails\">\n" ;
           if(conn.rs2.getString("hospitalized").equals("Yes")){  
Step2+="<tr><td>Date </td><td><input type=\"text\"  value=\""+conn.rs2.getString("datehospitalized")+"\" class=\"form-control\"  id=\"datepicker\"  onclick=\"getdate();\" name=\"DateHospitalized\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td>"+
"</tr><tr><td>Hospital admitted </td><td><input type=\"text\"   value=\""+conn.rs2.getString("hospital")+"\" class=\"form-control\"  name=\"HospitalAdmitted\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td></tr>"+
"<tr><td>Diagnosis </td><td><input type=\"text\"   value=\""+conn.rs2.getString("diagnosis")+"\" class=\"form-control\"  name=\"Diagnosis\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td></tr>" ;         
        }  
           else{
    Step2+="<tr><td>Date </td><td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"datepicker\"  onclick=\"getdate();\" name=\"DateHospitalized\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td>"+
"</tr><tr><td>Hospital admitted </td><td><input type=\"hidden\"  value=\"\" class=\"form-control\"  name=\"HospitalAdmitted\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td></tr>"+
"<tr><td>Diagnosis </td><td><input type=\"hidden \"  value=\"\" class=\"form-control\"  name=\"Diagnosis\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td></tr>" ;           
           
               
           }
        
  Step2+=      "                </table>\n" +
"         ";
          
          
          
          
          
          
          }
      
        String complaintarray[] = {"Fever","Cough","Vomiting","Diarrhea","Swelling","Restlessness","Irritability","Difficulty in Breathing","Convulsions","Joint Pain","Swelling","Growth","Yellow Eyes"};
//        complaintarray[] = new complaintarray{""};
          String getPresentComplaint="select * from presentcomplaints where PatientID='"+patientid+"' and   Complaint='Fever'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint);
         if(conn.rs3.next()){
        
         Step3+="<table style=\"padding-left: 300px;\" class=\"viewpdt1\">\n" +
"                      \n" +
"               <tr >\n" ;                 
                 if(conn.rs3.getString("complaint").equals("Fever")){
                        count++;
  Step3+="<td style=\"padding-left: 50px;\">Fever</td><td><input type=\"checkbox\"  checked value=\"Fever\" class=\"form-control\" onclick=\"showfield(1);\" id=\"complaints1\" name=\"complaints1\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td>"
          + "<input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration1\" name=\"duration1\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" >"
          + "<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid1\" name=\"presentcomplaintid1\"   >"
          + "</td>\n" ;
        }
  }               else {
  Step3+="<td style=\"padding-left: 50px;\">Fever</td><td><input type=\"checkbox\"  checked value=\"Fever\" class=\"form-control\" onclick=\"showfield(1);\" id=\"complaints1\" name=\"newcomplaints1\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"  value=\"\" class=\"form-control\"  id=\"duration1\" name=\"newduration1\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" ;
        }
         String getPresentComplaint1="select * from presentcomplaints where PatientID='"+patientid+"' and   Complaint='Restlessness'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint1);
               if(conn.rs3.next()){
if(conn.rs3.getString("complaint").equals("Restlessness")){
       count++;
    Step3+="               <td style=\"padding-left: 50px;\">Restlessness </td>\n" +
"               <td><input type=\"checkbox\" checked value=\"Restlessness\" class=\"form-control\" onclick=\"showfield(2);\" id=\"complaints2\" name=\"complaints2\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration2\" name=\"duration2\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>"
            + "<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid2\" name=\"presentcomplaintid2\"   >"+
            "              \n" ;}

               }else{
    Step3+="               <td style=\"padding-left: 50px;\">Restlessness </td>\n" +
"               <td><input type=\"checkbox\"  value=\"Restlessness\" class=\"form-control\" onclick=\"showfield(2);\" id=\"complaints2\" name=\"newcomplaints2\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration2\" name=\"newduration2\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"              \n" ;}
        String getPresentComplaint2="select * from presentcomplaints where PatientID='"+patientid+"' and Complaint='Headache'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint2);
               if(conn.rs3.next()){         
if(conn.rs3.getString("complaint").equals("Headache")){   
       count++;
Step3+=
"               <td style=\"padding-left: 50px;\">Headache </td>\n" +
"               <td><input type=\"checkbox\" checked  value=\"Headache\" class=\"form-control\" onclick=\"showfield(3);\" id=\"complaints3\" name=\"complaints3\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration3\" name=\"duration3\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" 
   + "<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid3\" name=\"presentcomplaintid3\"   >"+
        "              \n" ;

Step3+="               </tr>\n" +
"               <tr>\n" ;
}
}else{
Step3+="               <td style=\"padding-left: 50px;\">Headache </td>\n" +
"               <td><input type=\"checkbox\"  value=\"Headache\" class=\"form-control\" onclick=\"showfield(3);\" id=\"complaints3\" name=\"newcomplaints3\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration3\" name=\"newduration3\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"              \n" ;

Step3+="               </tr>\n" +
"               <tr>\n" ;
}
  String getPresentComplaint3="select * from presentcomplaints where PatientID='"+patientid+"' and Complaint='Cough'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint3);
               if(conn.rs3.next()){
 if(conn.rs3.getString("complaint").equals("Cough")){   
        count++;
Step3+=" <td style=\"padding-left: 50px;\">Cough</td><td><input type=\"checkbox\"  checked value=\"Cough\" class=\"form-control\" onclick=\"showfield(4);\" id=\"complaints4\" name=\"complaints4\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid4\" name=\"presentcomplaintid4\"   >"+
        "               <td><input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration4\" name=\"duration4\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;}
 }else{
 Step3+=" <td style=\"padding-left: 50px;\">Cough</td><td><input type=\"checkbox\"  value=\"Cough\" class=\"form-control\" onclick=\"showfield(4);\" id=\"complaints4\" name=\"newcomplaints4\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration4\" name=\"newduration4\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;
 }
                 String getPresentComplaint4="select * from presentcomplaints where PatientID='"+patientid+"' and  Complaint='Irritability'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint4);
               if(conn.rs3.next()){
 if(conn.rs3.getString("complaint").equals("Irritability")){ 
        count++;
Step3+=
"               <td style=\"padding-left: 50px;\">Irritability</td><td><input type=\"checkbox\" checked value=\"Irritability\" class=\"form-control\" onclick=\"showfield(5);\" id=\"complaints5\" name=\"complaints5\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration5\" name=\"duration5\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid5\" name=\"presentcomplaintid5\"   >"+"               \n" ;
 }
}else{
  Step3+=
"               <td style=\"padding-left: 50px;\">Irritability</td><td><input type=\"checkbox\"  value=\"Irritability\" class=\"form-control\" onclick=\"showfield(5);\" id=\"complaints5\" name=\"newcomplaints5\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration5\" name=\"newduration5\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;   
 }
                 String getPresentComplaint5="select * from presentcomplaints where PatientID='"+patientid+"' and  Complaint='Abdominal Pains'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint5);
               if(conn.rs3.next()){
if(conn.rs3.getString("complaint").equals("Abdominal Pains")){  
       count++;
Step3+=          "  <td style=\"padding-left: 50px;\">Abdominal Pains</td><td><input type=\"checkbox\" checked value=\"Abdominal Pains\" class=\"form-control\" onclick=\"showfield(6);\" id=\"complaints6\" name=\"complaints6\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration6\" name=\"duration6\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid6\" name=\"presentcomplaintid6\"   >"+
        "               \n" ;
Step3+=
"               </tr>\n" +
"               <tr>\n" ;}
}
else{  
Step3+=          "  <td style=\"padding-left: 50px;\">Abdominal Pains</td><td><input type=\"checkbox\"  value=\"Abdominal Pains\" class=\"form-control\" onclick=\"showfield(6);\" id=\"complaints6\" name=\"newcomplaints6\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration6\" name=\"newduration6\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;
Step3+=
"               </tr>\n" +
"               <tr>\n" ;}
  String getPresentComplaint6="select * from presentcomplaints where PatientID='"+patientid+"' and Complaint='Vomiting'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint6);
               if(conn.rs3.next()){
if(conn.rs3.getString("complaint").equals("Vomiting")){  
       count++;
    Step3+=
"               <td style=\"padding-left: 50px;\">Vomiting</td><td><input type=\"checkbox\" checked value=\"Vomiting\" class=\"form-control\" onclick=\"showfield(7);\" id=\"complaints7\" name=\"complaints7\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration7\" name=\"duration7\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid7\" name=\"presentcomplaintid7\"   >"+
            "               \n" ;}
}else {  
    Step3+=
"               <td style=\"padding-left: 50px;\">Vomiting</td><td><input type=\"checkbox\"  value=\"Vomiting\" class=\"form-control\" onclick=\"showfield(7);\" id=\"complaints7\" name=\"newcomplaints7\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration7\" name=\"newduration7\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;}
                 String getPresentComplaint7="select * from presentcomplaints where PatientID='"+patientid+"' and  Complaint='Difficulty in Breathing'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint7);
               if(conn.rs3.next()){
 if(conn.rs3.getString("complaint").equals("Difficulty in Breathing")){   
        count++;
Step3+="               <td style=\"padding-left: 50px;\">Difficulty in Breathing</td><td><input type=\"checkbox\" checked value=\"Difficulty in Breathing\" class=\"form-control\" onclick=\"showfield(8);\" id=\"complaints8\" name=\"complaints8\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration8\" name=\"duration8\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid8\" name=\"presentcomplaintid8\"   >"+
        "               \n" ;
 }}else{
     Step3+="               <td style=\"padding-left: 50px;\">Difficulty in Breathing</td><td><input type=\"checkbox\"  value=\"Difficulty in Breathing\" class=\"form-control\" onclick=\"showfield(8);\" id=\"complaints8\" name=\"newcomplaints8\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration8\" name=\"newduration8\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;
 }
                 String getPresentComplaint8="select * from presentcomplaints where PatientID='"+patientid+"' and  Complaint='Body Aches'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint8);
               if(conn.rs3.next()){
 if(conn.rs3.getString("complaint").equals("Body Aches")){   
        count++;
Step3+="              <td style=\"padding-left: 50px;\">Body Aches </td><td><input type=\"checkbox\" checked value=\"Body Aches\" class=\"form-control\" onclick=\"showfield(9);\" id=\"complaints9\" name=\"complaints9\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration9\" name=\"duration9\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid9\" name=\"presentcomplaintid9\"   >"+
        "               \n" ;

 Step3+="               </tr>\n" +
"               <tr>\n" ;}}
else{
 
 Step3+="              <td style=\"padding-left: 50px;\">Body Aches </td><td><input type=\"checkbox\"  value=\"Body Aches\" class=\"form-control\" onclick=\"showfield(9);\" id=\"complaints9\" name=\"newcomplaints9\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration9\" name=\"newduration9\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;
 Step3+="               </tr>\n" +
"               <tr>\n" ;
 }
  String getPresentComplaint9="select * from presentcomplaints where PatientID='"+patientid+"' and Complaint='Diarrhea'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint9);
               if(conn.rs3.next()){
if(conn.rs3.getString("complaint").equals("Diarrhea")){ 
       count++;
Step3+="                 <td style=\"padding-left: 50px;\">Diarrhea</td><td><input type=\"checkbox\"  checked value=\"Diarrhea\" class=\"form-control\" onclick=\"showfield(10);\" id=\"complaints10\" name=\"complaints10\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration10\" name=\"duration10\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid10\" name=\"presentcomplaintid10\"   >"+
        "               \n" ;
}
}
               else{
 Step3+="                 <td style=\"padding-left: 50px;\">Diarrhea</td><td><input type=\"checkbox\"  value=\"Diarrhea\" class=\"form-control\" onclick=\"showfield(10);\" id=\"complaints10\" name=\"newcomplaints10\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration10\" name=\"newduration10\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;   
}
                 String getPresentComplaint10="select * from presentcomplaints where PatientID='"+patientid+"' and Complaint='Convulsions'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint10);
               if(conn.rs3.next()){
if(conn.rs3.getString("complaint").equals("Convulsions")){
       count++;
    Step3+="               <td style=\"padding-left: 50px;\">Convulsions</td><td><input type=\"checkbox\" checked value=\"Convulsions\" class=\"form-control\" onclick=\"showfield(11);\" id=\"complaints11\" name=\"complaints11\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration11\" name=\"duration11\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid11\" name=\"presentcomplaintid11\"   >"+
            "               \n" ;
          }
}
               else{

    Step3+="               <td style=\"padding-left: 50px;\">Convulsions</td><td><input type=\"checkbox\"  value=\"Convulsions\" class=\"form-control\" onclick=\"showfield(11);\" id=\"complaints11\" name=\"newcomplaints11\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration11\" name=\"newduration11\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;

}
                 String getPresentComplaint11="select * from presentcomplaints where PatientID='"+patientid+"' and Complaint='Joint Pain'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint11);
               if(conn.rs3.next()){
if(conn.rs3.getString("complaint").equals("Joint Pain")){  
       count++;
Step3+="                <td style=\"padding-left: 50px;\">Joint Pain</td><td><input type=\"checkbox\" checked value=\"Joint Pain\" class=\"form-control\" onclick=\"showfield(12);\" id=\"complaints12\" name=\"complaints12\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration12\" name=\"duration12\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid12\" name=\"presentcomplaintid12\"   >"+
        "               \n" ;
Step3+="               </tr>\n" +
"               <tr>\n" ;}
}else{
Step3+="                <td style=\"padding-left: 50px;\">Joint Pain</td><td><input type=\"checkbox\"  value=\"Joint Pain\" class=\"form-control\" onclick=\"showfield(12);\" id=\"complaints12\" name=\"newcomplaints12\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration12\" name=\"newduration12\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;
Step3+="               </tr>\n" +
"               <tr>\n" ;
}
                 String getPresentComplaint12="select * from presentcomplaints where PatientID='"+patientid+"'  and Complaint='Swelling'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint12);
               if(conn.rs3.next()){

        
if(conn.rs3.getString("complaint").equals("Swelling")){   
       count++;
Step3+="  <td style=\"padding-left: 50px;\">Swelling</td><td><input type=\"checkbox\" checked  value=\"Swelling\" class=\"form-control\" onclick=\"showfield(13);\" id=\"complaints13\" name=\"complaints13\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"  value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration13\" name=\"duration13\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid13\" name=\"presentcomplaintid13\"   >"+
        "               \n" ;
}
}
               else{
               
          Step3+="  <td style=\"padding-left: 50px;\">Swelling</td><td><input type=\"checkbox\"   value=\"Swelling\" class=\"form-control\" onclick=\"showfield(13);\" id=\"complaints13\" name=\"newcomplaints13\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration13\" name=\"SwellingDuration\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +

        "               \n" ;     
               
               
               }            
               
                  String getPresentComplaint14="select * from presentcomplaints where PatientID='"+patientid+"'  and Complaint='Growth'";
          conn.rs3 = conn.state3.executeQuery(getPresentComplaint14);
               if(conn.rs3.next()){

        
if(conn.rs3.getString("complaint").equals("Swelling")){   
             
Step3+="               <td style=\"padding-left: 50px;\">Growth </td><td><input type=\"checkbox\"  checked value=\"Growth\" class=\"form-control\" onclick=\"showfield(14);\" id=\"complaints14\" name=\"newcomplaints14\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration14\" name=\"newduration14\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs3.getString(1)+"\"  id=\"presentcomplaintid14\" name=\"presentcomplaintid14\"   >"+
        "               \n" ;
}}else{
 Step3+="               <td style=\"padding-left: 50px;\">Growth </td><td><input type=\"checkbox\"  value=\"Growth\" class=\"form-control\" onclick=\"showfield(14);\" id=\"complaints14\" name=\"newcomplaints14\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration14\" name=\"newduration14\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;   
    
}
                 String getPresentComplaint13="select * from presentcomplaints where PatientID='"+patientid+"' and  Complaint='Yellow Eyes'";
          conn.rs4 = conn.state4.executeQuery(getPresentComplaint13);
               if(conn.rs4.next()==true){
                   System.out.println(conn.rs4.getString("complaint")+"  nn  "+conn.rs4.getString(1));
if(conn.rs4.getString("complaint").equals("Yellow Eyes")){ 
       count++;
    Step3+="<td style=\"padding-left: 50px;\">Yellow Eyes </td><td><input type=\"checkbox\"  checked value=\"Yellow Eyes\" class=\"form-control\" onclick=\"showfield(15);\" id=\"complaints15\" name=\"complaints15\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"text\" value=\""+conn.rs4.getString("duration")+"\" class=\"form-control\"  id=\"duration15\" name=\"duration15\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"<input type=\"hidden\"  value=\""+conn.rs4.getString(1)+"\"  id=\"presentcomplaintid15\" name=\"presentcomplaintid15\"   >"+
            "               \n" ;}
    }else{
    Step3+="<td style=\"padding-left: 50px;\">Yellow Eyes<td><td><input type=\"checkbox\"  value=\"Yellow Eyes\" class=\"form-control\" onclick=\"showfield(15);\" id=\"complaints15\" name=\"newcomplaints15\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration15\" name=\"newduration15\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" ></td>\n" +
"               \n" ;


}
Step3+="               </tr>\n" +
"               <tr>\n" ;
//for(int i=0; i<complaintarray.length;i++){
//if(!conn.rs3.getString("complaint").equals(complaintarray[i])){ 
//    Step3+="<td style=\"padding-left: 50px;\">Other </td><td><input type=\"checkbox\"  checked value=\"Other\" class=\"form-control\" onclick=\"showfield(16);\" id=\"other16\" name=\"Others\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
//"               <td><input type=\"text\"  value=\""+conn.rs3.getString("complaint")+"\" class=\"form-control\"  id=\"complaint16\" name=\"complaints16\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" placeholder=\"complaint...\" ></td>\n" +
//"               <td><td><input type=\"text\"   value=\""+conn.rs3.getString("duration")+"\" class=\"form-control\"  id=\"duration16\" name=\"duration16\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\"  placeholder=\"duration...\"></td>\n" ;
//}  
//else{
//   Step3+="<td style=\"padding-left: 50px;\">Other </td><td><input type=\"checkbox\"  value=\"Other\" class=\"form-control\" onclick=\"showfield(16);\" id=\"other16\" name=\"Others\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\" ></td>\n" +
//"               <td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"complaint16\" name=\"complaint16\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\" placeholder=\"complaint...\" ></td>\n" +
//"               <td><td><input type=\"hidden\"  value=\"\" class=\"form-control\"  id=\"duration16\" name=\"duration16\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;\"  placeholder=\"duration...\"></td>\n" ;
//          
//
//}}
   Step3+=         "               </tr>\n" +
"                   \n" +
"                 \n" +
    "       <input type=\"hidden\"  value=\""+count+"\" id=\"rowcount\" name=\"rowcount\" >"+
"                    </table>\n" +
"" ;
          
          
          
          System.out.println(count);
          
      String nutrition=""; 
      String generalconditions="";
      String faceodema="";
      String pittinglegoedema="";
      String faceoedema="";
      String dehydration="";
              String rashes="";
             String lymph=""; 
             String jaundice="";
     String nutritionalstatus[]={"","Good","Underweight","Obvious Malnutrition","Overweight","Obese"};      
     String generalcondition[]={"","Good","Fair","Poor"};      
     String present_absent []={"","Present","Absent"};      
     String lymphnodes []={"","Palpable","Not Palpable"};      
     String lymphlocation []={"","Neck","Axilla","Groin"};      
      String examinationfindings="select * from examinationfindings where PatientID='"+patientid+"' ";
     System.out.println(examinationfindings);
      conn.rs4 = conn.state4.executeQuery(examinationfindings);
      while(conn.rs4.next())
      {
          System.out.println("aaaa"+conn.rs4.getString("dehydration"));
            for(int a=0;a<nutritionalstatus.length;a++){
                
                if(nutritionalstatus[a].equals(conn.rs4.getString("Nutritionalstatus"))){
                    
                nutrition+="<option selected value=\""+nutritionalstatus[a]+"\">"+nutritionalstatus[a]+"</option>";
                
                }
                
                else{
                nutrition+="<option value=\""+nutritionalstatus[a]+"\">"+nutritionalstatus[a]+"</option>";
                }
                             }
            for(int a=0;a<generalcondition.length;a++){
                
                if(generalcondition[a].equals(conn.rs4.getString("Generalcondition"))){
                    
                generalconditions+="<option selected value=\""+generalcondition[a]+"\">"+generalcondition[a]+"</option>";
                
                }
                
                else{
                generalconditions+="<option value=\""+generalcondition[a]+"\">"+generalcondition[a]+"</option>";
                }
                             }
            for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs4.getString("dehydration"))){
                    
                dehydration+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                dehydration+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
                             }
            for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs4.getString("faceoedema"))){
                    
                faceoedema+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                faceoedema+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
                             }
            for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs4.getString("legoedema"))){
                    
                pittinglegoedema+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                pittinglegoedema+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
                             }
            for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs4.getString("jaundice"))){
                    
                jaundice+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                jaundice+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
                             }
            for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs4.getString("rashes"))){
                    
                rashes+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                rashes+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
                             }
            for(int a=0;a<lymphnodes.length;a++){
                
                if(lymphnodes[a].equals(conn.rs4.getString("Lymphnodes"))){
                    
                lymph+="<option selected value=\""+lymphnodes[a]+"\">"+lymphnodes[a]+"</option>";
                
                }
                
                else{
                lymph+="<option value=\""+lymphnodes[a]+"\">"+lymphnodes[a]+"</option>";
                }
                       }
              String   lymphlocations="";  
            for(int a=0;a<lymphlocation.length;a++){
                
                if(lymphlocation[a].equals(conn.rs4.getString("Lymphnodeslocation"))){
                    
                lymphlocations+="<option selected value=\""+lymphlocation[a]+"\">"+lymphlocation[a]+"</option>";
                
                }
                
                else{
                lymphlocations+="<option value=\""+lymphlocation[a]+"\">"+lymphlocation[a]+"</option>";
                }
                             }
      Step4+="<table style=\"padding-left: 300px;\" class=\"viewpdt\">\n" +
"               <tr></tr>        \n" +
"               <tr>\n" +
"                            <td>Nutritional Status</td><td>\n" +
"                                <select class=\"form-control\"  name=\"nutritionalstatus\"   style=\"height:30px;\"  > "+nutrition+"</select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                            \n" +
"                              <tr> <td>General Condition or Appearance?</td><td>\n" +
"                                <select class=\"form-control\"  name=\"generalcondition\"   style=\"height:30px;\"  >"+generalconditions+"</select>\n" +
"                                \n" +
"                                </td>\n" +
"                                   <td class=\"help-block\"  style=\"height:30px;\">(If Poor Admit child)</td>   \n" +
"                              </tr>\n" +
"                              <tr>\n" +
"                                  <td>Dyspnea</td><td><input type=\"text\" value=\""+conn.rs4.getString("dyspnea")+"\"  class=\"form-control\" name=\"Dyspnea\"   style=\"height:30px;\"></td>\n" +
"                              </tr>\n" +
"                              <tr>\n" +
"                                  <td>Tachypnea</td><td><input type=\"text\" value=\""+conn.rs4.getString("tachypnea")+"\"  class=\"form-control\" name=\"Tachypnea\"   style=\"height:30px;\"></td>\n" +
"                              </tr>\n" +
"                <tr> <td>Dehydration?</td><td>\n" +
"                                <select class=\"form-control\"  name=\"dehydration\"   style=\"height:30px;\"  >"+dehydration+" </select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                       <tr>\n" +
"                           <td>Temperature</td><td><input type=\"text\"  class=\"form-control\" name=\"Temperature\"  value=\""+conn.rs4.getString("temperature")+"\"  style=\"height:30px;\"></td>\n" +
"                        </tr>\n" +
"                          <tr> <td>Jaundice</td><td>\n" +
"                                <select class=\"form-control\"  name=\"Jaundice\"   style=\"height:30px;\"  >"+jaundice+"</select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                          <tr> <td>Lymph Nodes</td><td>\n" +
"                                  <select class=\"form-control\"  name=\"lymphnodes\" id=\"lymphnodes\" onchange=\"showlymphnode()\"  style=\"height:30px;\"  >"+lymph+" </select>\n" +
"                                </td>\n" +
"                              </tr>\n" ;
      if((conn.rs4.getString("Lymphnodes").equals("Palpable"))) {
Step4+="                          <tr id=\"lymphlocation\"><td>Lymph Node Location</td><td>"+
            "<select class=\"form-control\"  name=\"lymphnodelocation\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  >"
        + ""+lymphlocations+ ""
+ "</select></td></tr>";               
}
  
Step4+="                              " +
"                          <tr> <td>Face Oedema</td><td>\n" +
"                                <select class=\"form-control\"  name=\"faceoedema\"   style=\"height:30px;\"  >"+faceoedema+"</select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                       \n" +
"                          <tr> <td>Pitting Leg Oedema</td><td>\n" +
"                                <select class=\"form-control\"  name=\"pittinglegoedema\"   style=\"height:30px;\"  >"+pittinglegoedema+"</select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                          <tr> <td>Rashes</td><td>\n" +
"                                  <select class=\"form-control\"  name=\"rashes\" id=\"rashes\" onchange=\"showrashes()\"  style=\"height:30px;\"  >"+rashes+"</select>\n" +
"                                </td></tr>\n" +
"                                <tr><td>Rash type</td> <td><input type=\"text\"  class=\"form-control\" value=\""+conn.rs4.getString("rashtype")+"\"  name=\"rashesdescription\" id=\"rashesdescription\" placeholder=\"Rashes Description....\"  style=\"height:30px;\"></td></tr>\n" +
"                                <tr><td>Rash Description</td> <td><input type=\"text\"  class=\"form-control\" value=\""+conn.rs4.getString("rashlocation")+"\"   name=\"rasheslocation\" id=\"rasheslocation\" placeholder=\"Rashes Location....\"  style=\"height:30px;\"></td>\n" +
"                              </tr>\n" +
"                              \n" +
"                       \n" +
"                    </table>";
      
      
      
      }          
          
          
          
          
          
            try {
                
                jsonobj.put("step1", Step1);
                jsonobj.put("step2", Step2);
                jsonobj.put("step3", Step3);
                jsonobj.put("step4", Step4);
               
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
            Logger.getLogger(getGeneralExamination.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getGeneralExamination.class.getName()).log(Level.SEVERE, null, ex);
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
