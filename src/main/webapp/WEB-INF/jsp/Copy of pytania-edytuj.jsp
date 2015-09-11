<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="js/dynamic_list_helper.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>
<a href="<spring:url value="/pytania/remove/${pyt.pytanie_id}.html" />" class="btn btn-danger triggerRemove" data-toggle="modal" data-target="#modalRemove">
							Usuń
</a>
<form:form commandName="pytanie" cssClass="form-horizontal registrationForm" id="pytanieForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Zapisano pytanie!!!</div>
	</c:if>
	<div class="form-group">
		<label for="nazwaPytania" class ="col-sm-2 control-label" >Wprowadź nazwę pytania </label>
		   <div class="col-sm-10">
		   		<form:input path="nazwaPytania" cssClass="form-control"/>
		   		<form:errors path="nazwaPytania"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="trescPytania" class ="col-sm-2 control-label" >Wprowadź treść pytania </label>
		   <div class="col-sm-10">
		   		<form:input path="trescPytania" cssClass="form-control"/>
		   		<form:errors path="trescPytania"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="poprawnaOdpowiedz" class ="col-sm-2 control-label" >Wprowadź poprawną odpowiedź </label>
		   <div class="col-sm-10">
		   		<form:input path="poprawnaOdpowiedz" cssClass="form-control"/>
		   		<form:errors path="poprawnaOdpowiedz"/>
		   </div>
	</div>
	<div class="form-group">
		<label for="maxIloscPunktow" class ="col-sm-2 control-label">Wprowadź maksymalna ilosc punktow </label>
		   <div class="col-sm-10">
		   		<form:input path="maxIloscPunktow" cssClass="form-control"/>
		   		<form:errors path="maxIloscPunktow"/>
		   </div>
	</div>
	<c:forEach items="${pytanie.odpowiedzi}" var="odp" varStatus="loop">
		<tbody id="odpowiedziListContainer">
	        <tr class="odpowiedz">
	            <td><form:input items="${odp.tresc}" path="odpowiedzi[${loop.index}].tresc" /><td>
	            <a href="#" id="usunOdp">Usuń odpowiedz</a>&nbsp;&nbsp;
	        </tr>
	    </tbody>
    </c:forEach>
    <a href="#" id="dodajOdp">Dodaj odpowiedz</a>&nbsp;&nbsp;
    <a href="?f=">Reset List</a>

	<div class="form-group">
		<label for="name" class ="col-sm-2 control-label" ></label>
		   <div class="col-sm-2">
		   		<input type="submit" value="Wprowadz odpowiedzi" class="btn btn-lg btn-primary"/>
		   </div>
	</div>
</form:form>
<script type="text/javascript">
            function rowAdded(rowElement) {
                //clear the imput fields for the row
                $(rowElement).find("input").val('');
                //may want to reset <select> options etc
 
                //in fact you may want to submit the form
                
            }
            function rowRemoved(rowElement) {
            
                alert( "Removed Row HTML:\n" + $(rowElement).html() );
            }
 
            function saveNeeded() {
                $('#submit').css('color','red');
                $('#submit').css('font-weight','bold');
                if( $('#submit').val().indexOf('!') != 0 ) {
                    $('#submit').val( '!' + $('#submit').val() );
                }
            }
 
            function beforeSubmit() {
                alert('submitting....');
                return true;
            }
 
            $(document).ready( function() {
                var config = {
                    rowClass : 'odpowiedz',
                    addRowId : 'dodajOdp',
                    removeRowClass : 'usunOdp',
                    formId : 'pytanieForm',
                    rowContainerId : 'odpowiedziListContainer',
                    indexedPropertyName : 'odpowiedzi',
                    indexedPropertyMemberNames : 'tresc',
                    rowAddedListener : rowAdded,
                    rowRemovedListener : rowRemoved,
                    beforeSubmit : beforeSubmit
                };
                new DynamicListHelper(config);
            });
        </script>