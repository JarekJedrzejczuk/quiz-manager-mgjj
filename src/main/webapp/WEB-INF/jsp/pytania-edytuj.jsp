<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
<form:form commandName="pytanie" cssClass="form-horizontal registrationForm" id="pytanieForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Zapisano pytanie!!!</div>
	</c:if>
	<div class="form-group">
		<label for="pytanie_id" class ="col-sm-2 control-label" >id</label>
		   <div class="col-sm-10">
		   		<form:input path="pytanie_id" cssClass="form-control" readonly="true"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="nazwaPytania" class ="col-sm-2 control-label" >Nazwa pytania </label>
		   <div class="col-sm-10">
		   		<form:input path="nazwaPytania" cssClass="form-control"/>
		   		<form:errors path="nazwaPytania"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="trescPytania" class ="col-sm-2 control-label" >Treść pytania </label>
		   <div class="col-sm-10">
		   		<form:textarea path="trescPytania" cssClass="form-control"/>
		   		<form:errors path="trescPytania"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="poprawnaOdpowiedz" class ="col-sm-2 control-label" >Poprawna odpowiedź </label>
		   <div class="col-sm-10">
		   		<form:textarea path="poprawnaOdpowiedz" cssClass="form-control"/>
		   		<form:errors path="poprawnaOdpowiedz"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="maxIloscPunktow" class ="col-sm-2 control-label">Maksymalna ilość punktów </label>
		   <div class="col-sm-10">
		   		<form:input path="maxIloscPunktow" cssClass="form-control"/>
		   		<form:errors path="maxIloscPunktow"/>
		   </div>
	</div>
	
	<c:forEach items="${pytanie.odpowiedzi}" var="odp" varStatus="loop">
		<div class="form-group">
		        <label for="tresc" class ="col-sm-2 control-label">id odpowiedzi w bazie
		        	<br>treść odpowiedzi
		        </label>
		        <div class="col-sm-10">
		        	<form:input items="${odp.id}" path="odpowiedzi[${loop.index}].id" readonly="true" size="5"/>
		            <form:textarea items="${odp.tresc}" path="odpowiedzi[${loop.index}].tresc" cssClass="form-control"/>
		        </div>
		</div>
		                    
	 </c:forEach>
	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Zapisz zmiany" class="btn btn-sm btn-primary" />
		   </div>
	</div>
</form:form>