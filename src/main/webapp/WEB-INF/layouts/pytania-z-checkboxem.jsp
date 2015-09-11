<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@include file="../layouts/taglib.jsp"%> --%>

<table class="table table-bordered table-hover table-striped " data-toggle="table" data-cache="false" data-height="50">
	<thead>
		<tr>
			<th data-sortable="true">ID</th>
			<th data-sortable="true">nazwa pytania</th>
			<th data-sortable="true">tresc pytania</th>
			<th data-sortable="true">Zaznacz żeby usunąć</th>
		</tr>
	</thead>
	<tbody id="pytaniaListContainer">
		<c:forEach items="${quiz.pytania}" var="p" varStatus="loop">
			<tr>
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