<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layouts/taglib.jsp"%>

<style>
body, html {
  margin: 0;
  overflow: auto;
  height:100%;
}

@media (min-width: 1024px){
	#center {
    position: relative;
    top: 0px;
    bottom: 0;
    left: 0;
    width: 100%;
    overflow-y: hide; 
  }
  #left {
    position:     absolute;
    top: 0px;
    bottom: 0;
    left: 0;
    width: 25%;
    overflow: hidden; 
  }
  
  #right {
    position: absolute;
    top: 0px;
    bottom: 0;
    right: 0;
    overflow-y: scroll;
    width: 75%;
  }
}

#left {
  text-align: center;
  height:100%;
}
#center {
  text-align: center;
}
#right {
  height:100%;
  text-align: center;
}
.container{
  height: 75%;
  width: 100%;
  position: relative;
}
.theadUnscroll{
	position: relative;
	left: 0;
	top: 0;
	bottom: 0;
	height:10%;
	
	overflow-x: hidden;
}
.tbodyScroll{
	position: absolute;
    height:90%;
    
    overflow-x: scroll;
}
</style>
<a href="<spring:url value="/test/4.html" />" class="btn btn-danger" >
							Zapisz pytanie w bazie danych
						</a>
						
<form:form  >
	<input type="submit" value="Zapisz zmiany" class="btn btn-sm btn-primary" />
	</form:form>


<div id="center">						 
	<table class="table table-bordered table-hover table-striped"  >
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
				<tr>
					<td>
							<c:out value="${quiz.nazwa}" />
					</td>
					<td>
							<c:out value="${quiz.losowaKolejnosc}" />
					</td>
					<td>
							<c:out value="${quiz.limitCzasu}" />
					</td>
					<td>
							<c:out value="${quiz.dostepnyOd}" />
					</td>
					<td>
							<c:out value="${quiz.dostepnyOd}" />
					</td>
				</tr>
		</tbody>
	</table>
</div>
<div class="container ">
<div id="left"> 
        
          <b>
            Wybrane pytania do quizu
          </b>
        
     
	<table class="table table-bordered table-hover table-striped" >
	<thead class="theadUnscroll">
		<tr>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
		</tr>
	</thead>
	<tbody class="tbodyScroll">
		<c:forEach items="${pytania}" var="pyt">
			<tr>
				<td>
					<a href="<spring:url value="/quiz-deselect-pytanie/${pyt.pytanie_id}.html" />">
						<c:out value="${pyt.pytanie_id}" />
					</a>
				</td>
				<td>
						<c:out value="${pyt.nazwaPytania}" />
				</td>
				<td>
						<c:out value="${pyt.trescPytania}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>

<div id="right">
          <b>
			Wybierz pytania do które mają być zadane kursantom w trakcie quizu
			</b>
		


	<table class="table table-bordered table-hover table-striped" >
	<thead>
		<tr>
			<th>ID</th>
			<th>nazwa pytania</th>
			<th>tresc pytania</th>
			<th>Maksymalna ilość punktów</th>
			<th>poprawna odpowiedz</th>
			<th>Informacja zwrotna</th>
		</tr>
	</thead>
	<tbody >
		<c:forEach items="${quiz.pytania}" var="pyt" varStatus="i">
			
				<tr>
					<td>
						<a href="<spring:url value="/quiz-select-pytanie/${pyt.pytanie_id}.html" />">
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
							<input type="checkbox" name="pyt.czyUsunac"/>
					</td>
				</tr>
		
		</c:forEach>
	</tbody>
</table>
</div>
</div>