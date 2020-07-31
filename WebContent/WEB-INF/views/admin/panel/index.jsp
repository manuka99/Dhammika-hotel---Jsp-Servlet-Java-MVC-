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

						<section class="mt-md-4 pt-md-2 mb-5 pb-4">

							<!-- Grid row -->
							<div class="row">

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-xl-0 mb-4">

									<!-- Card -->
									<div class="card card-cascade cascading-admin-card">

										<!-- Card Data -->
										<div class="admin-up">
											<i class="far fa-money-bill-alt primary-color mr-3 z-depth-2"></i>
											<div class="data">
												<p class="text-uppercase">All orders</p>
												<h4 class="font-weight-bold dark-grey-text">#DP132</h4>
											</div>
										</div>

										<!-- Card content -->
										<div class="card-body card-body-cascade">
											<div class="progress mb-3">
												<div class="progress-bar bg-primary" role="progressbar"
													aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
													style="width: 100%"></div>
											</div>
											<p class="card-text">counts all orders cancelled to
												completed</p>
										</div>

									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-xl-0 mb-4">

									<!-- Card -->
									<div class="card card-cascade cascading-admin-card">

										<!-- Card Data -->
										<div class="admin-up">
											<i class="fas fa-chart-line warning-color mr-3 z-depth-2"></i>
											<div class="data">
												<p class="text-uppercase">Completed Orders</p>
												<h4 class="font-weight-bold dark-grey-text">#DP231</h4>
											</div>
										</div>

										<!-- Card content -->
										<div class="card-body card-body-cascade">
											<div class="progress mb-3">
												<div class="progress-bar red accent-2" role="progressbar"
													aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
													style="width: 100%"></div>
											</div>
											<p class="card-text">Dynamic Graphs by year based on the
												completed orders</p>
										</div>

									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-md-0 mb-4">

									<!-- Card -->
									<div class="card card-cascade cascading-admin-card">

										<!-- Card Data -->
										<div class="admin-up">
											<i
												class="fas fa-chart-pie light-blue lighten-1 mr-3 z-depth-2"></i>
											<div class="data">
												<p class="text-uppercase">Cancelled Orders</p>
												<h4 class="font-weight-bold dark-grey-text">#DP1212</h4>
											</div>
										</div>

										<!-- Card content -->
										<div class="card-body card-body-cascade">
											<div class="progress mb-3">
												<div class="progress-bar red accent-2" role="progressbar"
													aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
													style="width: 100%"></div>
											</div>
											<p class="card-text">Find out the modes in which the
												orders was cancelled</p>
										</div>

									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-0">

									<!-- Card -->
									<div class="card card-cascade cascading-admin-card">

										<!-- Card Data -->
										<div class="admin-up">
											<i class="fas fa-chart-bar red accent-2 mr-3 z-depth-2"></i>
											<div class="data">
												<p class="text-uppercase">COD Orders</p>
												<h4 class="font-weight-bold dark-grey-text">#TUF131</h4>
											</div>
										</div>

										<!-- Card content -->
										<div class="card-body card-body-cascade">
											<div class="progress mb-3">
												<div class="progress-bar bg-primary" role="progressbar"
													aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
													style="width: 100%"></div>
											</div>
											<p class="card-text">Get the orders completed with cash
												on delivery</p>
										</div>

									</div>
									<!-- Card -->

								</div>
								<!-- Grid column -->

							</div>
							<!-- Grid row -->

						</section>


						<!-- Section: Chart -->
						<section class="mb-5 mt-5">

							<!-- Card -->
							<div class="card card-cascade narrower">
								<section>

									<!-- Grid row -->
									<div class="row">

										<!-- Grid column -->
										<div class="col-xl-5 col-lg-12 mr-0 pb-2">

											<!-- Card image -->
											<div
												class="view view-cascade gradient-card-header light-blue lighten-1">
												<h2 class="h2-responsive mb-0 font-weight-500">All
													Orders Placed</h2>
											</div>

											<!-- Card content -->
											<div class="card-body card-body-cascade pb-0">

												<!-- Panel data -->
												<div class="row py-3 pl-4">

													<!-- First column -->
													<div class="col-md-6">

														<!-- Date select -->
														<p class="lead">
															<span class="badge info-color p-2" id="dataRange">This
																year</span>
														</p>


														<!-- Date pickers -->
														<p class="lead pt-3 pb-4">
															<span class="badge info-color p-2">Select Custom
																Year</span>
														</p>
														<div class="md-form">
															<input placeholder="Select year" type="text" id="toYear"
																class="form-control yearonlyDatePicker"> <label
																for="date-picker-example"></label>
														</div>
													</div>
													<!-- First column -->

													<!-- Second column -->
													<div class="col-md-6 text-center pl-xl-2 my-md-0 my-3">

														<!-- Summary -->
														<p>
															Total Value: <strong><span
																id="totalValueOfOrders"></span></strong>
														</p>
														<p>
															Total Orders: <strong><span id="totalNoOrders"></span></strong>
														</p>

														<!-- Change chart -->
														<span class="min-chart my-4" id="chart-sales"
															data-percent="99"><span class="percent"></span></span>
														<h5>
															<button class="badge red accent-2 p-2"
																onclick="orderChartManagement()">
																Change Data <i class="fas fa-arrow-circle-up ml-1"></i>
															</button>
															<button type="button" class="btn btn-info btn-sm p-2"
																data-toggle="tooltip" data-placement="top"
																title="Percentage is the acuracy of the data displayed">
																<i class="fas fa-question"></i>
															</button>
														</h5>

													</div>
													<!-- Second column -->

												</div>
												<!-- Panel data -->

											</div>
											<!-- Card content -->

										</div>
										<!-- Grid column -->

										<!-- Grid column -->
										<div class="col-xl-7 col-lg-12 mb-4 pb-2">

											<!-- Chart -->
											<div
												class="view view-cascade gradient-card-header blue-gradient">

												<canvas id="lineChart" height="175"></canvas>

											</div>

										</div>
										<!-- Grid column -->

									</div>
									<!-- Grid row -->

								</section>
							</div>
						</section>
						<!-- Section: Chart -->



						<div class="container-fluid mt-5">

							<!-- Heading & Date -->
							<div class="row mb-5 mt-lg-5">

								<!-- First column -->
								<div class="col-md-6 panel-title mb-5 mt-3">
									<h5>
										<span
											class="px-4 py-3 white-text z-depth-1-half blue lighten-1"
											style="border-radius: 5px;">Completed vs Cancelled </span>
									</h5>
								</div>
								<!-- First column -->

								<!-- Second column -->
								<div class="col-md-6">

									<div class="card">

										<div class="card-body pb-1">

											<!-- Grid row -->
											<div class="container">

												<!-- Grid column -->

												<div class="md-form">
													<input placeholder="Select year" type="text"
														onchange="orderChartManagement2()" id="toYear2"
														class="form-control yearonlyDatePicker"> <label
														for="date-picker-example"></label>
												</div>

												<!-- Grid column -->
											</div>
											<!-- Grid column -->

										</div>
										<!-- Grid column -->

									</div>
									<!-- Grid row -->

								</div>

							</div>
							<!-- Second column -->

						</div>
						<!-- Heading & Date -->


						<!-- Section: Main chart -->
						<section>

							<!-- Card -->
							<div class="card card-cascade narrower">

								<!-- Card image -->
								<div
									class="view view-cascade gradient-card-header blue-gradient">
									<canvas id="sales"></canvas>
								</div>
								<!-- Card image -->

								<!-- Card content -->
								<div class="card-body card-body-cascade blue-panel text-center">

									<!-- Second row -->
									<div class="row mx-3 mb-0 text-center">
										<!-- Grid column -->
										<div class="col mt-1 mb-2">

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-info btn-md active"> <input
													type="checkbox" name="options" id="option1"
													autocomplete="off" checked>Total completed Sales <strong><span
														id="totalCSales">Rs.1000</span></strong> <i
													class="fas fa-arrow-up ml-2 white-text"></i> <strong>
												</strong>

												</label>

											</div>

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-info btn-md"> <input
													type="checkbox" name="options" id="option2"
													autocomplete="off">Total completed Orders <strong><span
														id="totalCorders">1000</span></strong> <i
													class="fas fa-arrow-up ml-2 white-text"></i> <strong>
												</strong>

												</label>

											</div>



										</div>
										<!-- Grid column -->

									</div>
									<!-- Second row -->

									<!-- Third row -->
									<div class="row mx-3 mb-2 text-center">

										<!-- First column -->
										<div class="col">


											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn red accent-2 btn-md text-white"> <input
													type="checkbox" name="options" id="option2"
													autocomplete="off">Total cancelled Sales <strong><span
														id="totalCancellSales">Rs.1000</span></strong> <i
													class="fas fa-arrow-down ml-2 white-text"></i> <strong>
												</strong>

												</label>

											</div>

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn red accent-2 btn-md text-white"> <input
													type="checkbox" name="options" id="option2"
													autocomplete="off">Total cancelled Orders <strong><span
														id="totalCancellorders">1000</span></strong> <i
													class="fas fa-arrow-down ml-2 white-text"></i> <strong>
												</strong>

												</label>

											</div>

										</div>
										<!-- Second column -->

									</div>



									<div class="row mx-3 mb-5 text-center">

										<!-- First column -->
										<div class="col">




											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-primary btn-md"> <input
													type="radio" name="options" id="option1" autocomplete="off"
													checked>Months

												</label>

											</div>

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-primary btn-md"> <input
													type="radio" name="options" id="option2" autocomplete="off">Years

												</label>

											</div>

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-primary btn-md"> <input
													type="radio" name="options" id="option3" autocomplete="off">Sales

												</label>

											</div>

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-primary btn-md"> <input
													type="radio" name="options" id="option4" autocomplete="off">Orders
												</label>

											</div>

											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-primary btn-md"> <input
													type="radio" name="options" id="option4" autocomplete="off">Completed
												</label>

											</div>
											<div class="btn-group mt-1" data-toggle="buttons">

												<label class="btn btn-primary btn-md"> <input
													type="radio" name="options" id="option4" autocomplete="off">Cancelled
												</label>

											</div>


										</div>
										<!-- Second column -->

									</div>
									<!-- Third row -->

									<!-- Third row -->
									<div class="row mb-0">

										<!-- First column -->
										<div class="col-md-12">

											<!-- Panel content -->
											<div class="card-body pt-0">

												<!-- Table -->
												<div class="table-responsive">

													<table class="table table-hover">

														<!-- Table head -->
														<thead class="rgba-stylish-strong white-text">

															<tr>
																<th></th>
																<th>January</th>
																<th>February</th>
																<th>March</th>
																<th>April</th>
																<th>May</th>
																<th>June</th>
																<th>July</th>
																<th>August</th>
																<th>September</th>
																<th>October</th>
																<th>November</th>
																<th>December</th>
															</tr>

														</thead>
														<!-- Table head -->

														<!-- Table body -->
														<tbody id="ordwersColumns">

														</tbody>
														<!-- Table body -->
													</table>

												</div>
												<!-- Table -->

												<!-- Bottom Table UI -->
												<div class="d-flex justify-content-between">

													<!-- Name -->

												</div>
												<!-- Bottom Table UI -->

											</div>
											<!-- Panel content -->

										</div>
										<!-- First column -->
									</div>
									<!-- Third row -->

								</div>
								<!-- Card content -->

							</div>
							<!-- Card -->

						</section>
						<!-- Section: Main chart -->



						<div class="container-fluid">

							<!-- Section: Analytical panel -->
							<section class="mt-md-4 pt-md-2 mb-5">

								<!-- Card -->
								<div class="card card-cascade narrower">

									<!-- Section: Chart -->
									<section>

										<!-- Grid row -->
										<div class="row">

											<!-- Grid column -->
											<div class="col-xl-5 col-md-12 mr-0">

												<!-- Card image -->
												<div
													class="view view-cascade gradient-card-header light-blue lighten-1">
													<h4 class="h4-responsive mb-0 font-weight-bold">Orders
														Placed Based on mode</h4>
												</div>

												<!-- Card content -->
												<div class="card-body card-body-cascade pb-0">

													<!-- Panel data -->
													<div class="row card-body pt-3">

														<!-- First column -->
														<div class="col-md-12">

															<!-- Date select -->
															<p class="lead">
																<span class="badge success-color p-2">Default
																	Data is for current year </span>
															</p>

															<p class="lead">
																<span class="badge danger-color ">This
																	information may not be 100% accurate.</span>
															</p>

															<p class="lead">
																<span class="badge danger-color ">This Data
																	calculated to the nearest whole number.</span>
															</p>

															<!-- Date pickers -->
															<p class="lead pt-3 pb-2">
																<span class="badge primary-color p-2">Manual
																	input date</span>
															</p>
															<div class="d-flex justify-content-between">
																<div class="md-form w-100 mr-2">
																	<input placeholder="Input year" type="text"
																		id="toYear3" oninput="orderByTypeBar()"
																		class="form-control ">
																</div>
																<div class="md-form w-100 ml-2">
																	<input placeholder="Input month" type="text"
																		class="form-control " id="toMonth3"
																		oninput="orderByTypeBar()">
																</div>
															</div>

														</div>
														<!-- First column -->

													</div>
													<!-- Panel data -->

												</div>
												<!-- Card content -->

											</div>
											<!-- Grid column -->

											<!-- Grid column -->
											<div class="col-xl-7 col-md-12 mb-4">

												<!-- Chart -->
												<div
													class="view view-cascade gradient-card-header blue-gradient">

													<canvas id="traffic" height="170px"></canvas>

												</div>

											</div>
											<!-- Grid column -->

										</div>
										<!-- Grid row -->

									</section>
									<!-- Section: Chart -->

								</div>
								<!-- Card -->

							</section>
							<!-- Section: Analytical panel -->
						</div>





						<div class="container-fluid">

							<!-- Section: Analytical panel -->
							<section class="mt-md-4 pt-md-2 mb-5">

								<!-- Card -->
								<div class="card card-cascade narrower">

									<!-- Section: Chart -->
									<section>

										<!-- Grid row -->
										<div class="row">

											<!-- Grid column -->
											<div class="col-xl-5 col-md-12 mr-0">

												<!-- Card image -->
												<div
													class="view view-cascade gradient-card-header light-blue lighten-1">
													<h4 class="h4-responsive mb-0 font-weight-bold">Orders
														Completed Based on mode</h4>
												</div>

												<!-- Card content -->
												<div class="card-body card-body-cascade pb-0">

													<!-- Panel data -->
													<div class="row card-body pt-3">

														<!-- First column -->
														<div class="col-md-12">

															<!-- Date select -->
															<p class="lead">
																<span class="badge success-color p-2">Default
																	Data is for current year </span>
															</p>

															<p class="lead">
																<span class="badge danger-color ">This
																	information may not be 100% accurate.</span>
															</p>

															<p class="lead">
																<span class="badge danger-color ">This Data
																	calculated to the nearest whole number.</span>
															</p>

															<!-- Date pickers -->
															<p class="lead pt-3 pb-2">
																<span class="badge primary-color p-2">Manual
																	input date</span>
															</p>
															<div class="d-flex justify-content-between">
																<div class="md-form w-100 mr-2">
																	<input placeholder="Input year" type="text"
																		id="toYear4" oninput="ordersCompletedeBar()"
																		class="form-control ">
																</div>
																<div class="md-form w-100 ml-2">
																	<input placeholder="Input month" type="text"
																		class="form-control " id="toMonth4"
																		oninput="ordersCompletedeBar()">
																</div>
															</div>

														</div>
														<!-- First column -->

													</div>
													<!-- Panel data -->

												</div>
												<!-- Card content -->

											</div>
											<!-- Grid column -->

											<!-- Grid column -->
											<div class="col-xl-7 col-md-12 mb-4">

												<!-- Chart -->
												<div
													class="view view-cascade gradient-card-header blue-gradient">

													<canvas id="ordercom" height="170px"></canvas>

												</div>

											</div>
											<!-- Grid column -->

										</div>
										<!-- Grid row -->

									</section>
									<!-- Section: Chart -->

								</div>
								<!-- Card -->

							</section>
							<!-- Section: Analytical panel -->
						</div>


						<section class="pb-3 mt-4 mb-4">

							<!-- Grid row -->
							<div class="row">

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-xl-0 mb-4">

									<!-- Card Primary -->
									<div class="card classic-admin-card primary-color">
										<div class="card-body">
											<div class="pull-right">
												<i class="far fa-money-bill-alt"></i>
											</div>
											<p class="white-text">Top products</p>
											<h4 class="check">#TP212</h4>
										</div>
										<div class="progress">
											<div class="progress-bar bg grey darken-3" role="progressbar"
												aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"
												style="width: 25%"></div>
										</div>
										<div class="card-body">
											<p>Easily distinguish the top sold products.</p>
										</div>
									</div>
									<!-- Card Primary -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-xl-0 mb-4">

									<!-- Card Yellow -->
									<div class="card classic-admin-card warning-color">
										<div class="card-body">
											<div class="pull-right">
												<i class="fas fa-chart-line"></i>
											</div>
											<p>Product of the month</p>
											<h4 class="check">#PM276</h4>
										</div>
										<div class="progress">
											<div class="progress-bar bg grey darken-3" role="progressbar"
												aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"
												style="width: 25%"></div>
										</div>
										<div class="card-body">
											<p>Get the most purchased product with easy</p>
										</div>
									</div>
									<!-- Card Yellow -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-md-0 mb-4">

									<!-- Card Blue -->
									<div class="card classic-admin-card light-blue lighten-1">
										<div class="card-body">
											<div class="pull-right">
												<i class="fas fa-chart-pie"></i>
											</div>
											<p>X axis</p>
											<h4 class="check">Product ID</h4>
										</div>
										<div class="progress">
											<div class="progress-bar bg grey darken-4" role="progressbar"
												aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"
												style="width: 75%"></div>
										</div>
										<div class="card-body">
											<p>Product identification number is represented by the x
												axis</p>
										</div>
									</div>
									<!-- Card Blue -->

								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col-xl-3 col-md-6 mb-0">

									<!-- Card Red -->
									<div class="card classic-admin-card red accent-2">
										<div class="card-body">
											<div class="pull-right">
												<i class="fas fa-chart-bar"></i>
											</div>
											<p>Y axis</p>
											<h4 class="check">Quantity Sold</h4>
										</div>
										<div class="progress">
											<div class="progress-bar bg grey darken-4" role="progressbar"
												aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"
												style="width: 25%"></div>
										</div>
										<div class="card-body">
											<p>Quantity sold of the respective product id is
												displayed by y axis.</p>
										</div>
									</div>
									<!-- Card Red -->

								</div>
								<!-- Grid column -->

							</div>
							<!-- Grid row -->

						</section>


						<div class="container-fluid mt-4">

							<!-- Section: Analytical panel -->
							<section class=" mt-4 ">

								<!-- Card -->
								<div class="card card-cascade narrower">

									<!-- Section: Chart -->
									<section>

										<!-- Grid row -->
										<div class="">

											<!-- Grid column -->
											<div class="  ">

												<!-- Card image -->
												<div
													class="view view-cascade gradient-card-header light-blue lighten-1">
													<h4 class="h4-responsive mb-0 font-weight-bold">Products
														vs Sales</h4>
												</div>

												<!-- Card content -->
												<div class="card-body card-body-cascade pb-0">

													<!-- Panel data -->
													<div class=" card-body pt-3">

														<!-- First column -->
														<div class="">

															<!-- Date select -->
															<p class="lead">
																<span class="badge success-color p-2">Default
																	Data is for current year and month.</span>
															</p>

															<p class="lead">
																<span class="badge danger-color ">This
																	information 100% accurate with real time update.</span>
															</p>

															<p class="lead">
																<span class="badge danger-color ">Do note that
																	this data calculated to the nearest whole number.</span>
															</p>

															<!-- Date pickers -->
															<p class="lead pt-3 pb-2">
																<span class="badge primary-color p-2">Manual
																	input date</span>
															</p>
															<div class="d-flex justify-content-between">
																<div class="md-form w-100 mr-2">
																	<input placeholder="Input year" type="text"
																		id="toYear5" oninput="ordersProductsSaleBar()"
																		class="form-control ">
																</div>
																<div class="md-form w-100 ml-2">
																	<input placeholder="Input month" type="text"
																		class="form-control " id="toMonth5"
																		oninput="ordersProductsSaleBar()">
																</div>
															</div>

														</div>
														<!-- First column -->

													</div>
													<!-- Panel data -->

												</div>
												<!-- Card content -->

											</div>
											<!-- Grid column -->

											<!-- Grid column -->
											<div class=" mb-4">

												<!-- Chart -->
												<div
													class="view view-cascade gradient-card-header blue-gradient">

													<canvas id="orderProduct" height="180px"></canvas>


												</div>

											</div>
											<!-- Grid column -->

										</div>
										<!-- Grid row -->

									</section>
									<!-- Section: Chart -->

								</div>
								<!-- Card -->

							</section>
							<!-- Section: Analytical panel -->
						</div>



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

