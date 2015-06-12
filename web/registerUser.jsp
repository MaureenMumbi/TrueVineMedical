<%-- 
    Document   : registerUser
    Created on : Jun 10, 2015, 2:57:13 PM
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
<script>
   function comparepwds(){
      var pwd= document.getElementById("password").value    
      var cpwd= document.getElementById("passwords").value    
      if(cpwd!=pwd){
          alert("Password doesn't match")
          $("#passwords").focus();
          $("#passwords").css({'background-color' : 'yellow'});
        return false;
      }
        else{
            return true;
        }
        
    }
</script>
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
                    <h1 class="page-header">Register User</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
             <form class="form-horizontal" method="post" id="validate" action="RegisterUser" >
			
                 
                   <%if (session.getAttribute("useradded") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("useradded")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("useradded");
                            }

                        %> 
                 
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
	                                
	                                <div class="controls">
	                                <label class="control-label">UserID <span class="text-error">*</span></label>    <input type="text" value="<%=generateRandomNumber(1000,10888)%>" readonly class="validate[required] form-control" name="userid" id="req"/>
	                                </div>
	                            </div>
						      <div class="control-group">
						            <label class="control-label">First Name </label>
						            <div class="controls"><input class="form-control" type="text" name="fname" placeholder="First Name " /></div>
						        </div>
						      <div class="control-group">
						            <label class="control-label">Last Name </label>
						            <div class="controls"><input class="form-control" type="text" name="mname" placeholder="Surname" /></div>
						        </div>
						      <div class="control-group">
						            <label class="control-label">Username </label>
						            <div class="controls"><input class="form-control" type="text" name="username" placeholder="Username " /></div>
						        </div>
                                                        <div class="control-group">
                                                        <label class="control-label">Password <span class="text-error">*</span></label>
                                                        <div class="controls">
                                                            <input type="password" id="password" name="password"  class="validate[required] form-control " value="">
                                                        </div>
                                                     </div>  
                                                        <div class="control-group">
                                                        <label class="control-label">Repeat Password <span class="text-error">*</span></label>
                                                        <div class="controls">
                                                            <input type="password" onblur="comparepwds();" id="passwords" name="pass1"  class="validate[required] form-control " value="">
                                                        </div>
                                                     </div>  
                                                        <div class="control-group">
                                                        <label class="control-label">Access Level <span class="text-error">*</span></label>
                                                        <div class="controls">
                                                            <select id="accesslevel" name="userlevel"  class="validate[required] form-control ">
                                                                <option value=""></option>
                                                                <option value="Receptionist">Receptionist</option>
                                                                <option value="Clinician">Clinician</option>
                                                            </select>
                                                        </div>
                                                     </div>  
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
