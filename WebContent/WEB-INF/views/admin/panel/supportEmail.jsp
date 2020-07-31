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
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="Design/panel/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="Design/panel/css/mdb.min.css">
<link href="Design/mdPro/css/addons/datatables.css" rel="stylesheet">
<link href="Design/mdPro/css/addons/datatables.min.css" rel="stylesheet">
<link href="Design/mdPro/css/upload-file.css" rel="stylesheet">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/5.3.2/tinymce.min.js"></script>
<style>
</style>
</head>

<body class="fixed-sn white-skin" id="body">

	<div id="body2">

		<div id="headerRefresh22"></div>



		<main>
			<div class="container-fluid">

				<!-- Section: Basic examples -->
				<section>

					<div id="contectChangeArea">

						<div id="supportEmailPlatForm">



							<!-- Section: Create Page -->
							<section class="my-5">

								<!-- Grid row -->
								<div class="row">

									<!-- Grid column -->
									<div class="col-lg-8">

										<!-- First card -->
										<!--Accordion wrapper-->

										<div class="accordion md-accordion accordion-1 mt-0 mb-5"
											id="accordionEx23" role="tablist">

											<c:set var="counter" value="0" scope="page" />
											<c:forEach var="responseDB" items="${contactUs.responses}">
												<c:set var="counter" value="${counter + 1}" scope="page" />
												<div class="card">
													<div class="card-header blue z-depth-1"
														role="tab" id="heading98">
														<h5 class="text-uppercase mb-0 py-1">
															<a class="collapsed font-weight-bold white-text"
																data-toggle="collapse" href="#${responseDB.responseID}"
																aria-expanded="false" aria-controls="collapse98">
																#${counter} Responded by ${responseDB.user.name} @
																${responseDB.time} </a>
														</h5>
													</div>
													<div id="${responseDB.responseID}" class="collapse"
														role="tabpanel" aria-labelledby="heading98"
														data-parent="#accordionEx23">
														<div class="card-body">
															<div class="row my-4">
																<div class="col-md-8">
																	<h5 class="font-weight-bold mb-3 black-text">
																		Responded by ${responseDB.user.userID} at
																		${responseDB.time}</h5>
																	<div>${responseDB.message}</div>
																</div>
																<div class="col-md-4 mt-0 pt-0">

																	<button class="btn btn-danger"
																		onclick="deleteResponse('${responseDB.responseID}')">Delete
																		Response</button>

																</div>
															</div>
														</div>
													</div>
												</div>

											</c:forEach>



										</div>
										<!--Accordion wrapper-->

										<!-- First card -->

										<!-- Second card -->
										<div class="card mb-4">
											<textarea id="myTextArea" class="mceEditor">Start writing your response</textarea>
										</div>
										<!-- Second card -->

										<button type="button" onclick="addResponse()"
											class="btn btn-primary btn-lg btn-block mt-2 mb-5">Respond
											Now</button>


									</div>
									<!-- Grid column -->

									<!-- Grid column -->
									<div class="col-lg-4">

										<!-- Card -->
										<div class="card card-cascade narrower mb-5">

											<!-- Card image -->
											<div
												class="view view-cascade gradient-card-header blue-gradient">
												<h4 class="font-weight-500 mb-0">Sender Information</h4>
											</div>
											<!-- Card image -->

											<!-- Card content -->
											<div class="card-body card-body-cascade">
												<input type="hidden" id="contactUsID"
													value="${contactUs.contactUsID}">
												<p>
													<i class="fas fa-flag mr-1" aria-hidden="true"></i> Name: <strong>${contactUs.name}</strong>
												</p>
												<p>
													<i class="far fa-eye mr-1" aria-hidden="true"></i> Email: <strong>${contactUs.email}</strong>
												</p>
												<p>
													<i class="fas fa-archive mr-1 mr-1" aria-hidden="true"></i>
													Phone: <strong>${contactUs.phone}</strong>
												</p>
												<p>
													<i class="far fa-calendar-alt mr-1" aria-hidden="true"></i>
													Time: <strong>${contactUs.time}</strong>
												</p>
												<c:set var="counter" value="0" scope="page" />
												<c:forEach var="contact" items="${contactUs.responses}">
													<c:set var="counter" value="${counter + 1}" scope="page" />
												</c:forEach>
												<p>
													<i class="far fa-calendar-alt mr-1" aria-hidden="true"></i>
													Total Responds: <strong>${counter}</strong>
												</p>


											</div>
											<!-- Card content -->

										</div>
										<!-- Card -->

										<!-- Card -->
										<div class="card card-cascade narrower">

											<!-- Card image -->
											<div
												class="view view-cascade gradient-card-header blue-gradient">
												<h4 class="font-weight-500 mb-0">Sender Request</h4>
											</div>
											<!-- Card image -->

											<!-- Card content -->
											<div class="card-body card-body-cascade">
												<p>
													<strong>Subject: </strong>${contactUs.subject}
												</p>
												<br>
												<p>
													<strong>Message: </strong> ${contactUs.message}

												</p>
											</div>
											<!-- Card content -->

										</div>
										<!-- Card -->

									</div>
									<!-- Grid column -->

								</div>
								<!-- Grid row -->

							</section>
							<!-- Section: Create Page -->




						</div>
					</div>
				</section>
			</div>
		</main>
	</div>

	<%@ include file="home/footer.jsp"%>




</body>
</html>