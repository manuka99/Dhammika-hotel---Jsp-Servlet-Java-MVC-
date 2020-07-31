
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.FoodPub.Model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home Page</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="Design/mdPro/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="Design/mdPro/css/mdb.min.css" rel="stylesheet">

<link href="Design/mdPro/css/style.css" rel="stylesheet">

<link href="Design/mdPro/css/modules/animations-extended.css"
	rel="stylesheet">
<link href="Design/mdPro/css/modules/animations-extended.min.css"
	rel="stylesheet">

<link href="Design/mdPro/css/addons/datatables.css" rel="stylesheet">
<link href="Design/mdPro/css/addons/datatables.min.css" rel="stylesheet">
<link href="Design/mdPro/css/mdb.ecommerce.min.css" rel="stylesheet">
<link href="Design/mdPro/css/upload-file.css" rel="stylesheet">
<link href="Design/mdPro/css/mdb-pro.min.css" rel="stylesheet">
<link href="Design/panel/css/myCustomNotifications.css" rel="stylesheet">
</head>
<body class="homepage-v1 hidden-sn white-skin animated">
	<header>

		<!-- Navbar -->
		<nav
			class="navbar fixed-top navbar-expand-lg navbar-light scrolling-navbar white">

			<div class="container">

				<!-- SideNav slide-out button -->
				<div class="float-left mr-2">

					<a class="button-collapse" href="#" data-activates="slide-out">

						<i class="fas fa-home"></i>

					</a>

				</div>

				<a class="navbar-brand font-weight-bold" href="index.jsp"> <strong>Dammika
						Hotel PVT LTD</strong>

				</a>



				<button class="navbar-toggler" aria-expanded="false"
					aria-controls="navbarSupportedContent-4"
					aria-label="Toggle navigation" type="button"
					data-target="#navbarSupportedContent-4" data-toggle="collapse">

					<span class="navbar-toggler-icon"></span>

				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent-4">

					<ul class="navbar-nav ml-auto">

						<c:if test="${user.status eq 'false'}">


							<li class="nav-item dropdown ml-3"><a role="button"
								data-toggle="modal" data-target="#modalCookie1"
								class="nav-link  waves-effect waves-light red-text font-weight-bold"
								href="UserLogOut">Validate User Account </a></li>

						</c:if>


						<li class="nav-item"><a
							class="nav-link waves-effect waves-light dark-grey-text font-weight-bold"
							href="contactUs"> <i class="fas fa-envelope blue-text"></i>
								Contact <span class="sr-only">(current)</span>

						</a></li>

						<li class="nav-item dropdown ml-3"><a
							class="nav-link  waves-effect waves-light dark-grey-text font-weight-bold"
							href="menu"> <i class="fas fa-utensils blue-text"></i> Our
								Menu
						</a></li>

						<c:if test="${user.userID != null}">

							<li class="nav-item"><a onclick="notificationListUser()"
								href="Notifications" class="nav-link waves-effect"> <span
									id="unreadNotifications" class="badge red"></span> <span
									class="waves-effect waves-light dark-grey-text font-weight-bold">Notifications</span></a></li>

							<li class="nav-item "><a
								class="nav-link dark-grey-text font-weight-bold waves-effect waves-light"
								href="cart"> <span class="badge danger-color">${CartDetails.itemCount}</span>
									<i class="fas fa-shopping-cart blue-text" aria-hidden="true"></i>
									<span class="clearfix d-none d-sm-inline-block">Cart</span>

							</a></li>

							<li class="nav-item dropdown ml-3"><a
								class="nav-link dropdown-toggle waves-effect waves-light dark-grey-text font-weight-bold"
								id="navbarDropdownMenuLink-4" aria-expanded="false"
								aria-haspopup="true" data-toggle="dropdown"> <i
									class="fas fa-user blue-text"></i> ${user.name}
							</a>

								<div class="dropdown-menu dropdown-menu-right dropdown-cyan"
									aria-labelledby="navbarDropdownMenuLink-4">

									<a class="dropdown-item waves-effect waves-light"
										href="basicDetails">My account</a> <a
										class="dropdown-item waves-effect waves-light"
										href="UserLogOut">Log out</a>

								</div></li>

						</c:if>

						<c:if test="${user.userID == null}">

							<li class="nav-item dropdown ml-3"><a
								class="nav-link dropdown-toggle waves-effect waves-light dark-grey-text font-weight-bold"
								id="navbarDropdownMenuLink-4" aria-expanded="false"
								aria-haspopup="true" data-toggle="dropdown"> <i
									class="fas fa-user blue-text"></i>Member Area
							</a>

								<div class="dropdown-menu dropdown-menu-right dropdown-cyan"
									aria-labelledby="navbarDropdownMenuLink-4">

									<a class="dropdown-item waves-effect waves-light" href="login">Login
									</a> <a class="dropdown-item waves-effect waves-light"
										href="register">Register</a>

								</div></li>

						</c:if>
					</ul>

				</div>

			</div>

		</nav>
		<!-- Navbar -->

	</header>



	<!--Modal: modalCookie-->
	<div class="modal fade top" id="modalCookie1" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="true">
		<div
			class="modal-dialog modal-frame modal-top modal-notify modal-info"
			role="document">
			<!--Content-->
			<div class="modal-content">
				<!--Body-->
				<div class="modal-body">
					<div class="row d-flex justify-content-center align-items-center">

						<p class="pt-3 pr-2">${user.name},youraccountisnotactivatedto
							activate please check your email, ${user.email}</p>

						<a type="button" class="btn btn-primary"
							onclick="ResendActivationCode()">Send Activation Code<i
							class="fas fa-book ml-1"></i></a> <a type="button"
							class="btn btn-outline-primary waves-effect" data-dismiss="modal">Not
							now, Later</a>
					</div>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
	<!--Modal: modalCookie-->




</body>

</html>

