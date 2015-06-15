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
        $( ".date" ).datepicker({
                                dateFormat: "dd/mm/yy",
                                changeMonth: true,
                                changeYear: true,
                                yearRange:'1950:2036',
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
     
      function cleardate(){
     
     $("#invdate").val('');
     
 }
     
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
                    <h1 class="page-header">INVESTIGATIONS</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                                                                
                                                <table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td>
<!-- Smart Wizard -->
        <!--<h2>Example: Basic Wizard</h2>-->
                          <form method="post" action="updateinvestigations" class="form contact-form">
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
                        <h2 class="StepTitle">Step 1</h2>

                        <fieldset>
                            <h2> Fill all the fields shown</h2>
                            <div id="message"></div>
                            <div class="formRow" >
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <table style="margin-left: 150px; width:1000px;" id="invtable1" class="viewpdt">
                                                <td colspan="2"></td>


                                                <td><input type="hidden" required  value="Search.."  readonly style=" cursor:pointer;margin-left: 40px; text-transform:uppercase ; height: 18px; width:100px;text-align:center ; color:white ;background:coral; border-style:ridge ;" onclick="getAtoFDetails();"/> </td>
                                                <input type="hidden" name="patientid" value="<%=request.getParameter("regNo")%>"/>
                                                <tr>
                                                    <td style="text-align:left ;">Date: </td><td><input type='text' readonly  name='invdate' id='invdate' class='form-control date' style=' width: 160px;height:35px;'  ></td><td><button title ='clear date fields to blank' onclick="cleardate();" class="btn btn-default" type="button">
             <i class="fa fa-refresh" ></i>
</button></td>
                                                </tr>
                                                <tr>
                                                    <td style="text-align:left ;">Urinalysis and Microscopy </td><td><input type='text' name='urinalysis' class='form-control' style=' width: 160px;height:35px;' placeholder='in LB' ><td><i>LB</i></td>
                                                </tr>
                                                <tr> <td style="text-align:left ;">Stool Microscopy</th>  <td><input type='text' class='form-control'  style=' width: 160px;height:35px;' name='stoolmic' placeholder='Stool Microscopy' ></td>   
                                                </tr>
                                                <tr><td style="text-align:left ;">Stool Pylori</td> <td><select   class='form-control' style=' width: 160px;height:35px;' name='stoolpylori' placeholder='Stool Pylori' ><option value=''>select option</option>
                                                            <option value='positive'>Positive</option>
                                                            <option value='negative'>Negative</option></select></td>  </tr>
                                                <tr><td style="text-align:left ;">Blood Slide for Maliria Parasite</td><td><select   class='form-control' style=' width: 160px;height:35px;' name='malariaparasite' placeholder='Blood Slide for Malaria' ><option value=''>select option</option>
                                                            <option value='positive'>Positive</option>
                                                            <option value='negative'>Negative</option>
                                                        </select></td></tr>
                                                <tr><td style="text-align:left ;">Random Blood Sugar </td> <td> <input type='text' class='form-control' style=' width: 160px;height:35px;' name='rbs' id="rbs" Placeholder='use mmol/L'></td>
                                                </tr>




                                            </table>
                                        </div></div></div>

                            </div>
                        </fieldset>


        </div>
  			  			
  		
                    
                    <div id="step-2" style="height:400px; width:100%;">
                        <h2 class="StepTitle">Step 2</h2>

                        <table style="margin-left: 150px; width:1000px;" id="invtable2" class="viewpdt">
                            <tr><td style="text-align:left ;">(a)Total WBC Count </td><td> <input type='text'  name='wbccount' style=' width: 130px;height:35px;' id='wbccount'   /></td></tr>
                            <tr><td style="text-align:left ;">(b)Differential </td><td> <input type='text'  name='differential' style=' width: 130px;height:35px;' id='differential'   ></td></tr>
                            <tr><td style="text-align:left ;">(c) HB</td><td> <input type='text'name='hb' style=' width: 130px;height:35px;' id='hb' /> </td><td><i>g/dL</i></td></tr>
                            <tr><td style="text-align:left ;">(d)Peripheral Film </td><td> <input type='text'  name='peripheralfilm' style='width: 130px;height:35px;' id='periPheralFilm'   /></td></tr>
                            <tr><td style="text-align:left ;">(e)Inclusions</td><td><select  onchange="decideincdesc();"  style='width: 130px;height:35px;' name='inclusions' id="inclusions"  >
                                        <option value=''>select option</option>
                                        <option value='positive'>Positive</option><option value='negative'>Negative</option>
                                    </select></td></tr>
                            <tr><td style="text-align:left ;"><span id="incdesclabel"></span></td><td><textarea name="incdesc" id="incdesc" style="margin-left:322px ;" cols="40" rows="4" ></textarea></td></tr>                   
<tr>
</tr>
</table>
        </div>
                    
                    
        
                    <div id="step-3" style="height:550px; width:100%">
                        <h2 class="StepTitle">Step 3 </h2>
                        <table style="margin-left: 10px; width:1000px;" id="invtable2" class="viewpdt">
                            <tr>
                            </tr>
                            <tr><td style="text-align:left ;">LFTs  </td> <td><input type='text'  name='lft' style=' width: 130px;height:35px;' id='lft'   /></td> </tr>
                            <tr> <td style="text-align:left ;">Urea and Electrolytes </td> <td> <input type='text'  name='urea' style=' width: 130px;height:35px;' id='urea'   /></td></tr>
                            <tr> <td style="text-align:left ;">Thyroid Profile </td><td> <input type='text'  name='thyroid' style=' width: 130px;height:35px;' id='thyroid'   /></td></tr>
                            <tr> <td style="text-align:left ;">CTR </td> <td> <input type='text'  name='ctr' style=' width: 130px;height:35px;' id='ctr'   /></td></tr>
                            <tr><td style="text-align:left ;">Other X ray </td> <td> <input type='text'  name='xray' style=' width: 130px;height:35px;' id='xray'   /></td></tr>
                            <tr> <td style="text-align:left ;">Abdominal Ultra Sound </td>   <td> <input type='text'  name='ultrasound' style=' width: 130px;height:35px;' id='ultrasound'   /></td> </tr>
                            <tr><td style="text-align:left ;">CT scan brain </td> <td> <input type='text'  name='ctscanbrain' style=' width: 130px;height:35px;' id='ctscanbrain'   ></td></tr>
                            <tr> <td style="text-align:left ;">CT scan other </td> <td> <input type='text'  name='ctscanother' style=' width: 130px;height:35px;' id='ctscanother'   ></td>  </tr>
                            <tr> <td style="text-align:left ;">MRI </td><td> <input type='text'  name='mri' style=' width: 130px;height:35px;' id='mri'   ></td>   </tr>
                            <tr>
                            </tr>
                            </table>
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
  		$('#wizard').smartWizard();

      function onFinishCallback(){
        $('#wizard').smartWizard('showMessage','Finish Clicked');
        //alert('Finish Clicked');
      }
		});
                
                decideincdesc();
                
</script>


</body>

</html>
