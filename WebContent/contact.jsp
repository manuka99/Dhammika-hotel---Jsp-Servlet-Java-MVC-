<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home Page</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="Design/mdPro/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="Design/mdPro/css/mdb.min.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="WEB-INF/views/home/header.jsp"></jsp:include>

	<section>

		<!-- Google map -->
		<div id="map-container" class="z-depth-1-half map-container"
			style="height: 500px; margin-top: 60px;">

			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3960.7931540598383!2d79.97175359652637!3d6.915316542585662!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x2c63e344ab9a7536!2sSri%20Lanka%20Institute%20of%20Information%20Technology!5e0!3m2!1sen!2slk!4v1592156403631!5m2!1sen!2slk"
				width="100%" height="500" frameborder="0" style="border: 0;"
				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
		</div>

	</section>


	<main>

		<div class="container-fluid mb-5">

			<!-- Grid row -->
			<div class="row" style="margin-top: -140px;">

				<!-- Grid column -->
				<div class="col-md-12">

					<div class=" ">

						<div class="card-body">

							<div class="container">

								<!-- Section: Contact v.3 -->
								<section class="contact-section">

									<!-- Form with header -->
									<div class="card">

										<!-- Grid row -->
										<div class="row">


											<!-- Grid column -->
											<div class="col-lg-8">

												<div class="card-body form">

													<!-- Header -->
													<h3 class="mt-4">
														<i class="fas fa-envelope pr-2"></i>Write to us:
													</h3>
													<form id="contactUsForm">
														<!-- Grid row -->
														<div class="row">

															<!-- Grid column -->
															<div class="col-md-6">

																<div class="md-form mb-0">

																	<input type="text" id="name" class="form-control">

																	<label for="name" class="">Your name</label>

																</div>

															</div>
															<!-- Grid column -->

															<!-- Grid column -->
															<div class="col-md-6">

																<div class="md-form mb-0">

																	<input type="text" id="email" class="form-control">

																	<label for="email" class="">Your email</label>

																</div>

															</div>
															<!-- Grid column -->

														</div>
														<!-- Grid row -->

														<!-- Grid row -->
														<div class="row">

															<!-- Grid column -->
															<div class="col-md-6">

																<div class="md-form mb-0">

																	<input type="text" id="phone" class="form-control">

																	<label for="phone" class="">Your phone</label>

																</div>

															</div>
															<!-- Grid column -->

															<!-- Grid column -->
															<div class="col-md-6">

																<div class="md-form mb-0">

																	<input type="text" id="subject" class="form-control">

																	<label for="subject" class="">Subject</label>

																</div>

															</div>
															<!-- Grid column -->

														</div>
														<!-- Grid row -->

														<!-- Grid row -->
														<div class="row">

															<!-- Grid column -->
															<div class="col-md-12">

																<div class="md-form mb-0">

																	<textarea type="text" id="message"
																		class="form-control md-textarea" rows="3"></textarea>

																	<label for="message">Your message</label> 
																	<a onclick="ContactUsformSubmit()"
																		class="btn-floating btn-lg blue waves-effect waves-light">

																		<i class="far fa-paper-plane"></i>

																	</a>

																</div>

															</div>
															<!-- Grid column -->

														</div>
														<!-- Grid row -->
													</form>
												</div>

											</div>

											<!-- Grid column -->

											<!-- Grid column -->
											<div class="col-lg-4">

												<div class="card-body contact text-center h-100 white-text">

													<h3 class="my-4 pb-2">Contact information</h3>

													<ul class="text-lg-left list-unstyled ml-4">

														<li>

															<p>
																<i class="fas fa-map-marker-alt pr-2 mb-4"></i>Dammika
																Hotel, 11234, colombo
															</p>

														</li>

														<li>

															<p>
																<i class="fas fa-phone pr-2 mb-4"></i>011 2525 256
															</p>

														</li>

														<li>

															<p>
																<i class="fas fa-envelope pr-2"></i>dammika@gmail.com
															</p>

														</li>

													</ul>

													<hr class="hr-light my-4">

													<ul class="list-inline text-center list-unstyled">

														<li class="list-inline-item"><a
															class="p-2 fa-lg tw-ic"> <i class="fab fa-twitter"></i>

														</a></li>

														<li class="list-inline-item"><a
															class="p-2 fa-lg li-ic"> <i
																class="fab fa-linkedin-in"> </i>

														</a></li>

														<li class="list-inline-item"><a
															class="p-2 fa-lg ins-ic"> <i class="fab fa-instagram">
															</i>

														</a></li>

													</ul>

												</div>

											</div>
											<!-- Grid column -->

										</div>
										<!-- Grid row -->

									</div>
									<!-- Form with header -->

								</section>
								<!-- Section: Contact v.3 -->

							</div>

						</div>

					</div>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>

	</main>


	<jsp:include page="WEB-INF/views/home/footer.jsp"></jsp:include>
	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script type="text/javascript"
		src="Design/mdPro/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="Design/mdPro/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="Design/mdPro/js/bootstrap.min.js">
		
	</script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="Design/mdPro/js/mdb.min.js"></script>
	<script>
		// Animation init
		new WOW().init();

		// Material Select Initialization
		$(document).ready(function() {
			$('.mdb-select').material_select();
		});
	</script>
	<script>
		var status = 0;
		var name = "";
		var phone = 0;
		var email = "";
		var subject = "";
		var message = "";

		$("#contactUsForm")
				.on(
						"input",
						function() {

							$("#infoSpan").text(" ");

							name = $('#name').val();
							phone = $('#phone').val();
							email = $('#email').val();
							subject = $('#subject').val();
							message = $('#message').val();
							var atposition = email.indexOf("@");
							var dotposition = email.lastIndexOf(".");

							if (name == "") {
								status = 0;
							}

							else if (name.length < 10) {
								status = 0;
							}

							else if (email == "") {
								status = 0;

							}

							else if (email.length < 10) {
								status = 0;

							}

							else if (phone == "") {
								status = 0;
							}

							else if (phone.length < 9) {
								status = 0;
							}

							else if (subject == "") {
								status = 0;
							}

							else if (message == "") {
								status = 0;
							}

							else {
								status = 1;
							}

						});

		function ContactUsformSubmit() {

			event.preventDefault();
			var form = event.target.form; // storing the form
			if (status == 1) {
				$
						.ajax({

							url : "InsertContactUsForm",
							data : {
								'name' : name,
								'email' : email,
								'phone' : phone,
								'subject' : subject,
								'message' : message

							},

							success : function(data) {

								if(data == "success")
								window.location.href = "http://localhost:8080/ecommerce/index.jsp";

								else
									alert('not Submitted');
							}

						})
			}
			
			else
				alert('Please fill out the form and submit');

		};
	</script>
</body>
</html>
