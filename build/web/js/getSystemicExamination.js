/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


            
            function getSystemicDetails(){
                
                          
                       
                       var PatientID = document.getElementById("PatientID").value;   
//                  alert(regno+"  nnnn "+PatientID);
                if(document.getElementById("PatientID").value!=""){  
                
                    $.ajax({  
                        url:"getSystemicExamination?PatientID="+PatientID,  
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                    
                            document.getElementById("step1").innerHTML=data.step1;
                            document.getElementById("step2").innerHTML=data.step2;
                            document.getElementById("step3").innerHTML=data.step3;
                            document.getElementById("step4").innerHTML=data.step4;
                          
                            $("#DOB").datepicker({changeMonth: true, changeYear: true, yearRange: '2008:2020', dateFormat: 'dd/mm/yy'});
                       
                        
                        }}); 
                
                }//end of if
                
               
                
            }
            
            

       