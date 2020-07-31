<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Notifications</title>
</head>
<body class="homepage-v1 hidden-sn white-skin animated" id="body">


	<div class="intro-2"
		style="background: rgb(227, 60, 133); background: linear-gradient(90deg, rgba(227, 60, 133, 1) 0%, rgba(50, 127, 219, 0.630987429151348) 100%); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<div style="height: 80px;"></div>
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
						<div class="container">
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
																	onclick="notificationDelete('${notification.notificationID}')">
																	clear<i class="fas fa-trash pl-1"></i>
																</button>

															</div> <a
															onclick="notificationsOpened('${notification.notificationID}')"
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
					</div>
				</section>
			</div>
		</div>

		<%@ include file="../home/footer.jsp"%>
	</div>


	<!-- SCRIPTS -->

	<script>
		function notificationsOpened(notificationID) {
			$.ajax({

				url : "NotificationUpdate",
				data : {
					'notificationID' : notificationID
				},
				success : function(data, textStatus, jqXHR) {

					if (data === "true") {

						$("#body").load(location.href + "#body");

					}

				}

			})

		};

		function notificationDelete(notificationID) {

			$.ajax({

				url : "NotificationDelete",
				data : {
					'notificationID' : notificationID
				},
				success : function(data, textStatus, jqXHR) {
					if (data === "true") {

						$("#body").load(location.href + "#body");

					}
				}

			})

		};
	</script>


</body>
</html>