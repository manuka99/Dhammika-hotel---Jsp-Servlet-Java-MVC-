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
										<button type="button" onclick="editUser()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										<button type="button" onclick="deleteUsersbyIDs()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="far fa-trash-alt mt-0"></i>
										</button>
										<button type="button" onclick="addnewUserModelOpen()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-info-circle mt-0"></i>
										</button>
									</div>

								</div>
								<!--/Card image-->

								<div class="px-4">

									<div class="table-wrapper">
										<!--Table-->
										<div id="adadadaedrervvv" class="table-responsive" >
											<table id="dtMaterialDesignExample"
												class="table table-hover mb-0">

												<!--Table head-->
												<thead>
													<tr>
														<th></th>
														<th class="th-lg">Name</th>
														<th class="th-lg">Email</th>
														<th class="th-lg">Phone</th>
														<th class="th-lg">Date of Birth</th>
														<th class="th-lg">Address</th>
														<th class="th-lg">Status</th>
													</tr>
												</thead>
												<!--Table head-->

												<!--Table body-->
												<tbody>
													<c:forEach var="user" items="${userList}">
														<tr>
															<th scope="row"><input class="form-check-input"
																type="checkbox" id="${user.userID}"
																value="${user.userID}" name="items"> <label
																class="form-check-label" for="${user.userID}"
																class="label-table"></label></th>
															<td>${user.name}</td>
															<td>${user.email}</td>
															<td>${user.phone}</td>
															<td>${user.dateOfBirth}</td>
															<td>${user.address}</td>
															<td>${user.status}</td>
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
						<div id="UserEditModalDiv">
							<div class="modal fade" id="UserEditModal">
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
															<input type="text" id="editUserName" value="${user.name}"
																class="form-control"> <label class="active"
																for="editUserName">User Name</label> <input
																type="hidden" id="editUserID" value="${user.userID}"
																class="form-control"> <input type="hidden"
																id="getEditUserStatus" value="${user.status}"
																class="form-control">
														</div>




													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="editUserEmail"
																	value="${user.email}" class="form-control"> <label
																	class="active" for="editUserEmail">User Email</label>
															</div>


														</span>
													</h4>

													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input type="text" id="editUserPhone"
																value="${user.phone}" class="form-control"> <label
																class="active" for="editUserPhone">User Phone</label>
														</div>



													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="date" id="editUserDOB"
																	value="${user.dateOfBirth}" class="form-control">
															</div>


														</span>
													</h4>
													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input type="text" id="editUserAddress"
																class="form-control" value="${user.address}"> <label
																class="active" for="editUserAddress">User
																Address</label>
														</div>



													</h2>

													<!-- Add to Cart -->
													<div class="card-body">
														<div class="row">
															<div class="col-md-6">
																<h5>User account status:</h5>
																<div id="editUserOption">
																	<select id="editUserSelect"
																		class="browser-default custom-select">
																		<option value="true">Verified</option>
																		<option value="false">Not Verified</option>
																	</select>
																</div>
															</div>

															<div class="col-md-6">

																<h5>Associated Roles:</h5>
																<div id="addNewCategoryOption">

																	<c:forEach var="role" items="${RoleList}">
																		<c:set var="counter" value="0" scope="page" />
																		<c:forEach var="userRole" items="${user.roles}">
																			<c:if test="${role.roleID eq userRole.roleID}">
																				<div class="form-check">
																					<input type="checkbox" class="form-check-input"
																						id="${role.roleID}" value="${role.roleID}"
																						name="roles" checked> <label
																						class="form-check-label" for="${role.roleID}">${role.name}
																					</label>
																				</div>
																				<c:set var="counter" value="${counter + 1}"
																					scope="page" />
																			</c:if>
																		</c:forEach>

																		<c:if test="${counter == 0}">
																			<div class="form-check">
																				<input type="checkbox" class="form-check-input"
																					id="${role.roleID}" value="${role.roleID}"
																					name="roles"> <label
																					class="form-check-label" for="${role.roleID}">${role.name}
																				</label>
																			</div>
																		</c:if>


																	</c:forEach>





																</div>
															</div>
														</div>
														<hr class="mb-4">
														<div class="row">
															<div class="text-center">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<button class="btn btn-light-green"
																	"
																	onclick="updateUserPassword()">Change
																	User Password</button>
																<button class="btn btn-primary"
																	onclick="updateUserDetails()">Update User
																	Profile</button>

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
						<div id="UserAddModalDiv">
							<div class="modal fade" id="UserAddModal">
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
															<input type="text" id="addUserName" class="form-control">
															<label class="active" for="addUserName">User Name</label>
														</div>




													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="addUserEmail"
																	class="form-control"> <label class="active"
																	for="addUserEmail">User Email</label>
															</div>


														</span>
													</h4>

													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input type="text" id="addUserPhone" class="form-control">
															<label class="active" for="addUserPhone">User
																Phone</label>
														</div>



													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="date" id="addUserDOB" class="form-control">
															</div>


														</span>
													</h4>
													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input type="text" id="addUserAddress"
																class="form-control"> <label class="active"
																for="addUserAddress">User Address</label>
														</div>



													</h2>

													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input type="text" id="addUserPassword"
																	class="form-control"> <label class="active"
																	for="addUserPassword">User Password</label>
															</div>


														</span>
													</h4>

													<!-- Add to Cart -->
													<div class="card-body">
														<div class="row">
															<div class="col-md-6">
																<h5>User account status:</h5>
																<div id="addUserOption">
																	<select id="addUserSelect"
																		class="browser-default custom-select">
																		<option value="true">Verified</option>
																		<option value="false" selected>Not Verified</option>
																	</select>
																</div>
															</div>

															<div class="col-md-6">

																<h5>User Roles:</h5>
																<div id="addNewRoleOption">

																	<c:forEach var="role" items="${RoleList}">
																		<div class="form-check">
																			<input type="checkbox" class="form-check-input"
																				id="${role.roleID}" value="${role.roleID}"
																				name="addNewRoles"> <label
																				class="form-check-label" for="${role.roleID}">${role.name}
																			</label>
																		</div>
																	</c:forEach>

																</div>
															</div>
														</div>
														<hr class="mb-4">
														<div class="row">
															<div class="text-center">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<button class="btn btn-primary"
																	onclick="addNewUserDetails()">Add New User</button>

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
				</section>
			</div>
		</main>
	</div>

	<%@ include file="home/footer.jsp"%>





</body>
</html>