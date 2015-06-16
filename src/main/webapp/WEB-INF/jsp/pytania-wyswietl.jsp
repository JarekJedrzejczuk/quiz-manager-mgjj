<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>
<a href="<spring:url value="/pytania-wprowadz.html" />" class="btn btn-lg btn-primary" >
							Wprowadz pytanie
</a>

<table class="table table-bordered table-hover table-striped" data-sort-name="ID" data-sort-order="desc">
	<thead>
		<tr>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
			<th>Maksymalna ilość punktów</th>
			<th>poprawna odpowiedz</th>
			<th>Informacja zwrotna</th>
			<th>Usuwanie</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pytanie}" var="pyt">
			<tr>
				<td>
					<a href="<spring:url value="/pytania/${pyt.pytanie_id}.html" />">
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
				<td>
						<a href="<spring:url value="/pytania/remove/${pyt.pytanie_id}.html" />" class="btn btn-danger triggerRemove" data-toggle="modal" data-target="#modalRemove">
							Usuń
						</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form:form commandName="pytanie" cssClass="form-horizontal registrationForm">
	<div class="form-group">
		<label for="trescPytania" class ="col-sm-2 control-label" >Wprowadź treść pytania </label>
		   <div class="col-sm-10">
		   		<form:input path="trescPytania" cssClass="form-control" value="${pytanie.trescPytania}" />
		   		<form:errors path="trescPytania"/>
		   </div>
	</div>
</form:form>

<!--  Modal  -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Usuń pytanie</h4>
      </div>
      <div class="modal-body">
        Czy na pewno chcesz usunuąć pytanie ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Nie usuwaj</button>
        <a href="" class="btn btn-danger removeBtn">Usuń</a>
      </div>
    </div>
  </div>
</div>