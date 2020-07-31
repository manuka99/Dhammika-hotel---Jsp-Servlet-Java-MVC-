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





									<a href="" class="white-text mx-3">${categoryInfoName}</a>



									<div>
										<button type="button" onclick="editProduct()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										<button type="button" onclick="deleteProduct()"
											class="btn btn-outline-white btn-rounded btn-sm px-2">
											<i class="far fa-trash-alt mt-0"></i>
										</button>
										<button type="button" onclick="addnewModelOpen()"
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
														<th class="th-lg"></th>
														<th class="th-lg">Name</th>
														<th class="th-lg">Description</th>
														<th class="th-lg">Portion</th>
														<th class="th-lg">Price</th>
														<th class="th-lg">Tax</th>
														<th class="th-lg">Status</th>
													</tr>
												</thead>
												<!--Table head-->

												<!--Table body-->
												<tbody>
													<c:forEach var="Food" items="${FoodList}">
														<tr>
															<th scope="row"><input class="form-check-input"
																type="checkbox" id="${Food.itemID}"
																value="${Food.itemID}" name="type"> <label
																class="form-check-label" for="${Food.itemID}"
																class="label-table"></label></th>
															<td><img src="data:image/jpg;base64,${Food.image}"
																width="50" height="50" /></td>
															<td><a class="text-primary" target="_blank" href="product?fID=${Food.itemID}" >${Food.name}</a></td>
															<td>${Food.description}</td>
															<td>${Food.portion}</td>
															<td>${Food.price}</td>
															<td>${Food.tax}</td>
															<td>${Food.active}</td>
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

						<div id="productEditModalDiv">
							<!-- Modal: modalQuickView -->
							<div class="modal fade" id="productEditModal" tabindex="-1"
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
															<div class="carousel-item active">

																<div class="file-upload-wrapper">
																	<img src="data:image/jpg;base64,${Food.image}"
																		class="w-100 h-200"> <input type="file"
																		id="productImage" class="file-upload" />
																</div>

																<div id="progress"></div>
															</div>
														</div>
													</div>
													<!--/.Carousel Wrapper-->
												</div>
												<div class="container">
													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input value="${Food.name}" type="text" id="productName"
																class="form-control"> <label class="active"
																for="form4">Product Name</label> <input
																value="${Food.itemID}" type="hidden" id="productID"
																class="form-control"> <input
																value="${Food.active}" type="hidden" id="productStatus"
																class="form-control"> <input
																value="${Food.catergoryID}" type="hidden"
																id="CatergoryID" class="form-control">
														</div>



													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input value="${Food.price}" type="text"
																	id="productPrice" class="form-control"> <label
																	class="active" for="form4">Product Price</label>
															</div>


														</span>
													</h4>

													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input value="${Food.description}" type="text"
																id="productDescription" class="form-control"> <label
																class="active" for="productDescription">Product
																Description</label>
														</div>



													</h2>
													<h4 class="h4-responsive">
														<span class="green-text">
															<div class="md-form">
																<input value="${Food.portion}" type="text"
																	id="productPortion" class="form-control"> <label
																	class="active" for="productPortion">Product
																	Portion</label>
															</div>


														</span>
													</h4>



													<h2 class="h2-responsive product-name">



														<div class="md-form">
															<input value="${Food.tax}" type="text" id="productTax"
																class="form-control"> <label class="active"
																for="productTax">Product Tax</label>
														</div>
													</h2>

													<div class="card-body">
														<div class="row">
															<div class="col-md-6">


																<h5>Product Visibility:</h5>
																<div id="productOption">
																	<select id="productStatusSelect"
																		class="browser-default custom-select">
																		<option value="true">Active</option>
																		<option value="false">Hidden</option>
																	</select>
																</div>
															</div>
															<div class="col-md-6">
																<h5>Product Category:</h5>
																<div id="productCategory">
																	<select id="productCategorySelect"
																		class="browser-default custom-select">
																		<c:forEach var="category" items="${catagoryList}">
																			<option value="${category.categoryID}">${category.name}</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="text-center">
																<hr class="mb-4">
																<button type="button" class="btn btn-secondary"
																	data-dismiss="modal">Close</button>
																<button class="btn btn-primary"
																	onclick="updateProductDetails()">Update
																	Product</button>
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




					<!-- Modal: modalQuickView -->
					<div id="productAddModalDiv">
						<div class="modal fade" id="productAddModal">
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
														<div class="carousel-item active">

															<div class="file-upload-wrapper">
																<input type="file" id="addNewproductImage" class="file-upload" data-height="400"  />
															</div>

															<div id="progress"></div>
														</div>
													</div>
												</div>
												<!--/.Carousel Wrapper-->
											</div>
											<div class="container">
												<h2 class="h2-responsive product-name">




													<div class="md-form">
														<input type="text" id="AddNewproductName" class="form-control">
														<label class="active" for="AddNewproductName">Product Name</label>
													</div>



												</h2>
												<h4 class="h4-responsive">
													<span class="green-text">
														<div class="md-form">
															<input type="text" id="AddNewproductPrice" class="form-control">
															<label class="active" for="AddNewproductPrice">Product Price</label>
														</div>


													</span>
												</h4>

												<h2 class="h2-responsive product-name">



													<div class="md-form">
														<input type="text" id="AddNewproductDescription"
															class="form-control"> <label class="active"
															for="AddNewproductDescription">Product Description</label>
													</div>



												</h2>
												<h4 class="h4-responsive">
													<span class="green-text">
														<div class="md-form">
															<input type="text" id="AddNewproductPortion"
																class="form-control"> <label class="active"
																for="AddNewproductPortion">Product Portion</label>
														</div>


													</span>
												</h4>
												<h2 class="h2-responsive product-name">



													<div class="md-form">
														<input type="text" id="AddNewproductTax" class="form-control">
														<label class="active" for="AddNewproductTax">Product Tax</label>
													</div>



												</h2>

												<!-- Add to Cart -->
												<div class="card-body">
													<div class="row">
														<div class="col-md-6">
															<h5>Product Visibility:</h5>
															<div id="addNewProductOption">
																<select id="addNewProductStatusSelect"
																	class="browser-default custom-select">
																	<option>Change Status..</option>
																	<option value="true">Active</option>
																	<option value="false">Hidden</option>
																</select>
															</div>
														</div>
														<div class="col-md-6">

															<h5>Product Category:</h5>
															<div id="addNewCategoryOption">
																<select id="AddNewProductCategorySelect"
																	class="browser-default custom-select">
																	<option>Change Category..</option>
																	<c:forEach var="category" items="${catagoryList}">
																		<option value="${category.categoryID}">${category.name}</option>
																	</c:forEach>
																</select>
															</div>

														</div>
													</div>
													<div class="row">
														<div class="text-center">
															<hr class="mb-4">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Close</button>
															<button class="btn btn-primary"
																onclick="addNewProductDetails()">
																Add new product
															</button>
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