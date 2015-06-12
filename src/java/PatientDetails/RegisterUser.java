/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientDetails;

import DBCONNECT.dbConnect;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;
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
public class RegisterUser extends HttpServlet {

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
      HttpSession session;
    String f_name, m_name, s_name, phoneno, username, password, userid, userlevel,email;
    boolean statuz = false;
    MessageDigest m;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            response.setContentType("text/html;charset=UTF-8");


            session = request.getSession();
            userid = request.getParameter("userid");
            f_name = request.getParameter("fname");
            m_name = request.getParameter("mname");
           

            userlevel = request.getParameter("userlevel");

          
                if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
            username = request.getParameter("username");}
                   if (request.getParameter("password") != null && !request.getParameter("password").equals("")) {
            password = request.getParameter("password");}
System.out.println(f_name+" "+m_name+""+userlevel+" "+username+" "+password);
            
            //encrypt password

//            m = MessageDigest.getInstance("MD5");
//            m.update(password.getBytes(), 0, password.length());
//            String pw = new BigInteger(1, m.digest()).toString(16);
 PatientDetails.decryptor myEncryptor= new PatientDetails.decryptor();
   String stringToEncrypt=password;
        String pw=myEncryptor.encrypt(stringToEncrypt);
        String decrypted=myEncryptor.decrypt(pw);
            dbConnect conn = new dbConnect();
            
            
//save details to clerk table
//String save="insert into clerks(clerk_id, first_name,sur_name, phone) "
//+ "values ('"+userid+"','"+f_name+"','"+s_name+"','"+phoneno+"')";
//                        
//                            
//String save="insert into users( username,fname,mname, phone) "
//                                    + "values ('"+userid+"','"+f_name+"','"+s_name+"','"+phoneno+"')";
//                        

            String save = "insert into users (userid,username,fname,mname,password,userlevel,active) "
                    + "values ('"+userid+"','" + username + "','" + f_name + "','" + m_name + "','" + pw + "','" + userlevel + "','Yes')";
System.out.println(save);

            //save details to the usewrs table
//                                String add_to_users="insert into users(userid,password,username,level) "
//                                    + "values ('"+userid+"','"+pw+"','"+username+"','"+userlevel+"')";
//                        

            String checker = "select * from users where username='" + username + "'";



            conn.rs = conn.state.executeQuery(checker);

            //check if username is already used 
            if (!conn.rs.next()) {


                conn.state1.executeUpdate(save);

                //add top users table
                // conn.st.executeUpdate(add_to_users);  



                session.setAttribute("useradded", "<font color=\"green\">User added succesfully</font>");
            } else {
                session.setAttribute("useradded", "<b><font color=\"red\">Sorry, That username is already used.Use a different one</font></b>");


            }
            response.sendRedirect("registerUser.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public int generateRandomNumber(int start, int end) {
        Random random = new Random();
        long fraction = (long) ((end - start + 1) * random.nextDouble());
        return ((int) (fraction + start));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
