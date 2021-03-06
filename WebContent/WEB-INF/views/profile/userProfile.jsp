<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>User Profile</title>

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

										<li class="nav-item"><a class="nav-link active"
											data-toggle="tab" href="#" role="tab" id="myProfile"
											aria-selected="true">1. User Profile</a></li>

										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" id="myOrders" href="#" role="tab"
											aria-selected="false">2. Orders</a></li>

										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" id="mySecurity" href="#" role="tab"
											aria-selected="false">3. Security</a></li>

										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" id="myComplains" href="#" role="tab"
											aria-selected="false">4. User Complains</a></li>

									</ul>

									<!-- Pills panels -->

									<div id="ContentChange">

										<div class="">




											<hr class="mb-4">
											<!--Card content-->
											<form id="UserProfileForm" oninput="inputForm()">

												<!--Grid row-->
												<div class="row"></div>
												<!--Grid row-->

												<!--Username-->
												<div class="input-group mb-4">
													<div class="input-group-prepend">
														<span class="input-group-text" id="basic-addon1">@</span>
													</div>
													<input type="text" class="form-control py-0"
														value="${basicDetails.name}" id="name" name="name"
														aria-describedby="basic-addon1" required>
												</div>

												<!--email-->
												<label for="email" class="active">Email</label> <input
													type="text" id="email" name="email"
													class="form-control mb-4" value="${basicDetails.email}"
													required> <label for="phone" class="active">Phone
													Number</label> <input type="number" id="phone" name="phone"
													class="form-control mb-4" value="${basicDetails.phone}"
													required>

												<!--address-->
												<label for="address" class="active">Shipping Address</label>
												<input type="text" id="address" name="address"
													class="form-control mb-4" value="${basicDetails.address}"
													required> <label for="date" class="active">Date
													Of Birth</label> <input type="date" id="dateOfBirth"
													name="dateOfBirth" class="form-control mb-4"
													value="${basicDetails.dateOfBirth}" required>

												<!--Grid row-->
												<div class="row">

													<!--Grid column-->
													<div class="col-lg-4 col-md-12 mb-4">

														<label for="country">Country</label> <select
															class="custom-select d-block w-100" id="country" disabled>
															<option value="">Sri lanka</option>
														</select>

													</div>
													<!--Grid column-->




												</div>
												<!--Grid row-->

												<hr>

												<div id="updateProfile">
													<button class="btn btn-indigo" type="button"
														onclick="updateProfile()">update profile</button>
												</div>

											</form>

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
</body>
</html>
