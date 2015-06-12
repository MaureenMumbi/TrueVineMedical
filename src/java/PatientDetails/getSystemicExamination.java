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
public class getSystemicExamination extends HttpServlet {

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
               String nutritionalstatus[]={"","Good","Underweight","Obvious Malnutrition","Overweight","Obese"};      
     String generalcondition[]={"","Good","Fair","Poor"};      
     String present_absent []={"","Present","Absent"};    
     String normal_ab []={"","Normal","Abnormal"};  
      String palpable_not []={"","Palpable","Not Palpable"};    
      String uniform_irreg []={"","Uniform","Irregular"};    
      String normal_red []={"","Normal","Reduced","Increased"};    
      String masslocations[]={"Epigastrium","Right Hypochondrium","Right Lumbar","Right Iliac Fosa","Hypogastrium","Left Hypochondrium","Left Lumbar","Left Iliac Fosa"};
       String conciousness[]={"Fully Conscious","Drowsy","Unconscious"};     
     String ralesleft="";
     String ralesright="";
     String rhonchiright="";
     String rhonchileft="";
     String murmur="";
     String heartsize="";
     String heartsounds="";
     String distention="";
     String bowelsounds ="";
     String tenderness="";
     String distentiondesc="";
     String mass="";
     String masslocation="";
     String LeftKidney="";
     String RightKidney="";
     String liver="";
     String movements="";
     String tone="";
     String power="";
     String reflexes="";
     String concious="";
     String get="select * from cardiovascular";
     conn.rs3= conn.state3.executeQuery(get);
     while(conn.rs3.next()){
         System.out.println(conn.rs3.getString(1) +" aa"+conn.rs3.getString(2)+"bbb "+conn.rs3.getString("heartsounds"));
     }
          
          JSONObject jsonobj = new JSONObject();
//          String 
           System.out.println("systemiceexamination  "+patientid);
          String getRespiratory="select * from respiratory where PatientID='"+patientid+"'";
          conn.rs = conn.state.executeQuery(getRespiratory);
          while(conn.rs.next()){
               for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs.getString("RalesLeft"))){
                    
                ralesleft+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                ralesleft+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }}
             for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs.getString("RalesRight"))){
                    
                ralesright+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                ralesright+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }}
             for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs.getString("RhonchiRight"))){
                    
                rhonchiright+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                rhonchiright+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }}
             for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs.getString("RhonchiLeft"))){
                    
                rhonchileft+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                rhonchileft+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }}
          Step1+="<fieldset>\n" +
"                    <h2> Fill all fields</h2>\n" +
"	\n" +
"                    <table style=\"padding-left: 300px;\" class=\"viewpdt\">\n" +
"                        \n" +
"                        <tr>\n" +
"                            <input type=\"hidden\" name=\"respiratoryid\" value=\""+conn.rs.getString("RespiratoryID")+"\" > <td>Air Entry Left Lung Fields</td><td>\n" +
"                                <select name=\"airentryleft\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >\n";
     if(conn.rs.getString("AirEntryLeftLung").equals("Good")){  
                           
                            Step1+= " <option value=\"\"></option>  \n" +
"                                    <option selected value=\"Good\">Good</option>  \n" +
"                                    <option value=\"Poor\">Poor</option>  \n" +
"                                    <option value=\"Absent\">Absent</option>  \n"  ;
     }
     else if(conn.rs.getString("AirEntryLeftLung").equals("Poor")){
                                    
                                           Step1+= " <option value=\"\"></option>  \n" +
"                                    <option  value=\"Good\">Good</option>  \n" +
"                                    <option selected value=\"Poor\">Poor</option>  \n" +
"                                    <option value=\"Absent\">Absent</option>  \n"  ;
                                          
                                           }
                     else{ Step1+= " <option value=\"\"></option>  \n" +
"                                    <option  value=\"Good\">Good</option>  \n" +
"                                    <option value=\"Poor\">Poor</option>  \n" +
"                                    <option  selected value=\"Absent\">Absent</option>  \n"  ;}                
                  
                  
            
Step1+="</select>\n" +
"                            </td>\n" +
"                         </tr>\n" +
"                          <tr> <td>Air Entry Right Lung Fields</td>\n" +
"                                <td>\n" +
"                                  <select name=\"airentryright\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >\n" ;
     if(conn.rs.getString("AirEntryRightLung").equals("Good")){  
                           
                            Step1+= " <option value=\"\"></option>  \n" +
"                                    <option selected value=\"Good\">Good</option>  \n" +
"                                    <option value=\"Poor\">Poor</option>  \n" +
"                                    <option value=\"Absent\">Absent</option>  \n"  ;
     }
     else if(conn.rs.getString("AirEntryRightLung").equals("Poor")){
                                    
                                           Step1+= " <option value=\"\"></option>  \n" +
"                                    <option  value=\"Good\">Good</option>  \n" +
"                                    <option selected value=\"Poor\">Poor</option>  \n" +
"                                    <option value=\"Absent\">Absent</option>  \n"  ;
                                          
                                           }
                     else{ Step1+= " <option value=\"\"></option>  \n" +
"                                    <option  value=\"Good\">Good</option>  \n" +
"                                    <option value=\"Poor\">Poor</option>  \n" +
"                                    <option  selected value=\"Absent\">Absent</option>  \n"  ;}                
                  
                                             
Step1+="  </select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                           <tr>  <td>Rales Left</td>\n" +
"                               <td>\n" +
"                                   <select name=\"ralesleft\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+ralesleft+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                           <tr>  <td>Rales Right</td>\n" +
"                               <td>\n" +
"                                   <select name=\"ralesright\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+ralesright+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                           <tr>  <td>Rhonchi Left</td>\n" +
"                               <td>\n" +
"                                   <select name=\"rhonchileft\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+rhonchileft+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                           <tr>  <td>Rhonchi Right</td>\n" +
"                               <td>\n" +
"                                   <select name=\"rhonchiright\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+rhonchiright+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                       \n" +
"                      \n" +
"                    </table>\n" +
"                             \n" +
"								</fieldset>";}
          
          
         String getcardiovascular=" select * from cardiovascular where PatientID='"+patientid+"'";
         System.out.println(getcardiovascular);
          conn.rs2 = conn.state2.executeQuery(getcardiovascular);
          while(conn.rs2.next()){
              
              System.out.println("heart sounds "+conn.rs2.getString("heartsounds"));
              // heart sounds 
                 for(int a=0;a<normal_ab.length;a++){
                
                if(normal_ab[a].equals(conn.rs2.getString("heartsounds"))){
                    
                heartsounds+="<option selected value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                
                }
                                else{
                heartsounds+="<option value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                }}
                 
                 // heart murmur
                       for(int a=0;a<present_absent.length;a++){
                if(present_absent[a].equals(conn.rs2.getString("murmur"))){
                    
                murmur+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                murmur+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }}
                       
                       // heart size
             for(int a=0;a<normal_ab.length;a++){
                
                if(normal_ab[a].equals(conn.rs2.getString("heartsize"))){
                    
                heartsize+="<option selected value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                
                } else{
                heartsize+="<option value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                }}
          Step2+="    <table style=\" width:300px;\" class=\"viewpdt\">\n" +
"                   <tr><input type=\"hidden\" name=\"cardiovascularid\" value=\""+conn.rs2.getString("CardiovascularID")+"\" >   <td>Heart Sounds</td>\n" +
"                               <td>\n" +
"                                   <select name=\"heartsounds\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+heartsounds+" </select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                           <tr>  <td>Murmur</td>\n" +
"                               <td>\n" +
"                                   <select name=\"murmur\" class=\"form-control\" id=\"murmur\" onchange=\"showmurmur();\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+murmur+" </select>\n" +
"                               </td>\n" +
"                               <td><input type=\"hidden\" name=\"murmurdescription\" value=\""+conn.rs2.getString("murmurtype")+"\"  placeholder=\"Murmur Description ...\" id=\"murmurdescription\" style=\"padding-bottom: 10px; margin-bottom: 10px; height:30px; margin-left: 25px; width: 350px;\"></td>\n" +
"                           </tr>\n" +
"                       \n" +
"                       \n" +
"                           <tr>  <td>Heart Size</td>\n" +
"                               <td>\n" +
"                                   <select name=\"heartsize\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+heartsize+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                       \n" +
"          \n" +
"          \n" +
"                </table>";
          }
//          String getabdomen="select * from abdomen"
          String getabdomen=" select * from abdomen where PatientID='"+patientid+"'";
         System.out.println(getabdomen);
          conn.rs3 = conn.state3.executeQuery(getabdomen);
          while(conn.rs3.next()){
              
           for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs3.getString("Distention"))){
                    
                distention+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                distention+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
           }
             for(int a=0;a<uniform_irreg.length;a++){
                
                if(uniform_irreg[a].equals(conn.rs3.getString("DistentionType"))){
                    
                distentiondesc+="<option selected value=\""+uniform_irreg[a]+"\">"+uniform_irreg[a]+"</option>";
                
                }
                
                else{
                distentiondesc+="<option value=\""+uniform_irreg[a]+"\">"+uniform_irreg[a]+"</option>";
                }
           }
           for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs3.getString("BowelSounds"))){
                    
                bowelsounds+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                bowelsounds+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
           }
           for(int a=0;a<present_absent.length;a++){
                
                if(present_absent[a].equals(conn.rs3.getString("Tenderness"))){
                    
                tenderness+="<option selected value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                
                }
                
                else{
                tenderness+="<option value=\""+present_absent[a]+"\">"+present_absent[a]+"</option>";
                }
           }
         
           for(int a=0;a<palpable_not.length;a++){
                
                if(palpable_not[a].equals(conn.rs3.getString("Mass"))){
                    
                mass+="<option selected value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                
                }
                
                else{
                mass+="<option value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                }
           }
           for(int a=0;a<masslocations.length;a++){
                
                if(masslocations[a].equals(conn.rs3.getString("MassLocation"))){
                    
                masslocation+="<option selected value=\""+masslocations[a]+"\">"+masslocations[a]+"</option>";
                
                }
                
                else{
                masslocation+="<option value=\""+masslocations[a]+"\">"+masslocations[a]+"</option>";
                }
           }
           
           
            for(int a=0;a<palpable_not.length;a++){
                
                if(palpable_not[a].equals(conn.rs3.getString("Liver"))){
                    
                liver+="<option selected value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                
                }
                
                else{
                liver+="<option value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                }
           }
            for(int a=0;a<palpable_not.length;a++){
                
                if(palpable_not[a].equals(conn.rs3.getString("LeftKidney"))){
                    
                LeftKidney+="<option selected value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                
                }
                
                else{
                LeftKidney+="<option value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                }
           }
            for(int a=0;a<palpable_not.length;a++){
                
                if(palpable_not[a].equals(conn.rs3.getString("RightKidney"))){
                    
                RightKidney+="<option selected value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                
                }
                
                else{
                RightKidney+="<option value=\""+palpable_not[a]+"\">"+palpable_not[a]+"</option>";
                }
           }
          Step3+="  <table style=\"padding-left: 300px;\" class=\"viewpdt\">\n" +
"                      \n" +
"                <tr> <input type=\"hidden\" name=\"AbdomenID\" value=\""+conn.rs3.getString("AbdomenID")+"\" > <td>Distention</td>\n" +
"                               <td>\n" +
"                                   <select name=\"distention\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+distention+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                <tr>  <td>Specify Distention</td>\n" +
"                               <td>\n" +
"                                   <select name=\"distentiondescription\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+distentiondesc+" </select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                           <tr>  <td>Bowel Sounds</td>\n" +
"                               <td>\n" +
"                                   <select name=\"bowelsounds\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+bowelsounds+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                         \n" +
"                        <tr>  <td>Mass</td>\n" +
"                               <td>\n" +
"                                   <select name=\"mass\" id=\"mass\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+mass+" </select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                           <tr>  <td>Palpable Mass Location</td>\n" +
"                               <td>\n" +
"                                   <select name=\"masslocation\"  id=\"masslocation\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+masslocation+"</select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                         <tr>  <td>Tenderness</td>\n" +
"                               <td>\n" +
"                                   <select name=\"tenderness\" id=\"tenderness\" onchange=\"showtenderness();\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+tenderness+" </select>\n" +
"                               </td>\n" +
"                               \n" +
"                               <td> <input type=\"hidden\" name=\"tendernesslocation\" value=\"\" id=\"tendernesslocation\" placeholder=\"Tenderness Location ......\"  class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"> \n" +
"                               </td>\n" +
"                        </tr>\n" +
"                        \n" +
"                        \n" +
"                   <tr>  <td>Liver</td>\n" +
"                               <td>\n" +
"                                   <select name=\"liver\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+liver+"</select>\n" +
"                               </td>\n" +
"                               <td><input type=\"text\" name=\"liversize\" value=\"\" id=\"liversize\"  class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;\"></td><td> <span class=\"input-group-addon\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px;\">CM</span></td>\n" +
"                        </tr>\n" +
"                      \n" +
"            \n" +
"                          <tr>  <td>Left Kidney</td>\n" +
"                               <td>\n" +
"                                   <select name=\"leftkidney\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+LeftKidney+" </select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"            \n" +
"                          <tr>  <td>Right Kidney</td>\n" +
"                               <td>\n" +
"                                   <select name=\"rightkidney\" class=\"form-control\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" >"+RightKidney+" </select>\n" +
"                               </td>\n" +
"                        </tr>\n" +
"                    </table>";
          }
          
          
          
      String getnervous="select * from nervous where PatientID='"+patientid+"'";
      conn.rs4= conn.state4.executeQuery(getnervous);
      while(conn.rs4.next()){
           for(int a=0;a<normal_ab.length;a++){
                
                if(normal_ab[a].equals(conn.rs4.getString("movements"))){
                    
                movements+="<option selected value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                
                } else{
                movements+="<option value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                }}
           for(int a=0;a<normal_ab.length;a++){
                
                if(normal_ab[a].equals(conn.rs4.getString("movements"))){
                    
                power+="<option selected value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                
                } else{
                power+="<option value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                }}
           for(int a=0;a<normal_ab.length;a++){
                
                if(normal_ab[a].equals(conn.rs4.getString("movements"))){
                    
                tone+="<option selected value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                
                } else{
                tone+="<option value=\""+normal_ab[a]+"\">"+normal_ab[a]+"</option>";
                }}
           for(int a=0;a<normal_red.length;a++){
                
                if(normal_red[a].equals(conn.rs4.getString("reflexes"))){
                    
                reflexes+="<option selected value=\""+normal_red[a]+"\">"+normal_red[a]+"</option>";
                
                } else{
                reflexes+="<option value=\""+normal_red[a]+"\">"+normal_red[a]+"</option>";
                }}
           for(int a=0;a<conciousness.length;a++){
                
                if(conciousness[a].equals(conn.rs4.getString("movements"))){
                    
                concious+="<option selected value=\""+conciousness[a]+"\">"+conciousness[a]+"</option>";
                
                } else{
                concious+="<option value=\""+conciousness[a]+"\">"+conciousness[a]+"</option>";
                }}
          
          Step4+="  <table style=\"padding-left: 300px;\" class=\"viewpdt\">\n" +
"               <tr><input type=\"hidden\" name=\"nervousid\" value=\""+conn.rs4.getString("nervousID")+"\" ></tr>        \n" +
"               <tr>\n" +
"                            <td>State of consciousness</td><td>\n" +
"                                <select class=\"form-control\"  name=\"consciousness\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  >"+concious+" </select>\n" +
"                                </td>\n" +
"                              </tr>\n" +
"                            \n" +
"                              <tr> <td>Movements</td><td>\n" +
"                                      <select class=\"form-control\"  name=\"movements\"  id=\"movements\" onchange=\"showmovements();\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  >"+movements+"</select>\n" +
"                                </td>\n" +
"                                <td><input type=\"hidden\"  class=\"form-control\" name=\"movementsdescription\"  placeholder=\"Movements Description...\" id=\"movementsdescription\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"></td>\n" +
"                              </tr>\n" +
"                             \n" +
"                <tr> <td>Power</td><td>\n" +
"                                <select class=\"form-control\"  name=\"power\"  id=\"power\" onchange=\"showpower();\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  > "+power+" </select>\n" +
"                                </td>\n" +
"                                <td><input type=\"hidden\"  class=\"form-control\" name=\"powerdescription\" placeholder=\"Power Description...\" id=\"powerdescription\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"></td>\n" +
"                        </tr>\n" +
"                      \n" +
"                          \n" +
"                <tr> <td>Tone</td><td>\n" +
"                                <select class=\"form-control\"  name=\"tone\"  id=\"tone\" onchange=\"showtone();\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  >"+tone+" </select>\n" +
"                                </td>\n" +
"                                 <td><input type=\"hidden\"  class=\"form-control\" name=\"tonedescription\" id=\"tonedescription\" placeholder=\"Tone description....\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"></td>\n" +
"                        \n" +
"                              </tr>\n" +
"                      \n" +
"                          <tr> <td>Reflexes</td><td>\n" +
"                                <select class=\"form-control\"  name=\"reflexes\" id=\"reflexes\" onchange=\"showreflex();\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  >"+reflexes+"</select>\n" +
"                                </td>\n" +
"                                <td><input type=\"hidden\"  class=\"form-control\"  name=\"reflexdescription\" id=\"reflexdescription\" placeholder=\"Reflex Description....\" style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"></td>\n" +
"                              </tr>\n" +
"                             \n" +
"                       \n" +
"                    </table>";}
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
        }finally {            
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
            Logger.getLogger(getSystemicExamination.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getSystemicExamination.class.getName()).log(Level.SEVERE, null, ex);
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
