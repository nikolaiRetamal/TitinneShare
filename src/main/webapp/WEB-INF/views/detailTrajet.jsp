<%@page import="org.springframework.context.annotation.Import"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<!-- Imports CSS -->
	<link href="resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<link href="resources/css/footable.core.min.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/footable.metro.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="resources/css/medimage.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="conteneurContenu">
	<div class="contenu">
		<h1 class="titreSection">Détail du trajet en tant que ${typeTrajet}</h1>
		<hr class="separateur">
		
		<div class="descriptionExamen">
		<div id="presentationExamen">
			<div class="blocPresentation">
				<hr>
				<div class="colonnePresentation">
					<span class="libelle">Ville de départ</span><br>
					<span class="attribut">${trajet.villeDepart}</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Destination</span><br>
					<span class="attribut">${trajet.villeArrivee}</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Date</span><br>
					<span class="attribut">
						${trajet.dateTrajet}
					</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Heure de départ</span><br>
					<span class="attribut">
						${trajet.departHeure}H${trajet.departMinute}
					</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Heure d'arrivée</span><br>
					<span class="attribut">
						${trajet.arriveeHeure}H${trajet.arriveeMinute}
					</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Lieu de départ</span><br>
					<span class="attribut">${trajet.lieuDepart}</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Lieu de d'arrivée</span><br>
					<span class="attribut">${trajet.lieuArrivee}</span>
				</div>
			</div>
			<div class="blocPresentation">
				<hr>
				<div class="colonnePresentation">
					<span class="libelle">Véhicule</span><br>
					<span class="attribut">
						${trajet.vehicule}
					</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Nombre de passagers</span><br>
					<span class="attribut">
						${trajet.nbPassagers}
					</span>
				</div>
				<div class="colonnePresentation">
					<span class="libelle">Nombre de bagages</span><br>
					<span class="attribut">
						${trajet.nbBagages}
					</span>
				</div>
			</div>
		</div>
		</div>
	</div>
	</div>
</body>
<!-- Imports JS -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="resources/js/footable.js" type="text/javascript"></script>
<script src="resources/js/footable.paginate.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
    $('.footable').footable();
});
</script>
</html>