<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>User Security</title>

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

										<li class="nav-item"><a class="nav-link"
											data-toggle="tab" href="#" role="tab" id="myProfile"
											aria-selected="true">1. User Profile</a></li>

										<li class="nav-item"><a class="nav-link "
											data-toggle="tab" id="myOrders" href="#" role="tab"
											aria-selected="false">2. Orders</a></li>

										<li class="nav-item"><a class="nav-link active"
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
											<div class="row d-flex justify-content-center">
												<div class="col-md-6">
													<form oninput="passwordUpdateCheck()">
														<div class="row">
															<div class="col-md-12 mb-4">
																<label for="cc-name123">Current Password</label> <input
																	type="password" class="form-control"
																	id="currentPassword" name="currentPassword">
															</div>

														</div>
														<div class="row">
															<div class="col-md-6 mb-3">
																<label for="cc-expiration123">New Password</label> <input
																	type="text" class="form-control" id="newPassword"
																	name="newPassword" disabled> <span
																	id="newEnter" style="display: none"><small
																	class="text-muted">Enter your new password</small></span> <span
																	id="short" style="display: none"><small
																	class="text-muted">Your password is too short</small></span> <span
																	id="match" style="display: none"><small
																	class="text-muted">Passwords do not match</small></span> <span
																	id="conditionPass" style="display: none"><small
																	class="text-muted">Your password must be at 8
																		to 15 of length which contain at least one lowercase
																		letter, one uppercase letter, one numeric digit, and
																		one special character</small></span>
															</div>
															<div class="col-md-6 mb-3">
																<label for="cc-cvv123">Repeat Password</label> <input
																	type="text" class="form-control" id="repeatPass"
																	disabled>
																<div class="invalid-feedback show">Security code
																	required</div>
															</div>
														</div>


														<div class="row d-flex justify-content-center">
															<div id="UpdatePassword" style="display: none">
																<button class="btn btn-indigo" type="button"
																	onclick="updatePassword()">update Password</button>
															</div>
														</div>
													</form>
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
</body>
</html>