<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Cart</title>

</head>
<body class="homepage-v1 hidden-sn white-skin animated">


	<div class="intro-2"
		style="background: rgb(227, 60, 133); background: linear-gradient(90deg, rgba(227, 60, 133, 1) 0%, rgba(50, 127, 219, 0.630987429151348) 100%); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<div style="height: 80px"></div>
		<div id="headerRefresh">
			<%@ include file="../home/header.jsp"%>
		</div>

		<div id="loadMyCart">
			<div class="container skin-light">

				<!--Section: Block Content-->
				<section class="mt-5 mb-4">

					<!--Grid row-->
					<div class="row">

						<!--Grid column-->
						<div class="col-lg-8">

							<!-- Card -->
							<div class="card wish-list mb-4">
								<div class="card-body">

									<h5 class="mb-4">
										Cart (<span>${CartDetails.itemCount}</span> items)
									</h5>

									<c:forEach var="cart" items="${CartDetails.cartItemList}">


										<c:choose>
											<c:when test="${cart.fooditem.active eq true}">
												<div class="row mb-4">
													<div class="col-md-5 col-lg-3 col-xl-3">
														<div
															class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
															<img class="img-fluid w-100"
																src="data:image/jpg;base64,${cart.fooditem.image}"
																style="width: 150px; height: 150px; display: block; margin: auto;"
																alt="Sample"> <a href="#!">
																<div class="mask waves-effect waves-light">
																	<img class="img-fluid w-100"
																		src="data:image/jpg;base64,${cart.fooditem.image}"
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
																	<h5>${cart.fooditem.name}</h5>
																	<p class="mb-3 text-muted text-uppercase small">${cart.fooditem.portion}</p>
																	<p class="mb-2 text-muted text-uppercase small">${cart.fooditem.description}</p>
																</div>
																<div>
																	<div
																		class="def-number-input number-input safari_only mb-0 w-100">
																		<button
																			onclick="this.parentNode.querySelector('input[type=number]').stepDown(), updateQuantity('${cart.fooditem.itemID}')"
																			class="minus"></button>
																		<input class="quantity" min="1"
																			id="quantity${cart.fooditem.itemID}"
																			value="${cart.quantity}" name="quantity" value="1"
																			type="number">
																		<button
																			onclick="this.parentNode.querySelector('input[type=number]').stepUp(), updateQuantity('${cart.fooditem.itemID}')"
																			class="plus"></button>
																	</div>
																</div>
															</div>
															<div
																class="d-flex justify-content-between align-items-center">
																<div>
																	<a onclick="removeItemID(${cart.fooditem.itemID})"
																		type="button"
																		class="card-link-secondary small text-uppercase mr-3"><i
																		class="fas fa-trash-alt mr-1"></i> Remove item </a>
																</div>
																<p class="mb-0">
																	<span><strong>Rs.${cart.fooditem.price}</strong></span>
																</p>
															</div>
														</div>
													</div>
												</div>
											</c:when>
											<c:otherwise>
												<div class="row mb-4">
													<div class="col-md-5 col-lg-3 col-xl-3">
														<div
															class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
															<img class="img-fluid w-100"
																src="data:image/jpg;base64,${cart.fooditem.image}"
																style="width: 150px; height: 150px; display: block; margin: auto;"
																alt="Sample">
															<div
																class="mask pattern-4 flex-center waves-effect waves-light">
																<p class="white-text">Not Available</p>
															</div>

														</div>
													</div>
													<div class="col-md-7 col-lg-9 col-xl-9">
														<div>
															<div class="d-flex justify-content-between">
																<div>
																	<h5>
																		<del>${cart.fooditem.name}</del>
																	</h5>
																	<p class="mb-3 text-muted text-uppercase small">
																		<del>${cart.fooditem.portion}</del>
																	</p>
																	<p class="mb-2 text-muted text-uppercase small">
																		<del>${cart.fooditem.description}</del>
																	</p>
																</div>
																<div>
																	<div
																		class="def-number-input number-input safari_only mb-0 w-100">
																		<button class="minus"></button>
																		<input class="quantity" min="1" value="1"
																			type="number">
																		<button class="plus"></button>
																	</div>
																</div>
															</div>
															<div
																class="d-flex justify-content-between align-items-center">
																<div>
																	<a 
																		type="button"
																		class="card-link-secondary small text-uppercase mr-3"><i
																		class="fas fa-trash-alt mr-1"></i> Remove item </a>
																</div>
																<p class="mb-0">
																	<span><strong><del>Rs.${cart.fooditem.price}</del></strong></span>
																</p>
															</div>
														</div>
													</div>
												</div>
											</c:otherwise>
										</c:choose>


										<hr class="mb-4">

									</c:forEach>
									<p class="text-primary mb-0">
										<i class="fas fa-info-circle mr-1"></i> Do not delay the
										purchase, adding items to your cart does not mean booking
										them.
									</p>

								</div>
							</div>
							<!-- Card -->

							<!-- Card -->
							<div class="card mb-4">
								<div class="card-body">

									<h5 class="mb-4">Expected shipping delivery</h5>

									<p class="mb-0">Thu., 12.03. - Mon., 16.03.</p>
								</div>
							</div>
							<!-- Card -->

							<!-- Card -->
							<div class="card mb-4">
								<div class="card-body">

									<h5 class="mb-4">We accept</h5>

									<img class="mr-2" width="45px"
										src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
										alt="Visa"> <img class="mr-2" width="45px"
										src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
										alt="American Express"> <img class="mr-2" width="45px"
										src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
										alt="Mastercard"> <img class="mr-2" width="45px"
										src="https://z9t4u9f6.stackpathcdn.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
										alt="PayPal acceptance mark">
								</div>
							</div>
							<!-- Card -->

						</div>
						<!--Grid column-->

						<!--Grid column-->
						<div class="col-lg-4">

							<!-- Card -->
							<div class="card mb-4">
								<div class="card-body">

									<h5 class="mb-3">Shopping Cart</h5>


									<ul class="list-group list-group-flush">
										<li
											class="list-group-item d-flex justify-content-between align-items-center px-0">
											Value of the Products<span>Rs.${CartDetails.productPriceTotal}</span>
										</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center px-0">
											Tax and Vat <span>Rs.${CartDetails.tax}</span>
										</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center px-0">
											Shipping Fee<span>Rs.${CartDetails.shippingFee}</span>
										</li>
										<li
											class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
											<div>
												<strong>Total Amount Payable</strong> <strong>
													<p class="mb-0">(including VAT)</p>
												</strong>
											</div> <span><strong>Rs.${CartDetails.total}</strong></span>

										</li>

									</ul>
									<form action="checkOut" method="post">
										<button type="submit"
											class="btn btn-primary btn-block waves-effect waves-light">Checkout
											Now</button>
									</form>

								</div>
							</div>
							<!-- Card -->

							<!-- Card -->
							<div class="card mb-4">
								<div class="card-body">

									<a class="dark-grey-text d-flex justify-content-between"
										data-toggle="collapse" href="#collapseExample"
										aria-expanded="false" aria-controls="collapseExample"> Add
										a discount code (optional) <span><i
											class="fas fa-chevron-down pt-1"></i></span>
									</a>

									<div class="collapse" id="collapseExample">
										<div class="mt-3">
											<div class="md-form md-outline mb-0">
												<input type="text" id="discount-code"
													class="form-control font-weight-light"
													placeholder="Enter discount code">
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- Card -->

						</div>
						<!--Grid column-->

					</div>
					<!--Grid row-->

				</section>
				<!--Section: Block Content-->

			</div>






		</div>

		<%@ include file="../home/footer.jsp"%>
	</div>


	<!-- SCRIPTS -->
	<script>
	
	function updateQuantity(itemID) {

		var newQty = $('#quantity'+ itemID).val();
		console.log(newQty);

			$
					.ajax({

						url : "UpdateMyCartItem",
						data : {
							'itemID' : itemID,
							newQty : newQty,

						},

						success : function(data) {
							if (data == 'success') {									
								$("#headerRefresh").load(location.href + " #headerRefresh");
								$("#loadMyCart").load(location.href + " #loadMyCart");
								toastr.success('cart was updated');
							}

							else {
								toastr.error('Maximum quantity of an item cannot exceeds 3 and should be at least 1');
								$("#headerRefresh").load(location.href + " #headerRefresh");
								$("#loadMyCart").load(location.href + " #loadMyCart");
								
							}

						}

					})


	};

		function removeItemID(itemID) {

				$
						.ajax({

							url : "RemoveCartItem",
							data : {
								'itemID' : itemID
							},

							success : function(data) {
								if (data == 'success') {
									$("#headerRefresh").load(location.href + " #headerRefresh");
									$("#loadMyCart").load(location.href + " #loadMyCart");
									toastr.success('item was removed');
								}

								else if (data == 'failed') {
									$("#headerRefresh").load(location.href + " #headerRefresh");
									$("#loadMyCart").load(location.href + " #loadMyCart");
									toastr.error('item was not removed');
								}

								else {
									window.location.href = "UserLogOut";
									toastr.error('you dont have access');
								}

							}

						})

		};
	</script>

</body>
</html>

