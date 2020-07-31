
<footer class="page-footer font-small special-color-dark mt-5 pt-4">

	<!-- Footer Elements -->
	<div class="container">

		<!-- Social buttons -->
		<ul class="list-unstyled list-inline text-center">
			<li class="list-inline-item"><a class="btn-floating btn-fb mx-1">
					<i class="fab fa-facebook-f"> </i>
			</a></li>
			<li class="list-inline-item"><a class="btn-floating btn-tw mx-1">
					<i class="fab fa-twitter"> </i>
			</a></li>
			<li class="list-inline-item"><a
				class="btn-floating btn-gplus mx-1"> <i
					class="fab fa-google-plus-g"> </i>
			</a></li>
			<li class="list-inline-item"><a class="btn-floating btn-li mx-1">
					<i class="fab fa-linkedin-in"> </i>
			</a></li>
			<li class="list-inline-item"><a
				class="btn-floating btn-dribbble mx-1"> <i
					class="fab fa-dribbble"> </i>
			</a></li>
		</ul>
		<!-- Social buttons -->

	</div>
	<!-- Footer Elements -->

	<!-- Copyright -->
	<div class="footer-copyright text-center py-3">
		© 2020 Copyright: <a href="https://mdbootstrap.com/"> Designed and
			Developed By Manuka Yasas</a>
	</div>
	<!-- Copyright -->

</footer>

<script src="Design/mdPro/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="Design/panel/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="Design/panel/js/bootstrap.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="Design/panel/js/mdb.min.js"></script>
<div class="hiddendiv common"></div>
<script src="Design/mdPro/js/modules/addons/datatables.js"></script>
<script src="Design/mdPro/js/modules/addons/datatables.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="Design/mdPro/js/mdb-file-upload.min.js"></script>
<script type="text/javascript">
	
</script>

<!-- Initializations -->

<div class="drag-target" style="left: 0px;"></div>

<script src="Design/panel/js/darkmode.js" type="text/javascript">
	
</script>
<script type="text/javascript"
	src="Design/myScripts/js/datatablesProducts,.js"></script>


<script type="text/javascript"
	src="Design/myScripts/js/UserManagement.js"></script>


<script type="text/javascript" src="Design/myScripts/js/contactUs.js"></script>
<script type="text/javascript"
	src="Design/myScripts/js/dashboradChart.js"></script>
<script type="text/javascript">
	tableRunJquery();

	$.ajax({

		url : "RetreivePanelCategory",
		success : function(data, textStatus, jqXHR) {

			console.log("ssss");
			$('#headerRefresh22').html(data);
			tinyMYCINTSTART();

		}

	})
</script>


