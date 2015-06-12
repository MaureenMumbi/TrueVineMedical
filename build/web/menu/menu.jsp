<%-- 
    Document   : menu
    Created on : May 24, 2015, 5:55:52 PM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <% if (session.getAttribute("level")!=null){
            if(session.getAttribute("level").toString().equals("Receptionist")){
                %>
                
                 <ul class="nav" id="side-menu">
<!--                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                             /input-group 
                        </li>-->
                        <li>
                            <a class="active" href="maindashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>

                        <li>
                            <a href="childdetails.jsp"><i class="fa fa-stethoscope fa-fw"></i> Child Basic Details</a>
                        </li>
                        <li>
                            <a href="financialtransaction.jsp"><i class="fa fa-dollar fa-fw"></i> Financial Transactions</a>
                        </li>
                       
                    </ul>  
                
      <%  }else if(session.getAttribute("level").toString().equals("Clinician")){%>
        <ul class="nav" id="side-menu">
<!--                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                             /input-group 
                        </li>-->
                        <li>
                            <a class="active" href="maindashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>

                        <li>
                            <a href="childdetails.jsp"><i class="fa fa-stethoscope fa-fw"></i> Child Basic Details</a>
                        </li>
                       
                        <li>
                            <a href="forms.html"><i class="fa fa-files-o fa-fw"></i> Reports</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-calendar fa-fw"></i> Bookings</a>
                        </li>
                        <li>
                            <a href="viewChildDetails.jsp"><i class="fa fa-book fa-fw"></i> Next Patient</a>
                        </li>
                        <li>
                            <a href="manageforms.jsp"><i class="fa fa-book fa-fw"></i> Manage Patients</a>
                        </li>
                        
                        <li>
                            <a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
       <% }}%>
    </body>
</html>
