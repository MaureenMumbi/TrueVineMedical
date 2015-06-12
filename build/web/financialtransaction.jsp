<%-- 
    Document   : maindashboard
    Created on : Sep 8, 2014, 10:41:20 AM
    Author     : Maureen
--%>

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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                    <h1 class="page-header">Financial Transaction</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                 <form action="FinancialTransactions" method="post">
                       <%
String PatientID="";
if(request.getParameter("PatientID")!=null && !request.getParameter("PatientID").equals("")){
PatientID=request.getParameter("PatientID") ; }
else{
if(session.getAttribute("PatientID")!=null){
                  PatientID= (String) session.getAttribute("PatientID");
             }
}                   

%>        
                     <input type="hidden" value="<%=PatientID%>" name="PatientID">
                     <div class="form-group input-group" style="width:500px;">
                                             <label  style="width:200px;" >Fees Paid</label>
                                            <span class="input-group-addon">Kshs</span>
                                            <input type="text" class="form-control" name="consultationfee" readonly value="1500"  style="width:300px;">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                  <div class="form-group input-group" style="width:500px;">
                                             <label style="width:200px;">Injection</label>
                                            <span class="input-group-addon">Kshs</span>
                                            <input type="text" class="form-control" name="injectionfee" value="" style="width:300px;">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                  <div class="form-group input-group" style="width:500px;">
                                             <label style="width:200px;">Drugs</label>
                                            <span class="input-group-addon">Kshs</span>
                                            <input type="text" class="form-control" name="drugs" value="" style="width:300px;">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                  <div class="form-group input-group" style="width:500px;">
                                             <label style="width:200px;">Procedure Performed</label>
                                            <span class="input-group-addon">Kshs</span>
                                            <input type="text" class="form-control" name="procedurefee" value="" style="width:300px;">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                     
                                         <button type="submit" class="btn btn-default">Submit </button>
                                        <button type="reset" class="btn btn-default">Reset </button>
                                      
                 </form>
            </div>
        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="sbfiles/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="sbfiles/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>

    
    <!-- Custom Theme JavaScript -->
    <script src="sbfiles/js/sb-admin-2.js"></script>

</body>

</html>
