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

						<div class="card gray mr-3 z-depth-2 chat-room">
							<div class="card-body">

								<!-- Grid row -->
								<div class="  ">

									<!-- Grid column -->
									<div class="  ">

										<div
											class="white z-depth-1 px-2 pt-3 pb-0 members-panel-1 scrollbar-light-blue">
											<ul class="list-unstyled friend-list">
												<c:forEach var="notification" items="${notifications}">

													<li
														class="${notification.seen ? 'p-2' : 'active grey lighten-3 p-2'} border border-light">
														<div class="col-sm-0">
															<button class="btn btn-rounded btn-deep-orange btn-sm" 
															onclick="notificationDeletePanel('${notification.notificationID}')"
															>clear<i class="fas fa-trash pl-1"></i></button>

														</div> <a
														onclick="notificationsOpenedPanel('${notification.notificationID}')"
														href="${notification.url}" target="_blank"
														class="d-flex justify-content-between">
															<div class="text-large">
																<strong>${notification.header} </strong>
																<p class="last-message text-muted">${notification.body}</p>
															</div>
															<div class="chat-footer">
																<p class="text-smaller text-muted mb-0">${notification.time}</p>
																<c:if test="${notification.seen eq false}">
																	<span class="badge badge-danger float-right">1</span>
																</c:if>
															</div>

													</a>

													</li>
												</c:forEach>
											</ul>
										</div>

									</div>
									<!-- Grid column -->

									<!-- Grid column -->

									<!-- Grid column -->

								</div>
								<!-- Grid row -->

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