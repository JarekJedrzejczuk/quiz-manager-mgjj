<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<%@include file="../layouts/taglib.jsp"%>
<form:form commandName="quiz"
	cssClass="form-horizontal registrationForm">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label"></label>
		<div class="col-sm-2">
			<input type="submit" value="Zatwierdź"
				class="btn btn-lg btn-primary" />
		</div>
	</div>
	<div class="form-group">
		<label for="nazwa" class="col-sm-2 control-label">Nazwa quizu </label>
		<div class="col-sm-10">
			<form:input path="nazwa" cssClass="form-control" />
			<form:errors path="nazwa" />
		</div>
	</div>
	<div class="form-group">
		<label for="trescPytania" class="col-sm-2 control-label">Limit czasu w minutach </label>
		<div class="col-sm-10">
			<form:input path="limitCzasu" cssClass="form-control" />
			<form:errors path="limitCzasu" />
		</div>
	</div>
	<table class="table table-bordered table-hover table-striped" >
	<thead>
		<tr>
			<th data-sortable="true">LP</th>
			<th data-sortable="true">ID</th>
			<th data-sortable="true">nazwa pytania</th>
			<th data-sortable="true">tresc pytania</th>
			<th data-sortable="true">Zaznacz żeby usunąć</th>
		</tr>
	</thead>
	<tbody id="pytaniaListContainer">
		<c:forEach items="${quiz.pytania}" var="p" varStatus="loop">
			<tr>
				<td>${loop.index}</td>
				<td><form:input path="pytania[${loop.index}].pytanie_id"
						readonly="true" />
				<td><c:out value="${p.trescPytania}" />
				<td><c:out value="${p.poprawnaOdpowiedz}" />
				<td><input type="checkbox"
					name="pytania[${loop.index}].czyUsunac"
					id="pytania[${loop.index}].czyUsunac" />
				
			</tr>
		</c:forEach>
	</tbody>
</table>
</form:form>
</body>
</html>