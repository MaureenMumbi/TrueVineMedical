/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

   $(document).ready(function(){
    	// Smart Wizard     	
  		$('#wizard').smartWizard({transitionEffect:'slideleft',onLeaveStep:leaveAStepCallback,onFinish:onFinishCallback,enableFinishButton:true});

      function leaveAStepCallback(obj){
        var step_num= obj.attr('rel');
        return validateSteps(step_num);
      }
      
      function onFinishCallback(){
       if(validateAllSteps()){
        $('form').submit();
       }
      }
            
		});
	   
    function validateAllSteps(){
       var isStepValid = true;
       
       if(validateStep1() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:1,iserror:false});
       }
       if(validateStep2() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:2,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:2,iserror:false});
       }
       
       if(validateStep3() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:3,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:3,iserror:false});
       }
       if(validateStep4() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:4,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:4,iserror:false});
       }
       
       
       if(validateStep5() == false){
         isStepValid = false;
         $('#wizard').smartWizard('setError',{stepnum:5,iserror:true});         
       }else{
         $('#wizard').smartWizard('setError',{stepnum:5,iserror:false});
       }
       
       if(!isStepValid){
          $('#wizard').smartWizard('showMessage','Please fill the marked fields in step1 and click Next');
       }
              
       return isStepValid;
    } 	
		
			
		function validateSteps(step){
		 	  var isStepValid = true;
      // validate step 1
      if(step == 1){
        if(validateStep1() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      if(step == 2){
        if(validateStep2() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      // validate step3
      if(step == 3){
        if(validateStep3() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      //validate step 4
      if(step == 4){
        if(validateStep4() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      //validate step 5
      if(step == 5){
        if(validateStep5() == false ){
          isStepValid = false; 
          $('#wizard').smartWizard('showMessage','Please fill the red marked fields in step'+step+ ' and click next.');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:true});         
        }else{
          $('#wizard').smartWizard('hideMessage');
          $('#wizard').smartWizard('setError',{stepnum:step,iserror:false});
        }
      }
      
      return isStepValid;
    }
			
		function validateStep1(){
       var isValid = true; 
       // Validate Username
       var un = $('#regno').val();
       if(!un && un.length <= 0){
   
         document.getElementById("regno").required="true"; 
      $("#regno").css("border-color","#ff0000");
       $("#regno").focus();
            
              isValid = false;
       }else{
//         $('#msg_DOA').html('').hide();
       
       }
     
 
 ////created the date object
dateObject =new Date();
day=dateObject.getDate();
month=dateObject.getMonth()+1;
year=dateObject.getFullYear();
 var current_date;
//fully year separated by backward slash
var days=0;
days=day;
var dates=day;
if(parseInt(days)<10){
 dates="0"+day;  
}

var months=0;
months=month;
var months1=month;
if(parseInt(months)<10){
 months1="0"+month;  
}
//alert(dates);
current_date=months1+"/"+dates+"/"+year;
//current_date=months1+"/"+dates+"/"+year;

//alert(current_date);
//we compare the date

var dateofbirth = $('#DOB').val();
  if(!dateofbirth && dateofbirth.length <= 0){
   
         document.getElementById("DOB").required="true"; 
      $("#DOB").css("border-color","#ff0000");
       $("#DOB").focus();
            
              isValid = false;
       }else{
//         $('#msg_DOA').html('').hide();
       
       }
       
var dateregistered = $('#dateRegistered').val();

 if(!dateregistered && dateregistered.length <= 0){
   
         document.getElementById("dateRegistered").required="true"; 
      $("#dateRegistered").css("border-color","#ff0000");
       $("#dateRegistered").focus();
            
              isValid = false;
       }else{
//         $('#msg_DOA').html('').hide();
       
       }
var g= dateofbirth.split("/");
var k= dateregistered.split("/");

//alert(g[0] +"  "+g[1]+"  "+g[2]);
var curdate=new Date(current_date);

var entereddate = g[1] +"/"+g[0]+"/"+g[2];
var regdate = k[1] +"/"+k[0]+"/"+k[2];
var newdate=new Date(entereddate);
var registereddate=new Date(regdate);
//alert(newdate +"  gererr  "+curdate );

if( newdate > curdate){
alert("Date of birth cannot be greater than current date");
      $("#DOB").css("border-color","#ff0000");
     $("#DOB").focus();
return false;
}
if( registereddate > curdate){
alert("Date Registered cannot be greater than current date");
      $("#dateRegistered").css("border-color","#ff0000");
     $("#dateRegistered").focus();
return false;
}


        return isValid;
    }
    
    
    
       function validateStep2(){
     var isValid2 = true;  
 var mothersphoneno=$('#mothersphoneno').val();
  
  if( mothersphoneno.length >= 10){
   
         
      $("#mothersphoneno").css("border-color","#ff0000");
       $("#mothersphoneno").focus();
            
              isValid2 = false;
       }else{
//         $('#msg_DOA').html('').hide();
       
       }
       
        
        return isValid2;
    }  
       function validateStep3(){
     var isValid3 = true; 
 
    var Fathersphoneno=$('#Fathersphoneno').val();
  
  if( Fathersphoneno.length >= 10){
   
         
      $("#Fathersphoneno").css("border-color","#ff0000");
       $("#Fathersphoneno").focus();
            
              isValid3 = false;
       }else{
//         $('#msg_DOA').html('').hide();
       
       }
       
    
     return isValid3;
    
    }  
       function validateStep4(){
     var isValid4 = true; 
 
  
  
  
     return isValid4;
    
    }  
       function validateStep5(){
     var isValid5 = true; 
 
 
 
        return isValid5;
    
    }  

		
	