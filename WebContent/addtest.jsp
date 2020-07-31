<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form  enctype="multipart/form-data">
name
<input type="text" name = "name" >	
</br>
description
<input type="text" name = "description" >	
</br>
portion
<input type="text" name = "portion" >	
</br>
price
<input type="text" name = "price" >	
</br>
category
<input type="text" name = "category" >	
</br>
image
<input type="file" name = "file" >	
</br></br>
<input type= "submit" >
</br></br></br>
<button  type ="button" value="Submitff" id="btnSubmit2"> </button>
</form>


<form>
name
<input type="text" name = "number1" >	

description
<input type="text" name = "number2"  >

<button  type ="button" value="Submitff" id="btnSubmit"> </button>

</form>

<input type="text" id = "result2" value="" >

	<!-- jQuery -->

	
	<script src="Design/component/jquery/jquery.js"  type="text/javascript"></script>
	<script  src="Design/component/jquery/jquery.min.js"  type="text/javascript"></script>
	<script src="Design/component/jquery-3.4.1.min.js"  type="text/javascript"></script>
	<script src="Design/component/jquery.validate.min.js"  type="text/javascript"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script>
	
	$(document).ready(function () {

	    $("#btnSubmit").click(function (event) {

	        var number1 = $("input[name=number1]").val();
	        var number2 = $("input[name=number2]").val();

	        $.ajax({
	            type: "POST",
				data: {
				number1: 	number1,
							number2: number2,
				},
				url: 'test123',
	            success: function (result) {
	                $("#result2").val(result);

	            }
	
	        });

	    });

	    
	    $("#btnSubmit2").click(function (event) {

	        var name =  $("input[name=name]").val();
	        var description =  $("input[name=description]").val();
	        var portion = $("input[name=portion]").val();
	        var price =  $("input[name=price]").val();
	        var category =  $("input[name=category]").val();
	        var file =  $("input[name=file]")[0].files[0];
	        $.ajax({
	            type: "POST",
				data: {
					name: name,
					description: description,
					portion: portion,
					price: price,
					category: category,
					file: file,
				},
				enctype: 'multipart/form-data',
				url: 'AddNewFoodItem',	            
	            processData: false,
	            contentType: false,
	            success: function (result) {
	               alert('added');

	            }
	
	        });

	    });
	    
	});
	
	</script>







</body>
</html>