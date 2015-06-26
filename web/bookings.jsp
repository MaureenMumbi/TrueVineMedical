<%-- 
    Document   : manageforms
    Created on : Feb 2, 2015, 7:35:02 PM
    Author     : Maureen
--%>

<%@page import="java.text.Format"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%-- 
    Document   : viewChildDetails
    Created on : Nov 18, 2014, 9:01:14 PM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@page import="DBCONNECT.dbConnect"%>

<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<%!
  dbConnect conn =  new dbConnect();
  %>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Truevine Medical System</title>

    <!-- Bootstrap Core CSS -->
    <link href="sbfiles/css/bootstrap.min.css" rel="stylesheet">
<link rel="shortcut icon" href="images/truevine.png"/>
    <!-- MetisMenu CSS -->
    <link href="sbfiles/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="sbfiles/css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="sbfiles/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="sbfiles/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="sbfiles/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    
        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
<!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
<script src="scripts/jquery.validate.js" type="text/javascript"></script>
<link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />

        
          <script type="text/javascript" src="js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<script type="text/javascript" src="js/noty/themes/default.js"></script>
        
		<script type="text/javascript">
			$(document).ready( function () {
				$('#example').dataTable().makeEditable({
                                  
									
                                                                        sUpdateURL: "UpdateKnowledge",
                                                                        sAddURL: "AddKnowledgeCode",
                                                                        sDeleteURL: "DeleteKnowledgeCode",
                    							"aoColumns": [ null,                  									
                    									
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving...',
                                                            					tooltip: 'Click to edit ',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									},
                    									{
                									        event: 'mouseover',
                                                                                                indicator: 'Saving ...',
                                                            					tooltip: 'Click to edit ',
												type: 'textarea',
                                                 						submit:'Save changes',
                                                                                                callback : function(value, settings)
                                                                                                                        { 
                                                                                                                            alert(value);
                                                                                                                            window.location.reload();
                                                                                                                        
                                                                                                                        },
												fnOnCellUpdated: function(sStatus, sValue, row, column, settings){
													alert("(Cell Callback): Cell["+row+","+column+"] is updated with value " + sValue);
												}
                    									}
//                    									
											]									

										});
				
			} );
		</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-17838786-2']);
  _gaq.push(['_trackPageview']);

  
</script>

<script type="text/javascript">
function openwindow(){
    
  var page = document.getElementById("pages").value;
  
        window.open(page);
  
}

</script>
</head>

<body>

    <%if (session.getAttribute("invmsgupd") != null) {%>
                                    <script type="text/javascript"> 
                    
                        var n = noty({text: '<%=session.getAttribute("invmsgupd")%> Click to close.',
                            layout: 'top',
                            type: 'Success', 
                             timeout: 1200});
                    
                                    </script> <%
                        session.removeAttribute("invmsgupd");
                    }

                    %>
 <!--------------------------------------------------------->   
    <%if (session.getAttribute("disposaleditmsg") != null) {%>
                                    <script type="text/javascript"> 
                    
                        var n = noty({text: '<%=session.getAttribute("disposaleditmsg")%> Click to close.',
                            layout: 'top',
                            type: 'Success', 
                             timeout: 1300});
                    
                                    </script> <%
                        session.removeAttribute("disposaleditmsg");
                    }

                    %>
    
  <!--------------------------------------------------------------->  
    <%if (session.getAttribute("updtreatmentmsg") != null) {%>
                                    <script type="text/javascript"> 
                    
                        var n = noty({text: '<%=session.getAttribute("updtreatmentmsg")%>. Click to close.',
                            layout: 'top',
                            type: 'Success', 
                             timeout: 1400});
                    
                                    </script> <%
                        session.removeAttribute("updtreatmentmsg");
                    }

                    %>
    
  <!--------------------------------------------------------------->  
  
  
  
  
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="index.html">Bookings</a>
            </div>
            <!-- /.navbar-header -->
                    <%@include file="menu/minimenu.html" %>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                   <%@include file="menu/menu.jsp" %>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
 <%
  
  Format formatter = new SimpleDateFormat("yyyy/MM/dd");
                    String mdate;

                    Date mydate = new Date();
                    mdate = formatter.format(mydate);
                        
  
  
  %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Expected Visitors For Date  <%=mdate%></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <% int a=0;%>
            
            <form method="post" action="storeParameters">
              <table id="example" class="display">
		           <thead>
		           <tr>
		           <th>FIRST NAME</th>
                           <th>MIDDLE NAME</th>
                           <th>LAST NAME </th>
                           <th>REG. NO</th>
                           <th>TREATMENT DATE</th>
                           <th>NEXT VISIT DATE </th>                           
                           <th>TREATMENT/PRESCRIPTION </th>                           
                           </tr>
		                
		            </thead>
		            <tbody>
                          <% String getTreatment="select treatment.PatientID as PatientID , treatment ,Prescription,treatmentdate ,nextvisitdate from treatment left join investigations on investigations.patientID=treatment.PatientID and treatment.treatmentdate=investigations.date where nextvisitdate='"+mdate+"'";
                                    
                          
                          conn.rs2 = conn.state1.executeQuery(getTreatment);
                                     while(conn.rs2.next()){

                            a++;
                         String query = "select * from basicdetails where PatientID='"+conn.rs2.getString("PatientID")+"'";
                                     conn.rs = conn.state.executeQuery(query); 

                                        while(conn.rs.next())
                                        {
                                         %>       
                        

                           <tr id="<%= conn.rs.getString("RegNo")%>">
                                    <td> <%= conn.rs.getString("FName")%> </td>
                                    <td><%= conn.rs.getString("SName")%></td>
                                    <td><%= conn.rs.getString("LName")%></td>
                                    <td><%= conn.rs.getString("RegNo")%></td>
                                                                    
                                    
                                  
                                <td>  <%= conn.rs2.getString("treatmentdate")%>  </td>
                                <td>  <%= conn.rs2.getString("nextvisitdate")%>  </td>
                                <td>  <%= conn.rs2.getString("treatment") +" <br/>"+ conn.rs2.getString("Prescription")%>  </td>
                                
                              
                                    <td>
                                       </td>
                            <input type="hidden" name="Regno" value="<%= conn.rs.getString("RegNo")%>">   
                            <input type="hidden" name="PatientID" value="<%= conn.rs.getString("PatientID")%>">   
                           
                            </tr>
                                      <%
                                                                           }
                                   }
%>
                              		         
</tbody>
		        </table>
              <input type="hidden" id="lastselected" > 
            </form>
    </div>
    <!-- /#wrapper -->
    </div>
    <!-- jQuery Version 1.11.0 -->
    <!--<script src="sbfiles/js/jquery-1.11.0.js"></script>-->

    <!-- Bootstrap Core JavaScript -->
    <script src="sbfiles/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="sbfiles/js/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="sbfiles/js/plugins/morris/raphael.min.js"></script>
    <script src="sbfiles/js/plugins/morris/morris.min.js"></script>
    <script src="sbfiles/js/plugins/morris/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="sbfiles/js/sb-admin-2.js"></script>

    <script>
        
        
              function enablesubmit(id){
          var no=id;      
               if (!$("#pages"+id+" option:selected").length) {
   
    document.getElementById("submit"+id).disabled=true;
  }
  else {
   document.getElementById("submit"+id).disabled=false;    
           
            
            
  }
 
       var prevno=document.getElementById("lastselected").value;   
          //   alert(document.getElementById("lastselected").value+"__"+id);
  //check for the selected element
if(document.getElementById("lastselected").value!==id){
      //unselect the previous if its not blank
  if(document.getElementById("lastselected").value!==""){
$("#pages"+prevno).attr("selected",false);

for (var i=0; i<document.getElementById("pages"+prevno).options.length; i++)
{
if (document.getElementById("pages"+prevno).options[i].selected == true)
{
document.getElementById("pages"+prevno).options[i].selected = false;

}
} 
//also disable button
document.getElementById("submit"+prevno).disabled=true;          
      }
      else {
    
      }
      document.getElementById("lastselected").value=id;  
  }
     
  
}
  
    </script>
    
    
</body>

</html>
