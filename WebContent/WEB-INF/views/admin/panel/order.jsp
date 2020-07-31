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
<style type="text/css">
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
						<div class="card">
							<!-- Card -->
							<c:forEach var="order" items="${orderList}">
								<div class="wish-list mb-4">
									<div class="skin-light card-body">
										<h3 class="mb-4">
											<span class="text-muted">Order ID</span> <strong>#${order.orderID}</strong>
											<button class="btn btn-lg ml-4 btn-primary"
												onclick="editOrderNotification('${order.orderID}', '${order.userID}')">Edit
												Order</button>
										</h3>

										<hr class="mb-4">
										<c:forEach var="cart" items="${order.itemList}">
											<div class="row mb-4">
												<div class="col-md-5 col-lg-3 col-xl-3">
													<div
														class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
														<img class="img-fluid w-100"
															src="data:image/jpg;base64,${cart.key.image}"
															style="width: 150px; height: 150px; display: block; margin: auto;"
															alt="Sample"> <a href="#!">
															<div class="mask waves-effect waves-light">
																<img class="img-fluid w-100"
																	src="data:image/jpg;base64,${cart.key.image}"
																	style="width: 150px; height: 150px; display: block; margin: auto;">
																<div
																	class="mask rgba-black-slight waves-effect waves-light"></div>
															</div>
														</a>
													</div>
												</div>
												<div class="col-md-7 col-lg-9 col-xl-9">
													<div>
														<div class="d-flex justify-content-between">
															<div>
																<h5>${cart.key.name}</h5>
																<p class="mb-3 text-muted text-uppercase small">${cart.key.portion}</p>
																<p class="mb-2 text-muted text-uppercase small">${cart.key.description}</p>
																<p class="mb-2 text-muted text-uppercase small">Rs.${cart.key.price}</p>
															</div>

															<div>

																<div class="mb-0 w-100">
																	<div class="md-form  mb-0">
																		<input type="text" id="discount-code"
																			class="form-control font-weight-light"
																			value="Quantity ${cart.value}" disabled>
																	</div>

																	<div class="md-form  mb-0">
																		<input type="text" id="discount-code"
																			class="form-control font-weight-light"
																			value="Sum Total Rs.${cart.key.price * cart.value}"
																			disabled>
																	</div>

																</div>
															</div>
														</div>
														<div
															class="d-flex justify-content-between align-items-center">
															<div>

																<div class="mb-0 w-100"></div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<hr class="mb-4">

										</c:forEach>


									</div>
								</div>
								<!-- Card -->




								<!-- Card -->
								<div class="container-fluid mb-4">
									<div class="card-body">

										<h5 class="mb-3">Delivery Summary</h5>

										<ul class="list-group list-group-flush">
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Order Placed Date <span>${order.pDate}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Estimated Delivery Date <span>${order.estimatedDate}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Shipping Address<span>${order.shippingAddress}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
												<div>
													<strong>Delivered Date</strong> <strong> </strong>
												</div> <span><strong>${order.dDate}</strong></span>

											</li>
										</ul>
									</div>
								</div>
								<div class="container-fluid mb-4">
									<div class="card-body">

										<h5 class="mb-3">CheckOut Summary</h5>

										<ul class="list-group list-group-flush">
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Value of the Products<span>Rs.${order.subTotal}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Tax and Vat <span>Rs.${order.tax}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Shipping Fee<span>Rs.${order.shippingFee}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
												<div>
													<strong>Total value of the order</strong> <strong>
														<p class="mb-0">(including VAT, TAX and Shipping)</p>
													</strong>
												</div> <span><strong>Rs.${order.total}</strong></span>

											</li>
										</ul>
									</div>
								</div>
								<div class="container-fluid mb-4">
									<div class="card-body">
										<h5 class="mb-3">Payment Summary</h5>

										<ul class="list-group list-group-flush">
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Payment Mode <span>${order.orderType}</span>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center px-0">
												Payment Status <span>${order.payment}</span>
											</li>

											<c:if test="${order.orderType != 'COD' }">
												<li
													class="list-group-item d-flex justify-content-between align-items-center px-0">
													Payment Amount<span>Rs.${order.total}</span>
												</li>

												<li
													class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
													<div>
														<strong>Transaction ID</strong> <strong> </strong>
													</div> <span><strong>${order.transactionID}</strong></span>

												</li>
											</c:if>
											<c:if test="${order.orderType == 'COD' }">

												<li
													class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
													<div>
														<strong>Total Amount Payable</strong> <strong> </strong>
													</div> <span><strong>Rs.${order.total}</strong></span>

												</li>

											</c:if>

										</ul>

									</div>
								</div>
								<!-- Card -->
							</c:forEach>

						</div>
						
						<div id="orderEditModalDiv">
						</div>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->

					<!-- Grid column -->
				</section>
			</div>
			<!-- Grid row -->

		</main>
	</div>


	<%@ include file="home/footer.jsp"%>

</body>
</html>