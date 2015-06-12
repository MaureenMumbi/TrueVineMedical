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

    <title>Followup and Revisits</title>
 <script src="js/jquery-1.7.2.js"></script>
 
 
 
 
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
 
 
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
        $( "#date1" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1950:2027',
                                maxDate: new Date()
                        });
                    
                });
                function curdate(){
                    vardateObject,day,month,year,current_date;
//created the date object
dateObject =new Date();
day=dateObject.getDate();
month=dateObject.getMonth()+1;
year=dateObject.getFullYear();
//fully year separated by backward slash
current_date=month+"/"+day+"/"+year; 
                    
         document.getElementById("date1").value=current_date;           
                }
                
                
                
                 function cleardate(){
     
     $("#date1").val('');
     
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
  
  
  
  
  
  function loadvisits(age,name,patientid){
         
         
         
          $.ajax({
    url:"loadvisits?age="+age+"&name="+name+"&patientid="+patientid,
    type:'post',
    dataType:'html',
    success:function(data){
//        alert(data);
        document.getElementById("visitstable").innerHTML=data;
      $("#date1").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2020', dateFormat: 'dd/mm/yy'});
          
    }
});  
         
         
     }
  
  
  function loadspecificvisit(visit){
  
  var visit_no=visit.value;
  
  
        var age=document.getElementById("age").value;
        var name=document.getElementById("name").value;
        var patientid=document.getElementById("reg").value;
  document.getElementById("visitstable").innerHTML="<tr><td><img src='images/onemoment.gif' alt='loading ..please wait'></td></tr>";
  
       $.ajax({
     url:"loadvisits?age="+age+"&name="+name+"&patientid="+patientid+"&visitno="+visit_no,
     type:'post',
     dataType:'html',
     success:function(data){
//        alert(data);
         document.getElementById("visitstable").innerHTML=data;
         $("#date1").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2020', dateFormat: 'dd/mm/yy'});
          
          }
          });  
  
  
  }
  
  
  //now save the pages that appear
  
  function saveVisits(){
  var reg=document.getElementById("reg").value;
  var folowup=document.getElementById("followupid").value;
  var date1=document.getElementById("date1").value;
  var finding=document.getElementById("finding").value;
  var recom=document.getElementById("recomendation").value;
  var visitno=document.getElementById("visitno").value;
  
  if(date1===""){alert("Enter date");
  document.getElementById("date1").focus()
        }
 else {
  
    $.ajax({
    url:"SaveVisits?followupid="+folowup+"&reg="+reg+"&date1="+date1+"&finding="+finding+"&recomendation="+recom+"&Visitno="+visitno,
    type:'post',
    dataType:'html',
    success:function(data){
        var n = noty({text:data,
                        layout: 'center',
                        type: 'Success',
                        timeout: 3800,
        animation: {
        open: {height: 'toggle'}, // jQuery animate function property object
        close: {height: 'toggle'}, // jQuery animate function property object
        easing: 'swing', // easing
        speed: 500 // opening & closing animation speed
    }            
        }); 
         
    }
});  
 }
    }
  </script>  
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="index.html">Followup and reviews</a>
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
            
            <%@include file="menu/leftmenu.jsp" %>
          
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" style="font-family: bree serif;">Followup and Revisits</h1>
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
                   
		
                    
               <form action="SaveVisits" method="post">
                               
<table style="margin-left: 90px; width:1000px;" id="visitstable" class="viewpdt">
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
    
    loadvisits('<%=request.getParameter("age")%>','<%=request.getParameter("name")%>','<%=request.getParameter("regNo")%>');
    
    
</script>
</body>

</html>
