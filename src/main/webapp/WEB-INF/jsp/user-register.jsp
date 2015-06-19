<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Rejestracja zakończyła się powodzeniem! Witamy w systemie!!!</div>
	</c:if>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Login: </label>
		   <div class="col-sm-10">
		   		<form:input path="name" cssClass="form-control"/>
		   		<form:errors path="name"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Email </label>
		   <div class="col-sm-10">
		   		<form:input path="email" cssClass="form-control"/>
		   		<form:errors path="email"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Hasło </label>
		   <div class="col-sm-10">
		   		<form:password path="password" cssClass="form-control"/>
		   		<form:errors path="password"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Wprowadź hasło jeszcze raz </label>
		   <div class="col-sm-10">
		   		<input type="password" name="password_again" is="password_again" class = "form-control"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Imię </label>
		   <div class="col-sm-10">
		   		<form:input path="imie" cssClass="form-control"/>
		   		<form:errors path="imie"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Nazwisko </label>
		   <div class="col-sm-10">
		   		<form:input path="nazwisko" cssClass="form-control"/>
		   		<form:errors path="nazwisko"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >PESEL </label>
		   <div class="col-sm-10">
		   		<form:input path="pesel" cssClass="form-control"/>
		   		<form:errors path="pesel"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Instytucja </label>
		   <div class="col-sm-10">
		   		<form:input path="instytucja" cssClass="form-control"/>
		   		<form:errors path="instytucja"/>
		   </div>
	</div>
	
	
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Save" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
</form:form>
<script type="text/javascript">
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
					minlength : 11,
					maxlength : 11
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
					required:"Wypełnij to pole",
					remote: "Nazwa użytkownika istnieje"
				}
			}
		}
	);
});
</script>



	