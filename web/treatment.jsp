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

    <title>Treatment</title>
 <script src="js/jquery-1.7.2.js"></script>
 <script src="jquery-ui-1.11.4/jquery-ui.js"></script>
 <script src="jquery-ui-1.11.4/jquery-ui.css"></script>
    <script src="sbfiles/js/sb-admin-2.js"></script>
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->
<!--<script type="text/javascript" src="js/jquery.smartWizard.js"></script>-->
 

<!--<script src="js/jquery-ui-1.10.3.custom.js"></script>-->
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

    
    
    <style>
        
        
        
    </style>
    
    	<link href="styles/demo_style.css" rel="stylesheet" type="text/css">
        <link href="css/tablecss.css" rel="stylesheet" type="text/css">
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<!--<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">-->
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->
<!--<script type="text/javascript" src="js/jquery.smartWizard.js"></script>-->







 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<!--<script src="js/jquery-ui-1.10.3.custom.js"></script>-->

       <script src="js/datepicker.js"></script>
       <script src="js/jquery.ui.datepicker.js"></script>
      
<!--       <script src="js/DICHelp.js"></script>-->
	 <script>	
                $(function() {
       $(".date1").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2030', dateFormat: 'yy/mm/dd'});
       $(".nextvisit").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2030', dateFormat: 'yy/mm/dd',maxDate: new Date()});
                
            
                    
                });
                
                function cleardate(){
     
     $("#date1").val('');
     
 }
         function cleardate1(){
     
     $("#nextvisit").val('');
     
                               }   
    
    function printst(){
        
        
        if(document.getElementById("isprint").checked===true){
        document.getElementById("submit").value="SAVE AND PRINT";
        document.getElementById("isprint1").value="yes";
                       }
                       else 
                       {
             document.getElementById("submit").value="SAVE";
                document.getElementById("isprint1").value="no";      
                           
                           
                       }
    //alert(document.getElementById("isprint").value);
    }
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
                
                <a class="navbar-brand" href="#">Truevine ChildHealth Centre System</a>
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
                    <h1 class="page-header">Treatment</h1>
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
  		
  			
            <h2 style="color:orange; text-align: center;">Child Basic Details</h2>
           
		<fieldset>
                   
		
                    
               <form action="PrintForm" method="post">
                               
<table style="margin-left: 90px; width:1000px;" id="" class="viewpdt">

  <tr><td style="text-align: left;"> Patients Name :</td><td> <input type="hidden" name="reg" value="<%=request.getParameter("regNo")%>"><b><%=request.getParameter("name")%></b></td></tr>  
  <tbody>
    
  <tr>
      <td  style="text-align: left;">Age :</td><td><input type="hidden" name="name" value="<%=request.getParameter("name")%>"><input type="hidden" name="age" value="<%=request.getParameter("age")%>"><%=request.getParameter("age")%></td>     
  </tr>
  <%
  
  Format formatter = new SimpleDateFormat("yyyy/MM/dd");
                    String mdate;

                    Date mydate = new Date();
                    mdate = formatter.format(mydate);
                        
  
  
  %>
  <tr>
      <td style="text-align: left;">Date of Treatment:</td><td><input and required type="text" class="nextvisit" readonly name="date1" value="<%=mdate%>" style="height:30px;width:240px;" id="date1" required/><button title='clear date field to blank' onclick="cleardate();" class="btn btn-default" type="button">
             <i class="fa fa-refresh" ></i>
</button></td>     
  </tr>
  <tr>
      <td style="text-align: left;">Treatment :</td><td> <div id="the-basics"> <textarea required name="treatment" id="treatment" required cols="40" rows="3"></textarea></div></td>
    
 </tr>
 <tr></tr>
 <tr>
      <td style="text-align: left;">Prescription :</td><td>  <textarea  name="prescription" placeholder="Enter prescription in this format 1X2 or 3X4" id="prescription"  cols="40" rows="2"></textarea></td>
    
 </tr>
 <tr><td style="text-align: left;">Next Visit Date:</td><td><input  type="text"  class="date1" name="nextvisitdate" value="" style="height:30px;width:240px;" id="nextvisit" /><button title='clear date field to blank' onclick="cleardate1();" class="btn btn-default" type="button">
<i class="fa fa-refresh" ></i></button></td></tr>
 
  <tr><th colspan="2" style="text-align: center;">Refferal Section</th></tr>
 <tr><td style="text-align: left;">Select An Option</td><td> <select name="refferal" title="To select various options, hold the control button and select all the options that apply. To unselect an option, Hold the control button and press the selected option" id="refferal" required style="height:120px;width:240px;" multiple>
            <option value="Not reffered">Not reffered</option>
             <option value="Surgical">Surgical</option>
             <option value="Orthopedic">Orthopedic</option>
             <option value="Ophthalmology">Ophthalmology</option>
             <option value="ENT">ENT</option>
             <option value="Neurology">Neurology</option>
     
     </td></tr>
    <tr> <td><input type='hidden' name='isprint1' id='isprint1' value='yes'><input type="checkbox" onclick='printst();' checked name="isprint" id="isprint" value="yes">Print</td> <td colspan="2" style="margin-left: 20px;"><input type="submit" id="submit"  style="height: 35px; width:120px; background: orange;"value="SAVE AND PRINT" /></td>  </tr>

  </tbody>
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
    <script src="sbfiles/js/typeahead.bundle.js"></script>

     <!--Metis Menu Plugin JavaScript--> 
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>


</body>
<script>
    
       document.getElementById("submit").value="SAVE AND PRINT";
        document.getElementById("isprint1").value="yes";  
        document.getElementById("isprint").checked=true;  
   




 
var diseases = ["Malaria", "Pneumonia","Flu","Cold","Anaemia","Leukemia","erythema infectiosum","roseola infantum","chicken pox","Scarlet fever","Whooping cough"];
var prescription = ["1X1", "1X2","1X3","2X1","2X2","2X3","3X1","3X2","3X3","4X1","4X2","4X3"];
 
//$('#treatment').typeahead({
//  hint: true,
//  highlight: true,
//  minLength: 1
//},
//{
//  name: 'treatment',
//  source: substringMatcher(diseases)
//});

    $( "#treatment" ).autocomplete({
      source: diseases
    });
    $( "#prescription" ).autocomplete({
      source: prescription
    });

    </script>
</html>
