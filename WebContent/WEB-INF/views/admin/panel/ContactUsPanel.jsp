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
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/5.3.2/tinymce.min.js"></script>
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





									<a href="" class="white-text mx-3">Support Management</a>



									<div>
										<button type="button" onclick="respondContactUs()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										<button type="button" onclick="deleteContactUs()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="far fa-trash-alt mt-0"></i>
										</button>
										<button type="button" onclick="respondContactUs()"
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
														<th scope="col">User Name</th>
														<th scope="col">Subject</th>
														<th scope="col">Time</th>
													</tr>
												</thead>
												<!--Table head-->

												<!--Table body-->
												<tbody>
													<c:forEach var="contact" items="${contactUsList}">
														<tr>
															<th scope="row"><input class="form-check-input"
																type="checkbox" id="${contact.contactUsID}"
																value="${contact.contactUsID}" name="items"> <label
																class="form-check-label" for="${contact.contactUsID}"
																class="label-table"></label></th>
															<td>${contact.name}</td>
															<td>${contact.subject}</td>
															<td>${contact.time}</td>
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
					</div>
				</section>
			</div>
		</main>
	</div>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/5.3.2/tinymce.min.js"></script>
	<%@ include file="home/footer.jsp"%>





</body>
</html>