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

											<div id="inquriyResponsesMsg">

												<c:forEach var="responseDB" items="${Inquiry.responses}">
													<div class="card">
														
															<div class="card-header  ${Inquiry.user.userID eq responseDB.user.userID ? 'blue' : 'green'} z-depth-1" role="tab"
																	id="heading98">
																	<h5 class="text-uppercase mb-0 py-1">
																		<a class="collapsed font-weight-bold white-text"
																			data-toggle="collapse"
																			href="#${responseDB.responseID}"
																			aria-expanded="false" aria-controls="collapse98">
																			Responded by ${responseDB.user.name} 
																			</a>
																	</h5>
																	<span class="font-weight-bold white-text text-right mr-0" > ${responseDB.preetyTime} </span>
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
																		<div class="font-weight-bold">${responseDB.message}</div>
																	</div>
																	<div class="col-md-4 mt-0 pt-0">

																		<button class="btn btn-danger"
																			onclick="deleteResponsessINQ('${responseDB.responseID}')">Delete
																			Response</button>

																	</div>
																</div>
																<div class="row my-4">
																	<c:forEach var="image" items="${responseDB.images}">
																		<div class="ml-4">
																			<img src="data:image/jpg;base64,${image}" alt=""
																				class="img-fluid">
																		</div>
																	</c:forEach>
																</div>
															</div>
														</div>
													</div>

												</c:forEach>
												

											</div>
											<div id="newResponses"></div>


										</div>
										<!--Accordion wrapper-->

										<!-- First card -->
										<div id="uploadNewImage">

											<button id="uploadNewImage_btn" class="btn btn-primary">Add
												New Image</button>

										</div>
										<!-- Second card -->
										<div class="card mb-4">

											<div class="file-upload-wrapper" id="image1Div"
												style="display: none">
												<input type="file" id="image1" class="file-upload"
													data-height="120" />
											</div>

											<div class="file-upload-wrapper" id="image2Div"
												style="display: none">
												<input type="file" id="image2" class="file-upload"
													data-height="120" />
											</div>

											<div class="file-upload-wrapper" id="image3Div"
												style="display: none">
												<input type="file" id="image3" class="file-upload"
													data-height="120" />
											</div>

											<div id="progress"></div>

										</div>
										<!-- Second card -->

										<div class="card mb-4">
											<textarea id="messagetex" class="form-control" rows="8">Write Your response here!</textarea>


											<input type="hidden" name="inqID"
												value="${Inquiry.inquiryID}" id="inqID" class="form-control">
										</div>
										<div class="mt-4">
											<button type="button" onclick="addResponseINQ()"
												class="btn btn-primary btn-lg btn-block mt-2 mb-5">Respond
												Now</button>


										</div>


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
													value="${Inquiry.inquiryID}">
												<p>
													<i class="fas fa-flag mr-1" aria-hidden="true"></i> Name: <strong>${Inquiry.user.name}</strong>
												</p>
												<p>
													<i class="far fa-eye mr-1" aria-hidden="true"></i> Email: <strong>${Inquiry.user.email}</strong>
												</p>
												<p>
													<i class="fas fa-archive mr-1 mr-1" aria-hidden="true"></i>
													Phone: <strong>${Inquiry.user.phone}</strong>
												</p>
												<p>
													<i class="far fa-calendar-alt mr-1" aria-hidden="true"></i>
													Time: <strong>${Inquiry.time}</strong>
												</p>
												<p>
													<i class="far fa-calendar-alt mr-1" aria-hidden="true"></i>
													Total Responds: <strong><span id="respponsesSize" >${Inquiry.responses.size()}</span></strong>
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
													<strong>Subject: </strong>${Inquiry.subject}
												</p>
												<br>
												<p>
													<strong>Message: </strong> ${Inquiry.message}

												</p>
												<c:forEach var="image" items="${Inquiry.images}">
													<div class="">
														<img src="data:image/jpg;base64,${image}" alt=""
															class="img-fluid">
													</div>
												</c:forEach>
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
	<script>
	startTrackingNewResponses();
	</script>

</body>
</html>