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
 * @author MANUEL
 */
public class saveEditedInvestigations extends HttpServlet {

   
    
    HttpSession session=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        try {
    response.setContentType("text/html;charset=UTF-8");
    
    session=request.getSession();
    
    
    String patientid=request.getParameter("patientid");
    String urinalysis=request.getParameter("urinalysis");
    String date=request.getParameter("invdate");
    String stoolmic=request.getParameter("stoolmic");
    String stoolpylori=request.getParameter("stoolpylori");
    String malariaparasite=request.getParameter("malariaparasite");
    String rbs=request.getParameter("rbs");
    String wbccount=request.getParameter("wbccount");
    String differential=request.getParameter("differential");
    String hb=request.getParameter("hb");
    String peripheralfilm=request.getParameter("peripheralfilm");
    String inclusions=request.getParameter("inclusions");
    String incdesc="";
    if(request.getParameter("incdesc")!=null){
        
    incdesc=request.getParameter("incdesc");
    
                                             }
String lft=request.getParameter("lft");
String urea=request.getParameter("urea");
String thyroid=request.getParameter("thyroid");
String ctr=request.getParameter("ctr");
String xray=request.getParameter("xray");
String ultrasound=request.getParameter("ultrasound");
String ctscanbrain=request.getParameter("ctscanbrain");
String ctscanother=request.getParameter("ctscanother");
String mri=request.getParameter("mri");


//??????????????????????????????????????????????????????????????????????????
//??????????????????????????????????????????????????????????????????????????

 String userid="";  
 if(session.getAttribute("userid")!=null){ 
 userid=session.getAttribute("userid").toString();
 }
 
 //??????????????????????????????????????????????????????????????????????????
//??????????????????????????????????????????????????????????????????????????
    
    
    dbConnect conn= new dbConnect();
    
   // Investigations,patientID,urinalysis,stoolmicroscopy,stoolHPylori,malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,LFTs,UreaNelectrolytes,ThyroidProfile,CXR,OtherXray,ultrasound,ctscanbrain,ctscanother,MRI,userid,timestamp

    //have a session containing the patientid
    
    String invinsert="insert into investigations (patientID,urinalysis,stoolmicroscopy,stoolHPylori,malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,inclusiondesc,LFTs,UreaNelectrolytes,ThyroidProfile,CXR,OtherXray,ultrasound,ctscanbrain,ctscanother,MRI,userid,date)"
            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    
conn.ps1=conn.connect.prepareStatement(invinsert);
    
    //patientID,urinalysis,stoolmicroscopy,stoolHPylori,
//malaria,RBS,HTotalWBCCount,HDifferential,HHb,HPeripheral,HInclusions,
 conn.ps1.setString(1, patientid);   
 conn.ps1.setString(2, urinalysis); 
 conn.ps1.setString(3, stoolmic); 
 conn.ps1.setString(4, stoolpylori); 
 conn.ps1.setString(5 ,malariaparasite); 
 conn.ps1.setString(6,rbs); 
 conn.ps1.setString(7,wbccount); 
 conn.ps1.setString(8,differential); 
 conn.ps1.setString(9,hb); 
 conn.ps1.setString(10,peripheralfilm); 
 conn.ps1.setString(11,inclusions); 
 conn.ps1.setString(12,incdesc); 
 conn.ps1.setString(13,lft); 
 conn.ps1.setString(14,urea); 
 conn.ps1.setString(15,thyroid); 
 conn.ps1.setString(16,ctr); 
 conn.ps1.setString(17,xray); 
 conn.ps1.setString(18,ultrasound); 
 conn.ps1.setString(19,ctscanbrain); 
 conn.ps1.setString(20,ctscanother); 
 conn.ps1.setString(21,mri); 
 conn.ps1.setString(22,userid); 
 conn.ps1.setString(23,date); 
 
 conn.ps1.executeUpdate();
 //OtherXray,ultrasound,ctscanbrain,ctscanother,MRI,userid
 //LFTs,UreaNelectrolytes,ThyroidProfile,CXR,

 
    PrintWriter out = response.getWriter();
    
    
   // response.sendRedirect("viewChildDetails.jsp");
    
    
    session.setAttribute("datasaved","investigations data saved succesfully");
      String index="";
      
      String  form[]= new String[]{};
            form=(String[]) session.getAttribute("form");

     int indexes=0;
       
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
    
    
    try {
        
    } finally {            
        out.close();
    }
}       catch (SQLException ex) {
            Logger.getLogger(saveinvestigations.class.getName()).log(Level.SEVERE, null, ex);
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
