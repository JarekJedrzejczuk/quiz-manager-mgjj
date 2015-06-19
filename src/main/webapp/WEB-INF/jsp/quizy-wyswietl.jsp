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
<a href="<spring:url value="/quizy-wprowadz.html" />" class="btn btn-lg btn-primary" >
							Utwórz nowy quiz
						</a>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th><b>ID</b></th>
			<th><b>Nazwa quizu</b></th>
			<th><b>Losowa kolejność pytań</b></th>
			<th><b>Limit czasu</b></th>
			<th><b>Data udostępnienia testu</b></th>
			<th><b>Ostatni dzień udostępniania testu</b></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${quizyDoWyswietlenia}" var="q">
			<tr>
				<td>
					<a href="<spring:url value="/quiz/${q.quiz_id}.html" />">
						<c:out value="${q.quiz_id}" />
					</a>
				</td>
				<td>
						<c:out value="${q.nazwa}" />
				</td>
				<td>
						<c:out value="${q.losowaKolejnosc}" />
				</td>
				<td>
						<c:out value="${q.limitCzasu}" />
				</td>
				<td>
						<c:out value="${q.dostepnyOd}" />
				</td>
				<td>
						<c:out value="${q.dostepnyOd}" />
				</td>
				<td>
						<a href="<spring:url value="/quizy/remove/${q.quiz_id}.html" />" class="btn btn-danger triggerRemove" data-toggle="modal" data-target="#modalRemove">
							Usuń
						</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!--  Modal  -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Usuń quiz</h4>
      </div>
      <div class="modal-body">
        Czy na pewno chcesz usunuąć quiz ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Nie usuwaj</button>
        <a href="" class="btn btn-danger removeBtn">Usuń</a>
      </div>
    </div>
  </div>
</div>