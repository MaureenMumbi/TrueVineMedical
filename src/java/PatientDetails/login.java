/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.IOException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class login extends HttpServlet {

    String uname, pass, error_login, nextPage, current_time;
    String computername;
    MessageDigest m;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException, Exception {


        dbConnect conn = new dbConnect();

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        String yr, mnth, dater, hr, mn, sc, action = "";
        yr = Integer.toString(year);
        mnth = Integer.toString(month);
        dater = Integer.toString(date);
        hr = Integer.toString(hour);
        mn = Integer.toString(min);
        sc = Integer.toString(sec);
        session = request.getSession();

//____________________COMPUTER NAME____________________________________
        computername = InetAddress.getLocalHost().getHostName();
        System.out.println("Computer name " + computername);
        session.setAttribute("computer_name", computername);





//current_time=sc+"-"+mn+"-"+hr+"-"+dater+"-"+mnth+"-"+yr;

//current_time=yr+"-"+mnth+"-"+dater+"-"+hr+":"+mn+":"+sc;

        current_time = yr + "-" + mnth + "-" + dater + "-" + hr + ":" + mn + ":" + sc;
        //get username and password

        uname = request.getParameter("username");

        pass = request.getParameter("password");






        //encrypt password

      decryptor myEncryptor= new decryptor();
   String stringToEncrypt=pass;
        String pw=myEncryptor.encrypt(stringToEncrypt);
        String decrypted=myEncryptor.decrypt(pw);
System.out.println(uname+"_"+pw);

        //connection to database class instance


        //query for checking user existance in the database
      

String trialdate="";
String key="";
String dateToday="";
String status="";
Date mydate;

    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        mydate = new Date();
       dateToday = formatter.format(mydate);

//System.out.println("worked up to here 1;");


  String select1 = "select * from users where active='yes'";
        conn.rs = conn.state.executeQuery(select1);

        // System.out.println("username:"+uname+"  Password :"+pw );


        while (conn.rs.next()) {
            if (conn.rs.getString("username").equals(uname) && conn.rs.getString("password").equals(pw)) {

                error_login = null;
                if (conn.rs.getString("userlevel").equals("Clinician")) {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                      System.out.println("level:"+conn.rs.getString("userlevel"));
//                    String inserter = "insert into audit set host_comp='" + computername + " " + ip + "' , action='Logged in ',time='" + current_time + "',actor_id='" + conn.rs.getString("userid") + "'";
//
//                    //String inserter="insert into audit  (action,time,actor_id,host_comp) values ('"++"','"+"')";
//
//                    conn.state3.executeUpdate(inserter);
                    //the next page to be opened based on user level
                    nextPage = "maindashboard.jsp";

                  error_login=null;
//String fulname=""+conn.rs.getString("firstname") + " "+conn.rs.getString("lastname");
//audit="Insert into audit (Action,User) values('Logged in','"+fulname+"')";



                    //save current user details into a session

                   
                    session.setAttribute("fname", conn.rs.getString("fname"));
                    session.setAttribute("lname", conn.rs.getString("mname"));
                    session.setAttribute("level", conn.rs.getString("userlevel"));
                    session.setAttribute("userid", conn.rs.getString("userid"));
                    session.setAttribute("username", conn.rs.getString("username"));
                   

                    System.out.println( session.getAttribute("fname")+" __"+session.getAttribute("lname"));
                    
                    //get teacher details from the teacher registration table 


                    /** code for auditing  */
                    // conn.st.executeUpdate(audit);
                    break;
                }//end of admin level
                //****************************Clerk module**********************************************        
             
                if (conn.rs.getString("userlevel").equals("Receptionist")) {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                      System.out.println("level:"+conn.rs.getString("userlevel"));
//                    String inserter = "insert into audit set host_comp='" + computername + " " + ip + "' , action='Logged in ',time='" + current_time + "',actor_id='" + conn.rs.getString("userid") + "'";
//
//                    //String inserter="insert into audit  (action,time,actor_id,host_comp) values ('"++"','"+"')";
//
//                    conn.state3.executeUpdate(inserter);
                    //the next page to be opened based on user level
                    nextPage = "maindashboard.jsp";

                  error_login=null;                    //save current user details into a session

                   
                    session.setAttribute("fname", conn.rs.getString("fname"));
                    session.setAttribute("lname", conn.rs.getString("mname"));
                    session.setAttribute("level", conn.rs.getString("userlevel"));
                    session.setAttribute("userid", conn.rs.getString("userid"));
                    session.setAttribute("username", conn.rs.getString("username"));
                   

                    System.out.println( session.getAttribute("fname")+" __"+session.getAttribute("lname"));
                   
                    break;
                }
                
                if (conn.rs.getString("userlevel").equals("3")) {
                    String ip = InetAddress.getLocalHost().getHostAddress();
                      System.out.println("level:"+conn.rs.getString("userlevel"));
//                    String inserter = "insert into audit set host_comp='" + computername + " " + ip + "' , action='Logged in ',time='" + current_time + "',actor_id='" + conn.rs.getString("userid") + "'";
//
//                    //String inserter="insert into audit  (action,time,actor_id,host_comp) values ('"++"','"+"')";
//
//                    conn.state3.executeUpdate(inserter);
                    //the next page to be opened based on user level
                    nextPage = "orders.jsp";

                  error_login=null;                    //save current user details into a session

                   
                    session.setAttribute("fname", conn.rs.getString("fname"));
                    session.setAttribute("lname", conn.rs.getString("mname"));
                    session.setAttribute("level", conn.rs.getString("userlevel"));
                    session.setAttribute("userid", conn.rs.getString("userid"));
                    session.setAttribute("username", conn.rs.getString("username"));
                   

                    System.out.println( session.getAttribute("fname")+" __"+session.getAttribute("lname"));
                   
                    break;
                }
                else {

                    nextPage = "index.jsp";

                    System.out.println("third level");

                    error_login = "<b><font color=\"red\">ooops! wrong username and / or password combination</font></b>";

                }








            }//end of first if
            else {

                //System.out.println("worked up to here 6;");

                nextPage = "index.jsp";

                error_login = "<b><font color=\"red\">wrong username and or password</font></b>";

                System.out.println(">>" + nextPage);

            }



        }

System.out.println(nextPage);
if(conn.connect!=null){conn.connect.close();}
if(conn.rs!=null){conn.rs.close();}
if(conn.state!=null){conn.state.close();}

        session.setAttribute("error_login", error_login);
        response.sendRedirect(nextPage);


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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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