<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Material Design Bootstrap</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="Design/panel/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="Design/panel/css/mdb.min.css">

<!-- Your custom styles (optional) -->
<style>
</style>
<style type="text/css">/* Chart.js */
@
-webkit-keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
@
keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	-webkit-animation: chartjs-render-animation 0.001s;
	animation: chartjs-render-animation 0.001s;
}
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

						<section class="section team-section">

							<!-- Grid row -->
							<div class="row text-center">

								<!-- Grid column -->
								<div class="col-md-8 mb-4">

									<!-- Card -->
									<div class="card card-cascade cascading-admin-card user-card">

										<form oninput="inputFormPanel()">

											<!-- Card Data -->
											<div class="admin-up d-flex justify-content-start">
												<i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
												<div class="data">
													<h5 class="font-weight-bold dark-grey-text">
														Edit Profile - <span class="text-muted">Complete
															your profile</span>
													</h5>
												</div>
											</div>
											<!-- Card Data -->

											<!-- Card content -->
											<div class="card-body card-body-cascade">

												<!-- Grid row -->
												<div class="row">

													<!-- Grid column -->
													<div class="col-md-12">

														<div class="md-form form-sm mb-0">
															<input class="form-control form-control-sm" id="name"
																type="text" value="${userProfile.name}"> <label
																class="active" for="form6">User Name</label>
														</div>

													</div>
													<!-- Grid column -->

												</div>
												<!-- Grid row -->

												<!-- Grid row -->
												<div class="row">

													<!-- Grid column -->
													<div class="col-md-12">

														<div class="md-form form-sm mb-0">
															<input class="form-control form-control-sm" id="email"
																type="email" value="${userProfile.email}"> <label
																class="active" for="form6">User Email</label>
														</div>

													</div>
													<!-- Grid column -->

												</div>
												<!-- Grid row -->

												<!-- Grid row -->
												<div class="row">

													<!-- Grid column -->
													<div class="col-md-12">

														<div class="md-form form-sm mb-0">
															<input class="form-control form-control-sm" id="address"
																type="text" value="${userProfile.address}"> <label
																class="active" for="form6">Address</label>
														</div>

													</div>
													<!-- Grid column -->

												</div>
												<!-- Grid row -->



												<!-- Grid row -->
												<div class="row">

													<!-- Grid column -->
													<div class="col-md-12">

														<div class="md-form form-sm mb-0">
															<input class="form-control form-control-sm"
																id="dateOfBirth" type="date"
																value="${userProfile.dateOfBirth}"> <label
																class="active" for="form6">Date Of Birth</label>
														</div>

													</div>
													<!-- Grid column -->

												</div>
												<!-- Grid row -->

												<!-- Grid row -->
												<div class="row">

													<!-- Grid column -->
													<div class="col-md-12">

														<div class="md-form form-sm mb-0">
															<input class="form-control form-control-sm" id="phone"
																type="text" value="${userProfile.phone}"> <label
																class="active" for="form6">Phone</label>
														</div>

													</div>
													<!-- Grid column -->

												</div>
												<!-- Grid row -->

												<!-- Grid row -->
												<div class="row">

													<!-- Grid column -->
													<div class="col-lg-4 col-md-6">

														<div class="md-form form-sm mb-0">
															<input class="text-primary form-control form-control-sm"
																id="form8" value="Sri lanka" type="text" disabled>
															<label class="active" for="form8">Country</label>
														</div>

													</div>
													<!-- Grid column -->

												</div>
												<!-- Grid row -->

											</div>
											<!-- Card content -->
											<div id="updateProfile">
												<button class="btn btn-info btn-rounded waves-effect waves-light" type="button"
													onclick="updateProfilePanel()">update profile</button>
											</div>
										</form>
									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-md-4 mb-4">

									<!-- Card -->
									<div class="card profile-card">

										<i class="fas fa-shield-alt fa-6x"></i>


										<div class="card-body pt-0 mt-0">

											<!-- Name -->
											<h3 class="mb-3 font-weight-bold">
												<strong>Profile Security</strong>
											</h3>
											<h6 class="font-weight-bold cyan-text mb-4">Change
												Password</h6>

											<p class="mt-4 text-muted">
											<form oninput="passwordUpdatePanelCheck()">
												<div class="row">
													<div class="col-md-12 mb-4">
														<label for="cc-name123">Current Password</label> <input
															type="password" class="form-control" id="currentPassword"
															name="currentPassword">
													</div>

												</div>
												<div class="row">
													<div class="col-md-6 mb-3">
														<label for="cc-expiration123">New Password</label> <input
															type="text" class="form-control" id="newPassword"
															name="newPassword" disabled> <span id="newEnter"
															style="display: none"><small class="text-muted">Enter
																your new password</small></span> <span id="short" style="display: none"><small
															class="text-muted">Your password is too short</small></span> <span
															id="match" style="display: none"><small
															class="text-muted">Passwords do not match</small></span> <span
															id="conditionPass" style="display: none"><small
															class="text-muted">Your password must be at 8 to
																15 of length which contain at least one lowercase
																letter, one uppercase letter, one numeric digit, and one
																special character</small></span>
													</div>
													<div class="col-md-6 mb-3">
														<label for="cc-cvv123">Repeat Password</label> <input
															type="text" class="form-control" id="repeatPass" disabled>
														<div class="invalid-feedback show">Security code
															required</div>
													</div>
												</div>


												<div class="row d-flex justify-content-center">
													<div id="UpdatePassword" style="display: none">
														<button
															class="btn btn-info btn-rounded waves-effect waves-light"
															type="button" onclick="updatePasswordPanel()">update
															Password</button>
													</div>
												</div>
											</form>



											</p>


										</div>

									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->

							</div>
							<!-- Grid row -->

						</section>









					</div>
				</section>
			</div>

		</main>


	</div>



	<%@ include file="home/footer.jsp"%>

	<script>
		
	</script>

</body>
</html>

