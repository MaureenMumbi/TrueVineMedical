/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//
//function getChildDetails(){
//     
//var regno = document.getElementById("regno").value;
////alert(regno);
////alert(regno1);
//var xmlhttp;    
//if (regno=="")
//{
////filter the districts    
//
//
//
//document.getElementById("childdetails").innerHTML="";
//return;
//}
//if (window.XMLHttpRequest)
//{// code for IE7+, Firefox, Chrome, Opera, Safari
//xmlhttp=new XMLHttpRequest();
//}
//else
//{// code for IE6, IE5
//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//}
//xmlhttp.onreadystatechange=function()
//{
//if (xmlhttp.readyState==4 && xmlhttp.status==200)
//{
//document.getElementById("childdetails").innerHTML=xmlhttp.responseText;
//
//
//
//}
//}
//xmlhttp.open("POST","getBasicDetails?regno="+regno,true);
//xmlhttp.send();
////call step 5 ajax
//
//
//
//getMumDetails()
//
//}//end of filter districts
//function getMumDetails(){
//     
//var regno = document.getElementById("regno").value;
////alert(regno);
////alert(regno1);
//var xmlhttp;    
//if (regno=="")
//{
////filter the districts    
//
//
//
//document.getElementById("childdetails").innerHTML="";
//return;
//}
//if (window.XMLHttpRequest)
//{// code for IE7+, Firefox, Chrome, Opera, Safari
//xmlhttp=new XMLHttpRequest();
//}
//else
//{// code for IE6, IE5
//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//}
//xmlhttp.onreadystatechange=function()
//{
//if (xmlhttp.readyState==4 && xmlhttp.status==200)
//{
//document.getElementById("childdetails").innerHTML=xmlhttp.responseText;
//
//
//
//}
//}
//xmlhttp.open("POST","getBasicDetails?regno="+regno,true);
//xmlhttp.send();
////call step 5 ajax
//
//
////getMtoUDetails();
////getvtoabdetails();
////resetAtoH();
////resetHtoL();
////resetMtoU();
//
// getDadDetails();
//
//}//end of filter districts
//function getDadDetails(){
//     
//var regno = document.getElementById("regno").value;
////alert(regno);
////alert(regno1);
//var xmlhttp;    
//if (regno=="")
//{
////filter the districts    
//
//
//
//document.getElementById("childdetails").innerHTML="";
//return;
//}
//if (window.XMLHttpRequest)
//{// code for IE7+, Firefox, Chrome, Opera, Safari
//xmlhttp=new XMLHttpRequest();
//}
//else
//{// code for IE6, IE5
//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//}
//xmlhttp.onreadystatechange=function()
//{
//if (xmlhttp.readyState==4 && xmlhttp.status==200)
//{
//document.getElementById("childdetails").innerHTML=xmlhttp.responseText;
//
//
//
//}
//}
//xmlhttp.open("POST","getBasicDetails?regno="+regno,true);
//xmlhttp.send();
//
//
//
//}//end of filter districts
// <script>
    //=================load existing data============
            
            
            function getChildDetails(){
                
                          
                       var regno = document.getElementById("regno").value;   
                       var PatientID = document.getElementById("PatientID").value;   
//                  alert(regno+"  nnnn "+PatientID);
                if(document.getElementById("regno").value!="" && document.getElementById("PatientID").value!=""){  
                
                    $.ajax({  
                        url:"getBasicDetails?regno="+regno+"&PatientID="+PatientID,  
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                    
                            document.getElementById("step1").innerHTML=data.step1;
                            document.getElementById("step2").innerHTML=data.step2;
                            document.getElementById("step3").innerHTML=data.step3;
                          
                            $("#DOB").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2020', dateFormat: 'dd/mm/yy'});
                       
                        
                        }}); 
                
                }//end of if
                
               
                
            }
            
            

       