<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Customer Complains</title>




</head>
<body class="homepage-v1 hidden-sn white-skin animated" id="body">
	<%@ include file="../home/header.jsp"%>

	<div id="userProfileInfo" class="view intro-2"
		style="background: #bdc3c7;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #2c3e50, #bdc3c7);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #2c3e50, #bdc3c7); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
; background-repeat: no-repeat; background-size: cover; background-position: center center;">
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
										<hr class="mb-4">
										<div class="wrapper-editor">

											<!--Card content-->

											<div
												class="d-flex justify-content-center buttons-wrapper my-3">

												<button data-toggle="modal" data-target="#inquiryAddModal"
													data-backdrop="static" data-keyboard="false"
													class=" btn btn-rounded text-white purple
           											     lighten-2 add-new-row"
													type="button">
													<i class="fas fa-plus"></i> New Complain/inquiry
												</button>

											</div>

											<table
												class="table table-hover table-striped table-responsive-lg text-center "
												id="ordersTable">
												<thead>
													<tr>
														<th scope="col"></th>
														<th scope="col">InquiryID</th>
														<th scope="col">Subject</th>
														<th scope="col">Time</th>
													</tr>
												</thead>
												<tbody>
													<%
														int i = 1;
													%>
													<c:forEach var="Inquiry" items="${InquiryDBList}">
														<tr>
															<td><%=i++%></td>
															<td><a class="text-primary link"
																onclick="MoreOnInquiry('${Inquiry.inquiryID}')">${Inquiry.inquiryID}</a></td>
															<td>${Inquiry.subject}</td>
															<td>${Inquiry.time}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>


										<!-- Modal: modalQuickView -->
										<div id="inquiryAddModalDiv">
											<div class="modal fade" id="inquiryAddModal">
												<div class="modal-dialog modal-lg" role="">
													<div class="modal-content">
														<div class="modal-body">
															<div class="row">
																<div class="container">
																	<!--Carousel Wrapper-->
																	<div id="carousel-thumb"
																		class="carousel slide carousel-fade carousel-thumbnails"
																		data-ride="carousel">
																		<!--Slides-->
																		<div class="carousel-inner" role="listbox">
																			<div class="carousel-item active">

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
																		</div>
																	</div>
																	<!--/.Carousel Wrapper-->
																</div>
																<div class="container">
																	<h2 class="h2-responsive product-name">

																		<div id="uploadNewImage">
																			<button id="uploadNewImage_btn"
																				class="btn btn-primary">Add New Image</button>
																		</div>


																		<div class="md-form">
																			<input type="text" id="subject" class="form-control">
																			<label class="active" for="subject">Subject</label>
																		</div>



																	</h2>
																	<h4 class="h4-responsive">
																		<span class="green-text">
																			<div class="md-form">
																				<input type="text" id="message" class="form-control">
																				<label class="active" for="message">Message</label>
																			</div>


																		</span>
																	</h4>




																	<!-- Add to Cart -->
																	<div class="card-body">
																		<div class="row">
																			<div class="col-md-6"></div>
																			<div class="col-md-6"></div>
																		</div>
																		<div class="row">
																			<div class="text-center">
																				<hr class="mb-4">
																				<button type="button" class="btn btn-secondary"
																					data-dismiss="modal">Close</button>
																				<button class="btn btn-primary"
																					onclick="addNewInquiryDetails()">Add new
																					Inquiry</button>
																			</div>
																		</div>
																	</div>
																	<!-- /.Add to Cart -->
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

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
	<!-- SCRIPTS -->
	<!-- JQuery -->





</body>
</html>