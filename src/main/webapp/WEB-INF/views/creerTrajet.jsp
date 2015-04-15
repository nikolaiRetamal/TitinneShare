<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Créer un trajet</title>
	<!-- Imports CSS -->
	<link href="resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<link href="resources/datepicker/css/datepicker.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/dropzone.css">
	<link rel="stylesheet" href="resources/css/basic.css">
	<link rel="stylesheet" href="resources/css/tittineShare.css">
</head>
<body>
	<!-- Import Header -->
	<%@ include file="header.jsp" %>
	<div id="contenu" style="width:100%">
	
		<h1 class="titreSection">Mon trajet</h1>
		<hr class="separateur">
		<div>
			<form:form  modelAttribute="trajet" id="trajetform" action="/tittineShare/save"
			class="col-sm-12 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3">
				<div class="form-group">
					<label for="typeTrajet">Type de trajet</label>
					<select id="typeTrajet" name="typeTrajet">
						<c:choose>
							<c:when test="${typeTrajet=='1'}">
								<option value="0">Conducteur</option>
								<option value="1" selected="selected">Passager</option>
							</c:when>
							
							<c:otherwise>
								<option value="0" selected="selected">Conducteur</option>
								<option value="1">Passager</option>
							</c:otherwise>
						</c:choose>
					   
					   
					</select>
				</div>
				<div class="form-group">
					<label for="villeDepart">Départ</label>
					<input type="text" class="form-control" id="villeDepart" name="villeDepart" 
					placeholder="Entrez une ville de départ" value="${trajet.villeDepart}">
				</div>
				<div class="form-group">
					<label for="villeArrivee">Arrivée</label>
					<input type="text" class="form-control" id="villeArrivee" name="villeArrivee" 
					placeholder="Entrez une ville d'arrivé" value="${trajet.villeArrivee}">
				</div>
				<div class="form-group">
					<label for="departMinute">Heure de départ</label>
					<select id="departHeure" name="departHeure" >
					   <c:forEach var="i" begin="0" end="24">
						<c:choose>
							<c:when test="${trajet.departHeure==i}">
								<option value="${i}" selected="selected">${i}</option>
							</c:when>
							
							<c:otherwise>
								<option value="${i}">${i}</option>
							</c:otherwise>
						</c:choose>					   
			          </c:forEach>
					</select>
					<span>H</span>
					<select id="departMinute" name="departMinute">
					  <c:forEach var="i" begin="0" end="45" step="15">
						<c:choose>
							<c:when test="${trajet.departMinute==i}">
								<option value="${i}" selected="selected">${i}</option>
							</c:when>
							
							<c:otherwise>
								<option value="${i}">${i}</option>
							</c:otherwise>
						</c:choose>					   
			          </c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="arriveeHeure">Heure d'arrivée</label>
					<select id="arriveeHeure" name="arriveeHeure">
					   <c:forEach var="i" begin="0" end="24">
						<c:choose>
							<c:when test="${trajet.arriveeHeure==i}">
								<option value="${i}" selected="selected">${i}</option>
							</c:when>
							
							<c:otherwise>
								<option value="${i}">${i}</option>
							</c:otherwise>
						</c:choose>					   
			          </c:forEach>
					</select>
					<span>H</span>
					<select id="arriveeMinute" name="arriveeMinute">
					
					  <c:forEach var="i" begin="0" end="45" step="15">
						<c:choose>
							<c:when test="${trajet.arriveeMinute==i}">
								<option value="${i}" selected="selected">${i}</option>
							</c:when>
							
							<c:otherwise>
								<option value="${i}">${i}</option>
							</c:otherwise>
						</c:choose>					   
			          </c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="dateTrajet">Date</label>
					<input type="text" class="form-control" id="dateTrajet" name="dateTrajet" 
					placeholder="Veuillez saisir une date" value="${trajet.dateTrajet}">
				</div>
				<div class="form-group conducteur">
					<label for="vehicule">Véhicule</label>
					<input type="text" class="form-control" id="vehicule" name="vehicule" 
					placeholder="Entrez le type du véhicule" value="${trajet.vehicule}">
				</div>
				<div class="form-group conducteur">
					<label for="description">Description du trajet</label>
					<input type="text" class="form-control" id="description" name="description" 
					placeholder="Entrez une description sur le trajet" value="${trajet.description}">
				</div>		
				<div class="form-group conducteur">
					<label for="nbPassagers">Nombre de passagers</label>
					<select class="form-control" id="nbPassagers" name="nbPassagers">
					   <c:forEach var="i" begin="0" end="6">
						<c:choose>
							<c:when test="${trajet.nbPassagers==i}">
								<option value="${i}" selected="selected">${i}</option>
							</c:when>
							
							<c:otherwise>
								<option value="${i}">${i}</option>
							</c:otherwise>
						</c:choose>					   
			          </c:forEach>
					</select>
				</div>
				<div class="form-group passager">
					<label for="nbBagages">Nombre de bagages</label>
					<select class="form-control" id="nbBagages" name="nbBagages">
					   <c:forEach var="i" begin="0" end="3">
						<c:choose>
							<c:when test="${trajet.nbBagages==i}">
								<option value="${i}" selected="selected">${i}</option>
							</c:when>
							
							<c:otherwise>
								<option value="${i}">${i}</option>
							</c:otherwise>
						</c:choose>					   
			          </c:forEach>
					</select>
				</div>					
				<div class="form-group conducteur">
					<label for="lieuDepart">Lieu de rendez-vous (Départ et arrivée)</label>
					<input type="text" class="form-control" id="lieuDepart" name="lieuDepart" 
					placeholder="Entrez une description du lieu de départ" value="${trajet.lieuDepart}">
					<br>
					<input type="text" class="form-control" id="lieuArrivee" name="lieuArrivee" 
					placeholder="Entrez une description du lieu d'arrivée" value="${trajet.lieuArrivee}">
				</div>			
				<button type="submit" class="btn btn-default">Envoyer</button>
			</form:form>
		</div>
	</div>

</body>

<!-- Imports JS -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="resources/datepicker/js/bootstrap-datepicker.js"></script>
<script src="resources/datepicker/js/locales/bootstrap-datepicker.fr.js"></script>
<script type="text/javascript">
	$(function() {
		//Plugin pour choix de la date
		$('#dateTrajet').datepicker({
			format: 'dd-mm-yyyy',
			language: 'fr-FR'
		});
		//Event listener pour gérer les types de trajets
		$( "#typeTrajet" ).change(function() {
			
			 if($( this ).val() == 1){
				 $(".conducteur").hide();
				 $(".passager").show();
			 }else{
				 $(".conducteur").show();
				 $(".passager").hide();
			 } 
			});
		 //Par défaut on crée un trajet conducteur
		 $(".passager").hide();

	});

</script>
</html>