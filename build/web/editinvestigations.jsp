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
      <link rel="shortcut icon" href="images/truevine.png"/>
    <title>Truevine Medical System</title>
 <script src="js/jquery-1.7.2.js"></script>
    <script src="sbfiles/js/sb-admin-2.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
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
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
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
                                yearRange:'1950:2000',
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
     
     function decideincdesc(){
         
         if(document.getElementById("inclusions").value=='positive'){
             
             document.getElementById("incdesclabel").innerHTML='Describe inclusions';
             document.getElementById("incdesc").style.display='block';
         }
         else{
             
                document.getElementById("incdesclabel").innerHTML='';
             document.getElementById("incdesc").style.display='none';
             
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

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            
            <%@include file="menu/menu.jsp" %>
          
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                                                                
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
<!-- Smart Wizard -->
        <!--<h2>Example: Basic Wizard</h2>-->
                          <form method="post" action="saveinvestigations" class="form contact-form">
  		<div id="wizard" class="swMain" style="width:1200px;">

  <ul> 
      
       
      
                    <li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   FINAL Findings<br />
                   <small>Findings </small>
                  
                </span>                   
                        </a></li>
                    
                   
                        
                        
                        <li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   HAEMOGRAM<br />
                   <small>a-e</small>
                </span>                   
                        </a></li>
                        
                        
                  <li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                   LFTS to MRI<br />
                   <small>a-e</small>
                </span>                   
                        </a></li>       
                   
  		</ul>
                     
  			<div id="step-1"  style="height:400px; width:100%;">	
            

                          </div>
  			  			
  		
                    
                    <div id="step-2" style="height:400px; width:100%;">
                    </div>
                    
                    
        
                    <div id="step-3" style="height:550px; width:100%">
                  </div>
                                
                    
                  
                    
  		</div>
<!-- End SmartWizard Content -->
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
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script><!--

     Morris Charts JavaScript 
    <script src="sbfiles/js/plugins/morris/raphael.min.js"></script>
    <script src="sbfiles/js/plugins/morris/morris.min.js"></script>
    <script src="sbfiles/js/plugins/morris/morris-data.js"></script>-->

    <!-- Custom Theme JavaScript -->
     <script src="js/jquery-1.7.2.js"></script>
    <script src="sbfiles/js/sb-admin-2.js"></script>
<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
 

<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	// Smart Wizard
        
        $.ajax({
    url:"loadinvestigations",
    type:'post',
    dataType:'json',
    success:function(data){
       // alert(data["step1"]);
        document.getElementById("step-1").innerHTML=data["step1"];
        document.getElementById("step-2").innerHTML=data["step2"];
        document.getElementById("step-3").innerHTML=data["step3"];
        decideincdesc();
    }
});  
            
        
  		$('#wizard').smartWizard();

      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        //alert('Finish Clicked');
      }
		});
                
                
                
</script>


</body>

</html>
