<%@include file="/otp/init.jsp" %>
 <%
OTPConfiguration otpConfiguration = ConfigurationProviderUtil.getSystemConfiguration(OTPConfiguration.class);
int maxOtpVerifyAttempt = otpConfiguration.getMaxOtpVerifyAttempts();
int maxOtpResendAttempt= otpConfiguration.getOTPResendMaxAttempts();
int lockOutTime=otpConfiguration.getLockOutTime();
String invalid_otp=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-otp-not-match");
String otp_recieved=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-error-otp");
String otp_resend_max=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-otp-resend-max");
String otp_verify_max=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-otp-verify-max");
String max_otp_attempts=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-max-otp-attempt");
String otp_expire=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-otp-expire");
String service_down=LanguageUtil.get(ResourceBundle.getBundle("content/Language"), "label-service-down");
%>

<style>
modal-wrap .modal .modal-dialog .modal-content {
    align-items: center;
}

button:disabled {
  opacity: 0.65;
  cursor: not-allowed;
}

.resend {
    margin-right: 5px;
    color: #5BB600;
}
.modal-content {
    position: relative;
    display: flex;
    flex-direction: column;
    width: 100%;
    pointer-events: auto;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid rgba(0,0,0,.2);
    border-radius: 0.3rem;
    outline: 0;
}

.modal-body {
    position: relative;
    flex: 1 1 auto;
    padding: 1rem;
}

.modal-wrap .modal .modal-dialog .modal-content .modal-body {
    padding: 40px 0px 40px 0px;
    text-align: center;
}

.enterOtp {
    display: flex;
    column-gap: 13px;
    flex-wrap: wrap;
    row-gap: 10px;
 }   
.otp {
    width: 70px;
    height: 70px;
    padding: 15px;
    text-align: center;
    border: 1px solid #5BB600;
    box-shadow: 8px 8px 10px rgb(0 0 0 / 4%);
    border-radius: 5px;
    background-color: #F8FFF1;

}
.otp-time {
    display: flex;
    justify-content: end;
    margin-top: 12px;
    margin-bottom: 30px;
}

.extra-secondary-bg-btn {
    display: inline-block;
    min-width: 140px;
    padding: 0px 10px;
    height: 50px;
    line-height: 46px;
    text-align: center;
    border-radius: 6px;
    font-weight: 600;
    color: #ffffff;
    background-color: #5BB600;
    border: 2px solid #5BB600;
}

.extra-secondary-btn2 {
    display: inline-block;
    padding: 0px 20px;
    height: 50px;
    line-height: 46px;
    text-align: center;
    border-radius: 6px;
    background-color: #5BB600;
    border: 2px solid #5BB600;
    font-weight: 600;
    color: #ffffff;
    min-width: auto;
}
.modal-wrap .modal .modal-dialog {
    max-width: 680px;
}

.modal-wrap .modal .modal-dialog .modal-content {
    align-items: center;
}

.error {
	color: red;
	font-size: 12px;
	display: none;
}
.btn-close{
position: absolute;
right: 0;
}

</style>

<!-- Modal -->
<div class="modal-wrap">
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
    data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
    aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <button id="closeModal" type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            
            <div class="modal-body">
                                    					<span id="modal_error" class="error"></span>
            
              <form action="" class="verification-code mt-4">
            
                <h4>Enter OTP sent on your mobile no. <br /><span id="mobilenoid"></span></h4>
            <div class="enterOtp" id="otp">

							<input class="otp" id="codeBox1" type="number" maxlength="1"
								onkeyup="onKeyUpEvent(1, event)" onfocus="onFocusEvent(1)">
							<input class="otp" id="codeBox2" type="number" maxlength="1"
								onkeyup="onKeyUpEvent(2, event)" onfocus="onFocusEvent(2)">
							<input class="otp" id="codeBox3" type="number" maxlength="1"
								onkeyup="onKeyUpEvent(3, event)" onfocus="onFocusEvent(3)">
							<input class="otp" id="codeBox4" type="number" maxlength="1"
								onkeyup="onKeyUpEvent(4, event)" onfocus="onFocusEvent(4)">
							<input class="otp" id="codeBox5" type="number" maxlength="1"
								onkeyup="onKeyUpEvent(5, event)" onfocus="onFocusEvent(5)">
							<input class="otp" id="codeBox6" type="number" maxlength="1"
								onkeyup="onKeyUpEvent(6, event)" onfocus="onFocusEvent(6)">
								
			</div>
					<span id="otp_error" class="error"></span>					
<div id="msg_error" class="error"></div> 		

            <div class="otp-time" id="otp-timer-link" style="visibility:visible">
                <a class="resend">Resend in</a>
                <span class="resend" id="timer">00:00</span>
            </div>
            <button type="button" class="extra-secondary-btn2" id="verifyOtpBtn" onclick="checkOtp()">Verify</button>              
            <button type="button" class="extra-secondary-btn2" id="resendotpIdBtn" disabled onclick="resendmaxOtpVerifyAttempts()">Resend</button> 
            </form>
            </div>
        </div>
    </div>
</div>
</div>

<script>
var vargetOTPForUser = '<%=vargetOTPForUser%>';
var verifyOtp= '<%=verifyOtp%>';
var otpReceived;
var invalid_otp='<%=invalid_otp%>';
var otp_recieved='<%=otp_recieved%>';
var otp_resend_max='<%=otp_resend_max%>';
var otp_verify_max='<%=otp_verify_max%>';
var max_otp_attempts='<%=max_otp_attempts%>';
var otp_expire='<%=otp_expire%>';
var service_down='<%=service_down%>';
var contactNumber;
var maxOtpVerifyAttempt='<%=maxOtpVerifyAttempt%>';
var maxOtpResendAttempt='<%=maxOtpResendAttempt%>';
var restartOTPTimer;
var locking_period='<%=lockOutTime%>';
var current = new Date();
var startlocktime= current.toLocaleTimeString();
console.log("startlocktime: "+startlocktime);

function checkOtp(){ 	
	 return new Promise( (resolve, reject) => {
		 var response = false;
			$('#otp_error').html('');
			if($('#codeBox1').val()==''|| $('#codeBox2').val()=='' || $('#codeBox3').val()==''||$('#codeBox4').val()==''||$('#codeBox5').val()=='' || $('#codeBox6').val()==''){
				console.log("if checkOtp");
				$('#otp_error').text(otp_recieved).show(); 	
			} else{
				response = maxOtpVerifyAttempts();
			}
			resolve(response);
	 });
}

function resendmaxOtpVerifyAttempts(){
	$('#otp_error').html('');
	document.getElementById("verifyOtpBtn").disabled = false;
	document.getElementById("resendotpIdBtn").disabled = true;

	maxOtpVerifyAttempt='<%=maxOtpVerifyAttempt%>';
	maxOtpResendAttempt=maxOtpResendAttempt-1;
	console.log("resendmaxOtpVerifyAttempts: "+maxOtpResendAttempt);
	if(maxOtpResendAttempt<="0"){
		console.log("disable resend");
		document.getElementById("resendotpIdBtn").disabled = true;
		$('#otp_error').text(otp_resend_max).show(); 
		document.getElementById('otp-timer-link').style.visibility= "visible";
		otpTimer(locking_period);
		if(maxOtpVerifyAttempt=="0"){
		document.getElementById("verifyOtpBtn").disabled = true;
    	document.getElementById("resendotpIdBtn").disabled = true;
			$('#otp_error').text(max_otp_attempts).show(); 	
			document.getElementById('otp-timer-link').style.visibility= "visible";
			otpTimer(locking_period);
		}
	}
	else{
		resendOtp();	
	}
}

function maxOtpVerifyAttempts(){
	var response = false;
	$('#otp_error').html('');
	maxOtpVerifyAttempt=maxOtpVerifyAttempt-1;
	console.log("maxOtpVerifyAttempt: "+maxOtpVerifyAttempt);
	if(maxOtpVerifyAttempt<="0"){
		document.getElementById("verifyOtpBtn").disabled = true;
		$('#otp_error').text(otp_verify_max).show(); 
		if(maxOtpResendAttempt=="0"){
			$('#otp_error').html('');
			document.getElementById("verifyOtpBtn").disabled = true;
			document.getElementById("resendotpIdBtn").disabled = true;
				$('#otp_error').text(max_otp_attempts).show(); 
				document.getElementById('otp-timer-link').style.visibility= "visible";
				otpTimer(10);
		}
	}
	else{
		response = verifyOTP();
	}
	return response;
}

function verifyOTP(){
 	var otpNoId=$('#codeBox1').val().trim()+$('#codeBox2').val().trim()+$('#codeBox3').val().trim()+$('#codeBox4').val().trim()+$('#codeBox5').val().trim()+$('#codeBox6').val().trim();
    var isVerifiedOTP = false;
    console.log("otpNoId: "+otpNoId);
    var status;  
    $.ajax({
		url :verifyOtp,
		type: 'POST',
		data : {"<portlet:namespace />userEnterdOtp":otpNoId},
		dataType: 'JSON',
		async: false,
		success: function (response) {
			$.each(response, function(key, value) {	
				status=value.status;
			})
			if(status== 'ok'){
				isVerifiedOTP = true;	
				console.log("otp matched");			
			}
			 else if(status== 'notOK')
      		 {
				 console.log("otp not matched");
				 isVerifiedOTP = false;			
				 $('#otp_error').text(invalid_otp).show();
				 $('#otp_error').focus().select();				
      		 }
			 else if(status== 'timeout'){
				 $('#otp_error').text(otp_expire).show();
            	 $('#otp_error').focus().select();
			 }
             else
             {
            	 $('#otp_error').text(service_down).show();
            	 $('#otp_error').focus().select();            	
             }		
		   }
     }); 
    return isVerifiedOTP;
} 

function otpTimer(time){
	removeOTPTimer=false;
	let timerOn = true;

	function timer(remaining) {
	  var m = Math.floor(remaining / 60);
	  var s = remaining % 60;
	  
	  if(removeOTPTimer){
		  remaining='0';
	  }
	  
	  m = m < 10 ? '0' + m : m;
	  s = s < 10 ? '0' + s : s;
	  document.getElementById('timer').innerHTML = m + ':' + s;
	  remaining -= 1;
	  
	  if(remaining >= 0 && timerOn) {
		  restartOTPTimer =setTimeout(function() {
	        timer(remaining);
	    }, 1000);
	    return;
	  }else{
		  document.getElementById('timer').innerHTML = ''; 
	  }

	  if(!timerOn) {
	    return;
	  }
	  if(!removeOTPTimer){
			if(maxOtpResendAttempt<="0"){
				console.log("disable resend");
				document.getElementById("resendotpIdBtn").disabled = true;
			}
			else{
		document.getElementById('otp-timer-link').style.visibility= "hidden";
		document.getElementById("resendotpIdBtn").disabled = false;
			}
	  }
	}

	timer(time);
} 

function callOtpFunction(mobileno){  

	//document.getElementById("mobilenoid").value=mobileno;
	document.getElementById('mobilenoid').innerHTML = mobileno;
	var otpResendMaxAttemptsUser=maxOtpResendAttempt;
	contactNumber=mobileno;
	var	attemptrecieved;
	otpTimer(10);
	var serviceDown=false;
	var errorMsg;
	$.ajax({
		url :vargetOTPForUser,
		type: 'POST',
		data : {
			"<portlet:namespace />contactNumber":contactNumber,
			"<portlet:namespace />otpResendMaxAttemptsUser":otpResendMaxAttemptsUser
			},
		dataType: 'JSON',
		success: function (response) {
			$.each(response, function(key, value) {	
				otpSize=value.otpLength;
				serviceDown = value.errorFlag;
				errorMsg=value.errorMsg;
				attemptrecieved=value.otpResendMaxAttemptsUser;
			})
			if(attemptrecieved!= undefined || !isNaN(attemptrecieved) ){
				$('#otp_error').html('');

				console.log("attemptrecieved");
			    $('#codeBox1').val('');
				$('#codeBox1').val('');
				$('#codeBox2').val('');
				$('#codeBox3').val('');
				$('#codeBox4').val('');
				$('#codeBox5').val('');
				$('#codeBox6').val('');

				document.getElementById("verifyOtpBtn").disabled = false;
				document.getElementById("resendotpIdBtn").disabled = false;
				maxOtpResendAttempt=attemptrecieved;
			}
			if(serviceDown==true){
				 $('#otp_error').text(service_down).show();

				
			}	
		}	
	});
}


function resendOtp(){	
	console.log("rsend");
	    $('#codeBox1').val('');
		$('#codeBox1').val('');
		$('#codeBox2').val('');
		$('#codeBox3').val('');
		$('#codeBox4').val('');
		$('#codeBox5').val('');
		$('#codeBox6').val('');
		
	document.getElementById('otp-timer-link').style.visibility= "visible";
	console.log("inside resendOtp");
	callOtpFunction(contactNumber);
}
function getCodeBoxElement(index) {
return document.getElementById('codeBox' + index);
}
function onKeyUpEvent(index, event) {
	const eventCode = event.which || event.keyCode;
	if (getCodeBoxElement(index).value.length != getCodeBoxElement(index).maxLength) {
		getCodeBoxElement(index).value="";
		getCodeBoxElement(index).focus();
	}else if(getCodeBoxElement(index).value.length === 1) {
		if (index !== 6) {
			getCodeBoxElement(index+ 1).focus();
		} else {
			getCodeBoxElement(index).blur();
		
		}
	}
	if (eventCode === 8 && index !== 1) {			
		getCodeBoxElement(index - 1).focus();		
	}
	
} 

function onFocusEvent(index) {
for (item = 1; item < index; item++) {
 const currentElement = getCodeBoxElement(item);
 if (!currentElement.value) {
	  currentElement.focus();
	  break;
 }
}
}

</script>
