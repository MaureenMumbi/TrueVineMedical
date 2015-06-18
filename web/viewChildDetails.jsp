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

<script>
    
 

            function opennewpage(ur){
            
        var pg=ur.value;
        
        if(pg!==""){
            
            window.open(pg)
        }
                             
                
                    
            
            }
            
            
            
      
                    
             
            
            
  
  </script>
  <script type="text/javascript" src="js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<script type="text/javascript" src="js/noty/themes/default.js"></script>

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
                    <h1 class="page-header">VIEW CHILDREN</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
             <%if (session.getAttribute("patientadded") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("patientadded")%> . Click here to close',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("patientadded");
                            }

                        %> 
                        
                        
                
                         <%if (session.getAttribute("investdatasaved") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("investdatasaved")%>. Click here to close',
                        layout: 'center',
                        type: 'Success', 
                         timeout: 1800});
                    
                </script> <%
                session.removeAttribute("investdatasaved");
                            }

                        %> 
                        
                        
                              <%if (session.getAttribute("treatmentmsg") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("treatmentmsg")%>. Click here to close',
                        layout: 'center',
                        type: 'Success', 
                         timeout: 1800});
                    
                </script> <%
                session.removeAttribute("treatmentmsg");
                            }

                        %> 
                        
                        
                        
                             <%if (session.getAttribute("disposalmsg") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("disposalmsg")%>. Click here to close',
                        layout: 'center',
                        type: 'Success', 
                         timeout: 1800});
                    
                </script> <%
                session.removeAttribute("disposalmsg");
                            }

                        %> 
                        
                        
                            <form method="post" action="storeParameters">
              <table id="example" class="display">
		            <thead>
		            <tr>
		           <th>FIRST NAME</th>
                           <th>MIDDLE NAME</th>
                           <th> LAST NAME </th>
                           <th> REGNO </th>
                           <th> AGE </th>
                           <th> SECTION </th>
                            </tr>
		                
		            </thead>
		            <tbody>
                                
                         <% 
                         String query = "select * from basicdetails";
                                     conn.rs = conn.state.executeQuery(query); 
int count=1;
                                        while(conn.rs.next())
                                        {
                                     String child= conn.rs.getString("FName")+" "+conn.rs.getString("SName")+" "+ conn.rs.getString("LName");
                                         System.out.println("aaa"+child);
                                            
                                         %>       
                        

                           <tr id="<%= conn.rs.getString("RegNo")%>">
                                    <td> <%= conn.rs.getString("FName")%> </td>
                                    <td><%= conn.rs.getString("SName")%></td>
                                    <td><%= conn.rs.getString("LName")%></td>
                                    <td><%= conn.rs.getString("RegNo")%></td>
                                    <td><%= conn.rs.getString("Age")%></td>
                                    <td>
                                  <!--<select  onchange="opennewpage(this);"  id="pages" multiple>-->
                                    <select onclick="enablesubmit('<%=count%>');" id="pages<%=count%>" name="forms" style='height:130px;width:100%;' multiple>    
                                            <option value="">Select Page</option>
                                             <% if(session.getAttribute("level")!=null){
                    if(session.getAttribute("level").toString().equals("Receptionist")){%>
              <option value="NextPatient.jsp?PatientID=<%=conn.rs.getString("PatientID")%>&Name=<%=child%>">Revisit Details</option>
              <option value="financialtransaction.jsp?PatientID=<%=conn.rs.getString("PatientID")%>">Financial Transaction</option>
              <%}else{%>
              <option value="generalexamination.jsp?PatientID=<%=conn.rs.getString("PatientID")%>">General Examination</option>
              <option value="systemicexamination.jsp?PatientID=<%=conn.rs.getString("PatientID")%>">Systemic Examination</option>
              <option value="investigations.jsp?regNo=<%=conn.rs.getString(1)%>">Investigations</option>
              <!--<option value="visits.jsp?regNo=<%=conn.rs.getString(1)%>">Visits</option>-->
              <option value="visits.jsp?name=<%=child%>&age=<%=conn.rs.getString("age")%>&regNo=<%=conn.rs.getString("PatientID")%>">Follow ups and revisits</option>
             <option value="treatment.jsp?name=<%=child%>&age=<%=conn.rs.getString("age")%>&regNo=<%=conn.rs.getString("PatientID")%>">Treatment</option>
             <option value="Disposal.jsp?name=<%=child%>&regNo=<%=conn.rs.getString("PatientID")%>">Disposal</option>
              <%}}%>
                                        </select></td>
                                         <td> <input type="submit" disabled id="submit<%=count%>" value="NEXT" name="submit"> </td>
                                    
                            </tr>
                                      <%
                                             count++;
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
