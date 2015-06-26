<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layouts/taglib.jsp"%>
<% int j=0; %>
<form:form commandName="Tresc" cssClass="form-horizontal registrationForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Zapisano odpowiedzi</div>
	</c:if>
	
	<table class="table table-bordered table-hover table-striped">
		<thead></thead>
	<tbody>
		<c:forEach items="${Tresc.pytaniaTestowe}" var="p" varStatus="i">
			<% j=j+1; %>
			<b><tr>Pytanie nr <c:out value="${j}"/>.: <c:out value="${p.tresc}"/></tr></b>
				<c:forEach items="${p.odpowiedzi}" var="o" >
					<div class="form-group">
						<label for="pytaniaTestowe[${i.index}]" class ="col-sm-2 control-label" ></label>
							<div class="col-sm-10">
									<form:radiobutton path="pytaniaTestowe[${i.index}].udzielonaOdpowiedz" value="${o}"/><c:out value="${o}"/>
							</div>
					</div>
				</c:forEach>				
			<tr></tr>
		</c:forEach>
	</tbody>
	</table>	
	
	<div class="form-group">
		<label for="Tresc" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Zakończ test" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
</form:form>




	