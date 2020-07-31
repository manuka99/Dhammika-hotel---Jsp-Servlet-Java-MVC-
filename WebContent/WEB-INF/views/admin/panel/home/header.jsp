<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"
	rel="stylesheet" />
<link href="Design/panel/css/myCustomNotifications.css" rel="stylesheet">
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

.dropdown:hover>.dropdown-menu {
	display: block;
}

.dropdown>.dropdown-toggle:active {
	/*Without this, clicking will make it sticky*/
	pointer-events: none;
}
</style>
</head>

<body class="fixed-sn white-skin" id="body">

	<div id="body2">

		<div id="headerRefresh22">

			<header>

				<!-- Sidebar navigation -->
				<div id="slide-out" class="side-nav sn-bg-4 fixed"
					style="transform: translateX(0px);">
					<ul class="custom-scrollbar ps ps--active-x">

						<!-- Logo -->
						<li class="logo-sn waves-effect py-3">
							<div class="text-center">
								<a href="#" class="pl-0"><img
									src="Design/img/logo3.png"></a>
							</div>
						</li>

						<!-- Search Form -->
						<li>
							<form class="search-form" role="search">
								<div class="md-form mt-0 waves-light waves-effect waves-light">
									<input type="text" class="form-control py-2"
										placeholder="Search">
								</div>
							</form>
						</li>

						<!-- Side navigation links -->
						<li>
							<ul class="collapsible collapsible-accordion">

								<li><a onclick="listAllAdminDashborad()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-gem"></i>Admin Dashboard</a></li>

								<li><a onclick="listAllAboutUs()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-code"></i>About us</a></li>

								<li><a onclick="listAllDeveloper()"
									class="collapsible-header waves-effect"><i
										class="w-fa fab fa-codepen"></i>Developer</a></li>

								<li><a onclick="userProfile()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-user"></i>Profile</a></li>

								<li><a class="collapsible-header waves-effect arrow-r">
										<i class="w-fa fas fa-th"></i>Category Management<i
										class="fas fa-angle-down rotate-icon"></i>
								</a>
									<div class="collapsible-body">
										<ul>

											<li><a onclick="listCategoryTools()"
												class="waves-effect"> Category Tools</a></li>

											<li><a onclick="listFoodByCategory()"
												class="waves-effect">All Categories</a></li>


											<c:forEach var="category" items="${CategoryList}">
												<li><a
													onclick="listFoodByCategory(${category.categoryID})"
													class="waves-effect">${category.name}</a></li>
											</c:forEach>


										</ul>
									</div></li>

								<li><a class="collapsible-header waves-effect arrow-r">
										<i class="w-fa fas fa-users-cog"></i>User Management<i
										class="fas fa-angle-down rotate-icon"></i>
								</a>
									<div class="collapsible-body">
										<ul>

											<li><a onclick="listRolesTools()" class="waves-effect">
													User Tools</a></li>

											<c:forEach var="role" items="${RoleList}">
												<li><a onclick="listUsersByRoleID('${role.roleID}')"
													class="waves-effect">${role.name}</a></li>
											</c:forEach>


										</ul>
									</div></li>
								<!-- Simple link -->
								<li><a onclick="listDeliveryFee()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-shuttle-van"></i>Delivery Fee Calculator</a></li>
								<li><a onclick="listAllOrder()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-utensils"></i>Order Management</a></li>
								<li><a onclick="listAllContactUs()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-comment-alt"></i>Support Management</a></li>

								<li><a onclick="listAllInquiries()"
									class="collapsible-header waves-effect"><i
										class="w-fa fas fa-envelope-open"></i>Inquiries Management</a></li>

							</ul>
						</li>
						<!-- Side navigation links -->


					</ul>
					<div class="sidenav-bg mask-strong"></div>
				</div>
				<!-- Sidebar navigation -->

				<!-- Navbar -->
				<nav
					class="navbar fixed-top navbar-expand-lg scrolling-navbar double-nav">

					<!-- SideNav slide-out button -->
					<div class="float-left">
						<a href="#" data-activates="slide-out" class="button-collapse"><i
							class="fas fa-bars"></i></a>
					</div>

					<!-- Breadcrumb -->
					<div class="breadcrumb-dn mr-auto">
						<p>Dashboard v.11.6</p>
					</div>

					<div class="d-flex change-mode">

						<div class="ml-auto mb-0 mr-3 change-mode-wrapper">
							<button
								class="btn btn-outline-black btn-sm waves-effect waves-light"
								id="dark-mode">Dark Mode LITE</button>
						</div>

						<!-- Navbar links -->
						<ul class="nav navbar-nav nav-flex-icons ml-auto">

							<!-- Dropdown -->
							<li class="nav-item"><a onclick="notificationListPanel()"
								class="nav-link waves-effect"> <span
									id="unreadNotifications" class="badge red">0</span> <i
									class="fas fa-bell"></i> <span
									class="clearfix d-none d-sm-inline-block">Notifications</span></a></li>

							<li class="nav-item"><a onclick="notificationListPanel()"
								class="nav-link waves-effect"><i class="fas fa-envelope"></i>
									<span class="clearfix d-none d-sm-inline-block">Contact</span></a></li>
							<li class="nav-item"><a class="nav-link waves-effect"><i
									class="far fa-comments"></i> <span
									class="clearfix d-none d-sm-inline-block">Support</span></a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle waves-effect" href="#"
								id="userDropdown" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="fas fa-user"></i> <span
									class="clearfix d-none d-sm-inline-block">${user.name}</span>
							</a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="userDropdown">
									<a class="dropdown-item waves-effect waves-light" href="UserLogOut">Log
										Out</a> <a class="dropdown-item waves-effect waves-light" href="userProfile">My
										account</a>
								</div></li>

						</ul>
						<!-- Navbar links -->

					</div>

				</nav>
				<!-- Navbar -->

			</header>
		</div>




	</div>
	<script src="Design/mdPro/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="Design/panel/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="Design/panel/js/bootstrap.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="Design/panel/js/mdb.min.js"></script>
	<div class="hiddendiv common"></div>
	<div class="hiddendiv common"></div>
	<script src="Design/mdPro/js/modules/addons/datatables.js"></script>
	<script src="Design/mdPro/js/modules/addons/datatables.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="Design/mdPro/js/mdb-file-upload.min.js"></script>
	<script type="text/javascript">
		$('.file-upload').file_upload();
	</script>

	<!-- Initializations -->
	<script>
    // SideNav Initialization
    $(".button-collapse").sideNav();

    var container = document.querySelector('.custom-scrollbar');
    var ps = new PerfectScrollbar(container, {
      wheelSpeed: 2,
      wheelPropagation: true,
      minScrollbarLength: 20
    });

    // Data Picker Initialization
    $('.datepicker').pickadate();

    // Material Select Initialization
    $(document).ready(function () {
      $('.mdb-select').material_select();
    });

    // Tooltips Initialization
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
    });

	$(document).ready(function() {
		// SideNav Button Initialization
		$(".button-collapse").sideNav2();
		// SideNav Scrollbar Initialization
		var sideNavScrollbar = document.querySelector('.custom-scrollbar');
		var ps = new PerfectScrollbar(sideNavScrollbar);
		
	});

  </script>
  
  <script type="text/javascript">
function startTrackingNewResponses() {
	var inqID = $('#contactUsID').val();
	var respponsesSize = $('#respponsesSize').text();
	$.ajax({

		url : "RetrieveNewInquiryResponsesPanel",
		data : {
			'inquiryID' : inqID
		},

		success : function(data, textStatus, jqXHR) {

			var result = $(data).find('#inquriyResponsesMsg');
			var responsesListRecieved = $(data).find('#respponsesSize').text();
			$('#newResponses').append(result);
			$('#respponsesSize').text(+responsesListRecieved + +respponsesSize);
			if(responsesListRecieved > 0)
			toastr.success('You have new messages');
			//$('.file-upload').file_upload();
		}

	})
	setTimeout(startTrackingNewResponses, 10000);
};

</script>
	<div class="drag-target" style="left: 0px;"></div>

	<script src="Design/panel/js/darkmode.js" type="text/javascript"> </script>

	<script type="text/javascript"
		src="Design/myScripts/js/datatablesProducts,.js"></script>


	<script type="text/javascript"
		src="Design/myScripts/js/UserManagement.js"></script>

	<script type="text/javascript" src="Design/myScripts/js/deliveryFee.js"></script>
	<script type="text/javascript"
		src="Design/myScripts/js/orderManagement.js"></script>
	<script type="text/javascript" src="Design/myScripts/js/contactUs.js"></script>
	<script type="text/javascript"
		src="Design/myScripts/js/inquiryManage.js"></script>
	<script type="text/javascript"
		src="Design/myScripts/js/UserNNotifications.js"></script>

	<script type="text/javascript">
	
</script>

</body>
</html>
