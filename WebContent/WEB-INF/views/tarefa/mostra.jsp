<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
	<head>
		<link href="resources/css/jquery.css" rel="stylesheet">
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/jquery-ui.js"></script>
	</head>
	<body>
		<h3> Alterar tarefa - ${tarefa.id}</h3>
		<form action="alterarTarefa" method="post"> 
			<input type="hidden" name="id" value="${tarefa.id}" />
			
			Descrição: <br>
			<textarea name="descricao" rows="5" cols="100">${tarefa.descricao}</textarea>
			<br>
    		Finalizado? <input type="checkbox" name="finalizado" 
      				value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />      

    		Data de finalização: <br />
    		<caelum:data id="dataFinalizacao" />
		
			<input type="submit" value="Alterar"/>
		</form>
	</body>

</html>