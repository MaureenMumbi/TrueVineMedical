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

    <title>View Clients</title>
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
    
 

            function opennewpage(ur){
            
        var pg=ur.value;
        
        if(pg!==""){
            
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
                
                <a class="navbar-brand" href="index.html">Truevine ChildHealth Centre System</a>
            </div>
            <!-- /.navbar-header -->

          <%@include file="menu/minimenu.jsp" %>
            
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
<!--                            <form method="post" action="saveinvestigations" class="form contact-form">-->
  		
  			
            <h2 style="color:orange; text-align: center;">Child Basic Details</h2>
           
		<fieldset>
                   
		
                    
                <%dbConnect conn= new dbConnect();
String qry="SELECT PatientID, concat( FName,\" \",SName,\" \",LName) as child , Age, Residence FROM truevine.basicdetails;";                
conn.rs=conn.state.executeQuery(qry);



%>           
                               
<table style="margin-left: 90px; width:1000px;" id="invtable1" class="viewpdt">

  <tr><th>Patient Id</th><th> Patient Name</th><th>Age</th><th>Residence</th><th>Select Activity</th></tr>  
  <tbody>
  <%while(conn.rs.next()){%>    
  <tr>
      <td><%=conn.rs.getString(1)%></td>
      <td><%=conn.rs.getString(2)%></td>
      <td><%=conn.rs.getString(3)%></td>
      <td><%=conn.rs.getString(4)%></td>
      <td><select name="activityloader" onchange="opennewpage(this);" id="activityloader"> 
              <option value="">Select Page</option>
              <option value="financialtransaction.jsp?regNo=<%=conn.rs.getString(1)%>">Financial Transaction</option>
              <option value="generalexamination.jsp?regNo=<%=conn.rs.getString(1)%>">General Examination</option>
              <option value="systemicexamination.jsp?regNo=<%=conn.rs.getString(1)%>">Systemic Examination</option>
              <option value="investigations.jsp?regNo=<%=conn.rs.getString(1)%>">Investigations</option>
              <!--<option value="visits.jsp?regNo=<%=conn.rs.getString(1)%>">Visits</option>-->
             <option value="visits.jsp?name=<%=conn.rs.getString("child")%>&age=<%=conn.rs.getString("age")%>&regNo=<%=conn.rs.getString("PatientID")%>">Follow ups and revisits</option>
             <option value="treatment.jsp?name=<%=conn.rs.getString("child")%>&age=<%=conn.rs.getString("age")%>&regNo=<%=conn.rs.getString("PatientID")%>">Treatment</option>
             <option value="Disposal.jsp?name=<%=conn.rs.getString("child")%>&regNo=<%=conn.rs.getString("PatientID")%>">Disposal</option>
               
          </select></td>
  </tr>
      
      <%}%>
  </tbody>
  </table>
                              

									
							
	
                    
                    
        
                                
                    
                  
                    
  		
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
  		$('#wizard').smartWizard();

      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        //alert('Finish Clicked');
      }
		});
</script>


</body>

</html>
