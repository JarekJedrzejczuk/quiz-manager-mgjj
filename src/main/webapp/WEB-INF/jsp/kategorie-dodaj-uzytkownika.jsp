<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layouts/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th><b>ID</b></th>
			<th><b>Nazwa quizu</b></th>
			<th><b>Losowa kolejność pytań</b></th>
			<th><b>Limit czasu</b></th>
			<th><b>Data udostępnienia testu</b></th>
			<th><b>Ostatni dzień udostępniania testu</b></th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>
						<c:out value="${quiz.quiz_id}" />
				</td>
				<td>
						<c:out value="${quiz.nazwa}" />
				</td>
				<td>
						<c:out value="${quiz.losowaKolejnosc}" />
				</td>
				<td>
						<c:out value="${quiz.limitCzasu}" />
				</td>
				<td>
						<c:out value="${quiz.dostepnyOd}" />
				</td>
				<td>
						<c:out value="${quiz.dostepnyOd}" />
				</td>
			</tr>
	</tbody>
</table>
	

	<b>Wybrani użytkownicy</b>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>login</th>
			<th>imie i nazwisko</th>
			<th>PESEL</th>
			<th>instytucja</th>
			<th>zaznacz</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users_lista}" var="u">
			<tr>
				<td>
					<a href="<spring:url value="/kategorie-deselect-user/${u.id}.html" />">
						<c:out value="${u.id}" />
					</a>
				</td>
				<td>
						<c:out value="${u.name}" /> 
				</td>
				<td>
						<c:out value="${u.imie}" /> 
						<c:out value="${u.nazwisko}" />
				</td>
				
				<td>
						<c:out value="${u.pesel}" />
				</td>
				<td>
						<c:out value="${u.instytucja}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<b>Wybierz quiz</b>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th><b>ID</b></th>
			<th><b>Nazwa quizu</b></th>
			<th><b>Losowa kolejność pytań</b></th>
			<th><b>Limit czasu</b></th>
			<th><b>Data udostępnienia testu</b></th>
			<th><b>Ostatni dzień udostępniania testu</b></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${quizy}" var="q">
				<tr>
					<td>
						<a href="<spring:url value="/kategoria-select-quiz/${q.quiz_id}.html" />">
							<c:out value="${q.quiz_id}" />
						</a>
					</td>
					<td>
						<c:out value="${q.nazwa}" />
				</td>
				<td>
						<c:out value="${q.losowaKolejnosc}" />
				</td>
				<td>
						<c:out value="${q.limitCzasu}" />
				</td>
				<td>
						<c:out value="${q.dostepnyOd}" />
				</td>
				<td>
						<c:out value="${q.dostepnyOd}" />
				</tr>
		</c:forEach>
	</tbody>
</table>
<b>Wybierz quiz</b>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>ID</th>
				<th>login</th>
				<th>imie i nazwisko</th>
				<th>PESEL</th>
				<th>instytucja</th>
			</tr>
	</thead>
	<tbody>
		<c:forEach items="${uzytkownicy}" var="user">
			<tr>
				<td>
					<a href="<spring:url value="/kategoria-select-uzytkownik/${user.id}.html" />">
						<c:out value="${user.id}" />
					</a>
				</td>
				<td>
						<c:out value="${user.name}" /> 
				</td>
				<td>
						<c:out value="${user.imie}" /> 
						<c:out value="${user.nazwisko}" />
				</td>
				
				<td>
						<c:out value="${user.pesel}" />
				</td>
				<td>
						<c:out value="${user.instytucja}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="<spring:url value="/kategoria-save.html" />" class="btn btn-danger" >
							Zapisz kategorię w bazie danych
						</a>
	
