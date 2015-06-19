<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layouts/taglib.jsp"%>

<form:form commandName="quizTmp" cssClass="form-horizontal registrationForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Zapisano quiz!!!</div>
	</c:if>
	<div class="form-group">
		<label for="nazwa" class ="col-sm-2 control-label" >Wprowadź nazwę quizu </label>
		   <div class="col-sm-10">
		   		<form:input path="nazwa" cssClass="form-control"/>
		   		<form:errors path="nazwa"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="trescPytania" class ="col-sm-2 control-label" >Wprowadź limit czasu w minutach </label>
		   <div class="col-sm-10">
		   		<form:input path="limitCzasu" cssClass="form-control"/>
		   		<form:errors path="limitCzasu"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Wprowadz odpowiedzi" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
	
	
</form:form>