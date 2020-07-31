<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet">
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
</head>
<body>


	<div class="col-sm-8">

		<div class="panel-body">

			<table id="tbl-food" class="table table-bordered" cellpadding="0"
				cellspacing="0" width="100%">

				<thead>

					<tr>

						<th></th>


					</tr>

				</thead>
			</table>
		</div>
	</div>


	<fieldset>

		<legend> demo 1 </legend>
		<input type="button" value="didplay" id="bttn1">
		<div id="result2"></div>
	</fieldset>



	<c:forEach var="Food" items="${FoodList}">

		<img src="data:image/jpg;base64,${Food.image}" width="50" height="50" />
							${Food.name}
							${Food.description}
							<td>${Food.portion}
	</c:forEach>



	<script src="Design/component/jquery/jquery.js" type="text/javascript"></script>
	<script src="Design/component/jquery/jquery.min.js"
		type="text/javascript"></script>
	<script src="Design/component/jquery-3.4.1.min.js"
		type="text/javascript"></script>
	<script src="Design/component/jquery.validate.min.js"
		type="text/javascript"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

	<script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

	<script>
		$(document)
				.ready(
						function() {
							$
									.ajax({

										type : 'GET',
										url : 'AddNewFoodItem',
										headers : {
											Accept : "application/json; charset=utf-8",
											"Content-Type" : "application/json; charset=utf-8"

										},
										success : function(result) {

											var listProduct = $
													.parseJSON(result);
											var s = '';
											for (var i = 0; i < listProduct.length; i++) {
												s += 'ID: '
														+ listProduct[i].itemID
														+ listProduct[i].description
														+ '<img src="data:image/jpg;base64,' + listProduct[i].image + '" width="50" height="50" /> '
														+ '<br>';

											}
											document.getElementById('result2').innerHTML = s;
											 $("$FoodList").html(listProduct);
										}

									});

						});
	</script>




</body>
</html>