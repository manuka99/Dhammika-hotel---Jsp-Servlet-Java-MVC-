<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Login</title>

</head>
<body class="homepage-v1 hidden-sn white-skin animated">

	<div id="headder">
		<%@ include file="../home/header.jsp"%>

	</div>

	<div id="loginform" class="view intro-2" style="background: #334d50;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #cbcaa5, #334d50);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #cbcaa5, #334d50); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	">
	
		<div style="height: 120px"></div>
		<div class=" ">


			<!--Section: Content-->
			<section 
				class="px-md-5 mx-md-5 text-center font-weight-bold black-text">


				<!--Grid row-->
				<div class="row d-flex justify-content-center">

					<!--Grid column-->
					<div class="col-md-6 container my-5 py-5 z-depth-3">

						<!-- Default form login -->
						<form class="text-center">

							<p class="h1 mb-4">Member Area Login</p>

							<!-- Email -->
							<input type="email" id="email" class="form-control mb-4"
								placeholder="E-mail">

							<!-- Password -->
							<input type="password" id="password" class="form-control mb-4"
								placeholder="Password">

							<div class="d-flex justify-content-around">
								<div>
									<!-- Remember me -->
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input"
											id="defaultLoginFormRemember"> <label
											class="custom-control-label" for="defaultLoginFormRemember">Remember
											me</label>
									</div>
								</div>
								<div>
									<!-- Forgot password -->
									<h4 class="font-weight-bold"><a onclick="ForgotPasswordToggle()" class="blue-text">Forgot
										password?</a></h4>
								</div>
							</div>

							<!-- Sign in button -->
							<button class="btn btn-primary btn-block my-4" type="button"
								onclick="UserLoginValidator()">Sign in</button>

							<!-- Register -->
							<h4 class="font-weight-bold">
								Not a member? <a href="register"class="blue-text" >Register</a>
							</h4>


						</form>
						<!-- Default form login -->

					</div>
					<!--Grid column-->

				</div>
				<!--Grid row-->


			</section>
			<!--Section: Content-->


		</div>
		<div style="height: 120px"></div>
	</div>


	<div id="ForgotPassword" style="background-image: linear-gradient(to right top, #d16ba5, #c675b8, #b87fc8, #a689d5, #9393de, #81a0ea, #6dacf2, #58b8f6, #3ccafd, #2cdcfe, #3cecf9, #5ffbf1);" >
		<div style="height: 200px"></div>
		<div class="">


			<!--Section: Content-->
			<section
				class="px-md-5 mx-md-5 text-center font-weight-bold white-text">


				<!--Grid row-->
				<div class="row d-flex justify-content-center">

					<!--Grid column-->
					<div class="col-md-8 container my-5 py-5 z-depth-5">

						<!-- Default form login -->
						<form class="text-center">

							<h3 class="h3 mb-4">Password Recovery</h3>

							<p>Provide us the email you entered when you signed up, our
								server will send your email a system generated password so that
								you can recover your account</p>


							<!-- Email -->
							<input type="email" id="email2" class="form-control mb-4"
								placeholder="Enter your valid email to continue">

							<div class="d-flex justify-content-around">
								<div>
									<!-- Remember me -->

									<span class="text-muted">Not a member?</span><a href="register">Register</a>

								</div>
								<div>
									<!-- Forgot password -->
									<span class="text-muted">Have a Account?</span><a
										href="login">Login</a>
								</div>
							</div>

							<!-- Sign in button -->
							<div id="continueBttf">
								<button class="btn btn-info btn-block my-4" type="button"
									onclick="ForgotPasswordServlet()">Continue</button>
							</div>





						</form>
						<!-- Default form login -->

					</div>
					<!--Grid column-->

				</div>
				<!--Grid row-->


			</section>
			<!--Section: Content-->


		</div>
		<div style="height: 200px"></div>
	</div>


	<div id="currentUser">
	<div style="height: 100px"></div>
		<!-- Jumbotron -->
		<div class="jumbotron text-center">

			<!-- Title -->
			<h2 class="card-title h2">You Are Already Logged In</h2>
			<!-- Subtitle -->
			<p class="blue-text my-4 font-weight-bold">Your access is
				restricted on this page</p>

			<!-- Grid row -->
			<div class="row d-flex justify-content-center">

				<!-- Grid column -->
				<div class="col-xl-7 pb-2">

					<p class="card-text">You are logged in as ${user.name} to
						continue and redirect please select one of the below options.</p>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

			<hr class="my-4">

			<div class="pt-2">
				<a role="button" href="UserLogOut"
					class="btn btn-danger waves-effect">Confirm Logout <span
					class="far fa-exclamation ml-1"></span></a> <a role="button"
					href="index.jsp" class="btn btn-outline-primary waves-effect">Cancel
					<i class="fas fa-ban ml-1"></i>
				</a>
			</div>

		</div>
		<!-- Jumbotron -->
		<div style="height: 100px"></div>


	</div>



	<%@ include file="../home/footer.jsp"%>


	<script>
		$(document).ready(function() {

			if (performance.navigation.type == 2) {
				location.reload(true);
			}
			$('#currentUser').hide();
			$('#ForgotPassword').hide();
			$('#continueBttf').hide();

			$.ajax({

				url : "UserLoginValidation",

				success : function(data) {

					console.log(data);
					if (data == 'invalid') {
						//location.reload()
					}

					else if (data == 'alreadyloggedin') {
						$('#loginform').slideUp();
						$('#currentUser').show()

					} else
						$('#currentUser').hide()

				}

			})

		});
	</script>


	<script>
		function UserLoginValidator() {

			password = $('#password').val();
			email = $('#email').val();

			$
					.ajax({

						url : "UserLoginValidation",
						data : {
							'email' : email,
							'password' : password
						},

						success : function(data) {

							if (data == 'valid')
								window.location.href = "http://localhost:8080/ecommerce/index.jsp";

							else
								toastr.error('invalid credentials');

						}

					})

		};

		function ForgotPasswordToggle() {

			$('#loginform').fadeOut();
			$('#ForgotPassword').fadeIn();

		};

		$("#email2").on("input", function() {

			email = $('#email2').val();
			console.log(email);

			$.ajax({

				url : "CheckUserEmail",
				data : {
					'email' : email

				},

				success : function(data) {

					if (data == "true") {

						$('#continueBttf').slideDown();

					}

					else {
						$('#continueBttf').slideUp();
						console.log(data);

					}

				}

			})

		});

		function ForgotPasswordServlet() {

			email = $('#email2').val();

			//$('#conte').load('WEB-INF/views/home/CardLoader.jsp');
			console.log(password), console.log(email)
			$.ajax({

				url : "ForgotPasswordUser",
				data : {
					'email' : email
				},

				success : function(data) {

					if (data == 'true') {
						alert('success check your email');
						window.location.href = "login";
					} else
						alert('Unexpected Error');

				}

			})

		};
	</script>

</body>
</html>
