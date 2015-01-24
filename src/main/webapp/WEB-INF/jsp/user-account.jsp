<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Dane zostały uzupełnione</div>
	</c:if>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >Name: </label>
		   <div class="col-sm-10">
		   		<form:input path="name" cssClass="form-control" value="${user.name}"/>
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
		<label for="name" class ="col-sm-2 control-label" >hasło </label>
		   <div class="col-sm-10">
		   		<form:password path="password" cssClass="form-control"/>
		   		<form:errors path="password"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >wprowadź hasło jeszcze raz </label>
		   <div class="col-sm-10">
		   		<input type="password" name="password_again" is="password_again" class = "form-control"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >imie </label>
		   <div class="col-sm-10">
		   		<form:input path="imie" cssClass="form-control"/>
		   		<form:errors path="imie"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" >nazwisko </label>
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
		<label for="name" class ="col-sm-2 control-label" >instytucja </label>
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
<script type="text/javascript" src="/WEB-INF/scripts/userFormValidation.js"/> 
	