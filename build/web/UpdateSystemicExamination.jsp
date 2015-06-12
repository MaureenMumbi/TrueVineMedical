<%-- 
    Document   : UpdateSystemicExamination
    Created on : Mar 2, 2015, 5:10:24 PM
    Author     : Maureen
--%>

<%-- 
    Document   : systemicexamination
    Created on : Nov 15, 2014, 3:52:41 PM
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
 <script src="js/jquery-1.7.2.js"></script>
<link href="styles/smart_wizard.css" rel="stylesheet" type="text/css">
<!--<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>-->
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
 <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<!-- <script src="js/jquery-1.7.2.js"></script>-->
<script src="js/jquery-ui-1.10.3.custom.js"></script>
<link href="css/tablecss.css" rel="stylesheet"/>
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
  <script>
  function addtotextarea(id){
      var problem=id+" \n";
      document.getElementById("problem").value+=problem;
      
  }
  </script>

  
  <script type="text/javascript">
    function showtextfield() {

   //document.getElementById("myCheck").checked = true;
   
   if( document.getElementById(mass) != null){
   var a = document.getElementById("mass");
   var v =a.options[a.selectedIndex].value;
   
if((v=="Palpable")) {
   
       if(document.getElementById("masslocation").type==("hidden")){
           
       document.getElementById("masslocation").type="text"; 
         document.getElementById("masslocation").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("masslocation").type==("text")){
           
       document.getElementById("masslocation").type="hidden";    
       document.getElementById("masslocation").value=""; 
       document.getElementById("masslocation").removeAttribute("required");
       }}
   }
    }
  </script>
  <script>
   function showtenderness(){
//       alert("called");
       
        if( document.getElementById("tenderness") != null){
   var a = document.getElementById("tenderness");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Present")) {
   
       if(document.getElementById("tendernesslocation").type==("hidden")){
           
       document.getElementById("tendernesslocation").type="text"; 
         document.getElementById("tendernesslocation").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("tendernesslocation").type==("text")){
           
       document.getElementById("tendernesslocation").type="hidden";    
       document.getElementById("tendernesslocation").value=""; 
       document.getElementById("tendernesslocation").removeAttribute("required");
       }}
       
   }}
   function showmovements(){
//       alert("called");
       
        if( document.getElementById("movements") != null){
   var a = document.getElementById("movements");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Abnormal")) {
   
       if(document.getElementById("movementsdescription").type==("hidden")){
           
       document.getElementById("movementsdescription").type="text"; 
         document.getElementById("movementsdescription").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("movementsdescription").type==("text")){
           
       document.getElementById("movementsdescription").type="hidden";    
       document.getElementById("movementsdescription").value=""; 
       document.getElementById("movementsdescription").removeAttribute("required");
       }}
       
   }}
   function showpower(){
//       alert("called");
       
        if( document.getElementById("power") != null){
   var a = document.getElementById("power");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Abnormal")) {
   
       if(document.getElementById("powerdescription").type==("hidden")){
           
       document.getElementById("powerdescription").type="text"; 
         document.getElementById("powerdescription").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("powerdescription").type==("text")){
           
       document.getElementById("powerdescription").type="hidden";    
       document.getElementById("powerdescription").value=""; 
       document.getElementById("powerdescription").removeAttribute("required");
       }}
       
   }}
   function showtone(){
//       alert("called");
       
        if( document.getElementById("tone") != null){
   var a = document.getElementById("tone");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Abnormal")) {
   
       if(document.getElementById("tonedescription").type==("hidden")){
           
       document.getElementById("tonedescription").type="text"; 
         document.getElementById("tonedescription").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("tonedescription").type==("text")){
           
       document.getElementById("tonedescription").type="hidden";    
       document.getElementById("tonedescription").value=""; 
       document.getElementById("tonedescription").removeAttribute("required");
       }}
       
   }}
   function showreflex(){
//       alert("called");
       
        if( document.getElementById("reflexes") != null){
   var a = document.getElementById("reflexes");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Reduced" || v=="Increased")) {
   
       if(document.getElementById("reflexdescription").type==("hidden")){
           
       document.getElementById("reflexdescription").type="text"; 
         document.getElementById("reflexdescription").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("reflexdescription").type==("text")){
           
       document.getElementById("reflexdescription").type="hidden";    
       document.getElementById("reflexdescription").value=""; 
       document.getElementById("reflexdescription").removeAttribute("required");
       }}
       
   }}
   function showmurmur(){
//       alert("called");
       
        if( document.getElementById("murmur") != null){
   var a = document.getElementById("murmur");
   var v =a.options[a.selectedIndex].value;
//   alert(v);
if((v=="Present")) {
   
       if(document.getElementById("murmurdescription").type==("hidden")){
           
       document.getElementById("murmurdescription").type="text"; 
         document.getElementById("murmurdescription").required="true"; 
       }}

   
else{ 
   
       if(document.getElementById("murmurdescription").type==("text")){
           
       document.getElementById("murmurdescription").type="hidden";    
       document.getElementById("murmurdescription").value=""; 
       document.getElementById("murmurdescription").removeAttribute("required");
       }}
       
   }}
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

<body>

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
                    <h1 class="page-header">SYSTEMIC EXAMINATION</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                        <form method="post" action="updateSystemic" class="form contact-form" >                                             
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
                   <small> Respiratory</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   Step 2<br />
                   <small> Cardiovascular</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-3" style="width: 252px;">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                   Step 3<br />
                   <small>Abdomen</small>
                </span>                   
                        </a></li>
                    <li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                   Step 4<br />
                   <small>Nervous</small>
                </span>                   
                        </a></li>
  		</ul>
                        <input type="hidden" value="<%= session.getAttribute("PatientID")%>" id="PatientID" name="PatientID" >
  			<div id="step-1"  style="height:520px; width:1000px;">	
            <h2 class="StepTitle">Respiratory Examination </h2>
       
		    <div id="step1">
                        
                        
                    </div>	
							<!--</form>-->

        </div>
                    <div id="step-2" style="height:400px; width:1200px;">
            <h2 class="StepTitle">Cardiovascular Examination</h2>
        <div id="step2"></div>
         
        </div>
  			  			<div id="step-3" style="height:700px; width:1000px;">
            <h2 class="StepTitle">Abdomen Examination  </h2>
            <h3> </h3>
             <div id="step3"></div>
        </div>
  			 			<div id="step-4" style="height:400px; width:1000px;">
            <h2 class="StepTitle">Nervous Examination</h2>
          
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



<script type="text/javascript" src="js/getSystemicExamination.js"></script>
           
                                       <script type="text/javascript">
                                                                     getSystemicDetails();
                                                               
                                                                 </script> 
</body>

</html>
