<%-- 
    Document   : ViewNextPatient
    Created on : Jun 12, 2015, 12:28:14 PM
    Author     : Maureen
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
             <%@include file="menu/minimenu.jsp" %>

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
                    <h1 class="page-header">VIEW CHILDREN</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
             <%if (session.getAttribute("patientadded") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("patientadded")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("patientadded");
                            }

                        %> 
              <table id="example" class="display">
		            <thead>
		            <tr>
		           <th>PATIENT ID</th>
                           <th>FULL NAME</th>
                           <th> WEIGHT  </th>
                           <th> TEMPERATURE </th>
                           <th> BP </th>
                         </tr>
		                
		            </thead>
		            <tbody>
                       
                  
                        
    
    %>       
                         <% 
            
                         String getTodaysPatient="SELECT * FROM todayspatient WHERE TO_DAYS(timestamp)=TO_DAYS(NOW()) ORDER BY ID ";
                         conn.rs2 = conn.state2.executeQuery(getTodaysPatient);
                         while(conn.rs2.next()){
                         String query = "select * from basicdetails WHERE patientID='"+conn.rs2.getString("PatientID")+"'";
                                     conn.rs = conn.state.executeQuery(query); 

                                        while(conn.rs.next())
                                        {
                                     String child= conn.rs.getString("FName")+" "+conn.rs.getString("SName")+" "+ conn.rs.getString("LName");
                                         System.out.println("aaa"+child);
                                            
                                         %>       
                        

                           <tr id="<%= conn.rs.getString("RegNo")%>">
                                     <td><%= conn.rs.getString("RegNo")%></td>
                                    <td> <%= conn.rs.getString("FName")+" "+conn.rs.getString("SName") +" "+conn.rs.getString("LName")%> </td>
                                    <td><%= conn.rs2.getString("Weight") %></td>
                                    <td><%= conn.rs2.getString("temperature") %></td>
                                     <td><%= conn.rs2.getString("bp")%></td>
                                    <td>
                                  <select  onchange="opennewpage(this);"  id="pages">
                                            <option value="">Select Page</option>
               <% if(session.getAttribute("level")!=null){
                    if(session.getAttribute("level").toString().equals("Receptionist")){%>
              <option value="financialtransaction.jsp?PatientID=<%=conn.rs.getString("PatientID")%>">Financial Transaction</option>
             
            <%  }
              else{%>
              
              <option value="generalexamination.jsp?PatientID=<%=conn.rs.getString("PatientID")%>">General Examination</option>
              <option value="systemicexamination.jsp?PatientID=<%=conn.rs.getString("PatientID")%>">Systemic Examination</option>
              <option value="investigations.jsp?regNo=<%=conn.rs.getString(1)%>">Investigations</option>
              <!--<option value="visits.jsp?regNo=<%=conn.rs.getString(1)%>">Visits</option>-->
              <option value="visits.jsp?name=<%=child%>&age=<%=conn.rs.getString("age")%>&regNo=<%=conn.rs.getString("PatientID")%>">Follow ups and revisits</option>
             <option value="treatment.jsp?name=<%=child%>&age=<%=conn.rs.getString("age")%>&regNo=<%=conn.rs.getString("PatientID")%>">Treatment</option>
             <option value="Disposal.jsp?name=<%=child%>&regNo=<%=conn.rs.getString("PatientID")%>">Disposal</option>
           <%
                     }} 
         %>
                                        </select></td>
                                    
                            </tr>
                                      <%
                                                                   }  }                           
                                                  
%>
                                
		            </tbody>
		        </table>
 

    </div>
    <!-- /#wrapper -->
    </div>
    <!-- jQuery Version 1.11.0 -->
    <!--<script src="sbfiles/js/jquery-1.11.0.js"></script>-->

    <!-- Bootstrap Core JavaScript -->
   

</body>

</html>
