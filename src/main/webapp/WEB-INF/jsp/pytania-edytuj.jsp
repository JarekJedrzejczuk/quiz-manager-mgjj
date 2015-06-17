<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>
<a href="<spring:url value="/pytania/remove/${pyt.pytanie_id}.html" />" class="btn btn-danger triggerRemove" data-toggle="modal" data-target="#modalRemove">
							Usuń
</a>
<form:form commandName="pytanie" cssClass="form-horizontal registrationForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Zapisano pytanie!!!</div>
	</c:if>
	<div class="form-group">
		<label for="nazwaPytania" class ="col-sm-2 control-label" >Wprowadź nazwę pytania </label>
		   <div class="col-sm-10">
		   		<form:input path="nazwaPytania" cssClass="form-control"/>
		   		<form:errors path="nazwaPytania"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="trescPytania" class ="col-sm-2 control-label" >Wprowadź treść pytania </label>
		   <div class="col-sm-10">
		   		<form:input path="trescPytania" cssClass="form-control"/>
		   		<form:errors path="trescPytania"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="poprawnaOdpowiedz" class ="col-sm-2 control-label" >Wprowadź poprawną odpowiedź </label>
		   <div class="col-sm-10">
		   		<form:input path="poprawnaOdpowiedz" cssClass="form-control"/>
		   		<form:errors path="poprawnaOdpowiedz"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="maxIloscPunktow" class ="col-sm-2 control-label">Wprowadź maksymalna ilosc punktow </label>
		   <div class="col-sm-10">
		   		<form:input path="maxIloscPunktow" cssClass="form-control"/>
		   		<form:errors path="maxIloscPunktow"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Wprowadz odpowiedzi" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
	
</form:form>