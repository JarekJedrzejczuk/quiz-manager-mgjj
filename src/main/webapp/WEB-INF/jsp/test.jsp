<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layouts/taglib.jsp"%>
	<form:form commandName="pytanie" cssClass="form-horizontal registrationForm" id="pytanieForm">
	<table>
	<c:forEach items="${quiz.pytania}" var="p" varStatus="loop" >
		<tbody id="pytaniaListContainer">
	        <tr class="odpowiedz">
<%-- 	            <td><form:checkbox items="${p.czyUsunac}" path="pytania[${loop.index}].czyUsunac" /><td> --%>
	            <td><input type="checkbox" name="pytania[${loop.index}].czyUsunac" id="pytania[${loop.index}].czyUsunac" /><td>
	        </tr>
	    </tbody>
    </c:forEach>
    </table>

	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Wprowadz odpowiedzi" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
</form:form>