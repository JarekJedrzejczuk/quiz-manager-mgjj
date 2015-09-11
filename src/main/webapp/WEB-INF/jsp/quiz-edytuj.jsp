<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  --%>
<%--     prefix="fn" %>  --%>
<!--   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<!-- <script type="text/javascript" -->
<!-- 	src="http://code.jquery.com/jquery-2.1.4.min.js"></script> -->
<!-- <script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script> -->

<form:form commandName="quiz" cssClass="form-horizontal registrationForm" id="quizForm" >
	<div class="form-group">
		<label for="quiz_id" class ="col-sm-2 control-label" >id</label>
		   <div class="col-sm-10">
		   		<form:input path="quiz_id" cssClass="form-control" readonly="true"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="nazwa" class ="col-sm-2 control-label" >Nazwa quizu </label>
		   <div class="col-sm-10">
		   		<form:input path="nazwa" cssClass="form-control"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="nazwa" class ="col-sm-2 control-label" >Losowa kolejność </label>
		   <div class="col-sm-10">
		   		<form:checkbox path="losowaKolejnosc" />
		   </div>
	</div>
	<div class="form-group">
		<label for="limitCzasu" class ="col-sm-2 control-label" >Limit czasu w minutach</label>
		   <div class="col-sm-10">
		   		<form:input path="limitCzasu" cssClass="form-control"/>
		   		<form:errors path="limitCzasu"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="dostepnyOd" class ="col-sm-2 control-label" >Dostępny od </label>
		   <div class="col-sm-10">
		   		<input  name="dataOd" value="${quiz.dostepnyOd}"  min="2015-08-01"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="dostepnyDo" class ="col-sm-2 control-label">Dostępny do </label>
		   <div class="col-sm-10">
		   		<input name="dataDo" value="${quiz.dostepnyDo}" min="2015-08-01" />
		   </div>
	</div>
	<div class="form-group">
		<label for="name1" class="col-sm-2 control-label"></label>
		<div class="col-sm-2">
			<input type="submit" formaction="/quiz-dodaj-pytania.html" value="Zatwierdź i dodaj do pytania" class="btn btn-sm btn-primary" formmethod="post" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label"></label>
		<div class="col-sm-2">
			<input type="submit" value="Zapisz zmiany" class="btn btn-sm btn-primary" />
		</div>
	</div>
	<table class="table table-bordered table-hover table-striped" >
	<thead>
		<tr>
			<th>Lp</th>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
			<th>Zaznacz żeby usunąć</th>
		</tr>
	</thead>
		<tbody id="pytaniaListContainer">
		<c:forEach items="${quiz.pytania}" var="p" varStatus="loop" >		
		        <tr>
		        	<td>${loop.index}</td>
		            <td><form:input path="pytania[${loop.index}].pytanie_id"  readonly="true"/>
		            <td><c:out value="${p.trescPytania}" />
		            <td><c:out value="${p.poprawnaOdpowiedz}"/>
		            <td><input type="checkbox" name="pytania[${loop.index}].czyUsunac" id="pytania[${loop.index}].czyUsunac" />
		            
		        </tr>	    
	    </c:forEach>
	</tbody>
    </table>
</form:form>
</body>
</html>
