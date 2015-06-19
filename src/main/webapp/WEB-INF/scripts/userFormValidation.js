$(document).ready(function() {
	
	$(".registrationForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3,
					remote : {
						url: "<spring:url value='/register/available.html' />",
						type: "get",
						data: {
							username: function() {
								return $("#name").val();
							}
						}
					}
				},
				email: {
					required : true,
					email: true
				},
				password: {
					required : true,
					minlength : 5
				},
				password_again: {
					required : true,
					minlength : 5,
					equalTo: "#password"
				},
				imie: {
					required : true,
					minlength : 1
				},
				nazwisko: {
					required : true,
					minlength : 1
				},
				pesel: {
					required : true,
					minlength : 10,
					maxlength : 10
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				name: {
					required:"Wype³nij to pole",
					remote: "Nazwa u¿ytkownika istnieje"
				}
			}
		}
	);
});