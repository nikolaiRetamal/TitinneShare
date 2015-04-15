	<div id="header" class="">
		<div class="gauche">
			<ul class="menu">
				<li class="import">
					<a href="accueil">
						<img alt="importer" src="resources/images/logo.png" id="logo">
						
					</a>
					
				</li>
				<li class="helper">
					
					<span id="titre" >
						Tittine Share	
					</span>
					<br>
					<span>
						c'est moins cher quand c'est les autres qui payent
					</span>

				</li>
			</ul> 
		</div>
		<div class="droite">
			<ul class="menu">
					<li class="etatConnexion">
					<c:choose>
						<c:when test="${empty utilisateur}">
							<span class="connexion">
								<a href="connexion">
									<img alt="connexion" src="resources/images/connexion.png">
									Connexion
								</a>
							</span>
						</c:when>
						<c:otherwise>
							<span class="deconnexion">
								<a href="deconnexion">
									<img alt="deconnexion" src="resources/images/deconnexion.png">
									Déconnexion
								</a>
							</span>
						</c:otherwise>
					</c:choose>
				</li>  
			</ul>
		</div>
	</div>