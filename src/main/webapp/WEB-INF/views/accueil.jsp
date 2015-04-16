<%@page import="org.springframework.context.annotation.Import"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<!-- Imports CSS -->
	<link href="resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="resources/css/tittineShare.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="contenu">
		<h1 class="titreSection">${titrePage}</h1>
		<hr class="separateur">
		<c:if test="${trajetsVide != '1'}">
			<div class="action">
				<a href="trajets">
					<span> Mes trajets</span>
				</a>	
			</div>
		</c:if>

		<div class="action">
			<a href="create">
				<span>Créer un trajet</span>
			</a>
		</div>

		
	</div>
</body>
<!-- Imports JS -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="resources/js/accueil.js"></script>
</html>