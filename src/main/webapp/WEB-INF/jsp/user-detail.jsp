<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/taglib.jsp"%>

<a href="<spring:url value="/users/setrole/UCZESTNIK_${user.id}.html" />" class="btn btn-danger">
							ustaw role
</a>
<h1>${user.name}</h1>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr> 
 			<th>Atrybut</th> 
 			<th>Wartość</th> 
 		</tr> 
	</thead>
	<tbody>
			<tr>
				<td>
					ID: 
				</td>
				<td>
					<c:out value="${user.id} "/> 
				</td>
			</tr>
			<tr>
				<td>
					Imie: 
				</td>
				<td>
					<c:out value="${user.imie}"/>
				</td>
			</tr>
			<tr>
				<td>
					Nazwisko: 
				</td>
				<td>
					<c:out value="${user.nazwisko}"/>
				</td>
			</tr>
			<tr>
				<td>
					PESEL: 
				</td>
				<td>
					<c:out value="${user.pesel}"/>
				</td>
			</tr>
			<tr>
				<td>
					instytucja: 
				</td>
				<td>
					<c:out value="${user.instytucja}"/>
				</td>
			</tr>
			<tr> 
 				<td>rola:</td>
 				<td>
					<c:forEach items="${user.roles}" var="role">
							<c:out value="${role.name}"/>
					</c:forEach>
				</td>
 				</tr>
 			<tr>
 				<td>Wybierz role: </td>
 				<td>
						<a href="<spring:url value="/users/setrole/${user.id} ROLE_ADMIN.html" />" class="btn btn-danger">
							ADMIN
						</a>
						<a href="<spring:url value="/users/setrole/${user.id} EGZAMINATOR.html" />" class="btn btn-danger">
							EGZAMINATOR
						</a>
						<a href="<spring:url value="/users/setrole/${user.id} UCZESTNIK.html" />" class="btn btn-danger">
							UCZESTNIK
						</a>
						</td>
 			</tr>
			<tr>
				<td><a href="<spring:url value="/users/setEnable/${user.id}.html" />" class="btn btn-danger">
					Enabled
					</a>
				</td>
				<td><c:out value="${user.enabled}"/></td>
			</tr>
			<tr>
				<td>extrainfo</td>
				<td><c:out value="${user.extrainfo}"/></td>
			</tr>
	</tbody>
</table>	
<%-- <c:forEach items="${user.blogs}" var="blog"> --%>
<%-- 	<h1>${blog.name}</h1> --%>
<%-- 	<p>${blog.url}</p> --%>
<!-- 	<table class="table"> -->
<!-- 		<thead> -->
<!-- 			<tr> -->
<!-- 				<th>Title </th> -->
<!-- 				<th>Link</th> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody> -->
<%-- 			<c:forEach items="${blog.items}" var="item"> --%>
<!-- 				<tr> -->
<%-- 					<td>${item.title} </td> --%>
<%-- 					<td>${item.link}</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->
<%-- </c:forEach> --%>