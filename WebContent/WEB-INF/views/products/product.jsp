<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Product - ${Food.name}</title>
</head>
<body class="homepage-v1 hidden-sn white-skin animated" id="body">

	<div id="headerRefresh">
		<%@ include file="../home/header.jsp"%></div>

	<div class="skin-light container mt-5 pt-3">
		<div style="height: 20px;"></div>


		<section class="my-5">
			<div class="row">

				<div class="col-md-5 mb-4 mb-md-0">

					<div class="view zoom z-depth-2 rounded">
						<img class="img-fluid w-100"
							src="data:image/jpg;base64,${Food.image}"
							style="height: 500px; display: block; margin: auto;" alt="Sample">
						<c:if test="${Food.active eq false}">
							<div class="mask pattern-4 flex-center waves-effect waves-light">
								<p class="white-text">Not Available</p>
							</div>
						</c:if>
					</div>

				</div>
				<div class="col-md-7">
					<input type="hidden" id="productID" value="${Food.itemID}">
					<h5>${Food.name}</h5>
					<p class="mb-2 text-muted text-uppercase small">${FoodCat.name}</p>

					<c:choose>
						<c:when test="${Food.active eq true}">
							<h3>
								<span class="badge badge-success">Available Now</span>
							</h3>
						</c:when>
						<c:otherwise>
							<h3>
								<span class="badge badge-danger">Not Available</span>
							</h3>
						</c:otherwise>
					</c:choose>

					<ul class="rating">
						<li><i class="fas fa-star fa-sm text-primary"></i></li>
						<li><i class="fas fa-star fa-sm text-primary"></i></li>
						<li><i class="fas fa-star fa-sm text-primary"></i></li>
						<li><i class="fas fa-star fa-sm text-primary"></i></li>
						<li><i class="far fa-star fa-sm text-primary"></i></li>
					</ul>
					<p></p>
					<p class="pt-1 text-break">${Food.description}</p>
					<div class="table-responsive">
						<table class="table table-sm table-borderless mb-0">
							<tbody>
								<tr>
									<th class="pl-0 w-25" scope="row"><strong>Country</strong></th>
									<td>Sri Lanka</td>
								</tr>
								<tr>
									<th class="pl-0 w-25" scope="row"><strong>Province</strong></th>
									<td>Colombo</td>
								</tr>
								<tr>
									<th class="pl-0 w-25" scope="row"><strong>Tax</strong></th>
									<td>Rs.${Food.tax}</td>
								</tr>
								<tr>
									<th class="pl-0 w-25" scope="row"><strong>Price</strong></th>
									<td><strong>Rs.${Food.price}</strong></td>
								</tr>
							</tbody>
						</table>
					</div>
					<hr>
					<div class="table-responsive mb-2">
						<table class="table table-sm table-borderless">
							<tbody>
								<tr>
									<td class="pl-0 pb-0 w-25">Quantity</td>
								</tr>
								<tr>
									<td class="pl-0">
										<div class="def-number-input number-input safari_only mb-0">
											<button type="button"
												onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
												class="minus"></button>
											<input class="quantity" min="1" id="quantity" name="quantity"
												value="1" type="number">
											<button type="button"
												onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
												class="plus"></button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<c:choose>
						<c:when test="${Food.active eq true}">
							<a onclick="validateBuyNow()" target="_blank"
								class="btn btn-primary btn-md mr-1 mb-2 waves-effect waves-light">
								Buy now</a>
							<button type="button" onclick="addItemIDToCart(${Food.itemID})"
								class="btn btn-light btn-md mr-1 mb-2 waves-effect waves-light">
								<i class="fas fa-shopping-cart pr-2"></i>Add to cart
							</button>
						</c:when>
						<c:otherwise>
							<button type="button"
								class="btn btn-primary btn-md mr-1 mb-2 waves-effect waves-light">
								<del>Buy now</del>
							</button>
							<button type="button" onclick="addItemIDToCart(${Food.itemID})"
								class="btn btn-light btn-md mr-1 mb-2 waves-effect waves-light">
								<i class="fas fa-shopping-cart pr-2"></i>
								<del>Add to cart</del>
							</button>
						</c:otherwise>
					</c:choose>



				</div>

			</div>

			<div style="height: 80px"></div>

			<div class="classic-tabs">

				<ul class="nav tabs-primary nav-justified" id="advancedTab"
					role="tablist">
					<li class="nav-item"><a class="nav-link show"
						id="description-tab" data-toggle="tab" href="#description"
						role="tab" aria-controls="description" aria-selected="false">Description</a>
					</li>
					<li class="nav-item"><a class="nav-link" id="info-tab"
						data-toggle="tab" href="#info" role="tab" aria-controls="info"
						aria-selected="false">Information</a></li>
					<li class="nav-item"><a class="nav-link active"
						id="reviews-tab" data-toggle="tab" href="#reviews" role="tab"
						aria-controls="reviews" aria-selected="true">Reviews
							(${feedbacks.size()})</a></li>
				</ul>
				<div class="tab-content" id="advancedTabContent">
					<div class="tab-pane fade" id="description" role="tabpanel"
						aria-labelledby="description-tab">
						<h5>Product Description</h5>
						<p class="small text-muted text-uppercase mb-2">${FoodCat.name}</p>

						<h6>Rs.${Food.price}</h6>
						<p class="pt-1">${Food.description}</p>
					</div>
					<div class="tab-pane fade" id="info" role="tabpanel"
						aria-labelledby="info-tab">
						<h5>Additional Information</h5>
						<table class="table table-striped table-bordered mt-3">
							<thead>
								<tr>
									<th scope="row" class="w-150 dark-grey-text h6">Servings</th>
									<td><em>one single plate serves ${Food.portion}
											persons</em></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row" class="w-150 dark-grey-text h6">Price
										without tax</th>
									<td><em>${Food.price}</em></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tab-pane fade active show" id="reviews" role="tabpanel"
						aria-labelledby="reviews-tab">

						<div id="feedBackAllReviewsPanel">
							<c:choose>
								<c:when test="${feedbacks.size() > 0}">


									<h5>
										Reviews for <span>${Food.name}</span>
									</h5>
									<c:forEach var="feedback" items="${feedbacks}">
										<div class="media mt-3 mb-4">
											<img class="d-flex mr-3 z-depth-1"
												src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg"
												width="62" alt="Generic placeholder image">
											<div class="media-body">
												<div class="d-flex justify-content-between">
													<p class="mt-1 mb-2">
														<strong>${feedback.user.name}</strong> <span>- </span><span>${feedback.time}</span>
													</p>
													<ul class="rating mb-0">
														<c:forEach begin="1" end="${feedback.rating}"
															varStatus="loop">
															<li><i class="fas fa-star fa-sm text-primary"></i></li>
														</c:forEach>
														<c:forEach begin="${feedback.rating}" end="4"
															varStatus="loop">
															<li><i class="fas fa-star fa-sm grey-text"></i></li>
														</c:forEach>
													</ul>
												</div>
												<div class="d-flex justify-content-between">
													<p class="mt-1 mb-2">${feedback.review}</p>
													<c:choose>
														<c:when test="${feedback.userID eq user.userID}">
															<div>
																<button onclick="editFeedback('${feedback.feedbackID}')"
																	class="btn btn-primary btn-sm">edit</button>
																<button
																	onclick="deleteFeedback('${feedback.feedbackID}')"
																	class="btn btn-danger btn-sm">delete</button>
															</div>
														</c:when>

														<c:when test="${admin eq true}">
															<button
																onclick="deleteFeedback('${feedback.feedbackID}')"
																class="btn btn-danger btn-sm">delete</button>
														</c:when>
													</c:choose>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>

									<h3 class="text-muted">This product has no reviews yet.</h3>


								</c:otherwise>
							</c:choose>

							<div id="feedBackPanel">
								<c:choose>
									<c:when test="${editFeedback != null}">

										<div id="editFeedBackDiv">

											<div>
												<hr>
												<button type="button" onclick="postAReview()"
													class="btn btn-success waves-effect waves-light">Post
													a new review</button>
												<hr>
												<h5 class="mt-4">Edit your review</h5>
												<p>Your email address will not be published.</p>
												<div class="my-3">

													<c:forEach begin="1" end="${editFeedback.rating}"
														varStatus="loop">

														<span onmouseover="starmark(this)"
															onclick="starmark(this)" id="${loop.index}one"
															style="font-size: 20px; color:blue; cursor: pointer;"
															class="fa fa-star checked"></span>

													</c:forEach>
													<c:forEach begin="${editFeedback.rating + 1}" end="5"
														varStatus="loop">
														<span onmouseover="starmark(this)"
															onclick="starmark(this)" id="${loop.index}one"
															style="font-size: 20px; color:grey; cursor: pointer;"
															class="fa fa-star checked"></span>
													</c:forEach>
												</div>
												<div>

													<!-- Name -->
													<div class="md-form md-outline">
														<input type="text" id="form75" class="form-control pr-6"
															value="${user.name}" readonly="readonly"> <label
															for="form75" class="active text-primary">Name</label>
													</div>
													<!-- Email -->
													<div class="md-form md-outline">
														<input type="email" id="form77" class="form-control pr-6"
															value="${user.email}" readonly="readonly"> <label
															for="form77" class="active text-primary">Email</label>
													</div>
													<!-- Your review -->
													<div class="md-form md-outline">
														<textarea id="reviewText"
															class="md-textarea form-control pr-6" rows="4">${editFeedback.review}</textarea>
														<label for="reviewText" class="active">Your review</label>
													</div>
													<div class="text-right pb-2">
														<button type="button"
															onclick="updateReview('${editFeedback.feedbackID}')"
															class="btn btn-primary waves-effect waves-light">Update
															review</button>
													</div>
												</div>

											</div>


										</div>

									</c:when>
									<c:otherwise>

										<c:if test="${canReview eq true}">
											<div id="addFeedbackDiv">
												<hr>
												<h5 class="mt-4">Add a review</h5>
												<p>Your email address will not be published.</p>
												<div class="my-3">
													<span onmouseover="starmark(this)" onclick="starmark(this)"
														id="1one" style="font-size: 20px; color:grey; cursor: pointer;"
														class="fa fa-star checked"></span> <span
														onmouseover="starmark(this)" onclick="starmark(this)"
														id="2one" style="font-size: 20px; color:grey; cursor: pointer;"
														class="fa fa-star "></span> <span
														onmouseover="starmark(this)" onclick="starmark(this)"
														id="3one" style="font-size: 20px; color:grey; cursor: pointer;"
														class="fa fa-star "></span> <span
														onmouseover="starmark(this)" onclick="starmark(this)"
														id="4one" style="font-size: 20px; color:grey; cursor: pointer;"
														class="fa fa-star"></span> <span
														onmouseover="starmark(this)" onclick="starmark(this)"
														id="5one" style="font-size: 20px; color:grey; cursor: pointer;"
														class="fa fa-star"></span>
												</div>
												<div>

													<!-- Name -->
													<div class="md-form md-outline">
														<input type="text" id="form75" class="form-control pr-6"
															value="${user.name}" readonly="readonly"> <label
															for="form75" class="active text-primary">Name</label>
													</div>
													<!-- Email -->
													<div class="md-form md-outline">
														<input type="email" id="form77" class="form-control pr-6"
															value="${user.email}" readonly="readonly"> <label
															for="form77" class="active text-primary">Email</label>
													</div>
													<!-- Your review -->
													<div class="md-form md-outline">
														<textarea id="reviewText"
															class="md-textarea form-control pr-6" rows="4"></textarea>
														<label for="reviewText" class="active">Your review</label>
													</div>
													<div class="text-right pb-2">
														<button type="button" onclick="postReview()"
															class="btn btn-primary waves-effect waves-light">Add
															a review</button>
													</div>
												</div>

											</div>
										</c:if>


									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div></div>

			</div>
		</section>
	</div>

	<%@ include file="../home/footer.jsp"%>
	<script>
var count;

function starmark(item)
{
count=item.id[0];
sessionStorage.starRating = count;
var subid= item.id.substring(1);
for(var i=0;i<5;i++)
{
if(i<count)
{
document.getElementById((i+1)+subid).style.color="blue";
}
else
{
document.getElementById((i+1)+subid).style.color="grey";
}


}

};

function result()
{
//Rating : Count
//Review : Comment(id)
alert("Rating : "+count+"\nReview : "+document.getElementById("comment").value);
};

	var productID = $('#productID').val();
	
		function addItemIDToCart(itemID) {

			var quantity = $('#quantity').val();
			
			$.ajax({

				url : "AddCartItem",
				data : {
					'itemID' : itemID,
					'qty':quantity
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
		
		function validateBuyNow(){
			
			var quantity = $('#quantity').val();
			
			if(quantity > 0 && quantity < 4){
				
				
				var form = document
				.createElement("form");
		var element1 = document
				.createElement("input");
		var element2 = document
		.createElement("input");
		
		form.method = "POST";
		form.action = "BuyNow";

		element1.value = quantity;
		element1.name = "quantity";
		form.appendChild(element1);
		
		element2.value = productID;
		element2.name = "productID";
		form.appendChild(element2);
		
		
		document.body.appendChild(form);

		form.submit();
				//$('#buyNowForm').attr('action', "placeOrder").submit();
			}
			
			else
				toastr.error('Product quantity should be in between 1 and 3');
			
			
		}
		
		function postReview(){
			
			var review = $('#reviewText').val();
			var rating = $('#reviewText').val();
			
			$.ajax({

				url : "insertFeedback",
				data : {
					'itemID' : productID,
					'review':review,
					'rating':count
				},

				success : function(data) {
					if (data == 'true') {
						getAllProductReviews();
						toastr.success('Your review was added');
					}

					else {
						toastr.error('Your review was not added');
					}

				}

			})

			
		};
		
function deleteFeedback(feedbackID){

			$.ajax({

				url : "deleteFeedback",
				data : {
					'feedbackID' : feedbackID,
				},

				success : function(data) {
					if (data == 'true') {
						toastr.success('Your review was deleted');
						getAllProductReviews();
					}

					else {
						toastr.error('Your review was not deleted');
					}

				}

			})

			
		};
		
function editFeedback(feedbackID){

			$.ajax({

				url : "editFeedback",
				data : {
					'feedbackID' : feedbackID,
					'itemID' : productID
				},

				success : function(data) {
					var result = $(data).find('#feedBackPanel');					
					$('#feedBackPanel').html(result);

				}

			})

			
		};
		
function updateReview(feedbackID){
			
			var review = $('#reviewText').val();
			var rating = $('#reviewText').val();
			
			$.ajax({

				url : "updateFeedback",
				data : {
					'feedbackID' : feedbackID,
					'itemID' : productID,
					'review':review,
					'rating':count
				},

				success : function(data) {
					if (data == 'true') {
						toastr.success('Your review was updated');
						getAllProductReviews();
					}

					else {
						toastr.error('Your review was not updated');
					}

				}

			})

			
		};
		
function getAllProductReviews(){
			
			
			$.ajax({

				url : "product",
				data : {
					'fID' : productID,
				},

				success : function(data) {
					var result = $(data).find('#feedBackAllReviewsPanel');					
					$('#feedBackAllReviewsPanel').html(result);

				}

			})

			
		};
		
		
function postAReview(){
			
			
			$.ajax({

				url : "product",
				data : {
					'fID' : productID,
				},

				success : function(data) {
					var result = $(data).find('#feedBackPanel');					
					$('#feedBackPanel').html(result);

				}

			})

			
		};
	</script>

</body>
</html>