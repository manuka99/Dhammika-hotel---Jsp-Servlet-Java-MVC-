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
<title>User Order</title>

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

										<li class="nav-item"><a class="nav-link active"
											data-toggle="tab" id="myOrders" href="#" role="tab"
											aria-selected="false">2. Orders</a></li>

										<li class="nav-item"><a class="nav-link "
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
											<!-- Card -->
											<c:forEach var="order" items="${OrderList}">
												<div class="wish-list mb-4">
													<div class="skin-light card-body">

													

														<h3 class="mb-4">
															<span class="text-muted">Order ID</span> <strong>#${order.orderID}</strong>
																<button class="btn btn-lg ml-4 btn-danger" onclick="canceMyOrder('${order.orderID}')" >Cancel Order</button>
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

														<p class="text-primary mb-0">
															<i class="fas fa-info-circle mr-1"></i>If you have any
															issue regarding the order please ring to our hotline or
															drop us a mail. Thank You!
														</p>

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
																		<strong>Total Amount Payable</strong> <strong>
																		</strong>
																	</div> <span><strong>Rs.${order.total}</strong></span>

																</li>

																<p class="text-primary mb-0">
																	<i class="fas fa-info-circle mr-1"></i>Please do keep
																	the above amount ready when we reach you. Thank You!
																</p>
															</c:if>

														</ul>

													</div>
												</div>
												<!-- Card -->
											</c:forEach>






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
</body>
</html>