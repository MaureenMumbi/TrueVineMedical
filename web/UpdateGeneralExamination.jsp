<%-- 
    Document   : UpdateGeneralExamination
    Created on : Feb 3, 2015, 9:08:39 PM
    Author     : Maureen
--%>

<%-- 
    Document   : generalexamination
    Created on : Nov 10, 2014, 8:42:33 PM
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
 
   
<script src="scripts/jquery.js"></script>
<script src="scripts/jquery-ui_1.js"></script>
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
  <script src="sbfiles/js/sb-admin-2.js"></script>

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

    
    
    <link href="css/tablecss.css" rel="stylesheet"/>
    
    	<link href="styles/demo_style.css" rel="stylesheet" type="text/css">
 
<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">

 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">

<script src="js/jquery-ui-1.10.3.custom.js"></script>


	 <script>	
                function getdate() {
                   
                
        $( "#datepicker" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1990:2014'
                               
                        });
                    
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
  <script>
  function addtotextarea(id){
      var problem=id+" \n";
      document.getElementById("problem").value+=problem;
      
  }
  </script>
              
<script type="text/javascript">
    function showfield(b) {

   //document.getElementById("myCheck").checked = true;
   
   if( document.getElementById("complaints"+b) != null){
   var a = document.getElementById("complaints"+b).checked;
   
if((a==true)) {
   
       if(document.getElementById("duration"+b).type==("hidden")){
           
       document.getElementById("duration"+b).type="text"; 
         document.getElementById("duration"+b).required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("duration"+b).type==("text")){
           
       document.getElementById("duration"+b).type="hidden";    
       document.getElementById("duration"+b).value=""; 
       document.getElementById("duration"+b).removeAttribute("required");
       }}
   }
   
   if( document.getElementById("other"+b) != null){
   var other = document.getElementById("other"+b).checked;
   
  if((other==true)) {
   
       if(document.getElementById("complaint"+b).type==("hidden")){
           
       document.getElementById("complaint"+b).type="text"; 
         document.getElementById("complaint"+b).required="true"; 
       }
       if(document.getElementById("duration"+b).type==("hidden")){
           
       document.getElementById("duration"+b).type="text"; 
         document.getElementById("duration"+b).required="true"; 
       }
   }
    
else{ 
   
       if(document.getElementById("complaint"+b).type==("text")){
           
       document.getElementById("complaint"+b).type="hidden";    
       document.getElementById("complaint"+b).value=""; 
       document.getElementById("complaint"+b).removeAttribute("required");
       }
       if(document.getElementById("duration"+b).type==("text")){
           
       document.getElementById("duration"+b).type="hidden";    
       document.getElementById("duration"+b).value=""; 
       document.getElementById("duration"+b).removeAttribute("required");
       }
   

}}
   
   
       }
//       if(document.getElementById("others1").type="text"){
//           
//       document.getElementById("others1").type="hidden";    
//       }



</script>
         

</head>

<body onload="showhospital();">

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="index.html">Truevine ChildHealth Centre System</a>
            </div>
            <!-- /.navbar-header -->
   <%@include file="menu/minimenu.jsp" %>
            <!-- /.navbar-top-links -->

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
                    <h1 class="page-header">GENERAL EXAMINATION</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                                 <form method="post" action="updateGeneralExamination" class="form contact-form" >
                                           
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
<!-- Smart Wizard -->
        <!--<h2>Example: Basic Wizard</h2>-->
  		<div id="wizard" class="swMain"  style="width:1200px;">
  <ul> 
                                       <li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   Step 1<br />
                   <small> Child's Birth History</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   Step 2<br />
                   <small> Past Medical History</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-3" style="width: 252px;">
                <label class="stepNumber">3</label>
                <span class="stepDesc" style="font-size:19px;">
                   Step 3<br />
                   <small style="font-size:11px;">Present Complaints & Duration</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                   Step 4<br />
                   <small>Findings on examination</small>
                </span>                   
                        </a></li>
  		</ul>
                    <input type="hidden" value="<%= session.getAttribute("PatientID")%>" id="PatientID" name="PatientID" >	
                
  			<div id="step-1"  style="height:520px; width:1500px;">	
            <h2 class="StepTitle">Child Birth History</h2>
		
                    <h2> Child's Birth History</h2>
		 
                    <div id="step1">
                        
                        
                    </div>					

        </div>
                    <div id="step-2" style="height:600px; width:1110px;">
            <h2 class="StepTitle">Past Medical History</h2>
          <div id="step2"></div>
         
        </div>
  			  			<div id="step-3" style="height:400px; width:1200px;">
            <h2 class="StepTitle">Present complaints and duration</h2>
            <h3>What are the present complaints and duration? </h3>
                    <div id="step3"></div>
                                                
                                                </div>
                    
                    
                    
  			 			<div id="step-4" style="height:700px; width:1110px;">
            <h2 class="StepTitle">Findings on examination</h2>
            <div id="step4"></div>
           
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
    <script src="sbfiles/js/bootstrap.min.js"></script>

     <!--Metis Menu Plugin JavaScript--> 
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>
    <script>

 function showrashes(){
//       alert("called");
       
        if( document.getElementById("rashes") != null){
   var a = document.getElementById("rashes");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Present")) {
   
       if(document.getElementById("rashesdescription").type==("hidden")){
           
       document.getElementById("rashesdescription").type="text"; 
         document.getElementById("rashesdescription").required="true"; 
       document.getElementById("rasheslocation").type="text"; 
         document.getElementById("rasheslocation").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("rashesdescription").type==("text")){
           
       document.getElementById("rashesdescription").type="hidden";    
       document.getElementById("rashesdescription").value=""; 
       document.getElementById("rashesdescription").removeAttribute("required");
       
       document.getElementById("rasheslocation").type="hidden";    
       document.getElementById("rasheslocation").value=""; 
       document.getElementById("rasheslocation").removeAttribute("required");
       }}
       
   }}
 function showhospital(){
//     alert("hosi");
       
        if( document.getElementById("birthplace") != null){
   var a = document.getElementById("birthplace");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Hospital")) {
   
       if(document.getElementById("hospitalname").type==("hidden")){
           
       document.getElementById("hospitalname").type="text"; 
         document.getElementById("hospitalname").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("hospitalname").type==("text")){
           
       document.getElementById("hospitalname").type="hidden";    
       document.getElementById("hospitalname").value=""; 
       document.getElementById("hospitalname").removeAttribute("required");
       }}
       
   }}
 function showage(){
//       alert("called1");
       
        if( document.getElementById("siblingdeath") != null){
   var a = document.getElementById("siblingdeath");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Yes")) {
   
       if(document.getElementById("age").type==("hidden")){
           
       document.getElementById("age").type="text"; 
         document.getElementById("age").required="true"; 
       }
       if(document.getElementById("cause").type==("hidden")){
           
       document.getElementById("cause").type="text"; 
         document.getElementById("cause").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("age").type==("text")){
           
       document.getElementById("age").type="hidden";    
       document.getElementById("age").value=""; 
       document.getElementById("age").removeAttribute("required");
       }
       if(document.getElementById("cause").type==("text")){
           
       document.getElementById("cause").type="hidden";    
       document.getElementById("cause").value=""; 
       document.getElementById("cause").removeAttribute("required");
       }
   
}
       
   }}
 function showhospitalized(){
//       alert("called");
       
        if( document.getElementById("hospitalized") != null){
   var a = document.getElementById("hospitalized");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Yes")) {
 document.getElementById("hospitalizeddetails").innerHTML="<tr><td>If yes,specify </td></tr>\n\
 <tr><td>Date </td><td><input type=\"text\"  value=\"\" class=\"form-control\"  id=\"datepicker\"  onclick=\"getdate();\" name=\"DateHospitalized\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td>\n\
</tr><tr><td>Hospital admitted </td><td><input type=\"text\"  value=\"\" class=\"form-control\"  name=\"HospitalAdmitted\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td></tr>\n\
<tr><td>Diagnosis </td><td><input type=\"text\"  value=\"\" class=\"form-control\"  name=\"Diagnosis\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\" ></td></tr>";            
                  
}
   
else{ 
   
//    alert("no");
       
     document.getElementById("hospitalizeddetails").innerHTML="<td></td>" ;
}
       
   }}
 function showlymphnode(){
//      alert("A");
       
        if( document.getElementById("lymphnodes") != null){
   var a = document.getElementById("lymphnodes");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Palpable")) {
 document.getElementById("lymphlocation").innerHTML="<td>Lymph Node Location</td><td>\n\
<select class=\"form-control\"  name=\"lymphnodelocation\"  style=\"padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;\"  ><option value=\"\"></option><option value=\"Neck\">Neck</option><option value=\"Axilla\">Axilla</option><option value=\"Groin\">Groin</option></select></td>";               
}
   
else{ 
  document.getElementById("lymphlocation").innerHTML="<td></td>" ;
//    alert("no");
       
   
}
       
   }}
</script>

</body>
<script type="text/javascript" src="js/getGeneralExamination.js"></script>
           
                                       <script type="text/javascript">
                                                                     getGeneralDetails();
                                                               
                                                                 </script> 
</html>

