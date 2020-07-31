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
<title>Data Panel</title>
<!-- MDB icon -->
<link rel="icon" href="Design/panelv1/img/favicon.ico"
	type="image/x-icon">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="Design/panelv1/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="Design/panelv1/css/mdb.min.css">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="Design/panelv1/css/style.css">

<!--===============================SWEET ALERT CSS ================================================-->
<link href="Design/sweetalert2-9.10.12/package/dist/sweetalert2.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<!--===============================================================================================-->
<!--===============================SWEET ALERT JS =================================================-->
<script
	src="Design/sweetalert2-9.10.12/package/dist/sweetalert2.all.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<!--===============================================================================================-->
<!--===============================SWEET ALERTS ON UPDATE DELETE ==================================-->
<script src="Design/panelv1/js/delete.js">
	
</script>
<!--===============================================================================================-->

</head>
<body>

href = "FoodManagement?page=${i}&categoryID=${categoryID}"


<h1>Ceylon Vehicle Service And Fuel Management</h1>
<h1>IT19133850 MANUKA YASAS SLIIT</h1>
	<h2>Web Application using JSP/Servlet</h2>
      <form action = "ListAdminsServlet" method = "get">
      
      <input type= "submit" value = "START Now">
      </form>
    
    <script>
	getAll();
	function getAll(){
	$('#tbl-food').dataTable().fnDestroy();	
	$.ajax({
		
		url: "ListALLFood",
		type: "GET",
		dataType: "JSON",
		
		success:function(data){
			$('#tbl-food').dataTable({
				
				"aaData" : data,
				"scrollX": true,
				"aoColumns":[
					
					{"sTitle: "name", "mData": "name"},
					{"sTitle: "name", "mData": "name"},
						

					
					
				]
				
			});
			
		}
		
	});
		
	}
	
	</script>
    
</body>
</html>