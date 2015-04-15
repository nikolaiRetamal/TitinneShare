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
					   <option value="0">Conducteur</option>
					   <option value="1">Passager</option>
					</select>
				</div>
				<div class="form-group">
					<label for="villeDepart">Départ</label>
					<input type="text" class="form-control" id="villeDepart" name="villeDepart" placeholder="Entrez une ville de départ">
				</div>
				<div class="form-group">
					<label for="villeArrivee">Arrivé</label>
					<input type="text" class="form-control" id="villeArrivee" name="villeArrivee" placeholder="Entrez une ville d'arrivé">
				</div>
				<div class="form-group">
					<label for="departMinute">Heure de départ</label>
					<select id="departHeure" name="departHeure">
					<% for(int i =0; i<25;i++){ %>
					   <option value="<%=i%>"><%=i %></option>
					   <%} %>
					</select>
					<span>H</span>
					<select id="departMinute" name="departMinute">
					   <option value="0">0</option>
					   <option value="15">15</option>
					   <option value="30">30</option>
					   <option value="45">45</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="arriveeHeure">Heure d'arrivée</label>
					<select id="arriveeHeure" name="arriveeHeure">
					<% for(int i =0; i<25;i++){ %>
					   <option value="<%=i%>"><%=i %></option>
					   <%} %>
					</select>
					<span>H</span>
					<select id="arriveeMinute" name="arriveeMinute">
					   <option value="0">0</option>
					   <option value="15">15</option>
					   <option value="30">30</option>
					   <option value="45">45</option>
					</select>
				</div>
				<div class="form-group">
					<label for="dateTrajet">Date</label>
					<input type="text" class="form-control" id="dateTrajet" name="dateTrajet" placeholder="Veuillez saisir une date">
				</div>
				<div class="form-group conducteur">
					<label for="vehicule">Véhicule</label>
					<input type="text" class="form-control" id="vehicule" name="vehicule" placeholder="Entrez le type du véhicule">
				</div>
				<div class="form-group conducteur">
					<label for="description">Description du trajet</label>
					<input type="text" class="form-control" id="description" name="description" 
					placeholder="Entrez une description sur le trajet">
				</div>		
				<div class="form-group conducteur">
					<label for="nbPassagers">Nombre de passagers</label>
					<select class="form-control" id="nbPassagers" name="nbPassagers">
					<% for(int i =1; i<6;i++){ %>
					   <option value="<%=i%>"><%=i %></option>
					   <%} %>
					</select>
				</div>
				<div class="form-group passager">
					<label for="nbBagages">Nombre de bagages</label>
					<select class="form-control" id="nbBagages" name="nbBagages">
					<% for(int i =1; i<3;i++){ %>
					   <option value="<%=i%>"><%=i %></option>
					   <%} %>
					</select>
				</div>					
				<div class="form-group conducteur">
					<label for="lieuDepart">Lieu de rendez-vous (Départ et arrivée)</label>
					<input type="text" class="form-control" id="lieuDepart" name="lieuDepart" 
					placeholder="Entrez une description du lieu de départ">
					<br>
					<input type="text" class="form-control" id="lieuArrivee" name="lieuArrivee" 
					placeholder="Entrez une description du lieu d'arrivée">
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
		$('#dateDepart').datepicker({
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