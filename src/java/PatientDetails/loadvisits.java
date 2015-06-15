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

/**
 *
 * @author MANUEL
 */
public class loadvisits extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
        try {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    
    //================================receive the parameters to load in here==========================
    String patientid="";
    String name="";
    String age="";
    //this is the visit number send by the user from the interface
    
    String visitnoparam="";
    String finaltable="";
    
    if(request.getParameter("age")!=null){
    age=request.getParameter("age");
    
    }
    if(request.getParameter("name")!=null){
    
    name=request.getParameter("name");
    }
    if(request.getParameter("patientid")!=null){
        
    patientid=request.getParameter("patientid");
    
    }
    
    if(request.getParameter("visitno")!=null){
        
    visitnoparam=request.getParameter("visitno");
    
    }
    
    
    //================================now create the tables=========
    
    //======first, check whether there is data from the followup tablw weather there is data for that specific table...
    
    dbConnect conn= new dbConnect();
  
    
    int followupid=0;
    //get the  max followupid plus one as the followup id of the next client
    
    String getfollowupid="select max(FollowUpId) from followup";
    
    conn.rs=conn.state.executeQuery(getfollowupid);
    
    while(conn.rs.next()){
    followupid=conn.rs.getInt(1)+1;
    }
   System.out.println("_____"+followupid);
  String checkvisits="select * from followup where patientId like '"+patientid+"' order by visit_no DESC limit 1";
  
 
  
  //if the visit number is specified, then load data for that visit.
  
  if(!visitnoparam.equalsIgnoreCase("")){
  
      checkvisits="select * from followup where patientId like '"+patientid+"' and visit_no='"+visitnoparam+"' order by visit_no DESC limit 1";
     System.out.println(" A precise visit no search..expect few visit options ");
  }
  
  
  conn.rs=conn.state.executeQuery(checkvisits);
  int visitno=1;
  
  //String visitoptions="<option selected value='1'>1</option>";
  String visitoptions="";
  
  if (conn.rs.next()){
      
     //get the maximum visit no for that client inorder to show a complete no of visits options

      String getmaxvizit="select Max(visit_no) as vz from followup where patientId like '"+patientid+"'";
      
      conn.rs2=conn.state2.executeQuery(getmaxvizit);
      if(conn.rs2.next()){
      visitno=conn.rs2.getInt("vz");
      }
      
      
  //=======now load the table with data
      //visitno=conn.rs.getInt("visit_no");
      //rem to create the options table      
      for(int a=1;a<=visitno+1;a++){
      

      if(a==conn.rs.getInt("visit_no")){ 
        visitoptions+="<option selected value="+a+"> Visit "+a+" (Attended)</option>";
                                        }
                   else if(a==visitno+1){ 
                       
        visitoptions+="<option  value="+a+"> Visit "+a+" (Not Attended) </option>";
                                         
                                         }
      
      else {
            visitoptions+="<option value="+a+">Visit "+a+" (Attended) </option>";
      
      }
      
      }
      
 finaltable="<tr><td style='text-align: left;'> Patients Name :</td><td> <input type='hidden' id='reg' name='reg' value="+patientid+" >"+name+"</td></tr> " 
 +" <tbody> <tr><td  style='text-align: left;'>Age :</td><td><input type='hidden' id='name' name='name' value='"+name+"'><input type='hidden' id='age' name='age' value='"+age+"'>"+age+"</td> </tr>"
 +" <tr><td  style='text-align: left;'>Visit no.:</td><td><select onchange='loadspecificvisit(this);' style='height:32px;' name='Visitno' id='visitno'>"+visitoptions+"</select></td></tr>"
 +" <tr><td style='text-align: left;'>Date of Visit:</td><td><input readonly  type='text' value='"+conn.rs.getString("revisitDate") +"'  name='date1' style='height:33px;width:240px;' id='date1' required/><button title='clear date field to blank' onclick=\"cleardate();\" class=\"btn btn-default\" type=\"button\">" +
"<i class=\"fa fa-refresh\" ></i></button></td></td></tr>"
 +"  <tr><th colspan='2' style='text-align: center;'>Finding Section</th></tr>"
 +" <tr><td style='text-align: left;'>Finding :</td><td>  <textarea name='finding' id='finding' required cols='40' rows='4'> "+conn.rs.getString("findings") +" </textarea></td>"
 +" </tr><tr><th colspan='2' style='text-align: center;'>Recomendations Section</th></tr>"
 +" <tr><td style='text-align: left;'>Recommendations :</td><td>  <textarea name='recomendation' id='recomendation' required cols='40' rows='4'>"+conn.rs.getString("recommendations")+" </textarea></td></tr>"
 +"<tr><td colspan='2'><input id=\"generate1\" class=\"generate1\" type=\"text\" style=\" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 38px; width:140px;text-align:center ; color:white ;background:coral; border-style:ridge ;\" readonly=\"\" onclick=\"saveVisits();\"  value=\"Update\"><input type='hidden' name='followupid' id='followupid' value=\""+conn.rs.getInt("FollowUpId")+"\"/></td>  </tr></tbody>";     
      
  }
  
  else{
     String visitvalue="1";
      
     if(!visitnoparam.equals("")){visitvalue=visitnoparam;}
 
  //========================if the max visit no was selected and one needs to preview the unselected list of visits
  
  checkvisits="select * from followup where patientId like '"+patientid+"' order by visit_no DESC limit 1";
  
  
   conn.rs1=conn.state1.executeQuery(checkvisits);
  
   if(conn.rs1.next()){
      // System.out.println(" A general visit no search ");
       
  //=======now load the table with data
      visitno=conn.rs1.getInt("visit_no");
      //rem to create the options table      
           
           for(int a=1;a<=visitno+1;a++){
      

      if(a==Integer.parseInt(visitvalue)){ 
        visitoptions+="<option selected value="+a+"> Visit "+a+" (Not Attended)</option>";
                                          }
      else if(a!=Integer.parseInt(visitvalue))
                                         { 
        visitoptions+="<option  value="+a+"> Visit "+a+" (Attended)</option>";
                                           }
      
      
      
      }
 
   }
   else {
   
    visitoptions="<option selected value='"+visitvalue+"'>visit "+visitvalue+" (Not attended)</option>";
 
   }
  
   finaltable="<tr><td style='text-align: left;'> Patients Name :</td><td> <input type='hidden' id='reg' name='reg' value="+patientid+" >"+name+"</td></tr> " 
 +" <tbody> <tr><td  style='text-align: left;'>Age :</td><td><input type='hidden' id='name' name='name' value='"+name+"'><input type='hidden' id='age' name='age' value='"+age+"'>"+age+"</td> </tr>"
 +" <tr><td  style='text-align: left;'>Visit no.:</td><td><select style='height:32px;' onchange='loadspecificvisit(this);' name='Visitno' id='visitno'>"+visitoptions+"</select></td></tr>"
 +" <tr><td style='text-align: left;'>Date of Visit:</td><td><input type='text'  name='date1' style='height:33px;width:240px;' id='date1' required/><button title='clear date field to blank' onclick=\"cleardate();\" class=\"btn btn-default\" type=\"button\">" +
"<i class=\"fa fa-refresh\" ></i></button></td></tr>"
 +"  <tr><th colspan='2' style='text-align: center;'>Finding Section</th></tr>"
 +" <tr><td style='text-align: left;'>Finding :</td><td>  <textarea name='finding' id='finding' required cols='40' rows='4'> </textarea></td>"
 +" </tr><tr><th colspan='2' style='text-align: center;'>Recomendations Section</th></tr>"
 +" <tr><td style='text-align: left;'>Recommendations :</td><td>  <textarea name='recomendation' id='recomendation' required cols='40' rows='4'> </textarea></td></tr>"
 +"<tr><td colspan='2'><input id=\"generate1\" class=\"generate1\" type=\"text\" style=\" cursor:pointer;margin-left: 50px; text-transform:uppercase ; height: 38px; width:140px;text-align:center ; color:white ;background:coral; border-style:ridge ;\" readonly=\"\" onclick=\"saveVisits();\"  value=\"Save\"> <input type='hidden' name='followupid' id='followupid' value=\""+followupid+"\"></td>  </tr></tbody>";     
     
  }
    
    
    
    
    
    try {
      
        out.println(finaltable);
        
    } finally {            
        out.close();
    }
}       catch (SQLException ex) {
            Logger.getLogger(loadvisits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
