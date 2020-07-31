<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Checkout v2</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="Design/mdPro/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="Design/mdPro/css/mdb.min.css" rel="stylesheet">
<link href="Design/mdPro/css/style.css" rel="stylesheet">



</head>


<body class="homepage-v1 hidden-sn white-skin animated">
	<div class="intro-2"
		style="background: rgb(227, 60, 133); background: linear-gradient(90deg, rgba(227, 60, 133, 1) 0%, rgba(50, 127, 219, 0.630987429151348) 100%); background-repeat: no-repeat; background-size: cover; background-position: center center;">

		<div id="headerRefresh">
			<%@ include file="../home/header.jsp"%></div>

		<div class="container mt-5 pt-3">
			<h2 class="my-5 h2 text-center">Express Checkout</h2>

			<div class="container wow fadeIn">

				<!-- Heading -->

				<c:set var="orderID" scope="page" value="${param.orderID}" />
				<c:forEach var="order" items="${orderIdList}">
					<c:if test="${order.key eq orderID}">


						<!--Grid row-->
						<div class="row">

							<!--Grid column-->
							<div class="col-md-8 mb-4">

								<!--Card-->
								<div class="card">




									<!--Card content-->
									<form class="card-body" id="checkoutForm" action=""
										method="POST">

										<!--Username-->
										<div class="md-form input-group pl-0 mb-5">
											<div class="input-group-prepend">
												<span class="input-group-text" id="basic-addon1">@</span>
											</div>
											<input type="text" class="form-control py-0"
												value="${order.value.customer.name}"
												aria-describedby="basic-addon1" disabled> <input
												type="hidden" class="form-control py-0"
												value="${order.value.orderID}" name="orderID" id="orderID"
												aria-describedby="basic-addon1" disabled>
										</div>

										<!--email-->
										<div class="md-form mb-5">
											<input type="text" id="email" class="form-control"
												value="${order.value.customer.email}" disabled> <label
												for="email" class="active">Email (optional)</label>
										</div>

										<!--address-->
										<div class="md-form mb-5">
											<input type="text" id="address" class="form-control"
												value="${order.value.customer.address}" disabled> <label
												for="address" class="active">Address</label>
										</div>

										<!--Grid row-->
										<div class="row">

											<!--Grid column-->
											<div class="col-lg-4 col-md-12 mb-4">

												<label for="country">Country</label> <select
													class="custom-select d-block w-100" id="country" disabled>
													<option value="">Srilanka</option>
												</select>

											</div>
											<!--Grid column-->
										</div>
										<!--Grid row-->

										<hr>

										<label for="date" class="active">Delivery Date</label> <input
											type="date" id="dDate" name="dDate" class="form-control mb-4"
											required>
										<hr>

										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												id="same-address" checked> <label
												class="custom-control-label" for="same-address">Shipping
												address is the same as my billing address</label>
										</div>

										<hr>

										<div id="addressBill" class="md-form mb-5"
											style="display: none">
											<input type="text" id="address2" name="address2"
												class="form-control"> <label for="address"
												class="active">Shipping Address</label>
										</div>

										<div class="form-check mb-4">
											<input type="radio" class="form-check-input" id="paypal"
												name="orderType" value="paypal" checked> <label
												class="form-check-label" for="paypal">PayPal(USD)</label>
										</div>

										<div class="form-check mb-4">
											<input type="radio" class="form-check-input" id="payhere"
												name="orderType" value="payhere"> <label
												class="form-check-label" for="payhere">PayHere(LKR)</label>
										</div>

										<div class="form-check">
											<input type="radio" class="form-check-input" id="cod"
												name="orderType" value="COD"> <label
												class="form-check-label" for="cod">Cash on Delivery
											</label>
										</div>


										<hr class="mb-4">
										<p class="text-primary mb-0">
											<i class="fas fa-info-circle mr-1"></i>We will be delivering
											from 10.00 A.M to 7.00 PM, your order will be delivered on
											time. Thank you!
										</p>

										<hr class="mb-4">

										<button id="placeOrder"
											class="btn btn-primary btn-lg btn-block waves-effect waves-light"
											type="button">Place Order</button>

									</form>

								</div>
								<!--/.Card-->

							</div>
							<!--Grid column-->

							<!--Grid column-->
							<div class="col-md-4 mb-4">

								<!-- Heading -->
								<h4
									class="d-flex justify-content-between align-items-center mb-3">
									<span class="">Order Items</span>
								</h4>

								<!-- Cart -->
								<ul class="list-group mb-3 z-depth-1">

									<c:forEach var="item" items="${order.value.itemList}">

										<li
											class="list-group-item d-flex justify-content-between lh-condensed">
											<div>
												<h6 class="my-0">${item.key.name}</h6>
												<small class="text-muted">QTY ${item.value}</small>
											</div> <span class="text-muted">Rs.${item.key.price}</span>
										</li>


									</c:forEach>

									<li class="list-group-item d-flex justify-content-between"><span>Sum
											of the products (LKR)</span> <strong>Rs.${order.value.subTotal}</strong></li>

									<li class="list-group-item d-flex justify-content-between"><span>Tax
											(LKR)</span> <strong>Rs.${order.value.tax}</strong></li>

									<li class="list-group-item d-flex justify-content-between"><span>Shipping
											Fee (LKR)</span> <strong>Rs.${order.value.shippingFee}</strong></li>


									<li class="list-group-item d-flex justify-content-between"><span>Total
											(LKR)</span> <strong>Rs.${order.value.total}</strong></li>
								</ul>
								<!-- Cart -->

								<!-- Promo code -->
								<form class="card p-2">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="Promo code" aria-label="Recipient's username"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-secondary btn-md waves-effect m-0"
												type="button">Redeem</button>
										</div>
									</div>
								</form>
								<!-- Promo code -->

							</div>
							<!--Grid column-->

						</div>
						<!--Grid row-->
					</c:if>

				</c:forEach>
			</div>

		</div>
		<div class="mb-5"></div>
		<%@ include file="../home/footer.jsp"%>
	</div>




	<!-- SCRIPTS -->
	<!-- JQuery -->
	<!-- JQuery -->
	<script type="text/javascript"
		src="Design/mdPro/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="Design/mdPro/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="Design/mdPro/js/bootstrap.min.js">
		
	</script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="Design/mdPro/js/mdb.min.js"></script>
	<script type="text/javascript">
		/* WOW.js init */
		new WOW().init();
		// Tooltips Initialization
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})

		// Material Select Initialization
		$(document).ready(function() {
			$('.mdb-select').material_select();
		});

		// SideNav Initialization
		$(".button-collapse").sideNav();
	</script>

	<script type="text/javascript"
		src="https://www.payhere.lk/lib/payhere.js"></script>
	<script type="text/javascript">
		$('#same-address').change(function() {

			if (!this.checked) {

				$('#addressBill').slideDown();

			}

			else
				$('#addressBill').slideUp();

		});

		$("#placeOrder")
				.on(
						"click",
						function() {

							var radioValue = $(
									"input[name='orderType']:checked").val();
							var address2 = $("#address2").val();
							var orderID = $("#orderID").val();
							var dDate = $('#dDate').val();
							
							if ($('input[id="same-address"]:checked').length === 0
									&& address2.length === 0)
								alert('please confirm your shipping address');

							else {
								if (dDate.length != 0) {

									if (radioValue == 'payhere') {

										var payment = {};

										$.ajax({
											url : 'placeOrder',
											type : 'POST',
											data : {
												'orderType' : radioValue,
												'address2' : address2,
												'orderID' : orderID,
												'dDate':dDate

											},
											dataType : 'json',
											success : function(data) {
												payment = data;
												payhere.startPayment(payment);

											}
										})

									}

									else {

										var form = document
												.createElement("form");
										var element1 = document
												.createElement("input");
										var element2 = document
												.createElement("input");
										var element3 = document
												.createElement("input");

										var element4 = document
										.createElement("input");
										
										form.method = "POST";
										form.action = "placeOrder";

										element1.value = orderID;
										element1.name = "orderID";
										form.appendChild(element1);

										element2.value = address2;
										element2.name = "address2";
										form.appendChild(element2);

										element3.value = radioValue;
										element3.name = "orderType";
										form.appendChild(element3);

										element4.value = dDate;
										element4.name = "dDate";
										form.appendChild(element4);
										
										document.body.appendChild(form);

										form.submit();

									}
								} else
									alert('Please enter the delivery date');
								//$('#checkoutForm').attr('action', "placeOrder").submit();

							}

						});

		// Called when user completed the payment. It can be a successful payment or failure
		payhere.onCompleted = function onCompleted(orderId) {
			console.log("Payment completed. OrderID:" + orderId);
			//Note: validate the payment and show success or failure page to the customer
		};

		// Called when user closes the payment without completing
		payhere.onDismissed = function onDismissed() {
			//Note: Prompt user to pay again or show an error page
			console.log("Payment dismissed");
		};

		// Called when error happens when initializing payment such as invalid parameters
		payhere.onError = function onError(error) {
			// Note: show an error page
			console.log("Error:" + error);
		};
	</script>

</body>
</html>