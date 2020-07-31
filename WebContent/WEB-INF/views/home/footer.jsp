
<footer
	class="page-footer text-center text-md-left stylish-color-dark pt-0">

	<div style="background-color: #4285f4;">

		<div class="container">

			<!-- Grid row -->
			<div class="row py-4 d-flex align-items-center">

				<!-- Grid column -->
				<div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">

					<h6 class="mb-0 white-text">Get connected with us on social
						networks!</h6>

				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-6 col-lg-7 text-center text-md-right">

					<!-- Facebook -->
					<a class="fb-ic ml-0 px-2"> <i
						class="fab fa-facebook-f white-text"> </i>

					</a>

					<!-- Twitter -->
					<a class="tw-ic px-2"> <i class="fab fa-twitter white-text">
					</i>

					</a>

					<!-- Google + -->
					<a class="gplus-ic px-2"> <i
						class="fab fa-google-plus-g white-text"> </i>

					</a>

					<!-- Linkedin -->
					<a class="li-ic px-2"> <i class="fab fa-linkedin-in white-text">
					</i>

					</a>

					<!-- Instagram -->
					<a class="ins-ic px-2"> <i class="fab fa-instagram white-text">
					</i>

					</a>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>

	</div>

	<!-- Footer Links -->
	<div class="container mt-5 mb-4 text-center text-md-left">

		<div class="row mt-3">

			<!-- First column -->
			<div class="col-md-3 col-lg-4 col-xl-3 mb-4">

				<h6 class="text-uppercase font-weight-bold">

					<strong>Dammika Hotel PVT LTD</strong>

				</h6>

				<hr class="blue mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">

				<p>Each Hilton Hotel & Resort is a unique reflection of its
					destination and combines local influences with out-of-this-world
					service to make your stay truly memorable. Make the most of your
					stay with innovative fitness equipment, restful spa treatments, and
					nutritious food and beverage options.</p>

			</div>
			<!-- First column -->

			<!-- Second column -->
			<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

				<h6 class="text-uppercase font-weight-bold">

					<strong>Food and beverage</strong>

				</h6>

				<hr class="blue mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">

				<p>

					<a href="#!">xxxxxxxxxxx</a>

				</p>

				<p>

					<a href="#!">xxxxxxxxxxx</a>

				</p>

				<p>

					<a href="#!">xxxxxxxxxxx</a>

				</p>

				<p>

					<a href="#!">xxxxxxxxxxx</a>

				</p>

			</div>
			<!-- Second column -->

			<!-- Third column -->
			<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

				<h6 class="text-uppercase font-weight-bold">

					<strong>What we offer</strong>

				</h6>

				<hr class="blue mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">

				<p>

					<a href="#!">Secure Account</a>

				</p>

				<p>

					<a href="#!">A variety of food and beverage options</a>

				</p>

				<p>

					<a href="#!">Considerable Shipping Rates</a>

				</p>

				<p>

					<a href="#!">Secure Checkout</a>

				</p>

			</div>
			<!-- Third column -->

			<!-- Fourth column -->
			<div class="col-md-4 col-lg-3 col-xl-3">

				<h6 class="text-uppercase font-weight-bold">

					<strong>Contact</strong>

				</h6>

				<hr class="blue mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">

				<p>

					<i class="fas fa-home mr-3"></i> Dammika hotel, colombo
				</p>

				<p>

					<i class="fas fa-envelope mr-3"></i> dammika@gmail.com
				</p>

				<p>

					<i class="fas fa-phone mr-3"></i>077*******
				</p>

				<p>

					<i class="fas fa-print mr-3"></i> 011*******
				</p>

			</div>
			<!-- Fourth column -->

		</div>

	</div>
	<!-- Footer Links -->

	<!-- Copyright -->
	<div class="footer-copyright py-3 text-center">

		<div class="container-fluid">

			© 2020 Copyright: <a href="" target="_blank"> dammika@hotel PVT
				LMT </a> Developer: <a href="" target="_blank"> Manuka Yasas </a>
		</div>

	</div>
	<!-- Copyright -->

</footer>


<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="Design/mdPro/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="Design/mdPro/js/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="Design/mdPro/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="Design/mdPro/js/bootstrap.min.js">
	
</script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="Design/mdPro/js/mdb.min.js"></script>
<script type="text/javascript" src="Design/mdPro/js/modules/toastr.js"></script>
<script src="Design/mdPro/js/modules/addons/datatables.js"></script>
<script src="Design/mdPro/js/modules/addons/datatables.min.js"></script>
<script type="text/javascript"
	src="Design/mdPro/js/mdb-file-upload.min.js"></script>
<script type="text/javascript">
	$('.file-upload').file_upload();
</script>

<script src="Design/myScripts/js/userProfile.js" type="text/javascript"></script>
<script>
	ordersTableScriptChanging();
</script>


<script type="text/javascript">
	/* WOW.js init */
	new WOW().init();
	// Tooltips Initialization
	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})

	// Material Select Initialization
	$(document).ready(function() {
		$('.mdb-select').material_select();
	});

	// SideNav Initialization
	$(".button-collapse").sideNav();
</script>
<script>
	//to display real time notifications
	unreadNotifications();
	function unreadNotifications() {
		console.log("loaded");

		var noOfNoti = $('#unreadNotifications').text();
		
		$.ajax({

			url : "NotificationsUnreadUser",
			success : function(data, textStatus, jqXHR) {
				$('#unreadNotifications').text(data);
				
				if($('#unreadNotifications').text() > noOfNoti && noOfNoti != ''){
					
					toastr.success('You have new notifications');
					
				}
				
			}

		});
		setTimeout(unreadNotifications, 10000);
	};
</script>
<script>
	function ResendActivationCode() {
		$
				.ajax({

					url : "ResendActivationCode",
					success : function(data) {

						console.log(data);
						if (data == 'success')
							alert('Verification code sent successfully');

						else
							alert('There was a error in sending the verification code');

					}

				})

	};


</script>
