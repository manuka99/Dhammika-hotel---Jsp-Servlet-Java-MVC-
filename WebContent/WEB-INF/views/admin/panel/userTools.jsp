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





									<a href="" class="white-text mx-3">User Role Management</a>



									<div>
										<button type="button" onclick="editRolesTool()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										<button type="button" onclick="deleteRolesTool()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="far fa-trash-alt mt-0"></i>
										</button>
										<button type="button" data-toggle="modal"
											data-target="#roleAddModal" data-backdrop="static"
											data-keyboard="false"
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
														<th class="th-lg">User Role ID</th>
														<th class="th-lg">Role Name</th>
														<th class="th-lg">Role Description</th>
													</tr>
												</thead>
												<!--Table head-->

												<!--Table body-->
												<tbody>
													<c:forEach var="role" items="${roleList}">
														<tr>
															<th scope="row"><input class="form-check-input"
																type="checkbox" id="${role.roleID}"
																value="${role.roleID}" name="type"> <label
																class="form-check-label" for="${role.roleID}"
																class="label-table"></label></th>
															<td>${role.roleID}</td>
															<td>${role.name}</td>
															<td>${role.description}</td>
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

						<div id="roleEditModalDiv">
							<!-- Modal: modalQuickView -->
							<div class="modal fade" id="roleEditModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-lg" role="document">
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
															<input value="${role.name}" type="text" id="roleName"
																class="form-control"> <label class="active"
																for="roleName">Role Name</label> <input
																value="${role.roleID}" type="hidden" id="roleID"
																class="form-control">
														</div>



													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input value="${role.description}" type="text"
																	id="roleDescription" class="form-control"> <label
																	class="active" for="roleDescription">Role
																	Description</label>
															</div>


														</span>
													</h4>
													<div class="card-body">
														<div class="row">
															<div class="col-md-6"></div>
															<div class="col-md-6"></div>
														</div>
														<div class="row">
															<div class="text-center">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<button class="btn btn-primary"
																	onclick="updateRolesTool()">Update Role</button>
															</div>
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>


						<div id="roleAddModalDiv">
							<!-- Modal: modalQuickView -->
							<div class="modal fade" id="roleAddModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-lg" role="document">
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
															<input type="text" id="addRoleName" class="form-control">
															<label class="active" for="addRoleName">Role Name</label>
														</div>



													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="addRoleDescription"
																	class="form-control"> <label class="active"
																	for="addRoleDescription">Role Description</label>
															</div>


														</span>
													</h4>
													<div class="card-body">
														<div class="row">
															<div class="col-md-6"></div>
															<div class="col-md-6"></div>
														</div>
														<div class="row">
															<div class="text-center">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<button class="btn btn-primary"
																	onclick="AddPanelRolesTool()">Add Role</button>
															</div>
														</div>
													</div>

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