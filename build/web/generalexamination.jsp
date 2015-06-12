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
//      
  var problem=id+" \n";
      document.getElementById("problem").value+=problem;  
      alert( document.getElementById("problem").value);


//<button onclick="document.getElementById('up7913').disabled=true;document.getElementById('down7913').disabled=false;" type="submit" class="positive" name="up7913" id="up7913">First</button>
//
//<button onclick="this.disabled=true;document.getElementById('up7913').disabled=false;" type="submit" class="negative" name="down7913" id="down7913">Second</button>
//  
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
                                    <%@include file="menu/menu.html" %>

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
                                 <form method="post" action="generalexamination" class="form contact-form" >
        
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">

                                                    
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
                <span class="stepDesc">
                   Step 3<br />
                   <small  style="font-size: 11px;">Present Complaints&Duration</small>
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
  			<div id="step-1"  style="height:520px; width:1500px;">	
            <h2 class="StepTitle">Child Birth History</h2>
		<fieldset>
                    <h2> Child's Birth History</h2>
		<div id="message"></div>
                <div class="formRow" >
                     <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                    <table style="width: 1100px;" class="viewpdt">
                        
                        <tr>
                            <td>Place of Birth</td><td>
                                <select name="birthplace" id="birthplace" onchange="showhospital();" class="form-control"  style="height:30px;" >
                                    <option value=""></option>  
                                    <option value="Home">Home</option>  
                                    <option value="Hospital">Hospital</option>  
                                </select>
                            </td>
                         
                                <td>
                                    <input type="hidden" class="form-control"   style="height:30px;" name="hospitalname" id="hospitalname" placeholder="Hospital Name " >
                                </td>
                              </tr>
                           <tr>  <td>Mode of Delivery</td>
                               <td>
                                   <select name="deliverymode" class="form-control"  style="height:30px;" >
                                    <option value=""></option>  
                                    <option value="CSection">Caesarian Section</option>  
                                    <option value="Normal">Normal</option>  
                                </select>
                               </td>
                        </tr>
                       
                        <tr>
                            <td>Birth Weight</td>
                            <td> 
                                 
                            
                                <input type="text" class="form-control"  style="height:30px;" name="birthweight">
                               
                            </td>
                            <td> <span class="input-group-addon" style="width: 20px; ">Kgs</span></td>
                        </tr>
                        <tr>
                            <td>Birth Number</td><td> <input type="text"  name="birthno"  class="form-control" style="height:30px;" id="birthno" ></td>
                            
                        </tr>
                        <tr>
                            <td>Has there been any sibling death?</td>
                            <td> 
                                <select name="siblingdeath" id="siblingdeath" class="form-control" onchange="showage()"  style="height:30px;" >
                                    <option value=""></option>  
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                </select>
                            </td>
                            
                        </tr>
                        <tr>
                            <td> <input type="hidden" class="form-control" placeholder="Enters Siblings Age" name="age" style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; height: 70px; width: 250px;" id="age" ></td>
                            <td> <input type="hidden" class="form-control" name="cause"   placeholder="Enters Death Cause"style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; height: 70px; width: 250px;" id="cause" ></td>
                            
                        </tr>
                    </table>
                                </div></div></div>
<!--	<div class="textField">Child Name<input type="text" name="contact-name" id="name" placeholder="Your name ..." /></div>	
	</div>
	<div class="formRow">
	<div class="textField"><input type="text" name="contact-email" id="email" placeholder="Your Email ..." /></div>
        </div>
	<div class="formRow">
	<div class="textField"><textarea cols="20" name="contact-comment" id="comment" rows="4" placeholder="Your Comment ..."></textarea></div>
	</div>
        <div class="formRow">
	<button class="btnSmall btn submit right">
	<span>Send Message</span>
	</button>-->
									</div>
								</fieldset>
							

        </div>
                    <div id="step-2" style="height:600px; width:1110px;">
            <h2 class="StepTitle">Past Medical History</h2>
          <table style=" width:300px; height: 250px;">
              <tr></tr>
                        <tr>
                            <td>Has the child has any longstanding medical problems?</td>
                          </tr>
                                                     <tr><td>
                                    <input  value="Epilepsy" class="btnSmall btn submit center" style="background-color: #cccccc; margin-bottom: 10px;" onclick="addtotextarea('Epilepsy');this.disabled=true">
				    <input value="Asthma" class="btnSmall btn submit center" style="background-color:#cccccc;margin-bottom: 10px;"  onclick="addtotextarea('Asthma');this.disabled=true">
				    <input  value="Diabetes" class="btnSmall btn submit center" style="background-color:#cccccc;margin-bottom: 10px;" onclick="addtotextarea('Diabetes');this.disabled=true">
				    <input value="Cerebral Palsy" class="btnSmall btn submit center" style="background-color:#cccccc;margin-bottom: 10px;" onclick="addtotextarea('Cerebral Palsy');this.disabled=true">
				    <input  value="Sickle Cell Disease" class="btnSmall btn submit center" style="background-color:#cccccc;margin-bottom: 10px;" onclick="addtotextarea('Sickle Cell Disease')">
				    <input value="Others" class="btnSmall btn submit center" style="background-color:#cccccc;margin-bottom: 10px;" onclick="addtotextarea('Others');">
				   
                                </td></tr>
                                                                 <br/>
                             <tr><td><textarea style="width: 658px; height: 133px;" id="problem" name="problem"></textarea></td></tr>
          </table>
            <br/>
            <table>
                <tr><td>Has the child ever been hospitalized?</td>
                    <td>
                        <select name="hospitalized" id="hospitalized" class="form-control" onchange="showhospitalized()"  style="height:30px;" >
                                    <option value=""></option>  
                                    <option value="Yes">Yes</option>  
                                    <option value="No">No</option>  
                                </select>
                        
                        
                    </td></tr>
                </table>
                <table id="hospitalizeddetails">
              
                </table>
            
         
        </div>
  			  			<div id="step-3" style="height:400px; width:1200px;">
            <h2 class="StepTitle">Present complaints and duration</h2>
            <h3>What are the present complaints and duration? </h3>
            <table style="padding-left: 300px;" class="viewpdt1">
                      
               <tr >
                   <td style="padding-left: 50px;">Fever</td>
               <td><input type="checkbox"  value="Fever" class="form-control" onclick="showfield(1);" id="complaints1" name="complaints1"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration1" name="duration1"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
              
               <td style="padding-left: 50px;">Restlessness </td>
               <td><input type="checkbox"  value="Restlessness" class="form-control" onclick="showfield(2);" id="complaints2" name="complaints2"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration2" name="duration2"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
              
               <td style="padding-left: 50px;">Headache </td>
               <td><input type="checkbox"  value="Headache" class="form-control" onclick="showfield(3);" id="complaints3" name="complaints3"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration3" name="duration3"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
              
               
               </tr>
               <tr>
               <td style="padding-left: 50px;">Cough</td><td><input type="checkbox"  value="Cough" class="form-control" onclick="showfield(4);" id="complaints4" name="complaints4"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration4" name="duration4"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Irritability</td><td><input type="checkbox"  value="Irritability" class="form-control" onclick="showfield(5);" id="complaints5" name="complaints5"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration5" name="duration5"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Abdominal Pains</td><td><input type="checkbox"  value="Abdominal Pains" class="form-control" onclick="showfield(6);" id="complaints6" name="complaints6"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration6" name="duration6"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               </tr>
               <tr>
               <td style="padding-left: 50px;">Vomiting</td><td><input type="checkbox"  value="Vomiting" class="form-control" onclick="showfield(7);" id="complaints7" name="complaints7"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration7" name="duration7"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Difficulty in Breathing</td><td><input type="checkbox"  value="Difficulty in Breathing" class="form-control" onclick="showfield(8);" id="complaints8" name="complaints8"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration8" name="duration8"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Body Aches </td><td><input type="checkbox"  value="Body Aches" class="form-control" onclick="showfield(9);" id="complaints9" name="complaints9"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration9" name="duration9"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               </tr>
               <tr>
               <td style="padding-left: 50px;">Diarrhea</td><td><input type="checkbox"  value="Diarrhea" class="form-control" onclick="showfield(10);" id="complaints10" name="complaints10"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration10" name="duration10"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Convulsions</td><td><input type="checkbox"  value="Convulsions" class="form-control" onclick="showfield(11);" id="complaints11" name="complaints11"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration11" name="duration11"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Joint Pain</td><td><input type="checkbox"  value="Joint Pain" class="form-control" onclick="showfield(12);" id="complaints12" name="complaints12"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration12" name="duration12"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               </tr>
               <tr>
               <td style="padding-left: 50px;">Swelling</td><td><input type="checkbox"  value="Swelling" class="form-control" onclick="showfield(13);" id="complaints13" name="complaints13"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration13" name="duration13"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Growth </td><td><input type="checkbox"  value="Growth" class="form-control" onclick="showfield(14);" id="complaints14" name="complaints14"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration14" name="duration14"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               <td style="padding-left: 50px;">Yellow Eyes </td><td><input type="checkbox"  value="Yellow Eyes" class="form-control" onclick="showfield(15);" id="complaints15" name="complaints15"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration15" name="duration15"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" ></td>
               
               </tr>
               <tr>
                   <td style="padding-left: 50px;">Other </td><td><input type="checkbox"  value="Other" class="form-control" onclick="showfield(16);" id="other16" name="Others"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 50px;" ></td>
               
                
               <td><input type="hidden"  value="" class="form-control"  id="complaint16" name="complaint16"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;" placeholder="complaint..." ></td>
               <td><input type="hidden"  value="" class="form-control"  id="duration16" name="duration16"  style="padding-bottom: 10px; margin-bottom: 10px;  margin-left: 25px; width: 100px;"  placeholder="duration..."></td>
               </tr>
                   
                 
                    </table>
        </div>
  			 			<div id="step-4" style="height:700px; width:1110px;">
            <h2 class="StepTitle">Findings on examination</h2>
          
           <table style="padding-left: 300px;" class="viewpdt">
               <tr></tr>        
               <tr>
                            <td>Nutritional Status</td><td>
                                <select class="form-control"  name="nutritionalstatus"   style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Good">Good</option>
                                    <option value="Underweight">Underweight</option>
                                    <option value="Obvious Malnutrition">Obvious Malnutrition</option>
                                    <option value="Overweight">Overweight</option>
                                    <option value="Obese">Obese</option>
                                </select>
                                </td>
                              </tr>
                            
                              <tr> <td>General Condition or Appearance?</td><td>
                                <select class="form-control"  name="generalcondition"   style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Good">Good</option>
                                    <option value="Fair">Fair</option>
                                    <option value="Poor">Poor</option>
                                   
                                </select>
                                
                                </td>
                                   <td class="help-block"  style="height:30px;">(If Poor Admit child)</td>   
                              </tr>
                              <tr>
                                  <td>Dyspnea</td><td><input type="text"  class="form-control" name="Dyspnea"   style="height:30px;"></td>
                              </tr>
                              <tr>
                                  <td>Tachypnea</td><td><input type="text"  class="form-control" name="Tachypnea"   style="height:30px;"></td>
                              </tr>
                <tr> <td>Dehydration?</td><td>
                                <select class="form-control"  name="dehydration"   style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Present">Present</option>
                                    <option value="Absent">Absent</option>
                                 </select>
                                </td>
                              </tr>
                       <tr>
                           <td>Temperature</td><td><input type="text"  class="form-control" name="Temperature"   style="height:30px;"></td>
                        </tr>
                          <tr> <td>Jaundice</td><td>
                                <select class="form-control"  name="Jaundice"   style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Present">Present</option>
                                    <option value="Absent">Absent</option>
                                 </select>
                                </td>
                              </tr>
                          <tr> <td>Lymph Nodes</td><td>
                                  <select class="form-control"  name="lymphnodes" id="lymphnodes" onchange="showlymphnode()"  style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Palpable">Palpable</option>
                                    <option value="Not Palpable">Not Palpable</option>
                                 </select>
                                </td>
                              </tr>
                          <tr id="lymphlocation">
                              
                              </tr>
                          <tr> <td>Face Oedema</td><td>
                                <select class="form-control"  name="faceoedema"   style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Present">Present</option>
                                    <option value="Absent">Absent</option>
                                   
                                 </select>
                                </td>
                              </tr>
                       
                          <tr> <td>Pitting Leg Oedema</td><td>
                                <select class="form-control"  name="pittinglegoedema"   style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Present">Present</option>
                                    <option value="Absent">Absent</option>
                                   
                                 </select>
                                </td>
                              </tr>
                          <tr> <td>Rashes</td><td>
                                  <select class="form-control"  name="rashes" id="rashes" onchange="showrashes()"  style="height:30px;"  >
                                    <option value=""></option>
                                    <option value="Present">Present</option>
                                    <option value="Absent">Absent</option>
                                   
                                 </select>
                                </td>
                          </tr>
                          <tr>
                                 <td><input type="hidden"  class="form-control"  name="rashesdescription" id="rashesdescription" placeholder="Rashes Description...."  style="height:30px;"></td>
                                 <td><input type="hidden"  class="form-control"  name="rasheslocation" id="rasheslocation" placeholder="Rashes Location...."  style="height:30px;"></td>
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
//       alert("called");
       
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
//       alert("called");
       
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
<link href="css/tablecss.css" rel="stylesheet"/>
</body>

</html>
