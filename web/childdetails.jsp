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
 <!--<script src="js/jquery-1.7.2.js"></script>-->
  
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->

<script src="scripts/jquery.js"></script>
<script src="scripts/jquery-ui_1.js"></script>
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
   <script src="sbfiles/js/sb-admin-2.js"></script>

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

<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">
<script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>
<!--<script type="text/javascript" src="js/jquery.smartWizard.js"></script>-->

<link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet"/>
<link href="css/tablecss.css" rel="stylesheet"/>
 <script src="sbfiles/js/bootstrap.min.js"></script>

     <!--Metis Menu Plugin JavaScript--> 
    

	 <script>	
                $(function() {
        $( ".datepickerDOB" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1995:2015'
                               
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
                    <h1 class="page-header">CHILD BASIC DETAILS</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                      <form method="post" action="ChildDetails" class="form contact-form">                                            
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
<!-- Smart Wizard -->
        <!--<h2>Example: Basic Wizard</h2>-->
  		<div id="wizard" class="swMain">
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
  			<div id="step-1"  style="height:500px; width:1110px;">	
            <h2 class="StepTitle">Child Details</h2>
          
		<fieldset>
                    <h2> Enter child's basic details</h2>
		<div id="message"></div>
                <div class="formRow" >
                     <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                    <table  style="width:700px"   class="viewpdt">
                        
                        <tr>
                            <td>First Name</td><td><input type="text" name="FName" class="form-control"  style="height:30px;" placeholder="Childs First Name..." ></td>
                              </tr>
                            <tr> <td>Middle Name</td><td><input type="text" class="form-control"   style="height:30px;" name="MName" placeholder="Childs Middle Name..." ></td>
                              </tr>
                           <tr>  <td>Surname Name</td><td><input type="text" class="form-control"  style="height:30px;" name="SName" placeholder="Childs Surname..." ></td>
                        </tr>
                        <tr>
                            <td>Reg No</td><td> <input type="text" class="form-control" style="height:30px;" name="regno" Placeholder="e.g 1/2014"></td>
                            
                        </tr>
                        <tr>
                            <td>Date of Birth</td><td> <input type="text"  name="dob"  style="height:30px;" id="DOB" class="datepickerDOB" onchange="ageCount();" Placeholder="dd/mm/yyyy"></td>
                            
                        </tr>
                        <tr>
                            <td>Current Age</td><td> <input type="text" class="form-control" name="age"  style="height:30px;" id="age" readonly></td>
                            
                        </tr>
                        <tr>
                            <td>Sex</td>
                            <td> <select class="form-control" name="sex"  id="sex">
                                    <option value="">Select Gender</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </td>
                            
                        </tr>
                    </table>
                                </div></div></div>

									</div>
								</fieldset>
							
        </div>
  			  			<div id="step-2" style="height:500px; width:1110px;">
            <h2 class="StepTitle">Mothers Details</h2>
             <h2> Enter mother's  details</h2>
          <table  style="width:700px"  class="viewpdt" >
              <tr></tr>
                        <tr>
                            <td>First Name</td><td><input type="text"  class="form-control" name="MothersFName"   style="height:30px;" placeholder="Mother's First Name..." ></td>
                              </tr>
                            <tr> <td>Middle Name</td><td><input type="text" class="form-control" name="MothersMName"   style="height:30px;" placeholder="Mother's Middle Name..." ></td>
                              </tr>
                           <tr>  <td>Surname Name</td><td><input type="text"  class="form-control" name="MothersSName"   style="height:30px;" placeholder="Mother's Surname..." ></td>
                        </tr>
                        <tr>
                            <td>Phone No</td><td> <input type="text" name="mothersphoneno"  class="form-control"  style="height:30px;" Placeholder="e.g 0720000000"></td>
                            
                        </tr>
                        <tr>
                            <td>Occupation</td><td> <select name="mothersoccupation"  class="form-control"  style="height:30px;">
                                    <option value="housewife">Housewife</option>
                                    <option value="working">Working</option>
                                </select></td>
                            
                        </tr>
                       
                    </table>
         
        </div>
  			  			<div id="step-3" style="height:500px; width:1110px;">
            <h2 class="StepTitle">Fathers Details</h2>
              <h2> Enter fathers's  details</h2>
           <table style="width:700px" class="viewpdt" >
               <tr></tr>        
               <tr>
                            <td>First Name</td><td><input type="text"  class="form-control"  name="FathersFName"   style="height:30px;" placeholder="Father's First Name..." ></td>
                              </tr>
                            <tr> <td>Middle Name</td><td><input type="text"  class="form-control" name="FathersMName"  style="height:30px;" placeholder="Father's Middle Name..." ></td>
                              </tr>
                           <tr>  <td>Surname Name</td><td><input type="text"  class="form-control" name="FathersSName"  style="height:30px;" placeholder="Father's Surname..." ></td>
                        </tr>
                        <tr>
                            <td>Phone No</td><td> <input type="text"  class="form-control" name="Fathersphoneno"  style="height:30px;"  Placeholder="e.g 0720000000"></td>
                            
                        </tr>
                        <tr>
                            <td>Occupation</td><td> <input type="text" class="form-control" name="Fathersoccupation"  style="height:30px;" Placeholder="job"><td>
                            
                        </tr>
                        <tr>
                            <td>Place of work</td><td> <input type="text"  class="form-control" name="Fathersworkplace"   style="height:30px;" id="workplace"  ></td>
                            
                        </tr>
                        <tr>
                            <td>Provided for Insurance</td><td>
                             <select name="Insurance" class="select"  class="form-control"  style="height:30px;">
                                    <option value="Yes">Yes</option>
                                    <option value="No">No</option>
                                </select>
                            
                            <td>
                            
                        </tr>
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
   



</body>

</html>
