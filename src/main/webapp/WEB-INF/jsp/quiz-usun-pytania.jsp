<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layouts/taglib.jsp"%>
	<form:form commandName="quiz" cssClass="form-horizontal registrationForm" id="pytanieForm">
			<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Wprowadz odpowiedzi" class="btn btn-lg btn-primary"
		   			formaction="/quiz-usun-pytania.html"/>
		   </div>
	</div>
		<table class="table table-bordered table-hover table-striped" >
	<thead>
		<tr>
			<th class ="col-sm-2"><label for="quiz_id" class ="col-sm-2 control-label" >ID</label></th>
			<th><label for="nazwa" class ="col-sm-2 control-label" >Nazwa quizu </label></th>
		</tr>
	</thead>
	<tbody>
		<tr>
		   	<td class ="col-sm-2"><form:input path="quiz_id" cssClass="form-control" readonly="true"/></td>
		   	<td><form:input path="nazwa" cssClass="form-control" readonly="true"/></td>
		</tr>
	</tbody>
	</table>
	<table class="table table-bordered table-hover table-striped" >
	<thead>
		<tr>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
			<th>Zaznacz żeby usunąć</th>
		</tr>
	</thead>
		<tbody id="pytaniaListContainer">
		<c:forEach items="${quiz.pytania}" var="p" varStatus="loop" >		
		        <tr>
		            <td><form:input path="pytania[${loop.index}].pytanie_id"  readonly="true"/>
		            <td><c:out value="${p.trescPytania}" />
		            <td><c:out value="${p.poprawnaOdpowiedz}"/>
		            <td><input type="checkbox" name="pytania[${loop.index}].czyUsunac" id="pytania[${loop.index}].czyUsunac" />
		            <td>${loop.index}</td>
		        </tr>	    
	    </c:forEach>
	</tbody>
    </table>
</form:form>