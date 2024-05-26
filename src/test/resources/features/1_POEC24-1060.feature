
Feature: Authentification




	@POEC24-1060
	Scenario: Authentification 
		Given je me connecte sur l'application
		    When je saisis le login "standard_user"
		    And je saisis le password "secret_sau"
		    And je clique sur le bouton login
		    Then je me redirige vers la page d'accueil s'affiche
		
