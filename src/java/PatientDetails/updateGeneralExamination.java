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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maureen
 */
public class updateGeneralExamination extends HttpServlet {

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
        String birthplace="";
         String hospitalname="";
         String deliverymode="";
         String birthweight="";
         String birthno="";
         String siblingdeath="";
         String deathcause="";
         String deathage="";
         String newcomplaint="";
         String newduration="";
         String problem="";
         String hospitalized="";
         String DateHopitalized="";
         String HospitalAdmitted="";
         String Diagnosis="";
      String Userid="";
               String PatientID="";
               HttpSession session;
               int rowcount;
               String complaint="";
               String duration=""; 
               String presentcomplaintid="";
               String nutritionalstatus="";
               String generalcondition="";
               String Dyspnea="";
               String Tachypnea="";
               String Dehydration="";
               String Temperature="";
               String Jaundice="";
               String lymphnodes="";
               String lymphnodelocation="";
               String pittinglegoedema="";
               String faceoedema="";
               String rashes="";
               String rashesdescription="";
               String rasheslocation="";
               
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        rowcount=Integer.parseInt(request.getParameter("rowcount"));
//        System.out.println("rowcount"+rowcount);
        rowcount=16;
          session = request.getSession();
          dbConnect conn = new dbConnect();
        try {
             if(session.getAttribute("PatientID")!=null){
                  PatientID= (String) session.getAttribute("PatientID");
             }
                if(session.getAttribute("username")!=null){
           Userid= (String) session.getAttribute("username");}
         
         if(!PatientID.equals("") && PatientID!=null){
         birthplace=request.getParameter("birthplace");
         hospitalname=request.getParameter("hospitalname");
         deliverymode=request.getParameter("deliverymode");
         birthweight = request.getParameter("birthweight");
         birthno= request.getParameter("birthno");
         siblingdeath= request.getParameter("siblingdeath");
         deathcause= request.getParameter("cause");
         deathage= request.getParameter("age");
         
         problem= request.getParameter("problem");
         hospitalized= request.getParameter("hospitalized");
         DateHopitalized= request.getParameter("DateHospitalized");
         HospitalAdmitted= request.getParameter("HospitalAdmitted");
         Diagnosis= request.getParameter("Diagnosis");
          
         
         
              nutritionalstatus=request.getParameter("nutritionalstatus");;
                generalcondition=request.getParameter("generalcondition");;
                Dyspnea=request.getParameter("Dyspnea");;
                Tachypnea=request.getParameter("Tachypnea");;
                Dehydration=request.getParameter("dehydration");;
                Temperature=request.getParameter("Temperature");;
                Jaundice=request.getParameter("Jaundice");;
                lymphnodes=request.getParameter("lymphnodes");;
                lymphnodelocation=request.getParameter("lymphnodelocation");;
                pittinglegoedema=request.getParameter("pittinglegoedema");;
                faceoedema=request.getParameter("faceoedema");;
                rashes=request.getParameter("rashes");;
                rashesdescription=request.getParameter("rashesdescription");;
                rasheslocation=request.getParameter("rasheslocation");;
         }
         if(!PatientID.equals("") && PatientID!=null){
        
         String inserthistory="update childbirthhistory set BirthPlace=?,HospitalName=?,DeliveryMode=?,"
                 + "BirthWeight=?,BirthNo=?,SiblingDeath=?,DeathCause=?, DeathAge=? where PatientID=?";
         
         
          //conn.state1.executeUpdate(inserthistory);
         
            conn.ps=conn.connect.prepareStatement(inserthistory);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
  
 conn.ps.setString(1, birthplace); 
 conn.ps.setString(2, hospitalname); 
 conn.ps.setString(3, deliverymode); 
 conn.ps.setString(4 ,birthweight); 
 conn.ps.setString(5,birthno); 
 conn.ps.setString(6,siblingdeath); 
 conn.ps.setString(7,deathcause); 
 conn.ps.setString(8,deathage); 
 conn.ps.setString(9, PatientID); 
 
 conn.ps.executeUpdate();
          System.out.println(inserthistory);
          
          
          String insertpasthistory="update pastmedicalhistory set longstandingproblems=?, hospitalized =?, "
                  + "datehospitalized=?, hospital=?,diagnosis=? where  PatientID=?";
          
           System.out.println(insertpasthistory);
         
          // conn.state2.executeUpdate(insertpasthistory);
           
            conn.ps1=conn.connect.prepareStatement(insertpasthistory);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 
 conn.ps1.setString(1, problem); 
 conn.ps1.setString(2, hospitalized); 
 conn.ps1.setString(3, DateHopitalized); 
 conn.ps1.setString(4 ,HospitalAdmitted); 
 conn.ps1.setString(5, Diagnosis); 
 conn.ps1.setString(6, PatientID);  

 
 conn.ps1.executeUpdate();
           
                  
         for(int i=1;i<=rowcount;i++){
      
         presentcomplaintid= request.getParameter("presentcomplaintid"+i);
          complaint= request.getParameter("complaints"+i);
         duration= request.getParameter("duration"+i);
         
          newcomplaint= request.getParameter("newcomplaints"+i);
         newduration= request.getParameter("newduration"+i);
           System.out.println("complaint"+complaint);
         System.out.println("duration"+duration);
          if(complaint!=null && !complaint.equals("")){
           String insertPresentComplaint =" update presentcomplaints set Complaint=?,duration=? where PatientID=? and PresentcomplaintsID=?"  ;
//              conn.state2.executeUpdate(insertPresentComplaint);
          System.out.println(insertPresentComplaint);
             conn.ps1=conn.connect.prepareStatement(insertPresentComplaint);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
  
 conn.ps1.setString(1, complaint); 
 conn.ps1.setString(2, duration); 
  conn.ps1.setString(3, PatientID); 
 conn.ps1.setString(4, presentcomplaintid); 
 
 
 conn.ps1.executeUpdate();
          }
          if(newcomplaint!=null && !newcomplaint.equals("")){
       String insertnew=" insert into presentcomplaints set Complaint=?,duration=?,PatientID=?";
//              conn.state2.executeUpdate(insertPresentComplaint);
          System.out.println(insertnew);
             conn.ps2=conn.connect.prepareStatement(insertnew);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
  
 conn.ps2.setString(1, newcomplaint); 
 conn.ps2.setString(2, newduration); 
  conn.ps2.setString(3, PatientID); 

 
 
 conn.ps2.executeUpdate();      
         }
         }
           
           String insertFindings="update examinationfindings set  Nutritionalstatus=?,"
                   + "Generalcondition=? ,dyspnea=?, tachypnea=?,dehydration=?,"
                   + "temperature=?, jaundice=?,Lymphnodes=?,Lymphnodeslocation=?,"
                   + "faceoedema=? ,legoedema=?,rashes=?,rashtype=?,rashlocation=? where PatientID =?";
           
            System.out.println(insertFindings);
         
//           conn.state3.executeUpdate(insertFindings);
            conn.ps2=conn.connect.prepareStatement(insertFindings);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 
 conn.ps2.setString(1, nutritionalstatus); 
 conn.ps2.setString(2, generalcondition); 
 conn.ps2.setString(3, Dyspnea); 
 conn.ps2.setString(4 ,Tachypnea); 
 conn.ps2.setString(5,Dehydration); 
 conn.ps2.setString(6,Temperature); 
 conn.ps2.setString(7,Jaundice); 
 conn.ps2.setString(8,lymphnodes); 
 conn.ps2.setString(9,lymphnodelocation); 
 conn.ps2.setString(10,faceoedema); 
 conn.ps2.setString(11,pittinglegoedema); 
 conn.ps2.setString(12,rashes); 
 conn.ps2.setString(13,rashesdescription); 
 conn.ps2.setString(14,rasheslocation); 
 conn.ps2.setString(15, PatientID);  
 
 conn.ps2.executeUpdate();
         
           
           
           
           
           
        }
         
          String index="";

            String  form[]= new String[]{};
            form=(String[]) session.getAttribute("form");

         int indexes=0;
         session = request.getSession();
         if(session.getAttribute("index")!=null){
       index=session.getAttribute("index").toString();
       
       indexes=Integer.parseInt(index)+1;
         }
      System.out.println("length"+form.length);
      System.out.println("lengths"+indexes);
         if(Integer.parseInt(index)==form.length-1){   
             response.sendRedirect("manageforms.jsp");}

         else{
              response.sendRedirect(form[indexes]);
         }
         
        session.setAttribute("index",indexes);
//        response.sendRedirect("systemicexamination.jsp");
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
            Logger.getLogger(generalexamination.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(generalexamination.class.getName()).log(Level.SEVERE, null, ex);
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
