<%@ include file="/init.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<form>
	<div class="form-title">
		<h5>NID Details</h5>
	</div>
	<div class="row">
		<div class="col-md-6 col-12">
			<div class="form-group">
				<div class="input-field">
					<label for="nid">NID No. <span>*</span></label> <input
						type="NUMBER" class="form-control" placeholder="Type Here">
				</div>
			</div>
		</div>
		<div class="col-md-6 col-12">
			<div class="form-group">
				<div class="input-field">
					<label for="nid">Email Address </label> <input type="email"
						class="form-control" placeholder="Type Here">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-12">
			<div class="form-group">
				<div class="flag-wrap">
					<label for="nid">Mobile Number <span>*</span></label> <input
						type="NUMBER" class="form-control" id="mobile" placeholder="">
					<div class="flag-img">
						<img src="images/flag-img.png" alt="img"> <span>+880
							|</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6 col-12">
			<div class="form-group">
				<label>Date of Birth <span>*</span></label>
				<div class="input-group date" id="datepicker"
					data-date-format="dd-mm-yyyy">
					<input type="text" class="form-control" id="date"
						placeholder="07/09/2022" /> <span class="input-group-append">
						<svg width="18" height="19" viewBox="0 0 18 19" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                                                <path
								d="M1.88889 8.55556H16.1111M6.33333 13.2778H11.6667M5.44444 1L5.44444 4.77778M12.5556 1L12.5556 4.77778M5.74074 18H12.2593C14.4941 18 15.6115 18 16.3057 17.2623C17 16.5247 17 15.3374 17 12.963V8.87037C17 6.49589 17 5.30865 16.3057 4.57099C15.6115 3.83333 14.4941 3.83333 12.2593 3.83333H5.74074C3.50593 3.83333 2.38853 3.83333 1.69427 4.57099C1 5.30865 1 6.49589 1 8.87037V12.963C1 15.3374 1 16.5247 1.69427 17.2623C2.38853 18 3.50593 18 5.74074 18Z"
								stroke="#57AD00" stroke-linecap="round" />
                                            </svg>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-title">
		<h5>Set Up your Password for online account</h5>
	</div>
	<div class="form-group row">
		<div class="col-md-6 col-12">
			<div class="input-field">
				<label for="">Password <span>*</span>
				</label>
				<div class="inputWithIcon">
					<input type="password" class="form-control" name="password"
						placeholder="Type Here"> <i
						class="toggle-password bi bi-eye-slash"></i>
				</div>
			</div>

			<small>A strong password should be at least 6 characters long
				with a 1 Capital 1 Number 1 Special Character</small>
		</div>
		<div class="col-md-6 col-12">
			<div class="input-field">
				<label for="">Retype Password <span>*</span>
				</label>
				<div class="inputWithIcon">
					<input type="password" class="form-control" name="password"
						placeholder="Type Here"> <i
						class="toggle-password bi bi-eye-slash"></i>
				</div>
			</div>
		</div>
	</div>
 	<div class="form-btn">
		<a href="jaavascript:;"
			class="extra-secondary-btn extra-secondary-bg-btn mt-2"
			data-bs-toggle="modal" data-bs-target="#staticBackdrop"
			onclick="validate()">Next <span><svg width="20"
					height="20" viewBox="0 0 20 20" fill="none"
					xmlns="http://www.w3.org/2000/svg">
                                <g clip-path="url(#clip0_106_50)">
                                <path
						d="M13.4528 9.85445L7.96171 5.88124C7.93502 5.86186 7.90349 5.85026 7.87061 5.8477C7.83773 5.84515 7.80479 5.85175 7.77544 5.86678C7.74608 5.8818 7.72146 5.90466 7.7043 5.93282C7.68714 5.96099 7.67812 5.99335 7.67822 6.02633V7.0732C7.67822 7.30088 7.7876 7.5174 7.97287 7.65133L11.2184 9.99954L7.97287 12.3478C7.7876 12.4817 7.67822 12.696 7.67822 12.9259V13.9728C7.67822 14.1178 7.8434 14.2027 7.96171 14.1178L13.4528 10.1446C13.551 10.0732 13.551 9.92588 13.4528 9.85445Z"
						fill=""></path>
                                <path
						d="M10 0C4.47768 0 0 4.47768 0 10C0 15.5223 4.47768 20 10 20C15.5223 20 20 15.5223 20 10C20 4.47768 15.5223 0 10 0ZM10 18.3036C5.41518 18.3036 1.69643 14.5848 1.69643 10C1.69643 5.41518 5.41518 1.69643 10 1.69643C14.5848 1.69643 18.3036 5.41518 18.3036 10C18.3036 14.5848 14.5848 18.3036 10 18.3036Z"
						fill=""></path>
                                </g>
                                <defs>
                                <clipPath id="clip0_106_50">
                                <rect width="20" height="20" fill=""></rect>
                                </clipPath>
                                </defs>
                                </svg> </span></a>
		<dgfood-ui:otp otpEntered="" />

	</div> 
<!-- 	   <button class="extra-secondary-btn extra-secondary-bg-btn" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="callOtpFunction()">Next</button>
 -->	
	<p class="note">
		<span>Note : </span> By clicking on Next you are agreeing to retrieve
		and Validate your data from NID
	</p>
</form>

<script>

function validate(){
	var mobileno= document.getElementById('mobile').value;
	callOtpFunction(mobileno);
}

</script>

