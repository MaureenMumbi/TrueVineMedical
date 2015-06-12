<%-- 
    Document   : NextPatient
    Created on : Jun 12, 2015, 11:06:57 AM
    Author     : Maureen
--%>


<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : maindashboard
    Created on : Sep 8, 2014, 10:41:20 AM
    Author     : Maureen
--%>


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

          <%@include file="menu/minimenu.jsp" %>

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
                    <h1 class="page-header">Edit basic details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
             <form class="form-horizontal" method="post" id="validate" action="saveNextPatient" >
			
                 
                  
                 
                 <fieldset>
                                            <div class="widget row-fluid" style="margin-left:30px; ">
						    
						    	
                                                         <%!
    public int generateRandomNumber(int start, int end ){
        Random random = new Random();
        long fraction = (long) ((end - start + 1 ) * random.nextDouble());
        return ((int)(fraction + start));
    }
%>  
                                               
						    <div class="well">
                                                   		      
                                <div class="control-group">
	                                  <%
String PatientID="";
String Name="";
if(request.getParameter("PatientID")!=null && !request.getParameter("PatientID").equals("")){
PatientID=request.getParameter("PatientID") ; }
else{
if(session.getAttribute("PatientID")!=null){
                  PatientID= (String) session.getAttribute("PatientID");
             }
}                   
if(request.getParameter("Name")!=null && !request.getParameter("Name").equals("")){
Name=request.getParameter("Name") ; }
%>        
                     <input type="hidden" value="<%=PatientID%>" name="PatientID">
	                                
						   
                     
                     
                     
                     
                     
                                            <table>
                                           
                                                 <tr class="form-group input-group" style="width:500px;">
                                                     <td style="width:200px;"> Patient Name </td>
						     <td><%= Name %></td>
                                                            
                                             </tr>
						      
                                                 <tr class="form-group input-group" style="width:500px;">
                                                     <td style="width:200px;"> Patient No. </td>
						     <td><%= PatientID %></td>
                                                            
                                             </tr>
                                                 <tr class="form-group input-group" style="width:500px;">
                                                     <td style="width:200px;"> Temperature </td>
						     <td><input class="form-control" type="text" name="temperature" placeholder="Temperature " /></td>
                                                            
                                             </tr >
                                                 <tr class="form-group input-group" style="width:500px;">
                                                     <td style="width:200px;"> Weight </td>
						     <td> <input class="form-control" type="text" name="weight" placeholder="Weight in KGS" /></td>
                                                            
                                             </tr>
                                                 <tr class="form-group input-group" style="width:500px;">
                                                     <td style="width:200px;"> Blood Pressure </td>
						     <td> <input class="form-control" type="text" name="bp" placeholder="Blood Pressure " /></td>
                                                            
                                             </tr>
						      
                                                       
                                            </table>
                                         <div class="form-actions">
	                                        <button class="btn btn-primary" type="submit">Submit</button>
	                                        <!--<button class="btn btn-danger" type="button">Cancel</button>-->
	                                        <button class="btn" type="reset">Reset</button>
<!--	                                        <span class="help-inline">Left aligned buttons</span>-->
	                                    
<!--                                         <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>-->
                                      </div>
                                    </form>
            </div>
        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
  
</body>

</html>

