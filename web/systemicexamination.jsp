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
 
        $( ".datepicker" ).datepicker({
                                dateFormat: "yy/mm/dd",
                                changeMonth: true,
                                changeYear: true
                               
                               
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

            <%@include file="menu/minimenu.html" %>
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
                        <form method="post" action="SystemicExamination" class="form contact-form" >                                             
                                             
                              <%
String PatientID="";
if(request.getParameter("PatientID")!=null && !request.getParameter("PatientID").equals("")){
PatientID=request.getParameter("PatientID") ; }
else{
if(session.getAttribute("PatientID")!=null){
                  PatientID= (String) session.getAttribute("PatientID");
             }
}                   

%>        
                     <input type="hidden" value="<%=PatientID%>" name="PatientID">
                            
                            
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
  			<div id="step-1"  style="height:520px; width:1500px;">	
            <h2 class="StepTitle">Respiratory Examination </h2>
       
		<fieldset>
                    <!--<h2> Fill all fields</h2>-->
		<div id="message"></div>
                <div class="formRow" >
                     <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                    <table style="padding-left: 300px;" class="viewpdt">
                         <tr>
                            <td>Date </td><td> <input type="text"  name="dateRegistered"  style="height:30px;" id="dateRegistered" class="datepicker" Placeholder="dd/mm/yyyy"></td>
                            
                        </tr>
                        <tr>
                            <td>Air Entry Left Lung Fields</td><td>
                                <select name="airentryleft" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Good">Good</option>  
                                    <option value="Poor">Poor</option>  
                                    <option value="Absent">Absent</option>  
                                </select>
                            </td>
                         </tr>
                          <tr> <td>Air Entry Right Lung Fields</td>
                                <td>
                                  <select name="airentryright" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Good">Good</option>  
                                    <option value="Poor">Poor</option>  
                                    <option value="Absent">Absent</option>  
                                </select>
                                </td>
                              </tr>
                           <tr>  <td>Rales Left</td>
                               <td>
                                   <select name="ralesleft" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                        </tr>
                           <tr>  <td>Rales Right</td>
                               <td>
                                   <select name="ralesright" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                        </tr>
                           <tr>  <td>Rhonchi Left</td>
                               <td>
                                   <select name="rhonchileft" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                        </tr>
                           <tr>  <td>Rhonchi Right</td>
                               <td>
                                   <select name="rhonchiright" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                        </tr>
                       
                      
                    </table>
                                </div></div></div>
						</div>
								</fieldset>
							<!--</form>-->

        </div>
                    <div id="step-2" style="height:400px; width:1110px;">
            <h2 class="StepTitle">Cardiovascular Examination</h2>
          <table style=" width:300px;" class="viewpdt">
                   <tr>  <td>Heart Sounds</td>
                               <td>
                                   <select name="heartsounds" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Normal">Normal</option>  
                                    <option value="Abnormal">Abnormal</option>  
                                </select>
                               </td>
                        </tr>
                           <tr>  <td>Murmur</td>
                               <td>
                                   <select name="murmur" class="form-control" id="murmur" onchange="showmurmur();" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                               <td><input type="hidden" name="murmurdescription" value=""  placeholder="Murmur Description ..." id="murmurdescription" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px; height:30px;"></td>
                           </tr>
                       
                       
                           <tr>  <td>Heart Size</td>
                               <td>
                                   <select name="heartsize" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Normal">Normal</option>  
                                    <option value="Abnormal">Abnormal</option>  
                                </select>
                               </td>
                        </tr>
                       
          
          
                </table>
         
        </div>
  			  			<div id="step-3" style="height:700px; width:1200px;">
            <h2 class="StepTitle">Abdomen Examination  </h2>
            <h3> </h3>
            <table style="padding-left: 300px;" class="viewpdt">
                      
                <tr>  <td>Distention</td>
                               <td>
                                   <select name="distention" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                        </tr>
                <tr>  <td>Specify Distention</td>
                               <td>
                                   <select name="distentiondescription" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Uniform">Uniform</option>  
                                    <option value="Irregular">Irregular</option>  
                                </select>
                               </td>
                        </tr>
                           <tr>  <td>Bowel Sounds</td>
                               <td>
                                   <select name="bowelsounds" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                        </tr>
                         
                        <tr>  <td>Mass</td>
                               <td>
                                   <select name="mass" id="mass" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Palpable">Palpable</option>  
                                    <option value="Not Palpable">Not Palpable</option>  
                                </select>
                               </td>
                        </tr>
                           <tr>  <td>Palpable Mass Location</td>
                               <td>
                                   <select name="masslocation"  id="masslocation" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Epigastrium">Epigastrium</option>  
                                    <option value="Right Hypochondrium">Right Hypochondrium</option>  
                                    <option value="Right Lumbar">Right Lumbar</option>  
                                    <option value="Right Iliac Fosa">Right Iliac Fosa</option>  
                                    <option value="Hypogastrium">Hypogastrium</option>  
                                    <option value="Left Hypochondrium">Left Hypochondrium</option>  
                                    <option value="Left Lumbar">Left Lumbar</option>  
                                    <option value="Left Iliac Fosa">Left Iliac Fosa</option>  
                                </select>
                               </td>
                        </tr>
                         <tr>  <td>Tenderness</td>
                               <td>
                                   <select name="tenderness" id="tenderness" onchange="showtenderness();" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Absent">Absent</option>  
                                    <option value="Present">Present</option>  
                                </select>
                               </td>
                               
                               <td> <input type="hidden" name="tendernesslocation" value="" id="tendernesslocation" placeholder="Tenderness Location ......"  class="form-control" style="padding-bottom: 10px; margin-bottom: 10px; height:30px; margin-left: 25px; width: 350px;"> 
                               </td>
                        </tr>
                        
                        
                   <tr>  <td>Liver</td>
                               <td>
                                   <select name="liver" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Palpable">Palpable</option>  
                                    <option value="Not Palpable">Not Palpable</option>  
                                </select>
                               </td>
                               <td><input type="text" name="liversize" value="" id="liversize"  class="form-control" style="padding-bottom: 10px; height:30px; margin-bottom: 10px;  margin-left: 25px; width: 50px;"></td><td> <span class="input-group-addon"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px;">CM</span></td>
                        </tr>
                      
            
                          <tr>  <td>Left Kidney</td>
                               <td>
                                   <select name="leftkidney" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Palpable">Palpable</option>  
                                    <option value="Not Palpable">Not Palpable</option>  
                                </select>
                               </td>
                        </tr>
            
                          <tr>  <td>Right Kidney</td>
                               <td>
                                   <select name="rightkidney" class="form-control" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;" >
                                    <option value=""></option>  
                                    <option value="Palpable">Palpable</option>  
                                    <option value="Not Palpable">Not Palpable</option>  
                                </select>
                               </td>
                        </tr>
                    </table>
        </div>
  			 			<div id="step-4" style="height:400px; width:1110px;">
            <h2 class="StepTitle">Nervous Examination</h2>
          
           <table style="padding-left: 300px;" class="viewpdt">
               <tr></tr>        
               <tr>
                            <td>State of consciousness</td><td>
                                <select class="form-control"  name="consciousness"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;"  >
                                    <option value=""></option>
                                    <option value="Fully Conscious">Fully Conscious</option>
                                    <option value="Drowsy">Drowsy</option>
                                    <option value="Unconscious">Unconscious</option>
                                   
                                </select>
                                </td>
                              </tr>
                            
                              <tr> <td>Movements</td><td>
                                      <select class="form-control"  name="movements"  id="movements" onchange="showmovements();" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;"  >
                                    <option value=""></option>
                                    <option value="Normal">Normal</option>
                                    <option value="Abnormal">Abnormal</option>
                                    
                                </select>
                                </td>
                                <td><input type="hidden"  class="form-control" name="movementsdescription"  placeholder="Movements Description..." id="movementsdescription" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px; height:30px;"></td>
                              </tr>
                             
                <tr> <td>Power</td><td>
                                <select class="form-control"  name="power"  id="power" onchange="showpower();" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;"  >
                                    <option value=""></option>
                                    <option value="Normal">Normal</option>
                                    <option value="Abnormal">Abnormal</option>
                                 </select>
                                </td>
                                <td><input type="hidden"  class="form-control" name="powerdescription" placeholder="Power Description..." id="powerdescription"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px; height:30px;"></td>
                        </tr>
                      
                          
                <tr> <td>Tone</td><td>
                                <select class="form-control"  name="tone"  id="tone" onchange="showtone();" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;"  >
                                    <option value=""></option>
                                    <option value="Normal">Normal</option>
                                    <option value="Abnormal">Abnormal</option>
                                 </select>
                                </td>
                                 <td><input type="hidden"  class="form-control" name="tonedescription" id="tonedescription" placeholder="Tone description...." style="padding-bottom: 10px; margin-bottom: 10px; height:30px; margin-left: 25px; width: 350px; height:30px;"></td>
                        
                              </tr>
                      
                          <tr> <td>Reflexes</td><td>
                                <select class="form-control"  name="reflexes" id="reflexes" onchange="showreflex();"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px;"  >
                                    <option value=""></option>
                                    <option value="Normal">Normal</option>
                                    <option value="Reduced">Reduced</option>
                                    <option value="Increased">Increased</option>
                                 </select>
                                </td>
                                <td><input type="hidden"  class="form-control"  name="reflexdescription" id="reflexdescription" placeholder="Reflex Description...." style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 350px; height:30px;"></td>
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
    <script src="sbfiles/js/bootstrap.min.js"></script>

     <!--Metis Menu Plugin JavaScript--> 
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>




</body>

</html>
