<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Registration</title>

<style>
.border-top {
	border-top: 5px solid #33b5e5 !important;
	border-top-left-radius: .25rem !important;
	border-top-right-radius: .25rem !important;
}
</style>
</head>
<body class="homepage-v1 hidden-sn white-skin animated"
	style="background: #8E2DE2;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #4A00E0, #8E2DE2);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #4A00E0, #8E2DE2); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	">
	<%@ include file="../home/header.jsp"%>


	<div class="container my-5">

		<!--Section: Content-->
		<section>
			<div class="mask rgba-gradient">
				<div
					class="container h-100 d-flex justify-content-center align-items-center">

					<!-- Grid row -->
					<div class="row pt-5">

						<!-- Grid column -->
						<div class="col-md-12">

							<div class="card">
								<div class="card-body">

									<h2
										class="font-weight-bold my-4 text-center mb-5 mt-4 font-weight-bold">
										<strong>REGISTER</strong>
									</h2>
									<strong><span id="infoSpan"></span></strong>
									<hr>

									<!-- Grid row -->
									<div class="row mt-5">

										<!-- Grid column -->
										<div class="col-md-6 ml-lg-5 ml-md-3">

											<!-- Grid row -->
											<div class="row pb-4">
												<div class="col-2 col-lg-1">
													<i class="fas fa-university indigo-text fa-lg"></i>
												</div>
												<div class="col-10">
													<h4 class="font-weight-bold mb-4">
														<strong>PAYMENT</strong>
													</h4>
													<p>SFSDSDSDSDDDDDDDDDDDDDDDDDDDDSDSDSDSDSDS
													DSDSDSSSSS
													SDSDSDSDS
													SDSSDSSSDSDHSDJKHSDJSHDJKSHJSHDKSHK</p>
												</div>
											</div>
											<!-- Grid row -->

											<!-- Grid row -->
											<div class="row pb-4">
												<div class="col-2 col-lg-1">
													<i class="fas fa-desktop deep-purple-text fa-lg"></i>
												</div>
												<div class="col-10">
													<h4 class="font-weight-bold mb-4">
														<strong>CHECKOUT</strong>
													</h4>
													<p>SFSDSDSDSDDDDDDDDDDDDDDDDDDDDSDSDSDSDSDS
													DSDSDSSSSS
													SDSDSDSDS
													SDSSDSSSDSDHSDJKHSDJSHDJKSHJSHDKSHK.</p>
												</div>
											</div>
											<div class="row pb-4">
												<div class="col-2 col-lg-1">
													<i class="fas fa-desktop deep-purple-text fa-lg"></i>
												</div>
												<div class="col-10">
													<h4 class="font-weight-bold mb-4">
														<strong>CART</strong>
													</h4>
													<p>SFSDSDSDSDDDDDDDDDDDDDDDDDDDDSDSDSDSDSDS
													DSDSDSSSSS
													SDSDSDSDS
													SDSSDSSSDSDHSDJKHSDJSHDJKSHJSHDKSHK.</p>
												</div>
											</div>
											<!-- Grid row -->

											<!-- Grid row -->
											<div class="row pb-4">
												<div class="col-2 col-lg-1">
													<i class="far fa-money-bill-alt purple-text fa-lg"></i>
												</div>
												<div class="col-10">
													<h4 class="font-weight-bold mb-4">
														<strong>EFFICENCY</strong>
													</h4>
													<p>SFSDSDSDSDDDDDDDDDDDDDDDDDDDDSDSDSDSDSDS
													DSDSDSSSSS
													SDSDSDSDS
													SDSSDSSSDSDHSDJKHSDJSHDJKSHJSHDKSHK.</p>
												</div>
											</div>
											<!-- Grid row -->

										</div>
										<!-- Grid column -->

										<!-- Grid column -->
										<div class="col-md-5">

											<form id="userRegister">
												<!-- Body -->
												<div class="md-form mb-2">
													<i class="fas fa-user prefix"></i> <input
														class="form-control" id="name" type="text"><br>
													<label for="name">Your name</label>
												</div>

												<div class="md-form">
													<i class="fas fa-envelope prefix"></i> <input
														class="form-control" id="email" type="email"><br>
													<label for="email">Your email</label>
												</div>

												<div class="md-form">
													<i class="fas fa-home prefix"></i> <input
														class="form-control" id="address" type="text"><br>
													<label for="address">Your Home Address</label>
												</div>

												<div class="md-form">
													<i class="far fa-calendar-alt prefix"></i> <input
														class="form-control" id="DateOfBirth" type="date"><br>
													<label for="DateOfBirth"></label>
												</div>

												<div class="md-form">
													<i class="fas fa-phone prefix"></i> <input
														class="form-control" id="phone" type="text"><br>
													<label for="phone">Your Phone Number</label>
												</div>

												<div class="md-form">
													<i class="fas fa-lock prefix"></i> <input
														class="form-control" id="password" type="text"><br>
													<label for="password">Your Password</label>
												</div>

												<div class="md-form">
													<i class="fas fa-lock prefix"></i> <input
														class="form-control" id="repeatPassword" type="text">
													<label for="repeatPassword">Confirm Password</label>
												</div>

												<div class="text-center">
													<button
														class="btn btn-indigo btn-rounded mt-5 waves-effect waves-light"
														type="button" id="registerNow" onclick="formSubmit()">Sign
														up</button>
												</div>

											</form>
										</div>
										<!-- Grid column -->

									</div>
									<!-- Grid row -->

								</div>
							</div>

						</div>
						<!-- Grid column -->

					</div>
					<!-- Grid row -->

				</div>
			</div>
		</section>
		<div style="height: 20px"></div>
		<!--Section: Content-->

	</div>






	<%@ include file="../home/footer.jsp"%>
	<!-- SCRIPTS -->

	<script>
		var status = 0;
		var name = "";
		var password = "";
		var phone = 0;
		var email = "";
		var address = "";
		var dateOfBirth = "";
		var Estatus = 0;
		var testPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

		$("#userRegister")
				.on(
						"input",
						function() {

							$("#infoSpan").text(" ");

							name = $('#name').val();
							phone = $('#phone').val();
							password = $('#password').val();
							email = $('#email').val();
							address = $('#address').val();
							dateOfBirth = $('#dateOfBirth').val();
							password = $('#password').val();
							repeatPassword = $('#repeatPassword').val();
							var atposition = email.indexOf("@");
							var dotposition = email.lastIndexOf(".");

							console.log(password);

							$.ajax({

								url : "CheckUserEmail",
								data : {
									'email' : email

								},

								success : function(data) {

									if (data == "false") {
										Estatus = 0;

									}

									else {
										Estatus = 1;
										$("#registerNow").slideUp();

									}

								}

							})

							if (name == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text(" ");
							}

							else if (name.length < 10) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("User Name is too short");
							}

							else if (email == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("");

							}

							else if (email.length < 10) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("User Email is too short");

							}

							else if (Estatus == 1) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text(" ");
								alert('There is a registered user');
							}

							else if (phone == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("");
							}

							else if (phone.length < 9) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text(
										"Please enter a valid phone number");
							}

							else if (dateOfBirth == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("Please Select your date of Birth");
							}

							else if (password == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("");
							}

							else if (!password.match(testPassword)) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan")
										.text(
												"Your password must be at 8 to 15 of length which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character");
							}

							else if (repeatPassword == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("");
							}

							else if (!repeatPassword.match(password)) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("Passwords do not match");
							}

							else if (address == "") {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text("");
							}

							else if (address.length < 12) {
								status = 0;
								$("#registerNow").slideUp();
								$("#infoSpan").text(
										"Billing address is too short");
							}

							else {
								status = 1;
								$("#registerNow").slideDown();
							}

						});

		function formSubmit() {

			event.preventDefault();
			var form = event.target.form; // storing the form

			console.log(password);
			if (status == 1) {
				$
						.ajax({

							url : "UserRegistration",
							data : {
								'name' : name,
								'email' : email,
								'phone' : phone,
								'password' : password,
								'address' : address,
								'dateOfBirth' : dateOfBirth

							},

							success : function(data) {

								window.location.href = "http://localhost:8080/ecommerce/index.jsp";

							}

						})
			}

		};
	</script>
</body>
</html>
