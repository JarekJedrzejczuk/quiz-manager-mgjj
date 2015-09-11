<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layouts/taglib.jsp"%>

<form:form commandName="kategoria" cssClass="form-horizontal registrationForm" id="kategoria" >
	<div class="form-group" hidden="true">
		<label for="kategoria_id" class="col-sm-2 control-label">id</label>
		<div class="col-sm-10">
			<form:input path="kategoria_id" cssClass="form-control" readonly="true" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Zapisz zmiany"	class="btn btn-sm btn-primary" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<label for="nazwa"><b>Nazwa Quizu: </b></label>
			<form:input path="nazwa"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<label for="opis"><b>Opis: </b></label>
			<form:input path="opis"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<label for="quiz.quiz_id"><b>Wybierz quiz: </b></label>
		    <select id="quiz.quiz_id" required="required" name="quiz.quiz_id">
				<option value="quiz.quiz_id" selected="selected">${kategoria.quiz.nazwa}</option>
				<c:forEach items="${quizyWszystkie}" var="q" varStatus="loop">
					<option value="${q.quiz_id}">${q.nazwa}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<b>Wybierz quiz</b>
					<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>ID</th>
								<th>login</th>
								<th>imie i nazwisko</th>
								<th>PESEL</th>
								<th>instytucja</th>
								<th>Przypisać?</th>
							</tr>
					</thead>
					<tbody>
						<c:forEach items="${kategoria.users}" var="user" varStatus="loop">
							<tr>
								<td>
										<c:out value="${user.id}" />
											<div class="form-group" hidden="true">
												<label for="users[${loop.index}].id" class="col-sm-2 control-label">id</label>
												<div class="col-sm-10">
													<form:input path="users[${loop.index}].id" cssClass="form-control"
														readonly="true" />
												</div>
											</div>
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
								<td>
									<form:checkbox path="users[${loop.index}].czyZaznaczony" />
								</td>
<%-- 								<td><input type="checkbox" name="users[${loop.index}].czyZaznaczony" placeholder="${user.czyZaznaczony}"  /> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</form:form>

