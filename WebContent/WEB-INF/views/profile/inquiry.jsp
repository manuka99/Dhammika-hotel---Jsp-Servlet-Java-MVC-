<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Customer Complain</title>

</head>
<body class="homepage-v1 hidden-sn white-skin animated" id="body">
	<%@ include file="../home/header.jsp"%>

	<div id="userProfileInfo" class="view intro-2"
		style="background: #bdc3c7; /* fallback for old browsers */ background: -webkit-linear-gradient(to right, #2c3e50, #bdc3c7); /* Chrome 10-25, Safari 5.1-6 */ background: linear-gradient(to right, #2c3e50, #bdc3c7); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */; background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<div style="height: 80px"></div>
		<div aria-busy="true">
			<div class="container mt-5">


				<!--Section: Content-->
				<section class="dark-grey-text">


					<div class="card">
						<div class="card-body">

							<!--Grid row-->
							<div class="row">

								<!--Grid column-->
								<div class="col-lg-12">

									<!-- Pills navs -->
									<ul
										class="nav md-pills nav-justified pills-primary font-weight-bold">

										<li class="nav-item"><a class="nav-link "
											data-toggle="tab" href="#" role="tab" id="myProfile"
											aria-selected="true">1. User Profile</a></li>

										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" id="myOrders" href="#" role="tab"
											aria-selected="false">2. Orders</a></li>

										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" id="mySecurity" href="#" role="tab"
											aria-selected="false">3. Security</a></li>

										<li class="nav-item"><a class="nav-link active"
											data-toggle="tab" id="myComplains" href="#" role="tab"
											aria-selected="false">4. User Complains</a></li>

									</ul>

									<!-- Pills panels -->

									<div id="ContentChange">




										<div id="supportEmailPlatForm">

											<hr class="mb-4">

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

														<!-- Second card -->
														<div id="uploadNewImage">

															<button id="uploadNewImage_btn" class="btn btn-primary">Add
																New Image</button>

														</div>
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
																value="${Inquiry.inquiryID}" id="inqID"
																class="form-control">
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
																<h4 class="font-weight-500 mb-0">Complain
																	Information</h4>
															</div>
															<!-- Card image -->

															<!-- Card content -->
															<div class="card-body card-body-cascade">
																<input type="hidden" id="contactUsID"
																	value="${Inquiry.inquiryID}">

																<p>
																	<i class="fas fa-archive mr-1 mr-1" aria-hidden="true"></i>
																	Inquiry ID: <strong>${Inquiry.inquiryID}</strong>
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
																<h4 class="font-weight-500 mb-0">Complain Message</h4>
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
									<!-- Pills panels -->




								</div>
								<!--Grid column-->

								<!--Grid column-->

								<!--Grid column-->

							</div>
							<!--Grid row-->

						</div>
					</div>

				</section>
				<!--Section: Content-->


			</div>
		</div>
		<div style="height: 60px"></div>
	</div>


	<%@ include file="../home/footer.jsp"%>

	<script>
		startTrackingNewResponses();

		function startTrackingNewResponses() {
			var inqID = $('#contactUsID').val();
			var respponsesSize = $('#respponsesSize').text();
			$.ajax({

				url : "RetrieveNewInquiryResponsesUser",
				data : {
					'inquiryID' : inqID
				},

				success : function(data, textStatus, jqXHR) {

					var result = $(data).find('#inquriyResponsesMsg');
					var responsesListRecieved = $(data).find('#respponsesSize')
							.text();
					$('#newResponses').append(result);
					$('#respponsesSize').text(
							+responsesListRecieved + +respponsesSize);
					if (responsesListRecieved > 0)
						toastr.success('You have new messages');
					//$('.file-upload').file_upload();
				}

			})
			setTimeout(startTrackingNewResponses, 10000);
		};
	</script>

</body>
</html>