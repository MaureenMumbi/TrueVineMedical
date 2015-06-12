package DBCONNECT;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class dbConnect {

    public Connection connect;
    public Statement state, state1, state2, state3, state4, state5, state6, state7, state_1, state_2;
    public ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs_1, rs_2;
    public ResultSetMetaData rsmd;
    public String query, query1;
    public PreparedStatement ps, ps1, ps2, ps3;
    public  String dbconnectsetup[] = new String[4];
    String mycurrdrive = "";
    public static int iscalldbjspcalled_wrongpword=2;
    public static int iscalldbjspcalled_wronghost=2;
    public static int iscalldbjspcalled_filenotexist=2;
 

    public dbConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            
             URL location = dbConnect.class.getProtectionDomain().getCodeSource().getLocation();
        
            
            mycurrdrive =location.getFile().substring(1, 2);
            //if file exists, go ahead and check if passowrd exists.
              if(getdbconnsettings(mycurrdrive)==true){
            

            
            if (dbconnectsetup[0]!=null) {
                
                if(dbconnectsetup[3]==null){
                connect = DriverManager.getConnection("jdbc:mysql://" + dbconnectsetup[0] + "/" + dbconnectsetup[1], dbconnectsetup[2], "");
                
                }
                else{
                

                connect = DriverManager.getConnection("jdbc:mysql://" + dbconnectsetup[0] + "/" + dbconnectsetup[1], dbconnectsetup[2],dbconnectsetup[3]);
                }
               // System.out.println("" + dbconnectsetup[0]);

            } else {

                if(iscalldbjspcalled_wronghost%2==0){
               calldbjsp1();
               iscalldbjspcalled_wronghost++;
                }
                else{
                 iscalldbjspcalled_wronghost++;
                }
            }
          
            
    iscalldbjspcalled_wrongpword=2;
    iscalldbjspcalled_wronghost=2;
    iscalldbjspcalled_filenotexist=2;
            
            state = (Statement) connect.createStatement();
            state1 = (Statement) connect.createStatement();
            state2 = (Statement) connect.createStatement();
            state3 = (Statement) connect.createStatement();
            state4 = (Statement) connect.createStatement();
            state5 = (Statement) connect.createStatement();
            state6 = (Statement) connect.createStatement();
            state7 = (Statement) connect.createStatement();
            state_1 = (Statement) connect.createStatement();
            state_2 = (Statement) connect.createStatement();

              }//end of if
              
              
              
              
              
        } catch (Exception e) {
            if(iscalldbjspcalled_wrongpword%2==0){
                
             calldbjsp1() ;
             iscalldbjspcalled_wrongpword++;
            }
            else{
            
                iscalldbjspcalled_wrongpword++;
            }
            
            System.out.println("ERROR WHILE CONNECTING TO DATABASE. CHECK YOUR CONNECTION CREDENTIALS SETTINGS in dbConnect.java");
        }
    }//end of dbconnect

      public final boolean getdbconnsettings(String drive) {
        boolean worked = true;

        try {



            String dbconnpath = drive + ":/TrueVineMedical/DBCONNECTION/DO_NOT_DELETE/_/_/./dbconnection.txt";
          // System.out.println(dbconnpath);

            //File file = new File("");
            // InputStream inStream = getClass().getResourceAsStream("Web-INF/classes/dbconnection.txt");  
            FileInputStream fstream = new FileInputStream(dbconnpath);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String stLine;
            //Read File Line By Line
            int count = 0;
            while ((stLine = br.readLine()) != null) {

                // Print the content on the console


                dbconnectsetup[count] = stLine;

              //  System.out.println("dbconnect=" + dbconnectsetup[count] + "  Count:" + count);
                if (count < 4) {
                    count++;
                }
            }
            //Close the input stream
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            // if the file was not found, the call db.jsp which creates another jsp file
        
            if(iscalldbjspcalled_filenotexist%2==0)
            {            
     calldbjsp1();
     iscalldbjspcalled_filenotexist++;
            }
            else{
            iscalldbjspcalled_filenotexist++;
            
            }
            
            
            worked = false;

        }

        return worked;

    }

  public void calldbjsp1() {
        try {
            String url = "http://localhost:8080/TrueVineMedical/db.jsp";
             java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                   
                   //getdbsettings("M");
        } catch (IOException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
