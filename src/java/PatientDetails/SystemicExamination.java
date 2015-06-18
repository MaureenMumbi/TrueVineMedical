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
public class SystemicExamination extends HttpServlet {

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
           PrintWriter out = response.getWriter();
          String airentryleft="";
            String airentryright="";
            String ralesleft="";
            String ralesright="";
           String rhonchileft="";
           String rhonchiright="";
           String heartsounds="";
           String murmur="";
           String murmurdescription="";
           String heartsize="";
           String distention="";
           String distentiondescription="";
           String bowelsounds="";
           String mass="";
           String masslocation="";
           String tenderness="";
           String tendernesslocation="";
           String liver="";
           String liversize="";
           String leftkidney="";
           String rightkidney="";
           
           String consciousness="";
           String movements="";
           String movementsdescription="";
           String power="";
           String powerdescription="";
           String tone="";
           String tonedescription="";
           String reflexes="";
           String reflexdescription="";
           String dateRegistered="";
     HttpSession session;
     String PatientID="";
     String Userid="";
          session = request.getSession();
          dbConnect conn = new dbConnect();
        try {
//             if(session.getAttribute("PatientID")!=null){
//                  PatientID= (String) session.getAttribute("PatientID");
//             }
             if(request.getParameter("PatientID")!=null && !request.getParameter("PatientID").equals("")){
                      PatientID=request.getParameter("PatientID") ;
                        session.setAttribute("PatientID",PatientID);
           }
                if(session.getAttribute("username")!=null){
           Userid= (String) session.getAttribute("username");}
          
           if(!request.getParameter("dateRegistered").equals("") && request.getParameter("dateRegistered")!=null){
          dateRegistered=request.getParameter("dateRegistered");
          }
     airentryleft=request.getParameter("airentryleft");
             airentryright=request.getParameter("airentryleft");
             ralesleft=request.getParameter("ralesleft");
             ralesright=request.getParameter("ralesright");
            rhonchileft=request.getParameter("rhonchileft");
            rhonchiright=request.getParameter("rhonchiright");
            heartsounds=request.getParameter("heartsounds");
            murmur=request.getParameter("murmur");
            murmurdescription=request.getParameter("murmurdescription");
            heartsize=request.getParameter("heartsize");
            distention=request.getParameter("distention");
            distentiondescription=request.getParameter("distentiondescription");
            bowelsounds=request.getParameter("bowelsounds");
            mass=request.getParameter("mass");
            masslocation=request.getParameter("masslocation");
            tenderness=request.getParameter("tenderness");
           tendernesslocation=request.getParameter("tendernesslocation");
            liver=request.getParameter("liver");
            liversize=request.getParameter("liversize");
            leftkidney=request.getParameter("leftkidney");
            rightkidney=request.getParameter("rightkidney");
           
            System.out.println(rightkidney+"____"+PatientID);
             consciousness=request.getParameter("consciousness");
            movements=request.getParameter("movements");
            movementsdescription=request.getParameter("movementsdescription");
            power= request.getParameter("power");
            powerdescription= request.getParameter("powerdescription");
            tone =request.getParameter("tone");
            tonedescription=request.getParameter("tonedescription");
            reflexes=request.getParameter("reflexes");
           reflexdescription=request.getParameter("reflexdescription");
                    
             if(!PatientID.equals("") && PatientID!=null){
            String insertrespiratory="insert into respiratory set Patientid=?,dateRegistered=?,AirEntryLeftLung=?,"
                    + "AirEntryRightLung=?,RalesLeft=?,RalesRight=?,"
                    + "RhonchiLeft=?, RhonchiRight=?,userid=?";     
            System.out.println(insertrespiratory) ;    
//            conn.state.executeUpdate(insertrespiratory);
            
            
            conn.ps2=conn.connect.prepareStatement(insertrespiratory);
    
 conn.ps2.setString(1, PatientID);   
 conn.ps2.setString(2, dateRegistered); 
 conn.ps2.setString(3, airentryleft); 
 conn.ps2.setString(4, airentryright); 
 conn.ps2.setString(5, ralesleft); 
 conn.ps2.setString(6 ,ralesright); 
 conn.ps2.setString(7,rhonchileft); 
 conn.ps2.setString(8,rhonchiright);
 conn.ps2.setString(9,Userid); 
 
 conn.ps2.executeUpdate();
            
            String insertcardiovascular="insert into cardiovascular set PatientID=?, "
                    + "heartsounds=?, murmur=?, murmurtype=?,"
                    + "heartsize=?,userid=?";
                             System.out.println(insertcardiovascular) ;    

            conn.ps3=conn.connect.prepareStatement(insertcardiovascular);
    
 conn.ps3.setString(1, PatientID);   
 conn.ps3.setString(2, heartsounds); 
 conn.ps3.setString(3, murmur); 
 conn.ps3.setString(4, murmurdescription); 
 conn.ps3.setString(5 ,heartsize); 
 conn.ps3.setString(6,Userid); 
// conn.ps2.setString(7,rhonchiright);
// conn.ps2.setString(10,Userid); 
// 
 conn.ps3.executeUpdate();
//               conn.state.executeUpdate(insertcardiovascular);  
               
               
               
               String insertabdomen="insert into abdomen set PatientID=?,Distention=?, "
                       + "DistentionType=?, "
                       + "BowelSounds=?, Mass=?, MassLocation=?, Tenderness=?, "
                       + "Tendernesslocation=?, Liver=?, LiverMeasurement=?, "
                       + "LeftKidney=?, RightKidney=?, userid=?";
               
         
            conn.ps=conn.connect.prepareStatement(insertabdomen);
 conn.ps.setString(1, PatientID);    
conn.ps.setString(2, distention); 
 conn.ps.setString(3, distentiondescription); 
 conn.ps.setString(4, bowelsounds); 
 conn.ps.setString(5 ,mass); 
 conn.ps.setString(6,masslocation); 
 conn.ps.setString(7,tenderness); 
 conn.ps.setString(8,tendernesslocation); 
 conn.ps.setString(9,liver); 
 conn.ps.setString(10,liversize); 
 conn.ps.setString(11,leftkidney); 
 conn.ps.setString(12,rightkidney); 
 conn.ps.setString(13,Userid); 
  

 
 conn.ps.executeUpdate();
               
               
               
               
               
               
               
               System.out.println(insertabdomen);
               
               String insertnervous="insert into nervous set PatientID =?, consciousState=?, movements=?,"
                       + " movementdescription=?, power=?, powerdescription=?, tone=?, "
                       + "tonedescription=?, reflexes=?, reflexesdescription=?, userid=?";
              ///conn.state4.executeUpdate(insertnervous);
               System.out.println(insertnervous);
               
               
               
                conn.ps1=conn.connect.prepareStatement(insertnervous);
    
 conn.ps1.setString(1, PatientID);   
 conn.ps1.setString(2, consciousness); 
 conn.ps1.setString(3, movements); 
 conn.ps1.setString(4, movementsdescription); 
 conn.ps1.setString(5 ,power); 
 conn.ps1.setString(6,powerdescription); 
 conn.ps1.setString(7,tone); 
 conn.ps1.setString(8,tonedescription); 
 conn.ps1.setString(9,reflexes); 
 conn.ps1.setString(10,reflexdescription); 
 conn.ps1.setString(11,Userid); 
 
 conn.ps1.executeUpdate();
               
               
               
               
               
               
               
               
               
               
             }
             String index="";
             String  form[]= new String[]{};
             if(session.getAttribute("form")!=null){
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
             response.sendRedirect("viewChildDetails.jsp");}

         else{
              response.sendRedirect(form[indexes]);
         }
         
        session.setAttribute("index",indexes);}
             else{
      response.sendRedirect("investigations.jsp");
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
            Logger.getLogger(SystemicExamination.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SystemicExamination.class.getName()).log(Level.SEVERE, null, ex);
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
