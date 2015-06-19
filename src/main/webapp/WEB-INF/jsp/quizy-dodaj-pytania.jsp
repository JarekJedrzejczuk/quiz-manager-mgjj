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
	

	<b>Wybrane pytania do quizu</b>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
			<th>Maksymalna ilość punktów</th>
			<th>poprawna odpowiedz</th>
			<th>Informacja zwrotna</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pytania_lista}" var="pyt">
			<tr>
				<td>
					<a href="<spring:url value="/quiz-deselect-pytanie/${pyt.pytanie_id}.html" />">
						<c:out value="${pyt.pytanie_id}" />
					</a>
				</td>
				<td>
						<c:out value="${pyt.nazwaPytania}" />
				</td>
				<td>
						<c:out value="${pyt.trescPytania}" />
				</td>
				
				<td>
						<c:out value="${pyt.maxIloscPunktow}" />
				</td>
				<td>
						<c:out value="${pyt.poprawnaOdpowiedz}" />
				</td>
				<td>
						<c:out value="${pyt.informacjaZwrotna}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<b>Wybierz pytania do które mają być zadane kursantom w trakcie quizu</b>
	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
			<th>Maksymalna ilość punktów</th>
			<th>poprawna odpowiedz</th>
			<th>Informacja zwrotna</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pytanie}" var="pyt">
			
				<tr>
					<td>
						<a href="<spring:url value="/quiz-select-pytanie/${pyt.pytanie_id}.html" />">
							<c:out value="${pyt.pytanie_id}" />
						</a>
					</td>
					<td>
							<c:out value="${pyt.nazwaPytania}" />
					</td>
					<td>
							<c:out value="${pyt.trescPytania}" />
					</td>
					<td>
							<c:out value="${pyt.maxIloscPunktow}" />
					</td>
					<td>
							<c:out value="${pyt.poprawnaOdpowiedz}" />
					</td>
					<td>
							<c:out value="${pyt.informacjaZwrotna}" />
					</td>
				</tr>
		</c:forEach>
	</tbody>
</table>
<a href="<spring:url value="/quiz-save.html" />" class="btn btn-danger" data-toggle="modal" data-target="#modalRemove">
							Zapisz pytanie w bazie danych
						</a>
	
