<%-- 
    Document   : viewdetails
    Created on : Nov 18, 2014, 8:22:28 PM
    Author     : Maureen
--%>

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


<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
  <!--<script src="js/jquery-1.7.2.js"></script>-->
    <script src="sbfiles/js/sb-admin-2.js"></script>
      <script src="sbfiles/js/bootstrap.min.js"></script>

     <!--Metis Menu Plugin JavaScript--> 
   

<script src="js/jquery-ui-1.10.3.custom.js"></script>
    <!-- Bootstrap Core CSS -->
    <link href="sbfiles/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="sbfiles/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="sbfiles/css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="sbfiles/css/sb-admin-2.css" rel="stylesheet">
<link href="css/tablecss.css" rel="stylesheet" type="text/css">
    <!-- Morris Charts CSS -->
    <link href="sbfiles/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="sbfiles/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    
    
  

    
    	<link href="styles/demo_style.css" rel="stylesheet" type="text/css">
 <script src="js/jquery-1.7.2.js"></script>
<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<script src="js/jquery-ui-1.10.3.custom.js"></script>
  
       <script src="js/datepicker.js"></script>
       <script src="js/jquery.ui.datepicker.js"></script>
<!--       <script src="js/DICHelp.js"></script>-->
	 <script>	
                $(function() {
        $( ".datepickerDOB" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1950:2000'
                               
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
    
      function ageCount() {
        var date1 = new Date();
        var  dob= document.getElementById("DOB").value;
        var date2=new Date(dob);
        var pattern = /^\d{1,2}\/\d{1,2}\/\d{4}$/; //Regex to validate date format (dd/mm/yyyy)
        if (pattern.test(dob)) {
            var y1 = date1.getFullYear(); //getting current year
            var y2 = date2.getFullYear(); //getting dob year
            var age = y1 - y2;           //calculating age 
            document.getElementById('age').value = age;
            return true;
        } else {
            alert("Please input Clients Date of Birth!");
            return false;
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
                    <h1 class="page-header">Edit Child Basic Details</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                      <form method="post" action="UpdateChildDetails" class="form contact-form">                                            
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
<!-- Smart Wizard -->
        <!--<h2>Example: Basic Wizard</h2>-->
  		<div id="wizard" class="swMain" >
  <ul> 
                    <li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   Step 1<br />
                   <small>Enter Childs Details</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   Step 2<br />
                   <small>Enters Mothers Details</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                   Step 2<br />
                   <small>Enter Father's Details</small>
                </span>                   
                        </a></li>
                    
  		</ul>
  		<input type="hidden" value="<%= session.getAttribute("regno")%>" id="regno" name="regno" >	
  		<input type="hidden" value="<%= session.getAttribute("PatientID")%>" id="PatientID" name="PatientID" >	
                                  
                                     <div id="step-1"  style="height:400px; width:1110px;">
           <h2 class="StepTitle">Child Details</h2>   

  
                                     <table id="step1" class="viewpdt">   
                    </table>   
                                    
                                     </div>
                                   <div id="step-2" style="height:400px; width:1110px;">
                                       
                                        <h2 class="StepTitle">Mother Details</h2> 
                                       <table id="step2" class="viewpdt">   
                                         </table>     
                                   </div>
                                     <div id="step-3" style="height:400px; width:1110px;">
                                         <h2 class="StepTitle">Father Details</h2> 
                                         <table  id="step3" class="viewpdt">   
                                         </table>   
                                         
                                     </div>		
  		</div>
<!-- End SmartWizard Content -->

</td></tr>
</table>
</form>
            </div>
       
                                  
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
<!--    <script src="sbfiles/js/jquery-1.11.0.js"></script>-->

     <!--Bootstrap Core JavaScript--> 
  

 <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>

</body>
<script type="text/javascript" src="js/getChildDetails.js"></script>
           
                                       <script type="text/javascript">
                                                                     getChildDetails();
                                                               
                                                                 </script> 
</html>

