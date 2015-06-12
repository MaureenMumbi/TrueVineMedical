package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import DBCONNECT.dbConnect;
import java.util.ArrayList;

public final class ViewNextPatient_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  dbConnect conn =  new dbConnect();
  
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/menu/minimenu.html");
    _jspx_dependants.add("/menu/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Truevine Medical System</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"sbfiles/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- MetisMenu CSS -->\n");
      out.write("    <link href=\"sbfiles/css/plugins/metisMenu/metisMenu.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Timeline CSS -->\n");
      out.write("    <link href=\"sbfiles/css/plugins/timeline.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"sbfiles/css/sb-admin-2.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Morris Charts CSS -->\n");
      out.write("    <link href=\"sbfiles/css/plugins/morris.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"sbfiles/font-awesome-4.1.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    \n");
      out.write("        <script src=\"scripts/jquery-1.4.4.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"scripts/jquery.dataTables.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"scripts/jquery.jeditable.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!--<script src=\"media/js/jquery-ui.js\" type=\"text/javascript\"></script>-->\n");
      out.write("<!--   <script src=\"media/js/jquery.validate.js\" type=\"text/javascript\"></script>-->\n");
      out.write("<script src=\"scripts/jquery-ui.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"scripts/jquery.dataTables.editable.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"scripts/jquery.validate.js\" type=\"text/javascript\"></script>\n");
      out.write("<link href=\"media/dataTables/demo_page.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"media/dataTables/demo_table.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"media/dataTables/demo_table_jui.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"media/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <link href=\"media/themes/smoothness/jquery-ui-1.7.2.custom.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\t$(document).ready( function () {\n");
      out.write("\t\t\t\t$('#example').dataTable().makeEditable({\n");
      out.write("                                  \n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("                                                                        sUpdateURL: \"UpdateKnowledge\",\n");
      out.write("                                                                        sAddURL: \"AddKnowledgeCode\",\n");
      out.write("                                                                        sDeleteURL: \"DeleteKnowledgeCode\",\n");
      out.write("                    \t\t\t\t\t\t\t\"aoColumns\": [ null,                  \t\t\t\t\t\t\t\t\t\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\n");
      out.write("                    \t\t\t\t\t\t\t\t\t{\n");
      out.write("                \t\t\t\t\t\t\t\t\t        event: 'mouseover',\n");
      out.write("                                                                                                indicator: 'Saving...',\n");
      out.write("                                                            \t\t\t\t\ttooltip: 'Click to edit ',\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttype: 'textarea',\n");
      out.write("                                                 \t\t\t\t\t\tsubmit:'Save changes',\n");
      out.write("                                                                                                callback : function(value, settings)\n");
      out.write("                                                                                                                        { \n");
      out.write("                                                                                                                            alert(value);\n");
      out.write("                                                                                                                            window.location.reload();\n");
      out.write("                                                                                                                        \n");
      out.write("                                                                                                                        },\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tfnOnCellUpdated: function(sStatus, sValue, row, column, settings){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\talert(\"(Cell Callback): Cell[\"+row+\",\"+column+\"] is updated with value \" + sValue);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\n");
      out.write("                    \t\t\t\t\t\t\t\t\t},\n");
      out.write("                    \t\t\t\t\t\t\t\t\t{\n");
      out.write("                \t\t\t\t\t\t\t\t\t        event: 'mouseover',\n");
      out.write("                                                                                                indicator: 'Saving ...',\n");
      out.write("                                                            \t\t\t\t\ttooltip: 'Click to edit ',\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\ttype: 'textarea',\n");
      out.write("                                                 \t\t\t\t\t\tsubmit:'Save changes',\n");
      out.write("                                                                                                callback : function(value, settings)\n");
      out.write("                                                                                                                        { \n");
      out.write("                                                                                                                            alert(value);\n");
      out.write("                                                                                                                            window.location.reload();\n");
      out.write("                                                                                                                        \n");
      out.write("                                                                                                                        },\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tfnOnCellUpdated: function(sStatus, sValue, row, column, settings){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\talert(\"(Cell Callback): Cell[\"+row+\",\"+column+\"] is updated with value \" + sValue);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\n");
      out.write("                    \t\t\t\t\t\t\t\t\t}\n");
      out.write("//                    \t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t]\t\t\t\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t} );\n");
      out.write("\t\t</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("  var _gaq = _gaq || [];\n");
      out.write("  _gaq.push(['_setAccount', 'UA-17838786-2']);\n");
      out.write("  _gaq.push(['_trackPageview']);\n");
      out.write("\n");
      out.write("  \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    \n");
      out.write(" \n");
      out.write("\n");
      out.write("            function opennewpage(ur){\n");
      out.write("            \n");
      out.write("        var pg=ur.value;\n");
      out.write("        \n");
      out.write("        if(pg!==\"\"){\n");
      out.write("            \n");
      out.write("            window.open(pg)\n");
      out.write("        }\n");
      out.write("                             \n");
      out.write("                \n");
      out.write("                    \n");
      out.write("            \n");
      out.write("            }\n");
      out.write("  \n");
      out.write("  </script>\n");
      out.write("  <script type=\"text/javascript\" src=\"js/noty/jquery.noty.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/noty/layouts/top.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/noty/layouts/center.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/noty/themes/default.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                \n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\">Truevine ChildHealth Centre System</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-header -->\n");
      out.write("                    ");
      out.write("<!--\r\n");
      out.write("To change this template, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("      \r\n");
      out.write("            <ul class=\"nav navbar-top-links navbar-right\">\r\n");
      out.write("\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("                        <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-user\">\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Settings</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"divider\"></li>\r\n");
      out.write("                        <li><a href=\"logout.jsp\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <!-- /.dropdown-user -->\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- /.dropdown -->\r\n");
      out.write("            </ul>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("            <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("                <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                   ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 if (session.getAttribute("level")!=null){
            if(session.getAttribute("level").toString().equals("Clinician")){
                
      out.write("\n");
      out.write("                \n");
      out.write("                 <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("<!--                        <li class=\"sidebar-search\">\n");
      out.write("                            <div class=\"input-group custom-search-form\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("                                <span class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </span>\n");
      out.write("                            </div>\n");
      out.write("                             /input-group \n");
      out.write("                        </li>-->\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"active\" href=\"index.html\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"childdetails.jsp\"><i class=\"fa fa-stethoscope fa-fw\"></i> Child Basic Details</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"financialtransaction.jsp\"><i class=\"fa fa-dollar fa-fw\"></i> Financial Transactions</a>\n");
      out.write("                        </li>\n");
      out.write("                       \n");
      out.write("                    </ul>  \n");
      out.write("                \n");
      out.write("      ");
  }else if(session.getAttribute("level").toString().equals("Receptionist")){
      out.write("\n");
      out.write("        <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("<!--                        <li class=\"sidebar-search\">\n");
      out.write("                            <div class=\"input-group custom-search-form\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("                                <span class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </span>\n");
      out.write("                            </div>\n");
      out.write("                             /input-group \n");
      out.write("                        </li>-->\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"active\" href=\"index.html\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"childdetails.jsp\"><i class=\"fa fa-stethoscope fa-fw\"></i> Child Basic Details</a>\n");
      out.write("                        </li>\n");
      out.write("                       \n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-files-o fa-fw\"></i> Reports</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-calendar fa-fw\"></i> Bookings</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"viewChildDetails.jsp\"><i class=\"fa fa-book fa-fw\"></i> Next Patient</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"manageforms.jsp\"><i class=\"fa fa-book fa-fw\"></i> Manage Patients</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("       ");
 }}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /.sidebar-collapse -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-static-side -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <h1 class=\"page-header\">VIEW CHILDREN</h1>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col-lg-12 -->\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("             ");
if (session.getAttribute("patientadded") != null) { 
      out.write("\n");
      out.write("                                <script type=\"text/javascript\"> \n");
      out.write("                    \n");
      out.write("                    var n = noty({text: '");
      out.print(session.getAttribute("patientadded"));
      out.write("',\n");
      out.write("                        layout: 'center',\n");
      out.write("                        type: 'Success',\n");
      out.write(" \n");
      out.write("                         timeout: 4800});\n");
      out.write("                    \n");
      out.write("                </script> ");

                session.removeAttribute("patientadded");
                            }

                        
      out.write(" \n");
      out.write("              <table id=\"example\" class=\"display\">\n");
      out.write("\t\t            <thead>\n");
      out.write("\t\t            <tr>\n");
      out.write("\t\t           <th>FIRST NAME</th>\n");
      out.write("                           <th>MIDDLE NAME</th>\n");
      out.write("                           <th> LAST NAME </th>\n");
      out.write("                           <th> REGNO </th>\n");
      out.write("                           <th> AGE </th>\n");
      out.write("                           <th> SECTION </th>\n");
      out.write("                            </tr>\n");
      out.write("\t\t                \n");
      out.write("\t\t            </thead>\n");
      out.write("\t\t            <tbody>\n");
      out.write("                                \n");
      out.write("                         ");
 
                         Date date= new Date(); 
SimpleDateFormat formatter= new SimpleDateFormat("YYYY-MM-dd");
String formattedDate = formatter.format(date);
                         String getTodaysPatient="select * from todayspatient where timestamp='"+formattedDate+"' ";
                         conn.rs2 = conn.state.executeQuery(getTodaysPatient);
                         while(conn.rs2.next()){
                         String query = "select * from basicdetails WHERE patientID='"+conn.rs2.getString("PatientID")+"'";
                                     conn.rs = conn.state.executeQuery(query); 

                                        while(conn.rs.next())
                                        {
                                     String child= conn.rs.getString("FName")+" "+conn.rs.getString("SName")+" "+ conn.rs.getString("LName");
                                         System.out.println("aaa"+child);
                                            
                                         
      out.write("       \n");
      out.write("                        \n");
      out.write("\n");
      out.write("                           <tr id=\"");
      out.print( conn.rs.getString("RegNo"));
      out.write("\">\n");
      out.write("                                    <td> ");
      out.print( conn.rs.getString("FName"));
      out.write(" </td>\n");
      out.write("                                    <td>");
      out.print( conn.rs.getString("SName"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( conn.rs.getString("LName"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( conn.rs.getString("RegNo"));
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( conn.rs.getString("Age"));
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                  <select  onchange=\"opennewpage(this);\"  id=\"pages\">\n");
      out.write("                                            <option value=\"\">Select Page</option>\n");
      out.write("              <option value=\"NextPatient.jsp?PatientID=");
      out.print(conn.rs.getString("PatientID"));
      out.write("&Name=");
      out.print(child);
      out.write("\">Revisit Details</option>\n");
      out.write("              <option value=\"financialtransaction.jsp?PatientID=");
      out.print(conn.rs.getString("PatientID"));
      out.write("\">Financial Transaction</option>\n");
      out.write("              <option value=\"generalexamination.jsp?PatientID=");
      out.print(conn.rs.getString("PatientID"));
      out.write("\">General Examination</option>\n");
      out.write("              <option value=\"systemicexamination.jsp?PatientID=");
      out.print(conn.rs.getString("PatientID"));
      out.write("\">Systemic Examination</option>\n");
      out.write("              <option value=\"investigations.jsp?regNo=");
      out.print(conn.rs.getString(1));
      out.write("\">Investigations</option>\n");
      out.write("              <!--<option value=\"visits.jsp?regNo=");
      out.print(conn.rs.getString(1));
      out.write("\">Visits</option>-->\n");
      out.write("              <option value=\"visits.jsp?name=");
      out.print(child);
      out.write("&age=");
      out.print(conn.rs.getString("age"));
      out.write("&regNo=");
      out.print(conn.rs.getString("PatientID"));
      out.write("\">Follow ups and revisits</option>\n");
      out.write("             <option value=\"treatment.jsp?name=");
      out.print(child);
      out.write("&age=");
      out.print(conn.rs.getString("age"));
      out.write("&regNo=");
      out.print(conn.rs.getString("PatientID"));
      out.write("\">Treatment</option>\n");
      out.write("             <option value=\"Disposal.jsp?name=");
      out.print(child);
      out.write("&regNo=");
      out.print(conn.rs.getString("PatientID"));
      out.write("\">Disposal</option>\n");
      out.write("              \n");
      out.write("                                        </select></td>\n");
      out.write("                                    \n");
      out.write("                            </tr>\n");
      out.write("                                      ");

                                                      }                    }

      out.write("\n");
      out.write("                                \n");
      out.write("\t\t            </tbody>\n");
      out.write("\t\t        </table>\n");
      out.write(" \n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("    </div>\n");
      out.write("    <!-- jQuery Version 1.11.0 -->\n");
      out.write("    <!--<script src=\"sbfiles/js/jquery-1.11.0.js\"></script>-->\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"sbfiles/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Metis Menu Plugin JavaScript -->\n");
      out.write("    <script src=\"sbfiles/js/plugins/metisMenu/metisMenu.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Morris Charts JavaScript -->\n");
      out.write("    <script src=\"sbfiles/js/plugins/morris/raphael.min.js\"></script>\n");
      out.write("    <script src=\"sbfiles/js/plugins/morris/morris.min.js\"></script>\n");
      out.write("    <script src=\"sbfiles/js/plugins/morris/morris-data.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Custom Theme JavaScript -->\n");
      out.write("    <script src=\"sbfiles/js/sb-admin-2.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
