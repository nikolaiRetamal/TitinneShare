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
	<link rel="stylesheet" href="resources/css/identification.css">
</head>
<body>

	<div id="login">

		<h2>
			<span class="lock">
				<img alt="verrou" src="resources/images/lock.png">
			</span>
			${titrePage}
		</h2>
		<c:when test="${not empty message}">
			<h2 style="font-size: medium ;text-align: center;">
			<span class="lock">
				<img alt="attention" src="resources/images/caution.png">
			</span>
			${message}
			</h2>
		</c:when>
		<form action="/tittineShare/connexion" method="POST">

			<fieldset>

				<p>
					<label for="user">Nom d'utilisateur</label>
				</p>
				<p>
					<input type="text" id="nom" name="nom"
					placeholder="Nom">
				</p> <p>
					<label for="user">Prénom</label>
				</p>
				<p>
					<input type="text" id="prenom" name="prenom"
					placeholder="Prenom">
				</p> 
				<br/>
				<p>
					<input type="submit" value="Valider">
				</p>

			</fieldset>

		</form>

	</div> <!-- end login -->

</body>	
</html>

</body>

</html>