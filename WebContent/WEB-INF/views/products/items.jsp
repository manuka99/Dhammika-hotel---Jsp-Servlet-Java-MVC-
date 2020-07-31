<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Our menu</title>


</head>


<body class="homepage-v1 hidden-sn white-skin animated">

	<div id="headerRefresh">
		<%@ include file="../home/header.jsp"%></div>

	<div class="container mt-5 pt-3">
		<div style="height: 60px;"></div>
		<section>

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-12">

					<!-- Image -->
					<div class="view  z-depth-1">

						<img
							src="Design/img/hotel-restaurant-pool-people-flames-fire-others.jpeg"
							style="height: 280px; width: 480px" class="img-fluid"
							alt="sample image">

						<div class="mask rgba-stylish-slight">

							<div
								class="dark-grey-text text-right pt-lg-5 pt-md-1 mr-5 pr-md-4 pr-0">

								<div>

									<a> <span class="badge badge-danger">OFFER</span>

									</a>

									<h2 class="card-title font-weight-bold pt-md-3 pt-1">

										<strong>10% off your total bill this WEEKEND! </strong>

									</h2>

									<p class="">We offer 10% off your total bill for DINING!
										Enjoy this unbeatable offer</p>
									<span class="clearfix d-none d-md-block text-muted"><small>(conditions
											apply)</small></span> <a
										class="btn mr-0 btn-primary btn-rounded clearfix d-none d-md-inline-block waves-effect waves-light">Reserve
										Now</a>

								</div>

							</div>

						</div>

					</div>
					<!-- Image -->

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</section>

		<div id="FoodItems">

			<div class="row pt-5">


				<div class="col-lg-3">

					<div id="slide" style="display: none"><%@ include
							file="SliderLoader.jsp"%></div>
					<div id="category">




						<div class="">

							<!-- Grid row -->
							<div class="row">

								<div class="col-md-6 col-lg-12 mb-5">

									<!-- Panel -->
									<h5 class="font-weight-bold dark-grey-text">
										<strong>Order By</strong>
									</h5>

									<div class="divider"></div>

									<div class="form-group">
										<input class="form-check-input" name="group2000" type="radio"
											id="defaultOrder" onclick=" ListFoodByOrder(null, null)">
										<label for="defaultOrder"
											class="form-check-label dark-grey-text">Default</label>
									</div>


									<div class="form-group">
										<input class="form-check-input" name="group2000" type="radio"
											id="priceasc" onclick="ListFoodByOrder('price', 'asc')">
										<label for="priceasc" class="form-check-label dark-grey-text">Price:
											low to high</label>
									</div>


									<div class="form-group">
										<input class="form-check-input" name="group2000" type="radio"
											id="pricedesc" onclick="ListFoodByOrder('price', 'desc')">
										<label for="pricedesc" class="form-check-label dark-grey-text">Price:
											high to low</label>
									</div>

									<div class="form-group">
										<input class="form-check-input" name="group2000" type="radio"
											id="portionasc" onclick="ListFoodByOrder('portion', 'asc')">
										<label for="portionasc"
											class="form-check-label dark-grey-text">Portion: low
											to high</label>
									</div>

									<div class="form-group">
										<input class="form-check-input" name="group2000" type="radio"
											id="portiondesc" onclick="ListFoodByOrder('portion', 'desc')">
										<label for="portiondesc"
											class="form-check-label dark-grey-text">Portion :
											high to low</label>
									</div>


								</div>

								<!-- Filter by category -->
								<div class="col-md-6 col-lg-12 mb-5">

									<h5 class="font-weight-bold dark-grey-text">
										<strong>Category</strong>
									</h5>

									<div class="divider"></div>

									<!-- Radio group -->

									<div class="form-group">


										<input class="form-check-input" name="group1000" type="radio"
											checked="" id="allFoodID" onclick="ListAllFood()"> <label
											for="allFoodID" class="form-check-label dark-grey-text">All</label>

									</div>

									<c:forEach var="Category" items="${CategoryList}">

										<div class="form-group">

											<input class="form-check-input" name="group1000" type="radio"
												id="${Category.categoryID}" value="${Category.name}"
												onclick="ListFoodByCategory(${Category.categoryID}, '${Category.name}')">

											<label for="${Category.categoryID}"
												class="form-check-label dark-grey-text">${Category.name}</label>

										</div>
									</c:forEach>



									<!-- Radio group -->
								</div>

								<!-- Filter by category -->
							</div>
							<!-- Grid row -->

							<!-- Grid row -->
							<div class="row">

								<!-- Filter by price -->
								<div class="col-md-6 col-lg-12 mb-5">

									<h5 class="font-weight-bold dark-grey-text">
										<strong>Price</strong>
									</h5>

									<div class="divider"></div>

									<form class="range-field mt-3">

										<div class="slidecontainer">
											<input type="range" min="0" step="0" max="10000" value="0"
												class="slider" id="myRange" onclick="SlideMe()">
										</div>

									</form>

									<!-- Grid row -->
									<div class="row justify-content-center">

										<!-- Grid column -->
										<div class="col-md-6 text-left">

											<p class="dark-grey-text">
												<strong>Rs.<span id="slideFrom">0.00</span></strong>
											</p>



										</div>
										<!-- Grid column -->

										<!-- Grid column -->
										<div class="col-md-6 text-right">

											<p class="dark-grey-text">
												<strong id="clientPrice">Rs.10000.00</strong>
											</p>

										</div>
										<!-- Grid column -->

									</div>
									<!-- Grid row -->

								</div>
								<!-- Filter by price -->

								<!-- Filter by rating -->
								<div class="col-md-6 col-lg-12 mb-5">

									<h5 class="font-weight-bold dark-grey-text">
										<strong>Rating</strong>
									</h5>

									<div class="divider"></div>

									<div class="row ml-1">

										<!-- Rating -->
										<ul class="rating mb-0">

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li>

												<p class="ml-3 dark-grey-text">
													<a>4 and more</a>
												</p>

											</li>

										</ul>

									</div>

									<div class="row ml-1">

										<!-- Rating -->
										<ul class="rating mb-0">

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star grey-text"></i></li>

											<li>

												<p class="ml-3 dark-grey-text">
													<a>3 - 3,99</a>
												</p>

											</li>

										</ul>

									</div>

									<div class="row ml-1">

										<!-- Rating -->
										<ul class="rating">

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star blue-text"></i></li>

											<li><i class="fas fa-star grey-text"></i></li>

											<li><i class="fas fa-star grey-text"></i></li>

											<li>

												<p class="ml-3 dark-grey-text">
													<a>3.00 and less</a>
												</p>

											</li>

										</ul>

									</div>

								</div>
								<!-- Filter by rating -->

							</div>
							<!-- Grid row -->

						</div>













					</div>


				</div>



				<div class="col-lg-9">

					<div id="cardloader" style="display: none"><%@ include
							file="CardLoader.jsp"%></div>

					<div id="cardFood">




						<div id="categoryInfo" value="${categoryID}" style="display: none"></div>
						<div id="orderbyType" value="${column}${type}"
							style="display: none"></div>
						<div id="orderby" value="${column}" style="display: none"></div>
						<div id="getSliderValuer" value="${sliderValue}"
							style="display: none"></div>

						<!-- Filter Area -->
						<div class="row">

							<div class="col-md-4 mt-3"></div>



						</div>
						<!-- Filter Area -->

						<!-- Products Grid -->
						<section class="section pt-4">


							<!-- Grid row -->
							<div class="row">



								<c:forEach var="Food" items="${FoodList}">


									<!-- Grid column -->
									<div class="col-lg-4 col-md-12 mb-5">

										<!-- Card -->
										<div class="">

											<div class="view zoom z-depth-2 rounded">
												<img class="img-fluid w-100"
													src="data:image/jpg;base64,${Food.image}"
													style="width: 220px; height: 220px; display: block; margin: auto;"
													alt="Sample">
												<c:if test="${Food.active eq false}">
													<div
														class="mask pattern-4 flex-center waves-effect waves-light">
														<p class="white-text">Not Available</p>
													</div>
												</c:if>
											</div>

											<div class="text-center pt-4">

												<h5>${Food.name}</h5>
												<h6 class="mb-3">Rs.${Food.price}</h6>



												<c:choose>
													<c:when test="${Food.active eq true}">
														<button type="button"
															onclick="addItemIDToCart(${Food.itemID})"
															class="btn btn-blue btn-sm mr-1 waves-effect waves-light">
															<i class="fas fa-shopping-cart pr-2"></i>Add to cart
														</button>
													</c:when>
													<c:otherwise>
														<button type="button"
															onclick="addItemIDToCart(${Food.itemID})"
															class="btn btn-blue btn-sm mr-1 waves-effect waves-light">
															<i class="fas fa-shopping-cart pr-2"></i>
															<del>Add to cart</del>
														</button>
													</c:otherwise>
												</c:choose>



												<a href="product?fID=${Food.itemID}" target="_blank"
													class="btn btn-black btn-sm px-3 material-tooltip-main waves-effect waves-light"
													data-toggle="tooltip" data-placement="top" title=""
													data-original-title="view more details"><i
													class="fas fa-info"></i></a>

											</div>

										</div>
										<!-- Card -->

									</div>
									<!-- Grid column -->



								</c:forEach>


							</div>
							<!-- Grid row -->

							<!-- Grid row -->
							<div class="row justify-content-center mb-4">

								<!-- Pagination -->
								<nav class="mb-4">

									<ul class="pagination pagination-circle pg-blue mb-0">

										<c:if test="${currentPage != 1}">

											<!-- First -->
											<li class="page-item clearfix d-none d-md-block"><a
												class="page-link waves-effect waves-effect"
												onclick="ListFoodPagination('${column}', '${type}', ${currentPage - 1})">Previous</a>

											</li>



										</c:if>



										<!-- Numbers -->



										<c:forEach begin="1" end="${noOfPages}" var="i">
											<c:choose>

												<c:when test="${currentPage eq i}">

													<li class="page-item active"><a
														class="page-link waves-effect waves-effect active">${i}</a>

													</li>



												</c:when>

												<c:otherwise>


													<li class="page-item"><a
														class="page-link waves-effect waves-effect"
														onclick="ListFoodPagination('${column}', '${type}', ${i} )">${i}</a>

													</li>

												</c:otherwise>

											</c:choose>

										</c:forEach>


										<c:if test="${currentPage != noOfPages}">

											<!-- First -->
											<li class="page-item clearfix d-none d-md-block"><a
												class="page-link waves-effect waves-effect"
												onclick="ListFoodPagination('${column}', '${type}', ${currentPage + 1})">Next</a>

											</li>

										</c:if>




									</ul>

								</nav>
								<!-- Pagination -->

							</div>
							<!-- Grid row -->

						</section>
						<!-- Products Grid -->















					</div>

				</div>


			</div>

		</div>

	</div>



	<%@ include file="../home/footer.jsp"%>


	<script>
		$(document).ready(function() {

			//ListCategory();
			//ListAllFood()

			var catName = "";
			var categoryInfo = document.getElementById('categoryInfo').getAttribute('value');			
			var orderbyType = document.getElementById('orderbyType').getAttribute('value');
			var orderby = document.getElementById('orderby').getAttribute('value');
			var getSliderValuer = document.getElementById('getSliderValuer').getAttribute('value');
			
			console.log(categoryInfo);
			console.log(orderbyType);
			
			document.getElementById("myRange").value = getSliderValuer;
			document.getElementById("slideFrom").innerHTML = getSliderValuer;
			
		/*	if(orderby != ""){
				
				console.log(orderby);
				
				if(orderby === 'null'){
					
					console.log("1111");
					document.getElementById("defaultOrder").checked = true;
					
					
				}
				
				else{
					console.log("elseeee");
					document.getElementById(orderbyType).checked = true;
					
				}
				
				
			}*/
			
			if(orderby === "" || orderby === 'null'){
				
				document.getElementById("defaultOrder").checked = true;
				
			}
			
			if(orderby != "" && orderby != 'null'){
				
				document.getElementById(orderbyType).checked = true;
				
			}
			
			
			if(categoryInfo === ''){
				
				document.getElementById("allFoodID").checked = true;
				
			}
			
			if(categoryInfo != ''){
				
				document.getElementById(categoryInfo).checked = true;
				///catName = document.getElementById(categoryInfo).value;
				///$('#topNameCat').text(catName);
				
			}
				
			
		});
	</script>

	<script>
		var catID = "%";
		var column0 = "";
		var type0 = "";
		var sliderValue = 0;

		function ListAllFood() {
			
			$('#cardFood').fadeOut();
			$('#cardloader').fadeIn();			

			$.ajax({

				url : "menu",

				success : function(data, textStatus, jqXHR) {
					
					$('#cardFood').fadeIn();
					$('#cardloader').fadeOut();
					
					defaultSlider();
					var result = $(data).find('#cardFood');					
					$('#cardFood').html(result);
					history.pushState({}, "", "menu");
					catID = "%";
					document.getElementById("0000").checked = true;

				}

			})

		};

		function ListFoodPagination(column, type, page) {

			//$('#conte').load('WEB-INF/views/home/CardLoader.jsp');
			
			$('#cardFood').hide();
			$('#cardloader').fadeIn();
			
			$.ajax({

				url : "menu",
				data : {
					'column' : column,
					'type' : type,
					page : page,
					'cID' : catID,
					sliderValue : sliderValue,

				},
				success : function(data, textStatus, jqXHR) {

					$('#cardFood').fadeIn();
					$('#cardloader').hide();
					
					var result = $(data).find('#cardFood');					
					$('#cardFood').html(result);
					var url = "menu?column="+ column + "&type=" + type + "&page=" + page + "&cID=" + catID + "&sliderValue=" + sliderValue;
					history.pushState({}, "", url);

				}

			})

		};

		function ListCategory() {

			$.ajax({

				url : "ListCategorySlide",
				success : function(data, textStatus, jqXHR) {
					$('#category').html(data)

				}

			})

		};

		function ListFoodByCategory(catergoryID, name) {

			$('#cardFood').hide();
			$('#cardloader').fadeIn();
			
			$.ajax({

				url : "menu",
				data : {
					cID : catergoryID
				},
				success : function(data, textStatus, jqXHR) {
					
					$('#cardFood').fadeIn();
					$('#cardloader').hide();
					
					defaultSlider();
					catID = catergoryID;
					var result = $(data).find('#cardFood');					
					$('#cardFood').html(result);
					history.pushState({}, "", "menu?cID=" + catergoryID);
					//ListCategory();
					document.getElementById("0000").checked = true;

				}

			})

		};

		function ListFoodByOrder(column, type) {
			
			$('#cardFood').hide();
			$('#cardloader').fadeIn();

			$.ajax({

				url : "menu",
				data : {
					cID : catID,
					'column' : column,
					'type' : type,
					sliderValue : sliderValue
				},
				success : function(data, textStatus, jqXHR) {
					
					$('#cardFood').fadeIn();
					$('#cardloader').hide();
					
					column0 = column;
					type0 = type;

					var result = $(data).find('#cardFood');					
					$('#cardFood').html(result);
					var url = "menu?column="+ column + "&type=" + type + "&cID=" + catID + "&sliderValue=" + sliderValue;
					history.pushState({}, "", url);

				}

			})

		};

		function SlideMe() {
			var slider = document.getElementById("myRange");
			var output = document.getElementById("slideFrom");
			output.innerHTML = slider.value;
			sliderValue = slider.value;
			ListFoodByOrder(column0, type0);

			console.log(column0);
			console.log(type0);
		};

		function defaultSlider() {
			document.getElementById("myRange").value = 0.00;
			document.getElementById("slideFrom").innerHTML = "0.00";
			sliderValue = 0;
			console.log(sliderValue);
		};

		function addItemIDToCart(itemID) {

			$.ajax({

				url : "AddCartItem",
				data : {
					'itemID' : itemID
				},

				success : function(data) {
					if (data == 'added') {
						$("#headerRefresh").load(
								location.href + " #headerRefresh");
						toastr.success('item was added');
					}

					else if (data == 'updated') {
						$("#headerRefresh").load(
								location.href + " #headerRefresh");
						toastr.success('cart was updated');
					}

					else if (data == 'failed') {
						toastr.error('item was not added');
					}

					else {
						toastr.error('you dont have access');
					}

				}

			})

		};
	</script>
</body>
</html>

