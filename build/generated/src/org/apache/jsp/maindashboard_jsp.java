package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class maindashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/menu/minimenu.html");
    _jspx_dependants.add("/menu/menu.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
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
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
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
      out.write("\n");
      out.write("            <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("                <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                   <!--menu-->\n");
      out.write("                   \n");
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
      out.write("         <ul class=\"nav\" id=\"side-menu\">\r\n");
      out.write("<!--                        <li class=\"sidebar-search\">\r\n");
      out.write("                            <div class=\"input-group custom-search-form\">\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\r\n");
      out.write("                                <span class=\"input-group-btn\">\r\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\">\r\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                             /input-group \r\n");
      out.write("                        </li>-->\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a class=\"active\" href=\"index.html\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("<!--                        <li>\r\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Charts<span class=\"fa arrow\"></span></a>\r\n");
      out.write("                            <ul class=\"nav nav-second-level\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"flot.html\">Flot Charts</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"morris.html\">Morris.js Charts</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                             /.nav-second-level \r\n");
      out.write("                        </li>-->\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"childdetails.jsp\"><i class=\"fa fa-stethoscope fa-fw\"></i> Child Basic Details</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"financialtransaction.jsp\"><i class=\"fa fa-dollar fa-fw\"></i> Financial Transactions</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"generalexamination.jsp\"><i class=\"fa fa-ambulance fa-fw\"></i> General Examination</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"systemicexamination.jsp\"><i class=\"fa fa-plus-circle fa-fw\"></i> Systemic Examination</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-hospital-o fa-fw\"></i> Impression/Diagnosis </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"treatment.jsp\"><i class=\"fa fa-medkit fa-fw\"></i> Treatment</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-book fa-fw\"></i> FollowUps/Reviews</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-keyboard-o fa-fw\"></i> Final Disposal </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-files-o fa-fw\"></i> Reports</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-calendar fa-fw\"></i> Bookings</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <a href=\"manageforms.jsp\"><i class=\"fa fa-book fa-fw\"></i> Manage Clients</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
      out.write("                    <h1 class=\"page-header\">Dashboard</h1>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col-lg-12 -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-stethoscope fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Child</div>\n");
      out.write("                                    <div>Basic Details</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-pink\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-dollar fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Financial</div>\n");
      out.write("                                    <div> Transactions</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-purple\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-ambulance fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">General</div>\n");
      out.write("                                    <div>Examination</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                  <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-pinkish\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-plus-circle fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Systemic</div>\n");
      out.write("                                    <div>Examination</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-green\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-hospital-o fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Diagnosis</div>\n");
      out.write("                                    <div>Impression</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-yellow\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-medkit fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Treatment</div>\n");
      out.write("                                    <div></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"dashboard.jsp\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-red\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-book fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Referral</div>\n");
      out.write("                                    <div></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-bluish\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-keyboard-o fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Reviews</div>\n");
      out.write("                                    <div>Follow Ups</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-pink\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-archive fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Final</div>\n");
      out.write("                                    <div>Disposal</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View</span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-files-o fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Reports</div>\n");
      out.write("                                    <div></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View </span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                 <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <div class=\"panel panel-purple\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-3\">\n");
      out.write("                                    <i class=\"fa fa-calendar fa-5x\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-9 text-right\">\n");
      out.write("                                    <div class=\"huge\">Bookings</div>\n");
      out.write("                                    <div></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a href=\"#\">\n");
      out.write("                            <div class=\"panel-footer\">\n");
      out.write("                                <span class=\"pull-left\">Click to View </span>\n");
      out.write("                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("    <!-- jQuery Version 1.11.0 -->\n");
      out.write("    <script src=\"sbfiles/js/jquery-1.11.0.js\"></script>\n");
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