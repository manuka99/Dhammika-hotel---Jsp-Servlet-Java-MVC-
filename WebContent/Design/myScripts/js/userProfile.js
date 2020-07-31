var email_static = null;
var name_static = null;
var phone_static = null;
var dateOfBirth_static = null;
var address_static = null;

address_static = $('#address').val();
email_static = $('#email').val();
name_static = $('#name').val();
phone_static = $('#phone').val();
dateOfBirth_static = $('#dateOfBirth').val();

$("#updateProfile").fadeOut();

$("#myOrders").click(function() {

	console.log("orders in");

	$.ajax({

		url : "GetMyOrders",
		success : function(data, textStatus, jqXHR) {
			var result = $(data).find('#ContentChange');
			$('#ContentChange').html(result);
			var url = "GetMyOrders";
			;
			history.pushState({}, "", url);
			ordersTableScriptChanging();

		}

	})

});

$("#myProfile").click(function() {

	console.log("profile in");

	$.ajax({

		url : "basicDetails",
		success : function(data, textStatus, jqXHR) {
			var result = $(data).find('#ContentChange');
			$('#ContentChange').html(result);
			var url = "basicDetails";
			;
			history.pushState({}, "", url);

			address_static = $('#address').val();
			email_static = $('#email').val();
			name_static = $('#name').val();
			phone_static = $('#phone').val();
			dateOfBirth_static = $('#dateOfBirth').val();
			console.log(dateOfBirth_static);
			$("#updateProfile").fadeOut();

		}

	})

});

$("#mySecurity").click(function() {

	$('#ContentChange').load('mySecurity #ContentChange');
	history.pushState({}, "", "mySecurity");
	PasswordSecurityhideAll();

});

$("#myComplains").click(function() {

	console.log("orders in");

	$.ajax({

		url : "RetrieveInquiryUser",
		success : function(data, textStatus, jqXHR) {
			var result = $(data).find('#ContentChange');
			$('#ContentChange').html(result);
			var url = "RetrieveInquiryUser";
			;
			history.pushState({}, "", url);
			ordersTableScriptChanging();
			$('.file-upload').file_upload();

		}

	})

});

var status = 0;

function inputForm() {

	console.log("inputed");

	var name = $('#name').val();
	var email = $('#email').val();
	var address = $('#address').val();
	var phone = $('#phone').val();
	var dateOfBirth = $('#dateOfBirth').val();
	var atposition = email.indexOf("@");
	var dotposition = email.lastIndexOf(".");

	if (email != email_static && email.length > 10) {

		$.ajax({

			url : "CheckUserEmail",
			data : {
				'email' : email

			},

			success : function(data) {

				if (data == "false") {
					status = 1;
					$("#updateProfile").fadeIn();
					console.log(data);
				}

				else {
					status = 0;
					$("#updateProfile").fadeOut();
					alert('email has been taken');
				}

			}

		})

	} else if (name != name_static) {

		if (name.length < 10) {
			status = 0;
			alert('name is too short');
		}

		else {
			status = 1;
			$("#updateProfile").fadeIn();
		}
	}

	else if (address != address_static) {

		if (address.length > 12) {
			status = 1;
			$("#updateProfile").fadeIn();

		} else {
			status = 0;
			alert('address is too short');
		}

	}

	else if (phone != phone_static) {
		status = 1;
		$("#updateProfile").fadeIn();
	}

	else if (dateOfBirth != dateOfBirth_static) {

		if (dateOfBirth != "") {
			status = 1;
			$("#updateProfile").fadeIn();
		} else {
			status = 0;
			alert('please select a valide date of birth');
		}
	}

	else {
		status = 0;
		$("#updateProfile").fadeOut();
	}

};

function updateProfile() {
	event.preventDefault();
	var form = event.target.form; // storing the form

	if (status == 1) {

		var name = $('#name').val();
		var email = $('#email').val();
		var address = $('#address').val();
		var phone = $('#phone').val();
		var dateOfBirth = $('#dateOfBirth').val();

		$.ajax({

			url : "UpdateUserProfile",
			data : {
				'name' : name,
				'email' : email,
				'address' : address,
				'phone' : phone,
				'dateOfBirth' : dateOfBirth,
			},
			success : function(data, textStatus, jqXHR) {

				if (data === "true")
					$("#body").load(location.href + "#body");

				else
					alert('dwrswraa');

			}

		})

	}

	else {
		alert('sorry, you dont have access');
	}

}

function MoreOnOrder(orderID) {
	$.ajax({

		url : "GetMyOrders",
		data : {
			'orderID' : orderID
		},

		success : function(data, textStatus, jqXHR) {

			var result = $(data).find('#ContentChange');
			$('#ContentChange').html(result);
			var url = "GetMyOrders?orderID=" + orderID;
			history.pushState({}, "", url);
		}

	})
};

var newPassword = "";
var currentPassword = "";
var repeatPassword = "";
var status = 0;
var testPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

function PasswordSecurityhideAll() {

	console.log("passSec");
	status = 0;
	$('#newEnter').hide();
	$('#short').hide();
	$('#match').hide();
	$('#conditionPass').hide();
	$("#UpdatePassword").slideUp();
	// $('#newPassword').attr("disabled", "disabled");
	// $('#repeatPass').attr("disabled", "disabled");

}

function passwordUpdateCheck() {

	newPassword = $('#newPassword').val();
	currentPassword = $('#currentPassword').val();
	repeatPassword = $('#repeatPass').val();

	if (currentPassword != "") {

		$('#newPassword').removeAttr('disabled');

		if (newPassword != "") {

			if (newPassword.match(testPassword)) {

				$('#repeatPass').removeAttr('disabled');

				if (newPassword == repeatPassword) {
					PasswordSecurityhideAll();
					status = 1;
					$("#UpdatePassword").slideDown();
				}

				else {
					PasswordSecurityhideAll();
					$('#match').show();

				}

			}

			else {
				PasswordSecurityhideAll();
				$('#repeatPass').attr("disabled", "disabled");
				$('#conditionPass').show();
			}

		} else {
			PasswordSecurityhideAll();
			$('#repeatPass').attr("disabled", "disabled");
			$('#newEnter').show();
		}

	}

	else {
		PasswordSecurityhideAll();
		$('#newPassword').attr("disabled", "disabled");
		$('#repeatPass').attr("disabled", "disabled");
	}

	console.log(status);
};

function updatePassword() {

	event.preventDefault();
	var form = event.target.form; // storing the form

	if (status == 1) {
		$.ajax({

			url : "UpdateUserPassword",
			data : {
				'newPassword' : newPassword,
				'currentPassword' : currentPassword
			},

			success : function(data) {

				if (data === "success") {
					$.toaster('Your password has been changed!', 'Success',
							'success');
					window.location.replace("login");
				}

				else if (data === "error") {
					$.toaster('Please try again latter', 'Error', 'danger');
				}

				else {
					$.toaster('Your password has not been changed!',
							'Incorrect', 'danger');
				}

			}

		})
	}

	else
		$.toaster('Please try again latter!', 'Error', 'danger');
};

function addNewInquiryDetails() {

	var subject = $('#subject').val();
	var message = $('#message').val();

	console.log(message + subject);

	var fdbrnn = new FormData();
	fdbrnn.append('subject', subject);
	fdbrnn.append('message', message);

	var fileDatae = document.querySelector('#image1');
	fdbrnn.append('img1', fileDatae.files[0]);

	var fileDatae2 = document.querySelector('#image2');
	fdbrnn.append('img2', fileDatae2.files[0]);

	var fileDatae3 = document.querySelector('#image3');
	fdbrnn.append('img3', fileDatae3.files[0]);

	// for(let [name, value] of fdbrnn) {
	// alert(`${name} = ${value}`); // key1=value1, then key2=value2
	// }

	var request = new XMLHttpRequest();

	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200
				&& this.responseText === "true") {
			$("#body").load(location.href + "#body");
		}
	};

	request.upload.addEventListener('progress', function(e) {

		document.querySelector('#progress').innerHTML = Math.round(e.loaded
				/ e.total * 100)
				+ '%';

	}, false);

	request.open('post', 'InsertInquiryUser', true);
	request.send(fdbrnn);

};

function MoreOnInquiry(inqID) {

	$.ajax({

		url : "RetrieveInquiryUser",
		data : {
			'inquiryID' : inqID
		},

		success : function(data, textStatus, jqXHR) {

			var result = $(data).find('#supportEmailPlatForm');
			$('#ContentChange').html(result);
			var url = "RetrieveInquiryUser?inquiryID=" + inqID;
			history.pushState({}, "", url);
			$('.file-upload').file_upload();
		}

	})

};

function startTrackingNewInquries() {
	var inqID = $('#contactUsID').val();
	$.ajax({

		url : "RetrieveInquiryUser",
		data : {
			'inquiryID' : inqID
		},

		success : function(data, textStatus, jqXHR) {

			var result = $(data).find('#inquriyResponsesMsg');
			$('#inquriyResponsesMsg').html(result);
			$('.file-upload').file_upload();
		}

	})

};

function addResponseINQ() {

	var inqID = $('#inqID').val();
	var message = $('#messagetex').val();

	console.log(message);

	var fdbrnn = new FormData();
	fdbrnn.append('message', message);
	fdbrnn.append('inqID', inqID);

	var fileDatae = document.querySelector('#image1');
	fdbrnn.append('img1', fileDatae.files[0]);

	var fileDatae2 = document.querySelector('#image2');
	fdbrnn.append('img2', fileDatae2.files[0]);

	var fileDatae3 = document.querySelector('#image3');
	fdbrnn.append('img3', fileDatae3.files[0]);

	var request = new XMLHttpRequest();

	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200
				&& this.responseText == "true") {
			$("#body").load(location.href + "#body");
		}
	};

	request.upload.addEventListener('progress', function(e) {

		document.querySelector('#progress').innerHTML = Math.round(e.loaded
				/ e.total * 100)
				+ '%';

	}, false);

	request.open('post', 'InsertResponseINQ', true);
	request.send(fdbrnn);

};

var valueImageUpload = 0;

$(document).on(
		"click",
		"#uploadNewImage_btn",
		function() {

			if (valueImageUpload == 0) {
				valueImageUpload = 1;
				$('#image1Div').slideDown();
			}

			else if (valueImageUpload == 1
					&& $('#image1').get(0).files.length != 0) {
				valueImageUpload = 2;
				$('#image2Div').slideDown();
			}

			else if (valueImageUpload == 2
					&& $('#image1').get(0).files.length != 0
					&& $('#image2').get(0).files.length != 0) {
				valueImageUpload = 3
				$('#image3Div').slideDown();
				$('#uploadNewImage').slideUp();
			}

			else if (valueImageUpload > 2)
				alert('You cannot have more than 3 images! ');

			else
				alert('Please add images to the empty spaces given! ');

		});

function canceMyOrder(orderID) {

	$
			.ajax({

				url : "CancelOrderUser",
				data : {
					'orderID' : orderID
				},

				success : function(data, textStatus, jqXHR) {

					if (data === 'true')
						alert('order has been cancelled successfully');

					else
						alert('your order cannot be canncelled at this stage for more details please do call our hotline..');
				}

			})

};

// orders table
function ordersTableScriptChanging() {
	$(document)
			.ready(
					function() {
						$('#ordersTable').DataTable();
						$('#ordersTable_wrapper').find('label')
								.each(
										function() {
											$(this).parent().append(
													$(this).children());
										});
						$('#ordersTable_wrapper .dataTables_filter').find(
								'input').each(function() {
							const $this = $(this);
							$this.attr("placeholder", "Search");
							$this.removeClass('form-control-sm');
						});
						$('#ordersTable_wrapper .dataTables_length').addClass(
								'd-flex flex-row');
						$('#ordersTable_wrapper .dataTables_filter').addClass(
								'md-form');
						$('#ordersTable_wrapper select')
								.removeClass(
										'custom-select custom-select-sm form-control form-control-sm');
						$('#ordersTable_wrapper select').addClass('mdb-select');
						$('#ordersTable_wrapper .mdb-select').materialSelect();
						$('#ordersTable_wrapper .dataTables_filter').find(
								'label').remove();
					});
}