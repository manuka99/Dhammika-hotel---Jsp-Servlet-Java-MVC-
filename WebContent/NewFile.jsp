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
<title>Home Page</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="Design/mdPro/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="Design/mdPro/css/mdb.min.css" rel="stylesheet">
<link href="Design/mdPro/css/mdb.ecommerce.min.css" rel="stylesheet">

</head>
<body class="homepage-v1 hidden-sn white-skin animated">
<jsp:include page="WEB-INF/views/home/header.jsp"></jsp:include>
<section>
<jsp:include page="WEB-INF/views/home/carousel.jsp"></jsp:include>
<div class="container-fluid mx-0 px-0">
      <nav class="navbar navbar-expand-lg navbar-dark primary-color mb-5">
<jsp:include page="WEB-INF/views/home/menue.jsp"></jsp:include>
</nav>
</div>
</section>
<jsp:include page="WEB-INF/views/profile/cartTable1.jsp"></jsp:include>
<jsp:include page="WEB-INF/views/home/footer.jsp"></jsp:include>
    <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="Design/mdPro/js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="Design/mdPro/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="Design/mdPro/js/bootstrap.min.js">
  </script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="Design/mdPro/js/mdb.min.js"></script>
  <script type="text/javascript">
    /* WOW.js init */
    new WOW().init();
    // Tooltips Initialization
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
    })

    // Material Select Initialization
    $(document).ready(function () {
      $('.mdb-select').material_select();
    });

    // SideNav Initialization
    $(".button-collapse").sideNav();

  </script>
</body>
</html>
