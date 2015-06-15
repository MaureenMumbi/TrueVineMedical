<%-- 
    Document   : mothlyattendance
    Created on : Jun 14, 2015, 11:00:14 AM
    Author     : Maureen
--%>
<%-- 
    Document   : manageUsers
    Created on : Jun 12, 2015, 4:19:11 PM
    Author     : Maureen
--%>



<%@page import="DBCONNECT.dbConnect"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Truevine Medical System</title>

    <!-- Bootstrap Core CSS -->
    <link href="sbfiles/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="sbfiles/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="sbfiles/css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="sbfiles/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="sbfiles/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="sbfiles/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="js/css/plugins.css" rel="stylesheet" type="text/css">

 <script src="sbfiles/js/jquery-1.11.0.js"></script>
   <script type="text/javascript" src="js/functions.js"></script>
   <script type="text/javascript" src="js/jquery.validation.js"></script>
   <script type="text/javascript" src="js/jquery.validationEngine-en.js"></script>
   <!--<script type="text/javascript" src="js/jquery.form.wizard.js"></script>-->

    <!-- Bootstrap Core JavaScript -->
    <script src="sbfiles/js/bootstrap.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>

    
    <!-- Custom Theme JavaScript -->
    <script src="sbfiles/js/sb-admin-2.js"></script>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<script type="text/javascript" src="js/noty/themes/default.js"></script>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="index.html">Truevine ChildHealth Centre System</a>
            </div>
            <!-- /.navbar-header -->

          <%@include file="menu/minimenu.html" %>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <%@include file="menu/menu.jsp" %>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Monthly Attendance</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
             <form class="form-horizontal" method="post" id="validate" action="monthlyattendance" >
			
                 
                 <fieldset>
                                            <div class="widget row-fluid" style="margin-left:30px; ">
						    

                                               
						    <div class="well">
    				      
	                              
	                           
						      <div class="control-group">
						            <label class="control-label">Year </label>
						            <div class="controls">
                                                                <select class="form-control" name="year">
                                                                    <option value="2012">2012</option>
                                                                    <option value="2013">2013</option>
                                                                    <option value="2014">2014</option>
                                                                    <option value="2015">2015</option>
                                                                    <option value="2016">2016</option>
                                                                </select>
                                                            </div>
						        </div>
						      <div class="control-group">
						            <label class="control-label">Category </label>
						            <div class="controls">
                                                                <select class="form-control" name="category">
                                                                    <option value="Age">Age</option>  
                                                                    <option value="Sex">Sex</option>  
                                                                </select>
                                                            </div>
						        </div>
						       
                                         <div class="form-actions">
	                                        <button class="btn btn-primary" type="submit">Generate Report</button>
	                                    
                                      </div>
                                                    </div></div></fieldset>
                                    </form>
            </div>
        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
  
</body>

</html>
