<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layouts/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<tbody>
			<tr>
				<td><b>tresc pytania</b></td>
				<td><c:out value="${lastPytanie.trescPytania}"></c:out></td>
			</tr>
			<tr>
				<td><b>maxymalna ilość punktów</b></td>
				<td><c:out value="${lastPytanie.maxIloscPunktow}"></c:out></td>
			</tr>
			<tr>
				<td><b>poprawna odpowiedź</b></td>
				<td><c:out value="${lastPytanie.poprawnaOdpowiedz}"></c:out></td>
			</tr>
	</tbody>
</table>
<b>Błędne (mylące) odpowiedzi kóre mają zostać przypisane do ww. pytania: </b>
<table class="table table-bordered table-hover table-striped">
			<c:forEach items="${odpowiedzi_lista}" var="odp">
				<tr>
				<td>${i=i+1}</td>
					<td><c:out value="${odp.tresc}"></c:out></td>
					<td><a href="<spring:url value="/odpowiedzi-remove/${odp.tresc}.html" />" class="btn">
							Usuń
						</a></td>
				
				</tr>
			</c:forEach>
</table>


<form:form commandName="odpowiedz" cssClass="form-horizontal registrationForm">
			<c:if test="${param.success eq true}">
				<div class="alert alert-success">Zapisano błędną odpowiedź!!!</div>
			</c:if>
			<div class="form-group">
				<label for="nazwaPytania" class ="col-sm-2 control-label" >Wprowadź błędną odpowiedź </label>
				   <div class="col-sm-10">
				   		<form:input path="tresc" cssClass="form-control"/>
				   		<form:errors path="tresc"/>
				   </div>
			</div>	
			<div class="form-group">
				<label for="name" class ="col-sm-2 control-label" ></label>
				   <div class="col-sm-2">
				   		<input type="submit" value="Następna odpowiedź" class="btn btn-lg"/>
				   </div>
			</div>
</form:form>
<a href="<spring:url value="/odpowiedzi-wprowadz-save.html" />" class="btn btn-danger" >
							zapisz
						</a>
