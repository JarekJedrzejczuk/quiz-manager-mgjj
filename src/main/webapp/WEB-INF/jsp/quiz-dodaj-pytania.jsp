<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layouts/taglib.jsp"%>
<form:form commandName="quiz" cssClass="form-horizontal registrationForm" id="quizForm" >
	<div class="form-group">
		<label for="name1" class="col-sm-2 control-label"></label>
		<div class="col-sm-2">
			<input type="submit" formaction="/quiz-dodaj-pytania/${quiz.quiz_id}.html" value="Zatwierdź i dodaj do pytania" class="btn btn-sm btn-primary" formmethod="post" />
		</div>
	</div>
<%@include file="../layouts/pytania-z-checkboxem.jsp"%>
</form:form>
