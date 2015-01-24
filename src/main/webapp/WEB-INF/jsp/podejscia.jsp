<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

<c:out value="${user.nazwisko}" /> 
<c:out value="${user.imie}" />

<b>Dotychczasowe podejścia</b>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Data wykonania</th>
			<th>Nazwa Quizu</th>
			<th>Wynik</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.podejscia}" var="p">
			<tr>
				<td>
						<c:out value="${p.data_wykonania}" />
				</td>
				<td>
						<c:out value="${p.quiz.nazwa}" />
				</td>
				<td>
						<c:out value="${p.wynik}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<b>Wykonaj Quiz</b>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Nazwa Quizu</th>
			<th>Limit czasu</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${quizy}" var="q" varStatus="i">
			<tr>
				<td>
					<a href="<spring:url value="/podejscie-wykonaj/${i.index}.html" />" class="btn">
						<c:out value="${q.nazwa}" />
						
					</a>
				</td>
				<td>
						<c:out value="${q.limitCzasu}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>