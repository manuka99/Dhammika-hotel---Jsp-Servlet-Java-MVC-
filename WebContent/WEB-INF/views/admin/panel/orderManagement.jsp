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

						<div id="dataTableFood">
							<!-- Table with panel -->
							<div class="card card-cascade narrower">

								<!--Card image-->
								<div
									class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">

									<div>
										<button type="button"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-th-large mt-0"></i>
										</button>
										<button type="button"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-columns mt-0"></i>
										</button>
									</div>





									<a href="" class="white-text mx-3">${userListInfoName}</a>



									<div>
										<button type="button" onclick="editOrder()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										<button type="button" onclick="deleteOrders()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="far fa-trash-alt mt-0"></i>
										</button>
										<button type="button" onclick="viewUserOrderInvoice()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-info-circle mt-0"></i>
										</button>
									</div>

								</div>
								<!--/Card image-->

								<div class="px-4">

									<div class="table-wrapper">
										<!--Table-->
										<div id="adadadaedrervvv" class="table-responsive">
											<table id="dtMaterialDesignExample"
												class="table table-hover mb-0">

												<!--Table head-->
												<thead>
													<tr>
														<th></th>
														<th scope="col">OrderID</th>
														<th scope="col">User ID</th>
														<th scope="col">Order Placed Date</th>
														<th scope="col">PaymentType</th>
														<th scope="col">Payment</th>
														<th scope="col">status</th>
													</tr>
												</thead>
												<!--Table head-->

												<!--Table body-->
												<tbody>
													<c:forEach var="orders" items="${orderList}">
														<tr>
															<th scope="row"><input class="form-check-input"
																type="checkbox" id="${orders.orderID}"
																value="${orders.orderID}" name="items"> <label
																class="form-check-label" for="${orders.orderID}"
																class="label-table"></label></th>
															<td>${orders.orderID}</td>
															<td>${orders.userID}</td>
															<td>${orders.pDate}</td>
															<td>${orders.orderType}</td>
															<td>${orders.payment}</td>
															<td>${orders.status}</td>
														</tr>
													</c:forEach>
												</tbody>
												<!--Table body-->
											</table>
											<!--Table-->
										</div>

									</div>
								</div>

							</div>
							<!-- Table with panel -->
						</div>



						<!-- Modal: modalQuickView -->
						<div id="orderEditModalDiv">
							<div class="modal fade" id="orderEditModal">
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
															<div class="carousel-item active"></div>
														</div>
													</div>
													<!--/.Carousel Wrapper-->
												</div>
												<div class="container">
													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="hidden" id="userID" value="${orderReq.userID}">
															<input type="text" id="oid" value="${orderReq.orderID}"
																class="form-control" disabled> <input
																type="hidden" id="orderID" value="${orderReq.orderID}"
																class="form-control" disabled> <label
																class="active text-success" for="oid">Order ID</label>

														</div>
													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="uid" value="${orderReq.userID}"
																	class="form-control" disabled> <label
																	class="active text-success" for="uid">User ID</label>
															</div>


														</span>
													</h4>
													<br>
													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="text" id="tax" value="${orderReq.tax}"
																class="form-control" disabled> <label
																class="active text-success" for="tax">Tax</label>
														</div>
													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="shipingg"
																	value="${orderReq.shippingFee}" class="form-control"
																	disabled> <label class="active text-success"
																	for="shipingg">Shipping Fee</label>
															</div>


														</span>
													</h4>
													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="text" id="orders" class="form-control"
																value="${orderReq.subTotal}" disabled> <label
																class="active text-success" for="orders">Sub
																Total </label>
														</div>
													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="ordert" value="${orderReq.total}"
																	class="form-control" disabled> <label
																	class="active text-success" for="ordert">Order
																	Total</label>
															</div>
														</span>
													</h4>
													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="text" id="ordertt" class="form-control"
																value="${orderReq.orderType}" disabled> <label
																class="active text-success" for="ordertt">Payment
																Type </label>
														</div>



													</h2>

													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="text" id="tid" class="form-control"
																value="${orderReq.transactionID}" disabled> <label
																class="active text-success" for="tid">Payment
																TransactionID </label>
														</div>

													</h2>
													<br>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="sha"
																	value="${orderReq.shippingAddress}"
																	class="form-control" disabled> <label
																	class="active text-success" for="sha">Order
																	Shipping Address </label>
															</div>


														</span>
													</h4>



													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="pdate" value="${orderReq.pDate}"
																	class="form-control" disabled> <label
																	class="active text-success" for="pdate">Order
																	Placed Date Status</label>
															</div>


														</span>
													</h4>
													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="text" id="ed" class="form-control"
																value="${orderReq.estimatedDate}" disabled> <label
																class="active text-success" for="ed">Order
																Expected Date</label>
														</div>

													</h2>


													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="status"
																	value="${orderReq.status}" class="form-control">
																<label class="active text-danger" for="status">Order
																	Shipping Status</label>
															</div>


														</span>
													</h4>
													<br>
													<h2 class="h2-responsive product-name">
														<div class="md-form">
															<input type="date" id="dDate" class="form-control"
																value="${orderReq.dDate}"> <label
																class="active text-danger" for="dDate">Order
																Delivered Date</label>
														</div>

													</h2>

													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="payment"
																	value="${orderReq.payment}" class="form-control">
																<label class="active text-danger" for="payment">Order
																	Payment Status </label>

															</div>


														</span>
													</h4>
													<!-- Add to Cart -->
													<div class="card-body">
														<div class="row">
															<div class="col-md-6"></div>

															<div class="col-md-6"></div>
														</div>
														<hr class="mb-4">
														<div class="row">
															<div class="text-center">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<button class="btn btn-primary" onclick="updateOrder()">Update
																	Oder Details</button>

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










						<!-- Modal: modalQuickView -->
						<div id="orderInVoiceModalDiv">
							<div class="modal fade" id="orderInVoiceModal">
								<div class="modal-dialog modal-lg" role="">
									<div class="modal-content">
										<div class="modal-body">
											<div class="row">
												<div class="container">
													<section class="mb-4">

														<div class="card">
															<div class="card-body d-flex justify-content-between">
																<h4 class="h4-responsive mt-3">OrderID
																	#${orderReq.orderID}</h4>
																<input type="hidden" id="orderID"
																	value="${orderReq.orderID}" class="form-control"
																	disabled>

																<div>
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">Close</button>
																	<a class="btn btn-primary waves-effect waves-light"
																		href="#"><i class="fas fa-print left"></i> Print</a>
																</div>

															</div>
														</div>

													</section>

													<section class="mb-4">

														<div class="card">
															<div class="card-body">

																<!-- Grid row -->
																<div class="row">

																	<!-- Grid column -->
																	<div class="col-md-6 text-left">

																		<p>
																			<small>Delivery:</small>
																		</p>
																		<p>
																			<strong>Order Type: ${orderReq.orderType}</strong>
																		</p>

																		<p>
																			<strong>Order Placed date:</strong> ${orderReq.pDate}
																		</p>
																		<p>
																			<strong>Order Expected date:</strong>
																			${orderReq.estimatedDate}
																		</p>

																	</div>
																	<!-- Grid column -->

																	<!-- Grid column -->
																	<div class="col-md-6 text-right">

																		<h4 class="h4-responsive">
																			<small>User ID,</small><br> <strong><span
																				class="blue-text">#${orderReq.userID}</span></strong>
																		</h4>

																		<p></p>
																		<p>
																			<strong>Shipping Address</strong>
																		</p>
																		<p>${orderReq.shippingAddress}</p>

																	</div>
																	<!-- Grid column -->

																</div>
																<!-- Grid row -->

															</div>
														</div>

													</section>



													<section class="mb-5">

														<div class="card">
															<div class="card-body">

																<div class="table-responsive">
																	<table class="table">
																		<thead>
																			<tr>
																				<th>Item ID</th>
																				<th>Item Name</th>
																				<th>Quantity</th>
																				<th>Unit Price</th>
																				<th>Tax</th>
																				<th>Total price</th>
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach var="product" items="${orderReq.itemList}">
																				<tr>
																					<td>${product.key.itemID}</td>
																					<td>${product.key.name}</td>
																					<td>${product.value}</td>
																					<td>Rs.${product.key.price}</td>
																					<td>Rs.${product.key.tax}</td>
																					<td>Rs.${product.key.price * product.value}</td>
																				</tr>
																			</c:forEach>
																		</tbody>
																	</table>
																</div>

																<div class=" ">
																	<div class="">

																		<h5 class="mb-4"></h5>

																		<ul class="list-group list-group-flush">
																			<li
																				class="list-group-item d-flex justify-content-between align-items-center px-0">
																				Sub Total of the Products<span>Rs.${orderReq.subTotal}</span>
																			</li>
																			<li
																				class="list-group-item d-flex justify-content-between align-items-center px-0">
																				Tax and Vat <span>Rs.${orderReq.tax}</span>
																			</li>
																			<li
																				class="list-group-item d-flex justify-content-between align-items-center px-0">
																				Shipping Fee<span>Rs.${orderReq.shippingFee}</span>
																			</li>
																			<li
																				class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
																				<div>
																					<strong>Total value of the order</strong> <strong>
																						<p class="mb-0">(including VAT, TAX and
																							Shipping)</p>
																					</strong>
																				</div> <span><strong>Rs.${orderReq.total}</strong></span>
																			</li>
																			<li
																				class="list-group-item d-flex justify-content-between align-items-center px-0">

																				Payment Status<span>${orderReq.payment}</span>

																			</li>
																			<c:if
																				test="${orderReq.transactionID != '' &&  orderReq.transactionID  != null}">

																				<li
																					class="list-group-item d-flex justify-content-between align-items-center px-0">
																					<strong>Transaction ID</strong><span>${orderReq.transactionID}</span>

																				</li>
																			</c:if>



																		</ul>
																	</div>
																</div>

															</div>
														</div>

													</section>

												</div>
											</div>
										</div>
									</div>
								</div>

							</div>

						</div>


					</div>
				</section>
			</div>
		</main>
	</div>

	<%@ include file="home/footer.jsp"%>





</body>
</html>