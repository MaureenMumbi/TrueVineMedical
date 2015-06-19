<%-- 
    Document   : maindashboard
    Created on : Sep 8, 2014, 10:41:20 AM
    Author     : Maureen
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DBCONNECT.dbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="images/truevine.png"/>

    <title>Report</title>
 <script src="js/jquery-1.7.2.js"></script>
    <script src="sbfiles/js/sb-admin-2.js"></script>
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
 

<script src="js/jquery-ui-1.10.3.custom.js"></script>
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
    <link href="sbfiles/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    
    
    
    
    	<link href="styles/demo_style.css" rel="stylesheet" type="text/css">
        <link href="css/tablecss.css" rel="stylesheet" type="text/css">
         <script src="js/datepicker.js"></script>
       <script src="js/jquery.ui.datepicker.js"></script>
        
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<!--<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">-->
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->
<!--<script type="text/javascript" src="js/jquery.smartWizard.js"></script>-->







 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<script src="js/jquery-ui-1.10.3.custom.js"></script>

       <script src="js/datepicker.js"></script>
       <script src="js/jquery.ui.datepicker.js"></script>
<!--       <script src="js/DICHelp.js"></script>-->
	  <script>	
                $(function() {
        $( ".date" ).datepicker({
                                dateFormat: "yy/mm/dd",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1950:2027',
                                maxDate: new Date()
                        });
                    
                });
            </script>
<script type="text/javascript">
    $(document).ready(function(){
    	// Smart Wizard
  		$('#wizard').smartWizard();

      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        //alert('Finish Clicked');
      }
      
      
      
		});
</script>


<script>
    
 function cleardate1(){
     
     $("#startdate").val('');
     
 }
 function cleardate2(){
     
     $("#enddate").val('');
     
 }
            function opennewpage(){
            
        var pg=document.getElementById("activityloader").value;
        
        if(pg!=""){
            
            window.open(pg)
        }
                             
                
                    
            
            }
            
            
          
            
            
            
  
  </script>  
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="maindashboard.jsp">Truevine ChildHealth Centre System</a>
            </div>
            <!-- /.navbar-header -->

          <%@include file="menu/minimenu.jsp" %>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                   <!--menu-->
                   
                    <%@include file="menu/menu.jsp" %>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
          
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Disposal </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                                                                
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
<!-- Smart Wizard -->
        <!--<h2>Example: Basic Wizard</h2>-->
<!--                            <form method="post" action="saveinvestigations" class="form contact-form">-->
  		
  			
            <h2 style="color:orange; text-align: center;">Common Diagnosis Report</h2>
           
		<fieldset>
                   
		
                    
               <form action="CommonDiagnosis" method="post">
                               
 <%
  
  Format formatter = new SimpleDateFormat("yyyy/MM/dd");
                    String mdate;

                    Date mydate = new Date();
                    mdate = formatter.format(mydate);
                        
  
  
  %>
                   
           
                  <!--   death cause                       -->
             <table style="margin-left: 90px; width:1000px;" id="" class="viewpdt">     
 <tr ><th style="width:200px;"><span id="datelabel">Start Date</span></th><td><input type="text" class='date' name="startdate" id="startdate" readonly style="width:240px; height:30px;"/><button title='clear date field to blank' onclick="cleardate1();" class="btn btn-default" type="button">
             <i class="fa fa-refresh" ></i>
</button></td></tr>
 <tr ><th style="width:200px;"><span id="datelabel">End Date</span></th><td><input value="<%=mdate%>" type="text" class='date' name="enddate" id="enddate" readonly style="width:240px; height:30px;"/><button title='clear date field to blank' onclick="cleardate2();" class="btn btn-default" type="button">
             <i class="fa fa-refresh" ></i>
</button></td></tr>

<tr><th></th><th colspan="1"><input type="submit"  style="height: 30px; width:120px; background: orange;"value="GENERATE" /></th>  </tr>
</table>
</form>
									
							
	
                    
                    
        
                                
                    
                  
 

</td></tr>
</table>

            </div>
        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
<!--    <script src="sbfiles/js/jquery-1.11.0.js"></script>-->

     <!--Bootstrap Core JavaScript--> 
   
    <script src="sbfiles/js/bootstrap.min.js"></script>

     <!--Metis Menu Plugin JavaScript--> 
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>
<script>
     
    
</script>

</body>

</html>
