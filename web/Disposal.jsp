<%-- 
    Document   : maindashboard
    Created on : Sep 8, 2014, 10:41:20 AM
    Author     : Maureen
--%>

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

    <title>Disposal</title>
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
    
 function cleardate(){
     
     $("#deathdate").val('');
     
 }

            function opennewpage(){
            
        var pg=document.getElementById("activityloader").value;
        
        if(pg!=""){
            
            window.open(pg)
        }
                             
                
                    
            
            }
            
            
          
            
            
           function chooseaction(){
               
               //alert('here');
        if(document.getElementById("disposal").value=='Died'){
            //alert('should work');
            document.getElementById("causediv").style.display='block';;
            document.getElementById("towndiv").style.display='none';
            //document.getElementById("deathdate").required="true";
            //document.getElementById("deathcause").required="true";
            //document.getElementById("country").removeAttribute("required");
            //document.getElementById("town").removeAttribute("required");
             $("#country").val('');
            $("#town").val('');
            
           
            
        }
        
        else   if(document.getElementById("disposal").value=='Moved to other towns'){
            //alert('should work');
            document.getElementById("causediv").style.display='none';
            document.getElementById("towndiv").style.display='block';
         $("#deathdate").val('');
            $("#deathcause").val('');
            
            //document.getElementById("town").required="true";
            //document.getElementById("country").required="true";
            //document.getElementById("deathdate").removeAttribute("required");
            //document.getElementById("deathcause").removeAttribute("required");
            
        }
        else {
            
            
              document.getElementById("causediv").style.display='none';
            document.getElementById("towndiv").style.display='none'; 
            
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
  		
  			
            <h2 style="color:orange; text-align: center;">Follow up and Disposal</h2>
           
		<fieldset>
                   
		
                    
               <form action="savedisposal" method="post">
                               
<table style="margin-left: 90px; width:1000px;" id="" class="viewpdt">

   <tr><th colspan="2" style="text-align: center;">Give the reason for not attending hospital any more</th></tr>
 
   <tr><th colspan="1" style="text-align: center;">Patient's Name</th><td><b><%=request.getParameter("name")%></b><input type='hidden' name='patientid' value='<%=request.getParameter("regNo")%>'><input type='hidden' name='name' value='<%=request.getParameter("name")%>'></td></tr>
 <tr><th style="text-align: left;width:200px;">Reason</th><td> 
         <select name="disposal" required title="" id="disposal" onchange="chooseaction();" style="height:30px;width:240px;" >
             <option value="">choose reason</option>
             <option  value="Discharged due to overage"  >Discharged due to overage </option>
             <option value="Died">Died</option>
             <option value="Lost to follow up">Lost to follow up</option>
             <option value="Moved to other towns">Moved to other town</option>
             </select>
     </td></tr></table>
                   
             <div id="causediv">
                  <!--   death cause                       -->
             <table style="margin-left: 90px; width:1000px;" id="" class="viewpdt">     
 <tr ><th style="width:200px;"><span id="datelabel">Date</span></th><td><input type="text" class='date' name="deathdate" id="deathdate" readonly style="width:240px; height:30px;"/><button title='clear date field to blank' onclick="cleardate();" class="btn btn-default" type="button">
             <i class="fa fa-refresh" ></i>
</button></td></tr>
 <tr><th><span id="causelabel"> Cause </span></td><th><input type="text" name="deathcause" id="deathcause"  style="width:240px; height:75px;"/></td></tr>

 </table>
                  
                  </div>
                   
<div id="towndiv">
 <table style="margin-left: 90px; width:1000px;" id="" class="viewpdt">                   
<tr><th style="width:200px;"><span id="townlabel">Town</span></th><td> <input style='height:33px;width:240px;'  list="townsdl" name="town" id="town" /> <datalist id="townsdl"><option value="nairobi"> <option value="nyahururu"></datalist></td></tr>   
<tr><th><span id="countrylabel">Country</span></th><td> <input style='height:33px;width:240px;'  list="countydl" name="country" id="country" /> <datalist id="countydl"><option value="Uganda"/> <option value="Tanzania"/></datalist> </td></tr>   
</table></div>
<table class="viewpdt" style="margin-left: 400px;">
<tr><td colspan="2"><input type="submit"  style="height: 30px; width:120px; background: orange;"value="Save" /></td>  </tr>
</table><inpu type="submit" value="Save" >
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
      chooseaction();
    
</script>

</body>

</html>
