<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>User Orders</title>
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
											<table
												class="table table-hover table-striped table-responsive-lg text-center "
												id="ordersTable">
												<thead>
													<tr>
														<th scope="col"></th>
														<th scope="col">OrderID</th>
														<th scope="col">Order Placed Date</th>
														<th scope="col">PaymentType</th>
														<th scope="col">Payment</th>
														<th scope="col">status</th>
													</tr>
												</thead>
												<tbody>
													<%
														int i = 1;
													%>
													<c:forEach var="order" items="${OrderList}">
														<tr>
															<td><%=i++%></td>
															<td><a class="text-primary link"
																onclick="MoreOnOrder('${order.orderID}')">${order.orderID}</a></td>
															<td>${order.pDate}</td>
															<td>${order.orderType}</td>
															<td>${order.payment}</td>
															<td>${order.status}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>




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