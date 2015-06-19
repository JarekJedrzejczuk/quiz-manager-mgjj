<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layouts/taglib.jsp"%>
<!-- <div class="form-horizontal"> -->
<!--   <label for="t"> -->
<!--     <input type="checkbox" value="1" > -->
<!--      jakiś tam teges ten tamten -->
<!--   </label> -->
<!-- </div> -->
<%--  <td><form:checkbox path="t"></form:checkbox></td>   --%>
<form:form commandName="t" cssClass="form-horizontal">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Zapisano pytanie!!!</div>
	</c:if>
<div class="form-horizontal">
  <label for="t">
    <form:checkbox path="t" value="_3" />
  </label>
</div>

	<div class="form-group">
		<label for="t" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Wprowadz odpowiedzi" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
</form:form>

${t}